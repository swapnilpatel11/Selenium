package locatorTechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RahulShettyPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
			
		    String name = "Swap";
			String pass = "rahulshettyacademy";
		    WebDriver driver =new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/locatorspractice/");
			driver.findElement(By.id("inputUsername")).sendKeys(name);
			driver.findElement(By.name("inputPassword")).sendKeys(pass);
			driver.findElement(By.cssSelector("button[type='submit']")).click();
			Thread.sleep(2000);
			String actual = driver.findElement(By.tagName("p")).getText();
			Assert.assertEquals(actual, "You are successfully logged in.");
			driver.findElement(By.xpath("//button[text()='Log Out']")).click();
			driver.close();


	}

}
