package qtriptest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
    RemoteWebDriver driver;
    String url="https://qtripdynamic-qa-frontend.vercel.app/pages/login";

    // @FindBy(xpath="//a[text()='Login Here']")
    //  WebElement login_here;

     @FindBy(xpath ="//*[@id='floatingInput']")
      WebElement email_add_Text_box;
 
     @FindBy(id ="floatingPassword")
      WebElement password_text_box;

     @FindBy(xpath ="//button[text()='Login to QTrip']")
      WebElement logIn_to_qtrip;

     @FindBy(xpath = "//div[text()='Logout']")
      WebElement log_out_button;

     @FindBy(xpath="//a[text()='Login Here']")
      WebElement login_here_verify;

  public LoginPage(RemoteWebDriver driver){
    
    this.driver=driver;
    AjaxElementLocatorFactory ajax=new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(ajax, this);
  }
 
  public void navigateToLoginPage() throws InterruptedException{
    if(!driver.getCurrentUrl().equals(url)){
        driver.get(url);
    }
}
    public void performLogin(String username, String password){
      
        try{
          
          email_add_Text_box.sendKeys(username);
          password_text_box.sendKeys(password);
          logIn_to_qtrip.click();
          Thread.sleep(5000);
        }catch(Exception e){
          System.out.println(e);
        }
       
    }
   public boolean verifyLogin(){
     if (log_out_button.isDisplayed()){
      return true;
    }else{
    return false;
  } 

  }
  public boolean verifyLogout(){
    if(login_here_verify.isDisplayed()){
      return true;
    }else{
      return false;
    }
  }
  
  public void logout(){
    log_out_button.click();

 }

}
