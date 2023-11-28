package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.time.Duration;
import java.util.List;



    /**
     * 1. Create class “DesktopsTest”
     * Write the following Test:
     * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
     * 1.1 Mouse hover on Desktops Tab.and click
     * 1.2 Click on “Show All Desktops”
     * 1.3 Select Sort By position "Name: Z to A"
     * 1.4 Verify the Product will arrange in Descending order.
     * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
     * 2.1 Mouse hover on Currency Dropdown and click
     * 2.2 Mouse hover on £Pound Sterling and click
     * 2.3 Mouse hover on Desktops Tab.
     * 2.4 Click on “Show All Desktops”
     * 2.5 Select Sort By position "Name: A to Z"
     * 2.6 Select product “HP LP3065”
     * 2.7 Verify the Text "HP LP3065"
     * 2.8 Select Delivery Date "2023-11-27"
     * 2.9.Enter Qty "1” using Select class.
     * 2.10 Click on “Add to Cart” button
     * 2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
     * 2.12 Click on link “shopping cart” display into success message
     * 2.13 Verify the text "Shopping Cart"
     * 2.14 Verify the Product name "HP LP3065"
     * 2.15 Verify the Delivery Date "2023-11-27"
     * 2.16 Verify the Model "Product21"
     * 2.17 Verify the Todat "£74.73"
     */
    public class DesktopsTest extends Utility {

        String baseURL = "http://tutorialsninja.com/demo/index.php?";

        @Before
        public void setup() {
            openBrowser(baseURL);
        }

        @Test
        public void verifyProductArrangeInAlphabeticalOrder() {
            //1.1 Mouse hover on Desktops Tab.and click
            mouseHoverToElementAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));
            //1.2 Click on “Show All Desktops”
            clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
            //1.3 Select Sort By position "Name: Z to A"
            selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
            //1.4 Verify the Product will arrange in Descending order.
            assertEqualsMethod("Incorrect order", "Name (Z - A)", By.xpath("//option" +
                    "[@value='https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=DESC']"));
        }

        @Test
        public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //2.1 Mouse hover on Currency Dropdown and click
            mouseHoverToElementAndClick(By.xpath("//i[@class='fa fa-caret-down']"));
            //2.2 Mouse hover on £Pound Sterling and click
            mouseHoverToElementAndClick(By.xpath("//button[normalize-space()='£Pound Sterling']"));
            //2.3 Mouse hover on Desktops Tab.
            mouseHoverToElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));
            //2.4 Click on “Show All Desktops”
            clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
            //2.5 Select Sort By position "Name: A to Z"
            selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");
            //2.6 Select product “HP LP3065”
            clickOnElement(By.xpath("//img[@title='HP LP3065']"));
            //2.7 Verify the Text "HP LP3065"
            assertEqualsMethod("Incorrect Text", "HP LP3065",
                    By.xpath("//h1[normalize-space()='HP LP3065']"));
            //2.8 Select Delivery Date "2023-11-27"
            Thread.sleep(2000);
            clearTextField(By.xpath("//input[@id='input-option225']"));
            sendTextToElement(By.xpath("//input[@id='input-option225']"), "2024-11-27");
            String year = "2023";
            String month = "November";
            String date = "27";
            clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
            while (true) {
                String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
                String[] arr = monthAndYear.split(" ");
                String mon = arr[0];
                String yer = arr[1];
                if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                    break;
                } else {
                    clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
                }
            }
            List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
            for (WebElement e : allDates) {
                if (e.getText().equalsIgnoreCase(date)) {
                    e.click();
                    break;
                }
            }
            //2.9.Enter Qty "1” using Select class.
            clearTextField(By.id("input-quantity"));
            Thread.sleep(2000);
            sendTextToElement(By.id("input-quantity"),"1");
            //2.10 Click on “Add to Cart” button
            clickOnElement(By.id("button-cart"));
            //2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
            assertEqualsMethod("Incorrect Message", "Success: You have added HP LP3065 to your " +
                    "shopping cart!\n×", By.xpath("//div[@class='alert alert-success alert-dismissible']"));
            //2.12 Click on link “shopping cart” display into success message
            Thread.sleep(2000);
            clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
            //2.13 Verify the text "Shopping Cart"
            Thread.sleep(2000);
            Assert.assertEquals("Shopping Cart  (1.00kg)", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")));

            //2.14 Verify the Product name "HP LP3065"
            assertEqualsMethod("Incorrect Product Name", "HP LP3065",
                    By.xpath(("(//a[contains(text(),'HP LP3065')])[2]")));
            //2.15 Verify the Delivery Date "2023-11-27"
            assertEqualsMethod("Incorrect Date", "Delivery Date:2023-11-27",
                    By.xpath("//small[normalize-space()='Delivery Date:2023-11-27']"));

            //2.16 Verify the Model "Product21"
            assertEqualsMethod("Incorrect Model", "Product 21", By.xpath("" +
                    "//td[normalize-space()='Product 21']"));
            //2.17 Verify the Total "£74.73"
            Thread.sleep(2000);
            verifyTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]"), "£74.73");
        }

        @After
        public void tearDown() {
            closeBrowser();
        }
    }
