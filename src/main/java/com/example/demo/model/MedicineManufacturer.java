/**
 * Class MedicineManufacturer
 * AUTHOR: Aleksandar Hadzibabic
 * DATE: 24/1/2021
 */

package com.example.demo.model;

import javax.persistence.*;

@Entity
public class MedicineManufacturer {
	
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    @Column( nullable = false )
    private String name;

    public MedicineManufacturer() {
    }
}
