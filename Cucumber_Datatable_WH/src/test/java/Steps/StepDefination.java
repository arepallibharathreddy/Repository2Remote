package Steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PAGE1.Login;
import PAGE1.Logout;
import PAGE1.Skills;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefination {
	
		WebDriver driver;
		
		Login lp;
		Skills sp;
		Logout op;

	@Given("User Launches Chrome Browser")
	public void user_launches_chrome_browser() {
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		
	}

	@Then("User Enters URL as {string}")
	public void user_enters_url_as(String TestURL) {
		 lp = new Login();
		 lp.driver(driver);
		 lp.user_enters_url_as(TestURL);
	}

	@Then("user enters the credentials")
	public void user_enters_the_credentials(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		lp.user_enters_the_credentials(dataTable);
	}

	@Then("go to skill page")
	public void go_to_skill_page() throws InterruptedException {
		sp = new Skills();
		sp.driver(driver);
		sp.go_to_skill_page();
	}

	@Then("user enters skills records as")
	public void user_enters_skills_records_as(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		sp.user_enters_skills_records_as(dataTable);
	}

	@Then("user clicks logout button")
	public void user_clicks_logout_button() throws InterruptedException {
		op = new Logout();
		op.driver(driver);
		op.user_clicks_logout_button();
	}

	@Then("user close the browser")
	public void user_close_the_browser() throws InterruptedException {
		op.user_close_the_browser();
	}

}
