package register;

import javafx.beans.property.SimpleStringProperty;

public class FileInfo {
    private final SimpleStringProperty code;
    private final SimpleStringProperty name;
    private final SimpleStringProperty color;

    public FileInfo(String code, String name, String color) {
        this.code = new SimpleStringProperty(code);
        this.name = new SimpleStringProperty(name);
        this.color = new SimpleStringProperty(color);
    }

    public String getCode() {
        return code.get();
    }

    public String getName() {
        return name.get();
    }

    public String getColor() {
        return color.get();
    }
}
