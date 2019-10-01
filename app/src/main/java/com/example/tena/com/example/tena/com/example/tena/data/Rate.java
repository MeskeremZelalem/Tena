package com.example.tena.com.example.tena.com.example.tena.data;

import androidx.room.Entity;

import java.io.Serializable;

@Entity
public class Rate implements Serializable {

    private String patientFullName;
    private int numberOfRate;

    public String getPatientFullName() {
        return patientFullName;
    }

    public void setPatientFullName(String patientFullName) {
        this.patientFullName = patientFullName;
    }

    public int getNumberOfRate() {
        return numberOfRate;
    }

    public void setNumberOfRate(int numberOfRate) {
        this.numberOfRate = numberOfRate;
    }
}
