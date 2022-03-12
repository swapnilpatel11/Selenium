package miscellaneousConcept;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class CookiesDelete {

	public static void main(String[] args) throws IOException {
		//Here we see how can we delete cookies
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); //this step delete all cookies
		//driver.manage().deleteCookieNamed("sessionKey"); //to delete session based cookie
		driver.get("https://google.com");

		//Taking Screenshot
		//we have to convert our driver to screenshot driver by casting to be capable
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //this step capture screenshot in object of FILE
		//then we have to write this line to save file to the local machine
		FileUtils.copyFile(src,new File("C:\\Users\\Swapn\\Downloads\\screenshot.png")); //this step is for giving path to our local to store screenshot
	}

}
