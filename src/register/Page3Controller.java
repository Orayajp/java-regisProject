package register;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Page3Controller implements Initializable {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox box;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button backBtn;
    @FXML
    private Label infoLabel;

    public void setInfoLabel(String info){
        infoLabel.setText(info);
    }
    public void setVBox(){
        ReadFile readFile = new ReadFile("allSubject");
        readFile.openFile();
        readFile.readFile();
        for(int i=0;i<readFile.getArraySize();i++){
            Label label = new Label(readFile.getSubjectCode(i)+"            "+readFile.getSubjectName(i));
            if(readFile.getSubjectColor(i).equals("3")){
                label.setTextFill(Color.rgb(255,10,89));
                label.setFont(Font.font(18));
            }else if(readFile.getSubjectColor(i).equals("2")){
                label.setTextFill(Color.rgb(70,40,244));
                label.setFont(Font.font(18));
            }
            else
                label.setTextFill(Color.rgb(94,200,94));
            label.setFont(Font.font(18));
            box.getChildren().add(label);
        }
        readFile.closeFile();
        //---------test--------------
        for(int i =0 ; i < 150;i++) {
            Label la = new Label("My name is Ja");
            la.setFont(Font.font(18));
            box.getChildren().add(la);
        }
    }

    public void handleBackBtn(ActionEvent event){
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("page2.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setVBox();
        scrollPane.setContent(anchorPane);
        scrollPane.setFitToHeight(true);
    }

}