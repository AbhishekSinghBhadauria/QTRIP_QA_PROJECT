package qtriptest;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumWrapper {
    // public static WebDriver driver;

    public SeleniumWrapper(){
        // SeleniumWrapper.driver = driver;
    }

    public static void click(WebElement e) throws MalformedURLException{
        //System.out.println("WebElement "+e+" is displaying"+e.isDisplayed());
        if(e.isDisplayed()){
            Actions act = new Actions(DriverSingleton.getDriver());
            act.moveToElement(e).click().perform();
            // e.click();
        }
    }

    public static void sendkeys(WebElement inputBox, String keyToSend){
        if(inputBox.isDisplayed()){
        inputBox.clear();
        inputBox.sendKeys(keyToSend);
        }
    }

    public static boolean navigateToUrl(WebDriver driver,String url){
        boolean status;
        status = driver.getCurrentUrl().equals(url);
        if(!status){
            driver.get(url);
        }else{
            return status;
        }
        return status;
    }

    public static WebElement findElementWithRetry(WebDriver driver, By by, int retryCount){
        WebElement ele = null;
        for(int i = 0; i<retryCount; i++){
            ele = driver.findElement(by);
        }
        return ele;
    }
}
