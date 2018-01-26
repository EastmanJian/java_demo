package javase.demo.concurrency;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

public class ReadWriteTest {
    @Test
    public void testConcurreny() throws Exception {
        //clean up the file
        FileWriter fw = new FileWriter(ReadWrite.file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.close();
        fw.close();

        //simulate multiple concurrent accesses
        String[] data1 = {"1", "2", "3", "4", "5"};
        String[] data2 = {"a", "b", "c", "d", "e"};
        Thread[] t = new Thread[100];
        for (int i=0; i<25; i++) {
            t[i*4] = new Thread(new DataWriter(data1));
            t[i*4].start();

            t[i*4 + 1] = new Thread(new DataWriter(data2));
            t[i*4 + 1].start();

            t[i*4 + 2] = new Thread(new DataReader());
            t[i*4 + 2].start();

            t[i*4 + 3] = new Thread(new DataReader());
            t[i*4 + 3].start();
        }
        for (int i=0; i<100; i++) {
            t[i].join();
        }
    }

    private class DataWriter implements Runnable{
        private String[] data;
        public DataWriter (String[] data) {
            this.data = data;
        }

        @Override
        public void run() {
            ReadWrite rw = ReadWrite.getInstance();
            try {
                rw.write(data);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private class DataReader implements Runnable{

        @Override
        public void run() {
            ReadWrite rw = ReadWrite.getInstance();
            try {
                long delay = (long)(Math.random()*25000);
                Thread.sleep(delay); //add delay to make the read between the writes
                String line = rw.read();
                System.out.println("thread:" + Thread.currentThread().getName() + ", data=" + line);
                Thread.sleep(1000);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}