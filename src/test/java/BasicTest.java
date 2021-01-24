import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class BasicTest {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void test()
    {
        driver.get("https://freeqacamp.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "freeqacamp – software testing tutorials and interview prep";
        assertEquals(expectedTitle,actualTitle);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}