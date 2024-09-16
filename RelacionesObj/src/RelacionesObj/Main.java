/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RelacionesObj;
import java.util.Scanner;
/**
 *
 * @author usuario
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese apellido paterno: ");
        String paterno = scanner.nextLine();
        
        System.out.print("Ingrese apellido materno: ");
        String materno = scanner.nextLine();
        
        System.out.print("Ingrese nombres: ");
        String nombres = scanner.nextLine();
        
        System.out.print("Ingrese documento: ");
        String documento = scanner.nextLine();
        
        System.out.print("Ingrese tipo de documento: ");
        String tipoDocumento = scanner.nextLine();

        Usuario usuario = new Usuario(paterno, materno, nombres, documento, tipoDocumento);
        
        System.out.print("Ingrese el nombre del tipo de usuario: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese numero de tarjeta: ");
        int numero = scanner.nextInt();
        
        System.out.print("Ingrese saldo inicial: ");
        float saldo = scanner.nextFloat();
        
        System.out.print("Ingrese precio de tarjeta: ");
        float precio = scanner.nextFloat();
        
        Tarjeta tarjeta = new Tarjeta(numero, saldo, true, precio); 

        System.out.print("Ingrese monto a recargar: ");
        float montoRecarga = scanner.nextFloat();
        if (usuario.recargar(tarjeta, montoRecarga)) {
            System.out.println("Recarga exitosa. Nuevo saldo: " + tarjeta.getSaldo());
        } else {
            System.out.println("Error en la recarga.");
        }
        
        System.out.print("Ingrese monto a consumir: ");
        float montoConsumo = scanner.nextFloat();
        if (usuario.consumir(tarjeta, montoConsumo)) {
            System.out.println("Consumo exitoso. Nuevo saldo: " + tarjeta.getSaldo());
        } else {
            System.out.println("Error en el consumo.");
        }

        scanner.close();
    }
}
