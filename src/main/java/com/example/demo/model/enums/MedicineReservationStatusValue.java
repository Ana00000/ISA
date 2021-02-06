package com.example.demo.model.enums;

import java.util.Arrays;
import java.util.Optional;

public enum MedicineReservationStatusValue {
    ACTIVE("active"),
    CANCELED("canceled");

    private String text;

    private MedicineReservationStatusValue(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Optional<MedicineReservationStatusValue> fromText(String text) {
        return Arrays.stream(values())
                .filter(asv -> asv.text.equalsIgnoreCase(text))
                .findFirst();
    }
}
