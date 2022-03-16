package selenium4;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindow {

	public static void main(String[] args) throws IOException {
		//Here is Scenario we will achieve through automation
		//In practice page name field we enter the name of course which is first on rahulshetty academy website
		//we will open first practice project page
		//handling multiple window and invoking multiple window are different
		//here we are performing invoking multiple windows
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB); //open new tab in browser
		Set<String> handles = driver.getWindowHandles(); //collect windows opened
		Iterator<String> it = handles.iterator(); //Using iterator method to switch between windows
		String parentWindowId = it.next();
		String childWindowId = it.next();
		
		driver.switchTo().window(childWindowId); //switch to new tab
		driver.get("https://rahulshettyacademy.com/#/index");
		//grab first course name via index
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		
		driver.switchTo().window(parentWindowId); //switch back to main website
		WebElement name = driver.findElement(By.cssSelector("input[name='name']"));
		name.sendKeys(courseName);
		//Now we want to capture partial screenshot of page
		File file = name.getScreenshotAs(OutputType.FILE); //capture screenshot
		
		FileUtils.copyFile(file, new File("logo.png")); //convert into physical file which can be seen as logo.png in our project once refresh
		
		//Getting height and width of WebElement name editBox
		name.getRect().getDimension().getHeight();  //get the height
		name.getRect().getDimension().getWidth();  //get the width
		
	}

}
