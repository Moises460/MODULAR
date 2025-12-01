package org.example;

import java.util.Scanner;

public class Multiplicacion_al_cubo {
    static void main() {

        Scanner tc= new Scanner(System.in);

          int numero;
        System.out.println("Introduce un numero");
        if(tc.hasNextInt()){
           numero=tc.nextInt();
        }else  {
            System.out.println("error");
            return;
        }


        int resultado=cubo(numero);
        System.out.println(cubo(resultado));
        System.out.println(cubo(numero));
    }
    public static int cubo(int numero){

     return numero+numero+numero;
    }






}
