package register;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    private Scanner sc;
    private String fileName;
    public ReadFile(String fileName){
        this.fileName = fileName;
    }
    ArrayList name = new ArrayList();
    ArrayList code = new ArrayList();
    ArrayList color = new ArrayList();

    public void openFile(){
        try {
            sc = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void readFile(){
        String mes, code, sub, color;
        while(sc.hasNext()){
            mes = sc.nextLine();
            color = mes.substring(0,1);
            code = mes.substring(1,9);
            sub = mes.substring(10);
            name.add(sub);
            this.code.add(code);
            this.color.add(color);
        }
        sc.close();
    }
    public int getArraySize(){
        return name.size();
    }

    public String getSubjectCode(int i){
        return (String) code.get(i);
    }

    public String getSubjectColor(int i){
        return (String) color.get(i);
    }
    public String getSubjectName(int i){
        return  (String) name.get(i);
    }
}
