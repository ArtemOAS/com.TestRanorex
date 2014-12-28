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
public class LoadAndClearVIPUsersSteps {
    HomePage homePage = new HomePage(WebDriverFactory.getWebDriver());

    @Given("Open ranorex")
    public void getUrlHome(){
        homePage.getUrlHome();
    }

    @When("Load VIP Users")
    public void loadVIPUsers(){
        homePage.loadAllUsers();
    }

    @When("Clear all VIP users")
    public void clearAllVIPUsers(){
        homePage.clear();
    }

    @Then("Deleted all VIP users")
    public void userIsDelete(){
        Assert.assertTrue("VIPs is empty", homePage.userIsDeleted.isDisplayed());
    }
}
