package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double[][] estudiantes = new double[50][5];
        menu(estudiantes);
    }
    public static void menu(double[][] estudiantes){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa una opción.");
        System.out.println("1. Agregar estudiante");
        System.out.println("2. Mostrar cantidad de estudiantes que aprueban la asignatura");
        System.out.println("3. Mostrar cantidad de estudiantes que reprueban la asignatura");
        System.out.println("4. Mostrar la cantidad de estudiantes que van a examen");
        System.out.println("5. Mostrar el estado de todos los estudiantes de la asignatura (notas y promedio)");
        System.out.println("6. Salir");

        int ans = sc.nextInt();
        respuesta(estudiantes, ans);
        menu(estudiantes);
    }
    public static void respuesta(double[][] estudiantes, int ans){
        Scanner sc = new Scanner(System.in);
        switch (ans) {
            case 1 -> {
                System.out.println("Ingresa el índice:");
                agregarEstudiante(estudiantes, sc.nextInt());
            }
            case 2 -> estudiantesAprobados(estudiantes);
            case 3 -> estudiantesReprobados(estudiantes);
            case 4 -> estudiantesEnExamen(estudiantes);
            case 5 -> estadoEstudiantes(estudiantes);
            case 6 -> {
                System.out.println("Salida");
                System.exit(0);
            }
        }
    }
    public static double[] generarNotas(){
        Random rm = new Random();
        double[] notas = new double[5];
        for (int i = 0; i < notas.length; i++) {
            notas[i] = rm.nextDouble(1,7);
        }
        return notas;
    }

    public static void agregarEstudiante(double[][] estudiantes, int indice){

        if(indice<0||indice>49){
            System.out.println("Indice fuera de limite");
            menu(estudiantes);
        }

        if(estudiantes[indice][0]==0.0){
        estudiantes[indice] = generarNotas();}
        else{
            System.out.println("Espacio ocupado");
            menu(estudiantes);
        }
    }

    public static void estadoEstudiantes(double[][] estudiantes){
        for (int i = 0; i < estudiantes.length; i++) {
            if(estudiantes[i][0]!=0.0) {
                System.out.print("Estudiante nro " + i + ":");
                for (int j = 0; j < estudiantes[i].length; j++) {
                    System.out.print("[" + estudiantes[i][j] + "]");
                }
                System.out.print(" Promedio: " + calcularPromedio(estudiantes[i]));
                System.out.println();
            }
        }
    }
    public static double calcularPromedio(double[] notas){
        return notas[0]*0.25+notas[1]*0.25+notas[2]*0.25+notas[3]*0.15+notas[4]*0.10;
    }
    public static int calcularAprobacion(double promedio){
        if(promedio>=4.0){
            return 1;
        } else if (promedio<4.0 && promedio>=3.6) {
            return 2;
        } else if(promedio>0.0 && promedio < 3.6){
            return 0;
        }
        return -1;
    }
    public static void estudiantesAprobados(double[][] estudiantes){
        int aprobados = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (calcularAprobacion(calcularPromedio(estudiantes[i]))==1){
                aprobados++;
            }
        }
        System.out.println("Aprobaron un total de: "+aprobados+" alumnos.");
    }

    public static void estudiantesEnExamen(double[][] estudiantes){
        int examen = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (calcularAprobacion(calcularPromedio(estudiantes[i]))==2){
                examen++;
            }
        }
        System.out.println("Van a examen un total de: "+examen+" alumnos.");
    }

    public static void estudiantesReprobados(double[][] estudiantes){
        int reprobados = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (calcularAprobacion(calcularPromedio(estudiantes[i]))==0){
                reprobados++;
            }
        }
        System.out.println("Reprobaron un total de: "+reprobados+" alumnos.");
    }
}