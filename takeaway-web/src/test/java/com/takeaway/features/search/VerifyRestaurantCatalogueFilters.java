package com.takeaway.features.search;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.takeaway.enums.Enums.DeliveryCostFilter;
import com.takeaway.steps.Home;
import com.takeaway.steps.RestaurantCatalogue;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTagValuesOf;

@RunWith(SerenityRunner.class)
@WithTagValuesOf({ "feature:filters", "team:takeaway-qa", "type:regression" })
public class VerifyRestaurantCatalogueFilters {

    @Managed
    WebDriver driver;

    @Steps
    private Home home;

    @Steps
    private RestaurantCatalogue restaurantCatalogue;

    private String address = "Greifswalder Strasse 212";

    private String kitchenType = "Italian";

    @Before
    public void setup() {
        home.userIsOnHomePage();
        home.searchRestaurants(address);
    }

    @Test
    @Title("Verify Delivery Cost Filter")
    public void verifyDeliveryCostFilter() {
        restaurantCatalogue.applyDeliveyCostFilter(DeliveryCostFilter.LESSTHAN1EURO);
        restaurantCatalogue.verifyDeliveryCosts(DeliveryCostFilter.LESSTHAN1EURO.value);
    }

    @Test
    @Title("Verify Kitchen Category Filter")
    public void verifyKitchenCategoryFilter() {
        restaurantCatalogue.filterRestaurantsCategoryWise(kitchenType);
        restaurantCatalogue.verifyKitchenType(kitchenType);
    }
}
