package com.ranorextest.RanorexTest.steps;

import com.ranorextest.Category;
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
public class AddAUserFemaleAndMailUsingTheCategoriesSteps {
    HomePage homePage = PageFactory.initElements(WebDriverFactory.getWebDriver(),HomePage.class);

    @Given("Open ranorex")
    public void getUrlHome(){
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
            homePage.enterFirstName();
            homePage.enterLastName();
            homePage.chooseMale();
            homePage.addUser();
        }
    }

    @Then("Vip user add")
    public void vipUserAdd(){
            Assert.assertTrue("registered user", homePage.registeredUser.isDisplayed());
    }
}
