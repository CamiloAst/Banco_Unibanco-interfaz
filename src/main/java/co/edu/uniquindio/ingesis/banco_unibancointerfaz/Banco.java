package co.edu.uniquindio.ingesis.banco_unibancointerfaz;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {

    private String nombre = "Unibanco";
    private Map<String, Cliente> clientes;
    public Banco() {
//        this.nombre = nombre;
        this.clientes = new HashMap<>();
    }
    public String getNombre() {
        return nombre;
    }

    public void agregarCliente (String cedula, Cliente cliente) throws Exception {
        if (clientes.get(cedula)==null) {
            clientes.put(cedula, cliente);
        }
        else {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Error");
            alerta.setHeaderText("");
            alerta.setContentText("El cliente ya está registrado");
            alerta.showAndWait();
            throw new Exception("El cliente ya se encuentra registrado");
        }
    }
    public Cliente buscarCliente (String cedula) throws Exception {
        Cliente cliente=clientes.get(cedula);
        if (cliente!=null) {
            return cliente;
        }
        else {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Error");
            alerta.setHeaderText("");
            alerta.setContentText("Identificacion no encontrada");
            alerta.showAndWait();
            throw new Exception("No se encontró la celdula");

        }
    }
    public void eliminarCliente (String cedula) throws Exception {
        Cliente cliente = buscarCliente(cedula);
        clientes.remove(cedula);
    }

    public List<Cliente> listarClientes (){
        List<Cliente> listaClientes = new ArrayList<>(clientes.values());
        return listaClientes;
    }
}
