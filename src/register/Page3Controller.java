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
//    @FXML private TableColumn<FileInfo, String> subCode;
//    @FXML private TableColumn<FileInfo, String> title;
//    @FXML private TableColumn<FileInfo, String> level;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//       TableColumn subCode = new TableColumn("Subjects code");
//       TableColumn title = new TableColumn("Course title");
//       TableColumn level = new TableColumn("Level");
//       table.getColumns().addAll(code,course,this.level);
//       final ObservableList<FileInfo> fileInfos = FXCollections.observableArrayList(
//                new FileInfo("20202020","Comsci","Red"));

       code.setCellValueFactory(new PropertyValueFactory<FileInfo,String>("code"));
       course.setCellValueFactory(new PropertyValueFactory<FileInfo,String>("name"));
       this.level.setCellValueFactory(new PropertyValueFactory<FileInfo,String>("color"));
       table.setItems(getData());


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
}