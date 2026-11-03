package com.sheri;


//Node = [ patient | next ]
//`patient` is the node’s *value.
//`next` is the node’s pointer to another node.
//`head` and `tail` are pointers outside the node, pointing at particular nodes.
//`tail.next` is the `next` pointer inside the node that `tail` points to.
//`newNode` = reference to the newly created node (reference var)

//Made own node class for practice


public class WaitingRoom {
    private Node head;
    private Node tail; 

    private class Node {
        private Patient patient;
        private Node next;

        private Node(Patient patient){
            this.patient = patient;
        }
    }

    public void addPatient(Patient patient) {
        Node newNode = new Node(patient);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Patient serveNextPatient() {
        if (head == null) {
            return null;
        }

        Patient servedPatient = head.patient;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        return servedPatient;
    }

    public void insertEmergencyPatient(Patient patient, int position) {
        if (position < 1) {
            throw new IndexOutOfBoundsException("Position must be at least 1.");
        }

        Node newNode = new Node(patient);

        if (position == 1) {
            newNode.next = head;
            head = newNode;

            if (tail == null) {
                tail = newNode;
            }
            return;
        }

        Node current = head;
        int currentPosition = 1;

        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Position is past the end of the queue.");
        }

        newNode.next = current.next;
        current.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }
    }

    public void printPatients() {
        if (head == null) {
            System.out.println("Waiting room is empty.");
            return;
        }

        Node current = head;
        int position = 1;

        while (current != null) {
            System.out.println(position + ". " + current.patient);
            current = current.next;
            position++;
        }
    }
}
