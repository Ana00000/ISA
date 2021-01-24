/**
 * Class Patient
 * AUTHOR: Aleksandar Hadzibabic
 * DATE: 24/1/2021
 */

package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Patient extends User
{
    @Column(name="appID", unique=false, nullable=false)
    private Integer id;

    public Patient(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
