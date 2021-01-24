/**
 * Class AppointmentStatus
 * AUTHOR: Aleksandar Hadzibabic
 * DATE: 24/1/2021
 */
package com.example.demo.model;

import javax.persistence.*;

enum AppointmentStatusValue{ UPCOMING, DONE, DENIED }

@Entity
public class AppointmentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusID;
    @Column(unique = true, nullable = false)
    private AppointmentStatusValue statusValue;

    public AppointmentStatus() {
    }

    public AppointmentStatus(int statusID, AppointmentStatusValue statusValue) {
        this.statusID = statusID;
        this.statusValue = statusValue;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public AppointmentStatusValue getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(AppointmentStatusValue statusValue) {
        this.statusValue = statusValue;
    }
}
