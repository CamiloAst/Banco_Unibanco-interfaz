package co.edu.uniquindio.ingesis.banco_unibancointerfaz.controller;

import co.edu.uniquindio.ingesis.banco_unibancointerfaz.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class TransaccionesController {

    @FXML
    private Button btnDeposito;
    @FXML
    private Button btnRetiro;
    @FXML
    private Button btnSolicitarSaldo;


    public void onSolicitarButtonClicked(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("Consulta.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public void onRetiroButtonClicked(ActionEvent actionEvent) throws IOException {
        openW("Retiro");
    }

    public void OnDepositoButtonClicked(ActionEvent actionEvent) throws IOException {
        openW("Deposito");
    }

    void openW(String ventana) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(ventana + ".fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        Stage actual = (Stage) btnDeposito.getScene().getWindow();
        actual.close();
        stage.show();
    }
}
