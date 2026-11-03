package com.sheri;

import java.util.LinkedList;

public class PatientHistory {
    private final LinkedList<PatientRecord> records = new LinkedList<>();
    private int currentIndex = -1;

    public PatientHistory() {
        addRecord(new PatientRecord("2025-01-15", "Routine checkup", "Routine health review."));
        addRecord(new PatientRecord("2025-02-02", "Brain Fog,", "Discussed symptom management."));
        addRecord(new PatientRecord("2025-03-12", "finger cramp", "Rest and follow-up advised."));
        addRecord(new PatientRecord("2025-04-04", "Follow-up visit", "Symptoms reviewed."));
        addRecord(new PatientRecord("2025-05-21", "Mild dehydration", "Hydration guidance provided."));
        addRecord(new PatientRecord("2025-06-08", "Coding fatigue", "Care instructions provided."));
        addRecord(new PatientRecord("2025-07-14", "Tension headache", "Rest and monitoring advised."));
        addRecord(new PatientRecord("2025-08-03", "Common irriation", "Supportive care discussed."));
        addRecord(new PatientRecord("2025-09-10", "Vaccination visit", "Routine observation completed."));
        addRecord(new PatientRecord("2025-10-22", "Annual physical", "Routine health review."));
    }

    public void addRecord(PatientRecord record) {
        records.addLast(record);
        if (currentIndex == -1) {
            currentIndex = 0;
        }
    }

    public PatientRecord getCurrentRecord() {
        if (currentIndex == -1) {
            return null;
        }
        return records.get(currentIndex);
    }

    public PatientRecord moveToNextRecord() {
        if (currentIndex >= records.size() - 1) {
            return null;
        }
        currentIndex++;
        return records.get(currentIndex);
    }

    public PatientRecord moveToPreviousRecord() {
        if (currentIndex <= 0) {
            return null;
        }
        currentIndex--;
        return records.get(currentIndex);
    }

    public PatientRecord getOldestRecord() {
        return records.peekFirst();
    }

    public PatientRecord getNewestRecord() {
        return records.peekLast();
    }
}