package com.ranorextest.RanorexTest.steps;

import com.ranorextest.RanorexTest.webdriver.WebDriverFactory;
import com.ranorextest.pageobject.HomePage;
import com.ranorextest.pageobject.ModalDialogOKCancelPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Тёма on 28.12.2014.
 */
public class ConnectAndDisconnectSteps {
    HomePage homePage = PageFactory.initElements(WebDriverFactory.getWebDriver(),HomePage.class);
    ModalDialogOKCancelPage modalDialogOKCancelPage = PageFactory.initElements(WebDriverFactory.getWebDriver(), ModalDialogOKCancelPage.class);

    @Given("Get url ranorex")
    public void getUrlHome(){
        homePage.getUrlHome();
    }

    @When("Connect and disconnect")
    public void confirmConnection(){
        homePage.disconnect();
        homePage.connect();
        Set<String> windowId = WebDriverFactory.getWebDriver().getWindowHandles();
        Iterator<String> itererator = windowId.iterator();
        String mainWinID = itererator.next();
        String  newAdwinID = itererator.next();
        WebDriverFactory.getWebDriver().switchTo().window(newAdwinID);
        modalDialogOKCancelPage.connectOk();
        WebDriverFactory.getWebDriver().switchTo().window(mainWinID);
        homePage.disconnect();
        homePage.connect();
        Set<String> windowId2 = WebDriverFactory.getWebDriver().getWindowHandles();
        Iterator<String> itererator2 = windowId2.iterator();
        String mainWinID2 = itererator2.next();
        String newAdwinID2 = itererator2.next();
        WebDriverFactory.getWebDriver().switchTo().window(newAdwinID2);
        modalDialogOKCancelPage.connectCancel();
        WebDriverFactory.getWebDriver().switchTo().window(mainWinID2);
    }

    @Then("Not connected")
    public void cancelConnected(){
        //Assert.assertTrue("connected", homePage.checkConnect.isDisplayed());
    }
}
