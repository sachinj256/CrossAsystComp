package Assignment.CrossAsyst;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class Base {
	

		public static WebDriver driver;
		//private Object ChromeOptions;
	
		public static WebDriver InitializeDriver() throws IOException {
		
		File F = new File("DriversExe");
		File FS = new File(F,"chromedriver.exe");
		
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Sachin Jadhav\\eclipse-workspace\\CrossAsyst\\data.properties");
		prop.load(file);
		String BrowserName = prop.getProperty("browser");
		
		if(BrowserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", FS.getAbsolutePath());
			driver = new ChromeDriver(GetChromeOptions());
		}
		else if(BrowserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecho.driver", FS.getAbsolutePath());
			driver = new FirefoxDriver();
		}
		else
		{
			System.setProperty("webdriver.internetexplorer.driver", FS.getAbsolutePath());
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		return driver;

}
		public static ChromeOptions GetChromeOptions() {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			return options;
		}
		
		 @AfterTest
		 public void TearDown()
		 {
			 if(driver != null)
			 {
				 driver.close();
				 driver.quit();
			 }
		 }

}
