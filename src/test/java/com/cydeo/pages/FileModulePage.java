package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileModulePage {

    //From three dots button all web elements array
    //List<WebElement> optionsElements = Driver.getDriver().findElements(By.xpath(""));

    public FileModulePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@href='/index.php/apps/files/'])[1]")
    public WebElement fileModuleButton;

    @FindBy(xpath = "//a[@class='nav-icon-files svg active']")
    public WebElement AllFilesButton;

    @FindBy(xpath = "//tr[@data-file='Folder1']//span[@class='icon icon-more']")
    public WebElement folder1Options;

    @FindBy(xpath = "//tr[@data-file='Folder1']//span[@class='icon icon-more']/../../../..//child::li//span[contains(text(), 'favorites')]")
    public WebElement addToFavoritesButton;

    @FindBy(xpath = "//tr[@data-file='Folder1']//span[@class='icon icon-more']/../../../..//child::li//span[contains(text(), 'favorites')]")
    public WebElement removeFromFavoritesButton;

    @FindBy(xpath = "//tr[@data-file='Folder1']//child::div[@class='favorite-mark permanent']")
    public WebElement favoriteMark;

    @FindBy(xpath = "//tr[@data-file='Folder1']//span[@class='icon icon-more']/../../../..//child::li//span[contains(text(), 'Details')]")
    public WebElement detailsButton;

    @FindBy(xpath = "//tr[@data-file='Folder1']//span[@class='icon icon-more']/../../..")
    public WebElement actualFileName;

    @FindBy(xpath = "//tr[@data-file='Folder1']//span[@class='icon icon-more']/../../../..//child::li//span[contains(text(), 'Rename')]")
    public WebElement renameButton;

    @FindBy(xpath = "//tr[@data-file='Folder1']//span[@class='icon icon-more']/../../../..//child::li//span[contains(text(), 'Delete')]")
    public WebElement deleteButton;
    //*/../../../..//child::li//span[contains(text(), 'Rename')] -at any submenu Rename button

    @FindBy(xpath = "//tr[@data-file='Folder1']//span[contains(text(), 'Folder1')]")
    public WebElement renameInputBox;

    @FindBy(xpath = "//a[@id='commentsTabView']")
    public WebElement commentsButton;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement commentsInputBox;

    @FindBy(xpath = "(//div[@class='message'])[2]")
    public WebElement commentText;

    @FindBy(xpath = "//a[@class='action more icon icon-more has-tooltip']")
    public WebElement commentOptions;

    @FindBy(xpath = "(//a[@class='menuitem action delete permanent'])[2]")
    public WebElement deleteComment;
    
    @FindBy(xpath = "//*[*='No comments yet, start the conversation!']")
    public WebElement noCommentsYet;

    //---------------------------------------------
    @FindBy(xpath = "")
    public WebElement renamedFolder1;


}
