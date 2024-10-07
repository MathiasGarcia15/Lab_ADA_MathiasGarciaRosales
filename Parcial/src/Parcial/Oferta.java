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
public class Oferta {
    String puesto;
    String descripcion;
    String area;
    Date fechaInicio;
    Date fechaTermino;
    boolean activa;
    List<Requisito> requisitos = new ArrayList<>();
    List<Postulacion> postulaciones = new ArrayList<>();

    public Oferta(String puesto, String descripcion, String area, Date fechaInicio, Date fechaTermino) {
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.area = area;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.activa = true;
    }

    public boolean agregarRequisito(int orden, String descripcion) {
        Requisito requisito = new Requisito(orden, descripcion);
        return requisitos.add(requisito);
    }

    public List<Requisito> getRequisitos() {
        return requisitos;
    }

    public void visualizarPostulantes() {
        for (Postulacion postulacion : postulaciones) {
            System.out.println("Postulante: " + postulacion.postulante.nombres + " - Estado: " + postulacion.estado);
        }
    }
}
