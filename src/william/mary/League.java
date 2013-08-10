package william.mary;

import java.util.HashMap;
import java.util.Iterator;

public class League {

    private String name;
    private HashMap<String, Team> listTeams = new HashMap<>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap getListTeams() {
        return listTeams;
    }

    public void setListTeams(HashMap listTeams) {
        this.listTeams = listTeams;
    }

    void addTeam(Team TeamToAdd) {
        this.listTeams.put(TeamToAdd.getCode(), TeamToAdd);
    }

    Team getOneTeam(String Key) {
        Team team = this.listTeams.get(Key);
        return team;
    }
    
    void print() {
        System.out.println(" --- " + this.getName() + " ---");
        for (Iterator<String> it = listTeams.keySet().iterator(); it.hasNext();) {
            String Key = it.next();
            Team TeamToDisplay = listTeams.get(Key);
            System.out.println("L'équipe " + TeamToDisplay.getName() + "(" 
                    + TeamToDisplay.getCode() + ") appartient à " + this.getName() + ".");
            
        }
        System.out.println("");
    }
//    public void setupDiv1() {
//        for (int i = 0; i < list1.length; i++) {
//            String code = list1[i].substring(0, 3);
//            String name = list1[i].substring(4);
//            addTeam(1, code, name);
//        }
//    }
//
//    public void setupDiv2() {
//        for (int i = 0; i < list2.length; i++) {
//            String code = list2[i].substring(0, 3);
//            String name = list2[i].substring(4);
//            addTeam(2, code, name);
//        }
//    }
//
//    public void addTeam(int division, String code, String name) {
//        Team aTeam = new Team(division, code, name);
//        teams.add(aTeam);
//    }
//
//    public Team findTeam(String code) {
//        Team aTeam = null;
//        for (int i = 0; i < teams.size(); i++) {
//            aTeam = teams.get(i);
//            if (aTeam.code.equals(code)) {
//                aTeam.division = aTeam.getDivision();
//                break;
//            }
//        }
//        return aTeam;
//    }
//
//    public void addResult(String results) {
//        String hCode = results.substring(0, 3);
//        String aCode = results.substring(7, 10);
//        int hScore = Integer.parseInt((results.substring(5, 6)));
//        int aScore = Integer.parseInt(results.substring(12, 13));
//
//
//        Team homeTeam = this.findTeam(hCode);
//        homeTeam.addHomeResult(hScore, aScore);
//
//        Team awayTeam = this.findTeam(aCode);
//        awayTeam.addAwayResult(hScore, aScore);
//    }
//
//    public void print() {
//        System.out.println("DIV" + "\t" + "CODE" + "\t" + "POINTS" + "\t" + "PLAYED" + "\t" + "SCORED" + "\t" + "CONC" + "\t" + "DIFF");
//        for (Team aTeam : teams) {
//            aTeam.print();
//        }
//    }
}
