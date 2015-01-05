package com.ranorextest.RanorexTest.steps;

import com.ranorextest.AllVIPUsers;
import com.ranorextest.RanorexTest.webdriver.WebDriverFactory;
import com.ranorextest.pageobject.HomePage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Тёма on 28.12.2014.
 */
public class LoadDeleteAndClearVIPUsersSteps {
    HomePage homePage = PageFactory.initElements(WebDriverFactory.getWebDriver(), HomePage.class);

    @Given("Open ranorex")
    public void getUrlHome(){
        homePage.getUrlHome();
    }

    @When("Load VIP users, delete and clear")
    public void chooseCategories() {
        homePage.loadAllUsers();
        for (AllVIPUsers VIPAllUsers : homePage.VIPUsers()) {
            String VIPUsersName = VIPAllUsers.getVIPUsers();
            homePage.getWebElementVIPUsers(VIPUsersName).click();
            homePage.delete();
        }
        homePage.loadAllUsers();
        homePage.clear();
    }

    @Then("Deleted all VIP users")
    public void userIsDelete(){
        Assert.assertTrue("VIPs is empty", homePage.userIsDeleted.isDisplayed());
    }
}
