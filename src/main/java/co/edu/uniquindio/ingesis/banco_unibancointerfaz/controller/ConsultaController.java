package co.edu.uniquindio.ingesis.banco_unibancointerfaz.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ConsultaController implements Initializable {
    @FXML
    private TextField txtNumCuenta;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtSaldo;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtNumCuenta.setText(SesionCliente.getInstance().getCliente().getCuenta().getNumCuenta());
        txtCedula.setText(SesionCliente.getInstance().getCliente().getCedula());
        txtSaldo.setText(SesionCliente.getInstance().getCliente().getCuenta().consultarSaldo());
    }
}
