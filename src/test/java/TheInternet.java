
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtx.pages.CheckBoxPageObject;
import com.qtx.pages.DropDownPageObject;
import com.qtx.pages.FramePageObject;
import com.qtx.pages.HorizontalSliderPageObject;
import com.qtx.pages.InputPage;
import com.qtx.pages.JavaScriptAlertPage;
import com.qtx.pages.LoginPageObject;
import com.qtx.pages.DownloadPageObject;
import com.qtx.pages.HoverPageObject;
import com.qtx.pages.InfiniteScrollPageObject;
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
	// Homework 1.a
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
	// HomeWork 2.a
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
	// Homework 2.b
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
	// Homework 2.c
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

	// As a user
	// I want to get the text from each frame
	// So that I can prove i know wow to get texts from a frame
	// Homework 3.a
	@Test
	public void canGetTextFromFrame() {
		String frames[] = new String[4];
		String expected[] = {"LEFT", "MIDDLE", "RIGHT", "BOTTOM"};
		
		frames = new FramePageObject(driver, baseUrl)
				.openFramePage()
				.getFrameText();
		
		Assert.assertEquals(frames, expected);
	}
	
	// As a user
	// I want to click the profile link
	// so that I can navigate to my profile
	// Homework 4
	@Test
	public void canSelectProfileThree() {
		String expectedUrl = "http://the-internet.herokuapp.com/users/3";
		
		String actualUrl =	new HoverPageObject(driver, baseUrl)
		.openHoverPage()
		.hoverToFigureThree()
		.selectProfileThree();
		
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	// As a user 
	// I want to download the text file
	// So that I can print the output
	// Homework 5
	@Test
	public void canDownloadTextFile() {
		String expectedText = "check";
		
		String actualText = new DownloadPageObject(driver, baseUrl)
		.openDownloadPage()
		.selectTextFile()
		.getTextFileText();
		
		Assert.assertEquals(actualText, expectedText);
		
	}
	
	// As a user
	// I want to scroll and grab the first dynamic paragraph
	// So that I know how to handle infinite scroll
	// Homework 6 - contains grouped elements
	@Test 
	public void canPrintText() {
		boolean expected = true;
		
		boolean didPrint = new InfiniteScrollPageObject(driver, baseUrl)
		.openInfiniteScrollPage()
		.scrollDown()
		.getFirstDynamicParagraph()
		.printDynamicText();
		
		Assert.assertEquals(actual, expected);
		
		
	}

	
}
