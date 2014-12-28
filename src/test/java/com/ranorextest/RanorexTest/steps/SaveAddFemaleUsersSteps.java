package com.ranorextest.RanorexTest.steps;

import com.ranorextest.Category;
import com.ranorextest.RanorexTest.webdriver.WebDriverFactory;
import com.ranorextest.pageobject.HomePage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Тёма on 29.12.2014.
 */
public class SaveAddFemaleUsersSteps {
    HomePage homePage = new HomePage(WebDriverFactory.getWebDriver());

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
        }
    }

    @When("Save VIP users")
    public void saveVIPUsers(){
        homePage.saveVIPUser();
    }

    @When("Confirm saving")
    public void confirmSaving(){
        Set<String> windowId = WebDriverFactory.getWebDriver().getWindowHandles();
        Iterator<String> itererator = windowId.iterator();
        String mainWinID = itererator.next();
        String  newAdwinID = itererator.next();
        WebDriverFactory.getWebDriver().switchTo().window(newAdwinID);
        homePage.storedSuccessfully();
        WebDriverFactory.getWebDriver().close();
        WebDriverFactory.getWebDriver().switchTo().window(mainWinID);
    }
}
