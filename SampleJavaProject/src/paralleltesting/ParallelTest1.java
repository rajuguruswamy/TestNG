package paralleltesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ParallelTest1   {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\raju\\study\\SoftwareEngineering\\QA\\TestNG\\Drivers\\chromedriver.exe");
        driver.set(new ChromeDriver());
    }

    public WebDriver getDriver() {
        return driver.get();
    }


    @Test
    void logoTest()  throws  InterruptedException{
        WebDriver driver = getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        WebElement logo =  driver.findElement(By.xpath("//img[@alt='company-branding']"));
        WebElement logo = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//img[@alt='company-branding']")
                )
        );

       Assert.assertNotNull(logo,"Logo not displayed on the page");
        Assert.assertTrue(logo.isDisplayed(),"Logo not displayed on the page");
        Thread.sleep(5000);
    }

    @Test
    void  homePageTitle() throws  InterruptedException{
        WebDriver driver = getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
        String title =  driver.getTitle();
        Assert.assertEquals(title, "OrangeHRM","Title is not matched");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
//            driver.close();
        }
    }
}
