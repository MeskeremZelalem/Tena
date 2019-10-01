package com.example.tena.com.example.tena.activity;

public class RequestItem {
    String title , description , age ,amount;
    int patientImage;

    public RequestItem(String title, String description, String age, String amount, int patientImage) {
        this.title = title;
        this.description = description;
        this.age = age;
        this.amount = amount;
        this.patientImage = patientImage;
    }

    public RequestItem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getPatientImage() {
        return patientImage;
    }

    public void setPatientImage(int patientImage) {
        this.patientImage = patientImage;
    }
}
