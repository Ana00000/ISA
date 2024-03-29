package com.example.demo.model;

import com.example.demo.dto.MedicineDTO;
import com.example.demo.dto.MedicineIngredientDTO;
import com.example.demo.dto.MedicineToAddDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;
import org.junit.Ignore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Medicine implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(name="name", unique=false, nullable=false)
    private String name;

	@Column(name="contraindications", unique=false, nullable=true)
	private String contraindications;

	@Column(name="recommendedIntake", unique=false, nullable=true)
	private int recommendedIntake;

	@Column(name="code", unique=false, nullable=true)
	private String code;

	@Column(name="points", unique=false, nullable=true)
	private int points;
    
    @Column(name="recipeNeed", unique=false, nullable=false)
    private boolean recipeNeed;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable( name = "alternativeMedicine", joinColumns = @JoinColumn(name="mainMedicineId", referencedColumnName="id"), inverseJoinColumns = @JoinColumn(name = "alternativeMedicineId", referencedColumnName = "id"))
    private Set<Medicine> alternativeMedicine = new HashSet<Medicine>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MedicineManufacturer medicineManufacturer;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MedicineShape medicineShape;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable( name = "ingredientsOfMedicine", joinColumns = @JoinColumn(name="ingredient_id", referencedColumnName="id"), inverseJoinColumns = @JoinColumn(name = "medicine_id", referencedColumnName = "id"))
    private Set<MedicineIngredient> ingredients = new HashSet<MedicineIngredient>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="medicineTypeId", referencedColumnName = "id")
    private MedicineType medicineType;

	@Version
	private Long version;

    public Medicine() {
    }

    public Medicine(MedicineDTO medicineDTO) {
    	this.id = medicineDTO.getId();
    	this.name = medicineDTO.getName();
    }

    public Medicine(MedicineToAddDTO medicineToAddDTO){
    	this.id = medicineToAddDTO.getId();
    	this.name = medicineToAddDTO.getName();
    	this.code = medicineToAddDTO.getCode();
    	this.recipeNeed = medicineToAddDTO.isRecipeNeed();
    	this.contraindications = medicineToAddDTO.getContraindications();
    	this.recommendedIntake = medicineToAddDTO.getRecommendedIntake();
    	this.points = medicineToAddDTO.getPoints();
	}

	public Medicine(Long id, String name, boolean recipeNeed, Set<Medicine> alternativeMedicine,
			MedicineManufacturer medicineManufacturer, MedicineShape medicineShape,
			Set<MedicineIngredient> ingredients, int points) {
		super();
		this.id = id;
		this.name = name;
		this.recipeNeed = recipeNeed;
		this.alternativeMedicine = alternativeMedicine;
		this.medicineManufacturer = medicineManufacturer;
		this.medicineShape = medicineShape;
		this.ingredients = ingredients;
		this.points = points;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getRecommendedIntake() {
		return recommendedIntake;
	}

	public void setRecommendedIntake(int recommendedIntake) {
		this.recommendedIntake = recommendedIntake;
	}

	public String getContraindications() {
		return contraindications;
	}

	public void setContraindications(String contraindications) {
		this.contraindications = contraindications;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMedicineType(MedicineType medicineType) {
		this.medicineType = medicineType;
	}

	public String getCode() {
		return code;
	}

	public MedicineType getMedicineType() {
		return medicineType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRecipeNeeded() {
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
	
	public Set<MedicineIngredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<MedicineIngredient> ingredients) {
		this.ingredients = ingredients;
	}

	public boolean isRecipeNeed() {
		return recipeNeed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alternativeMedicine == null) ? 0 : alternativeMedicine.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + ((medicineManufacturer == null) ? 0 : medicineManufacturer.hashCode());
		result = prime * result + ((medicineShape == null) ? 0 : medicineShape.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (recipeNeed ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicine other = (Medicine) obj;
		if (alternativeMedicine == null) {
			if (other.alternativeMedicine != null)
				return false;
		} else if (!alternativeMedicine.equals(other.alternativeMedicine))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		if (medicineManufacturer == null) {
			if (other.medicineManufacturer != null)
				return false;
		} else if (!medicineManufacturer.equals(other.medicineManufacturer))
			return false;
		if (medicineShape == null) {
			if (other.medicineShape != null)
				return false;
		} else if (!medicineShape.equals(other.medicineShape))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (recipeNeed != other.recipeNeed)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", recipeNeed=" + recipeNeed + ", alternativeMedicine="
				+ alternativeMedicine + ", medicineManufacturer=" + medicineManufacturer + ", medicineShape="
				+ medicineShape + ", ingredients=" + ingredients + "]";
	}
}
