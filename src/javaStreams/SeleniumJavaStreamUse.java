package javaStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumJavaStreamUse {

	public static void main(String[] args) {
		//Perform web table sorting using Selenium
		//greenKart TopDeal WebTable Veggie name sorting on click or not
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//click on column
		//capture webelement into list
		//capture text of all webelements into new list
		//perform sort on original list and we have one sorted list 
		//compare both list to verify it sorted or not
		
		driver.findElement(By.xpath("//tr/th[1]")).click(); //click on veggie column
		List<WebElement> Veggie = driver.findElements(By.xpath("//tr/td[1]")); //capture all WebElements into list
		List<String> realList = Veggie.stream().map(s->s.getText()).collect(Collectors.toList()); //convert from webelement to string list
		List<String> newList = realList.stream().sorted().collect(Collectors.toList()); //sorting realList 
		
		Assert.assertTrue(realList.equals(newList));  //compare two list sorted or not
		 
		//Print the price of veggie
		//scan the column with gettext -> Rice -> Print the price of Rice
		//we will see how we can use custom method in stream mapping
		//we passed first column name through stream and implement custom method
		List<String> Price = Veggie.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggie(s)).collect(Collectors.toList()); //create custom method
		Price.forEach(s->System.out.println(s)); //print price 
		//but there is problem in upper solution as what if beans is on 3rd page so we have to use pagination to scan veggie in all page to print price
		
	}

	private static String getPriceVeggie(WebElement s) {
		//Create custom method
		//Logic we Use: here we are using siblings xpath because we are moving from veggie name to price 
		//so first column xpath already we passed into stream so we need to passed price column xpath in this methods to get price accordingly
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
