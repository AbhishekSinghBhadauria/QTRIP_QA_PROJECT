package qtriptest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class HomePage {

    RemoteWebDriver driver;
String url="https://qtripdynamic-qa-frontend.vercel.app";

@FindBy(id="autocomplete")
WebElement search_valid_cityName;

@FindBy(xpath="//h5[text()='No City found']")
WebElement no_city_found;

@FindBy(id="results")
WebElement city_result;

public HomePage(RemoteWebDriver driver){
    this.driver=driver;
    AjaxElementLocatorFactory ajax= new AjaxElementLocatorFactory(driver,  10);
    PageFactory.initElements(ajax, this);
}

public void navigateToHomePage() throws InterruptedException{

    if(!driver.getCurrentUrl().equals(url)){
        driver.get(url);
    }
}


public void searchCity(String CityName) throws InterruptedException{

    search_valid_cityName.clear();
    Thread.sleep(2000);
    search_valid_cityName.sendKeys(CityName);

}
public boolean isCityNotFound(){
    boolean status= false;
    try{
        status=no_city_found.isDisplayed();
        return status;
    }catch(Exception e){
        return status;
    }
}
public boolean isCityFound(){
    boolean status= false;
    try{
        status=city_result.isDisplayed();
        return status;
    }catch(Exception e){
        return status;
    }
}


public void selectCity() throws InterruptedException{
    Thread.sleep(2000);
    city_result.click();
//    WebDriverWait wait= new WebDriverWait(driver, 5);
//    wait.until(ExpectedConditions.urlToBe("https://qtripdynamic-qa-frontend.vercel.app"));
  }   

}
