package pages;

import dto.Board;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BoardsPage extends BasePage {

    public BoardsPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 10), this);
    }

    @FindBy(xpath = "//button[@data-testid= 'create-board-tile']")
    WebElement btnCreateNewBoard;
    @FindBy(xpath = "//button[@data-testid='create-board-button']")
    WebElement btnCreateBoard;
    @FindBy(xpath = "//input[@data-testid='create-board-title-input']")
    WebElement inputBoardTitle;
    @FindBy(xpath = "//button[@data-testid='create-board-submit-button']")
    WebElement btnCreate;
    @FindBy(xpath = "//h3[text() = 'Board deleted.']")
    WebElement popUpMassageBoardDeleted;
    @FindBy(xpath = "//button[@data-testid = 'header-member-menu-button']")
    WebElement btnAccount;
    @FindBy(xpath = "//span[text() = 'Manage account']")
    WebElement btnManageAccount;


    public void openMyAccount() {
        clickWait(btnAccount);
        clickWait(btnManageAccount);
    }

    public boolean validatePopUpMassageBoardDeleted(String text) {
        return isTextInElementPresent(popUpMassageBoardDeleted, text);
    }

    public boolean isButtonCreateNotClickable() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .not(ExpectedConditions.elementToBeClickable(btnCreate)));
    }

    public void clickBtnCreateNewBoard() {
        btnCreateNewBoard.click();
    }

    public void clickBtnCreateBoard() {
        clickWait(btnCreateBoard);
    }

    public void typeBoardTitle(Board board) {
        clickWait(inputBoardTitle);
        inputBoardTitle.sendKeys(board.getBoardTitle());
    }

    public void clickBtnCreate() {
        btnCreate.click();
    }
}