package com.example.demo.model.enums;

import java.util.Arrays;
import java.util.Optional;

public enum PrescriptionStatus {
	NEW("new"),
	PROCESSED("processed"),
	DENIED("denied");

	private String text;

	private PrescriptionStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Optional<PrescriptionStatus> fromText(String text) {
        return Arrays.stream(values())
          .filter(asv -> asv.text.equalsIgnoreCase(text))
          .findFirst();
    }
}
