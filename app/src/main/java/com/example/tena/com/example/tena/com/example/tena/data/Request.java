package com.example.tena.com.example.tena.com.example.tena.data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Request implements Serializable {


    @PrimaryKey(autoGenerate = true)
    private int id;

    private String patientFullName;
    private String email;
    private String description;
    private int photo;
    private int verificationFile;
    private int progress;
    private int age;
    private int amount;


//    private Rate rate;

    public Request(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientFullName() {
        return patientFullName;
    }

    public void setPatientFullName(String patientFullName) {
        this.patientFullName = patientFullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getVerificationFile() {
        return verificationFile;
    }

    public void setVerificationFile(int verificationFile) {
        this.verificationFile = verificationFile;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

//    public Rate getRate() {
//        return rate;
//    }
//
//    public void setRate(Rate rate) {
//        this.rate = rate;
//    }
}
