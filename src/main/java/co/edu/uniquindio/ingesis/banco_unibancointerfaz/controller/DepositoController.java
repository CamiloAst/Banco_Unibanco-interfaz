package co.edu.uniquindio.ingesis.banco_unibancointerfaz.controller;

import co.edu.uniquindio.ingesis.banco_unibancointerfaz.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class DepositoController {

    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtSaldo;
    @FXML
    private Button btnDepositar;
    @FXML
    private Button btnCancelar;


    public void OnDepositarButtonClicked(MouseEvent event){
        if (txtCedula.getText().equals(SesionCliente.getInstance().getCliente().getCedula())){
            SesionCliente.getInstance().getCliente().getCuenta().depositar(Double.parseDouble(txtSaldo.getText()));
            //abrir ventana account
        }
        else {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Error de Depósito");
            alerta.setHeaderText("");
            alerta.setContentText("Cédula incorrecta");
            alerta.showAndWait();
        }
    }
    public void OnCancelarButtonClicked(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(Main.class.getResource("Account.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        Stage actual = (Stage) btnDepositar.getScene().getWindow();
        actual.close();
        stage.show();

    }

}
