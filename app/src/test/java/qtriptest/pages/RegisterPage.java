package qtriptest.pages;

import java.util.UUID;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegisterPage { 
    RemoteWebDriver driver;
    String url="https://qtripdynamic-qa-frontend.vercel.app";
    public String lastGeneratedUsername = "";


    @FindBy(xpath="//a[text()='Register']")
    WebElement register;

   @FindBy(name="email")
   WebElement username_txt_box;

   @FindBy(name="password")
   WebElement password_txt_box;

   @FindBy(name="confirmpassword")
   WebElement confirm_password_txt_box;

   @FindBy(xpath="//button[text()='Register Now']")
   WebElement register_now_button;

    public RegisterPage(RemoteWebDriver driver) {
        this.driver=driver;
        AjaxElementLocatorFactory ajax=new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(ajax, this);
    }

    public void navigateToRegisterPage() throws InterruptedException{

       
        if(!driver.getCurrentUrl().equals(this.url)){
            driver.get(this.url);
        }
    }

    public boolean registerNewUser(String username, String password, boolean generateRandomUsername) throws InterruptedException{

        if (generateRandomUsername) {
            // Concatenate the timestamp to string to form unique timestamp
            username = UUID.randomUUID().toString()+username;
        }

       //Thread.sleep(3000);
        register.click();
        
        username_txt_box.sendKeys(username);
        password_txt_box.sendKeys(password);
        confirm_password_txt_box.sendKeys(password);
        lastGeneratedUsername = username;

               register_now_button.click();
               Thread.sleep(3000);

        return this.driver.getCurrentUrl().endsWith("/login");
    }
}











// public class RegisterPage {

//     RemoteWebDriver driver;

//     public RegisterPage(RemoteWebDriver driver){

//        this.driver = driver;
//        PageFactory.initElements(new AjaxElementLocatorFactory(driver,25), this);
//     }
    

//     @FindBy(id = "email")
//     public WebElement emailField;

//     @FindBy(name = "password")
//     public WebElement passwordText;

//     @FindBy(id = "confirmPassword")
//     public WebElement confirmPasswordText;

//     @FindBy(xpath = "//button[text()='Register Now")
//     public WebElement registerButton;

//     public Boolean checkRegisterPageURL(String endPoint){
//            return driver.getCurrentUrl().contains(endPoint);
//     }

//     public void checkRegisterPageUrl(String string) {}


    // public WebDriver driver;
    // public WebDriverWait wait;

    // // defining web elements on the registration page using Page Factory annotations
    // @FindBy(id = "username")
    // public WebElement usernameField;

    // @FindBy(id = "password")
    // public WebElement passwordField;

    // @FindBy(id = "confirm_password")
    // public WebElement confirmPasswordField;

    // @FindBy(id = "email")
    // public WebElement emailField;

    // @FindBy(id = "register_button")
    // public WebElement registerButton;

    // @FindBy(id = "success_message")
    // public WebElement successMessage;

    // public void RegistrationPage(WebDriver driver) {
    //     this.driver = driver;
    //     AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10); // Initializing WebDriverWait with a timeout of 10 seconds
    //     PageFactory.initElements(driver, this);
    // }

    // public void register(String username, String password, String confirmPassword, String email) {
    //     // Entering registration information
    //     usernameField.sendKeys(username);
    //     passwordField.sendKeys(password);
    //     confirmPasswordField.sendKeys(confirmPassword);
    //     emailField.sendKeys(email);

    //     // Submitting the registration form
    //     registerButton.click();
    // }

    // public String getSuccessMessage() {
    //     // Waiting for the success message to be visible
    //     wait.until(ExpectedConditions.visibilityOf(successMessage));

    //     // Retrieving the success message after registration
    //     return successMessage.getText();
    // }

    // public String getErrorMessage() {
    //     return null;
    // }
// }


