module co.edu.uniquindio.ingesis.banco_unibancointerfaz {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.ingesis.banco_unibancointerfaz to javafx.fxml;
    exports co.edu.uniquindio.ingesis.banco_unibancointerfaz;
    exports co.edu.uniquindio.ingesis.banco_unibancointerfaz.controller;
    opens co.edu.uniquindio.ingesis.banco_unibancointerfaz.controller to javafx.fxml;
}