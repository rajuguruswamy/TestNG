import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import  org.openqa.selenium.WebDriver;
import  org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class AssertionExample {

    WebDriver driver;
    @BeforeClass
    void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\raju\\study\\SoftwareEngineering\\QA\\TestNG\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 1)
    void logoTest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement logo = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//img[@alt='company-branding']")
                )
        );

        Assert.assertNotNull(logo,"Logo not displayed on the page");
        Assert.assertTrue(logo.isDisplayed(),"Logo not displayed on the page");
//        Assert.assertFalse( logo.isDisplayed());
    }

    @Test(priority = 2)
    void homePageTitle() {
       String title =  driver.getTitle();
       Assert.assertEquals(title, "OrangeHRM","Title is not matched");
    }


    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
