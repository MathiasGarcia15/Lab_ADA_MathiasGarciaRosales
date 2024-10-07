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
public class ArregloEstadoEtapa {
    List<EstadoEtapa> estados = new ArrayList<>();

    public void agregarEstado(EstadoEtapa estado) {
        estados.add(estado);
    }

    public List<EstadoEtapa> getEstados() {
        return estados;
    }
}
