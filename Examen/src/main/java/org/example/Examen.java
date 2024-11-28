package org.example;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Examen {
    public void Bingo() {

        Random rdm = new Random();
        Scanner entrada = new Scanner(System.in);

        int a_fila = 0;
        int a_bingo = 0;
        boolean error = false;

        Integer[][] matriz = new Integer[3][3];
        Integer[] vectorboleto = new Integer[rdm.nextInt(10,41)];
        int[] repes = new int[9];

        //Vector aleatoria
        while (true) {
            for (int i = 0; i < vectorboleto.length; i++) {

                vectorboleto[i] = rdm.nextInt(90) + 1;

            }
            Arrays.stream(vectorboleto).distinct();
            if (vectorboleto.length > Arrays.stream(vectorboleto).distinct().toArray().length){
                continue;
            } else {
                break;
            }
        }



        System.out.println("***BIENVENIDO AL BINGO DEL CASINO CANTÁBRICO***");
        System.out.println(vectorboleto.length + " bolas extraídas hasta ahora: " + Arrays.toString(vectorboleto));
        Arrays.sort(vectorboleto);


        try {
            for (int i = 0; i < matriz.length; i++) {
                System.out.println("Introduce valores de la fila " + (i + 1));
                String nums[] = entrada.next().split("-");

                try{
                    for (int j = 0; j < matriz[i].length; j++) {
                        matriz[i][j] = Integer.parseInt(nums[j]);


                        if (Integer.parseInt(nums[j]) > 99 || Integer.parseInt(nums[j]) < 0) {
                            error = true;
                        }
                        if (Arrays.asList(vectorboleto).contains(Integer.parseInt(nums[j]))) {
                            a_bingo++;
                        }


                    }
                }catch (NumberFormatException er){
                    System.out.println("Introduce corréctamente los valores, separados por - y sin espacios.");
                    return;
                }


                if (error == true) {

                }


            }
            int r = 0;

            for (int k = 0; k < matriz.length; k++) {
                for (int l = 0; l < matriz[k].length; l++) {
                    repes[r++] = matriz[k][l];
                }
            }
            if (Arrays.stream(repes).distinct().toArray().length < repes.length) {
                System.out.println("No puedes introducir números repetidos en tu cartón");
                return;
            }

        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Introduce corréctamente los valores, separados por - y sin espacios.");
            return;
        }



        System.out.println("Datos del cartón introducido:");
        //Muestra cartón
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Premios:");
        if (a_bingo == 9) {
            System.out.println("Hay BINGO!!!!");
        } else {
            System.out.println("No hay BINGO");
            for (int i = 0; i < matriz.length; i++) {
                a_fila = 0;
                for (int j = 0; j < matriz[i].length; j++) {
                    if (Arrays.asList(vectorboleto).contains(matriz[i][j])) {
                        a_fila++;
                    }

                }
                if (a_fila == 3) {
                    System.out.println("Linea " + (i+1) + ": CORRECTA!!!");
                } else {
                    System.out.println("Linea " + (i+1) + ": NO");
                }
            }
        }











    }
    public void Bolas_del_sorteo() {

    }
}
