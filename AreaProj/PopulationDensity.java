package AreaProj;
import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
//import all_programs.Shape.*;
public class PopulationDensity {//extends all_programs.Shape.Rectangle {
    ArrayList<Double> list;
    
    PopulationDensity(){
        list = new ArrayList<Double>();
        //super.testv+=6;
    }
    public static void main(String[] args){
        PopulationDensity ob = new PopulationDensity();
        /*all_programs.Shape.Square sq=new all_programs.Shape.Square(12.0,"Yellow",true);
        //new java.util.Scanner(System.in).nextLine();
        //sq.testv+=5;
        
        System.out.println(sq);*/
        try{
            File f1 = new File("C:\\BellyPot\\Java-in-VSCODE\\AreaProj\\sample.txt");    
            Scanner dataReader = new Scanner(f1);  
            while (dataReader.hasNextLine()) {  
                String fileData = dataReader.nextLine();  
                String words[]=fileData.split("\t");
                //System.out.println(Arrays.toString(words));  
                ob.sortItOut(words);
            }  
            dataReader.close();  
        }catch(FileNotFoundException exception){
            System.out.println("File not found!!");
            exception.printStackTrace();  
        }  
        //System.out.println(ob.list); 
    }

    private double convToNumber(String number){
        String[] num=number.split(",");
        String n="";
        for(String digs:num)
            n=n+digs;
        return Double.valueOf(n);
    }

    private void sortItOut(String[] words){
        int i=1;
        String state="";
        while(Character.isLetter(words[i].charAt(0))){
            state=state+words[i]+" ";
            i++;
        }
        int index=(state.trim()).lastIndexOf(" ");
        state=state.substring(0,index);
        double area = convToNumber(words[i]), population = convToNumber(words[i+1]);
        list.add(population/area);
        System.out.println("Density = "+population/area+"\tState = "+state);
    }
}