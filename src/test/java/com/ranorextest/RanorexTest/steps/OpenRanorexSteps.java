package com.ranorextest.RanorexTest.steps;

import com.ranorextest.RanorexTest.webdriver.WebDriverFactory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import com.ranorextest.pageobject.HomePage;
import org.openqa.selenium.support.PageFactory;

public class OpenRanorexSteps {
    HomePage homePage = PageFactory.initElements(WebDriverFactory.getWebDriver(), HomePage.class);

    @Given("User open ranorex page")
    public void givenUSerOpenRanorex(){
        homePage.getUrlHome();
    }

    @Then("Open page ranorex")
    public void openRanorex(){
        Assert.assertTrue("VIP Database Test Web Application", homePage.namePage.isDisplayed());
    }
    
}
