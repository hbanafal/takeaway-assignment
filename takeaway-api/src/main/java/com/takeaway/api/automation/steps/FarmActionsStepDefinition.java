package com.takeaway.api.automation.steps;

import org.assertj.core.api.SoftAssertions;

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
    FarmActionsImpl farmActions;

    @Step
    public void userIsUnlockingTheBarn() {
        farmActions = new FarmActionsImpl();
        response = farmActions.unlockBarn();
        postFarmActionResponse = response.getBody().as(PostFarmActionResponse.class);
    }

    @Step
    public void verifyUserSuccessfullyUnlockedTheBarn() {

        SoftAssertions softAssertion = new SoftAssertions();
        softAssertion.assertThat(postFarmActionResponse.getAction()).as("Farm action is not correct")
                .isEqualTo("barn-unlock");
        softAssertion.assertThat(postFarmActionResponse.getSuccess()).as("Success is not correct").isTrue();
        softAssertion.assertThat(postFarmActionResponse.getMessage()).as("Message is not correct")
                .isEqualTo("You just unlocked your barn! Watch out for strangers!");
        softAssertion.assertThat(postFarmActionResponse.getData()).as("Data is not null").isEqualTo(0);
        softAssertion.assertAll();

    }

    @Step
    public void userIsPuttingToiletSeatDown() {
        farmActions = new FarmActionsImpl();
        response = farmActions.putToiletSeatDown();
        postFarmActionResponse = response.getBody().as(PostFarmActionResponse.class);
    }

    @Step
    public void verifyUserSuccessfullyPutTpiletSeatDown() {

        SoftAssertions softAssertion = new SoftAssertions();
        softAssertion.assertThat(postFarmActionResponse.getAction()).as("Farm action is not correct")
                .isEqualTo("toiletseat-down");
        softAssertion.assertThat(postFarmActionResponse.getSuccess()).as("Success is not correct").isTrue();
        softAssertion.assertThat(postFarmActionResponse.getMessage()).as("Message is not correct")
                .isEqualTo("You just put the toilet seat down. You're a wonderful roommate!");
        softAssertion.assertThat(postFarmActionResponse.getData()).as("Data is not null").isEqualTo(0);
        softAssertion.assertAll();

    }

    @Step
    public void userIsFeedingChickens() {
        farmActions = new FarmActionsImpl();
        response = farmActions.feedChickens();
        postFarmActionResponse = response.getBody().as(PostFarmActionResponse.class);
    }

    @Step
    public void verifyUserSuccessfullyFeededChickens() {

        SoftAssertions softAssertion = new SoftAssertions();
        softAssertion.assertThat(postFarmActionResponse.getAction()).as("Farm action is not correct")
                .isEqualTo("chickens-feed");
        softAssertion.assertThat(postFarmActionResponse.getSuccess()).as("Success is not correct").isTrue();
        softAssertion.assertThat(postFarmActionResponse.getMessage()).as("Message is not correct")
                .isEqualTo("Your chickens are now full and happy");
        softAssertion.assertThat(postFarmActionResponse.getData()).as("Data is not null").isEqualTo(0);
        softAssertion.assertAll();

    }

    @Step
    public void userIsCollectingEggsFromChickens() {
        farmActions = new FarmActionsImpl();
        response = farmActions.collectEggsFromChicken();
        postFarmActionResponse = response.getBody().as(PostFarmActionResponse.class);
    }

    @Step
    public void verifyUserSuccessfullyCollectedEggs() {

        SoftAssertions softAssertion = new SoftAssertions();
        int noOfEggs = postFarmActionResponse.getData();
        softAssertion.assertThat(postFarmActionResponse.getAction()).as("Farm action is not correct")
                .isEqualTo("eggs-collect");
        softAssertion.assertThat(postFarmActionResponse.getSuccess()).as("Success is not correct").isTrue();
        softAssertion.assertThat(postFarmActionResponse.getMessage()).as("Message is not correct")
                .isEqualTo("Hey look at that, " + noOfEggs + " eggs have been collected!");
        softAssertion.assertThat(postFarmActionResponse.getData()).as("Data is not null").isGreaterThan(0);
        softAssertion.assertAll();

    }

    @Step
    public void userIsCountingEggsCollected() {
        farmActions = new FarmActionsImpl();
        response = farmActions.getNumberOfEggsCollected();
        postFarmActionResponse = response.getBody().as(PostFarmActionResponse.class);
    }

    @Step
    public void verifyUserSuccessfullyCountedEggs() {

        SoftAssertions softAssertion = new SoftAssertions();
        int noOfEggs = postFarmActionResponse.getData();
        softAssertion.assertThat(postFarmActionResponse.getAction()).as("Farm action is not correct")
                .isEqualTo("eggs-count");
        softAssertion.assertThat(postFarmActionResponse.getSuccess()).as("Success is not correct").isTrue();
        softAssertion.assertThat(postFarmActionResponse.getMessage()).as("Message is not correct")
                .isEqualTo("You have collected a total of " + noOfEggs + " eggs today");
        softAssertion.assertThat(postFarmActionResponse.getData()).as("Data is not null").isGreaterThan(0);
        softAssertion.assertAll();

    }
}
