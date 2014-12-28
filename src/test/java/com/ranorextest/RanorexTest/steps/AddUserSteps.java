package com.ranorextest.RanorexTest.steps;

import com.ranorextest.RanorexTest.webdriver.WebDriverFactory;
import com.ranorextest.pageobject.HomePage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

/**
 * Created by Тёма on 26.12.2014.
 */
public class AddUserSteps {
    HomePage homePage = new HomePage(WebDriverFactory.getWebDriver());

    @Given("User open ranorex page")
    public void OpenRanorex(){
        homePage.getUrlHome();
    }

    @When("Enter user first name")
    public void enterFirstName(){
        homePage.enterFirstName();
    }

    @When("Enter user last name")
    public void enterLastName(){
        homePage.enterLastName();
    }

    @When("Add user")
    public void addUser(){
        homePage.addUser();
    }

    @Then("Successful registered")
    public void createUserFemale(){
        Assert.assertTrue("registered user", homePage.registeredUser.isDisplayed());
    }

}
