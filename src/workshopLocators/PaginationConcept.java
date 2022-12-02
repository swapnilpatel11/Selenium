package workshopLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationConcept {
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		while(true)
		{
			if(driver.findElements(By.xpath("//td[text()='Indor']")).size()>0) {
				//Both method works as we defined
				selectCityCheck("Indor");
				break;
			}
			else {
				//Pagination Logic
				WebElement next = driver.findElement(By.linkText("Next"));
				//this condition is for checking button is available then click otherwise print message
				if(next.getAttribute("class").contains("disable")) {
					System.out.println("Pagination is over...city is not found...");
					break;
				}
				next.click();
			}
		}

	}
	
	//Selenium 4 feature
	public static void selectCityCheck(String cityName) {
		WebElement ele = driver.findElement(By.xpath("//td[text()='"+cityName+"']"));
		driver.findElement(with(By.xpath("input[@type='checkbox']")).toLeftOf(ele)).click();
	}
	
	
	public static void selectCity(String cityName) {
		driver.findElement(By.xpath("//td[text()='"+cityName+"']/preceding-sibling::td/child::input[@type='checkbox']")).click();
	}

}
