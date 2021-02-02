package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class City {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( nullable = false )
    private String name;

    @Column( nullable = false, unique = true )
    private Long postalCode;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Country country;

    public City(Long id, String name, Long postalCode, Country country) {
        this.id = id;
        this.name = name;
        this.postalCode = postalCode;
        this.country = country;
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

    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) &&
                Objects.equals(name, city.name) &&
                Objects.equals(postalCode, city.postalCode) &&
                Objects.equals(country, city.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, postalCode, country);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postalCode=" + postalCode +
                ", country=" + country +
                '}';
    }
}
