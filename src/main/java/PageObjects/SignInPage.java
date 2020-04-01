package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

	public WebDriver driver;

	By SignIn = By.className("login");
	By EmailAddr = By.id("email_create");
	public static By AccountBtn = By.id("SubmitCreate");
	By Title = By.id("id_gender1");
	By FirstNM = By.id("customer_firstname");
	By LastNM = By.id("customer_lastname");
	By Pwd = By.id("passwd");
	By FNameAddr = By.id("firstname");
	By LNameAddr = By.id("lastname");
	By Address = By.id("address1");
	By City = By.id("city");
	By ZipCode = By.id("postcode");
	By Mobile = By.id("phone_mobile");

	public SignInPage(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement ClickSignIn() {

		return driver.findElement(SignIn);
	}

	public WebElement getEmailAdd() {

		return driver.findElement(EmailAddr);
	}

	public WebElement getTitle() {

		return driver.findElement(Title);
	}

	public WebElement getFirstNM() {

		return driver.findElement(FirstNM);
	}

	public WebElement getLastNM() {

		return driver.findElement(LastNM);
	}

	public WebElement getPwd() {

		return driver.findElement(Pwd);
	}

	public WebElement getFNameAddr() {

		return driver.findElement(FNameAddr);
	}

	public WebElement getLNameAddr() {

		return driver.findElement(LNameAddr);
	}

	public WebElement getAddress() {

		return driver.findElement(Address);
	}

	public WebElement getCity() {

		return driver.findElement(City);
	}

	public WebElement getZipCode() {

		return driver.findElement(ZipCode);
	}

	public WebElement getMobile() {

		return driver.findElement(Mobile);
	}

}
