import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownListTest extends TestSuperClass{

	// As a user
	// I want to select option 2 from a dropdown list
	// So that some option is selected
	@Test
	public void canSelectFromDrowdown() {
		//TODO navigate to the dropdown page.

		String expectedSelection = "Option 2";

		//WebElement dropDown = driver.findElement(By.id("dropdown"));
		//WebElement secondOption = driver.findElement(By.linkText("Option 2"));

		Select customerDropDownList = new Select(driver.findElement(By.id("dropdown")));
		customerDropDownList.selectByIndex(2);

		//dropDown.click();
		//secondOption.click();

		String actualSelection = customerDropDownList.getFirstSelectedOption().getText();

		Assert.assertEquals(actualSelection, expectedSelection, "Failed to click Option 2!");
	}

}
