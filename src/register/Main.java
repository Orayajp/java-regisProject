package register;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("page1home.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 750, 450));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

//git remote add origin https://github.com/Orayajp/java-regisProject.git
//git push -u origin master


    public static void main(String[] args) {
        launch(args);
    }
}
