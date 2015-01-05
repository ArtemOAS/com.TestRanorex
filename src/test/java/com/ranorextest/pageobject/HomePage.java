package com.ranorextest.pageobject;

import com.ranorextest.AllVIPUsers;
import com.ranorextest.Category;
import com.ranorextest.MaleFemale;
import com.ranorextest.RanorexTest.webdriver.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Тёма on 26.12.2014.
 */
public class HomePage {

    WebDriver webDriver;
    String URL_HOME = "http://www.ranorex.com/web-testing-examples/vip/";

   public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    HomePage(){}

    public void getUrlHome(){
        webDriver.get(URL_HOME);
    }

    @FindBy(xpath = ".//*[@id='Content']/h1")
    public WebElement namePage;

    @FindBy(id = "FirstName")
    WebElement enterFirstName;
    public void enterFirstName(){
        enterFirstName.sendKeys("Test1");
    }

    @FindBy(id = "LastName")
    WebElement enterLastName;
    public void enterLastName(){
        enterLastName.sendKeys("Test1");
    }

    @FindBy(xpath = ".//*[@id='VIPs']/tbody/tr[2]/td[2]")
    public WebElement registeredUser;

    WebElement addUser;
    public void addUser(){
        addUser = (new WebDriverWait(webDriver,60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='Add']")));
        addUser.click();
    }

    public Set<Category> categories(){
        List<WebElement> categoryElements = WebDriverFactory.getWebDriver().findElements(By.xpath(".//*[@id='Category']/option[@value]"));
        Set<Category> categories = new HashSet<Category>();

        for (WebElement element: categoryElements){
            Category category = new Category(element.getText());
            categories.add(category);
        }
        return categories;
    }

    public WebElement getWebElementCategory(String categoryName){
        WebElement element = webDriver.findElement(By.xpath(".//*[@id='Category']/option[contains(text(), '" + categoryName + "')]"));
        return element;
    }

    @FindBy(id = "Delete")
    WebElement delete;
    public void delete(){
        delete.click();
    }

    @FindBy(id = "VIPs")
    public WebElement userIsDeleted;

    @FindBy(xpath = ".//*[@id='Gender'][@value='female']")
    WebElement chooseFemale;
    public void chooseFemale(){
        chooseFemale.click();
    }

    @FindBy(xpath = ".//*[@id='Gender'][@value='male']")
    WebElement chooseMale;
    public void chooseMale(){
        chooseMale.click();
    }

    @FindBy(id = "Clear")
    WebElement clear;
    public void clear(){
        clear.click();
    }

    WebElement disconnect;
    public void disconnect(){
        disconnect = (new WebDriverWait(webDriver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='connect'][@value='Disconnect...']")));
        disconnect.click();
    }

    @FindBy(xpath = ".//*[@id='connect'][@value='Connect...']")
    public WebElement checkDisconnect;

    @FindBy(xpath = ".//*[@id='connect'][@value='Connect...']")
    WebElement connect;
    public void connect(){
        connect.click();
    }

    @FindBy(xpath = ".//*[@id='connect'][@value='Disconnect...']")
    public WebElement checkConnect;



    @FindBy(id = "Load")
    WebElement loadAllUsers;
    public void loadAllUsers(){
        loadAllUsers.click();
    }

    @FindBy(xpath = "//input[@id='VIP']")
    public List <WebElement> usersLoaded;

    public Set<AllVIPUsers> VIPUsers(){
        Set<AllVIPUsers> VIPUsers = new HashSet<>();
        List<WebElement> allVIPUsersElement = WebDriverFactory.getWebDriver().findElements(By.xpath("//input[@id='VIP']/ancestor::tr/td[2]"));

        for (WebElement element: allVIPUsersElement) {
            AllVIPUsers allVIPUsers = new AllVIPUsers(element.getText());
            VIPUsers.add(allVIPUsers);
        }
        return VIPUsers;
    }

    public WebElement getWebElementVIPUsers(String VIPUsersName){
        WebElement element = webDriver.findElement(By.xpath("//td[contains(text(),'"+VIPUsersName+"')]/ancestor::tr/td/input[@id='VIP']"));
        return element;
    }

    WebElement saveVIPUser;
    public void saveVIPUser(){
        saveVIPUser = (new WebDriverWait(webDriver,40)).until(ExpectedConditions.presenceOfElementLocated(By.id("Save")));
        saveVIPUser.click();
    }

    public Set<MaleFemale> malesFemales(){
        Set<MaleFemale> maleFemale = new HashSet<>();
        List<WebElement> maleFemaleElement = WebDriverFactory.getWebDriver().findElements(By.xpath(".//td[@id='gender']/table/tbody/tr[position() mod 2+2]/td"));

        for (WebElement element: maleFemaleElement) {
            MaleFemale malesFemales = new MaleFemale(element.getText());
            maleFemale.add(malesFemales);
        }
        return maleFemale;
    }

    public WebElement getWebElementMaleFemale(String maleFemaleName){
        WebElement element = (new WebDriverWait(webDriver,20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//td[@id='gender']/table/tbody/tr/td[text()[normalize-space(.)='" + maleFemaleName + "']]/input[@id='Gender']")));
        return element;
    }

}
