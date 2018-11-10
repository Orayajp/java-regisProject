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


public class Page2Controller {
    @FXML
    private Label infoLabel;
    @FXML
    private Button allSubBtn,subBtn,classBtn;

    public void setInfoLabel(Information info){
        infoLabel.setText(info.getName()+"      "+info.getSurname()+"\n"+info.getId());
    }

    public void handleLabelAllSubject(ActionEvent event){
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("page3All.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
