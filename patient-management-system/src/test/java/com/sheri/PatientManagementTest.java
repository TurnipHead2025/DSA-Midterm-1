package com.sheri;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class PatientManagementTest {
    @Test
    void servingEmptyWaitingRoomReturnsNull() {
        WaitingRoom waitingRoom = new WaitingRoom();

        assertNull(waitingRoom.serveNextPatient());
    }

    @Test
    void waitingRoomServesPatientsInArrivalOrder() {
        WaitingRoom waitingRoom = new WaitingRoom();
        waitingRoom.addPatient(new Patient(1, "Patient One", "Checkup"));
        waitingRoom.addPatient(new Patient(2, "Patient Two", "Follow-up"));

        assertEquals(1, waitingRoom.serveNextPatient().getPatientId());
        assertEquals(2, waitingRoom.serveNextPatient().getPatientId());
        assertNull(waitingRoom.serveNextPatient());
    }

    @Test
    void emergencyPatientIsInsertedAtRequestedPosition() {
        WaitingRoom waitingRoom = new WaitingRoom();
        waitingRoom.addPatient(new Patient(1, "Patient One", "Checkup"));
        waitingRoom.addPatient(new Patient(3, "Patient Three", "Follow-up"));
        waitingRoom.insertEmergencyPatient(
                new Patient(2, "Patient Two", "Emergency"), 2);

        assertEquals(1, waitingRoom.serveNextPatient().getPatientId());
        assertEquals(2, waitingRoom.serveNextPatient().getPatientId());
        assertEquals(3, waitingRoom.serveNextPatient().getPatientId());
    }

    @Test
    void patientHistoryNavigationStopsAtOldestAndNewestRecords() {
        PatientHistory history = new PatientHistory();

        assertEquals("2025-01-15", history.getCurrentRecord().getVisitDate());
        assertNull(history.moveToPreviousRecord());
        assertEquals("2025-01-15", history.getCurrentRecord().getVisitDate());

        for (int index = 0; index < 9; index++) {
            history.moveToNextRecord();
        }

        assertEquals("2025-10-22", history.getCurrentRecord().getVisitDate());
        assertNull(history.moveToNextRecord());
        assertEquals("2025-01-15", history.getOldestRecord().getVisitDate());
        assertEquals("2025-10-22", history.getNewestRecord().getVisitDate());
    }
}