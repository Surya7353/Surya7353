package Testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainData {
	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
     Properties prop=new Properties();
     FileInputStream InputStream = new FileInputStream("F:\\eclipse\\eclipse\\SeleniumProject\\src\\test\\java\\Properties\\test.properties");
     prop.load(InputStream);
 
     String Bvalue=prop.getProperty("browser");
     String BName=Bvalue.toLowerCase();
     
	 String Testlink =prop.getProperty("url");
	 
    
     switch(BName) {
		case "chrome":System.setProperty("webdriver.chrome.driver","F:\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		break;
		
		case "firefox":System.setProperty("webdriver.gecko.driver","F:\\drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		break;
		
		default:break;		
		
		}
        driver.get(Testlink);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
     return driver;
     
	}

}

