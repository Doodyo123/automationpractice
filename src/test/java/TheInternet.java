
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qtx.pages.CheckBoxPageObject;
import com.qtx.pages.DropDownPageObject;
import com.qtx.pages.HorizontalSliderPageObject;
import com.qtx.pages.LoginPageObject;

public class TheInternet extends TestSuperClass{

	// As a user
	// I want to select check the first check box and
	// check the second check box
	// so that the checked boxes are swapped.
	@Test
	public void canClickCheckBoxes() {

		CheckBoxPageObject page = new CheckBoxPageObject(driver, baseUrl)
				.openCheckBoxPage()
				.selectCheckBoxOne();

		boolean checkOne = page.isCheckBoxOneSelected();
		boolean checkTwo = page.isCheckBoxTwoSelected();

		Assert.assertEquals(checkOne, true, "Failed to select checkbox one!");
		Assert.assertEquals(checkTwo, true, "Failed to select checkbox one!");
		
	}

	// As a user
	// I want to log in
	// So users can do stuff
	@Test
	public void canLogIn() {

		String userName = new String("tomsmith");
		String password = new String("SuperSecretPassword!");
		String expectedGreenBoxText = new String("You logged into a secure area!\n×");

		String actualGreenBoxText = new LoginPageObject(driver, baseUrl)
				.OpenLoginPage() //from LoginPageObject
				.login(userName, password) //from LoginPageObject
				.getLoginConfirmationMessage(); // from SecurePageObject

		Assert.assertEquals(actualGreenBoxText , expectedGreenBoxText, "Can not Log in!");

	}

	// As a user
	// I want to select option 2 from a dropdown list
	// So that some option is selected
	@Test
	public void canSelectFromDrowdown() {

		String expectedSelection = "Option 2";

		//act
		String actualSelection = new DropDownPageObject(driver, baseUrl)
				.openDropdownPage()
				.setDropDownList(expectedSelection)
				.getDropDownListTextValue();

		Assert.assertEquals(actualSelection, expectedSelection, "Failed to click Option 2!");
		
	}
	
	// As a user
	// I want to move the slider to the max value
	// So I can prove that I know how to use the Actions builder
	@Test
	public void canMoveSliderToMaxValue() throws InterruptedException {
		
		String expectedSliderValue = "5";
		
		String sliderValue = new HorizontalSliderPageObject(driver, baseUrl)
		.openHorizontalSliderPage()
		.setHorizontalSliderToMax()
		.getSliderValue();
		
		Assert.assertEquals(sliderValue, expectedSliderValue);
		
	}

}
