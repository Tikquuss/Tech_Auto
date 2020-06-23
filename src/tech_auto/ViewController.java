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
import javafx.scene.control.Button;
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
    private Button okButton;
    @FXML
    private CheckBox huile_moteur_bon;
    @FXML
    private CheckBox huile_moteur_mauvais;
    @FXML
    private CheckBox liquide_frein_bon;
    @FXML
    private CheckBox liquide_frein_mauvais;
    @FXML
    private CheckBox circuit_refroid_bon;
    @FXML
    private CheckBox circuit_refroid_mauvais;
    @FXML
    private CheckBox circuit_direction_bon;
    @FXML
    private CheckBox circuit_direction_mauvais;
    @FXML
    private CheckBox batterie_bon;
    @FXML
    private CheckBox batterie_mauvais;
    @FXML
    private CheckBox lavage_glasse_bon;
    @FXML
    private CheckBox lavage_glasse_mauvais;
    @FXML
    private CheckBox veilleuses_bon;
    @FXML
    private CheckBox veilleuses_mauvais;
    @FXML
    private CheckBox feux_position_bon;
    @FXML
    private CheckBox feux_position_mauvais;
    @FXML
    private CheckBox feux_de_route_bon;
    @FXML
    private CheckBox feux_de_route_mauvais;
    @FXML
    private CheckBox clignotants_bon;
    @FXML
    private CheckBox clignotants_mauvais;
    @FXML
    private CheckBox feux_dettresse_bon;
    @FXML
    private CheckBox feux_dettresse_mauvais;
    @FXML
    private CheckBox feux_stop_bon;
    @FXML
    private CheckBox feux_stop_mauvais;
    @FXML
    private CheckBox feux_recul_bon;
    @FXML
    private CheckBox feux_recul_mauvais;
    @FXML
    private CheckBox e_plaque_police_bon;
    @FXML
    private CheckBox e_plaque_police_mauvais;
    @FXML
    private CheckBox antibrouillard_bon;
    @FXML
    private CheckBox antibrouillard_mauvais;
    @FXML
    private CheckBox reglage_phares_bon;
    @FXML
    private CheckBox up_AV_bon;
    @FXML
    private CheckBox up_AV_mauvais;
    @FXML
    private CheckBox up_AR_bon;
    @FXML
    private CheckBox up_AR_mauvais;
    @FXML
    private CheckBox pression_bon;
    @FXML
    private CheckBox pression_mauvais;
    @FXML
    private CheckBox pression_rds_bon;
    @FXML
    private CheckBox cv_1_bon;
    @FXML
    private CheckBox cv_1_mauvais;
    @FXML
    private CheckBox cv_2_bon;
    @FXML
    private CheckBox cv_6_mauvais;
    @FXML
    private CheckBox cv_3_bon;
    @FXML
    private CheckBox cv_3_mauvais;
    @FXML
    private CheckBox cv_4_bon;
    @FXML
    private CheckBox cv_4_mauvais;
    @FXML
    private CheckBox cv_5_bon;
    @FXML
    private CheckBox cv_5_mauvais;
    @FXML
    private CheckBox cv_6_bon;
    @FXML
    private CheckBox idb_1_bon;
    @FXML
    private CheckBox idb_1_mauvais;
    @FXML
    private CheckBox idb_2_bon;
    @FXML
    private CheckBox idb_2_mauvais;
    @FXML
    private CheckBox idb_3_bon;
    @FXML
    private CheckBox idb_3_mauvais;
    @FXML
    private CheckBox idb_4_mauvais;
    @FXML
    private CheckBox idb_5_bon;
    @FXML
    private CheckBox idb_5_mauvais;
    @FXML
    private CheckBox idb_6_bon;
    @FXML
    private CheckBox idb_6_mauvais;
    @FXML
    private Label idb_1;
    @FXML
    private Label idb_2;
    @FXML
    private Label idb_3;
    @FXML
    private CheckBox idb_7_bon;
    @FXML
    private CheckBox idb_8_bon;
    @FXML
    private CheckBox idb_7_mauvais;
    @FXML
    private CheckBox idb_8_mauvais;
    @FXML
    private CheckBox idb_9_bon;
    @FXML
    private CheckBox idb_9_mauvais;
    @FXML
    private CheckBox idb_10_mauvais;
    @FXML
    private CheckBox idb_10_bon;
    @FXML
    private CheckBox idb_11_bon;
    @FXML
    private CheckBox idb_11_mauvais;
    
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
        // TODO
    }    

    private void checkform(){
    }
    
    @FXML
    private void analyse(ActionEvent event) {
        
        int n_bon = 0, n_mauvais = 0, n_mauvais_obligatoire = 0;
        
        ObservableList<Node> childrens = niveaux.getChildren();
        
        int column_index = 0, ligne_index = 0;
        
        int n_nodes = childrens.size();
        int n_rows = niveaux.getRowConstraints().size();
        int n_columns = niveaux.getColumnConstraints().size();
        
        System.out.println(n_rows);
        System.out.println(n_columns);
        
        for (Node node : childrens) {
            try{
                column_index = niveaux.getColumnIndex(node);
                ligne_index = niveaux.getRowIndex(node);
                
                if(ligne_index != 0 && column_index != 0) {
                    if(column_index != 3){
                        CheckBox cb = (CheckBox)node;
                        if(cb.isSelected()){
                            if(column_index == 1){
                                n_bon = n_bon + 1;
                            }else{
                                n_mauvais = n_mauvais + 1;
                                /*
                                Label obligatoire_label = (Label)childrens.get((n_rows-1)*ligne_index + 3);
                                String s = obligatoire_label.getText();
                                System.out.println(s);
                                
                                if(s.equals("Oui")){
                                    n_mauvais_obligatoire = n_mauvais_obligatoire + 1;
                                }
                                //*/
                            }
                        }else{
                        }
                    }else{
                        Label l = (Label)node;
                        //System.out.println(l.getText());
                    }
                }
            }catch(NullPointerException e){
            }
        }
        
        int total = n_bon + n_mauvais;
        int pourcentage_bon = n_bon*100/total;
        int pourcentage_mauvais = n_mauvais*100/total;
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Info visite");
        alert.setHeaderText("pourcentage de pieces en bonne état : " + pourcentage_bon+
                            "\npourcentage de pieces en mauvais état : " + pourcentage_mauvais);
            
        if(pourcentage_bon > 75){
            alert.setContentText("Vous etes admis en visite technique !");
        }else{
            alert.setContentText("Vous n'etes pas admis en visite technique !");
        }
        alert.showAndWait();
    }   
}
