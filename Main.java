package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size = 3;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells:");
        char[] array = scanner.nextLine().toCharArray();
        System.out.println("---------");
        for (int i = 0; i < size * size; i += size) {
            System.out.println(String.format("| %c %c %c |", array[i], array[i+1], array[i+2]));
        }
        System.out.println("---------");
    }
}
