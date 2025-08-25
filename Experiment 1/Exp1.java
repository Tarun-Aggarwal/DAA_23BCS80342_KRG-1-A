import java.util.ArrayList;
import java.util.List;

class Stack<T> {
    private List<T> list;
    private int capacity;

    public Stack(int size) {
        capacity = size;
        list = new ArrayList<>(size);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean isFull() {
        return list.size() == capacity;
    }

    public void push(T item) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + item);
            return;
        }
        list.add(item);
        System.out.println(item + " pushed into stack.");
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop.");
            return null;
        }
        return list.remove(list.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! No top element.");
            return null;
        }
        return list.get(list.size() - 1);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack elements: ");
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

public class Exp1 {
    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>(5);

        intStack.push(10);
        intStack.push(20);
        intStack.push(30);

        intStack.display();
        System.out.println("Top element: " + intStack.peek());

        intStack.pop();
        intStack.display();

        System.out.println("Is Empty? " + (intStack.isEmpty() ? "true" : "false"));
        System.out.println("Is Full? " + (intStack.isFull() ? "true" : "false"));
    }
}
