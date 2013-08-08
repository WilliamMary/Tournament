package william.mary;

import java.util.*;
import java.io.*;

public class Classetest {

    static HashMap<String, League> listLeague = new HashMap();
    static HashMap<String, Team> listTeam = new HashMap();
    static HashMap<String, Match> listMatch = new HashMap();

    public static void importFile(String adress, String fileName) {

        try (BufferedReader br = new BufferedReader(new FileReader(adress + fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                switch (fileName) {
                    case "ObjectsLeague.txt":
                        League LeagueToAdd = loadFileLeague(line);
                        listLeague.put(LeagueToAdd.getName(), LeagueToAdd);
                        break;
                    case "ObjectsTeam.txt":
                        Team TeamToAdd = loadFileTeam(line);
                        listTeam.put(TeamToAdd.getCode(), TeamToAdd);
                        break;
                    case "ObjectsMatch.txt":
                        Match MatchToAdd = loadFileMatch(line);
                        listMatch.put(MatchToAdd.getHomeTeam() + "-" + MatchToAdd.getAwayTeam(), MatchToAdd);
                        break;
                }
            }
            br.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.toString());
        }

    }

    public static void exportObjects(String adress, String fileName) {
    }

    public static League loadFileLeague(String line) {

        String[] attributs = line.split(";");
        League newLeague = new League(attributs[0]);

        for (String codeTeam : attributs) {
            if (!codeTeam.equals(attributs[0])) {
                Team TeamToAdd = listTeam.get(codeTeam);
                newLeague.addTeam(TeamToAdd);
            }
        }

        return newLeague;
    }

    public static Team loadFileTeam(String line) {

        String[] attributs = line.split(";");
        Team newTeam = new Team(attributs[0], attributs[1], Integer.parseInt(attributs[2]), Integer.parseInt(attributs[3]), Integer.parseInt(attributs[4]), Integer.parseInt(attributs[5]), Integer.parseInt(attributs[6]));

        return newTeam;
    }

    public static Match loadFileMatch(String line) {

        String[] attributs = line.split(";");
        Team HomeTeam = listTeam.get(attributs[0]);
        Team AwayTeam = listTeam.get(attributs[1]);
        Match newMatch = new Match(HomeTeam, AwayTeam, Integer.parseInt(attributs[2]), Integer.parseInt(attributs[3]), Integer.parseInt(attributs[4]));

        return newMatch;
    }

    public static int Menu() {

        Scanner KeyBoard = new Scanner(System.in);

        System.out.println("--- Menu de navigation ---");
        System.out.println("1 - Voir les ligues");
        System.out.println("2 - Voir les équipes");
        System.out.println("3 - Voir les matchs");
        System.out.println("4 - Quitter");

        return KeyBoard.nextInt();
    }

    public static void main(String[] arg) {

        importFile("./Parametres/", "ObjectsTeam.txt");
        importFile("./Parametres/", "ObjectsMatch.txt");
        importFile("./Parametres/", "ObjectsLeague.txt");

        int ChoosenMenu;
        do {

            ChoosenMenu = Menu();

            switch (ChoosenMenu) {
                
                case 1:
                    for (Iterator<String> it = listLeague.keySet().iterator(); it.hasNext();) {
                        String KeyLeague = it.next();
                        League leagueToDisplay = listLeague.get(KeyLeague);
                        leagueToDisplay.print();
                        
                    }
                    break;
                    
                case 2:
                    break;
                    
                case 3:
                    break;
            }

        } while (ChoosenMenu != 4);


//        /* Créé deux HashMap en indiquant le type des clefs et des valeurs. */
//        HashMap<String, String> listTeamToCreate = new HashMap();
//        HashMap<String, Team> listTeam = new HashMap();
//
//        /* On ajoute les clefs et les noms des équipes à créer. */
//        listTeamToCreate.put("ARS", "Arsenal");
//        listTeamToCreate.put("MAN", "Manchester");
//        listTeamToCreate.put("LVP", "Liverpool");
//        listTeamToCreate.put("CHE", "Chelsea");
//
//
//        /* Parcours listTeamToCreate pour créer les objets Team avec les valeurs qu'elle contient. */
//        for (Iterator<String> iterator = listTeamToCreate.keySet().iterator(); iterator.hasNext();) {
//            String CurrentKey = iterator.next(); // Récupère la clé suivante.
//            Team NewTeam = new Team(CurrentKey.toString(), listTeamToCreate.get(CurrentKey)); // Créé un objet Team à partir du constructeur de la classe.
//            listTeam.put(CurrentKey.toString(), NewTeam); // Ajoute l'objet créer à la HashMap listTeam.
//
//        }
//
//        /* Créé l'objet Ligue 1 qui contient la HashMap listTeam. */
//        League myLeague = new League("Ligue 1");
//
//        /* Parcours listTeam pour récupérer les objets Team qu'elle contient. */
//        for (Iterator<String> itHome = listTeam.keySet().iterator(); itHome.hasNext();) {
//            String KeyHome = itHome.next(); // Récupère la clé suivante.
//
//            Team currentTeamHome = listTeam.get(KeyHome); // Récupère l'objet Team associé à la clé.
//
//            for (Iterator<String> itAway = listTeam.keySet().iterator(); itAway.hasNext();) {
//                String KeyAway = itAway.next(); // Récupère la clé suivante.
//                Team currentTeamAway = listTeam.get(KeyHome); // Récupère l'objet Team associé à la clé.
//
//                if (!KeyHome.equals(KeyAway)) {
//                    Match newMatch = new Match(currentTeamHome, currentTeamAway);
//
//                    int HomeScore = (int) (Math.random() * 10);
//                    int AwayScore = (int) (Math.random() * 10);
//
//                    newMatch.setHomeScore(HomeScore);
//                    newMatch.setAwayScore(AwayScore);
//
//                    int HomePoints;
//                    int AwayPoints;
//                    if (HomeScore < AwayScore) {
//                        HomePoints = 0;
//                        AwayPoints = 3;
//                    } else if (HomeScore > AwayScore) {
//                        HomePoints = 3;
//                        AwayPoints = 0;
//                    } else {
//                        HomePoints = 1;
//                        AwayPoints = 1;
//                    }
//
//                    currentTeamHome.upgradeStatTeam(HomePoints, HomeScore, AwayScore);
//
//                    currentTeamAway.upgradeStatTeam(AwayPoints, AwayScore, HomeScore);
//                }
//
//            }
//        }
//
//        myLeague.setupDiv1();
//        myLeague.setupDiv2();
//        for (String r : results) {
//            myLeague.addResult(r);
//        }
//        myLeague.print();
    }
}
