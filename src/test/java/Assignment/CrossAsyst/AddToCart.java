package Assignment.CrossAsyst;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import Helper.GenericHelper;
import Helper.HelperClass;
import PageObjects.SignInPage;

public class AddToCart extends Base{
	
	//WebDriverWait wait = new WebDriverWait(Base.driver, 30);
	
	@Test
	public void Testing() throws IOException, InterruptedException {
		
		 String [] ItemsNeeded = {"Faded Short Sleeve T-shirts"};
		 driver = InitializeDriver();
		 driver.get("http://automationpractice.com/index.php");
		 SignInPage Sp = new SignInPage(driver);
		 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login")));
		 Sp.ClickSignIn().click();
		 Sp.getEmailAdd().sendKeys("sachinj256@gmail.com");
		 HelperClass.ButtonClick(SignInPage.AccountBtn);
		 Thread.sleep(2000L);
		 if(GenericHelper.IsElementPresent(By.id("create_account_error"))) {
			 System.out.println("Account already Exists.");
			 HelperClass.TypeInText(By.id("email"), "sachinj256@gmail.com");
			 HelperClass.TypeInText(By.id("passwd"), "123456");
			 HelperClass.ButtonClick(By.id("SubmitLogin"));
		 }
		 else {
		 Sp.getTitle().click();
		 Sp.getFirstNM().sendKeys("Sachin");
		 Sp.getLastNM().sendKeys("Jadhav");
		 Sp.getPwd().sendKeys("123456");
		 Sp.getFNameAddr().sendKeys("Test");
		 Sp.getLNameAddr().sendKeys("Test");
		 Sp.getAddress().sendKeys("Testing Street");
		 Sp.getCity().sendKeys("Mumbai");
		// HelperClass.ButtonClick(By.id("id_state"));
		 HelperClass.SelectByValue(By.id("id_state"), "5");
		 Sp.getZipCode().sendKeys("80563");
		 Sp.getMobile().sendKeys("9969960506");
		 HelperClass.TypeInText(By.id("alias"), "Testing");
		 HelperClass.ButtonClick(By.id("submitAccount"));
		 }
		 WebDriverWait wait = new WebDriverWait(Base.driver, 30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Women']")));
		 HelperClass.ButtonClick(By.xpath("//a[text()='Women']"));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='product_list grid row']")));
		 WebElement Item = driver.findElement(By.xpath("//ul[@class='product_list grid row']"));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", Item); 
		 
		 int j = 0;
		 
		 List<WebElement> products=driver.findElements(By.xpath("//ul[@class='product_list grid row']//li/descendant::img"));
		 for(int i=0;i<products.size();i++)

		 {

			 String name=products.get(i).getAttribute("title");
			 List itemsNeededList = Arrays.asList(ItemsNeeded);
			 
			 if(itemsNeededList.contains(name))

			 {

			 j++;

			 Actions a = new Actions(driver);
			 a.moveToElement(driver.findElement(By.xpath("(//ul[@class='product_list grid row']//li/descendant::img)[1]")));
			 a.build().perform(); 

			 driver.findElements(By.xpath("//ul[@class='product_list grid row']//li/descendant::a[3]")).get(i).click();
			 WebElement Frame = driver.findElement(By.className("fancybox-iframe"));
			 driver.switchTo().frame(Frame);
			 driver.switchTo().activeElement();
			 HelperClass.ButtonClick(By.xpath("//a[contains(@class,'quantity_up')]"));
			 HelperClass.ButtonClick(By.cssSelector("button.exclusive"));
			 driver.switchTo().defaultContent();
			 HelperClass.ButtonClick(By.xpath("(//div[@class='button-container']/a)[1]"));
			 driver.switchTo().defaultContent();
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Proceed to checkout']")));
			// WebElement Proceed = driver.findElement(By.xpath("//*[text()='Proceed to checkout']"));
			// js.executeScript("arguments[0].scrollIntoView();", Item, Proceed);
			 HelperClass.ButtonClick(By.xpath("//*[text()='Proceed to checkout']"));
			 Thread.sleep(2000L);
			 HelperClass.ButtonClick(By.xpath("//*[text()='Proceed to checkout']"));
			 Thread.sleep(2000L);
			 HelperClass.ButtonClick(By.id("cgv"));
			 HelperClass.ButtonClick(By.xpath("//button[@name='processCarrier']"));
			 WebElement Total = driver.findElement(By.xpath("//table[@id='cart_summary']//tr[5]/td[2]"));
			 String GetTotal = Total.getText();
			 js.executeScript("arguments[0].scrollIntoView();", Total);
			 Thread.sleep(2000L);
			 HelperClass.ButtonClick(By.xpath("//div[@id='HOOK_PAYMENT']/descendant::a[position() = 1]"));
			 Thread.sleep(2000L);
			 HelperClass.ButtonClick(By.xpath("//*[text()='I confirm my order']"));
			 Thread.sleep(2000L);
			 HelperClass.ButtonClick(By.xpath("//a[@title='Back to orders']"));
			 Thread.sleep(2000L);
			 WebElement TotalPrice = driver.findElement(By.xpath("(//table[@id='order-list']//tr/td[3])[1]"));
			 String VerifyPrice = TotalPrice.getText();
			 Assert.assertEquals(VerifyPrice, GetTotal);
			 if(j==ItemsNeeded.length)

			 {

			 break;

			 }
			 
			 }
		 }
		 
		

}
}
