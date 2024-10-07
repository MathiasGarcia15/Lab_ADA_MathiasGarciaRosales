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
 * @author usuario
 */
public class Cliente {
    String RUC;
    String nombre;
    Rubro rubro;
    String email;
    String clave;
    Contacto contacto;

    List<Oferta> ofertas = new ArrayList<>();

    public Cliente(String RUC, String nombre, Rubro rubro, String email, Contacto contacto) {
        this.RUC = RUC;
        this.nombre = nombre;
        this.rubro = rubro;
        this.email = email;
        this.contacto = contacto;
        this.clave = generarClave();
    }

    private String generarClave() {
        return "CLAVE" + new Random().nextInt(10000);
    }

    public boolean agregarOferta(Oferta oferta) {
        return ofertas.add(oferta);
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void visualizarOfertas() {
        for (Oferta oferta : ofertas) {
            System.out.println("Oferta: " + oferta.descripcion + " - Estado: " + (oferta.activa ? "Activa" : "Inactiva"));
        }
    }
}
