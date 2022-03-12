package miscellaneousConcept;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		//Here we will see how can we handle broken Links
		//if http status code is more than 400 then that url is not working 
		//step1: to get all URL tied up to the links using Selenium
		//Java methods will call URL's and gets you the status code
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> Links = driver.findElements(By.cssSelector(".gf-t a"));
		SoftAssert SA = new SoftAssert();
		
		for(WebElement link : Links)
		{
			String url = link.getAttribute("href");
			HttpURLConnection con= (HttpURLConnection)new URL(url).openConnection(); //open connection via this object for that URL
			con.setRequestMethod("HEAD"); //setting a request method
			con.connect(); //making connection
			int resCode = con.getResponseCode(); //it will give response code
			System.out.println(resCode);
			//below one is hard assert so we apply soft assert so that script will not fail when it false
			//Assert.assertTrue(resCode > 400,"The link with "+ link.getText() + " is broken with code "+resCode );
			SA.assertTrue(resCode < 400,"The link with "+ link.getText() + " is broken with code "+resCode );
		}
		
		//for getting report
		SA.assertAll(); //we have to put this at the end so that soft assert can store all fail report
		
		
		
		

	}

}
