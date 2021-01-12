package com.takeaway.pages;

import com.takeaway.pages.locators.HomePageLocators;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends PageObject {

    private HomePageLocators locators;

    public boolean userIsOnHomePage() {
        getDriver().get("https://www.lieferando.de/en/");
        getDriver().manage().window().maximize();
        if (locators.acceptCookiedPrefButton.isCurrentlyVisible())
            locators.acceptCookiedPrefButton.click();
        return locators.addressSearchField.isVisible();
    }

    public void enterAddress(String address) {
        locators.addressSearchField.sendKeys(address);
    }

    public void selectFromSuggestedAddress(String address) {
        for (WebElementFacade suggestedAddress : locators.suggestedAddresses)
            if (suggestedAddress.getText().contains(address))
                suggestedAddress.click();
    }

    public void clickShowButton() {
        locators.showButton.click();
    }
}
