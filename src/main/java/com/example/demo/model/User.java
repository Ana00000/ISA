package com.example.demo.model;
import javax.persistence.*;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

@Entity
@Table(name="hospitalUsers") 
@Inheritance(strategy=TABLE_PER_CLASS)
public abstract class User 
{
    @Id
    @SequenceGenerator(name = "usersIdSeqGen", sequenceName = "usersIdSeq", initialValue = 10, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersIdSeqGen")
    @Column(name="id", unique=true, nullable=false)
    private long id;

    @Column(name="name", unique=false, nullable=false)
    private String name;

    @Column(name="lastName", unique=false, nullable=false)
    private String lastName;

	public User() {
	}
	
	public User(long id, String name, String lastName) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}