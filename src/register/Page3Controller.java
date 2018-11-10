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
    @FXML private TableView<FileInfo> table;
    @FXML private TableColumn<FileInfo, String> subCode;
    @FXML private TableColumn<FileInfo, String> title;
    @FXML private TableColumn<FileInfo, String> level;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        subCode.setCellValueFactory(new PropertyValueFactory<FileInfo,String>("Subjects Code"));
        title.setCellValueFactory(new PropertyValueFactory<FileInfo,String>("Course title"));
        level.setCellValueFactory(new PropertyValueFactory<FileInfo,String>("Level"));

        table.setItems(getSubjectAndCode());
    }
    //test git in my project

    public ObservableList<FileInfo> getSubjectAndCode(){
        ObservableList<FileInfo> fileInfos = FXCollections.observableArrayList();
//        ReadFile file = new ReadFile("allSubject.txt");
//        for(int i=0;i<file.getArraySize();i++){
//            fileInfos.add(new FileInfo(file.getSubjectCode(i),file.getSubjectName(i),file.getSubjectColor(i)));
//        }
        fileInfos.add(new FileInfo("202020","comSic","Red"));
        return fileInfos;
    }
}