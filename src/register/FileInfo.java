package register;

import javafx.beans.property.SimpleStringProperty;

public class FileInfo {
    private SimpleStringProperty code;
    private SimpleStringProperty name;
    private SimpleStringProperty color;
    public FileInfo(String code, String name, String color){
        this.code = new SimpleStringProperty(code);
        this.name = new SimpleStringProperty(name);
        this.color = new SimpleStringProperty(color);
    }

    public String getCode() {
        return code.get();
    }

    public SimpleStringProperty codeProperty() {
        return code;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getColor() {
        return color.get();
    }

    public SimpleStringProperty colorProperty() {
        return color;
    }
}
