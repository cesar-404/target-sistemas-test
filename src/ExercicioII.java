import java.util.Scanner;

public class ExercicioII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entre com um número:");
        int target = Integer.parseInt(scanner.nextLine());

        if (isFibonacci(target)) {
            System.out.println("O numero " + target + " pertence a sequência de Fibonacci.");
        } else {
            System.out.println("O número " + target + " não pertence a sequência de Fibonacci.");
        }

        scanner.close();
    }

    public static boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(num);
        return squareRoot * squareRoot == num;
    }

    public static boolean isFibonacci(int num) {
        return isPerfectSquare(5 * num * num + 4) || isPerfectSquare(5 * num * num - 4);
    }
}