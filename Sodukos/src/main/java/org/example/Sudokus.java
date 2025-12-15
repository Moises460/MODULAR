package org.example;

import java.util.Scanner;

public class Sudokus {
     static void main(String[]args){
         Scanner tc=new Scanner(System.in);
         System.out.println("SUDOKUS");
         System.out.println("¿CUANTOS SUDOKUS HAY?: ");
         int cantidad = Integer.parseInt(tc.nextLine().trim());

         System.out.println("ITRODUZCA EL SUDOKUS");
         tc.nextLine();   // Saltar línea en blanco antes del primer Sudoku
         for (int c = 0; c < cantidad; c++) {
             char[][] sudoku = Lectura();

             // Saltar línea en blanco entre Sudokus (excepto el último)
             if (c < cantidad - 1) {
                 tc.nextLine();
             }

             if (Validador(sudoku)) {
                 System.out.println("SI");
             } else {
                 System.out.println("NO");
             }
         }


     }

    public static char[][] Lectura(){
        Scanner tc=new Scanner(System.in);
        char[][] sudoku=new char[9][9];
        for (int i = 0; i < 9; i++) {
            String relleno1=tc.nextLine();
            for (int j = 0; j < 9 ; j++) {
                sudoku[i][j] = relleno1.charAt(j);
            }
        }
        return sudoku;

    }
    
    public static int Contarlinea(char[][] sudoku){
         int lineas=0;
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
                if ((sudoku[i][j] == '-' && sudoku[8 - i][8 - j] != '-') ||
                        (sudoku[i][j] != '-' && sudoku[8 - i][8 - j] == '-')) {
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































}
