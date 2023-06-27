package AreaProj;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

public class IndianStates {
    static ArrayList<States> list = new ArrayList<States>();

    public static void main(String[] args)throws ParseException{
        try{
            File f1 = new File("C:\\BellyPot\\Java-in-VSCODE\\AreaProj\\sample.txt");    
            Scanner dataReader = new Scanner(f1);  
            while (dataReader.hasNextLine()) {  
                String fileData = dataReader.nextLine();  
                String words[]=fileData.split("\t");
                
                States st=new States(words);
                //System.out.println(st);
                list.add(st);
            }  
            
            dataReader.close();  
        }catch(FileNotFoundException exception){
            System.out.println("File not found!!");
            exception.printStackTrace();  
        } 
        finally
        {
            for(States s:list)
            {
                System.out.println(s);
            }
            //System.out.println(list);
        } 
    }
}
