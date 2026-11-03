package com.sheri;

public class Patient {
    private int patientId;
    private String name;
    private String reasonforVisit;


    //constructor for Patient class
    public Patient(int patientId, String name, String reasonforVisit) {
        this.patientId = patientId;
        this.name = name;
        this.reasonforVisit = reasonforVisit;
    }

    //getters
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public String getReasonforVisit() {
        return reasonforVisit;
    }

    //setters
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReasonforVisit(String reasonforVisit) {
        this.reasonforVisit = reasonforVisit;
    }

    //toString
    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", name='" + name + '\'' +
                ", reasonforVisit='" + reasonforVisit + '\'' +
                '}';
    }
}
