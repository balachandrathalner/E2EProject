package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public static WebDriver driver;
	public Properties prop;
	public WebDriver intializeDriver() throws IOException {
		
		prop=new Properties();
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Talaneru\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		//String browserName=prop.getProperty("browser");
		
		//maven commond to run browser : mvn test -Dbrowser=chrome
		
		String browserName=System.getProperty("browser");
		
		System.out.println(browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "E:\\software\\chrome_driver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "E:\\software\\gecko_driver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")) {
			
		}
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		
	}

	public void getScreenShot(String result) throws IOException {

		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String path=System.getProperty("user.dir");
		
		FileUtils.copyFile(src, new File(path+"\\FailedTest_ScreenShot\\"+result+"_ScreenShot.png"));
		
		
	}
	
}
