package Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelperClass {

	private static WebElement ele;
	private static Select select;

	public static void TypeInText(By locator, String Text)
	{
		ele = GenericHelper.GetElement(locator);
		ele.sendKeys(Text);
	}

	public static void TextClear(By locator) 
	{
		ele = GenericHelper.GetElement(locator);
		ele.clear();
	}
	
	 public static void ButtonClick(By locator)
     {
         ele = GenericHelper.GetElement(locator);
         ele.click();
     }
	 
	 public static void SelectElement(By locator, int index)
     {
         select = new Select(GenericHelper.GetElement(locator));
         select.selectByIndex(index);
         
     }
	 
	 public static void SelectElement(By locator, String visibletext)
     {
         select = new Select(GenericHelper.GetElement(locator));
         select.deselectByVisibleText(visibletext);
     }

     public static void SelectByValue(By locator, String valueTexts)
     {
         select = new Select(GenericHelper.GetElement(locator));
         select.selectByValue(valueTexts);
     }
     
     public static void ClickRadioButton(By locator)
     {
         ele = GenericHelper.GetElement(locator);
         ele.click();
     }

}
