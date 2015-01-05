package com.ranorextest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Тёма on 04.01.2015.
 */
public class ModalDialogOKPage {

    WebDriver webDriver;

    public ModalDialogOKPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    ModalDialogOKPage(){}

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement confirmIncorrectFilling;
    public void confirmIncorrectFilling(){
        confirmIncorrectFilling.click();
    }

    @FindBy(id = "alertTextOK")
    public WebElement alertTextOK;
}
