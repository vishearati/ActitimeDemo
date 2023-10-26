package comActitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.ObjectRepository.HomePage;
import com.Actitime.ObjectRepository.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	FileLibrary f = new FileLibrary();
         @BeforeSuite
         public void databaseConnection(){
        	Reporter.log("database connected",true); 
         }
         @BeforeClass
         public void launchBrowser() throws IOException {
        	 
        	 driver = new ChromeDriver();
        	 driver.manage().window().maximize();
        	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        	  String url=f.readDataFromProperty("url");
        	 driver.get("url");
        	 //Reporter.log("browser launched successfully",true);
         }
         
         @BeforeMethod
         public void login() throws IOException {
        	 LoginPage lp = new LoginPage(driver);
        	 String un = f.readDataFromProperty("un");
        	 String pw =f.readDataFromProperty("pw");
        	 lp.getUntbx().sendKeys(un);
        	 lp.getPwtbx().sendKeys(pw);
        	 lp.getLgbtn().click();
        	 
        	 
        	// driver.findElement(By.id("username")).sendKeys("admin");
      	  // driver.findElement(By.name("pwd")).sendKeys("manager");
      	   //driver.findElement(By.xpath("//div[.='Login ']")).click();
      	   //Reporter.log("Logged successfully",true);
         }
         @AfterMethod
         public void logout() {
        	 HomePage hp = new HomePage(driver);
        	 hp.getLogoutlnk().click();
      	  // driver.findElement(By.id("logoutLink")).click();
      	   Reporter.log("logged out successfully",true);
         }
         @AfterClass
         public void closeBrowser() {
        	 driver.close();
      	   Reporter.log("Browser closed successfully",true);
      	   
         }
         @AfterSuite
         public void databaseDisconnected() {
      	   Reporter.log("database dissconnected",true);
         }
         
}
