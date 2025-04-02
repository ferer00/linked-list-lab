package main.java;
public class DoublyLinkedList {
    private static class Node {
        Character data;
        Node prev;
        Node next;

        Node(Character data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
}