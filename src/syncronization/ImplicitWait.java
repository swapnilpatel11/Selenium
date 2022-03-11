package syncronization;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

	
	public static void main(String[] args) throws InterruptedException {
		// We are using GreenKart WebApp from RahulShetty Academy
		// Problem: Add Multiple items items into cart for eCommerce WebApp
				// Amazon Interview question
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //Implicit Wait
				//create array of products to add in cart
				String[] itemsNeeded = {"Cucumber","Brocolli","Beetroot","Carrot"};
				
				driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
				Thread.sleep(4000);
				addItems(driver,itemsNeeded); //we create this method which is count as Utility which we can reuse in any class 
				driver.findElement(By.cssSelector("img[alt='Cart']")).click();
				driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();
				driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
				driver.findElement(By.cssSelector(".promoBtn")).click();
				System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());


	}
	
	public static void addItems(WebDriver driver,String[] itemsNeeded) {
		//define integer for exit loop after necessary execution
		//We want to add cucumber into cart
		//we collect the list of products in WebElement list and passed it through for loop
		int j=0;
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
				//Using add to cart XPath
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsNeeded.length)
				{
				break;
				}
			
			}
		}
	}

}
