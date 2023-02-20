package co.edu.uniquindio.ingesis.banco_unibancointerfaz;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Cuenta {
    private String numCuenta;
    private double saldo;
    private TipoCuenta tipocuenta;
    private List<Transaccion> transacciones = new ArrayList<>();

    public Cuenta(String numCuenta, double saldo, TipoCuenta tipocuenta) {
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        this.tipocuenta = tipocuenta;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public TipoCuenta getTipocuenta() {
        return tipocuenta;
    }

    public void depositar(double saldo){
        String hora = definirHora();
        String fecha = definirFecha();

        this.saldo+=saldo;
        transacciones.add(new Transaccion(saldo, hora, fecha, "deposito", "EXITOSO"));
    }
    public String consultarSaldo(){
        return ""+saldo;
    }
    public void retirar(double saldo) throws Exception {
        String hora = definirHora();
        String fecha = definirFecha();
        if (this.saldo<saldo){
            transacciones.add(new Transaccion(saldo, hora, fecha, "RETIRO", "RECHAZADA"));
            throw new Exception("Saldo insuficiente");

        }
        else {
            this.saldo-=saldo;
            transacciones.add(new Transaccion(saldo, hora, fecha, "RETIRO", "EXITOSO"));
        }
    }
    public List<Transaccion> getTransacciones(){
        return transacciones;
    }
    public String definirHora(){
        LocalDateTime horaActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        String hora = horaActual.format(formato);
        return hora;
    }
    public String definirFecha(){
        LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = fechaActual.format(formato);
        return fecha;
    }
    public int generarNumeroAleatorio(){
        Random random = new Random();
        int numero = random.nextInt(9000)+1000;
        return numero;
    }

    public enum TipoCuenta{
        AHORRO,
        CORRIENTE
    }
}
