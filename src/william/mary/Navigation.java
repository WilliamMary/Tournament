package william.mary;

import java.util.*;
import static william.mary.Main.*;
import static william.mary.Navigation.keyboard;

public class Navigation {

    static Scanner keyboard = new Scanner(System.in);
    static Boolean nameValid;
    /* Méthode permettant d'afficher le menu de navigation et d'appeler les méthodes souhaitées par saisie clavier. */

    public static int Menu() {

        System.out.println();
        System.out.println("--- Menu de navigation ---");
        System.out.println("    1 - Consultation");
        System.out.println("    2 - Ajout");
        System.out.println("    3 - Modification");
        System.out.println("    4 - Suppression");
        System.out.println("    5 - Quitter");

        int choosenMenu = keyboard.nextInt();
        keyboard.nextLine();
        switch (choosenMenu) {

            case 1:
                do {
                    System.out.println();
                    System.out.println("--- Consultation ---");
                    System.out.println("1 - Voir les ligues");
                    System.out.println("2 - Voir les équipes");
                    System.out.println("3 - Voir les matchs");
                    System.out.println("4 - Précédent");

                } while (Consultation(keyboard.nextInt()) != 4);
                break;

            case 2:
                do {
                    System.out.println();
                    System.out.println("--- Ajout ---");
                    System.out.println("1 - Ajouter une ligue");
                    System.out.println("2 - Ajouter une équipe");
                    System.out.println("3 - Ajouter un match");
                    System.out.println("4 - Précédent");

                } while (Ajout(keyboard.nextInt()) != 4);
                break;

            case 3:
                do {
                    System.out.println();
                    System.out.println("--- Modification ---");
                    System.out.println("1 - Modifier une ligue");
                    System.out.println("2 - Modifier une équipe");
                    System.out.println("3 - Modifier un match");
                    System.out.println("4 - Précédent");

                } while (Modification(keyboard.nextInt()) != 4);
                break;

            case 4:
                do {
                    System.out.println();
                    System.out.println("--- Suppression ---");
                    System.out.println("1 - Supprimer une ligue");
                    System.out.println("2 - Supprimer une équipe");
                    System.out.println("3 - Supprimer un match");
                    System.out.println("4 - Précédent");

                } while (Suppression(keyboard.nextInt()) != 4);
                break;
        }

        return choosenMenu;
    }

    /* Méthode permettant l'affichage de l'ensemble des objets d'une classe demandée. */
    private static int Consultation(int choosenMenu) {
        switch (choosenMenu) {

            case 1:
                for (Iterator<String> it = listLeague.keySet().iterator(); it.hasNext();) {
                    String keyListLeague = it.next();
                    League leagueToDisplay = listLeague.get(keyListLeague);
                    leagueToDisplay.print();
                    System.out.println();
                }
                break;

            case 2:
                System.out.println(" CODE | Equipe | Points | Match joués | Marqué | Concédé | Différence");
                for (Iterator<String> it = listTeam.keySet().iterator(); it.hasNext();) {
                    String keyListTeam = it.next();
                    Team teamToDisplay = listTeam.get(keyListTeam);
                    teamToDisplay.print();
                }
                System.out.println();
                break;

            case 3:
                for (Iterator<String> it = listMatch.keySet().iterator(); it.hasNext();) {
                    String KeyLeague = it.next();
                    Match matchToDisplay = listMatch.get(KeyLeague);
                    matchToDisplay.print();
                }
                System.out.println();
                break;
        }
        return choosenMenu;
    }

    /* Méthode permettant d'ajouter un objet d'une classe demandée. */
    private static int Ajout(int choosenMenu) {
        switch (choosenMenu) {

            case 1:

                Boolean quit;
                String leagueName;
                String addAgain;

                System.out.println("Veuillez saisir le nom de la nouvelle ligue.");

                do {
                    keyboard.nextLine();
                    leagueName = keyboard.nextLine();
                    if (listLeague.containsKey(leagueName)) {
                        System.out.println("Erreur : Ce nom de ligue existe déjà, veuillez saisir un autre nom de ligue.");
                        nameValid = false;
                    } else {
                        nameValid = true;
                    }
                } while (!nameValid);

                League newLeague = new League(leagueName);
                listLeague.put(leagueName, newLeague);
                System.out.println("La ligue \"" + newLeague.getName() + "\" a été ajoutée.");
                System.out.println("Souhaitez vous ajouter des équipes à cette ligue ? (O/N)");
                do {
                    switch (keyboard.nextLine()) {

                        case "o":
                        case "O":
                        case "oui":
                        case "Oui":
                        case "OUI":
                        case "y":
                        case "Y":
                        case "yes":
                        case "Yes":
                        case "YES":
                            do {
                                for (Iterator<String> it = listTeam.keySet().iterator(); it.hasNext();) {
                                    String keyListTeam = it.next();
                                    Team.teamFree(true, keyListTeam);
                                }

                                System.out.println("Entrez le code d'une des équipes disponibles ou entrez un nouveau code d'équipe.");
                                Boolean codeValid;
                                do {
                                    String teamCode = keyboard.nextLine();
                                    if (teamCode.length() != 3) {
                                        System.out.println("Erreur : Code invalide, veuillez saisir un code d'équipe valide, celui ci doit contenir 3 lettres.");
                                        codeValid = false;
                                    } else {
                                        if (listTeam.containsKey(teamCode) && Team.teamFree(false, teamCode)) {
                                            newLeague.addTeam(listTeam.get(teamCode));
                                        } else {
                                            System.out.println("Entrez le nom de la nouvelle équipe.");
                                            String teamName = keyboard.nextLine();
                                            Team newTeam = new Team(teamCode, teamName);
                                            listTeam.put(teamCode, newTeam);
                                            newLeague.addTeam(newTeam);

                                        }
                                        System.out.println("L'équipe " + listTeam.get(teamCode).getName() + " a été ajoutée à la ligue \"" + newLeague.getName() + "\".");
                                        codeValid = true;
                                    }
                                } while (!codeValid);
                                System.out.println("Voulez vous ajoutez une nouvelle équipe ? (O/N)");
                                addAgain = keyboard.nextLine();
                            } while ("o".equals(addAgain) || "O".equals(addAgain) || "oui".equals(addAgain) || "Oui".equals(addAgain)
                                    || "OUI".equals(addAgain) || "y".equals(addAgain) || "Y".equals(addAgain) || "yes".equals(addAgain)
                                    || "Yes".equals(addAgain) || "YES".equals(addAgain));

                        case "n":
                        case "N":
                        case "non":
                        case "Non":
                        case "NON":
                        case "no":
                        case "No":
                        case "NO":
                            quit = true;
                            break;

                        default:
                            System.out.println("Aucune action associé à votre réponse, veuillez recommencer. (O/N)");
                            quit = false;
                            break;
                    }
                } while (!quit);
                break;

            case 2:

                break;

            case 3:

                break;
        }
        return choosenMenu;
    }

    /* Méthode permettant de modifier un objet d'une classe demandée. */
    private static int Modification(int choosenMenu) {
        switch (choosenMenu) {

            case 1:
                String oldLeagueName;

                for (Iterator<String> it = listLeague.keySet().iterator(); it.hasNext();) {
                    String keyListLeague = it.next();
                    System.out.println(keyListLeague);
                }
                System.out.println("Entrez le nom de la ligue à modifier.");
                keyboard.nextLine();
                do {
                    oldLeagueName = keyboard.nextLine();
                    if (listLeague.containsKey(oldLeagueName)) {
                        break;
                    } else {
                        System.out.println("Erreur : Ce nom de ligue n'existe pas, veuillez saisir un nom de ligue valide.");
                    }
                } while (true);

                League currentLeague = listLeague.get(oldLeagueName);
                System.out.println("Veuillez saisir les nouvelles valeurs (pour ne pas modifier une valeur laisser le champ vide.");
                System.out.print("Nom de ligue : ");
                String newLeagueName = keyboard.nextLine();
                listLeague.remove(oldLeagueName);
                currentLeague.setName(newLeagueName);
                listLeague.put(newLeagueName, currentLeague);

//                System.out.println("1 - Modifier une ligue");
//                System.out.println("2 - Modifier une équipe");
//                System.out.println("3 - Modifier un match");
//                System.out.println("4 - Précédent");
                break;

            case 2:

                break;

            case 3:

                break;
        }
        return choosenMenu;
    }

    /* Méthode permettant de supprimer un objet d'une classe demandée. */
    private static int Suppression(int choosenMenu) {
        switch (choosenMenu) {

            case 1:

                break;

            case 2:

                break;

            case 3:

                break;
        }
        return choosenMenu;
    }
}
