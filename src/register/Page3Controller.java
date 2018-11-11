package register;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Page3Controller implements Initializable {
    @FXML private TableView table;
    @FXML private TableColumn code,course,level;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       code.setCellValueFactory(new PropertyValueFactory<FileInfo,String>("code"));
       course.setCellValueFactory(new PropertyValueFactory<FileInfo,String>("name"));
       this.level.setCellValueFactory(new PropertyValueFactory<FileInfo,String>("color"));
//       table.setItems(getData());
//       TablePosition pos = (TablePosition) table.getSelectionModel().getSelectedCells().get(0);
//       int index = pos.getRow();
//       String selected = table.getItems().get(index).toString();
//       System.out.println(selected);
       setTable();
    }
    //cool it help
    public ObservableList<FileInfo> getData(){
        ObservableList <FileInfo> list = FXCollections.observableArrayList();
        ReadFile readFile = new ReadFile("allSubject");
        readFile.openFile();
        readFile.readFile();
        for(int i=0;i<readFile.getArraySize();i++){
            list.add(new FileInfo(readFile.getSubjectCode(i),readFile.getSubjectName(i),readFile.getSubjectColor(i)));
        }
        readFile.closeFile();
        return list;
    }


    public void setTable(){
        ObservableList <FileInfo> list = FXCollections.observableArrayList();
        ReadFile readFile = new ReadFile("allSubject");
        readFile.openFile();
        readFile.readFile();
        for(int i=0;i<readFile.getArraySize();i++){
            list.add(new FileInfo(readFile.getSubjectCode(i),readFile.getSubjectName(i),readFile.getSubjectColor(i)));
        }
        readFile.closeFile();
        table.setItems(list);
//        for(int i =0;i<readFile.getArraySize();i++) {
//            if(level.getCellObservableValue(i).getValue()=="3"){
//                level.setStyle("-fx-background-color: red;");
//            }
//            else if (level.getCellObservableValue(i).getValue()=="2"){
//                level.setStyle("-fx-background-color: green;");
//            }
//            else {
//                level.setStyle("-fx-background-color: blue;");
//            }
//        }

    }
}