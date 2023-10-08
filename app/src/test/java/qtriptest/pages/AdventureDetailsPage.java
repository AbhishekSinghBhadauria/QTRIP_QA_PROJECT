package qtriptest.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AdventureDetailsPage {
       RemoteWebDriver driver;
    

       @FindBy(xpath="//input[@name='name']")
       WebElement name_text_box;

       @FindBy(xpath="//input[@name='date']")
       WebElement date;

       @FindBy(xpath="//input[@name='person']")
       WebElement person_count;

       @FindBy(xpath="//button[text()='Reserve']")
       WebElement reserve_button;

       @FindBy(xpath="//div[contains(text(),'Greetings! Reservation for this adventure is successful')]")
       WebElement verify_booking;

       @FindBy(xpath = "//a[text()='Reservations']")
       WebElement reservation;
       
    public AdventureDetailsPage(RemoteWebDriver driver){
        this.driver=driver;
        AjaxElementLocatorFactory ajax= new AjaxElementLocatorFactory(driver,  10);
        PageFactory.initElements(ajax, this);
    }

    
    public void bookAdventure(String GuestName,String Date,String count ) throws InterruptedException{
   
     Thread.sleep(5000);

      name_text_box.sendKeys(GuestName);
      date.sendKeys(Date);
      Thread.sleep(3000);
      person_count.clear();
      person_count.sendKeys(count);
      Thread.sleep(5000);
      reserve_button.click();
      Thread.sleep(3000);
    }

    public boolean verifyAdventureBooking(){
    
    if(verify_booking.getText().contains("Greetings! Reservation for this adventure is successful")){
      return true;
    }else{
      return false;
    }
  }
  public void reservationClick() throws InterruptedException{
    Thread.sleep(2000);
    reservation.click();
    Thread.sleep(2000);
  }
    
}