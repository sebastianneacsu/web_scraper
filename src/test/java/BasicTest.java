import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class BasicTest {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
    }

    @Test
    public void test()
    {
        driver.get("https://freeqacamp.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "freeqacamp";
        assertEquals(expectedTitle,actualTitle);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}