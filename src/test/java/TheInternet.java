
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtx.pages.CheckBoxPageObject;
import com.qtx.pages.DropDownPageObject;
import com.qtx.pages.HorizontalSliderPageObject;
import com.qtx.pages.InputPage;
import com.qtx.pages.JavaScriptAlertPage;
import com.qtx.pages.LoginPageObject;
import com.qtx.pages.JqueryMenuPageObject;
import com.qtx.pages.HomePageObject;

public class TheInternet extends TestSuperClass{

	// As a user
	// I want to select check the first check box and
	// check the second check box
	// so that the checked boxes are swapped.
	@Test
	public void canClickCheckBoxes() {

		CheckBoxPageObject page = new CheckBoxPageObject(driver, baseUrl)
				.openCheckBoxPage()
				.selectCheckBoxOne()
				.selectCheckBoxTwo();

		boolean checkOne = page.isCheckBoxOneSelected();
		boolean checkTwo = page.isCheckBoxTwoSelected();

		Assert.assertEquals(checkOne, true, "Failed to select checkbox one!");
		Assert.assertEquals(checkTwo, false, "Failed to select checkbox two!");

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
	public void canMoveSliderToMaxValue() {

		HorizontalSliderPageObject page = new HorizontalSliderPageObject(driver, baseUrl);


		float sliderValue = page
				.openHorizontalSliderPage()
				.setHorizontalSliderToMax()
				.getSliderValue();


		float expectedSliderValue = page.getSliderMaxValue();

		Assert.assertEquals(sliderValue, expectedSliderValue);

	}

	// As a user
	// I want to enter values in the input box
	// So I can prove I know how to use data provider
	@Test(dataProvider="numberData")
	public void canInputNumbers(int number) {

		int actualNumberInput = new InputPage(driver, baseUrl)
				.navigate()
				.setInputValue(number)
				.getInputValue();

		Assert.assertEquals(actualNumberInput, number);
	}

	@DataProvider(name = "numberData")
	public Object[] getNumberData() {
		return new Object[] { 2, 3, 5, 8, 13 };
	}

	// As a user
	// I want to be able to click Best Sellers
	// So that I can view the best selling products
	@Test
	public void canViewBestSellers() {
		boolean expectedButtonSelected = true;

		boolean buttonSelected = new HomePageObject(driver, otherUrl )
				.openHomePage()
				.getButtonOne()
				.getButtonTwo()
				.isButtonSelected();

		System.out.println(buttonSelected);
		Assert.assertEquals(buttonSelected, expectedButtonSelected);
	}

	// As a user
	// I want to be able to click the last item in the menu path and wait for the file to download
	// So that I can prove I know how to choose the last item on a menu
	@Test
	public void canClickLastMenuItem() {

		String fileName = "C:\\Users\\Deric\\Downloads\\menu.xls";

		boolean downloadedFile = new JqueryMenuPageObject(driver, baseUrl)
				.openMenuPage()
				.clickItemByMenuPath(new String[] {"Enabled", "Downloads", "Excel"})
				.getDownloadedFile(fileName);

		Assert.assertEquals(downloadedFile, true);
	}

	// As a user
	// I want to click a button
	// So that i can handle the JS Alert
	@Test
	public void canClickJSAlertButton() {
		String expectedText = "You successfuly clicked an alert";

		String actualText = new JavaScriptAlertPage(driver, baseUrl)
				.openJavaScriptAlertsPage()
				.clickJSAlertButton()
				.getResultText();

		Assert.assertEquals(actualText, expectedText);
	}

	// As a user
	// I want to click a button
	// So that i can handle the JS Confirm
	@Test
	public void canClickJSConfirmButton() {
		String expectedText = "You clicked: Ok";

		String actualText = new JavaScriptAlertPage(driver, baseUrl)
				.openJavaScriptAlertsPage()
				.clickJSConfirmButton()
				.getResultText();

		Assert.assertEquals(actualText, expectedText);
	}

	// As a user
	// I want to click a button
	// So that i can handle the JS Prompt
	@Test
	public void canClickJSPromptButton() {
		String text = "Hello";
		String expectedText = "You entered: " + text;

		String actualText = new JavaScriptAlertPage(driver, baseUrl)
				.openJavaScriptAlertsPage()
				.clickJSPromptButton(text)
				.getResultText();

		Assert.assertEquals(actualText, expectedText);
	}



}
