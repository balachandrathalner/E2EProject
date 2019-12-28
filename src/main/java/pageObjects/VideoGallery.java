package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VideoGallery {

	public WebDriver driver;
	@FindBy(xpath="//*[@class='title']/div[2]/div/div")
	private WebElement videogallery;
	
	@FindBy(xpath="(//*[@class='col-sm-3'])[2]/h3")
	private WebElement about;
	
	public VideoGallery(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getVideogallery() {
		return videogallery;
	}
	public WebElement getAbout() {
		return about;
	}
	
}
