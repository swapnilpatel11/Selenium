package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealProblemAssignment1 {

	public static void main(String[] args) {
		// This assignment is for counting total number of rows and columns 
		// getting values from 2nd row 
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Counting rows in table
		System.out.println(driver.findElements(By.cssSelector(".table-display tr")).size());
		System.out.println(driver.findElements(By.cssSelector(".table-display th")).size());
		
		//Printing 2nd row data
		List<WebElement> values = driver.findElements(By.cssSelector(".table-display tr:nth-child(3)")); //collect data in List
		
		for(int i=0; i<values.size();i++)
		{
			System.out.println(values.get(i).getText());
		}

	}

}
