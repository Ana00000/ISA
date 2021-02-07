package com.example.demo.model.enums;

import java.util.Arrays;
import java.util.Optional;

public enum VacationStatusValue {
	ACCEPTED("accepted"), 
	REJECTED("rejected"),
	PENDING("pending");
	
	private String text;

	private VacationStatusValue(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Optional<VacationStatusValue> fromText(String text) {
        return Arrays.stream(values())
          .filter(vs -> vs.text.equalsIgnoreCase(text))
          .findFirst();
    }
}
