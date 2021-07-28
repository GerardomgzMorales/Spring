package mx.gerdev.com.spring_demo.models;

public class Usuario {

    private String nombre;
    private String apellidos;
    private String e_mail;

    public Usuario(){

    }

    public Usuario(String nombre, String apellidos, String e_mail) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.e_mail = e_mail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
}
