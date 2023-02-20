package co.edu.uniquindio.ingesis.banco_unibancointerfaz.controller;

import co.edu.uniquindio.ingesis.banco_unibancointerfaz.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class RetiroController {

    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtSaldo;

    public void OnRetirarButtonClicked(MouseEvent event) throws Exception {
        if (txtCedula.getText().equals(SesionCliente.getInstance().getCliente().getCedula())){
            SesionCliente.getInstance().getCliente().getCuenta().retirar(Double.parseDouble(txtSaldo.getText()));
            //abrir ventana account
        }
        else {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Error de Retiro");
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
        Stage actual = (Stage) txtCedula.getScene().getWindow();
        actual.close();
        stage.show();

    }
}

