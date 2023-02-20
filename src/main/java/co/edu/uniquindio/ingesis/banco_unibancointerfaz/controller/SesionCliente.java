package co.edu.uniquindio.ingesis.banco_unibancointerfaz.controller;

import co.edu.uniquindio.ingesis.banco_unibancointerfaz.Cliente;

public class SesionCliente {

    public static SesionCliente instance = null;
    private Cliente cliente;

    private SesionCliente(){

    }
    public static SesionCliente getInstance(){
        if (instance==null){
            instance = new SesionCliente();
            return instance;
        }
        else {
            return instance;
        }
    }

    public Cliente getCliente(){return cliente;}

    public void setCliente(Cliente cliente){this.cliente = cliente;}


}
