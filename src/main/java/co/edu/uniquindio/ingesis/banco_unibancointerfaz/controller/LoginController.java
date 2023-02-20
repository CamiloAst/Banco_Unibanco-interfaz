package co.edu.uniquindio.ingesis.banco_unibancointerfaz.controller;

import co.edu.uniquindio.ingesis.banco_unibancointerfaz.Banco;
import co.edu.uniquindio.ingesis.banco_unibancointerfaz.Main;
import javafx.event.ActionEvent;
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
import java.util.Objects;

import static co.edu.uniquindio.ingesis.banco_unibancointerfaz.controller.AppController.BANCO;

public class LoginController {
    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtClave;

    public void onLoginButtonClicked(ActionEvent event) throws Exception {
        String id =txtCedula.getText();
        String clave = txtClave.getText();
        System.out.println("Hola mundo");
        if (clave.equals(BANCO.getBanco().buscarCliente(id).getClave())){
            System.out.println("Hola mundo2");
            SesionCliente.getInstance().setCliente(BANCO.getBanco().buscarCliente(id));
            Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("Account.fxml")));
            Stage stage = new Stage();
            stage.setTitle("Cuenta");
            Scene scene = new Scene(root);

            stage.setScene(scene);
            Stage actual = (Stage) btnLogin.getScene().getWindow();
            actual.close();
            stage.show();

        }
        else {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Error de accesso");
            alerta.setHeaderText("");
            alerta.setContentText("Identificacion o contraseña incorrecta");
            alerta.showAndWait();
        }
    }

    public void onLabelClicked(MouseEvent event) throws IOException {
        //abrir ventana de registro
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("Register.fxml")));
        Stage stage = new Stage();
        stage.setTitle("Registro");
        Scene scene = new Scene(root);

        stage.setScene(scene);
        Stage actual = (Stage) btnLogin.getScene().getWindow();
        actual.close();
        stage.show();
    }


}
