import java.util.Stack;

public class Splicestack {
    public static Stack<Integer> spliceStack(Stack<Integer> s, int i, int j) {
        int size = s.size();
        int[] elementos = new int[size];
        for (int k = size - 1; k >= 0; k--) {
            elementos[k] = s.pop();
        }

        Stack<Integer> resultado = new Stack<>();
        for (int k = i; k < j; k++) {
            resultado.push(elementos[k]);
        }

        for (int k = 0; k < size; k++) {
            if (k < i || k >= j) {
                s.push(elementos[k]);
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("Stack original: " + stack);

        Stack<Integer> spliced = spliceStack(stack, 1, 4);

        System.out.println("Stack resultante (splice): " + spliced);
        System.out.println("Stack original tras splice: " + stack);
    }
}