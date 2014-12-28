package com.ranorextest.RanorexTest.steps;

import com.ranorextest.RanorexTest.webdriver.WebDriverFactory;
import com.ranorextest.pageobject.HomePage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

/**
 * Created by Тёма on 28.12.2014.
 */
public class DisconnectSteps {
    HomePage homePage = new HomePage(WebDriverFactory.getWebDriver());

    @Given("Get url ranorex")
    public void getUrlHome(){
        homePage.getUrlHome();
    }

    @When("Take button 'Disconnect...'")
    public void disconnect(){
        homePage.disconnect();
    }

    @Then("Check disconnect")
    public void checkDisconnect(){
        Assert.assertTrue("Disconnect",homePage.checkDisconnect.isDisplayed());
    }
}
