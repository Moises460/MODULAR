package org.example;

import java.util.Scanner;

public class Ejercico2 {
    static void main() {

        Scanner teclado = new Scanner(System.in);

        imprimirMenu();
        char opcion = teclado.next().charAt(0);

        if (validar(opcion)){
            System.out.println("Válido");
        }else{
            System.out.println("No es válido");
        }

    }

    public static void imprimirMenu(){

        System.out.println("Bienvenido!! ");
        System.out.println("1. Saludar");
        System.out.println("2. Despedirse");
        System.out.println("3. Alegrarse");
        System.out.println("4. Enfadarse");
        System.out.println("X. Salir");

    }

    public static boolean validar (char opcion){

        switch(opcion){
            case '1':
            case '2':
            case '3':
            case '4':
            case 'X':
                return true;
            default:
                return false;
        }

    }

}
