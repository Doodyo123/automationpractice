import org.testng.Assert;
import org.testng.annotations.Test;

import com.qtx.pages.DropDownPageObject;


public class DropdownListTest extends TestSuperClass{

	// As a user
	// I want to select option 2 from a dropdown list
	// So that some option is selected
	@Test
	public void canSelectFromDrowdown() {
		
		String expectedSelection = "Option 2";
		
		//act
		String actualSelection = new DropDownPageObject(driver, baseUrl)
				.OpenDropdownPage()
				.setDropDownList(expectedSelection)
				.getDropDownListTextValue();

		Assert.assertEquals(actualSelection, expectedSelection, "Failed to click Option 2!");
	}

}
