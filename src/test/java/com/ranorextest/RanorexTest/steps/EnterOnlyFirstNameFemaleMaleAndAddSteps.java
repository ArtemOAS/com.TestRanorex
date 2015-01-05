package com.ranorextest.RanorexTest.steps;

import com.ranorextest.MaleFemale;
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
public class EnterOnlyFirstNameFemaleMaleAndAddSteps {
    HomePage homePage = PageFactory.initElements(WebDriverFactory.getWebDriver(),HomePage.class);
    ModalDialogOKPage modalDialogOKPage = PageFactory.initElements(WebDriverFactory.getWebDriver(), ModalDialogOKPage.class);

    @Given("User open ranorex page")
    public void OpenRanorex(){
        homePage.getUrlHome();
    }

    @When("Confirm the incorrect filling")
    public void confirmIncorrectFilling(){
        homePage.enterFirstName();
        for (MaleFemale maleFemale : homePage.malesFemales()) {
            String maleFemaleName = maleFemale.getMaleFemale();
            homePage.getWebElementMaleFemale(maleFemaleName).click();
            homePage.addUser();
            Set<String> windowId = WebDriverFactory.getWebDriver().getWindowHandles();
            Iterator<String> itererator = windowId.iterator();
            String mainWinID = itererator.next();
            String newAdwinID = itererator.next();
            WebDriverFactory.getWebDriver().switchTo().window(newAdwinID);
            modalDialogOKPage.confirmIncorrectFilling();
            WebDriverFactory.getWebDriver().switchTo().window(mainWinID);
        }
    }

    @Then("Not users female")
    public void userIsDelete(){
        Assert.assertTrue("Not users", homePage.userIsDeleted.isDisplayed());
    }
}
