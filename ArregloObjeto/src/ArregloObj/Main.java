/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArregloObj;
import java.util.Scanner;
/**
 *
 * @author Mathias Garcia Rosales
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de alumnos: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        Alumno[] alumnos = new Alumno[cantidad];

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingrese los datos del alumno " + (i + 1) + ":");
            alumnos[i] = new Alumno();
            alumnos[i].ingresarDatos();
        }

        System.out.println("\nDatos de los alumnos ingresados:");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Alumno " + (i + 1) + ":");
            alumnos[i].presentarDatos();
            System.out.println();
        }
    }
}
