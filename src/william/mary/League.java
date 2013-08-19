package william.mary;

import java.util.*;

public class League implements Comparator<String> { // On implémente comparator pour la méthode print().

    /* Attributs */
    private String name;
    private HashMap<String, Team> listTeams = new HashMap<>();

    /* Constructeur */
    public League(String name) {
        this.name = name;
    }

    /* Accesseurs(get) et mutateurs(set) */
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

    /* Méthode permettant d'ajouter un objet Team à la liste de l'objet League. */
    void addTeam(Team TeamToAdd) {
        this.listTeams.put(TeamToAdd.getCode(), TeamToAdd);
    }

    /* Méthode permettant de récuperer un objet Team parmis la liste de l'objet League. */
    Team getOneTeam(String Key) {
        Team team = this.listTeams.get(Key);
        return team;
    }

    /* Méthode permettant d'afficher le classement des objets Team de l'objet League. */
    void print() {
        ArrayList<String> keyTeamToSort = new ArrayList(listTeams.keySet()); // Créé un ArrayList contenant les clés de l'attribut HashMap listTeams de l'objet League.
        Collections.sort(keyTeamToSort, Collections.reverseOrder(this)); // Trie par ordre décroissant l'ArrayList keyTeamToSort à l'aide de la méthode polymorphée compare() (note : la métode sort() de la classe Collections utilise la méthode compare()).
        int place = 1; // Variable utilisé comme compteur pour le parcours de l'ArrayList et afficher comme place du classement.
        
        /* Affichage d'informations. */
        System.out.println("  --- " + this.getName() + " ---");
        System.out.println("  Place  |  Equipe  | Points ");
        
        /* Parcours l'ArrayList triée keyTeamToSort et recherche les objets Team à partir des codes qu'elle contient pour afficher le classement. */
        for (String codeTeamSort : keyTeamToSort) {
            Team teamToDisplay = listTeams.get(codeTeamSort);
            System.out.println("    " + place + "    |  " + teamToDisplay.getName() + "  |  " + teamToDisplay.getPoints());
            place++;
        }
    }

    /* Méthode polymorphé utilisée par la méthode sort() dans la méthode print() pour classer les objets Team de l'objet League. */
    @Override
    public int compare(String code1, String code2) {

        Team teamOne = listTeams.get(code1);
        Team teamTwo = listTeams.get(code2);
        int result = 0;

        if ((teamOne.getPoints() - teamTwo.getPoints()) < 0) {
            result = -1;
        } else if ((teamOne.getPoints() - teamTwo.getPoints()) > 0) {
            result = 1;
        } else if ((teamOne.getPoints() - teamTwo.getPoints()) == 0) {
            if ((teamOne.getDifference() - teamTwo.getDifference()) < 0) {
                result = -1;
            } else if ((teamOne.getDifference() - teamTwo.getDifference()) < 0) {
                result = 1;
            }
        }
        return result;
    }
}
