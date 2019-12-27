package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateTitle extends base {
	
	private static Logger log=LogManager.getLogger(ValidateTitle.class.getName());
	
	@BeforeTest
	public void intialize() throws IOException {
		

		driver=intializeDriver();
		System.out.println(driver);
		log.info("driver is intialized");
		
		driver.get(prop.getProperty("url"));
		log.info("browser is lounched");
	}
	
	@Test(priority=0)
	public void navigationHomepage() throws IOException  {
		
		
		LandingPage lp=new LandingPage(driver);
		log.debug("will comparing actual and expected");
		
		String actual=lp.getTitle().getText();
	
		Assert.assertEquals(actual, "FEATURED COURSES");
		
		log.info("actual and expected are matched");
		
		Assert.assertTrue(lp.getContact().isDisplayed());

		log.info("contact is displayed");
		Assert.assertTrue(false);
	}
	

	
	@Test(priority=1)
	public void videos() throws InterruptedException {
		LandingPage lps=new LandingPage(driver);

		Thread.sleep(3000);
		
		if(driver.findElements(By.xpath("//*[text()='NO THANKS']")).size()>0) {
			driver.findElement(By.xpath("//*[text()='NO THANKS']")).click();

		
				lps.getVideos().click();
				log.info("clicked on videos....");
		}
			
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
		
		log.info("driver object is closed");
	}
	
	
}
