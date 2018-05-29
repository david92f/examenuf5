/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenuf5m3davidfernandez;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Cotxe;
import model.Empresa;
import model.Seu;

/**
 *
 * @author David Fernandez
 */
public class FXMLDocumentController implements Initializable, AssignaModel {

    private Empresa empresa;
    @FXML
    private Label labelModel, labelSeu;

    @FXML
    private ListView tMostrar;

    @FXML
    private TextField tCercarMatricula, tAfegirMatricula, tAfegirModel;

    @FXML
    private ComboBox comboMostrar, comboAfegir;

    @FXML
    public void mostrarCombo(ActionEvent e) {
        int index = comboMostrar.getSelectionModel().getSelectedIndex();
        tMostrar.setItems(FXCollections.observableArrayList(empresa.getCotxesSeu(empresa.getSeus().get(index))));
    }

    @FXML
    public void netejar(ActionEvent e) {
        tCercarMatricula.setText("");
        labelModel.setText("");
        labelSeu.setText("");
    }

    @FXML
    public void cercarCotxe(ActionEvent e) {

        String matricula = tCercarMatricula.getText();
        Seu seu = empresa.getSeu(matricula);
        if (seu != null) {
            Cotxe c = empresa.getCotxe(seu, matricula);
            labelModel.setText(c.getModel());
            labelSeu.setText(seu.getNomSeu());
        }
        
    }

    @FXML
    public void afegirCotxe(ActionEvent e) {
//        empresa.afegirCotxeASeu((Seu)comboAfegir.getSelectionModel().getSelectedItem(), new Cotxe(tAfegirMatricula.getText(), tAfegirModel.getText()));
        String matricula = tAfegirMatricula.getText();
        String model = tAfegirModel.getText();
        
        int index = comboAfegir.getSelectionModel().getSelectedIndex();

        empresa.afegirCotxeASeu(empresa.getSeus().get(index), new Cotxe(matricula, model));

        tAfegirMatricula.clear();
        tAfegirModel.clear();
        tMostrar.setItems(FXCollections.observableArrayList(empresa.getCotxesSeu(empresa.getSeus().get(index))));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        LinkedList<String> a= new LinkedList<>();
//        
//        for (Seu list : empresa.getSeus()) {
//            a.add(list.getNomSeu());
//        }
        // mostres en combox els models
        comboMostrar.setItems(FXCollections.observableArrayList(empresa.getSeus()));
        
        // per defecte selecciones la primera opcio per evitar errors
        comboMostrar.getSelectionModel().selectFirst();
        tMostrar.setItems(FXCollections.observableArrayList(empresa.getCotxesSeu(empresa.getSeus().get(0))));
        
        // afegir
        // mostres en combox els models
        comboAfegir.setItems(FXCollections.observableArrayList(empresa.getSeus()));
        // per defecte selecciones la primera opcio per evitar errors
        comboAfegir.getSelectionModel().selectFirst();
    }

    @Override
    public void assignaModel(Object obj) {
        if (obj instanceof Empresa) {
            empresa = (Empresa) obj;
        }
    }
}
