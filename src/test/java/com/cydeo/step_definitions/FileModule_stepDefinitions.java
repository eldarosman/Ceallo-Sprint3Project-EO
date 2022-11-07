package com.cydeo.step_definitions;

import com.cydeo.pages.FileModulePage;
import com.cydeo.pages.LogInPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class FileModule_stepDefinitions {

    //------------------------------------------------------Given
    LogInPage LogInPage = new LogInPage();
    FileModulePage FileModulePage = new FileModulePage();
    Actions action = new Actions(Driver.getDriver());

    @Given("user login and pass to All files")
    public void user_login_and_pass_to_all_files() {
        LogInPage = new LogInPage();
        FileModulePage = new FileModulePage();

        Driver.getDriver().get("https://qa.ceallo.com/index.php");
        LogInPage.usernameInputBox.click();
        LogInPage.usernameInputBox.sendKeys("employee121");
        LogInPage.passwordInputBox.click();
        LogInPage.passwordInputBox.sendKeys("Employee123");
        LogInPage.signInButton.click();

        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        FileModulePage.fileModuleButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        FileModulePage.AllFilesButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //------------------------------------------------------TC1

    @When("user clicks Add to favorites")
    public void user_clicks_add_to_favorites() {
            FileModulePage.folder1Options.click();
            Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            FileModulePage.addToFavoritesButton.click();
            Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("user should be able to see a yellow star right on the folder icon")
    public void user_should_be_able_to_see_a_yellow_star_right_on_the_folder_icon() {
        Assert.assertTrue(FileModulePage.favoriteMark.isEnabled());
    }

    //------------------------------------------------------TC2

    @When("user clicks Rename")
    public void user_clicks_rename() {
        FileModulePage.folder1Options.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        FileModulePage.renameButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @When("user enters a New name for file or folder and presses Enter key")
    public void user_enters_a_new_name_for_file_or_folder_and_presses_enter_key() {
        action.sendKeys("Renamed folder" + Keys.ENTER);
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        FileModulePage.AllFilesButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

 //       String actualFileName = FileModulePage.actualFileName.getText();
 //       System.out.println(FileModulePage.actualFileName.getText());
 //       action.moveToElement(com.cydeo.pages.FileModulePage);
//        action.moveToElement(FileModulePage.renameInputBox).click().perform();
        //FileModulePage.renameInputBox.sendKeys("Renamed folder" + Keys.ENTER);
//        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        action.moveToElement(FileModulePage.renameInputBox).sendKeys("Renamed folder" + Keys.ENTER);
 //       Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }

    @Then("user should be able to see a changed name of file or folder")
    public void user_should_be_able_to_see_a_changed_name_of_file_or_folder() {
        //String existingFileName = FileModulePage.actualFileName.getText();
        //Assert.assertTrue(FileModulePage.actualFileName.getText().equals(existingFileName));
    }

    //-----------------------------------------------------TC3

    @When("user clicks Details")
    public void user_clicks_details() {
        FileModulePage.folder1Options.click();
        FileModulePage.detailsButton.click();
    }

    @When("user clicks Comments")
    public void user_clicks_comments() {
        FileModulePage.commentsButton.click();
    }

    @When("user enters a New comment text for file or folder and presses Enter key")
    public void user_enters_a_new_comment_text_for_file_or_folder_and_presses_enter_key() {
        FileModulePage.commentsInputBox.click();
        String commentText = "I'm writing new comment";
        FileModulePage.commentsInputBox.sendKeys(commentText + Keys.ENTER);
    }

    @Then("user should be able to see a recently written comment")
    public void user_should_be_able_to_see_a_recently_written_comment() {
        String commentText = "I'm writing new comment";
        Assert.assertEquals(FileModulePage.commentText.getText(), commentText);
        //Assert.assertTrue(FileModulePage.commentText.getText().equals(commentText));
    }

    //----------------------------------------------------TC4

    @When("user clicks on three dot icon near the comment that should be deleted")
    public void user_clicks_on_three_dot_icon_near_the_comment_that_should_be_deleted() {
        FileModulePage.folder1Options.click();
        FileModulePage.detailsButton.click();
        FileModulePage.commentsButton.click();
        FileModulePage.commentOptions.click();
        FileModulePage.deleteComment.click();
    }

    @Then("user should be able to see that there is no recently deleted comment")
    public void user_should_be_able_to_see_that_there_is_no_recently_deleted_comment() {
        Assert.assertFalse(FileModulePage.noCommentsYet.isDisplayed());
    }




}
