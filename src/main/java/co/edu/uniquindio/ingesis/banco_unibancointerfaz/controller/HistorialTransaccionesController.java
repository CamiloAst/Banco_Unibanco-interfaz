package co.edu.uniquindio.ingesis.banco_unibancointerfaz.controller;

import co.edu.uniquindio.ingesis.banco_unibancointerfaz.Transaccion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HistorialTransaccionesController implements Initializable {

    @FXML
    private TableView<Transaccion> tablaHistorial;
    @FXML
    private TableColumn<Transaccion,String> columnaFecha;
    @FXML
    private TableColumn<Transaccion,String> columnaHora;
    @FXML
    private TableColumn<Transaccion,String> columnaValor;
    @FXML
    private TableColumn<Transaccion,String> columnaTipo;
    @FXML
    private TableColumn<Transaccion,String> columnaEstado;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnaFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        columnaHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        columnaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        columnaTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        columnaEstado.setCellValueFactory(new PropertyValueFactory<>("Estado"));

        ObservableList<Transaccion> transaccions = FXCollections.observableList(SesionCliente.getInstance().getCliente()
                .getCuenta().getTransacciones());
        tablaHistorial.setItems(transaccions);
    }
}
