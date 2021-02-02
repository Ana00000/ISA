package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Pharmacy {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Long id;

    private int grade;

    @Column( nullable = false )
    private String name;

    private String description;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private Address address;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private PharmacyAdmin pharmacyAdmin;

    public Pharmacy(Long id, int grade, String name, String description, Address address, PharmacyAdmin pharmacyAdmin) {
        this.id = id;
        this.grade = grade;
        this.name = name;
        this.description = description;
        this.address = address;
        this.pharmacyAdmin = pharmacyAdmin;
    }

    public Pharmacy(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pharmacy pharmacy = (Pharmacy) o;
        return grade == pharmacy.grade &&
                Objects.equals(id, pharmacy.id) &&
                Objects.equals(name, pharmacy.name) &&
                Objects.equals(description, pharmacy.description) &&
                Objects.equals(address, pharmacy.address) &&
                Objects.equals(pharmacyAdmin, pharmacy.pharmacyAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, grade, name, description, address, pharmacyAdmin);
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "id=" + id +
                ", grade=" + grade +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address=" + address +
                ", pharmacyAdmin=" + pharmacyAdmin +
                '}';
    }
}
