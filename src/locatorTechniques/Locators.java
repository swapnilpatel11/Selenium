package locatorTechniques;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		// Locators type: ID, XPath, CSS Selector, name, ClassName, TagName, LinkText,Partial LinkText
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
					
					WebDriver driver =new ChromeDriver();
					//define implicit wait to handle timeout
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					driver.get("https://www.facebook.com/");
					driver.findElement(By.id("email")).sendKeys("sappu");
					driver.findElement(By.name("pass")).sendKeys("9984");
					driver.findElement(By.name("login")).click();
					System.out.println(driver.findElement(By.cssSelector("div._9ay7")).getText());
					driver.findElement(By.linkText("Forgot password?")).click();
					driver.findElement(By.xpath("//input[@id='identify_email']")).sendKeys("Swapnil");
					driver.findElement(By.cssSelector("input[id='identify_email']")).clear();

	}

}
