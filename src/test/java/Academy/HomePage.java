package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LogingPage;
import resources.base;

public class HomePage extends base {
	private static Logger log=LogManager.getLogger(ValidateTitle.class.getName());

	
	@BeforeTest
	public void intialize() throws IOException {
		driver=intializeDriver();

		log.info("intializing driver");
		
	}
	
	@Test(dataProvider="getdata")
	public void navigationHomepage(String username,String password) throws IOException {

		
		driver.get(prop.getProperty("url"));
		
		log.info("url is invoked");
	
		
		LandingPage lp=new LandingPage(driver);
		lp.getLogin().click();
	
		log.info("clicked on login button of landing page");
		
			
		LogingPage l=new LogingPage(driver);
		l.getUsername().sendKeys(username);
		l.getPassword().sendKeys(password);
		l.clickLogin().click();
		log.info("sented username and password and clicked on loginn button of login page");

		
	}
	@DataProvider()
		
		public Object[][] getdata() {
			
			Object[][]data=new Object[3][2];
			data[0][0]="abc@gmail.com";
			data[0][1]="65656";		
					
			data[1][0]="dsgvsgabc@gmail.com";
			data[1][1]="38o2ky";
			
			data[2][0]="hkdjabashoc@gmail.com";
			data[2][1]="ihiw89437";
			
			return data;
		}
		
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
		
		log.info("driver object closed");
	}
	
	}

