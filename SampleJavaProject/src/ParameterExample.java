import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParameterExample {

    WebDriver driver;
    @BeforeClass
    @Parameters({"browser","url"})
    void setup(String browser, String app) {

        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\raju\\study\\SoftwareEngineering\\QA\\TestNG\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "C:\\raju\\study\\SoftwareEngineering\\QA\\TestNG\\Drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\raju\\study\\SoftwareEngineering\\QA\\TestNG\\Drivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        driver.get(app);

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
//        Assert.assertTrue(logo.isDisplayed(),"Logo not displayed on the page");
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
