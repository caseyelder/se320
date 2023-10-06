import java.util.Arrays;
public class GenericStack<E> {
    private E[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public GenericStack() {
        this(DEFAULT_CAPACITY);
    }

    public GenericStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive.");
        }
        elements = (E[]) new Object[initialCapacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return elements[size - 1];
    }

    public void push(E o) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size++] = o;
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        E o = elements[--size];
        elements[size] = null; // Helps with garbage collection
        return o;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("stack: ");
        for (int i = size - 1; i >= 0; i--) {
            result.append(elements[i]);
            if (i > 0) {
                result.append(", ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Size of stack: " + stack.getSize());
        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        System.out.println("Size of stack after pops: " + stack.getSize());
    }
}


