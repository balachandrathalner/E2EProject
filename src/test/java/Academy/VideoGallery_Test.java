package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.VideoGallery;
import resources.base;

public class VideoGallery_Test extends base {
	
	private static Logger log=LogManager.getLogger(ValidateTitle.class.getName());


	@BeforeTest
	public void intialize() throws IOException {
		

		driver=intializeDriver();
log.info("intializing driver");
		
		driver.get(prop.getProperty("url"));
		
		log.info("launching url");
	}
	
	@Test
	public void vidiogallery() throws IOException, InterruptedException {
		
		LandingPage lp=new LandingPage(driver);
		
	log.debug("set the sleep for 10000 mili sec");
		
		Thread.sleep(10000);
		
		log.info("sleep completed");
			
		

			if(driver.findElements(By.xpath("//*[text()='NO THANKS']")).size()>0) {
		
				log.debug("if popup window shown..click no thanks");
				driver.findElement(By.xpath("//*[text()='NO THANKS']")).click();
				log.info("clicked on popup windpow...no thanks ");
			}
			
		
		lp.getVideos().click();
		log.info("clicked on video...");
		
		
		
	VideoGallery vg=new VideoGallery(driver);
	


	
	WebDriverWait wait=new WebDriverWait(driver, 50);
	boolean invisble2=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class='listbuilder-popup-content']")));
	
	
	if(invisble2) {
	
	if(driver.findElements(By.xpath("//*[text()='NO THANKS']")).size()>0) {
		driver.findElement(By.xpath("//*[text()='NO THANKS']")).click();
	}
	
	Assert.assertTrue(vg.getVideogallery().isDisplayed());

	Assert.assertEquals(vg.getAbout().getText(), "ABOUT US1");

	}
		
	}
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
		log.info("driver closed");
	}
}
