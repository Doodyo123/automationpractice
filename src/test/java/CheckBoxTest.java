
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
		boolean expected = true;
		
		
		boolean isChecked = new CheckBoxPageObject(driver, baseUrl)
		.openCheckBoxPage()
		.selectCheckBoxOne(checkBoxOneText)
		.unselectCheckBoxTwo(checkBoxTwoText)
		.isCheckBoxClicked();
	
		System.out.println(isChecked);
		Assert.assertEquals(isChecked, expected, "Failed to select checkbox one!");
	}
}
