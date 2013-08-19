package william.mary;

import java.util.*;

public class Main {/* classe test renommée et simplifiée

    /* Déclaration de 3 HashMap contenant tout les objets existants de leur classe respective */
    static HashMap<String, League> listLeague = new HashMap();
    static HashMap<String, Team> listTeam = new HashMap();
    static HashMap<String, Match> listMatch = new HashMap();

    public static void main(String[] arg) {

        /* Importe les 3 fichiers de configurations */
        Parametres.ImportFile("./Parametres/", "ObjectsTeam.txt");
        Parametres.ImportFile("./Parametres/", "ObjectsMatch.txt");
        Parametres.ImportFile("./Parametres/", "ObjectsLeague.txt");

        /* Effectue une boucle sur le menu principal. */
        do {
        } while (Navigation.Menu() != 5);

        Parametres.ExportInFile("./Parametres/", "ObjectsTeam.txt");
        Parametres.ExportInFile("./Parametres/", "ObjectsMatch.txt");
        Parametres.ExportInFile("./Parametres/", "ObjectsLeague.txt");
    }
}
