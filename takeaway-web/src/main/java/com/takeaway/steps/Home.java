package com.takeaway.steps;

import org.junit.Assert;

import com.takeaway.pages.HomePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.model.TestStep;

public class Home extends TestStep {

    private HomePage homePage;

    public void userIsOnHomePage() {
        Assert.assertTrue("User is not on Home Page", homePage.userIsOnHomePage());
    }

    @Step
    public void searchRestaurants(String address) {
        homePage.enterAddress(address);
        homePage.selectFromSuggestedAddress(address);
        homePage.clickShowButton();
    }
}
