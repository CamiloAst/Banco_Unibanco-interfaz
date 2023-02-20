package co.edu.uniquindio.ingesis.banco_unibancointerfaz;

public class Cliente {
    private String nombre;
    private String apellidos;
    private String cedula;
    private String direccion;
    private String email;
    private String clave;
    private Cuenta cuenta;

    public Cliente(String nombre, String apellidos, String cedula, String direccion, String email, String clave, Cuenta cuenta) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.direccion = direccion;
        this.email = email;
        this.clave = clave;
        this.cuenta = cuenta;
    }

    public String getClave() {
        return clave;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cuenta getCuenta() {return cuenta;}
}
