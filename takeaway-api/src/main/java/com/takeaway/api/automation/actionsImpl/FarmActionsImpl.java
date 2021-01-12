package com.takeaway.api.automation.actionsImpl;

import com.takeaway.api.automation.actions.FarmActions;
import com.takeaway.api.automation.utilities.APIFunctions;

import io.restassured.response.Response;

public class FarmActionsImpl implements FarmActions {

    @Override
    public Response unlockBarn() {
        return APIFunctions.postRequest("/barn-unlock");
    }

    @Override
    public Response putToiletSeatDown() {
        return APIFunctions.postRequest("/toiletseat-down");
    }

    @Override
    public Response feedChickens() {
        return APIFunctions.postRequest("/chickens-feed");
    }

    @Override
    public Response collectEggsFromChicken() {
        return APIFunctions.postRequest("/eggs-collect");
    }

    @Override
    public Response getNumberOfEggsCollected() {
        return APIFunctions.postRequest("/eggs-count");
    }
}
