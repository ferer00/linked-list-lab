package test.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {
    
    @Test
    void testConstructor() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertEquals(0, list.length());
    }
    
    @Test
    void testAppendAndLength() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append('A');
        assertEquals(1, list.length());
        list.append('B');
        assertEquals(2, list.length());
    }
    
    @Test
    void testGet() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append('A');
        list.append('B');
        assertEquals('A', list.get(0));
        assertEquals('B', list.get(1));
    }
    
    @Test
    void testGetInvalidIndex() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }
}