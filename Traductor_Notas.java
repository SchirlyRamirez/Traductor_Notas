import java.util.Scanner;

public class Traductor_Notas {

    private int totalCalificaciones;
    private int contadorCalificaciones;
    private int[] contadorLetraCalificacion;

    // Constructor
    public Traductor_Notas() {
        totalCalificaciones = 0;
        contadorCalificaciones = 0;
        contadorLetraCalificacion = new int[5]; // Para almacenar la cantidad de cada letra de calificación
    }

    // Método para agregar una calificación
    public void agregarCalificacion(int calificacion) {
        totalCalificaciones += calificacion;
        contadorCalificaciones++;

        // Determinar la letra de calificación
        char letraCalificacion = calcularLetraCalificacion(calificacion);
        actualizarContadorLetraCalificacion(letraCalificacion);
    }

    // Método para calcular la letra de calificación
    private char calcularLetraCalificacion(int calificacion) {
        if (calificacion >= 90) {
            return 'A';
        } else if (calificacion >= 80) {
            return 'B';
        } else if (calificacion >= 70) {
            return 'C';
        } else if (calificacion >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // Método para actualizar el contador de letra de calificación
    private void actualizarContadorLetraCalificacion(char letraCalificacion) {
        switch (letraCalificacion) {
            case 'A':
                contadorLetraCalificacion[0]++;
                break;
            case 'B':
                contadorLetraCalificacion[1]++;
                break;
            case 'C':
                contadorLetraCalificacion[2]++;
                break;
            case 'D':
                contadorLetraCalificacion[3]++;
                break;
            case 'F':
                contadorLetraCalificacion[4]++;
                break;
        }
    }

    // Método para mostrar el reporte
    public void mostrarReporte() {
        System.out.println("Total de calificaciones introducidas: " + contadorCalificaciones);

        if (contadorCalificaciones > 0) {
            double promedio = (double) totalCalificaciones / contadorCalificaciones;
            System.out.println("Promedio de calificaciones: " + promedio);
        } else {
            System.out.println("No se introdujeron calificaciones.");
        }

        System.out.println("Número de estudiantes que recibieron cada letra de calificación:");
        System.out.println("A: " + contadorLetraCalificacion[0]);
        System.out.println("B: " + contadorLetraCalificacion[1]);
        System.out.println("C: " + contadorLetraCalificacion[2]);
        System.out.println("D: " + contadorLetraCalificacion[3]);
        System.out.println("F: " + contadorLetraCalificacion[4]);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Traductor_Notas gradeBook = new Traductor_Notas();

        System.out.println("Ingrese las calificaciones (Ingrese -1 para terminar):");

        int calificacion;
        while ((calificacion = scanner.nextInt()) != -1) {
            gradeBook.agregarCalificacion(calificacion);
        }

        gradeBook.mostrarReporte();
        scanner.close();
    }

}






