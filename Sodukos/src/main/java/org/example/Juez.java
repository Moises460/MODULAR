package org.example;

import java.util.Scanner;

public class Juez {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantidad = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        for (int t = 0; t < cantidad; t++) {
            char[][] sudoku = new char[9][9];

            // Lectura del Sudoku (robusta)
            for (int i = 0; i < 9; i++) {
                String fila = sc.nextLine().trim();

                // Saltar líneas vacías
                while (fila.isEmpty()) {
                    fila = sc.nextLine().trim();
                }

                // Eliminar espacios si los hay
                fila = fila.replace(" ", "");

                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = fila.charAt(j);
                }
            }

            // Contar casillas rellenas
            int rellenas = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (sudoku[i][j] != '-') rellenas++;
                }
            }

            // Comprobar simetría
            boolean simetrico = true;
            for (int i = 0; i < 9 && simetrico; i++) {
                for (int j = 0; j < 9; j++) {
                    if ((sudoku[i][j] == '-') != (sudoku[8 - i][8 - j] == '-')) {
                        simetrico = false;
                        break;
                    }
                }
            }

            // Validación final
            if (rellenas <= 32 && simetrico) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }
    }
}
