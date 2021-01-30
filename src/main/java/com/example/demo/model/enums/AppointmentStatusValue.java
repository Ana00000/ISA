package com.example.demo.model.enums;

import java.util.Arrays;
import java.util.Optional;

public enum AppointmentStatusValue {
	UPCOMING("upcoming"),
	DONE("done"),
	DENIED("denied");
	
	private String text;

	private AppointmentStatusValue(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Optional<AppointmentStatusValue> fromText(String text) {
        return Arrays.stream(values())
          .filter(bl -> bl.text.equalsIgnoreCase(text))
          .findFirst();
    }
}
