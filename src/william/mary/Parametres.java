package william.mary;

import java.io.*;
import java.util.Iterator;
import static william.mary.Main.*;
import static william.mary.Parametres.LoadFileLeague;
import static william.mary.Parametres.LoadFileMatch;
import static william.mary.Parametres.LoadFileTeam;

public class Parametres {

    /* Méthode permettant de lire et traiter un fichier de configuration pour recréer les instances d'objets de la dernière exécution et de les ajoutés aux HashMaps associées à leur classe. */
    public static void ImportFile(String address, String fileName) {

        try (BufferedReader br = new BufferedReader(new FileReader(address + fileName))) { // Essai d'ouvrir le fichier et de créer un pointeur.
            String line;
            while ((line = br.readLine()) != null) { // Récupère la ligne suivante si possible (fin de fichier).
                switch (fileName) {
                    case "ObjectsLeague.txt":
                        League leagueToAdd = LoadFileLeague(line);
                        listLeague.put(leagueToAdd.getName(), leagueToAdd);
                        break;
                    case "ObjectsTeam.txt":
                        Team teamToAdd = LoadFileTeam(line);
                        listTeam.put(teamToAdd.getCode(), teamToAdd);
                        break;
                    case "ObjectsMatch.txt":
                        Match matchToAdd = LoadFileMatch(line);
                        listMatch.put(matchToAdd.getHomeTeam() + "-" + matchToAdd.getAwayTeam(), matchToAdd);
                        break;
                }
            }
            br.close(); // Ferme le fichier.
        } catch (IOException | NumberFormatException e) { // En cas d'échec au sein de l'éxécution de la clause try.
            System.out.println(e.toString());
        }

    }

    public static void ExportInFile(String address, String fileName) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(address + fileName))) { // Essai d'ouvrir le fichier et de créer un pointeur.

            switch (fileName) {
                case "ObjectsLeague.txt":
                    for (Iterator<String> itLeague = listLeague.keySet().iterator(); itLeague.hasNext();) {
                        String keyListLeague = itLeague.next();
                        League currentLeague = listLeague.get(keyListLeague);
                        String lineToWrite = currentLeague.getName();
                        for (Iterator<String> itListTeams = currentLeague.getListTeams().keySet().iterator(); itListTeams.hasNext();) {
                            String keyListTeams = itListTeams.next();
                            lineToWrite += ";" + keyListTeams;
                        }
                        lineToWrite += "\r\n";
                        bw.write(lineToWrite);
                    }
                    bw.flush();
                    bw.close();
                    break;
                case "ObjectsTeam.txt":
                    for (Iterator<String> itListTeam = listTeam.keySet().iterator(); itListTeam.hasNext();) {
                        String keyListTeam = itListTeam.next();
                        Team currentTeam = listTeam.get(keyListTeam);
                        String lineToWrite = currentTeam.getName() + ";" + currentTeam.getCode() + ";"
                                + currentTeam.getPoints() + ";" + currentTeam.getMatchPlayed() + ";"
                                + currentTeam.getGoalScored() + ";" + currentTeam.getConceded() + ";"
                                + currentTeam.getDifference() + "\r\n";
                        bw.write(lineToWrite);
                    }
                    bw.flush();
                    bw.close();
                    break;
                case "ObjectsMatch.txt":
                    for (Iterator<String> itListMatch = listMatch.keySet().iterator(); itListMatch.hasNext();) {
                        String keyListMatch = itListMatch.next();
                        Match currentMatch = listMatch.get(keyListMatch);
                        String lineToWrite = currentMatch.getHomeTeam() + ";" + currentMatch.getAwayTeam() + ";"
                                + currentMatch.getHomeScore() + ";" + currentMatch.getAwayScore() + ";"
                                + currentMatch.getDay() + "\r\n";
                        bw.write(lineToWrite);
                    }
                    bw.flush();
                    bw.close();
                    break;
            }
        } catch (IOException | NumberFormatException e) { // En cas d'échec au sein de l'éxécution de la clause try.
            System.out.println(e.toString());
        }

    }

    /* Méthode permettant le traitement d'une ligne du fichier de configuration ObjectsLeague. */
    public static League LoadFileLeague(String line) {

        String[] attributs = line.split(";");
        League newLeague = new League(attributs[0]);

        for (String codeTeam : attributs) {
            if (!codeTeam.equals(attributs[0])) {
                Team teamToAdd = listTeam.get(codeTeam);
                newLeague.addTeam(teamToAdd);
            }
        }

        return newLeague;
    }

    /* Méthode permettant le traitement d'une ligne du fichier de configuration ObjectsTeam. */
    public static Team LoadFileTeam(String line) {

        String[] attributs = line.split(";");
        Team newTeam = new Team(attributs[0], attributs[1], Integer.parseInt(attributs[2]), Integer.parseInt(attributs[3]), Integer.parseInt(attributs[4]), Integer.parseInt(attributs[5]), Integer.parseInt(attributs[6]));

        return newTeam;
    }

    /* Méthode permettant le traitement d'une ligne du fichier de configuration ObjectsMatch. */
    public static Match LoadFileMatch(String line) {

        String[] attributs = line.split(";");
        Team homeTeam = listTeam.get(attributs[0]);
        Team awayTeam = listTeam.get(attributs[1]);
        Match newMatch = new Match(homeTeam, awayTeam, Integer.parseInt(attributs[2]), Integer.parseInt(attributs[3]), Integer.parseInt(attributs[4]));

        return newMatch;
    }
}
