package com.ranorextest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Тёма on 04.01.2015.
 */
public class ModalDialogOKCancelPage {

    WebDriver webDriver;

    public ModalDialogOKCancelPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    ModalDialogOKCancelPage(){}


    @FindBy(xpath=".//*[@id='alertOKCancel']/center/button[text()='OK']")
    WebElement connectOk;
    public void connectOk(){
        connectOk.click();
    }

    @FindBy(xpath=".//*[@id='alertOKCancel']/center/button[text()='Cancel']")
    WebElement connectCancel;
    public void connectCancel(){
        connectCancel.click();
    }
}
