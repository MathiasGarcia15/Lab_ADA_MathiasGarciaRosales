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
public class ArregloPostulante {
     List<Postulante> postulantes = new ArrayList<>();

    public void agregarPostulante(Postulante postulante) {
        postulantes.add(postulante);
    }

    public List<Postulante> getPostulantes() {
        return postulantes;
    }
}
