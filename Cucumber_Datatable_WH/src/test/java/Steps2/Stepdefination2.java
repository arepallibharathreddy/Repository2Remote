package Steps2;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Stepdefination2 {
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
	@Then("User enters a Credentials")
	public void user_enters_a_credentials(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
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
	@Then("user clicks a admin button")
	public void user_clicks_a_admin_button() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(2000);
	    
	}
	@Then("user clicks a Nationality button")
	public void user_clicks_a_nationality_button() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Nationalities']")).click();
		Thread.sleep(2000);
	}
	@Then("it Goes to nationality page")
	public void it_goes_to_nationality_page() {
	    
	}
	@Then("user enters nationality records")
	public void user_enters_nationality_records(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String,String>> NationData = dataTable.asMaps(String.class,String.class);
		
		for(int i=0;i<NationData.size();i++) {
			
		String NATIONNAME = NationData.get(i).get("Nationname");
		
		
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[starts-with(@class,'oxd-input')])[2]")).sendKeys(NATIONNAME);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
		Thread.sleep(2000);
		}
	    
	}
	
	
}
