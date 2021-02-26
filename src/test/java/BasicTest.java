import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BasicTest {
    WebDriver driver;
    ImmoWeb immoWeb;
    ImobiliareRo imobiliareRo;
    @Before
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void getMostRecentProperties()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.mostRecentProperties);
        immoWeb.printAllProperties();
    }

    @Test
    public void getMostRecentPropertiesBucharest()throws InterruptedException, IOException {
        imobiliareRo = new ImobiliareRo(driver);
        imobiliareRo.navigateCustomUrl(imobiliareRo.mostRecentProperties);
        imobiliareRo.printAllProperties();
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}