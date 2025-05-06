package PAGE1;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Skills {
	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Admin']")
	WebElement ADMIN;
	
	@FindBy(xpath = "//span[text()='Qualifications ']")
	WebElement QUALIFICATION;
	
	@FindBy(xpath = "//a[starts-with(text(),'Skills')]")
	WebElement SKILLS;
	
	@FindBy(xpath = "//button[text()=' Add ']")
	WebElement ADDBTN;
	
	@FindBy(xpath = "(//input[@data-v-1f99f73c])[2]")
	WebElement SKILLNAME;
	
	@FindBy(xpath = "//textarea[@placeholder='Type description here']")
	WebElement SKILLDESC;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement SAVEBTN;
	
	
	
	public void driver(WebDriver driver1) {
		this.driver= driver1;
		PageFactory.initElements(driver1, this);
	}
	
	public void go_to_skill_page() throws InterruptedException {

		ADMIN.click();
		Thread.sleep(1000);
		QUALIFICATION.click();
		Thread.sleep(1000);
		SKILLS.click();
		Thread.sleep(1000);

	}
	
	public void user_enters_skills_records_as(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		
        
		List<Map<String,String>> SkillData = dataTable.asMaps(String.class,String.class);
		
		for(int i=0;i<SkillData.size();i++) {
			
			String Skillname = SkillData.get(i).get("Skill");
			String Skilldesc = SkillData.get(i).get("SkillDesc");
	
		ADDBTN.click();
		Thread.sleep(1000);
		SKILLNAME.sendKeys(Skillname);
		Thread.sleep(1000);
		SKILLDESC.sendKeys(Skilldesc);
		Thread.sleep(1000);
		SAVEBTN.click();

		}
	}

}
