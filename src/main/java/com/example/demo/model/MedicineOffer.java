package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.junit.Ignore;

import javax.persistence.*;

@Entity
@Ignore
public class MedicineOffer {

    @Id
    @SequenceGenerator(name = "medicineOfferIdSeqGen", sequenceName = "medicineOfferIdSeqGen", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicineOfferIdSeqGen")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="pharmacy_id", referencedColumnName = "id")
    @JsonManagedReference //this will be serialized
    private Supplier supplier;


    private MedicineOrder medicineOrder;
}
