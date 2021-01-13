package com.takeaway.api.automation.steps;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import com.takeaway.api.automation.actionsImpl.FarmActionsImpl;
import com.takeaway.api.automation.models.Response.ErrorResponse;
import com.takeaway.api.automation.models.Response.PostFarmActionResponse;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.model.TestStep;

public class FarmActionsStepDefinition extends TestStep {

    Response response;
    ErrorResponse errorResponse;
    PostFarmActionResponse postFarmActionResponse;
    FarmActionsImpl farmActions = new FarmActionsImpl();

    @Step
    public void userIsUnlockingTheBarn() {
        response = farmActions.unlockBarn();
        postFarmActionResponse = response.getBody().as(PostFarmActionResponse.class);
    }

    @Step
    public void verifyUserSuccessfullyUnlockedTheBarn() {

        verifyRespone("barn-unlock", "You just unlocked your barn! Watch out for strangers!", 0);

    }

    @Step
    public void userIsPuttingToiletSeatDown() {
        response = farmActions.putToiletSeatDown();
        postFarmActionResponse = response.getBody().as(PostFarmActionResponse.class);
    }

    @Step
    public void verifyUserSuccessfullyPutTpiletSeatDown() {

        verifyRespone("toiletseat-down", "You just put the toilet seat down. You're a wonderful roommate!", 0);

    }

    @Step
    public void userIsFeedingChickens() {
        response = farmActions.feedChickens();
        postFarmActionResponse = response.getBody().as(PostFarmActionResponse.class);
    }

    @Step
    public void verifyUserSuccessfullyFeededChickens() {

        verifyRespone("chickens-feed", "Your chickens are now full and happy", 0);

    }

    @Step
    public void userIsCollectingEggsFromChickens() {
        response = farmActions.collectEggsFromChicken();
        postFarmActionResponse = response.getBody().as(PostFarmActionResponse.class);
    }

    @Step
    public void verifyUserSuccessfullyCollectedEggs() {
        int noOfEggs = postFarmActionResponse.getData();
        Assert.assertTrue("No of eggs collected are not greater than zero", noOfEggs > 0);

        verifyRespone("eggs-collect", "Hey look at that, " + noOfEggs + " eggs have been collected!", noOfEggs);

    }

    @Step
    public void userIsCountingEggsCollected() {
        response = farmActions.getNumberOfEggsCollected();
        postFarmActionResponse = response.getBody().as(PostFarmActionResponse.class);
    }

    @Step
    public void verifyUserSuccessfullyCountedEggs() {
        int noOfEggs = postFarmActionResponse.getData();
        Assert.assertTrue("No of eggs collected are not greater than zero", noOfEggs > 0);

        verifyRespone("eggs-count", "You have collected a total of " + noOfEggs + " eggs today", noOfEggs);
    }

    private void verifyRespone(String farmAction, String message, int data) {
        SoftAssertions softAssertion = new SoftAssertions();
        softAssertion.assertThat(postFarmActionResponse.getAction()).as("Farm action is not correct")
                .isEqualTo(farmAction);
        softAssertion.assertThat(postFarmActionResponse.getSuccess()).as("Farm action is not successful.").isTrue();
        softAssertion.assertThat(postFarmActionResponse.getMessage()).as("Farm action Message is not correct")
                .isEqualTo(message);
        softAssertion.assertThat(postFarmActionResponse.getData()).as("Data is not correct").isEqualTo(data);
        softAssertion.assertAll();
    }
}
