package com.example.demo.model.enums;

import java.util.Arrays;
import java.util.Optional;

public enum MedicineShapeValue {
	PILL("pill"), 
	TABLET("tablet"), 
	SYRUP("syrup");
	
	private String text;

	private MedicineShapeValue(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Optional<MedicineShapeValue> fromText(String text) {
        return Arrays.stream(values())
          .filter(msv -> msv.text.equalsIgnoreCase(text))
          .findFirst();
    }
}
