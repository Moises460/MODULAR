package org.example;



public class Main {
    static void main(String[] args) {



       int num= Prueba.prubea(10);
        System.out.println(num);

        Prueba.procedimiento();


        System.out.println("perros:");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        varios(1,2,3,54,8456,4);
    }
public static void varios(int...num){

    for (int i = 0; i < num.length; i++) {
        System.out.println(num[i]);
    }
}


}
