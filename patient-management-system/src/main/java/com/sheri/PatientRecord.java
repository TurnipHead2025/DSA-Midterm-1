package com.sheri;

public class PatientRecord {
    private String visitDate;
    private String diagnosis;
    private String treatmentNotes;

    //constructor
    public PatientRecord(String visitDate, String diagnosis, String treatmentNotes) {
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.treatmentNotes = treatmentNotes;
    }

    //getters
    public String getVisitDate() {
        return visitDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatmentNotes() {
        return treatmentNotes;
    }

    
}
