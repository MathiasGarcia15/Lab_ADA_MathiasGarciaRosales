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
public class ArregloRubro {
     List<Rubro> rubros = new ArrayList<>();

    public void agregarRubro(Rubro rubro) {
        rubros.add(rubro);
    }

    public List<Rubro> getRubros() {
        return rubros;
    }
}
