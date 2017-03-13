package CaculateProject;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testGetResult(){
        App app = new App();
        Assert.assertEquals(9,Integer.parseInt(app.getResult("4+(2+4)-4*5+9-8/4*(3+6)"  ).toString()));
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
