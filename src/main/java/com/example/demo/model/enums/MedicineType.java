package com.example.demo.model.enums;

import java.util.Arrays;
import java.util.Optional;

public enum MedicineType {
	HEAD("head"), 
	BODY("body");
	
	private String text;

	private MedicineType(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Optional<MedicineType> fromText(String text) {
        return Arrays.stream(values())
          .filter(mt -> mt.text.equalsIgnoreCase(text))
          .findFirst();
    }
}
