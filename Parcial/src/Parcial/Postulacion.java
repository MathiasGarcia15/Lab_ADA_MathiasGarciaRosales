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
public class Postulacion {
    Postulante postulante;
    Oferta oferta;
    String glosa;
    Date fecha;
    boolean anulado;
    String estado;
    List<EstadoEtapa> etapas = new ArrayList<>();

    public Postulacion(Postulante postulante, Oferta oferta, String glosa) {
        this.postulante = postulante;
        this.oferta = oferta;
        this.glosa = glosa;
        this.fecha = new Date();
        this.anulado = false;
        this.estado = "ACTIVA";
    }

    public void anular() {
        this.anulado = true;
        this.estado = "ANULADA";
    }

    public void actualizarEstado(String estado, String glosa) {
        this.estado = estado;
        EstadoEtapa etapa = new EstadoEtapa(estado, glosa);
        etapas.add(etapa);
    }
}
