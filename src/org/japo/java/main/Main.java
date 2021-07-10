/*
 * Copyright 2020 Noelia Cremades Gómez - noelia.cremades.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Noelia Cremades Gómez - noelia.cremades.alum@iescamp.es
 */
public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
    public static final Random RND = new Random();

    public static void main(String[] args) {

        //DECLARACIÓN DE CONSTANTES
        final int NUM_MAX = 10;
        final int NUM_MIN = 1;

        //DECLARACIÓN DE VARIABLES
        int numUsuario;
        int numAleatorio;

        //SALIDA POR CONSOLA
        System.out.println("MEGA ADIVINATOR (c) 2019 - JAPO Labs");
        System.out.println("------------------------------------");

        System.out.println("Se ha generado un número entre 1 y 10");
        System.out.println("---");

        //GENERADOR DE ALEATORIO
        numAleatorio = RND.nextInt(NUM_MAX - NUM_MIN + 1) + NUM_MIN;

        //BUCLE PARA LOS 3 INTENTOS
        for (int i = 3; i > 0; i--) {
            //ENTRADA POR CONSOLA
            try {
                System.out.printf("Quedan %d intentos - Número: ", i);
                numUsuario = SCN.nextInt();

                //CONDICIONES 
                if (i > 1) {
                    if (numUsuario == numAleatorio) {
                        System.out.println("---");
                        System.out.printf("Era el %d - ¡Enhorabuena! %n",
                                numAleatorio);
                        i = 0;
                    } else {
                        if (numUsuario > numAleatorio) {
                            System.out.println("Prueba un número MENOR.");
                            System.out.println("---");

                        } else if (numUsuario < numAleatorio) {
                            System.out.println("Prueba un número MAYOR.");
                            System.out.println("---");
                        }
                    }
                } else {
                    System.out.println("Número de intentos AGOTADO.");
                    System.out.println("---");
                    System.out.printf("Era el %d - ¡Otra vez será!%n",
                            numAleatorio);
                }
            } catch (Exception e) {
                System.out.println("ERROR: Entrada incorrecta");
                i++;
            } finally {
                SCN.nextLine();
            }
        }
    }
}
