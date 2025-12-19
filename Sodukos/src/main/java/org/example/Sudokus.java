package org.example;

import java.util.Scanner;

/**
 * @author Moises
 * @version 1.0
 * Clase principal para la lectura y validacion de Sudokus.
 * Permite introducir uno o varios Sudokus por teclado y comprobar
 * si cumplen las condiciones de validez.
 */
public class Sudokus {

    /**
     * Metodo principal del programa.
     * Solicita al usuario el numero de Sudokus a comprobar,
     * los lee por teclado y muestra si son validos o no.
     *
     * @param args argumentos de linea de comandos
     */
    public static void main(String[] args) {

        Scanner tc = new Scanner(System.in);
        int cantidad;
        System.out.println("*-----------------------------------*");
        System.out.println("              SUDOKUS");
        System.out.println("*-----------------------------------*");
        System.out.println("¿CUANTOS SUDOKUS QUIERES COMPROBAR?");

        while (!tc.hasNextInt()) {
            System.out.println("SOLO SE ADMITE NUMEROS");
            tc.nextLine();
        }

        cantidad = tc.nextInt();
        tc.nextLine();

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nINTRODUZCA EL SUDOKU " + (i + 1));
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
     * Metodo para leer un Sudoku por teclado.
     * Cada fila debe tener exactamente 9 caracteres.
     * Se admiten numeros del 1 al 9 y el caracter '-'.
     *
     * @param tc objeto Scanner para la lectura de datos
     * @return devuelve una matriz 9x9 con el Sudoku introducido
     */
    public static char[][] Lectura(Scanner tc) {

        char[][] sudoku = new char[9][9];

        for (int i = 0; i < 9; i++) {

            while (true) {
                String fila = tc.nextLine();

                if (fila.length() != 9) {
                    System.out.println("ERROR: DEBE TENER EXACTAMENTE 9 CARACTERES");
                    continue;
                }

                boolean correcta = true;
                for (int j = 0; j < 9; j++) {
                    char busaca = fila.charAt(j);
                    if ((busaca < '1' || busaca > '9') && busaca != '-') {
                        correcta = false;
                        break;
                    }
                }

                if (!correcta) {
                    System.out.println("ERROR: SOLO NUMEROS DEL 1 AL 9 Y '-'");
                    continue;
                }

                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = fila.charAt(j);
                }
                break;
            }
        }
        return sudoku;
    }

    /**
     * @author Moises
     * @version 1.0
     * Metodo para contar la cantidad de numeros introducidos en el Sudoku.
     *
     * @param sudoku tablero de Sudoku
     * @return devuelve el numero de celdas distintas de '-'
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
     * Metodo para comprobar la simetria del Sudoku.
     * Un Sudoku es simetrico si las posiciones vacias ('-')
     * se reflejan respecto al centro del tablero.
     *
     * @param sudoku tablero de Sudoku
     * @return devuelve true si el Sudoku es simetrico
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
     * Metodo para validar un Sudoku.
     * Comprueba que el tablero tenga como maximo 32 numeros introducidos
     * y que sea simetrico respecto al centro.
     *
     * @param sudoku tablero de Sudoku
     * @return devuelve true si el Sudoku es valido, false en caso contrario
     */
    public static boolean Validador(char[][] sudoku) {

        return Contarlinea(sudoku) <= 32 && Comprobar_simetria(sudoku);
    }
}




















