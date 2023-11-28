package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {

    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch
        (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }


    }

    @Test
    //Verify userShouldNavigateToDesktopsPageSuccessfully

    public void userShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {

        //Mouse Hover on Desktops tab and cli
        mouseHoverToElement(By.xpath("//a[normalize-space()='Desktops']"));
        clickOnElement(By.xpath("//a[normalize-space()='Desktops']"));
        Thread.sleep(2000);

        //call selectMenu method and pass the menu = show all desktpos

        selectMenu("Show AllDesktops");
        Thread.sleep(2000);

        //Verify the text desktops
        assertEqualsMethod("Incorrect Text", "Desktops",(By.xpath("//h2[normalize-space()='Desktops']")));
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        //Mouse hover on laptops and notebooks tab and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        clickOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

        //call select menu method and pass the menu = show all laptops and notebooks
        selectMenu("Show AllLaptops& Notebooks");

        //verify the text laptops and notebooks
       assertEqualsMethod("IncorrectText", "Laptops & Notebooks", By.xpath("//h2[normalize-space()='Laptops & Notebooks']"));


    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //Mouse hover on components tab and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Components']"));
        clickOnElement(By.xpath("//a[normalize-space()='Components']"));

        //call selectMenu method and pass the menu = show all components

        selectMenu("Show AllComponents");

        //Verify the text computers
        assertEqualsMethod("Incorrect components", "Components", By.xpath("//h2[normalize-space()='Components']"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}



