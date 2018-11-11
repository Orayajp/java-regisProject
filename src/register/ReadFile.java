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
    ArrayList <String> name = new ArrayList();
    ArrayList <String> code = new ArrayList();
    ArrayList <String> color = new ArrayList();

    public void openFile(){
        try {
            sc = new Scanner(new File(this.fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Cannot Find This File.");
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
    }

    public void closeFile(){
        sc.close();
    }

    public int getArraySize(){
        return name.size();
    }

    public String getSubjectCode(int i){
        return code.get(i);
    }

    public String getSubjectColor(int i){
        return color.get(i);
    }

    public String getSubjectName(int i){
        return name.get(i);
    }
}
