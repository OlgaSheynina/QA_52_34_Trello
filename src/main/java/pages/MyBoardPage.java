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
    @FindBy(xpath = "//button[@class = 'Js3vLl6hOLoP6t CPJ6qEQnd2n6OO bqDBTa8KAMX3yi NJP5k28ExDCtBL']")
    WebElement btnDots;
    @FindBy(xpath = "//div[text() = 'Close board']")
    WebElement btnCloseBoard;
    @FindBy(xpath = "//button[@data-testid = 'popover-close-board-confirm']")
    WebElement btnClose;
    @FindBy(xpath = "//button[text() = 'Permanently delete board']")
    WebElement btnDeleteBoard;
    @FindBy(xpath = "//button[@data-testid = 'close-board-delete-board-confirm-button']")
    WebElement btnDelete;

    public boolean validateBoardName(String text) {
        return isTextInElementPresent(boardName, text);
    }

    public void deleteBoard() {
        clickWait(btnDots);
        clickWait(btnCloseBoard);
        clickWait(btnClose);
       // pause(2000);
        driver.navigate().refresh();
        clickWait(btnDots);
        clickWait(btnDeleteBoard);
        clickWait(btnDelete);

    }
}
