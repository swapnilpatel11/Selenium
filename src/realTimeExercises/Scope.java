package realTimeExercises;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// Here we do different exercises with coding
		//1. Print links count in page as output
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size()); //count of links
		
		//2. Getting count of links in footer section
		//Here we use concept of limiting the scope and then we count the links
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));//Limiting WebDriver Scope
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//3.Getting links count in first column of footer
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		
		//4.Click on each link in column in footer and check opening or not and get the title of every tab from that link opened
		for(int i=1;i<columnDriver.findElements(By.tagName("a")).size();i++)
		{
			String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			Thread.sleep(5000);
		}
			//Print the titles
			Set<String> abc = driver.getWindowHandles(); //collect all windows in sets
			Iterator<String> it = abc.iterator(); //using iterator to scan titles
			
			while(it.hasNext())
			{
				driver.switchTo().window(it.next()); //switch to tab for getting title
				System.out.println(driver.getTitle());
			}
		 

	}

}
