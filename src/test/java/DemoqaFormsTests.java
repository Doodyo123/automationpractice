
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtx.pages.AutomationPracticeFormPageObject;


import data.userData;

public class DemoqaFormsTests extends TestSuperClass {
	
	// As a user I want to input my first and last name
	// so that I can know how to input my first and last name
	@Test (dataProvider = "userData")
	public void canInputFirstAndLastName(userData John) {
		
		
		John.getLastName();
		new AutomationPracticeFormPageObject(driver, demoqaFormsUrl) 
		.openAutomationWebPage()
		.inputFirstName(John.getFirstName())
		.inputLastName(John.getLastName());
	}
	
	@DataProvider (name = "userData")
	public Object[] getUserData() {
		
		userData John = new userData();
		John.setFirstName("John");
		John.setLastName("Doe");
		
		return new Object[] {John};
	}
	
	
}
