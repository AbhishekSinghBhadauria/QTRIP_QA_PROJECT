package qtriptest.tests;

import qtriptest.DP;
import qtriptest.DriverSingleton;
import qtriptest.pages.HomePage;
import qtriptest.pages.LoginPage;
import qtriptest.pages.RegisterPage;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class testCase_01 {
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
		driver = DriverSingleton.getDriverInstance("chrome");
		logStatus("driver", "Initializing driver", "Success");
	}
	
    @Test(dataProvider = "DatasetsforQTrip", dataProviderClass =DP.class, enabled = true, description = "verify Login flow" , priority = 1, groups={"Login Flow"})
     public  void TestCase01(String username, String password) throws InterruptedException{

		HomePage home= new HomePage(driver);
		home.navigateToHomePage();

		RegisterPage register= new RegisterPage(driver);
        register.navigateToRegisterPage();
        Assert.assertTrue(register.registerNewUser(username, password, true));
		lastUsername=register.lastGeneratedUsername;
        System.out.println("registration complete "+username);

		LoginPage login= new LoginPage(driver);
		login.performLogin(lastUsername, password);
		Assert.assertTrue(login.verifyLogin());
		login.logout();
		Assert.assertTrue(login.verifyLogout());
        
     }
}
