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
    @Before
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void getBrusselsApartments()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.brusselsApartments);
        immoWeb.printAllApartments();
    }
    @Test
    public void getBrusselsHouses()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.brusselsHouses);
        immoWeb.printAllHouses();
    }

    @Test
    public void getAntwerpApartments()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
            immoWeb.navigateCustomUrl(immoWeb.antwerpApartments);
            immoWeb.printAllApartments();
    }

    @Test
    public void getAntwerpHouses()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.antwerpHouses);
        immoWeb.printAllHouses();
    }

    @Test
    public void getLimbourgApartments()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.limbourgApartments);
        immoWeb.printAllApartments();
    }

    @Test
    public void getLimbourgHouses()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.limbourgHouses);
        immoWeb.printAllHouses();
    }

    @Test
    public void getEastFlandersApartments()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.eastFlandersApartments);
        immoWeb.printAllApartments();
    }

    @Test
    public void getEastFlandersHouses()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.eastFlandersHouses);
        immoWeb.printAllHouses();
    }

    @Test
    public void getWestFlandersApartments()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.westFlandersApartments);
        immoWeb.printAllApartments();
    }

    @Test
    public void getWestFlandersHouses()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.westFlandersHouses);
        immoWeb.printAllHouses();
    }

    @Test
    public void getWalloonBrabantApartments()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.walloonBrabantApartments);
        immoWeb.printAllApartments();
    }

    @Test
    public void getWalloonBrabantHouses()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.walloonBrabantHouses);
        immoWeb.printAllHouses();
    }

    @Test
    public void getFlemishBrabantApartments()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.flemishBrabantApartments);
        immoWeb.printAllApartments();
    }

    @Test
    public void getFlemishBrabantHouses()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.flemishBrabantHouses);
        immoWeb.printAllHouses();
    }

    @Test
    public void getHainautApartments()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.hainautApartments);
        immoWeb.printAllApartments();
    }
    @Test
    public void getHainautHouses()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.hainautHouses);
        immoWeb.printAllHouses();
    }

    @Test
    public void getLiegeApartments()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.liegeApartments);
        immoWeb.printAllApartments();
    }
    @Test
    public void getLiegeHouses()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.liegeHouses);
        immoWeb.printAllHouses();
    }
    @Test
    public void getLuxembourgApartments()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.luxembourgApartments);
        immoWeb.printAllApartments();
    }
    @Test
    public void getLuxembourgHouses()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.luxembourgHouses);
        immoWeb.printAllHouses();
    }

    @Test
    public void getNamurApartments()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.namurApartments);
        immoWeb.printAllApartments();
    }
    @Test
    public void getNamurHouses()throws InterruptedException, IOException {
        immoWeb = new ImmoWeb(driver);
        immoWeb.navigateCustomUrl(immoWeb.namurHouses);
        immoWeb.printAllHouses();
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}