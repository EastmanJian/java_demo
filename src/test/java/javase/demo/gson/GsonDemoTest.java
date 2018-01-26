package javase.demo.gson;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jiany on 2017-12-15.
 */
public class GsonDemoTest {
    @Test
    public void objToJson() throws Exception {
        GsonDemo demo = new GsonDemo();
        demo.objToJson();
    }

    @Test
    public void jsonToObj() throws Exception {
        GsonDemo demo = new GsonDemo();
        demo.jsonToObj();
    }


}