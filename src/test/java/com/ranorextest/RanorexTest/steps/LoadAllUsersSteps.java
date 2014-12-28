package com.ranorextest.RanorexTest.steps;

import com.ranorextest.RanorexTest.webdriver.WebDriverFactory;
import com.ranorextest.pageobject.HomePage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Тёма on 28.12.2014.
 */
public class LoadAllUsersSteps {
    HomePage homePage = new HomePage(WebDriverFactory.getWebDriver());

    @Given("Open ranorex")
    public void getUrlHome(){
        homePage.getUrlHome();
    }

    @When("Push button 'Load'")
    public void loadAllUsers(){
        homePage.loadAllUsers();
    }

    @Then("Users loaded")
    public void usersLoaded(){
        Assert.assertTrue("All users",homePage.usersLoaded.isEmpty());
    }
}
