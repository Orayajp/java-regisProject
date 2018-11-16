package register;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class Page2Controller {
    @FXML
    private Label infoLabel;
    @FXML
    private Button allSubBtn,subBtn,classBtn;
    public void setInfoLabel(Information info){
        infoLabel.setText(info.getName()+"    "+info.getSurname()+"\n"+info.getId());
    }
    public String getLabel(){
        return infoLabel.getText();
    }
    public void handleBtnAllSubject(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("page3All.fxml"));
            Parent parent = loader.load();
            Page3Controller page3 = loader.getController();
            page3.setInfoLabel(getLabel());
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    public void handleBtnClassSchedule(ActionEvent event){
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("page4.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
