package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {

    String baseURL = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        //Mouse hover on Laptops and Notebooks Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

        //Click on "Show AllLaptops & Notebooks"
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));

        //Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("(//select[@id='input-sort'])[1]"), "Price (High > Low)");

        //Select Product "Macbook"
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));

        //Verify the text MacBook
        assertEqualsMethod(("Incorrect Text"), "MacBook", By.xpath("//h1[normalize-space()='MacBook']"));

        //Changing currency
        mouseHoverToElement(By.xpath("//span[text()='Currency']"));

        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[text()='Currency']"));

        Thread.sleep(1000);

        //Mouse hover on Pound Sterling and click
        mouseHoverToElement(By.xpath("//button[text()='£Pound Sterling']"));
        Thread.sleep(1000);

        clickOnElement(By.xpath(("//button[text()='£Pound Sterling']")));

        //Click on "Add to Cart" button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //Verify the message "Success: You have added Macbook to your shopping cart!"
        //assertEqualsMethod("Incorrect Message", "Success: You have added MacBook to your shopping cart!\n×", By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        //Click on Link "Shopping cart" display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //Verify the text "Shopping Cart"
        assertEqualsMethod("Wrong Text", "Shopping Cart  (0.00kg)",
                By.xpath("//h1[contains(text(),'Shopping Cart')]"));

        //Verify the Product Name "MacBook"
        assertEqualsMethod("Incorrect Product Name", "MacBook",
                By.xpath("(//a[contains(text(),'MacBook')])[2]"));
        //Change Quantity "2"
        clearTextField(By.xpath("//input[@class='form-control']"));
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@class='form-control']"), "2");

        //Click on Update Tab
        clickOnElement(By.xpath("(//button[@type='submit'])[1]"));

        //Verify the message "Success: You have modified your shopping cart!"
        //assertEqualsMethod("Incorrect Message", "Success: You have modified your shopping cart!\n×",
        // By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        Thread.sleep(2000);

        //Verify the Total £737.45
        assertEqualsMethod("Incorrect Total", "£737.45",
                By.xpath("(//td[contains(text(),'£737.45')])[3]"));
        Thread.sleep(2000);

        //Click on Checkout button
        clickOnElement(By.xpath(("//a[@class='btn btn-primary']")));

        //Verify the text Checkout
        assertEqualsMethod("Incorrect Text", "Checkout", By.xpath("//h1[normalize-space()='Checkout']"));
        Thread.sleep(2000);

        //Verify the Text "New Customer"
        assertEqualsMethod("Incorrect Text", "New Customer",
                By.xpath("//h2[normalize-space()='New Customer']"));
        Thread.sleep(2000);


        //Click on Guest Checkout radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        Thread.sleep(2000);

        //Click on continue tab
        clickOnElement(By.cssSelector("#button-account"));

        //Fill the mandatory fields
        sendTextToElement(By.id("input-payment-firstname"), "Sheldon");
        sendTextToElement(By.id("input-payment-lastname"), "Cooper");
        sendTextToElement(By.id("input-payment-email"), "jack_cooper@gmail.com");
        sendTextToElement(By.id("input-payment-telephone"), "01234567899");
        sendTextToElement(By.id("input-payment-address-1"), "Harley Street");
        sendTextToElement(By.id("input-payment-city"), "London");
        sendTextToElement(By.name("postcode"), "HP6 2BA");
        selectByVisibleTextFromDropDown(By.id("input-payment-country"), "United Kingdom");
        selectByVisibleTextFromDropDown(By.id("input-payment-zone"), "Devon");

        //Click on Continue button
        clickOnElement(By.xpath("//input[@id='button-guest']"));

        //Add comments about your order into the text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"), "Leave it by door please");

        //Check the Terms and Conditions check box
        clickOnElement(By.cssSelector("input[value='1'][name='agree']"));

        //Click on Continue button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

        //Verify the message "Warning: Payment method required!"
        //assertEqualsMethod(("Incorrect warning message", "Warning: You must agree to the Terms & Conditions!\n×",
        //By.xpath("//div[@class ='alert alert-danger alert-dismissible']"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}

