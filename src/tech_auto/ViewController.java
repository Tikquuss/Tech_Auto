/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_auto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Notsawo
 */
public class ViewController implements Initializable {
   
    @FXML
    private GridPane niveaux;
    @FXML
    private GridPane eclairage_signalisation;
    @FXML
    private GridPane pneus;
    @FXML
    private GridPane control_visuel;
    @FXML
    private GridPane instruments_de_bord;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init(niveaux);
        init(eclairage_signalisation);
        init(pneus);
        init(control_visuel);
        init(instruments_de_bord);
    } 
    
    /***
     * @docRoot Selectionne les elements obligatoires avant le chargement de l'application
     * @param gridpane 
     */
    public void init(GridPane gridpane){
   
        ObservableList<Node> childrens = gridpane.getChildren();
    
        int column_index = 0, ligne_index = 0;
        
        for (Node node : childrens) {
            try{
                column_index = gridpane.getColumnIndex(node);
                ligne_index = gridpane.getRowIndex(node);
                
                if(ligne_index != 0 && column_index != 0) {
                    if(column_index == 1){
                        Label obligatoire_label = (Label)getGridPaneNode(childrens, ligne_index,  column_index + 2);
                        if(obligatoire_label.getText().equals("Oui")){
                            CheckBox cb = (CheckBox)node;
                            cb.setSelected(true);
                        }   
                    }
                }
            }catch(NullPointerException e){}
        }
    }

    /**
     * @docRoot Retourne l'element à la position (i, j) d'un GridPane donc la liste des enfants est donnée
     * @param childrens
     * @param i
     * @param j
     * @return 
     */
    public Node getGridPaneNode(ObservableList<Node> childrens, int i, int j) {
        for (Node node : childrens) {
            try{
                if(i == niveaux.getRowIndex(node) && j == niveaux.getColumnIndex(node)){
                    return node;
                }
            }catch(NullPointerException e){}
        }
        return null;
    }
    
    /**
     * @docRoot verifie que les elements obligatoires sont toujours selectionnés
     * @param event 
     */
    @FXML
    private void checkform(ActionEvent event){
        CheckBox source = (CheckBox)event.getSource();
        String id = source.getId();
        
        GridPane parent = (GridPane)source.getParent();
        ObservableList<Node> childrens = parent.getChildren();
         
        int column_index = parent.getColumnIndex(source);
        int ligne_index = parent.getRowIndex(source);
            
        if(id.endsWith("bon")){
            CheckBox mauvais = (CheckBox)getGridPaneNode(childrens, ligne_index, column_index + 1);
            Label obligatoire_label = (Label)getGridPaneNode(parent.getChildren(), ligne_index,  column_index + 2);
            
            if(source.isSelected()){
                if(obligatoire_label.getText().equals("Oui")){
                    mauvais.setSelected(false);
                }else{
                    mauvais.setDisable(true);
                }
            }else{
                if(obligatoire_label.getText().equals("Oui")){
                    mauvais.setSelected(true);
                }else{
                     mauvais.setDisable(false);
                }
            }
        }else if(id.endsWith("mauvais")){
            CheckBox bon = (CheckBox)getGridPaneNode(childrens, ligne_index, column_index - 1);
            Label obligatoire_label = (Label)getGridPaneNode(parent.getChildren(), ligne_index,  column_index + 1);
            
            if(source.isSelected()){
                if(obligatoire_label.getText().equals("Oui")){
                    bon.setSelected(false);
                }else{
                    bon.setDisable(true);
                }
            }else{
                if(obligatoire_label.getText().equals("Oui")){
                    bon.setSelected(true);
                }else{
                    bon.setDisable(false);
                }
            }
        }
    }
    
    /**
     * @docRoot Analyse toute la fiche technique et prend la decision
     * @param gridpane
     * @return nombre de pieces en bonne etat, en mauvais etat; et le nombre de pieces en mauvais etat obligatoire
     */
    public int[] single_stats(GridPane gridpane){
        int indexs[] = new int[3];
        
        ObservableList<Node> childrens = gridpane.getChildren();
        
        int column_index = 0, ligne_index = 0;
        
        for (Node node : childrens) {
            try{
                column_index = gridpane.getColumnIndex(node);
                ligne_index = gridpane.getRowIndex(node);
                
                if(ligne_index != 0 && column_index != 0) {
                    if(column_index != 3){
                        CheckBox cb = (CheckBox)node;
                        if(cb.isSelected()){
                            if(column_index == 1){
                                indexs[0] = indexs[0] + 1;
                            }else{
                                indexs[1] = indexs[1] + 1;
                                Label obligatoire_label = (Label)getGridPaneNode(childrens, ligne_index, column_index + 1);
                                if(obligatoire_label.getText().equals("Oui")){
                                    indexs[2] = indexs[2] + 1;
                                }
                            }
                        }
                    }
                }
            }catch(NullPointerException e){
            }
        }
        return indexs;
    }
    
    /**
     * @param event 
     * @docRoot Analyse toute la fiche technique et prend la decision
     */
    @FXML
    private void analyse(ActionEvent event) {
        
        int n_bon = 0, n_mauvais = 0, n_mauvais_obligatoire = 0;
        
        int indexs[] = single_stats(niveaux);
        n_bon = n_bon + indexs[0];
        n_mauvais =  n_mauvais + indexs[1];
        n_mauvais_obligatoire =  n_mauvais_obligatoire + indexs[2];
        indexs = single_stats(eclairage_signalisation);
        n_bon = n_bon + indexs[0];
        n_mauvais =  n_mauvais + indexs[1];
        n_mauvais_obligatoire =  n_mauvais_obligatoire + indexs[2];
        indexs = single_stats(pneus);
        n_bon = n_bon + indexs[0];
        n_mauvais =  n_mauvais + indexs[1];
        n_mauvais_obligatoire =  n_mauvais_obligatoire + indexs[2];
        indexs = single_stats(control_visuel);
        n_bon = n_bon + indexs[0];
        n_mauvais =  n_mauvais + indexs[1];
        n_mauvais_obligatoire =  n_mauvais_obligatoire + indexs[2];
        indexs = single_stats(instruments_de_bord);
        n_bon = n_bon + indexs[0];
        n_mauvais =  n_mauvais + indexs[1];
        n_mauvais_obligatoire =  n_mauvais_obligatoire + indexs[2];
        
     
        int total = n_bon + n_mauvais;
        int pourcentage_bon = n_bon*100/total;
        int pourcentage_mauvais = n_mauvais*100/total;
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Info visite");
        alert.setHeaderText(" Pourcentage de pieces en bonne état : " + pourcentage_bon+
                            "\n Pourcentage de pieces en mauvais état : " + pourcentage_mauvais+
                            "\n Nombre de pieces en mauvais état obligatoire: " + n_mauvais_obligatoire);
            
        if(pourcentage_bon > 75){
            if(n_mauvais_obligatoire != 0){
                alert.setContentText("La decision revient au chef exclusivement !");
            }else{
                alert.setContentText("Vous etes admis en visite technique !");
            }
        }else{
            alert.setContentText("Vous n'etes pas admis en visite technique !");
        }
        alert.showAndWait();
    }   
}
