package qtriptest.pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class HistoryPage {
    RemoteWebDriver driver;
    String url="https://qtripdynamic-qa-frontend.vercel.app/pages/adventures/reservations/";

    @FindBy(xpath ="//tbody[@id='reservation-table']/tr/th")
    List<WebElement> transactionId;

    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancel_button;

    @FindBy(xpath="//div[contains(text(),'Oops! You have not made any reservations yet!')]")
    WebElement verify_cancel;

    @FindBy(xpath = "//div[text()='Logout']")
    WebElement log_out;
    
    public HistoryPage(RemoteWebDriver driver){
        this.driver=driver;
        AjaxElementLocatorFactory ajax= new AjaxElementLocatorFactory(driver,  10);
        PageFactory.initElements(ajax, this);
    }

    public void navigateToHistoryPage() throws InterruptedException{
          if(!driver.getCurrentUrl().equals(url)){
            driver.get(url);
        }
    }

    public void storeTransactionId(){
        try{
            driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            Thread.sleep(1000);
            for(int i=0;i<transactionId.size();i++)
            {
                System.out.println("Transaction id: " +transactionId.get(i).getText());
            }
            
        } catch(Exception e) {
             System.out.println(e);
        }
    }

    public void cancelReservation() throws InterruptedException{
        Thread.sleep(2000);
        cancel_button.click();
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver)
        .withTimeout((Duration.ofSeconds(30)))
        .pollingEvery(Duration.ofMillis(250))
        .ignoring(Exception.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("no-reservation-banner")));
        driver.navigate().refresh();
       
    }


public boolean verifyCancelReservation(){
    if(verify_cancel.getText().contains("Oops! You have not made any reservations yet!")){
        return true;
      }else{
        return false;
      }
    }

    public void logout() throws InterruptedException{
        Thread.sleep(2000);
        log_out.click();
    }
}