package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;
import static org.testng.AssertJUnit.assertEquals;

public class DashboardPage {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.elementHelper = new ElementHelper(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    By myInfoButton = By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > aside:nth-child(1) > nav:nth-child(1) > div:nth-child(2) > ul:nth-child(2) > li:nth-child(6) > a:nth-child(1) > span:nth-child(2)");
    By saveButton = By.cssSelector("div[class='orangehrm-horizontal-padding orangehrm-vertical-padding'] button[type='submit']");
    By nameAndSurnameTitle = By.cssSelector(".oxd-userdropdown-name");
    By username = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div.orangehrm-edit-employee-content > div.orangehrm-horizontal-padding.orangehrm-vertical-padding > form > div:nth-child(1) > div > div > div > div.--name-grouped-field > div:nth-child(1) > div:nth-child(2) > input");
    By userSurname = By.cssSelector("input[placeholder='Last Name']");

    public void clickToMyInfo() {
        driver.findElement(myInfoButton).click();
    }

    public void changeNameAndSurname() {
        WebElement user = elementHelper.findElement(username);
        user.sendKeys(Keys.CONTROL + "a");
        user.sendKeys(Keys.DELETE);
        user.sendKeys("Mustafa");

        WebElement surname = elementHelper.findElement(userSurname);
        surname.sendKeys(Keys.CONTROL + "a");
        surname.sendKeys(Keys.DELETE);
        surname.sendKeys("Şahin");

    }

    public void clickToSaveButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        elementHelper.click(saveButton);
    }

    public void checkNewNameAndSurname() {
        elementHelper.click(myInfoButton);
        WebElement newNameAndSurname = driver.findElement(nameAndSurnameTitle);
        String newNameAndSurnameText = newNameAndSurname.getText();
        assertEquals(newNameAndSurnameText, "Mustafa Şahin");
    }
}
