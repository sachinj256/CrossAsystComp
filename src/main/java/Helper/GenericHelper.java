package Helper;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import com.google.errorprone.annotations.Var;

import Assignment.CrossAsyst.Base;

public class GenericHelper {

	// public TestContext textContext;

	public static boolean IsElementPresent(By locator) {

		try {

			return Base.driver.findElements(locator).size() == 1;

			} 
		catch (Exception e) 
		{

			return false;
		}

	}
	
	   public static WebElement GetElement(By locator)
       {
           if (IsElementPresent(locator))
               return Base.driver.findElement(locator);
           throw new NoSuchElementException("Element not Found :" + locator.toString());

       }
	   
	  /* private WebDriverWait getWait(int timeOutInSeconds,int pollingEveryInMiliSec) {
			oLog.debug("");
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.MILLISECONDS);
			wait.ignoring(NoSuchElementException.class);
			wait.ignoring(ElementNotVisibleException.class);
			wait.ignoring(StaleElementReferenceException.class);
			wait.ignoring(NoSuchFrameException.class);
			return wait;
		}
	 
	   public void waitForElementVisible(By locator,int timeOutInSeconds,int pollingEveryInMiliSec) {
		   Base.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			//setImplicitWait(1, TimeUnit.SECONDS);
			WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
			wait.until(ExpectedConditions.visibilityOf(Base.driver.findElement(locator)));
			setImplicitWait(reader.getImplicitWait(), TimeUnit.SECONDS);
		} */
}
