package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;
import java.util.UUID;

public class MyAccountsTest extends Utility {

    String baseURL = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    public void selectMyAccountOptions(String option) {

        //This method should click on the options whatever name is passed as parameter
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//ul[@class = 'list-inline']//a"));
        for (WebElement names : topMenuNames) {
            System.out.println(names.getText());
            if (names.getText().equalsIgnoreCase(option)) {
                names.click();
                break;

            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //Click on My account link
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        selectMyAccountOptions("Register");

        //Verify the text returning customer
        assertEqualsMethod("Incorrect Option", "Register Account",
                By.xpath("//h1[normalize-space()='Register Account']"));


    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //click on my account link
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //call the method and pass the parameter login
        selectMyAccountOptions("Login");

//Verify the text Returning customer
        assertEqualsMethod("Incorrect Text", "Returning Customer",
                By.xpath("//h2[normalize-space()='Returning Customer']"));

    }

    @Test
    public void verifyThatUserShouldRegisterAccountSuccessfully() {
        //click on my account link
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //call the method and pass the parameter register
        selectMyAccountOptions("Register");

        //Enter first name
        sendTextToElement(By.id("input-firstname"), "Ben");

        //Enter last name
        sendTextToElement(By.id("input-lastname"), "Stokes");

        //Enter Email
        final String randomEmail = randomEmail();
        sendTextToElement(By.id("input-email"), randomEmail);

        //Enter telephone
        sendTextToElement(By.id("input-telephone"), "0145456789");

        //Enter password
        sendTextToElement(By.id("input-password"), "12345678");

        //confirm password
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "12345678");

        //Select subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));

        //click on privacy policy check box
        clickOnElement(By.cssSelector("input[value='1'][name='agree']"));

        //click on continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //verify the message "Your account has been created!"
        assertEqualsMethod("Incorrect message", "Your Account Has Been Created!",
                By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));

        //click on continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        //click on my account link
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //call the method method and pass the parameter "Logout"
        selectMyAccountOptions("Logout");

        //Click on continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //click on my account link
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //call the method and pass the parameter "Login"
        selectMyAccountOptions("Login");

        //Enter email address
        sendTextToElement(By.id("input-email"), "ben_stokes01@gmail.com");

        //Enter password
        sendTextToElement(By.id("input-password"), "12545678");

        //Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));

        //verify text my account
        assertEqualsMethod("Incorrect Text", "My Account", By.xpath("//h2[normalize-space()='My Account']"));

        //click on my account link
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //call the method and pass the parameter logout
        selectMyAccountOptions("Logout");

        //verify the text account logout
        assertEqualsMethod("Incorrect Text", "Logout", By.xpath("//a[normalize-space()='Logout']"));

        //click on continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@gmail.com";

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}




