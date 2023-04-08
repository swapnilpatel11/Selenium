package realTimeExercises;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderUI {

	public static void main(String[] args) {
		// Here we see how to deal with calendar
		//This code is not working in month selection 
		//Website host is deleted so its failing
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.cssSelector("#travel_date")).click();
		//Selection of month with same approach
		Boolean condition = driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("April");
		while(!condition) //we use negative condition to click on next page of month until we find the selected one
		{
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}
		
		//Grab common attribute and put it in List and iterate to get desired date
		List<WebElement> dates = driver.findElements(By.className("day")); //List of all days
		//Selecting 25th Date from calendar
		for(int i=0;i<dates.size();i++)
		{
			String text = dates.get(i).getText(); //we collect all items' text
			if(text.equalsIgnoreCase("25"))  //condition for matching dates
			{
				dates.get(i).click();  //if getText() matches 23 then it click on 25
				break;
			}
		}
	}

}
