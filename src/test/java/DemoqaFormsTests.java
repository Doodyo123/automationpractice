
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtx.pages.AutomationPracticeFormPageObject;

import data.People;
import data.userData;

public class DemoqaFormsTests extends TestSuperClass {
	
	// As a user I want to input my first and last name
	// so that I can know how to input my first and last name
	@Test (dataProvider = "userData")
	public void canInputFirstAndLastName(userData John) {
		boolean expected = true;
		
		boolean actual = new AutomationPracticeFormPageObject(driver, demoqaFormsUrl) 
		.openAutomationWebPage()
		.inputFirstName(John.getFirstName())
		.inputLastName(John.getLastName())
		.isFirstNameAndLastNameFilled();
		
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider (name = "userData")
	public Object[] getUserData() {
		
		userData John = new userData();
		John.setFirstName("John");
		John.setLastName("Doe");
		
		return new Object[] {John};
	}
	
	// As a user I want to fill all the information 
	// so that i can know how to use a data class
	@Test
	public void canFillAllInformation() {
		
		userData John = People.getJohnInfo();
		boolean expected = true;
		boolean actual = new AutomationPracticeFormPageObject(driver, demoqaFormsUrl)
		.openAutomationWebPage()
		.inputFirstName(John.getFirstName())
		.inputLastName(John.getLastName())
		.selectGender(John.getGender())
		.selectYearsOfExperience(John.getYearsOfExperience())
		.inputDate(John.getDate().toString())
		.selectProfession(John.getProfession())
		.selectAutomationTool(John.getAutomationTool())
		.selectContinent(John.getContinent())
		.selectMultipleContinents(John.getContinentList())
		.selectSeleniumCommand(John.getSeleniumCommands())
		.areFieldsCompleted();
		
		Assert.assertEquals(actual, expected);
	}
}
