package tictactoe;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    private static final int SIZE = 3;
    private static char[][] gameField;
    private static final char X = 'X';
    private static final char O = 'O';

    public static void main(String[] args) {

        initField();
        printField();
        checkField();
    }

    public static void initField() {
        System.out.print("Enter cells:");
        String cells = scanner.nextLine();

        gameField = new char[SIZE][SIZE];

        int count = 0;
        for (int i = 0; i < SIZE * SIZE; i++) {
            gameField[i / SIZE][i % SIZE] = cells.charAt(count);
            count++;
        }
    }

    public static void printField() {
        System.out.println("---------");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean checkField() {

        // check impossible
        int countX = 0;
        int countO = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (gameField[i][j] == X) {
                    countX++;
                }
                if (gameField[i][j] == O) {
                    countO++;
                }
            }
        }

        if (Math.abs(countO - countX) > 1) {
            System.out.println("Impossible");
            return false;
        }

        //check win & impossible win

        if (checkDiagWin(X) || checkDiagWin(O)) {
            return true;
        }

        boolean winX = checkRowColWin(X);
        boolean winO = checkRowColWin(O);

        if (winX && winO) {
            System.out.println("Impossible");
            return true;
        } else if (winX) {
            System.out.println("X wins");
            return true;
        } else if (winO) {
            System.out.println("O wins");
            return true;
        }

        //check draw or not finished
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (gameField[i][j] == ' ' || gameField[i][j] == '_') {
                    System.out.println("Game not finished");
                    return true;
                }
            }
        }
        System.out.println("Draw");
        return true;
    }

    private static boolean checkDiagWin(char symbol) {
        boolean leftRightDiag = true;
        boolean rightLeftDiag = true;

        for (int i = 0; i < SIZE; i++) {
            leftRightDiag &= (gameField[i][i] == symbol);
            rightLeftDiag &= (gameField[SIZE - i - 1][i] == symbol);
        }

        if (leftRightDiag || rightLeftDiag) {
            System.out.println(symbol + " wins");
            return true;
        }
        return false;
    }

    private static boolean checkRowColWin(char symbol) {
        boolean cols, rows;

        for (int col = 0; col < SIZE; col++) {
            cols = true;
            rows = true;

            for (int row = 0; row < SIZE; row++) {
                cols &= (gameField[col][row] == symbol);
                rows &= (gameField[row][col] == symbol);
            }
            if (cols || rows) {
                return true;
            }
        }
        return false;
    }
}