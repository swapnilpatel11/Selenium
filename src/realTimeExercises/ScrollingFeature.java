package realTimeExercises;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollingFeature {

	public static void main(String[] args) {
		// Here we are going to use JavaScript Executor to scroll mouse pointer and count data from table
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Casting driver to JavaScriptExecutor to use JavaScript
		//We will use JavaScript in console of our web browser e.g. window.scroll(0,500) hit enter
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Scrolling window to halfway where table is
		js.executeScript("window.scroll(0,500)");
		
		//Now we want scroll table which is inside web page and we scroll table with jquerySelector which is same as cssSelector 
		//document.querySelector(".tableFixHead").scrollTop=500
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		//Here we want to add numbers from 4th column and make it total
		//we collect all 4th column items into list then we passed it through for loop and add together
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum = 0;
		for(int i=0;i<values.size();i++)
		{
			sum = sum + Integer.parseInt(values.get(i).getText()); //convert this string into Integer so we can add all values
			
		}
		System.out.println(sum);
		
		//We are comparing now sum with total amount on web page
		String totalAmount = driver.findElement(By.cssSelector(".totalAmount")).getText(); //we store text in string
		String finalTotal = totalAmount.split(":")[1].trim(); //we extract 296 from string here
		int total = Integer.parseInt(finalTotal);
		
		Assert.assertEquals(sum, total);
		
		
		
		

	}

}
