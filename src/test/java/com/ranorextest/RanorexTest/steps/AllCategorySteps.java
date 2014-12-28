package com.ranorextest.RanorexTest.steps;

import com.ranorextest.Category;
import com.ranorextest.RanorexTest.webdriver.WebDriverFactory;
import com.ranorextest.pageobject.HomePage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Тёма on 28.12.2014.
 */
public class AllCategorySteps {
    HomePage homePage = new HomePage(WebDriverFactory.getWebDriver());

    @Given("Open ranorex")
    public void getUrlHome(){
        homePage.getUrlHome();
    }

    @When("Find category")
    public void findAllCategory(){
        List<WebElement> categoryElements = WebDriverFactory.getWebDriver().findElements(By.xpath(".//*[@id='Category']/option[@value]"));
        Set<Category> categories = new HashSet<Category>();

        for (WebElement element: categoryElements){
            Category category = new Category(element.getText());
            categories.add(category);
        }
    }

    @Then("All categories")
    public void allCategory(){
        List<WebElement> categories = WebDriverFactory.getWebDriver().findElements(By.xpath(".//*[@id='Category']/option[@value]"));
       // Assert.assertTrue(categories.isEmpty());
    }
}
