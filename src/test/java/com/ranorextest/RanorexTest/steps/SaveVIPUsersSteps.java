package com.ranorextest.RanorexTest.steps;

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
 * Created by Тёма on 28.12.2014.
 */
public class SaveVIPUsersSteps {
    HomePage homePage = PageFactory.initElements(WebDriverFactory.getWebDriver(),HomePage.class);
    ModalDialogOKPage modalDialogOKPage = PageFactory.initElements(WebDriverFactory.getWebDriver(), ModalDialogOKPage.class);

    @Given("Open ranorex")
    public void getUrlHome(){
        homePage.getUrlHome();
    }

    @When("Save VIP users")
    public void confirmSaving(){
        homePage.loadAllUsers();
        homePage.saveVIPUser();
    }

    @Then("Confirm save VIP users")
    public void confirmSaveVIPUsers(){
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
