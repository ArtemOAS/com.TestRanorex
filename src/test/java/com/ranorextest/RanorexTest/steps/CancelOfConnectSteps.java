package com.ranorextest.RanorexTest.steps;

import com.ranorextest.RanorexTest.webdriver.WebDriverFactory;
import com.ranorextest.pageobject.HomePage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Тёма on 28.12.2014.
 */
public class CancelOfConnectSteps {
    HomePage homePage = new HomePage(WebDriverFactory.getWebDriver());

    @Given("Get url ranorex")
    public void getUrlHome(){
        homePage.getUrlHome();
    }

    @When("Push disconnect")
    public void disconnect(){
        homePage.disconnect();
    }

    @When("Push connect")
    public void connect(){
        homePage.connect();
    }

    @When("Cancel of connection")
    public void confirmConnection(){
        Set<String> windowId = WebDriverFactory.getWebDriver().getWindowHandles();
        Iterator<String> itererator = windowId.iterator();
        String mainWinID = itererator.next();
        String  newAdwinID = itererator.next();
        WebDriverFactory.getWebDriver().switchTo().window(newAdwinID);
        homePage.connectCancel();
        WebDriverFactory.getWebDriver().close();
        WebDriverFactory.getWebDriver().switchTo().window(mainWinID);
    }

    @Then("Not connected")
    public void connected(){
        Assert.assertTrue("connected", homePage.checkConnect.isDisplayed());
    }
}
