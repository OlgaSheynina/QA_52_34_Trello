package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MyBoardPage extends BasePage {

    public MyBoardPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 10), this);
    }

    @FindBy(xpath = "//h1[@data-testid = 'board-name-display']")
    WebElement boardName;
    @FindBy(xpath = "//button[@aria-label='Show menu' or contains(@class, 'icon-overflow-menu-horizontal')]")
    WebElement btnDots;
    @FindBy(xpath = "//div[text() = 'Close board']")
    WebElement btnCloseBoard;
    @FindBy(xpath = "//button[@data-testid = 'popover-close-board-confirm']")
    WebElement btnClose;
    @FindBy(xpath = "//button[@aria-label = 'Show menu']")
    WebElement btnDots1;

    public boolean validateBoardName(String text) {
        return isTextInElementPresent(boardName, text);
    }

    public void deleteBoard() {
        clickWait(btnDots);
        clickWait(btnCloseBoard);
        btnClose.click();
        clickWait(btnDots1);

    }
}
