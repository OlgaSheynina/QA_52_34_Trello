package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.annotations.Test;

public class AtlassianPage extends BasePage {
    public AtlassianPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 10), this);
    }

    @FindBy(xpath = "//button[@data-testid = 'profile-avatar-dropdown-trigger']")
    WebElement btnProfilePhoto;
    @FindBy(xpath = "//button[@data-testid = 'change-avatar']")
    WebElement btnChangeProfilePhoto;


    public void changeProfilePhoto() {
        Actions actions = new Actions(driver);
        actions.moveToElement(btnProfilePhoto).click().perform();
        clickWait(btnChangeProfilePhoto);
    }
}