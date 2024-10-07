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
public class ArregloGradoEstudio {
    List<GradoEstudio> grados = new ArrayList<>();

    public void agregarGrado(GradoEstudio grado) {
        grados.add(grado);
    }

    public List<GradoEstudio> getGrados() {
        return grados;
    }
}
