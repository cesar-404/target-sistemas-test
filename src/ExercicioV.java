import java.util.Scanner;

public class ExercicioV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite algo:");
        String originalString = scanner.nextLine();

        System.out.println("String original: " + originalString);
        System.out.println("String invertida: " + reverseString(originalString));

    }

    public static String reverseString(String originalString) {
        char[] characters = new char[originalString.length()];

        for (int i = 0; i < originalString.length(); i++) {
            characters[i] = originalString.charAt(originalString.length() - 1 - i);
        }

        return new String(characters);
    }
}