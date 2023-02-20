package co.edu.uniquindio.ingesis.banco_unibancointerfaz.controller;

import co.edu.uniquindio.ingesis.banco_unibancointerfaz.Cliente;
import co.edu.uniquindio.ingesis.banco_unibancointerfaz.Cuenta;
import co.edu.uniquindio.ingesis.banco_unibancointerfaz.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static co.edu.uniquindio.ingesis.banco_unibancointerfaz.controller.AppController.BANCO;
public class RegisterController {

    @FXML
    private Button btnRegistrar;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtClave1;
    @FXML
    private TextField txtClaveConfirm;


    public void initialize(){
        txtNombres.textProperty().addListener((observable, oldValue, newValue) -> updateAllFieldsFilled());
        txtCedula.textProperty().addListener((observable, oldValue, newValue) -> updateAllFieldsFilled());
        txtApellidos.textProperty().addListener((observable, oldValue, newValue) -> updateAllFieldsFilled());
        txtEmail.textProperty().addListener((observable, oldValue, newValue) -> updateAllFieldsFilled());
        txtDireccion.textProperty().addListener((observable, oldValue, newValue) -> updateAllFieldsFilled());
        txtClave1.textProperty().addListener((observable, oldValue, newValue) -> updateAllFieldsFilled());
        txtClaveConfirm.textProperty().addListener((observable, oldValue, newValue) -> updateAllFieldsFilled());
        btnRegistrar.setDisable(true);
    }
    @FXML
    public void onButtonClicked(ActionEvent event) throws Exception {

        if(txtClave1.getText().equals(txtClaveConfirm.getText())){
            Cliente cliente = new Cliente(txtNombres.getText(),txtApellidos.getText(),txtCedula.getText()
                    ,txtDireccion.getText(),txtEmail.getText(),txtClave1.getText(),
                    new Cuenta(txtCedula.getText(),0.0, Cuenta.TipoCuenta.AHORRO));
            BANCO.getBanco().agregarCliente(cliente.getCedula(),cliente);

            //abrir ventana de inicio de sesión
            Parent root = FXMLLoader.load(Main.class.getResource("Login.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Registro");
            Scene scene = new Scene(root);

            stage.setScene(scene);
            Stage actual = (Stage) txtNombres.getScene().getWindow();
            actual.close();
            stage.show();
        }
        else {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Error de Registro");
            alerta.setHeaderText("");
            alerta.setContentText("Las contraseñas no coinciden");
            alerta.showAndWait();
        }
    }

    private void updateAllFieldsFilled(){
        boolean fieldsFilled = !txtCedula.getText().isEmpty() && !txtNombres.getText().isEmpty() &&
                !txtApellidos.getText().isEmpty() && !txtDireccion.getText().isEmpty() && !txtEmail.getText().isEmpty() &&
                !txtClaveConfirm.getText().isEmpty() && !txtClave1.getText().isEmpty();
        btnRegistrar.setDisable(!fieldsFilled);
    }

}
