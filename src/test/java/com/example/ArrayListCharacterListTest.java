
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayListCharacterListTest {
    
    @Test
    void testConstructor() {
        ArrayListCharacterList list = new ArrayListCharacterList();
        assertEquals(0, list.length());
    }
    
    @Test
    void testAppendAndLength() {
        ArrayListCharacterList list = new ArrayListCharacterList();
        list.append('A');
        assertEquals(1, list.length());
        list.append('B');
        assertEquals(2, list.length());
    }
    
    @Test
    void testInsert() {
        ArrayListCharacterList list = new ArrayListCharacterList();
        list.append('A');
        list.append('C');
        
        list.insert('B', 1);
        assertEquals(3, list.length());
        assertEquals('B', list.get(1));
    }
    
    @Test
    void testInsertInvalidIndex() {
        ArrayListCharacterList list = new ArrayListCharacterList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert('A', -1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert('A', 1));
    }
    
    @Test
    void testDelete() {
        ArrayListCharacterList list = new ArrayListCharacterList();
        list.append('A');
        list.append('B');
        list.append('C');
        
        assertEquals('B', list.delete(1));
        assertEquals(2, list.length());
        assertEquals('A', list.get(0));
        assertEquals('C', list.get(1));
    }
    
    @Test
    void testDeleteInvalidIndex() {
        ArrayListCharacterList list = new ArrayListCharacterList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(0));
    }
    
    @Test
    void testDeleteAll() {
        ArrayListCharacterList list = new ArrayListCharacterList();
        list.append('A');
        list.append('B');
        list.append('A');
        list.append('C');
        
        list.deleteAll('A');
        assertEquals(2, list.length());
        assertEquals('B', list.get(0));
        assertEquals('C', list.get(1));
    }
    
    @Test
    void testGet() {
        ArrayListCharacterList list = new ArrayListCharacterList();
        list.append('A');
        list.append('B');
        
        assertEquals('A', list.get(0));
        assertEquals('B', list.get(1));
    }
    
    @Test
    void testGetInvalidIndex() {
        ArrayListCharacterList list = new ArrayListCharacterList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }
    
    @Test
    void testClone() {
        ArrayListCharacterList list = new ArrayListCharacterList();
        list.append('A');
        list.append('B');
        
        ArrayListCharacterList clone = list.clone();
        assertEquals(2, clone.length());
        assertEquals('A', clone.get(0));
        assertEquals('B', clone.get(1));
        
        // Переконуємось, що це глибока копія
        list.delete(0);
        assertEquals(2, clone.length());
    }
    
    @Test
    void testReverse() {
        ArrayListCharacterList list = new ArrayListCharacterList();
        list.append('A');
        list.append('B');
        list.append('C');
        
        list.reverse();
        assertEquals('C', list.get(0));
        assertEquals('B', list.get(1));
        assertEquals('A', list.get(2));
    }
    
    @Test
    void testFindFirst() {
        ArrayListCharacterList list = new ArrayListCharacterList();
        list.append('A');
        list.append('B');
        list.append('A');
        
        assertEquals(0, list.findFirst('A'));
        assertEquals(1, list.findFirst('B'));
        assertEquals(-1, list.findFirst('C'));
    }
    
    @Test
    void testFindLast() {
        ArrayListCharacterList list = new ArrayListCharacterList();
        list.append('A');
        list.append('B');
        list.append('A');
        
        assertEquals(2, list.findLast('A'));
        assertEquals(1, list.findLast('B'));
        assertEquals(-1, list.findLast('C'));
    }
    
    @Test
    void testClear() {
        ArrayListCharacterList list = new ArrayListCharacterList();
        list.append('A');
        list.append('B');
        
        list.clear();
        assertEquals(0, list.length());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }
    
    @Test
    void testExtend() {
        ArrayListCharacterList list1 = new ArrayListCharacterList();
        list1.append('A');
        list1.append('B');
        
        ArrayListCharacterList list2 = new ArrayListCharacterList();
        list2.append('C');
        list2.append('D');
        
        list1.extend(list2);
        assertEquals(4, list1.length());
        assertEquals('A', list1.get(0));
        assertEquals('B', list1.get(1));
        assertEquals('C', list1.get(2));
        assertEquals('D', list1.get(3));
        
        // Переконуємось, що це глибока копія
        list2.delete(0);
        assertEquals(4, list1.length());
    }
}