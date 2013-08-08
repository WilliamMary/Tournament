package william.mary;

public class Match {

    private Team HomeTeam; // Equipe à domicile.
    private Team AwayTeam; // Equipe visiteur.
    private int HomeScore; // Score de l'équipe à domicile.
    private int AwayScore; // Score de l'équipe visiteur.
    private int Day; // Journée durant laquelle a lieu le match.

    public Match(Team HomeTeam, Team AwayTeam) {
        this.HomeTeam = HomeTeam;
        this.AwayTeam = AwayTeam;
        this.HomeScore = 0;
        this.AwayScore = 0;
        this.Day = 0;
    }

    public Match(Team HomeTeam, Team AwayTeam, int HomeScore, int AwayScore, int Day) {
        this.HomeTeam = HomeTeam;
        this.AwayTeam = AwayTeam;
        this.HomeScore = HomeScore;
        this.AwayScore = AwayScore;
        this.Day = Day;
    }

    public Team getHomeTeam() {
        return HomeTeam;
    }

    public void setHomeTeam(Team HomeTeam) {
        this.HomeTeam = HomeTeam;
    }

    public Team getAwayTeam() {
        return AwayTeam;
    }

    public void setAwayTeam(Team AwayTeam) {
        this.AwayTeam = AwayTeam;
    }

    public int getHomeScore() {
        return HomeScore;
    }

    public void setHomeScore(int HomeScore) {
        this.HomeScore = HomeScore;
    }

    public int getAwayScore() {
        return AwayScore;
    }

    public void setAwayScore(int AwayScore) {
        this.AwayScore = AwayScore;
    }
    
    public int getDay() {
        return Day;
    }

    public void setDay(int Day) {
        this.Day = Day;
    }
}
