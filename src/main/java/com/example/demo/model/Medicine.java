/**
 * Class Medicine
 * AUTHOR: Aleksandar Hadzibabic
 * DATE: 24/1/2021
 */

package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean needsRecipe;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable( name = "alternativeMedicine", joinColumns = @JoinColumn(name="mainMedicine", referencedColumnName="id"), inverseJoinColumns = @JoinColumn(name = "alternativeMedicine", referencedColumnName = "id"))
    private Set<Medicine> alternativeMedicine;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private MedicineManufacturer medicineManufacturer;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private MedicineShape medicineShape;

    public Medicine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNeedsRecipe() {
        return needsRecipe;
    }

    public void setNeedsRecipe(boolean needsRecipe) {
        this.needsRecipe = needsRecipe;
    }

    public Set<Medicine> getAlternativeMedicine() {
        return alternativeMedicine;
    }

    public void setAlternativeMedicine(Set<Medicine> alternativeMedicine) {
        this.alternativeMedicine = alternativeMedicine;
    }

    public MedicineManufacturer getMedicineManufacturer() {
        return medicineManufacturer;
    }

    public void setMedicineManufacturer(MedicineManufacturer medicineManufacturer) {
        this.medicineManufacturer = medicineManufacturer;
    }

    public MedicineShape getMedicineShape() {
        return medicineShape;
    }

    public void setMedicineShape(MedicineShape medicineShape) {
        this.medicineShape = medicineShape;
    }
}
