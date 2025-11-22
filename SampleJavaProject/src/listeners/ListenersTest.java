package listeners;

import net.bytebuddy.implementation.bytecode.Throw;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(CustomListeners.class)
public class ListenersTest {

    @Test
    void test1() {
        String expected ="A";
        System.out.println("This is test1");
        Assert.assertEquals("A" ,expected);
    }

    @Test
    void test2() {
        System.out.println("This is test2");
        Assert.assertEquals("A" ,"B");
    }

    @Test
    void test3() {
        System.out.println("This is test3");
        throw new SkipException("This is skip exception");
    }
}
