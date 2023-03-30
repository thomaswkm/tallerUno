package org.example;

import java.util.Random;

public class Main {


    public static void main(String[] args) {

        double[][] estudiantes = new double[50][5];

        //metodos de prueba, por ahora.
        agregarEstudiante(estudiantes,1);
        agregarEstudiante(estudiantes,2);
        agregarEstudiante(estudiantes,3);
        estadoEstudiantes(estudiantes);
        estudiantesAprobados(estudiantes);
        estudiantesReprobados(estudiantes);
        estudiantesEnExamen(estudiantes);
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

    public static void estadoEstudiantes(double[][] estudiantes){
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.print("Estudiante nro "+i+":");
            for (int j = 0; j < estudiantes[i].length; j++) {
                System.out.print("["+estudiantes[i][j]+"]");
            }
            System.out.print(" Promedio: "+calcularPromedio(estudiantes[i]));
            System.out.println();
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
        }
        return 0;
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
        System.out.println("Van a examen un total de :"+examen+" alumnos.");
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