package Steps1;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefination1 {
	WebDriver driver;

	@Given("User Launches Chrome Browser")
	public void user_launches_chrome_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Then("User Enters URL as {string}")
	public void user_enters_url_as(String TestURL) {
		driver.get(TestURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Then("user enters the Credentials")
	public void user_enters_the_credentials(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String,String>> Login = dataTable.asMaps(String.class,String.class);
		
		String USERNAME = Login.get(0).get("username");
		String PASSWORD = Login.get(0).get("password");
		

		// Login
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class,'oxd-button--medium oxd-button')]")).click();
		Thread.sleep(2000);
	}

	@Then("it goes to job page")
	public void it_goes_to_job_page() throws InterruptedException {
		// admin
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(2000);
		// job
		driver.findElement(By.xpath("//span[text()='Job ']")).click();
		Thread.sleep(2000);
		// job titles
		driver.findElement(By.xpath("//a[text()='Job Titles']")).click();
		Thread.sleep(2000);

	}

	@Then("user enters job records")
	public void user_enters_job_records(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String,String>> JobData = dataTable.asMaps(String.class,String.class);
		
		for(int i=0;i<JobData.size();i++) {
			
			String JOBNAME = JobData.get(i).get("jobname");
			String JOBDESC = JobData.get(i).get("jobdesc");
			String JOBNOTES = JobData.get(i).get("jobnotes");
			

		// add
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		Thread.sleep(2000);
		// job title
		driver.findElement(By.xpath("(//input[starts-with(@class,'oxd-input oxd-input')])[2]")).sendKeys(JOBNAME);
		Thread.sleep(2000);
		// job desc
		driver.findElement(By.xpath("(//textarea[contains(@class,'oxd-textarea--active')])[1]")).sendKeys(JOBDESC);
		Thread.sleep(2000);
		// add note
		driver.findElement(By.xpath("//textarea[@placeholder='Add note']")).sendKeys(JOBNOTES);
		Thread.sleep(2000);
		// save
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		}
	}

	@Then("user clicks logout button")
	public void user_clicks_logout_button() {

	}

}
