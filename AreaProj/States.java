package AreaProj;

import java.text.NumberFormat;
import java.util.Locale;
import java.text.ParseException;

public class States {
    private long population;
    private double area;
    private String state,region;

    public String getRegion() {
        return region;
    }

    public String getState() {
        return state;
    }
    
    public double getArea() {
        return area;
    }

    public long getPopulation() {
        return population;
    }

    public States(String[] stat)throws ParseException{
        this.state=stat[1];
        this.region=stat[2];
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        area=format.parse(stat[3]).doubleValue();
        population=format.parse(stat[4]).longValue();
    }

    public double calDensity(){
        return population/area;
    }

    @Override
    public String toString(){
        return "\n"+state+"[Region = "+region+", \n\tArea = "+ area +" sq miles, \n\tPopulation = "+population+", \n\tPopulation Density = "+String.format("%.3g",calDensity())+"]\n";
    }
}
