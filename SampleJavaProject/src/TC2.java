import org.testng.annotations.*;

public class TC2 {

    @BeforeClass()
    void beforeClass(){
        System.out.println("===This will execute before the class starts===");
    }

    @AfterClass()
    void afterClass(){
        System.out.println("===This will execute after the class end===");
    }

    @BeforeMethod()
    void beforeMethod() {
        System.out.println("==This will execute before every Test Method==");
    }

    @AfterMethod()
    void afterMethod() {
        System.out.println("==This will execute after every Test Method==");
    }


    @Test
    void test3(){
        System.out.println("=This is test3=");
    }

    @Test
    void test4() {
        System.out.println("=This is Test4=");
    }

    @BeforeSuite()
    void beforeSuite() {
        System.out.println("=====This will execute before suite start=====");
    }

    @AfterSuite()
    void afterSuite() {
        System.out.println("=====This will execute after suite end=====");
    }

}
