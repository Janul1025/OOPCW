import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class F1GUI extends JFrame{

    //Swing components needed
    JTable dStableView;
    JScrollPane sp;
    JButton pointsAscendingOrder;
    JButton pointsDescendingOrder;
    JButton createRaceButton;
    JLabel dateOfRace;
    JLabel raceDateWithProb;
    JTable randomTableRace;
    JScrollPane sp2;
    JButton createRaceBEPro;
    JButton viewAlltheRaces;
    JButton search;
    JTextField inputName;
    JTable rTable;
    JScrollPane sp3;
    JTable results;
    JScrollPane sp4;


    //Constructor
    public F1GUI(Formula1ChampionshipManager x){
        //title of the GUI
        setTitle("Championship Manager GUI");

        //Table with driver stats
        String[] columnsStatTable = {"Driver Name","Team Name","Location","First Positions","Second Positions","Third Positions","Participated","Total Points"};
        String[][] rowsStatTable = new String[x.getDrivers().size()][8]; //Holds data of the table
        guiTableDataPointsDescending(rowsStatTable,x);
        dStableView = new JTable(rowsStatTable,columnsStatTable);
        dStableView.setDefaultEditor(Object.class, null); //get an uneditable table
        sp=new JScrollPane(dStableView); //make the table scrollable
        sp.setBounds(25,25,750,300);

        //Button to sort stat table in ascending order
        pointsAscendingOrder = new JButton("Ascending Order");
        pointsAscendingOrder.setBounds(175,360,200,50);
        pointsAscendingOrder.addActionListener(new  ActionListener() { //functionality
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                guiTableDataPointsAscending(rowsStatTable,x);
                dStableView.repaint(); //refresh the table
            }
        });

        //Button to sort the above table in descending order regarding number of first positions won
        pointsDescendingOrder = new JButton("Sort By Wins");
        pointsDescendingOrder.setBounds(385,360,200,50);
        pointsDescendingOrder.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                guiTableDataWinsDescending(rowsStatTable,x);
                dStableView.repaint(); //Refresh the table
            }
        });

        //Generates a random race with proof table
        String [] columnGenerateRandom = {"Name","Position"};
        String [][] randomRaceRow = new String[x.getDrivers().size()][2];
        dateOfRace = new JLabel();
        createRaceButton = new JButton("Random Race");
        createRaceButton.setBounds(175,420,200,50);
        createRaceButton.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String date = randomRace(x,randomRaceRow);
                dateOfRace.setBounds(175, 480, 250, 20);
                dateOfRace.setText("Date  : " + date);
                guiTableDataPointsDescending(rowsStatTable,x); //update values inside the table
                dStableView.repaint(); //Refresh the table
                randomTableRace = new JTable(randomRaceRow, columnGenerateRandom);
                randomTableRace.setDefaultEditor(Object.class, null);
                sp2 = new JScrollPane(randomTableRace);
                sp2.setBounds(165, 500, 210, 100);
                add(sp2);
            }
        });

        //Generates a random race according to probability with proof table
        createRaceBEPro = new JButton("Probability Random Race");
        createRaceBEPro.setBounds(385,420,200,50);
        //adds functionality to the button
        createRaceBEPro.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                String date = randomRaceWithProbability(x);
                guiTableDataPointsDescending(rowsStatTable,x);
                dStableView.repaint(); //Refresh the table
            }
        });

        //Display all the finished races
        viewAlltheRaces= new JButton("View Races");
        viewAlltheRaces.setBounds(175,620,200,50);
        viewAlltheRaces.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String[] raceTableColumn = {"Date","Participant Count"};
                String[][] raceTableData = new String[x.getDrivers().size()][2];
                raceTableData(x,raceTableData);
                rTable = new JTable(raceTableData,raceTableColumn);
                rTable.setDefaultEditor(Object.class, null);
                sp3 = new JScrollPane(rTable);
                sp3.setBounds(800,25,350,400);
                add(sp3);
            }
        });

        //Display search results
        inputName = new JTextField(); //Gets search name
        inputName.setBounds(385,680,200,50);
        search = new JButton("Search");
        search.setBounds(175,680,200,50);
        search.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String [] resultTableColumn = {"Date","FinishedPosition"};
                String [][] resultTableData = new String[x.getDrivers().size()][2];
                resultTableData(inputName.getText(),x,resultTableData);
                results = new JTable(resultTableData,resultTableColumn);
                results.setDefaultEditor(Object.class,null);
                sp4 = new JScrollPane(results);
                sp4.setBounds(800,450,350,300);
                add(sp4);
            }
        });

        //Adds swing components to the interface
        add(sp);
        add(pointsAscendingOrder);
        add(createRaceButton);
        add(createRaceBEPro);
        add(pointsDescendingOrder);
        add(dateOfRace);
        add(viewAlltheRaces);
        add(inputName);
        add(search);
        setSize(1175,820);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Programme ends after pressing close button of the GUI
    }

    public void guiTableDataPointsDescending(String[][] rows,Formula1ChampionshipManager x) {
        //Sort drivers in the "driverList" in descending order
        Collections.sort(x.getDrivers(), new PointComparatorasecending()); //Descending order / Points
        int i=0;
        for (Formula1Driver temp : x.getDrivers()){
            rows [i][0] = temp.getName();
            rows [i][1] = temp.getTeam();
            rows [i][2] = temp.getLocation();
            rows [i][3] = Integer.toString(temp.getFirstposition());
            rows [i][4] = Integer.toString(temp.getSecondpositions());
            rows [i][5] = Integer.toString(temp.getSecondpositions());
            rows [i][6] = Integer.toString(temp.getNumberofracecparticipated());
            rows [i][7] = Integer.toString(temp.getNumberofpoints());
            i++;
        }
    }


    public void guiTableDataPointsAscending(String[][] rows,Formula1ChampionshipManager x) {
        //Sort drivers in the "driverList" in ascending order
        Collections.sort(x.getDrivers(),new PointComparatorasecending());
        int i=0;
        for (Formula1Driver temp : x.getDrivers()){
            rows [i][0] = temp.getName();
            rows [i][1] = temp.getTeam();
            rows [i][2] = temp.getLocation();
            rows [i][3] = Integer.toString(temp.getFirstposition());
            rows [i][4] = Integer.toString(temp.getSecondpositions());
            rows [i][5] = Integer.toString(temp.getThirdposition());
            rows [i][6] = Integer.toString(temp.getNumberofracecparticipated());
            rows [i][7] = Integer.toString(temp.getNumberofpoints());
            i++;
        }
    }

    public void guiTableDataWinsDescending(String[][] rows,Formula1ChampionshipManager x) {
        //Sort drivers in the "driverList" in descending order considering wins
        Collections.sort(x.getDrivers(), new PointComparator());
        int i=0;
        for (Formula1Driver temp : x.getDrivers()){
            rows [i][0] = temp.getName();
            rows [i][1] = temp.getTeam();
            rows [i][2] = temp.getLocation();
            rows [i][3] = Integer.toString(temp.getFirstposition());
            rows [i][4] = Integer.toString(temp.getSecondpositions());
            rows [i][5] = Integer.toString(temp.getThirdposition());
            rows [i][6] = Integer.toString(temp.getNumberofracecparticipated());
            rows [i][7] = Integer.toString(temp.getNumberofpoints());
            i++;
        }
    }

    //creates a random race
    public String randomRace(Formula1ChampionshipManager x,String[][] randomRaceRow){
        try {
            ArrayList<Integer> validPosition = new ArrayList<>(); //Store generated valid positions
            int position;
            int j = 0;
            int month = (int) (Math.random() * 12) + 1; //Generates a random month
            Calendar calender = Calendar.getInstance();
            calender.set(2021, month, 0);
            int daysOfMonth = calender.get(Calendar.DAY_OF_MONTH);  //Gets num of days in the month
            int day = (int) (Math.random() * daysOfMonth + 1); //Generates a random day
            String dateS = day + "/" + month + "/" + 2021;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
            Date date = dateFormat.parse(dateS);
            Race race = new Race(date, x.getDrivers());
            x.races.add(race);
            //Selecting drivers one by one
            for (Formula1Driver temp :x.getDrivers()) {
                //Generates a random position and check for validity
                while (true) {
                    position = (int) (Math.random() * x.getDrivers().size()) + 1;
                    if (validPosition.isEmpty()) {
                        validPosition.add(position);
                        break;
                    } else if (!validPosition.contains(position)) {
                        validPosition.add(position);
                        break;
                    }
                }
                //Add values to the table
                randomRaceRow[j][0] = temp.getName();
                randomRaceRow[j][1] = Integer.toString(position);
                //Add points and position
                temp.calcpoints(position);
                if (position == 1) {
                    temp.setFirstposition();
                } else if (position == 2) {
                    temp.setSecondpositions();
                } else if (position == 3) {
                    temp.setThirdposition();
                   temp.setPosition(position);
              temp.calcpoints(position);
             race.addDriver(temp);
             randomRaceRow[j][0]=temp.getName();
             randomRaceRow[j][1]= String.valueOf(temp.getPosition());

                    race.setParticipatingDrivers();
                    temp.setNumberofracecparticipated();
                    //Store name and position of each driver
                    race.setDriverDetails(temp.getName(), String.valueOf(Integer.valueOf(position)));

                    j++;

                }
            }
            return dateS;
        }catch (ParseException ignored){
            return null;
        }
    }

    //Generates a random race where random driver win the race according to starting position (specific probability for each starting position)
    public String randomRaceWithProbability(Formula1ChampionshipManager x){
        try {
            ArrayList<Integer> validPositionProb = new ArrayList<>(); //Holds randomly created valid positions
            boolean won;
            int positionOfDriver;
            int randomNum;
            boolean gotFirstPosition = false;
            //Since this programme is made for one season of the championship year was not generated as a random.

            int month = (int) (Math.random() * 12) + 1; //Generates a random month
            Calendar calender = Calendar.getInstance();
            calender.set(2021, month, 0);
            int daysOfMonth = calender.get(Calendar.DAY_OF_MONTH);  //Gets num of days in the month
            int day = (int) (Math.random() * daysOfMonth + 1); //Generates a random day
            String dateS = day + "/" + month + "/" + 2021;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
            Date date = dateFormat.parse(dateS);
            Race race = new Race(date, x.getDrivers());
            x.races.add(race);
            Collections.shuffle(x.races);//Getting random starting positions by shuffling the list
            for (Formula1Driver temp : x.getDrivers()) {
                int starting = x.getDrivers().indexOf(temp)+1; //starting position = index of the shuffled list
                //Generates a valid finished position
                while (true) {
                    //Wins the race considering starting position and its probability
                    randomNum = (int) (Math.random() * 100 + 1);
                    won = false;
                    if (starting == 1) {
                        if (randomNum >= 1 && randomNum <= 40) {
                            won = true;
                        }
                    } else if (starting == 2) {
                        if (randomNum >= 40 && randomNum <= 70) {
                            won = true;
                        }
                    } else if (starting == 3 || starting == 4) {
                        if (randomNum >= 70 && randomNum <= 80) {
                            won = true;
                        }
                    } else if (starting >= 5 && starting <= 8) {
                        if (randomNum == 100 || randomNum == 99) {
                            won = true;
                        }
                    }else if(starting == 9){
                        won = true;
                    }
                    if (won && !gotFirstPosition || (x.getDrivers().size() < 9 && starting == x.getDrivers().size()-1 && !validPositionProb.contains(1))) {
                        positionOfDriver = 1;
                        gotFirstPosition = true;
                    } else {
                        positionOfDriver = (int) (Math.random() * x.getDrivers().size() - 1) + 2;
                    }
                    if (validPositionProb.isEmpty()) {
                        validPositionProb.add(positionOfDriver);
                        break;
                    } else if (!validPositionProb.contains(positionOfDriver)) {
                        validPositionProb.add(positionOfDriver);
                        break;
                    }
                }

                temp.calcpoints(positionOfDriver);
                //Add points and position
                if (positionOfDriver == 1) {
                    temp.setFirstposition();
                } else if (positionOfDriver == 2) {
                    temp.setSecondpositions();
                } else if (positionOfDriver == 3) {
                    temp.setThirdposition();
                }
                race.setParticipatingDrivers();
                temp.setNumberofracecparticipated();
                //Store name and position of each driver
                race.setDriverDetails(temp.getName(), Integer.toString(positionOfDriver));
            }

            return dateS;
        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }
    }

    //Set values in races table
    public void raceTableData(Formula1ChampionshipManager x,String [][] raceTableData){
        //Sort the races according to date
        Collections.sort(x.races,new DateComparator());
        int i =0;
        //Date and number of participants gets added to table for each race
        for(Race temp : x.races){
            raceTableData[i][0] = temp.getDate().toString();
            raceTableData[i][1] = Integer.toString(temp.getParticipatingDrivers().size());
            i++;
        }
    }

    //Set values in results table
    public void resultTableData(String name,Formula1ChampionshipManager x,String[][] resultTableData){
        int i = 0;
        //checks for driver name in races
        for(Race temp : x.races){
            for(String[] driverTemp : temp.getDriverDetails()) {
                //Checks whether selected array element is null
                if(driverTemp[0] != null){
                    //date and position is of the race gets added to the table if a participated race is found
                    if (driverTemp[0].equals(name)) {
                        resultTableData[i][0] = temp.getDate().toString();
                        resultTableData[i][1] = driverTemp[1];
                        break;
                    }
                }
            }
            i++;
        }
    }
}
