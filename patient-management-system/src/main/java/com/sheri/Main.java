package com.sheri;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WaitingRoom waitingRoom = new WaitingRoom();
        PatientHistory patientHistory = new PatientHistory();
        boolean running = true;

        while (running) {
            System.out.println("1. Patient waiting room");
            System.out.println("2. Patient history");
            System.out.println("0. Exit");

            switch (readInt(scanner, "Choose: ")) {
                case 1 -> waitingRoomMenu(scanner, waitingRoom);
                case 2 -> historyMenu(scanner, patientHistory);
                case 0 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    private static void waitingRoomMenu(Scanner scanner, WaitingRoom waitingRoom) {
        boolean inMenu = true;

        while (inMenu) {
            System.out.println("1. Add patient");
            System.out.println("2. Serve next patient");
            System.out.println("3. Insert emergency patient");
            System.out.println("4. Print waiting room");
            System.out.println("0. Back");

            switch (readInt(scanner, "Choose: ")) {
                case 1 -> {
                    int patientId = readInt(scanner, "Patient ID: ");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Reason for visit: ");
                    String reason = scanner.nextLine();
                    waitingRoom.addPatient(new Patient(patientId, name, reason));
                }
                case 2 -> {
                    Patient patient = waitingRoom.serveNextPatient();
                    if (patient == null) {
                        System.out.println("Waiting room is empty.");
                    } else {
                        System.out.println("Serving: " + patient);
                    }
                }
                case 3 -> {
                    int patientId = readInt(scanner, "Patient ID: ");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Reason for visit: ");
                    String reason = scanner.nextLine();
                    int position = readInt(scanner, "Position (1 is the front): ");
                    try {
                        waitingRoom.insertEmergencyPatient(
                                new Patient(patientId, name, reason), position);
                    } catch (IndexOutOfBoundsException exception) {
                        System.out.println(exception.getMessage());
                    }
                }
                case 4 -> waitingRoom.printPatients();
                case 0 -> inMenu = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void historyMenu(Scanner scanner, PatientHistory patientHistory) {
        boolean inMenu = true;

        while (inMenu) {
            System.out.println("1. Show current record");
            System.out.println("2. Next record");
            System.out.println("3. Previous record");
            System.out.println("4. Show oldest record");
            System.out.println("5. Show newest record");
            System.out.println("0. Back");

            switch (readInt(scanner, "Choose: ")) {
                case 1 -> showRecord(patientHistory.getCurrentRecord());
                case 2 -> showRecord(patientHistory.moveToNextRecord());
                case 3 -> showRecord(patientHistory.moveToPreviousRecord());
                case 4 -> showRecord(patientHistory.getOldestRecord());
                case 5 -> showRecord(patientHistory.getNewestRecord());
                case 0 -> inMenu = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void showRecord(PatientRecord record) {
        if (record == null) {
            System.out.println("No record available in that direction.");
            return;
        }

        System.out.println("Visit date: " + record.getVisitDate());
        System.out.println("Diagnosis: " + record.getDiagnosis());
        System.out.println("Treatment notes: " + record.getTreatmentNotes());
    }

    private static int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}