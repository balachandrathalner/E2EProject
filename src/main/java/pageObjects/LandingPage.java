package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;
	
	@FindBy(linkText="Login")
	private WebElement login;
	
	@FindBy(xpath="//*[@class='text-center']/h2")
	private WebElement title;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']/li[8]/a")
	private WebElement contact;
	
	@FindBy(css="[class='text-center'] a")
	private WebElement viewcourse;
	
	@FindBy(xpath="//*[@class='nav navbar-nav navbar-right'] //li[3]/a")
	WebElement videos;
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getLogin() {
		return login;
	}
	public WebElement getTitle() {
		return title;
	}
	public WebElement getContact() {
		return contact;
	}
	public WebElement getViewCourse() {
		return viewcourse;
	}
	public WebElement getVideos() {
		return videos;
	}
}
