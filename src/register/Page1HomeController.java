package register;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class Page1HomeController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField idField;
    @FXML
    private TextField surnameField;
    @FXML
    private Button nextBtn;
    @FXML
    private Label textLabel;

    public void handleBtnActionNext(ActionEvent e){
        textLabel.setText("");

        Information information = new Information();
        if(nameField.getText().length()!=0 && surnameField.getText().length()!=0 && idField.getText().length()!= 0){
            if(checkName(nameField.getText()) && checkName(surnameField.getText()) && checkID(idField.getText())){
                information.setName(changeFormatName(nameField.getText()));
                information.setSurname(surnameField.getText().toUpperCase());
                information.setId(idField.getText());
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("page2.fxml"));
                    Parent parent = loader.load();
                    Scene scene = new Scene(parent);
                    Page2Controller page2 = loader.getController();
                    page2.setInfoLabel(information);

                    Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
          stage.show();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            else {
                nameField.clear();
                idField.clear();
                surnameField.clear();
                textLabel.setText("Name and Surname should be a letter and ID should be 10 digits.");
            }
        }
        else{
            nameField.clear();
            idField.clear();
            surnameField.clear();
            textLabel.setText("You must fill in all fields.");
        }
    }

    private Boolean checkName(String s){
        s.replace(" ","");
        boolean isAlpha = true;
        for(int i=0; i<s.length();i++){
            if(!Character.isLetter(s.charAt(i))){
                isAlpha=false;
                break;
            }
        }
        return isAlpha;
    }
    private Boolean checkID(String id){
        id.replace(" ","");
        boolean isDigit = true;
        if(id.length()==10) {
            for(int j=0;j<10;j++)
            try {
                int i = Integer.parseInt(id.substring(j,j+1));
            } catch (NumberFormatException e) {
                isDigit = false;
                break;
            }
        }else isDigit=false;
        return isDigit;
    }
    private String changeFormatName(String n){
        n=n.toLowerCase();
        return n.replaceFirst(n.substring(0,1),n.substring(0,1).toUpperCase());
    }
}
