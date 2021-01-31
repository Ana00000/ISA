package com.example.demo.model.enums;

import java.util.Arrays;
import java.util.Optional;

public enum AppointmentTypeValues {
	CONSULTATION("consultation"), 
	EXAMINATION("examination");
	
	private String text;

	private AppointmentTypeValues(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Optional<AppointmentTypeValues> fromText(String text) {
        return Arrays.stream(values())
          .filter(atv -> atv.text.equalsIgnoreCase(text))
          .findFirst();
    }
}
