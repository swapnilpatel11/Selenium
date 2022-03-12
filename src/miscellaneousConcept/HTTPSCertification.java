package miscellaneousConcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HTTPSCertification {

	public static void main(String[] args) {
		//Here we handle HTTPS SSL Certification with ChromeOptions/FirefoxOptions/EdgeOptions Class
		//Declare ChromeOptions class
		ChromeOptions options = new ChromeOptions();
		//If we want to add any extension to our automated open browser then we can do by below as well
		//options.addExtensions(FilePath from computer);
		//If we want to add proxy to our browser then we can add it by Proxy class as below for real project
		//Proxy proxy = new Proxy();
		//proxy.setHttpProxy("ipaddress:4444");
		//options.setCapability("proxy", proxy);
		
		options.setAcceptInsecureCerts(true);  //here we are accepting SSL privacy certification
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		driver.getTitle();
		

	}

}
