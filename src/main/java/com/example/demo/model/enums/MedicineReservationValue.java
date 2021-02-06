package com.example.demo.model.enums;

import java.util.Arrays;
import java.util.Optional;

public enum MedicineReservationValue {
    UPCOMING("upcoming"),
    DONE("done"),
    DENIED("denied");

    private String text;

    private MedicineReservationValue(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Optional<MedicineReservationValue> fromText(String text) {
        return Arrays.stream(values())
                .filter(asv -> asv.text.equalsIgnoreCase(text))
                .findFirst();
    }
}
