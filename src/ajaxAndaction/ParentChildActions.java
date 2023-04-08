package ajaxAndaction;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentChildActions {

	public static void main(String[] args) {
		//Parent child actions
		//Here we open login page click on link and for email id we go to new tab and then grab email from that id and put it in back to login page
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//This step collects all child windows open by click on link
		Set<String> windows = driver.getWindowHandles(); //[parentid,child id]
		//Now we use iterator to go to next window open by click on link
		Iterator<String> it = windows.iterator();
		String parentId = it.next(); //this step move to next id of opened pages or tabs
		String childId = it.next();
		driver.switchTo().window(childId);
		//Extract emailID from Paragraph String from child window
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split(" ")[4].trim();
		driver.switchTo().window(parentId);
		driver.findElement(By.cssSelector("#username")).sendKeys(emailId);
		

	}

}
