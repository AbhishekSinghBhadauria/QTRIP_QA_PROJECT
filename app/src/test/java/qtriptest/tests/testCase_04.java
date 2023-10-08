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

public class testCase_04 {
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
//    @Parameters({"GuestName1" ,"Date1" , "count1" , "GuestName2" , "Date2" , "count2"})
   @Test(dataProvider="DatasetsforQTrip", dataProviderClass=DP.class, enabled=true, description = "verify Relaibility flow" , priority = 4, groups={"Reliability Flow"})
   public void TestCase04(String NewUserName,String Password, String dataSet1,String dataSet2,String dataSet3) throws InterruptedException{
    
        HomePage home= new HomePage(driver);
        home.navigateToHomePage();

        RegisterPage register= new RegisterPage(driver);
        register.navigateToRegisterPage();
        register.registerNewUser(NewUserName, Password, true);
		lastUsername=register.lastGeneratedUsername;
        
		LoginPage login= new LoginPage(driver);
		login.performLogin(lastUsername, Password);
        String[] dataset1 = dataSet1.split(";");
        String[] dataset2 = dataSet2.split(";");
        String[] dataset3 = dataSet3.split(";");
        home.searchCity(dataset1[0]);
        home.selectCity();
         
        AdventurePage adventure= new AdventurePage(driver);
        adventure.searchAdventure(dataset1[1]);
        adventure.clickAdventure();
        Thread.sleep(3000);
        AdventureDetailsPage adventureDetails= new AdventureDetailsPage(driver);
        adventureDetails.bookAdventure( dataset1[2], dataset1[3], dataset1[4]);
        adventureDetails.verifyAdventureBooking();
        adventureDetails.reservationClick();
        Thread.sleep(3000);
        home.navigateToHomePage();
        home.searchCity(dataset2[0]);
        home.selectCity(); 
        AdventurePage adventure1= new AdventurePage(driver);
        adventure1.searchAdventure(dataset2[1]);
        adventure1.clickAdventure();
        Thread.sleep(3000);
        AdventureDetailsPage adventureDetails1= new AdventureDetailsPage(driver);
        adventureDetails1.bookAdventure( dataset2[2], dataset2[3], dataset2[4]);
        adventureDetails1.verifyAdventureBooking();
        adventureDetails1.reservationClick();
        Thread.sleep(3000);
        home.navigateToHomePage();
        home.searchCity(dataset3[0]);
        home.selectCity();
        AdventurePage adventure2= new AdventurePage(driver);
        adventure2.searchAdventure(dataset3[1]);
        adventure2.clickAdventure();
        Thread.sleep(3000);
        AdventureDetailsPage adventureDetails2= new AdventureDetailsPage(driver);
        adventureDetails2.bookAdventure( dataset3[2], dataset3[3], dataset3[4]);
        adventureDetails2.verifyAdventureBooking();
        adventureDetails2.reservationClick();
        Thread.sleep(3000); 
        HistoryPage history= new HistoryPage(driver);
        history.storeTransactionId();
        history.logout();
   }
   
}
