import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ImmoWeb {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public ImmoWeb(WebDriver driver) {
        this.driver=driver;
    }

    String baseURL = "https://www.immoweb.be/en";
    By keepBrowsingPopUp = By.cssSelector("button[aria-label=\"Keep browsing\"]");

    WebElement propertyTypeDropdown = driver.findElement(By.cssSelector("select[aria-labelledby*=\"inputPropertyTypeLabel\"]"));
    Select propertyType = new Select(propertyTypeDropdown);

    By searchButton = By.cssSelector("button[id = \"searchBoxSubmitButton\"]");

    By propertyPrice = By.cssSelector("p[class*=\"card--result__price\"] span[aria-hidden=\"true\"]");

    //Method to click login button
    public void navigateHomepage() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(500);
        if (!driver.findElements(keepBrowsingPopUp).isEmpty()){
            driver.findElement(keepBrowsingPopUp).click();
        }
        Thread.sleep(500);
    }

    public void searchForApartments() throws InterruptedException {
        propertyType.selectByValue("APARTMENT");
        Thread.sleep(500);
        driver.findElement(searchButton).click();
        Thread.sleep(500);
    }

    public String [] getApartmentDetails(){
    return new String[]{"stuff"};
    }
}
