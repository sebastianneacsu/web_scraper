import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImmoWeb {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public ImmoWeb(WebDriver driver) {
        this.driver=driver;
    }

    String baseURL = "https://www.immoweb.be/en";
    By keepBrowsingPopUp = By.cssSelector("button[aria-label=\"Keep browsing\"]");
    By propertyTypeDropDown = By.cssSelector("button[id*=\"propertyTypesDesktop\"]");
    By apartmentOption = By.cssSelector("li[data-value=\"APARTMENT\"]");
    By searchButton = By.cssSelector("button[id = \"searchBoxSubmitButton\"]");


    By propertyPrice = By.cssSelector("p[class*=\"card--result__price\"] span[aria-hidden=\"true\"]");
    By propertyBedrooms = By.xpath("//p[contains(concat(\" \", normalize-space(@class), \" \"), \" card__information--property\")] /*[1]");
    By propertyLocation = By.cssSelector("p[class*=\"card__information--locality\"]");
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
        driver.findElement(propertyTypeDropDown).click();
        Thread.sleep(500);
        driver.findElement(apartmentOption).click();
        Thread.sleep(500);
        driver.findElement(searchButton).click();
        Thread.sleep(500);
    }

    public String [] getApartmentDetails(){
        String price = driver.findElement(propertyPrice).getText();
        String bedrooms = driver.findElement(propertyBedrooms).getText();
        String location = driver.findElement(propertyLocation).getText();
        System.out.println(price + bedrooms + location);
        return new String[]{price, bedrooms, location};
    }

    //validations: if bedrooms class is abbreviation
}
