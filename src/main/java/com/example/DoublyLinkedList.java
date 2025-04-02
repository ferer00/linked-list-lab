package com.example;

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

    public int length() {
        return size;
    }

    public void append(Character element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void insert(Character element, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }

        if (index == size) {
            append(element);
            return;
        }

        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node current = getNode(index);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    public Character delete(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }

        Node toDelete;
        if (index == 0) {
            toDelete = head;
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (index == size - 1) {
            toDelete = tail;
            tail = tail.prev;
            tail.next = null;
        } else {
            toDelete = getNode(index);
            toDelete.prev.next = toDelete.next;
            toDelete.next.prev = toDelete.prev;
        }
        size--;
        return toDelete.data;
    }

    public void deleteAll(Character element) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
            }
            current = current.next;
        }
    }

    public Character get(int index) throws IndexOutOfBoundsException {
        return getNode(index).data;
    }

    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }

        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    public DoublyLinkedList clone() {
        DoublyLinkedList newList = new DoublyLinkedList();
        Node current = head;
        while (current != null) {
            newList.append(current.data);
            current = current.next;
        }
        return newList;
    }

    public void reverse() {
        Node temp = null;
        Node current = head;
        
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        
        if (temp != null) {
            tail = head;  
            head = temp.prev;
        }
    }

    public int findFirst(Character element) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(element)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public int findLast(Character element) {
        Node current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.data.equals(element)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void extend(DoublyLinkedList elements) {
        if (elements == null || elements.head == null) {
            return;  
        }
        
        DoublyLinkedList copy = elements.clone();
        if (head == null) {
            head = copy.head;
            tail = copy.tail;
        } else {
            tail.next = copy.head;
            if (copy.head != null) {
                copy.head.prev = tail;
            }
            tail = copy.tail;
        }
        size += copy.size;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        
        list.append('A');
        list.append('B');
        list.append('C');
        System.out.println("Після додавання A, B, C: " + listToString(list));
        
        list.insert('D', 1);
        System.out.println("Після вставки D на позицію 1: " + listToString(list));
        
        char deleted = list.delete(2);
        System.out.println("Видалено елемент на позиції 2: " + deleted);
        System.out.println("Після видалення: " + listToString(list));
        
        System.out.println("Перше входження 'A': " + list.findFirst('A'));
        System.out.println("Останнє входження 'B': " + list.findLast('B'));
        
        list.append('A');
        list.append('B');
        list.append('A');
        System.out.println("Після додавання A, B, A: " + listToString(list));
        
        list.deleteAll('A');
        System.out.println("Після видалення всіх 'A': " + listToString(list));
        
        DoublyLinkedList copy = list.clone();
        System.out.println("Копія списку: " + listToString(copy));
        
        list.reverse();
        System.out.println("Після обернення: " + listToString(list));
        
        list.clear();
        System.out.println("Після очищення, довжина: " + list.length());
        
        list.extend(copy);
        System.out.println("Після розширення копією: " + listToString(list));
    }
    
    private static String listToString(DoublyLinkedList list) {
        StringBuilder sb = new StringBuilder("[");
        try {
            for (int i = 0; i < list.length(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(list.get(i));
            }
        } catch (IndexOutOfBoundsException e) {
            return "Error: " + e.getMessage();
        }
        sb.append("]");
        return sb.toString();
    }
}