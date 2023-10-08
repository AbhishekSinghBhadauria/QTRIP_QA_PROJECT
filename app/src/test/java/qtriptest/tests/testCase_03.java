package qtriptest.tests;

import qtriptest.DP;
import qtriptest.DriverSingleton;
import qtriptest.pages.AdventureDetailsPage;
import qtriptest.pages.AdventurePage;
import qtriptest.pages.HistoryPage;
import qtriptest.pages.HomePage;
import qtriptest.pages.LoginPage;
import qtriptest.pages.RegisterPage;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class testCase_03 {
    static RemoteWebDriver driver;
    public String lastUsername;
   // Method to help us log our Unit Tests
   public static void logStatus(String type, String message, String status) {
       System.out.println(String.format("%s |  %s  |  %s | %s",
               String.valueOf(java.time.LocalDateTime.now()), type, message, status));
   }

   // Iinitialize webdriver for our Unit Tests
   @BeforeSuite(alwaysRun = true, enabled = true)
   public static void createDriver() throws MalformedURLException {
       logStatus("driver", "Initializing driver", "Started");
       driver=DriverSingleton.getDriverInstance("chrome");
      // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       logStatus("driver", "Initializing driver", "Success");
   }

   @Test(dataProvider="DatasetsforQTrip", dataProviderClass=DP.class, enabled=true, description = "verify booking and cancellation flow" , priority = 3, groups={"Booking and Cancellation Flow"})
   public void TestCase03(String NewUserName,String Password, String SearchCity,String AdventureName,String GuestName,String Date,String count) throws InterruptedException{
    
         HomePage home= new HomePage(driver);
         home.navigateToHomePage();


        RegisterPage register= new RegisterPage(driver);
        register.navigateToRegisterPage();
        register.registerNewUser(NewUserName, Password, true);
		lastUsername=register.lastGeneratedUsername;
        
		LoginPage login= new LoginPage(driver);
		login.performLogin(lastUsername, Password);
        home.searchCity(SearchCity);
        home.selectCity();

    
         AdventurePage adventure= new AdventurePage(driver);
         adventure.searchAdventure(AdventureName);
         adventure.clickAdventure();
        
         
         AdventureDetailsPage adventureDetails= new AdventureDetailsPage(driver);
           adventureDetails.bookAdventure( GuestName, Date, count);
           adventureDetails.verifyAdventureBooking();
           adventureDetails.reservationClick();
 

          HistoryPage history= new HistoryPage(driver);
          history.storeTransactionId();
          history.logout();
   }
   
}
