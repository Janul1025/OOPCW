import java.io.Serializable;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;

public class Race implements Serializable {  //create race class

    private Date date;
    private ArrayList<Formula1Driver> participatingDrivers= new ArrayList<>();


    private  String [][] driverDetails;
    private int x=0;

    public Race(Date date, ArrayList<Formula1Driver> drivers) {  //race constructor
    }

    public void setDriverDetails(String name, String position) { //set values for the drivers details
        this.driverDetails [x][0] = name;
        this.driverDetails [x][1] = position;
        x++;
    }

    public String[][] getDriverDetails() {  //get drivers details

        return driverDetails;
    }

    public Date getDate() {  //get date
        return date;
    }



    public void setParticipatingDrivers(ArrayList<Formula1Driver> participatingDrivers) {
        this.participatingDrivers = participatingDrivers;
    }

    public ArrayList<Formula1Driver> getParticipatingDrivers() {

        return participatingDrivers;
    }



    public Race(Date date, int x){
        this.driverDetails= new String[x][2];
        this.date=date;


    }

    public void addDriver(Formula1Driver driver){ //this called add driver method
        participatingDrivers.add(driver);

    }


    public void setParticipatingDrivers() {
    }
}
