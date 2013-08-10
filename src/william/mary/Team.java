package william.mary;

import java.util.HashMap;

public class Team {

    private String name;
    private String code;
    private int points;
    private int matchPlayed;
    private int goalScored;
    private int conceded;
    private int difference;
    private HashMap<String, Match> listMatchs = new HashMap();

    public Team(String code, String name) {
        this.code = code;
        this.name = name;
        this.points = 0;
        this.matchPlayed = 0;
        this.goalScored = 0;
        this.conceded = 0;
        this.difference = 0;
    }

    public Team(String name, String code, int points, int matchPlayed, int goalScored, int conceded, int difference) {
        this.name = name;
        this.code = code;
        this.points = points;
        this.matchPlayed = matchPlayed;
        this.goalScored = goalScored;
        this.conceded = conceded;
        this.difference = difference;
    }

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

    public void addGoalScored(int Score) {
        Score += this.getGoalScored();
        this.setGoalScored(Score);
    }

    public void addConcededScore(int Score) {
        Score += this.getConceded();
        this.setConceded(Score);
    }

    public void upgradeStatTeam(int points, int goalScored, int conceded) {
        this.setPoints(this.getPoints() + points);
        this.setMatchPlayed(this.getMatchPlayed() + 1);
        this.addGoalScored(goalScored);
        this.addConcededScore(conceded);
        this.setDifference(this.getGoalScored() - this.getConceded());
    }

    void addMatch(Match MatchToAdd) {
        this.listMatchs.put(MatchToAdd.getHomeTeam().getCode() + "-" + MatchToAdd.getAwayTeam().getCode(), MatchToAdd);
    }
    
    public void print() {
        String nameDisplay = this.getName();
        String codeDisplay = this.getCode();
        int pointsDisplay = this.getPoints();
        int matchPlayedDisplay = this.getMatchPlayed();
        int goalScoredDisplay = this.getGoalScored();
        int concededDisplay = this.getConceded();
        int differenceDisplay = this.getDifference();

        System.out.println(codeDisplay + "   " + nameDisplay + "  " + pointsDisplay + "  " + matchPlayedDisplay
                + "   " + goalScoredDisplay + "  " + concededDisplay + "  " + differenceDisplay);
    }
//    public int compareTo(Team aTeam) {
//        return 0;
//    }
//
//    public void addResult(int home, int away) {
//    }
//
//    public void addHomeResult(int home, int away) {
//        if (home == away) {
//            points = points + 1;  // Draw
//        }
//        if (home > away) {
//            points = points + 3; // Home Win
//        }
//        if (home < away) {
//            points = points + 0; // Away Win
//        }
//        matchPlayed++;
//        this.goalScored = goalScored + home;
//        this.conceded = conceded + away;
//        this.difference = goalScored - conceded;
//    }
//
//    public void addAwayResult(int home, int away) {
//        if (home == away) {
//            points = points + 1;  // Draw
//        }
//        if (home > away) {
//            points = points + 0; // Home Win
//        }
//        if (home < away) {
//            points = points + 3; // Away Win
//        }
//        matchPlayed++;
//        goalScored = goalScored + home;
//        conceded = conceded + away;
//        difference = goalScored - conceded;
//    }
//
//    public void print() {
//        System.out.println(division + "\t" + code + "\t" + points + "\t" + matchPlayed + "\t" + goalScored + "\t" + conceded + "\t" + difference + "\t");
//    }
}
