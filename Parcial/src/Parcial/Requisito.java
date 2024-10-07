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
public class Requisito {
    int orden;
    String descripcion;
    boolean estado;

    public Requisito(int orden, String descripcion) {
        this.orden = orden;
        this.descripcion = descripcion;
        this.estado = true;
    }

    public boolean habilitar() {
        estado = true;
        return estado;
    }

    public boolean deshabilitar() {
        estado = false;
        return estado;
    }
}
