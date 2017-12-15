package javase.demo.peroperties;

import org.junit.Test;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {
    @Test
    public void testReadPropertiesFile() throws IOException {
        Properties pps = new Properties();

        //get the properties file InputStream (way 1)
        //InputStream in = getClass().getResourceAsStream("/test.properties");

        //get the properties file InputStream (way 2).
        String absolutePath = getClass().getResource("/").getPath();
        InputStream in = new BufferedInputStream(new FileInputStream(absolutePath + File.separator + "test.properties"));

        //load the properties file
        pps.load(in);

        System.out.println("absolutePath=" + absolutePath);

        //list the properties (way 1)
        pps.list(System.out);

        //list the properties (way 2)
        Enumeration en = pps.propertyNames();
        while (en.hasMoreElements()) {
            String strKey = (String) en.nextElement();
            String strValue = pps.getProperty(strKey);
            System.out.println(strKey + "=" + strValue);
        }

    }
}
