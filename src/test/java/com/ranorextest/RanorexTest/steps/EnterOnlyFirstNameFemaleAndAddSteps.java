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
 * Created by Тёма on 29.12.2014.
 */
public class EnterOnlyFirstNameFemaleAndAddSteps {
    HomePage homePage = new HomePage(WebDriverFactory.getWebDriver());

    @Given("User open ranorex page")
    public void OpenRanorex(){
        homePage.getUrlHome();
    }

    @When("Enter user first name")
    public void enterFirstName(){
        homePage.enterFirstName();
    }

    @When("Choose female")
    public void chooseFemale(){
        homePage.chooseFemale();
    }

    @When("Add user")
    public void addUser(){
        homePage.addUser();
    }

    @When("Confirm the incorrect filling")
    public void confirmIncorrectFilling(){
        Set<String> windowId = WebDriverFactory.getWebDriver().getWindowHandles();
        Iterator<String> itererator = windowId.iterator();
        String mainWinID = itererator.next();
        String newAdwinID = itererator.next();
        WebDriverFactory.getWebDriver().switchTo().window(newAdwinID);
        homePage.confirmIncorrectFilling();
        WebDriverFactory.getWebDriver().close();
        WebDriverFactory.getWebDriver().switchTo().window(mainWinID);
    }

    @Then("Not users female")
    public void userIsDelete(){
        Assert.assertTrue("Not users", homePage.userIsDeleted.isDisplayed());
    }
}
