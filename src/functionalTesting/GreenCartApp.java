package functionalTesting;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenCartApp {

	public static void main(String[] args) throws InterruptedException {
		// Problem: Add items into cart for eCommerce App
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		int j=0;
		//create array of products to add in cart
		String[] itemsNeeded = {"Cucumber","Brocolli","Beetroot","Carrot"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(4000);
		//define integer for exit loop after necessary execution
		
		//We want to add cucumber into cart
		//we collect the list of products in webelement list and passed it through for loop
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		//Now we scan products in for loop and convert items needed array in array list
		for(int i=0; i<products.size();i++)
		{
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			//check whether name you extracted is present in array or not
			//convert array into arrayList for easy search
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			
			if(itemsNeededList.contains(formattedName))
			{
				j++;
				//click on add to cart
				//Using add to cart Xpath
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsNeeded.length)
				{
				break;
				}
			
			}
		}
		

	}

}
