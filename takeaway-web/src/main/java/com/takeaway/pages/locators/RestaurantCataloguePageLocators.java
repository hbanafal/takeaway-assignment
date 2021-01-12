package com.takeaway.pages.locators;

import java.util.List;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class RestaurantCataloguePageLocators extends PageObject {

    @FindBy(xpath = "//span[normalize-space()='Free']")
    public WebElementFacade deliveryCostFree;

    @FindBy(xpath = "//span[contains(text(),'1,00 € or less')]")
    public WebElementFacade deliveryCostLessThan1Euro;

    @FindBy(xpath = "//span[contains(text(),'2,50 € or less')]")
    public WebElementFacade deliveryCostLessThan2Euro;

    @FindBy(className = "detailswrapper")
    public List<WebElementFacade> searchedRestaurants;

    @FindBy(xpath = "//*[contains(@class, 'delivery-cost')]")
    public List<WebElementFacade> deliveryCosts;

    @FindBy(xpath = "//*[contains(@class, 'kitchen-types__show-more')]")
    public WebElementFacade showMoreCategoriesType;

    @FindBy(xpath = "//*[contains(@class, 'tv-searchbox__searchfield')]")
    public WebElementFacade searchCategoriesField;

    @FindBy(xpath = "//span[contains(@class,'tv-chip__inner-content')]")
    public List<WebElementFacade> searchedCategories;

    @FindBy(xpath = "//*[contains(@class, 'kitchens')]/span")
    public List<WebElementFacade> kitchenTypes;

}