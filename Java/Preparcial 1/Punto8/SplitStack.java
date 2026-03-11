import java.util.Stack;

public class SplitStack {
    public static Pair<Stack<Integer>, Stack<Integer>> splitStack(Stack<Integer> s, int i) {
        int size = s.size();

        int[] elementos = new int[size];
        for (int k = size - 1; k >= 0; k--) {
            elementos[k] = s.pop();
        }

        Stack<Integer> primera = new Stack<>();
        for (int k = 0; k < i; k++) {
            primera.push(elementos[k]);
        }

        Stack<Integer> segunda = new Stack<>();
        for (int k = i; k < size; k++) {
            segunda.push(elementos[k]);
        }

        return new Pair<>(primera, segunda);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("Stack original: " + stack);

        Pair<Stack<Integer>, Stack<Integer>> resultado = splitStack(stack, 2);

        System.out.println("Primera subpila (fondo hasta i=2): " + resultado.first);
        System.out.println("Segunda subpila (desde i=2 al tope): " + resultado.second);
    }
}