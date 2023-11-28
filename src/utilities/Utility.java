package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    /**
     * This method will get text from element
     */

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method will send text to the element
     */

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will click on any element what ever locator you pass it
     */

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method will use to hover mouse on element and click on it
     */

    public void mouseHoverToElementAndClick(By by) {
        WebElement action = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(action).click().perform();
    }

    /**
     * This method will use to hover mouse on element
     */

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        actions.moveToElement(mouseHoover).build().perform();
    }

    /**
     * This method will select visible text from dropdown menu
     */

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        //create obj
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    /**
     * This method will select the value from the dropdown menu
     */
    public void selectByValue(By by, String value) {
        WebElement dropDown1 = driver.findElement(by);
        Select select = new Select(dropDown1);
        select.selectByValue(value);
    }


    public void verifyTextFromElement(By by, String expectedText) {
        WebElement actualText = driver.findElement(by);
        String actual = actualText.getText();
        Assert.assertEquals(expectedText, actual);
    }

    /**
     * This method will verify the expected and actual result
     */

    public void assertEqualsMethod(String message, String expected, By by) {
        String actual = getTextFromElement(by);
        Assert.assertEquals(" ", expected, actual);
    }

    public void clearTextField(By by) {
        driver.findElement(by).clear();

    }

}




