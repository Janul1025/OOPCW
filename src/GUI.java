//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class GUI extends JFrame {
//
//
//    private String[][] array ;
//    private String[] colum = {"name", "team", "points"};
//    JTable driverTable;
//    JScrollPane sp;
//    JButton asc;
//    JButton newRace;
//    JLabel dateLabel;
//    JTable randomTable;
//    JScrollPane sp2;
//    JButton races;
//    JTable rcaeTable;
//    JScrollPane raceSp;
//    JButton search;
//    JTextArea inputText;
//    JTable resultTable;
//    JLabel nameLabel;
//
//
//
//
//
////   table.setDefaultEditor(Object.class, null);
//
//
//    public GUI(Formula1ChampionshipManager x) throws ParseException {
//
//        setTitle("Championship Manager GUI");
//
//
//        String[] columnsStatTable = {"Driver Name","Team Name","Location","First Positions","Second Positions","Third Positions","Participated","Total Points"};
//        String[][] rowsStatTable = new String[x.getDrivers().size()][8];
//
//
//
//
//        array = new String[x.getDrivers().size()][7];
//        Collections.sort(x.getDrivers(), new PointComparator());
//        tableGUI(x.getDrivers());
//        driverTable = new JTable(array, colum);
//        driverTable.setBounds(50, 10, 500, 100);
//        sp = new JScrollPane(driverTable);
//        Collections.sort(x.getDrivers(), new PointComparatorasecending());
//        tableGUI(x.getDrivers());
//        asc = new JButton("Click here");
//        asc.setBounds(800,140,300,200);
//        asc.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                Collections.sort(x.getDrivers(), new PointComparatorasecending());
//                tableGUI(x.getDrivers());
//                driverTable.repaint();
//
//            }
//        });
//
//        String [] columRands ={ "driver name ","position"};
//        String [] [] rowRand= new String[x.getDrivers().size()][2];
//        String date= randomRace(x.getDrivers(),x.getRaces(),rowRand);
//        randomTable=new JTable(rowRand,columRands);
//        randomTable.setBounds(120,40,300,400);
//
//
//        randomTable= new JTable();
//        dateLabel=new JLabel();
//        dateLabel.setBounds(160,90,20,40);
//
//
//
//        newRace = new JButton(" Create new race");
//        newRace.setBounds(400, 140, 300, 200);
//        newRace.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
////               String date= randomRace(x.getDrivers(),x.addRace(),rowRand);
////               randomTable=new JTable(rowRand,columRands);
////               randomTable.setBounds();
////                sp2=new JScrollPane(randomTable);
//                tableGUI(x.getDrivers());
//                driverTable.repaint();
//                String date= null; //t
//                try {
//                    date = randomRace(x.getDrivers(),x.getRaces(),rowRand);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                randomTable=new JTable(rowRand,columRands);
//               randomTable.setBounds(90,200,40,50);
//               randomTable.setDefaultEditor(Object.class,null);
//               sp2=new JScrollPane(randomTable);
//
//                dateLabel.setText(date);
//
//                add(sp2);
//
//
//            }
//        });
//
//        String [] columHeadRace= {"Date","No of PARTICIPANTS"};
//        String [][]  rowRaces= new String[x.getRaces().size()][2];
//        Collections.sort(x.getRaces(),new DateComparator() );
//        int y=0;
//        for(Race tem : x.getRaces()) {                             //add method fotr thuis  *************************
//            rowRaces[y][0] = String.valueOf(tem.getDate());
//            rowRaces[y][1] = String.valueOf(tem.getParticipatingDrivers().size());
//            y++;
//        }
//
//
//
//
//        races= new JButton("View races");
//        races.setBounds(1200,200,200,400);
//        races.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                rcaeTable=new JTable(rowRaces,columHeadRace);
//
//
//                rcaeTable.setBounds(200,30,40,20);
////               rcaeTable.setVisible(false);
//                rcaeTable.setDefaultEditor(Object.class,null);
//                raceSp=new JScrollPane(rcaeTable);
//                add(raceSp);
//
//
//
//
//            }
//        });
//        nameLabel= new JLabel();
//        nameLabel.setBounds(300,30,400,50);
//        String [] colimHEadResult ={"Date","Position"};
//        String [][] rowsREsult = new String[x.getRaces().size()][2];
//        inputText= new JTextArea();
//        search = new JButton("Search");
//        search.setBounds(50,200,200,400);
//        races.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
////                inputText.getText();
//                nameLabel.setText(inputText.getText());
////                print(inputText.getText(),x.getRaces(),);
//                resultTable= new JTable(rowsREsult,colimHEadResult);
//                resultTable.setBounds(250,50,600,700);
//                resultTable.setDefaultEditor(Object.class, null);
//
//
//            }
//        });
//
//
//
//
//        add(sp);
//        add(races);
//        add(asc);
//        add(newRace);
//        add(dateLabel);
//        add(nameLabel);
//        add(search);
//        setTitle("GUI");
//        setSize(500, 500);
//        setLayout(null);
//        setVisible(true);
//
//        add(driverTable);
//
//
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//
//    }
//
//    public void print(String name,ArrayList<Race> races,String [][] darray) {
//        int i=0;
//        for (Race x : races) {
//            for (String[] x2 : x.getDriverDetails()) {
//                if(x2[0].equals(name)){
//                    darray[0][0]= String.valueOf(x.getDate());
//                    darray[0][1] = x2[i];
//                    i++;
//                    break;
//                }
//
//            }
//        }
//    }
//
//
//
//    public void tableGUI(ArrayList<Formula1Driver> drivers) {
//
//        int i = 0;
//        for (Formula1Driver x : drivers) {
//            array[i][0] = x.getName();
//            array[i][1] = x.getTeam();
//            array[i][2] = x.getLocation();
//            array[i][3]= String.valueOf(x.getNumberofpoints());
//            array[i][4]= String.valueOf(x.getFirstposition());
//            array[i][5]= String.valueOf(x.getSecondpositions());
//            array[i][6]= String.valueOf(x.getThirdposition());
//            i++;
//
//        }
//
//
//
//
////
////            public void tableGUI(ArrayList<Formula1Driver> drivers,int g){
////       if(g==1) {
////
////           Collections.sort(drivers, new PointComparator());
////       }else if(g==2){
////           Collections.sort(drivers, new PointComparatorasecending());
////
////       }
////        int i=0;
////        for (Formula1Driver x: drivers){
////           array[i][0] = x.getName();
////            array[i][1] = x.getTeam();
////            array[i][2]=x.getLocation();
////            array[i][2] =  x.getNumberofpoints();
////            array[i][3] = x.getFirstposition();
////            array[i][4] = x.getSecondpositions();
////            array[i][5] =x.getThirdposition();
////            i++;
//
//
//    }
//
//    public String randomRace(ArrayList<Formula1Driver> drivers, ArrayList<Race> races, String[][] rowRand) throws ParseException {
//        ArrayList<Integer> validityChecker = new ArrayList<>();
////        Scanner input= new Scanner(System.in);
////        System.out.println("Enter date dd/MM/yyyy :");
////        String date=input.next();
////        Race race=new Race(date);
////        races.add(race);
//        int position;
//
//        int month = (int) (Math.random() * 12 +1);
//        Calendar calendar= Calendar.getInstance();
//        calendar.set(2021,month,0);
//        int daysofmonth= calendar.get(Calendar.DAY_OF_MONTH);
//        int day=(int)(Math.random()* daysofmonth)+1;
//
//
//        String dates = day+"/"+month+"/"+2021;
//        SimpleDateFormat foemattee= new SimpleDateFormat("dd/MM/yyyy");
//        Date date= foemattee.parse(dates);
//
//
//        Race race = new Race(date,drivers.size());
//        races.add(race);
//        int j=0;
//
//
//        for (Formula1Driver x : drivers) {
//            int randomPosition;
//            race.addDriver(x);
//            while (true) {
//               randomPosition = (int) (Math.random() * drivers.size()) + 1;
//                if (validityChecker.isEmpty()) {
//                    validityChecker.add(randomPosition);
//                    break;
//                } else if (!validityChecker.contains(randomPosition)) {
//                    validityChecker.add(randomPosition);
//                    break;
//                }
//
//            }
//
//            if (randomPosition == 1) {
//                     x.setFirstposition();
//            } else if (randomPosition == 2) {
//                    x.setSecondpositions();
//            } else if (randomPosition == 3) {
//                     x.setThirdposition();
//                x.setPosition(randomPosition);
//                x.calcpoints(randomPosition);
//                race.addDriver(x);
//                rowRand[j][0]=x.getName();
//                rowRand[j][1]= String.valueOf(x.getPosition());
//                race.setDriverDetails(x.getName(),String.valueOf(randomPosition));
//
//                j++;
//                }
//
//
//        }
//        return dates;
//    }
//
//    public void probabilityRandomRace(ArrayList<Formula1Driver> drivers, ArrayList<Race> races, String [][] rowland) throws ParseException {
//        ArrayList<Integer> validityChecker = new ArrayList<>();
//        ArrayList<Integer> startingChecker = new ArrayList<>();
//        int month=(int)(Math.random()*12)+1;
//
//
//
//        Calendar calendar= Calendar.getInstance();
//        calendar.set(2021,month,0);
//        int daysOfMonth= calendar.get(calendar.DAY_OF_MONTH);
//        int day= (int)(Math.random()*daysOfMonth)+1;
//
//        String dates = day+"/"+month+"/"+2021;
//        SimpleDateFormat foemattee= new SimpleDateFormat("dd/MM/yyyy");
//        Date date= foemattee.parse(dates);
//
//
//
////        Race race = new Race(date,drivers.size()); //driver array
//        races.add(race);
//
//        for (Formula1Driver x : drivers) {
//
//            race.addDriver(x);
//            int position=0;
//            int start;
//
//            while (true) {
//                boolean won=false;
//                while ((true)) {
//                 start = (int) (Math.random() * drivers.size()) + 1;
//                if (startingChecker.isEmpty()) {
//                    startingChecker.add(start);
//                    break;
//                } else if (!startingChecker.contains(start)) {
//                    startingChecker.add(start);
//                    break;
//                }
//            }
//                if (start == 1) {
//                    int random = (int) (Math.random() * 100) + 1;
//                    if (random <= 40 && random >= 1) {
//                            won=true;
//                            position = 1;
//                    }
//
//                } else if (start == 2) {
//                    int random = (int) (Math.random() * 100) + 1;
//                    if (random <= 70 && random >= 40) {
//                        won=true;
//                        position = 1;
//                    }
//
//                } else if (start == 3 || start == 4) {
//                    int random = (int) (Math.random() * 100) + 1;
//                    if (random <= 50 && random >= 40) {
//                        won=true;
//                        position = 1;
//
//                    }
//
//                } else if (start >= 5 && start <= 9) {
//                    int random = (int) (Math.random() * 100) + 1;
//                    if (random == 100 || random == 98) {
//                        won=true;
//                        position = 1;
//                    }
//                } if(start>9 || !won) {
//                    position = (int) (Math.random() * drivers.size()-1)+2;
//
//                }
//                    if (validityChecker.isEmpty()) {
//                        validityChecker.add(position);
//                        break;
//                    } else if (!validityChecker.contains(position)) {
//                        validityChecker.add(position);
//                        break;
//                    }
//
//                }
//
//                if (position == 1) {
//                    x.setFirstposition();
//                } else if (position == 2) {
//                    x.setSecondpositions();
//                } else if (position == 3) {
//                    x.setThirdposition();
//                    x.setPosition(position);
//                    x.calcpoints(position);
//                    race.setDriverDetails(x.getName(),String.valueOf(position));
//
//
//
//                }
//            }
//
//
//        }
//        }
//
//
//
//
//
//
//
//
//
