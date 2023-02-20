package co.edu.uniquindio.ingesis.banco_unibancointerfaz;


public class Transaccion {
    private double valor;
    private String hora;
    private String fecha;
    private String tipo;
    private String estado;

    public Transaccion(double valor, String hora, String fecha, String tipo, String estado) {
        this.valor = valor;
        this.hora = hora;
        this.fecha = fecha;
        this.tipo = tipo;
        this.estado = estado;
    }

    public double getValor() {
        return valor;
    }

    public String getHora() {
        return hora;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }
}
