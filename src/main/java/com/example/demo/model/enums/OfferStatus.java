package com.example.demo.model.enums;

import java.util.Arrays;
import java.util.Optional;

public enum OfferStatus {
    ACCEPTED("ACCEPTED"),
    DECLINED("DECLINED"),
    WAITING("WAITING");

    private String text;

    private OfferStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Optional<OfferStatus> fromText(String text) {
        return Arrays.stream(values())
                .filter(mt -> mt.text.equalsIgnoreCase(text))
                .findFirst();
    }
}
