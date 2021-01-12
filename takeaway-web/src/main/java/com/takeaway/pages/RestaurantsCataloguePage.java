package com.takeaway.pages;

import java.util.List;

import org.openqa.selenium.By;

import com.takeaway.enums.Enums.DeliveryCostFilter;
import com.takeaway.pages.locators.RestaurantCataloguePageLocators;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class RestaurantsCataloguePage extends PageObject {

    private BasePage basePage;

    private RestaurantCataloguePageLocators locators;

    public void selectDeliveryCostFilter(DeliveryCostFilter deliveryCostFilter) {
        switch (deliveryCostFilter) {
        case FREE:
            locators.deliveryCostFree.click();
            break;
        case LESSTHAN1EURO:
            locators.deliveryCostLessThan1Euro.click();
            break;
        case LESSTHAN2_5Euro:
            locators.deliveryCostLessThan2Euro.click();
            break;
        default:
            break;
        }

    }

    public List<String> getDeliveryCosts() {
        return basePage.getTextOfElements(locators.deliveryCosts);
    }

    public List<String> getKitchenTypesOfRestaurants() {
        return basePage.getTextOfElements($$(By.xpath("//*[contains(@class, 'kitchens')]/span")));
    }

    public void filterRestaurantsCategoryWise(String category) {
        locators.showMoreCategoriesType.click();
        locators.searchCategoriesField.sendKeys(category);
        for (WebElementFacade searchedCategory : $$(By.xpath("//span[contains(@class,'tv-chip__inner-content')]")))
            if (searchedCategory.getText().equals(category))
                searchedCategory.click();
    }
}
