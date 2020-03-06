
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qtx.pages.CheckBoxPageObject;

public class CheckBoxTest extends TestSuperClass{
  
	// As a user
	// I want to select check the first check box and
	// check the second check box
	// so that the checked boxes are swapped.
	
	@Test
	public void canClickCheckBoxes() {
		String checkBoxOneText = "checkbox 1";
		String checkBoxTwoText = "checkbox 2";
		
		
		CheckBoxPageObject page = new CheckBoxPageObject(driver, baseUrl)
		.openCheckBoxPage()
		.selectCheckBox(checkBoxOneText)
		.selectCheckBox(checkBoxTwoText);
		
		boolean check1 = page.isCheckBoxClicked(checkBoxOneText);
		boolean check2 = page.isCheckBoxClicked(checkBoxTwoText);
	
		Assert.assertEquals(check1, true, "Failed to select checkbox one!");

		Assert.assertEquals(check2, false, "Failed to select checkbox one!");
	}
}
