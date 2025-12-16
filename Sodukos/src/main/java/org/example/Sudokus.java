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
                cantidad = tc.nextInt(); // Leer directamente el entero
                tc.nextLine(); // Limpiar el salto de línea
                valido = true;
            } else {
                System.out.println("SOLO SE ADMITE NUMEROS");
                tc.nextLine(); // Limpiar la entrada incorrecta
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
                    System.out.println("La fila debe tener exactamente 9 caracteres.");
                    continue;
                }
                validar_fila = true;

                for (int j = 0; j < 9; j++) {
                    char control = fila.charAt(j);
                    if (!(control >= '1' && control <= '9') && control != '-') {
                        System.out.println("Solo se permiten números del 1 al 9 o '-'");
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
        int llenas = Contarlinea(sudoku);
        boolean simetrico = Comprobar_simetria(sudoku);
        return llenas <= 32 && simetrico;
    }
<<<<<<< HEAD
=======
}










































>>>>>>> d5e8ba4cacf648979acd79dd64a35feea08f68a6
}





























