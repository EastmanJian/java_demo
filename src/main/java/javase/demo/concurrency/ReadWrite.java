package javase.demo.concurrency;


import java.io.*;

/**
 * Requirement
 * 1) there will be concurrent multiple access to the write() and read() method
 * 2) ensure the write() operations will not be overlapped with each other
 * 3) read() should not read intermediate data
 * 4) to consider the performance, allow multi threads to read concurrently.
 *
 * Below is one of the implementation using basic Java multithread programming
 */
public class ReadWrite {
    public static File file = new File ("c:\\temp\\ConcurrentReadWrite.txt");
    private static ReadWrite singleton;
    private static String cache;
    private ReadWrite() {

    }

    public static synchronized ReadWrite getInstance() {
        if (singleton==null) {
            singleton = new ReadWrite();
        }
        return singleton;
    }

    public void write (String[] data) throws IOException, InterruptedException {
        synchronized (this) {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < data.length; i++) {
                bw.write(data[i]);
                bw.flush();
                Thread.sleep(100); //add delay to amplify the concurrency issue
            }
            bw.close();
            fw.close();

            //update cache
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            cache = br.readLine();
            br.close();
            fr.close();
        }
    }

    public String read() throws IOException, InterruptedException {
        if (cache !=null ) return cache;
        String line;
        synchronized (this) {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            br.close();
            fr.close();
        }
        return line;
    }
}
