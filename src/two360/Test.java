package two360;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * @author smi1e
 * Date 2019/8/31 19:35
 * Description
 */
public class Test {
    @org.junit.Test
    public void test1() {
        String str1 = "123";
        String str2 = "123";
        assertSame("same",true,str1==str2);
        assertEquals("same",true,str1==str2);
    }
}
