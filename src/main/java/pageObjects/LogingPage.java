package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogingPage {
	
	public WebDriver driver;
	
	@FindBy(id="user_email")
	private WebElement username;
	
	@FindBy(id="user_password")
	private WebElement password;
	
	@FindBy(css="input[type='submit']")
	private WebElement login;
	
	public LogingPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
public WebElement clickLogin() {
	return login;
}
}
