import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ImobiliareRo {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public ImobiliareRo(WebDriver driver) {
        this.driver=driver;
    }

    String mostRecentProperties = "https://www.imobiliare.ro/vanzare-apartamente/bucuresti-ilfov?id=26628651";

    By acceptCookies = By.xpath("(//*[text()[contains(.,\"Accept toate cookie-urile\")]])[2]");

    By propertyPrice = By.cssSelector("span[class*=\"pret-mare\"]");
    By propertyBedrooms = By.xpath("//*[contains(concat(' ', normalize-space(@class), ' '), 'caracteristici')] //*[text()[contains(.,\"camere\")]]");
    By propertySurface = By.xpath("//*[contains(concat(' ', normalize-space(@class), ' '), 'caracteristici')] //*[text()[contains(.,\"mp utili\")]]");

    By nextPageButton = By.cssSelector("a[class*=\"inainte butonpaginare\"]");


    public String [] getApartmentDetails(int i){

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);
        System.out.println("Date Format with dd-MM-yyyy : "+ strDate);

        List<WebElement> priceList = driver.findElements(propertyPrice);
        List<WebElement> bedroomList = driver.findElements(propertyBedrooms);
        List<WebElement> surfaceList = driver.findElements(propertySurface);

        try {
            String price = priceList.get(i).getText().trim();

            String bedrooms = bedroomList.get(i).getText();
            bedrooms = bedrooms.substring(0, bedrooms.indexOf("camere")).trim();


            String surface = surfaceList.get(i).getText();
            surface = surface.substring(0, surface.indexOf("mp utili")).trim();


            System.out.println(" PRICE = " + price + " BED = " + bedrooms + " AREA = " + surface
                    + " DATE = " + strDate);
            return new String[]{price, bedrooms, surface, strDate};
        }

        catch (Exception exception){
            System.out.println(exception + "ERROR");
            return new String[]{"ERROR", "ERROR", "ERROR", "ERROR"};
        }
    }


    public void getAllPropertiesToCSV() throws IOException {
        List<WebElement> locationList = driver.findElements(propertyPrice);

        for (int i = 0; i < locationList.size(); i++) {
            if(!getApartmentDetails(i)[0].contains("-") && !getApartmentDetails(i)[3].contains("-")&& (getApartmentDetails(i)[0].matches("^(\\d+|\\d{1,3}(,\\d{3})*)(\\.\\d+)?$"))
                    && (getApartmentDetails(i)[1].matches("[0-9]+") && getApartmentDetails(i)[1].length() > 0)
                    && (getApartmentDetails(i)[2].matches("[0-9]+"))){
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

    public void navigateCustomUrl(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(5000);
        if (!driver.findElements(acceptCookies).isEmpty()){
            driver.findElement(acceptCookies).click();
        }
        Thread.sleep(500);
    }

}
