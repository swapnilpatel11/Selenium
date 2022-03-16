package selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		//Selenium 4 Features 
		//Above(): Element located above with respect to the specified element.
		//Below(): Element located below with respect to the specified element.
		//toLeftOf(): Element located to the left of specified element
		//toRightOf():Element located to the right of the specified element
		//Syntax: driver.findElement(withTagName("label").above(nameEditBox));
		//relativeLocators not support Flex elements in HTML 
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox = driver.findElement(By.cssSelector("input[name='name']"));
		String label = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText(); //Syntax for above relativeLocator used
		System.out.println(label);
		
		WebElement dateOfBirth = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click(); //it will click submit because date of birth input is flex component
		
		WebElement checkBoxText = driver.findElement(By.cssSelector(" label[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkBoxText)).click(); // example 3 use of leftOf
		
		WebElement radioButton = driver.findElement(By.id("inlineRadio1"));
		String label2 =	driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText(); //example of rightOf
		System.out.println(label2);
	}

}
