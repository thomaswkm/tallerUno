package org.example;

import java.util.Random;

public class Main {


    public static void main(String[] args) {

        double[][] estudiantes = new double[50][5];

        //metodos de prueba, por ahora.
        agregarEstudiante(estudiantes,1);
        agregarEstudiante(estudiantes,2);
        agregarEstudiante(estudiantes,3);
        imprimir(estudiantes);
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
        estudiantes[indice] = generarNotas();
    }

    public static void imprimir(double[][] estudiantes){
        for (int i = 0; i < estudiantes.length; i++) {
            for (int j = 0; j < estudiantes[i].length; j++) {
                System.out.print("["+estudiantes[i][j]+"]");
            }
            System.out.println();
        }
    }

    public static int calcularAprobacion(double[] notas){

        double promedio = notas[0]*0.25+notas[1]*0.25+notas[2]*0.25+notas[3]*0.15+notas[4]*0.10;

        if(promedio>=4.0){
            return 1;
        } else if (promedio<4.0 && promedio>=3.6) {
            return 2;
        }
        return 0;
    }

    public static void estudiantesAprobados(double[][] estudiantes){
        int aprobados = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (calcularAprobacion(estudiantes[i])==1){
                aprobados++;
            }
        }
        System.out.println("Aprobaron un total de: "+aprobados+" alumnos.");
    }

    public static void estudiantesEnExamen(double[][] estudiantes){
        int examen = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (calcularAprobacion(estudiantes[i])==2){
                examen++;
            }
        }
        System.out.println("Van a examen un total de :"+examen+" alumnos.");
    }

    public static void estudiantesReprobados(double[][] estudiantes){
        int reprobados = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (calcularAprobacion(estudiantes[i])==0){
                reprobados++;
            }
        }
        System.out.println("Reprobaron un total de: "+reprobados+" alumnos.");

    }



}