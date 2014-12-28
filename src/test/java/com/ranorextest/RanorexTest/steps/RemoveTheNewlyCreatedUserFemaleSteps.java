package com.ranorextest.RanorexTest.steps;

import com.ranorextest.Category;
import com.ranorextest.RanorexTest.webdriver.WebDriverFactory;
import com.ranorextest.pageobject.HomePage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

/**
 * Created by Тёма on 28.12.2014.
 */
public class RemoveTheNewlyCreatedUserFemaleSteps {
    HomePage homePage = new HomePage(WebDriverFactory.getWebDriver());

    @Given("Open ranorex")
    public void getUrlSteps(){
        homePage.getUrlHome();
    }

    @When("Choose category")
    public void chooseCategories(){
        for (Category category: homePage.categories()){
            String categoryName = category.getСategory();
            homePage.getWebElementCategory(categoryName).click();
            homePage.enterFirstName();
            homePage.enterLastName();
            homePage.chooseFemale();
            homePage.addUser();
            homePage.delete();
        }
    }

    @Then("User is delete")
    public void userIsDelete(){
        Assert.assertTrue("VIPs is empty",homePage.userIsDeleted.isDisplayed());
    }
}
