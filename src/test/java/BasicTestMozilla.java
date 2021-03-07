import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BasicTestMozilla {
    WebDriver driver;
    ImmoWeb immoWeb;
    ImobiliareRo imobiliareRo;
    @Before
    public void setUpGeckoDriver() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\NEACSUSE\\Projects\\web_scraper\\geckodriver.exe");
        driver = new FirefoxDriver();
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