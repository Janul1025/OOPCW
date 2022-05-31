import java.io.Serializable;

public abstract class Driver implements Serializable {

    private String name;
    private String location;
    private String team;





    public Driver(String name, String location, String team){
        this.name=name;
        this.location=location;
        this.team=team;

    }

    public abstract int calcpoints(int position);

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getTeam() {
        return team;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTeam(String team) {
        this.team = team;
    }


    public abstract int setNumberofracecparticipated();
}
