import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class playerEntryTest {
    public static void main(String[] args) {
        anInput in = new anInput();
        System.out.println("1: Print All Players");
        System.out.println("2: Add Players");
        System.out.println("3: Create New Player File");
        System.out.println("4: Delete A Player");
        System.out.println("5: Display Stadiums");
        System.out.println("6: Display Players Where Name contains");
        System.out.println("7: Display Specific Subset of Players");
        int option = 7;
        option = in.getInt("Enter an Option");
        while (option < 0 || option > 7){
            option = in.getInt("Enter an Option:");
        }
        switch (option) {
            case 1: System.out.println("1: Print All Players");
                displayPlayer();
                break;
            case 2: System.out.println("2: Add Players");
                addPlayer(true);
                break;
            case 3: System.out.println("3: Create New Player File");
                addPlayer(false);
                break;
            case 4: System.out.println("4: Delete A Player");
                deletePlayer();
                break;
            case 5: System.out.println("5: Display Stadiums");
                searchStadiums();
                break;
            case 6: System.out.println("6: Display Players Where Name Contains");
                searchPlayer();
                break;
            case 7: System.out.println("7: Display Specific Subset of Players");
                displaySpecific();
                break;
            default:System.out.println("INVALID NUMBER");
                break;
        }
    }
        public static void displayPlayer(){
            String filename = "playertxt.txt";
            try {
                readFile File = new readFile(filename);
                List<String> listLines = File.openFile();
                for (int i = 1; i < listLines.size(); i++){
                    System.out.println(listLines.get(i));
                    String[] arrayList = (listLines.get(i)).split(",");
                    System.out.println("\n\nPlayer Name (ID): " + arrayList[0]);
                    System.out.println("Player Career Tries: " + arrayList[1]);
                    System.out.println("Player Team Name: " + arrayList[2]);
                    System.out.println("Player Team ID: " + arrayList[3]);
                    System.out.println("Stadium Name: " + arrayList[4]);
                    System.out.println("Stadium Street: " + arrayList[5]);
                    System.out.println("Stadium Town: " + arrayList[6]);
                    System.out.println("Stadium Postcode: " + arrayList[7]);
                }
            }
            catch (IOException e){
                System.out.println("Error");
            }
        }
        public static void addPlayer(boolean rewrite){
            String filename = "playertxt.txt";
            playerEntry player = new playerEntry();
            String playerData = player.createString( );
            System.out.println();
            if (rewrite == false){
                try {
                    writeFile data = new writeFile(filename, false);
                    data.write_file("");
                }
                catch (IOException e){
                    System.out.println("Error");
                }
                try {
                    writeFile data = new writeFile(filename, true);
                    data.write_file(playerData);
                }
                catch (IOException e){
                    System.out.println("Error");
                }
            }
            else {
                try {
                    writeFile data = new writeFile(filename, false);
                    data.write_file(playerData);
                }
                catch (IOException e){
                    System.out.println("Error");
                }
            }
                System.out.println("File Written");
        }
    
        public static void deletePlayer(){
            anInput in = new anInput();
            String filename = "playertxt.txt";
            try {
                readFile File = new readFile(filename);
                List<String> listLines = File.openFile();
                for (int i = 1; i < listLines.size(); i++){
                    String[] arrayList = (listLines.get(i)).split(",");
                    System.out.println("Player "+ i);
                    System.out.println("\n\nPlayer Name (ID): " + arrayList[0]);
                    System.out.println("Player Career Tries: " + arrayList[1]);
                    System.out.println("Player Team Name: " + arrayList[2]);
                    System.out.println("Player Team ID: " + arrayList[3]);
                    System.out.println("Stadium Name: " + arrayList[4]);
                    System.out.println("Stadium Street: " + arrayList[5]);
                    System.out.println("Stadium Town: " + arrayList[6]);
                    System.out.println("Stadium Postcode: " + arrayList[7]);
                }
                int index = in.getInt("Input a Player number to delete (Player Number)");
                listLines.remove(index);
                try {
                    writeFile data = new writeFile (filename, false);
                    data.write_file("");
                    for (int i = 1; i< listLines.size(); i++){
                        writeFile dataNew = new writeFile (filename, true);
                        dataNew.write_file(listLines.get(i));
                    }
                }
                catch (IOException e){
                    System.out.println("Error");
                }
            }
            catch (IOException e){
                System.out.println("Error");
            }
        }

        public static void searchPlayer(){
            anInput in = new anInput();
            String searchValue = in.getStr("Input a Search String");
            String filename = "playertxt.txt";
            List<Integer> indexFound = new ArrayList<>();
            try {
                readFile File = new readFile(filename);
                List<String> listLines = File.openFile();
                for (int i = 1; i < listLines.size(); i++){
                    String[] ArrayList = (listLines.get(i)).split(",");
                    String search = ArrayList[2];
                    boolean isFound = search.contains(searchValue);
                    if (isFound == true){
                        System.out.println("Found");
                        indexFound.add(i);
                    }
                }
                for (int i = 0; i < indexFound.size(); i++){
                    System.out.println(listLines.get(indexFound.get(i)));
                }
   
            }
            catch (IOException e){
                System.out.println("Error");
            }
        }
        public static void searchStadiums(){
            anInput in = new anInput();
            String searchValue = in.getStr("Input a Search Value");
            String filename = "playertxt.txt";
            List<String> listStadAddress = new ArrayList<>();
            List<Integer> indexFound = new ArrayList<>();
            try {
                readFile File = new readFile(filename);
                List<String> listLines = File.openFile();
                for (int i = 1; i < listLines.size(); i++){
                    String[] arrayList = (listLines.get(i)).split(",");
                    String search = (arrayList[4] + arrayList[5] + arrayList[6] + arrayList[7]);
                    search = search.toUpperCase();
                    boolean isFound = search.contains(searchValue.toUpperCase());
                    if (isFound == true){
                        System.out.println("Found");
                        indexFound.add(i);
                    }
                }
                for (int i = 0; i < indexFound.size(); i++){
                    System.out.println(listLines.get(indexFound.get(i)));
                }

            }
            catch (IOException e){
                System.out.println("Error");
            }
        }
        public static void displaySpecific(){
            anInput in = new anInput();
            Integer firstValue = in.getInt("Input Player From");
            Integer secondValue = in.getInt("Input Player to");
            String filename = "playertxt.txt";
            try{
                readFile File = new readFile(filename);
                List<String> listLines = File.openFile();
                if (firstValue >= 1 &&  secondValue <= listLines.size()){
                    for (Integer i = firstValue; i < secondValue + 1; i++){
                        String[] arrayList = (listLines.get(i)).split(",");
                        System.out.println("Player "+ i);
                        System.out.println("\n\nPlayer Name (ID): " + arrayList[0]);
                        System.out.println("Player Career Tries: " + arrayList[1]);
                        System.out.println("Player Team Name: " + arrayList[2]);
                        System.out.println("Player Team ID: " + arrayList[3]);
                        System.out.println("Stadium Name: " + arrayList[4]);
                        System.out.println("Stadium Street: " + arrayList[5]);
                        System.out.println("Stadium Town: " + arrayList[6]);
                        System.out.println("Stadium Postcode: " + arrayList[7]);
                    }

                }
                else{
                    System.out.println("Error Index is not valid");
                }
            }
            catch (IOException e){
                 System.out.println("Error");
            }
        }
}