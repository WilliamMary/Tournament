package william.mary;

public class Match {

    /* Attributs */
    private Team HomeTeam;
    private Team AwayTeam;
    private int HomeScore;
    private int AwayScore;
    private int Day;

    /* Constructeur */
    public Match(Team HomeTeam, Team AwayTeam) {
        this.HomeTeam = HomeTeam;
        this.AwayTeam = AwayTeam;
        this.HomeScore = 0;
        this.AwayScore = 0;
        this.Day = 0;
    }

    /* Constructeur */
    public Match(Team HomeTeam, Team AwayTeam, int HomeScore, int AwayScore, int Day) {
        this.HomeTeam = HomeTeam;
        this.AwayTeam = AwayTeam;
        this.HomeScore = HomeScore;
        this.AwayScore = AwayScore;
        this.Day = Day;
    }

    /* Accesseurs(get) et mutateurs(set) */
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

    /* Méthode permettant d'afficher l'ensemble des informations d'un objet Match. */
    void print() {
        System.out.println(this.getHomeTeam().getName() + " " + this.getHomeScore()
                + " - " + this.getAwayScore() + " " + this.getAwayTeam().getName());
    }
}
