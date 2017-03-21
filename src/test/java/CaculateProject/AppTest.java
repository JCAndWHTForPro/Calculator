package CaculateProject;

import org.junit.Assert;
import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testGetResult(){
        App app = new App();
        Assert.assertEquals("false",app.getResult("{} or 4+(2*4)-4*5+9-8/4*(3+6) and 3-9*7 and 6-9/34*7 and 0"  ).toString());
    }
    @Test
    public void testMoreSpace(){
        App app = new App();
        Assert.assertEquals("false",app.getResult("{}  or  0"  ).toString());
    }
    @Test
    public void testLargeData(){
        App app = new App();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            app.getResult("{} or 4+(2*4)-4*5+9-8/4*(3+6) and 3-9*7 and 6-9/34*7 and 0"  );
        }
        long end = System.currentTimeMillis();
        System.out.println("All time is : "+(end-start)/1000);
    }
    @Test
    public void testJsLargeDataExpression() throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            nashorn.eval("function test(){return 0 || 4+(2*4)-4*5+9-8/4*(3+6) && 3-9*7 && 6-9/34*7 && true;}");
            Object result = nashorn.eval("test()");
        }
        long end = System.currentTimeMillis();
        System.out.println("All time is : "+(end-start)/1000);

    }

}
