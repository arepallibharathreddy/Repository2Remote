package PAGE1;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;
	
	@FindBy(xpath ="//input[@name='username']")
	WebElement USERNAME;
	
	@FindBy(xpath ="//input[@name='password']")
	WebElement PASSWORD;
	
	@FindBy(xpath ="//button[contains(@class,'oxd-button--medium oxd-button')]")
	WebElement LOGINBTN;

	public void driver(WebDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}

	public void user_enters_url_as(String TestURL) {
		driver.get(TestURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void user_enters_the_credentials(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> Login = dataTable.asMaps(String.class, String.class);

		String Username = Login.get(0).get("username");
		String Password = Login.get(0).get("password");

		USERNAME.sendKeys(Username);
		Thread.sleep(1000);
		PASSWORD.sendKeys(Password);
		Thread.sleep(1000);
		LOGINBTN.click();

	}
	

}
