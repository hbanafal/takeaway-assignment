package com.takeaway.steps;

import org.assertj.core.api.SoftAssertions;

import com.takeaway.enums.Enums.DeliveryCostFilter;
import com.takeaway.pages.RestaurantsCataloguePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.model.TestStep;

public class RestaurantCatalogue extends TestStep {

    private RestaurantsCataloguePage restaurantsPage;

    @Step
    public void applyDeliveyCostFilter(DeliveryCostFilter deliveryCostFilter) {
        restaurantsPage.selectDeliveryCostFilter(deliveryCostFilter);
    }

    @Step
    public void verifyDeliveryCosts(float maxDeliveryCost) {
        SoftAssertions softAssertion = new SoftAssertions();
        for (String cost : restaurantsPage.getDeliveryCosts())

            if (cost.contains("€")) {
                float actualCost = Float.parseFloat(cost.replace(",", ".").replace(" ", "").replace("€", ""));
                softAssertion.assertThat(actualCost)
                        .as("Actual Delivery cost of the restaurant is more than filtered value")
                        .isLessThanOrEqualTo(maxDeliveryCost);
            } else
                softAssertion.assertThat(cost).as("Actual Delivery cost of the restaurant is more than filtered value")
                        .isIn("FREE", "");
        softAssertion.assertAll();
    }

    @Step
    public void filterRestaurantsCategoryWise(String category) {
        restaurantsPage.filterRestaurantsCategoryWise(category);
    }

    @Step
    public void verifyKitchenType(String expectedKitchenType) {
        SoftAssertions softAssertion = new SoftAssertions();
        for (String kitchenTypes : restaurantsPage.getKitchenTypesOfRestaurants()) {
            if (kitchenTypes.equals(""))
                continue;
            softAssertion.assertThat(kitchenTypes)
                    .as("Actual Delivery cost of the restaurant is more than filtered value")
                    .contains(expectedKitchenType);
        }
        softAssertion.assertAll();
    }
}
