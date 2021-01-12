package com.takeaway.enums;

public class Enums {

    public enum DeliveryCostFilter {
        FREE(0.0f), LESSTHAN1EURO(1.0f), LESSTHAN2_5Euro(2.5f);

        public final float value;

        DeliveryCostFilter(float f) {
            this.value = f;
        }
    }

}
