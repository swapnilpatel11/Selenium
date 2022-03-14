package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealProblemAssignment2 {

	public static void main(String[] args) {
		//Here we going to use AutoSuggest Dropdown 
		//we enter 3 letter of country and and then we going to select desired country
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys("ind"); //enter ind into textbox
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys(Keys.DOWN); //two times down arrow key to select country
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys(Keys.DOWN);
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys(Keys.DOWN);
		driver.findElement(By.cssSelector("#autocomplete")).getAttribute("value"); //by getAttribute we can select india
		
		

	}

}
