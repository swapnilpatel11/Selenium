package javaStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterFunctionality {

	public static void main(String[] args) {
		//Here we will verify filter 
		//we are checking filter option with entering value and check howmany rows are display
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("Rice"); //enter value in filter
		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]")); //collect list of rows
		//Filter rows which contains rice word and collect it in list
		List<WebElement> filterRows = rows.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		
		//now rows and filterRows should be same 
		Assert.assertEquals(rows.size(), filterRows.size()); //;compare two lists
	}

}
