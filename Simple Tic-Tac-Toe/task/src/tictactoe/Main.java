package tictactoe;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // write your code here
//        play();
        int i = 0;
        char[][] array = new char[3][3];
        for (int j = 0; j < array.length; j++) {
            for (int k = 0; k < array[j].length; k++) {
                array[j][k] = ' ';
            }
        }
        result(array);
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter the coordinates:");
            try {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (a > 3 || b > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    if (array[a - 1][ b - 1] == 'X' || array[a - 1][ b - 1] == 'O' ) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        if (i % 2 == 0) {
                            array[a - 1][ b - 1] = 'X';
                        } else {
                            array[a - 1][ b - 1] = 'O';
                        }
                        i++;
                        result(array);
                        if ("X wins".equals(check(array))) {
                            System.out.println(check(array));
                            break;
                        } else if ("O wins".equals(check(array))) {
                            System.out.println(check(array));
                            break;
                        } else if ("Draw".equals(check(array))) {
                            if (checkAll(array)) {
                                System.out.println(check(array));
                                break;
                            } else {
                                continue;
                            }
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }

        }

    }

    private static boolean checkAll(char[][] array) {
        char spcae = 32;
        int x = 0;
        for (int i = 0; i < 3; i++) {
            for (char[] a : array) {
                if (a[i] == spcae) {
                    x++;
                }
            }
        }
        if (x == 0) {
            return true;
        }
        return false;
    }


    private static String check(char[][] array) {
        int x = 0;
        int o = 0;
        char[] xo = {'X','O'};
        for (int i = 0; i < xo.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[j][0] == xo[i] && array[j][1] == xo[i] && array[j][2] == xo[i]
                    || array[0][j] == xo[i] && array[1][j] == xo[i] && array[2][j] == xo[i]
                        || array[0][j] == xo[i] && array[1][1] == xo[i] && array[2][2 - j] == xo[i]) {
                    if (i == 0) {
                        x = 1;
                        break;
                    } else {
                        o = 1;
                        break;
                    }
                }
            }
        }
        if (x == 1 && o == 0) {
            return "X wins";
        } else if (o == 1 && x == 0){
            return "O wins";
        } else {
            return "Draw";
        }
    }

    private static void result(char[][] array) {
        System.out.println("---------");
        for (int i = 0; i < array.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

    }
}
