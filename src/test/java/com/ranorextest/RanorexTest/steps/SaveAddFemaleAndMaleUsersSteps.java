package com.ranorextest.RanorexTest.steps;

import com.ranorextest.Category;
import com.ranorextest.RanorexTest.webdriver.WebDriverFactory;
import com.ranorextest.pageobject.HomePage;
import com.ranorextest.pageobject.ModalDialogOKPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Тёма on 29.12.2014.
 */
public class SaveAddFemaleAndMaleUsersSteps {
    HomePage homePage = PageFactory.initElements(WebDriverFactory.getWebDriver(),HomePage.class);
    ModalDialogOKPage modalDialogOKPage = PageFactory.initElements(WebDriverFactory.getWebDriver(), ModalDialogOKPage.class);

    @Given("Open ranorex")
    public void getUrlHome(){
        homePage.getUrlHome();
    }

    @When("Save add users")
    public void chooseCategories(){
        for (Category category: homePage.categories()){
            String categoryName = category.getСategory();
            homePage.getWebElementCategory(categoryName).click();
            homePage.enterFirstName();
            homePage.enterLastName();
            homePage.chooseFemale();
            homePage.addUser();
            homePage.enterFirstName();
            homePage.enterLastName();
            homePage.chooseMale();
            homePage.addUser();
        }
        homePage.saveVIPUser();
    }

    @Then("Confirm save users")
    public void confirmSaveUsers(){
        Set<String> windowId = WebDriverFactory.getWebDriver().getWindowHandles();
        Iterator<String> itererator = windowId.iterator();
        String mainWinID = itererator.next();
        String  newAdwinID = itererator.next();
        WebDriverFactory.getWebDriver().switchTo().window(newAdwinID);
        Assert.assertTrue("alertTextOK", modalDialogOKPage.alertTextOK.isDisplayed());
        modalDialogOKPage.confirmIncorrectFilling();
        WebDriverFactory.getWebDriver().switchTo().window(mainWinID);
    }
}
