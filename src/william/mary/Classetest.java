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
                        listMatch.put(MatchToAdd.getHomeTeam().getCode() + "-" + MatchToAdd.getAwayTeam().getCode(), MatchToAdd);
                        Team HomeTeam = listTeam.get(MatchToAdd.getHomeTeam().getCode());
                        HomeTeam.addMatch(MatchToAdd);
                        Team AwayTeam = listTeam.get(MatchToAdd.getAwayTeam().getCode());
                        AwayTeam.addMatch(MatchToAdd);
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
        System.out.println("4 - Ajouter une ligue");
        System.out.println("5 - Quitter");

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
                    for (Iterator<String> it = listTeam.keySet().iterator(); it.hasNext();) {
                        String KeyTeam = it.next();
                        Team teamToDisplay = listTeam.get(KeyTeam);
                        teamToDisplay.print();
                    }
                    break;

                case 3:
                    for (Iterator<String> it = listMatch.keySet().iterator(); it.hasNext();) {
                        String KeyMatch = it.next();
                        Match matchToDisplay = listMatch.get(KeyMatch);
                        matchToDisplay.print();

                    }
                    break;

                case 4:
                    Scanner Keyboard = new Scanner(System.in);
                    System.out.println("Saisissez le nom de la league.");
                    String LeagueName = Keyboard.nextLine();
                    League newLeague = new League(LeagueName);
                    listLeague.put(LeagueName, newLeague);

                    System.out.println("Souhaitez vous ajouter des équipes ?");
                    String answer = Keyboard.next();
                    switch (answer) {
                        case "yes":
                        case "oui":
                        case "OUI":
                        case "O":
                            for (Iterator<String> it = listTeam.keySet().iterator(); it.hasNext();) {
                                String codeTeam = it.next();
                                Team oneTeam = listTeam.get(codeTeam);
                                oneTeam.print();   
                            }
                            System.out.println("Entrer le code de l'équipe à ajouter.");
                            String codeTeam = Keyboard.next();
                            newLeague.addTeam(listTeam.get(codeTeam));
                            System.out.println("Equipe ajoutée");
                            break;
                        default:
                            System.out.println("Réponse éronnée.");
                    }
                    break;
                    
                case 5:
            
                    break;
            }

        } while (ChoosenMenu != 6);
//
//
//        /* Parcours listTeamToCreate pour créer les objets Team avec les valeurs qu'elle contient. */
//        for (Iterator<String> iterator = listTeamToCreate.keySet().iterator(); iterator.hasNext();) {
//            String CurrentKey = iterator.next(); 
//            Team NewTeam = new Team(CurrentKey.toString(), listTeamToCreate.get(CurrentKey)); 
//            listTeam.put(CurrentKey.toString(), NewTeam); 
//
//        }
//
//        /* Créé l'objet Ligue 1 qui contient la HashMap listTeam. */
//        League myLeague = new League("Ligue 1");
//
//        /* Parcours listTeam pour récupérer les objets Team qu'elle contient. */
//        for (Iterator<String> itHome = listTeam.keySet().iterator(); itHome.hasNext();) {
//            String KeyHome = itHome.next(); 
//
//            Team currentTeamHome = listTeam.get(KeyHome); 
//
//            for (Iterator<String> itAway = listTeam.keySet().iterator(); itAway.hasNext();) {
//                String KeyAway = itAway.next(); 
//                Team currentTeamAway = listTeam.get(KeyHome); 
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
