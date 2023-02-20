package co.edu.uniquindio.ingesis.banco_unibancointerfaz.controller;

import co.edu.uniquindio.ingesis.banco_unibancointerfaz.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccountController implements Initializable {

    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtDireccion;
    @FXML
    private Button btnCerrar;
    @FXML
    private BorderPane borderPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtNombres.setText(SesionCliente.getInstance().getCliente().getNombre());
        txtApellidos.setText(SesionCliente.getInstance().getCliente().getApellidos());
        txtEmail.setText(SesionCliente.getInstance().getCliente().getEmail());
        txtDireccion.setText(SesionCliente.getInstance().getCliente().getDireccion());
    }

    public void onCerrarButtonClicked(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("Login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        Stage actual = (Stage) btnCerrar.getScene().getWindow();
        actual.close();
        stage.show();
    }

    public void datos(MouseEvent event) throws IOException {
        openP("Account");
    }

    public void historial(MouseEvent event) throws IOException {
        openP("HistorialTransacciones");
    }

    public void transacciones(MouseEvent event) throws IOException {
        openP("Transacciones");
    }
    void openP(String page) {
        Parent root = null ;
        try {
            root = FXMLLoader.load(Main.class.getResource(page+".fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        borderPane.setCenter(root);
    }
}
