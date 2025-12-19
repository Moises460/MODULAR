package org.example;

import java.util.Scanner;

public class Juez {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        int cantidad = tc.nextInt();


        for (int i = 0; i < cantidad; i++) {
            char[][] sudoku = new char[9][9];


            for (int n = 0; n < 9; n++) {
                String fila = tc.nextLine();
                for (int j = 0; j < 9; j++) {
                    sudoku[j][j] = fila.charAt(j);
                }
            }


            int rellenas = 0;
            for (int n = 0; n < 9; n++) {
                for (int j = 0; j < 9; j++) {
                    if (sudoku[n][j] != '-') rellenas++;
                }
            }


            boolean simetrico = true;
            for (int n = 0; n < 9 && simetrico; n++) {
                for (int j = 0; j < 9; j++) {
                    if ((sudoku[n][j] == '-') != (sudoku[8 - n][8 - j] == '-')) {
                        simetrico = false;
                        break;
                    }
                }
            }


            if (rellenas <= 32 && simetrico) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }
    }
}
