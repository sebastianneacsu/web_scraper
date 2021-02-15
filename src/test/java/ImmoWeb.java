import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ImmoWeb {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public ImmoWeb(WebDriver driver) {
        this.driver=driver;
    }

    String baseURL = "https://www.immoweb.be/en";
    String mostRecentProperties = "https://www.immoweb.be/en/search/house-and-apartment/for-sale?countries=BE&orderBy=newest";

    By keepBrowsingPopUp = By.cssSelector("button[aria-label=\"Keep browsing\"]");
    By propertyTypeDropDown = By.cssSelector("button[id*=\"propertyTypesDesktop\"]");
    By apartmentOption = By.cssSelector("li[data-value=\"APARTMENT\"]");
    By searchButton = By.cssSelector("button[id = \"searchBoxSubmitButton\"]");


    By propertyPrice = By.cssSelector("p[class*=\"card--result__price\"] span[aria-hidden=\"true\"]");
    By propertyBedrooms = By.xpath("//p[contains(concat(\" \", normalize-space(@class), \" \"), \" card__information--property\")] /*[1]");
    By propertyLocation = By.cssSelector("p[class*=\"card__information--locality\"]");
    By propertySurface = By.xpath("//p[contains(concat(\" \", normalize-space(@class), \" \"), \" card__information--property\")]");

    By sortingCriteria = By.cssSelector("button[id*=\"inputSort\"]");
    By cheapestCriteria = By.cssSelector("li[data-value=\"cheapest\"]");
    By mostExpensiveCriteria = By.cssSelector("li[data-value=\"most_expensive\"]");

    By nextPageButton = By.cssSelector("a[class*=\"pagination__link--next\"]");


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

    public void searchForHouses() throws InterruptedException {
        driver.findElement(searchButton).click();
        Thread.sleep(500);
    }

    public String [] getApartmentDetails(int i){

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);
        System.out.println("Date Format with dd-MM-yyyy : "+ strDate);

        List<WebElement> priceList = driver.findElements(propertyPrice);
        List<WebElement> bedroomList = driver.findElements(propertyBedrooms);
        List<WebElement> locationList = driver.findElements(propertyLocation);
        List<WebElement> surfaceList = driver.findElements(propertySurface);

        try {
            String price = priceList.get(i).getText().trim();
            price = price.substring(1);

            String bedrooms = bedroomList.get(i).getText();
            bedrooms = bedrooms.substring(0, 2).trim();

            String location = locationList.get(i).getText().trim();
            String commune = location.substring(4);
            String postCode = location.substring(0, 4);

            String surface = surfaceList.get(i).getText();

            surface = surface.substring(surface.indexOf("·") + 1);
            surface = surface.substring(0, surface.indexOf("m²")).trim();


            System.out.println(" PRICE = " + price + " BED = " + bedrooms + " COMMUNE = " + commune + " AREA = " + surface
                    + " CODE = " + postCode + "DATE = " + strDate);
            return new String[]{price, bedrooms, commune, surface, postCode, strDate};
        }

        catch (Exception exception){
            System.out.println(exception + "ERROR");
            return new String[]{"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"};
        }
    }


    public void getAllPropertiesToCSV() throws IOException {
        List<WebElement> locationList = driver.findElements(propertyLocation);

        for (int i = 0; i < locationList.size(); i++) {
            if(!getApartmentDetails(i)[0].contains("-") && !getApartmentDetails(i)[3].contains("-")&& (getApartmentDetails(i)[0].matches("^(\\d+|\\d{1,3}(,\\d{3})*)(\\.\\d+)?$"))
                    && (getApartmentDetails(i)[1].matches("[0-9]+") && getApartmentDetails(i)[1].length() > 0)
                    && (getApartmentDetails(i)[3].matches("[0-9]+"))&&(getApartmentDetails(i)[4].matches("[0-9]+"))){
                CSVWriter.printHouses(getApartmentDetails(i));
            }
        }
    }



    public void printAllProperties() throws IOException, InterruptedException {
        while (!driver.findElements(nextPageButton).isEmpty()){
            getAllPropertiesToCSV();
            Thread.sleep(500);
            driver.findElement(nextPageButton).click();
        }
    }

    public void sortByCheapest() throws InterruptedException {
        Thread.sleep(200);
        driver.findElement(sortingCriteria).click();
        Thread.sleep(200);
        driver.findElement(cheapestCriteria).click();
        Thread.sleep(200);
    }

    public void sortByMostExpensive() throws InterruptedException {
        Thread.sleep(200);
        driver.findElement(sortingCriteria).click();
        Thread.sleep(200);
        driver.findElement(mostExpensiveCriteria).click();
        Thread.sleep(200);
    }

    public void navigateCustomUrl(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(500);
        if (!driver.findElements(keepBrowsingPopUp).isEmpty()){
            driver.findElement(keepBrowsingPopUp).click();
        }
        Thread.sleep(500);
    }

}
