package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import classification.Creature;

public class Main {
    
    private static Random randomGenerator;
    
    public static void main(String[] args) {
        
        List<Creature> creatures = new ArrayList<Creature>();

        boolean continuePrompt = true;
        randomGenerator = new Random();
        String userinput = "";
        
        // Now we start the interactive mode.
        System.out.println();
        
        Scanner scan = new Scanner(System.in);
        while (continuePrompt == true) {
            System.out.print("What would you like to do? : ");
            userinput = scan.next().toLowerCase();
            switch (userinput) {
                case "list":
                    System.out.println();
                    System.out.println("--- All Creatures in Database: ---");
                    for (int i=0; i<creatures.size(); i++) {
                        System.out.println("Creature " + i + ": " + creatures.get(i));
                    }
                    System.out.println("--- No more creatures to show. ---\n");
                break;
                case "create":
                case "add":
                    System.out.print("\n ");
                break;
                case "random": // Add Random entries to populate the list of creatures.
                case "populate":
                    System.out.print("How many random entries? : ");
                    int num = scan.nextInt();
                    makeEntries(creatures, num);
                break;
                case "quit":
                case "exit":
                    continuePrompt = false;
                break;
                case "edit":
                case "customize":
                    System.out.print("Which creature would you like to edit? : ");
                    int id = scan.nextInt();
                    System.out.print("Possible values: | motive | ingest | genus | species | more, extra, info, detail, other |\n" +
                                     "What about it would you like to edit? : ");
                    userinput = scan.next().toLowerCase();
                    switch (userinput) {
                        case "motive":
                            System.out.print("What should the motive be set to? : ");
                            creatures.get(id).setMotive(scan.next());
                        break;
                        case "ingest":
                        case "ingestion":
                            System.out.print("What should the ingestion be set to? : ");
                            creatures.get(id).setIngest(scan.next());
                        break;
                        case "genus":
                            System.out.print("What should the genus be set to? : ");
                            creatures.get(id).setGenus(scan.next());
                        break;
                        case "species":
                            System.out.print("What should the species be set to? : ");
                            creatures.get(id).setSpecies(scan.next());
                        break;
                        case "more":
                        case "other":
                        case "info":
                        case "detail":
                        case "extra":
                        case "information":
                            System.out.print("Which value would you like to edit? : ");
                            String key = scan.next();
                            System.out.print("What should the value be? : ");
                            creatures.get(id).addInfo(key, "" + scan.nextLine());
                        break;
                    }
                break;
                case "info":
                case "details":
                    System.out.print("Which creature do you want to see details on? : ");
                    int index = scan.nextInt();
                    System.out.print("Creature Details:");
                    creatures.get(index).printAllInfo();
                break;
                default:
                    System.out.println("\nThat wasn't an option, or was it?");
                break;
            }
        } // That ends our interactive loop, close it all up.
        scan.close();
    }

    // Returns a random Species
    private static String getRandomSpecies() {
        List<String> choices = new ArrayList<String>(Arrays.asList( // Indenting for readability.
                                                                   "lichens",
                                                                   "harsend",
                                                                   "keblet",
                                                                   "unfa",
                                                                   "solan",
                                                                   "porten",
                                                                   "yurnam",
                                                                   "iman",
                                                                   "takmin",
                                                                   "weikem",
                                                                   "kadmein",
                                                                   "heinrich",
                                                                   "semtu",
                                                                   "iambu",
                                                                   "reahn",
                                                                   "elije",
                                                                   "spoken",
                                                                   "jentu"
                                                                   ));
        int index = randomGenerator.nextInt(choices.size());
        return choices.get(index);
    }

    // Returns a random Genus
    private static String getRandomGenus() {
        List<String> choices = new ArrayList<String>(Arrays.asList( // Just making up some example names.
                                                                   "bardicus",
                                                                   "poten",
                                                                   "grenlen",
                                                                   "sprectus",
                                                                   "numen",
                                                                   "kopenshmurf",
                                                                   "kenlung",
                                                                   "qeirl",
                                                                   "aural"
                                                                   ));
        int index = randomGenerator.nextInt(choices.size());
        return choices.get(index);
    }

    // Returns a random Motive
    private static String getRandomMotive() {
        List<String> choices = new ArrayList<String>(Arrays.asList(
                                                                   "pendens", //Floating
                                                                   "repens", //Crawling
                                                                   "perfodiens", //Burrowing
                                                                   "sedens" //Sedentary (not moving)
                                                                   ));
        int index = randomGenerator.nextInt(choices.size());
        return choices.get(index);
    }
    
    // Returns a random Ingestion
    private static String getRandomIngest() {
        List<String> choices = new ArrayList<String>(Arrays.asList(
                                                                   "vaporem", //Gaseous consumption
                                                                   "carnem", //Carnivore
                                                                   "perficiendo" //Processing
                                                                   ));
        int index = randomGenerator.nextInt(choices.size());
        return choices.get(index);
    }
    
    // Adds random creatures to the creature list.
    private static void makeEntries(List<Creature> list,int number) {
        for (int i=0; i<number; i++) {
            list.add(new Creature(getRandomMotive(), getRandomIngest(), getRandomGenus(), getRandomSpecies()));
        }
    }
    
}
