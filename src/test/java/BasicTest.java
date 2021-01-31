import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BasicTest {
    WebDriver driver;
    String[] brusselsCommunes = {"Woluwe-St-Pierre", "Auderghem"};
    @Before
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
       // options.addArguments("--headless");
        driver = new ChromeDriver(options);

    }

    @Test
    public void test() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;

        driver.get("https://www.immoweb.be/en");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[aria-label=\"Keep browsing\"]")).click();
        driver.findElement(By.cssSelector(".searchbox__input input")).sendKeys(brusselsCommunes[0]);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[id = \"searchBoxSubmitButton\"]")).click();
        Thread.sleep(6000);
      //  String actualTitle = driver.getTitle();
    //    String expectedTitle = "freeqacamp – software testing tutorials and interview prep";
  //      assertEquals(expectedTitle,actualTitle);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}