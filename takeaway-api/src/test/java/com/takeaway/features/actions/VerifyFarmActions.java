package com.takeaway.features.actions;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.takeaway.api.automation.steps.FarmActionsStepDefinition;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTagValuesOf;

@RunWith(SerenityRunner.class)
@WithTagValuesOf({ "feature:farm_Actions", "team:takeaway-qa", "type:regression", "request_type:POST" })
public class VerifyFarmActions {

    @Steps
    private FarmActionsStepDefinition farmAction;

    @Test
    @Title("Verify Unlock Barn")
    public void verifyUnlockBarnAction() {

        farmAction.userIsUnlockingTheBarn();
        farmAction.verifyUserSuccessfullyUnlockedTheBarn();

    }

    @Test
    @Title("Verify Put Toilet Seat Down")
    public void verifyPutToiletSeatDownAction() {

        farmAction.userIsPuttingToiletSeatDown();
        farmAction.verifyUserSuccessfullyPutTpiletSeatDown();

    }

    @Test
    @Title("Verify Feeding Chicken")
    public void verifyFeedChickenAction() {

        farmAction.userIsFeedingChickens();
        farmAction.verifyUserSuccessfullyFeededChickens();

    }

    @Test
    @Title("Verify Collecting Eggs")
    public void verifyCollectEggsAction() {

        farmAction.userIsCollectingEggsFromChickens();
        farmAction.verifyUserSuccessfullyCollectedEggs();

    }

    @Test
    @Title("Verify Counting Eggs")
    public void verifyCountEggsAction() {

        farmAction.userIsCountingEggsCollected();
        farmAction.verifyUserSuccessfullyCountedEggs();

    }

}
