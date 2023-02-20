package co.edu.uniquindio.ingesis.banco_unibancointerfaz.controller;

import co.edu.uniquindio.ingesis.banco_unibancointerfaz.Banco;
import co.edu.uniquindio.ingesis.banco_unibancointerfaz.Cliente;

public enum AppController {

    BANCO;

    private final Banco banco;



    AppController(){banco = new Banco();}

    public Banco getBanco(){return banco;}
}
