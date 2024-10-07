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
public class EstadoEtapa {
    String nombre;
    String glosa;
    Date fecha;

    public EstadoEtapa(String nombre, String glosa) {
        this.nombre = nombre;
        this.glosa = glosa;
        this.fecha = new Date();
    }
}
