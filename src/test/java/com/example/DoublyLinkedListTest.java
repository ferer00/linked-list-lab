package com.example;

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

    @Test
    void testInsertAtStart() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append('B');
        list.insert('A', 0);
        assertEquals(2, list.length());
        assertEquals('A', list.get(0));
        assertEquals('B', list.get(1));
    }

    @Test
    void testInsertInMiddle() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append('A');
        list.append('C');
        list.insert('B', 1);
        assertEquals(3, list.length());
        assertEquals('A', list.get(0));
        assertEquals('B', list.get(1));
        assertEquals('C', list.get(2));
    }

    @Test
    void testInsertAtEnd() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append('A');
        list.insert('B', 1);
        assertEquals(2, list.length());
        assertEquals('A', list.get(0));
        assertEquals('B', list.get(1));
    }

    @Test
    void testInsertInvalidIndex() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert('A', -1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert('A', 2));
    }

    @Test
    void testDeleteFromStart() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append('A');
        list.append('B');
        assertEquals('A', list.delete(0));
        assertEquals(1, list.length());
        assertEquals('B', list.get(0));
    }

    @Test
    void testDeleteFromMiddle() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append('A');
        list.append('B');
        list.append('C');
        assertEquals('B', list.delete(1));
        assertEquals(2, list.length());
        assertEquals('A', list.get(0));
        assertEquals('C', list.get(1));
    }

    @Test
    void testDeleteFromEnd() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append('A');
        list.append('B');
        assertEquals('B', list.delete(1));
        assertEquals(1, list.length());
        assertEquals('A', list.get(0));
    }

    @Test
    void testDeleteInvalidIndex() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(0));
    }

    @Test
    void testDeleteAll() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append('A');
        list.append('B');
        list.append('A');
        list.append('C');
        list.append('A');
        
        list.deleteAll('A');
        assertEquals(2, list.length());
        assertEquals('B', list.get(0));
        assertEquals('C', list.get(1));
    }

    @Test
    void testDeleteAllNotFound() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append('B');
        list.append('C');
        
        list.deleteAll('A');
        assertEquals(2, list.length());
    }

    @Test
    void testClone() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append('A');
        list.append('B');
        list.append('C');
        
        DoublyLinkedList clone = list.clone();
        assertEquals(3, clone.length());
        assertEquals('A', clone.get(0));
        assertEquals('B', clone.get(1));
        assertEquals('C', clone.get(2));
        
        list.delete(0);
        assertEquals(3, clone.length());
    }

    @Test
    void testReverse() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append('A');
        list.append('B');
        list.append('C');
        
        list.reverse();
        assertEquals(3, list.length());
        assertEquals('C', list.get(0));
        assertEquals('B', list.get(1));
        assertEquals('A', list.get(2));
    }

    @Test
    void testReverseEmptyList() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.reverse();
        assertEquals(0, list.length());
    }

    @Test
    void testFindFirst() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append('A');
        list.append('B');
        list.append('A');
        list.append('C');
        
        assertEquals(0, list.findFirst('A'));
        assertEquals(1, list.findFirst('B'));
        assertEquals(3, list.findFirst('C'));
        assertEquals(-1, list.findFirst('D'));
    }

    @Test
    void testFindLast() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append('A');
        list.append('B');
        list.append('A');
        list.append('C');
        
        assertEquals(2, list.findLast('A'));
        assertEquals(1, list.findLast('B'));
        assertEquals(3, list.findLast('C'));
        assertEquals(-1, list.findLast('D'));
    }

    @Test
    void testClear() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append('A');
        list.append('B');
        list.append('C');
        
        list.clear();
        assertEquals(0, list.length());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void testExtend() {
        DoublyLinkedList list1 = new DoublyLinkedList();
        list1.append('A');
        list1.append('B');
        
        DoublyLinkedList list2 = new DoublyLinkedList();
        list2.append('C');
        list2.append('D');
        
        list1.extend(list2);
        assertEquals(4, list1.length());
        assertEquals('A', list1.get(0));
        assertEquals('B', list1.get(1));
        assertEquals('C', list1.get(2));
        assertEquals('D', list1.get(3));
        
        list2.delete(0);
        assertEquals(4, list1.length());
    }

    @Test
    void testExtendWithEmptyList() {
        DoublyLinkedList list1 = new DoublyLinkedList();
        list1.append('A');
        
        DoublyLinkedList list2 = new DoublyLinkedList();
        
        list1.extend(list2);
        assertEquals(1, list1.length());
        assertEquals('A', list1.get(0));
    }
}