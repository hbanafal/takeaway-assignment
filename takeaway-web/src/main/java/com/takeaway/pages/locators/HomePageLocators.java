package com.takeaway.pages.locators;

import java.util.List;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePageLocators extends PageObject {

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    public WebElementFacade acceptCookiedPrefButton;

    @FindBy(id = "imysearchstring")
    public WebElementFacade addressSearchField;

    @FindBy(xpath = "//*[@id='iautoCompleteDropDownContent']/a")
    public List<WebElementFacade> suggestedAddresses;

    @FindBy(id = "submit_deliveryarea")
    public WebElementFacade showButton;

}
