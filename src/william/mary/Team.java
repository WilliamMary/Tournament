package william.mary;

import java.util.HashMap;
import java.util.Iterator;

public class Team {

    /* Attributs */
    private String name;
    private String code;
    private int points;
    private int matchPlayed;
    private int goalScored;
    private int conceded;
    private int difference;
    private HashMap<String, Match> listMatchs = new HashMap();

    /* Constructeur */
    public Team(String code, String name) {
        this.code = code;
        this.name = name;
        this.points = 0;
        this.matchPlayed = 0;
        this.goalScored = 0;
        this.conceded = 0;
        this.difference = 0;
    }

    /* Constructeur */
    public Team(String name, String code, int points, int matchPlayed, int goalScored,
            int conceded, int difference) {
        this.name = name;
        this.code = code;
        this.points = points;
        this.matchPlayed = matchPlayed;
        this.goalScored = goalScored;
        this.conceded = conceded;
        this.difference = difference;
    }

    /* Accesseurs(get) et mutateurs(set) */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getMatchPlayed() {
        return matchPlayed;
    }

    public void setMatchPlayed(int matchPlayed) {
        this.matchPlayed = matchPlayed;
    }

    public int getGoalScored() {
        return goalScored;
    }

    public void setGoalScored(int goalScored) {
        this.goalScored = goalScored;
    }

    public int getConceded() {
        return conceded;
    }

    public void setConceded(int conceded) {
        this.conceded = conceded;
    }

    public int getDifference() {
        return difference;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }

    public HashMap getListMatchs() {
        return listMatchs;
    }

    public void setListMatchs(HashMap listMatchs) {
        this.listMatchs = listMatchs;
    }

    /* Méthode permettant d'incrémenter l'attribut goalScored. */
    public void addGoalScored(int Score) {
        Score += this.getGoalScored();
        this.setGoalScored(Score);
    }

    /* Méthode permettant d'incrémenter l'attribut conceded. */
    public void addConcededScore(int Score) {
        Score += this.getConceded();
        this.setConceded(Score);
    }

    /* Méthode permettant de mettre à jour l'ensemble des statistiques d'un objet Team. */
    public void upgradeStatTeam(int points, int goalScored, int conceded) {
        this.setPoints(this.getPoints() + points);
        this.setMatchPlayed(this.getMatchPlayed() + 1);
        this.addGoalScored(goalScored);
        this.addConcededScore(conceded);
        this.setDifference(this.getGoalScored() - this.getConceded());
    }

    /* Méthode permettant d'afficher l'ensemble des informations d'un objet Team. */
    public void print() {
        System.out.println(" " + this.getCode() + "  | " + this.getName() + " | " + this.getPoints()
                + " | " + this.getMatchPlayed() + " | " + this.getGoalScored()
                + " | " + this.getConceded() + " | " + this.getDifference());
    }

    static Boolean teamFree(Boolean display, String teamCode) {
        Boolean teamFree = true;
        for (Iterator<String> it = Main.listLeague.keySet().iterator(); it.hasNext();) {
            String keyListLeague = it.next();
            if (Main.listLeague.get(keyListLeague).getListTeams().containsKey(teamCode)) {
                teamFree = false;
                break;
            }
        }
        if (teamFree && display) {
            Main.listTeam.get(teamCode).print();
        }
        return teamFree;
    }
}
