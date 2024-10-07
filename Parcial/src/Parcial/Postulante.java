/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
/**
 *
 * @author mathias garcia
 */
public class Postulante {
    String DNI;
    String email;
    String nombres;
    String apellidos;
    String telefono;
    String direccion;
    Date nacimiento;
    String gradoEstudios;
    String clave;
    List<Postulacion> postulaciones = new ArrayList<>();

    public Postulante(String DNI, String email, String nombres, String apellidos, String telefono, String direccion, Date nacimiento, String gradoEstudios) {
        this.DNI = DNI;
        this.email = email;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nacimiento = nacimiento;
        this.gradoEstudios = gradoEstudios;
        this.clave = generarClave();
    }

    private String generarClave() {
        return "POST" + new Random().nextInt(10000);
    }

    public boolean postular(Oferta oferta, String glosa) {
        if (!oferta.activa) {
            System.out.println("La oferta ya no está activa.");
            return false;
        }

        Postulacion postulacion = new Postulacion(this, oferta, glosa);
        oferta.postulaciones.add(postulacion);
        return postulaciones.add(postulacion);
    }

    public boolean anularPostulacion(Postulacion postulacion) {
        if (postulaciones.contains(postulacion) && !postulacion.anulado) {
            postulacion.anular();
            return true;
        }
        return false;
    }
}
