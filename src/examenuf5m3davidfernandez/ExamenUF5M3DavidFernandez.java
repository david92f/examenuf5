/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenuf5m3davidfernandez;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Empresa;

/**
 *
 * @author David Fernandez
 */
public class ExamenUF5M3DavidFernandez extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Crea model
        Empresa model = new Empresa();
        //Crea vista
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        //Crea controlador
        FXMLDocumentController controlador = new FXMLDocumentController();
        //Assigna model al controlador controlador.
        controlador.assignaModel(model);
        //Assigna controlador a la vista fxml
        fxml.setController(controlador);
        //Crear nodo Parent(La classe base per a tots els nodes que tenen fills a l'escenari gràfic)
        Parent root = fxml.load();
        //La classe Scene(escena) és el contenidor de tot el contingut en un escenari gràfic.
        Scene scene = new Scene(root);
        //La classe Stage(escenari) és el contenidor de nivell superior JavaFX.
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
