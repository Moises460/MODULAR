package org.example;

import java.util.Scanner;

/**
 * @author Moises
 * @version 1.0
 * Programa para validar tableros de Sudoku
 */
public class Sudokus {

    /**
     * @author Moises
     * @version 1.0
     * Metodo principal del programa
     * @param args - argumentos de linea de comandos
     */
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        int cantidad = 0;
        boolean valido = false;

        System.out.println("SUDOKUS");
        System.out.println("¿CUANTOS SUDOKUS QUIERES COMPROBAR?");

        while (!valido) {
            if (tc.hasNextInt()) {
                cantidad = tc.nextInt();
                tc.nextLine();
                valido = true;
            } else {
                System.out.println("SOLO SE ADMITE NUMEROS");
                tc.nextLine();
            }
        }

        for (int i = 0; i < cantidad; i++) {
            char[][] sudoku = Lectura(tc);

            if (Validador(sudoku)) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }
    }

    /**
     * @author Moises
     * @version 1.0
     * Metodo para leer un tablero de Sudoku
     * @param tc - Scanner para leer datos
     * @return - Devuelve el tablero de Sudoku
     */
    public static char[][] Lectura(Scanner tc) {
        char[][] sudoku = new char[9][9];

        for (int i = 0; i < 9; i++) {
            String fila = tc.nextLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = fila.charAt(j);
            }
        }
        return sudoku;
    }

    /**
     * @author Moises
     * @version 1.0
     * Metodo para contar las casillas rellenas
     * @param sudoku - tablero de Sudoku
     * @return - Devuelve el numero de casillas rellenas
     */
    public static int Contarlinea(char[][] sudoku) {
        int contador = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] != '-') {
                    contador++;
                }
            }
        }
        return contador;
    }

    /**
     * @author Moises
     * @version 1.0
     * Metodo para comprobar la simetria del Sudoku
     * @param sudoku - tablero de Sudoku
     * @return - Devuelve true si es simetrico
     */
    public static boolean Comprobar_simetria(char[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ((sudoku[i][j] == '-') != (sudoku[8 - i][8 - j] == '-')) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @author Moises
     * @version 1.0
     * Metodo para validar un Sudoku
     * @param sudoku - tablero de Sudoku
     * @return - Devuelve true si el Sudoku es valido
     */
    public static boolean Validador(char[][] sudoku) {
        return Contarlinea(sudoku) <= 32 && Comprobar_simetria(sudoku);
    }
}

























