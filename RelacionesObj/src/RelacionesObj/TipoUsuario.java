/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RelacionesObj;
import java.util.Scanner;
/**
 *
 * @author usuario
 */
public class TipoUsuario {
    private String nombre;
    private boolean estado;
    
    
    TipoUsuario(){
        this.nombre = "";
        this.estado = false;
    }
    
    
    public boolean isEstado(){
        return estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public String Nombre(){
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
