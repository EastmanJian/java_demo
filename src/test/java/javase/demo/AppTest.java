package javase.demo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        System.out.println("hello");
        assertTrue( true );
        String a = "abc";
        String b = "def";
        swap(a ,b);
        System.out.println("a=" + a + ", b=" + b);

    }

    private void swap(String x, String y)
    {
        String tmp=y;
        y=x;
        x=tmp;
    }
}
