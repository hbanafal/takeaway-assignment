package com.takeaway.api.automation.actions;

import io.restassured.response.Response;

public interface FarmActions {

    Response unlockBarn();

    Response putToiletSeatDown();

    Response feedChickens();

    Response collectEggsFromChicken();

    Response getNumberOfEggsCollected();
}
