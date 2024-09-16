/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RelacionesObj;

/**
 *
 * @author usuario
 */
public class Usuario {
    private String paterno;
    private String materno;
    private String nombres;
    private String documento;
    private String tipoDocumento;


    Usuario() {
        this.paterno = " ";
        this.materno = " ";
        this.nombres = " ";
        this.documento = " ";
        this.tipoDocumento = " ";
    }

    // Constructor con parámetros
     Usuario(String paterno, String materno, String nombres, String documento, String tipoDocumento) {
        this.paterno = paterno;
        this.materno = materno;
        this.nombres = nombres;
        this.documento = documento;
        this.tipoDocumento = tipoDocumento;
    }


    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

 
    public boolean recargar(Tarjeta tarjeta, float monto) {
        return tarjeta.recargar(monto);
    }

    public boolean consumir(Tarjeta tarjeta, float monto) {
        return tarjeta.consumir(monto);
    }
    
    
}
