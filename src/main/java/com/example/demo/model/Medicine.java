package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Medicine 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private long id;

    @Column(name="name", unique=false, nullable=false)
    private String name;
    
    @Column(name="recipeNeed", unique=false, nullable=false)
    private boolean recipeNeed;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable( name = "alternativeMedicine", joinColumns = @JoinColumn(name="mainMedicine", referencedColumnName="id"), inverseJoinColumns = @JoinColumn(name = "alternativeMedicine", referencedColumnName = "id"))
    private Set<Medicine> alternativeMedicine;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MedicineManufacturer medicineManufacturer;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MedicineShape medicineShape;

    public Medicine() {
    }

	public Medicine(long id, String name, boolean recipeNeed, Set<Medicine> alternativeMedicine,
			MedicineManufacturer medicineManufacturer, MedicineShape medicineShape) {
		super();
		this.id = id;
		this.name = name;
		this.recipeNeed = recipeNeed;
		this.alternativeMedicine = alternativeMedicine;
		this.medicineManufacturer = medicineManufacturer;
		this.medicineShape = medicineShape;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRecipeNeed() {
		return recipeNeed;
	}

	public void setRecipeNeed(boolean recipeNeed) {
		this.recipeNeed = recipeNeed;
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
