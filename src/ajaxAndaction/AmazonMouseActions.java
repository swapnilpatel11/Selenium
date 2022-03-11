package ajaxAndaction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonMouseActions {

	public static void main(String[] args) {
		//Here we are doing mouse over actions in Amazon WepApp
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.ca/ref=nav_logo");
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.cssSelector("span[class='nav-line-2 ']"));
		//Moves to Specific Element
		a.moveToElement(move).build().perform();
		//Enter capital letters in search 
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();

	}

}
