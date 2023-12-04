
import java.util.Stack;

class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        mainStack.push(value);

        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public void pop() {
        if (!mainStack.isEmpty()) {
            int poppedValue = mainStack.pop();

            if (poppedValue == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    // public int top() {
    // return mainStack.isEmpty() ? -1 : mainStack.peek();
    // }

    public int min() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
}

public class Problem2 {
    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(3);
        stack.push(5);
        System.out.println("Min: " + stack.min()); // Output: 3

        stack.push(2);
        stack.push(1);
        System.out.println("Min: " + stack.min()); // Output: 1

        stack.pop();

        System.out.println("Min: " + stack.min()); // Output: 2
    }
}
