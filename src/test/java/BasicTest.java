import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BasicTest {
    WebDriver driver;
    ImmoWeb immoWeb;
    @Before
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
       // options.addArguments("--headless");
        driver = new ChromeDriver(options);
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test() throws InterruptedException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateHomepage();
        immoWeb.searchForApartments();
        immoWeb.getApartmentDetails();
      //  String actualTitle = driver.getTitle();
    //    String expectedTitle = "freeqacamp – software testing tutorials and interview prep";
  //      assertEquals(expectedTitle,actualTitle);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}