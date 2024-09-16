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
public class Alumno {
     private String codigo;
    private String nombre;
    private double promedioFinal;

    public Alumno() {
        this.codigo = "";
        this.nombre = "";
        this.promedioFinal = 0.0;
    }

    public void ingresarDatos() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el codigo del alumno: ");
        this.codigo = scanner.nextLine();

        System.out.print("Ingrese el nombre del alumno: ");
        this.nombre = scanner.nextLine();

        System.out.print("Ingrese el promedio final del alumno: ");
        this.promedioFinal = scanner.nextDouble();
    }

    public void presentarDatos() {
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Promedio Final: " + this.promedioFinal);
    }
}

