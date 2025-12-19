package org.example;

import java.util.Scanner;

/**
 * Programa para validar tableros de Sudoku según ciertas condiciones:
 * - Que tenga 32 o menos números rellenados.
 * - Que los espacios vacíos ('-') sean simétricos respecto al centro del tablero.
 *
 * No resuelve Sudokus, solo verifica estas reglas sobre tableros ingresados por el usuario.
 */
public class Sudokus {

    /**
     * Método principal del programa.
     * Pide al usuario cuantos  Sudokus hay para  verificar,
     * lee cada Sudoku, y valida si cumple las condiciones.
     *
     * @param args argumentos de línea de comandos (no se utilizan)
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

        if(cantidad == 1){
            System.out.println("INTRODUZCA EL SUDOKUS");
        } else {
            System.out.println("INTRODUZCA LOS SUDOKUS");
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
     * Lee un tablero de Sudoku desde el teclado.
     * Cada fila debe tener exactamente 9 caracteres, que pueden ser '1'-'9' o '-'.
     *
     * @param tc Scanner para leer la entrada del usuario
     * @return devuelve el tablero completo
     */
    public static char[][] Lectura(Scanner tc) {
        char[][] sudoku = new char[9][9];

        for (int i = 0; i < 9; i++) {
            boolean validar_fila = false;

            while (!validar_fila) {
                System.out.print("FILA [" + (i + 1) + "] -> ");
                String fila = tc.nextLine();

                if (fila.length() != 9) {
                    System.out.println("FILA NO VALIDA 9 CARACTERES MAXIMO");
                    continue;
                }
                validar_fila = true;

                // CONTROLA LOS CARATERES QUE INTROCDUCES
                // ADMITE NUMERO ESNTRE 1 Y 9 Y '-'
                for (int j = 0; j < 9; j++) {
                    char control = fila.charAt(j);
                    if (!(control >= '1' && control <= '9') && control != '-') {
                        System.out.println("SOLO SE ADMITE NUMEROS DEL 1 AL 9 Y '-'");
                        validar_fila = false;
                        break;
                    }
                }

                // GUARDA LAS FILAS SI SON VALIDAS
                if (validar_fila) {
                    for (int j = 0; j < 9; j++) {
                        sudoku[i][j] = fila.charAt(j);
                    }
                }
            }
        }
        return sudoku;
    }

    /**
     * Cuenta cuántas casillas del Sudoku están rellenas (no son '-').
     *
     * @param sudoku el tablero de Sudoku
     * @return número de casillas rellenas
     */
    public static int Contarlinea(char[][] sudoku) {
        int lineas = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] != '-') {
                    lineas++;
                }
            }
        }
        return lineas;
    }

    /**
     * Comprueba si las casillas vacías ('-') del Sudoku son simétricas
     *
     * @param sudoku el tablero de Sudoku
     * @return true si es simétrico,  false en caso de que no sea
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
     * Valida un Sudoku :
     * - Tener como máximo 32 casillas rellenas
     * - Ser simétrico
     *
     * @param sudoku el tablero de Sudoku
     * @return true si cumple ambas condiciones, false en caso de que no sea
     */
    public static boolean Validador(char[][] sudoku) {
        int corectas = Contarlinea(sudoku);
        boolean simetrico = Comprobar_simetria(sudoku);
        return corectas <= 32 && simetrico;
    }
}




























