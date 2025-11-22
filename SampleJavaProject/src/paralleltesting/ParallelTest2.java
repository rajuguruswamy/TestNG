package paralleltesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParallelTest2 {

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
    void login()  throws  InterruptedException{
        WebDriver driver = getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        Assert.assertNotNull(username);
        username.sendKeys("Admin");

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        Assert.assertNotNull(password);
        password.sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type='submit' and contains(normalize-space(.), 'Login')]")).click();

        String title =  driver.getTitle();
        Assert.assertEquals(title, "OrangeHRM","Title is not matched");
        Thread.sleep(5000);

     }

    @AfterMethod
    public void tearDown() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
        }
    }

}
