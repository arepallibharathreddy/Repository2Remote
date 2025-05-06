package PAGE1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
	
	WebDriver driver;
	
	@FindBy(xpath="//p[@data-v-bdd6d943]")
	WebElement PROFILE;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement LOGOUT;
	
	public void driver(WebDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}
	
	public void user_clicks_logout_button() throws InterruptedException {
		PROFILE.click();
		Thread.sleep(3000);
	}

	public void user_close_the_browser() throws InterruptedException {
		LOGOUT.click();
		Thread.sleep(5000);
	}

}
