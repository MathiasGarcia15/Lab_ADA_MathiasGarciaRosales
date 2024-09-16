/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RelacionesObj;

/**
 *
 * @author usuario
 */
public class Tarjeta {
    private int numero;
    private float saldo;
    private boolean activo;
    private float precio;

        Tarjeta() {
        this.numero = 1;
        this.saldo = 0.0f;
        this.activo = false;
        this.precio = 0.0f;
    }

   
     Tarjeta(int numero, float saldo, boolean activo, float precio) {
        this.numero = numero;
        this.saldo = saldo;
        this.activo = activo;
        this.precio = precio;
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean recargar(float monto) {
        if (monto > 0 && activo) {
            this.saldo += monto;
            return true;
        }
        return false;
    }

    public boolean consumir(float monto) {
        if (monto > 0 && monto <= saldo && activo) {
            this.saldo -= monto;
            return true;
        }
        return false;
    }
}
