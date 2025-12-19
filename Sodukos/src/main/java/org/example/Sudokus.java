package org.example;

import java.util.Scanner;

public class Sudokus {

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


        if(cantidad==1){
            System.out.println("INTRODUZCA EL SUDOKUS");
        }else {
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

                for (int j = 0; j < 9; j++) {
                    char control = fila.charAt(j);
                    if (!(control >= '1' && control <= '9') && control != '-') {
                        System.out.println("SOLO SE ADMINTE NUMEROS DEL 1 AL 9 Y '-'");
                        validar_fila = false;
                        break;
                    }
                }

                if (validar_fila) {
                    for (int j = 0; j < 9; j++) {
                        sudoku[i][j] = fila.charAt(j);
                    }
                }
            }
        }
        return sudoku;
    }

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

    public static boolean Validador(char[][] sudoku) {
        int corectas = Contarlinea(sudoku);
        boolean simetrico = Comprobar_simetria(sudoku);
        return corectas <= 32 && simetrico;
    }
}




























