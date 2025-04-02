package main.java;
import java.util.ArrayList;

public class ArrayListCharacterList {
    private ArrayList<Character> list;

    public ArrayListCharacterList() {
        list = new ArrayList<>();
    }

    public int length() {
        return list.size();
    }

    public void append(Character element) {
        list.add(element);
    }

    public void insert(Character element, int index) throws IndexOutOfBoundsException {
        list.add(index, element);
    }

    public Character delete(int index) throws IndexOutOfBoundsException {
        return list.remove(index);
    }

    public void deleteAll(Character element) {
        list.removeIf(e -> e.equals(element));
    }

    public Character get(int index) throws IndexOutOfBoundsException {
        return list.get(index);
    }

    public ArrayListCharacterList clone() {
        ArrayListCharacterList newList = new ArrayListCharacterList();
        newList.list = (ArrayList<Character>) this.list.clone();
        return newList;
    }

    public void reverse() {
        ArrayList<Character> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        list = reversed;
    }

    public int findFirst(Character element) {
        return list.indexOf(element);
    }

    public int findLast(Character element) {
        return list.lastIndexOf(element);
    }

    public void clear() {
        list.clear();
    }

    public void extend(ArrayListCharacterList elements) {
        ArrayListCharacterList copy = elements.clone();
        list.addAll(copy.list);
    }

    public static void main(String[] args) {
        System.out.println("=== Демонстрація роботи ArrayListCharacterList ===");
        
        ArrayListCharacterList charList = new ArrayListCharacterList();
        
        System.out.println("\n1. Додавання елементів:");
        charList.append('A');
        charList.append('B');
        charList.append('C');
        System.out.println("Список після додавання A, B, C: " + charList.list);
        System.out.println("Довжина списку: " + charList.length());
        
        System.out.println("\n2. Вставка елемента:");
        charList.insert('D', 1);
        System.out.println("Список після вставки D на позицію 1: " + charList.list);
        
        System.out.println("\n3. Отримання елемента:");
        System.out.println("Елемент на позиції 2: " + charList.get(2));
        
        System.out.println("\n4. Видалення елемента:");
        char removed = charList.delete(2);
        System.out.println("Видалений елемент: " + removed);
        System.out.println("Список після видалення: " + charList.list);
        
        System.out.println("\n5. Пошук елементів:");
        charList.append('A');
        charList.append('B');
        charList.append('A');
        System.out.println("Список після додавання A, B, A: " + charList.list);
        System.out.println("Перше входження 'A': " + charList.findFirst('A'));
        System.out.println("Останнє входження 'B': " + charList.findLast('B'));
        
        System.out.println("\n6. Видалення всіх 'A':");
        charList.deleteAll('A');
        System.out.println("Список після видалення: " + charList.list);
        
        System.out.println("\n7. Копіювання списку:");
        ArrayListCharacterList copiedList = charList.clone();
        System.out.println("Копія списку: " + copiedList.list);
        
        System.out.println("\n8. Обернення списку:");
        charList.reverse();
        System.out.println("Обернений список: " + charList.list);
        
        System.out.println("\n9. Розширення списку:");
        charList.extend(copiedList);
        System.out.println("Список після розширення: " + charList.list);
        
        System.out.println("\n10. Очищення списку:");
        charList.clear();
        System.out.println("Довжина списку після очищення: " + charList.length());
    }
    
    private static String listToString(ArrayListCharacterList list) {
        return list.list.toString();
    }
}