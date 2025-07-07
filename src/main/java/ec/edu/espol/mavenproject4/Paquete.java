
package ec.edu.espol.mavenproject4;

public class Paquete {
    private String codigo;
    private String descripcion;
    private double peso;
    private String destinatario;
    private String direccion;
    private String telefono;

    public Paquete(String codigo, String descripcion, double peso, String destinatario, String direccion, String telefono) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.peso = peso;
        this.destinatario = destinatario;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    

    public String getCodigo(){
        return codigo;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public double getPeso(){
        return peso;
    }

    public String getDestinatario(){
        return destinatario;
    }

    public String getDireccion(){
        return direccion;
    }

    public String getTelefono(){
        return telefono;
    }

    @Override
    public String toString() {
        return "Paquete{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", peso=" + peso + ", destinatario=" + destinatario + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }

    // Método para evitar duplicados de paquetes por código
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Paquete paquete = (Paquete) obj;
        return codigo.equals(paquete.codigo);
    }
}
