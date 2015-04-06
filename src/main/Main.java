package main;

/*
 * Ben Klein, Mars Life Classification
 * 
 * See project on Github at https://github.com/robobenklein/MarsLifeClassiciation
 * 
 * See README.md for Project Description and other details.
 * 
 * Project Requirements and Specifications are in 'Project-Requirements.pdf'
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.Set;

import classification.Creature;

public class Main {
    
    // Create a random generator for creating our initial creatures we don't want to type in.
    private static Random randomGenerator;
    public static Scanner scan = new Scanner(System.in);
    
    // Main, boots up our interactive prompt.
    public static void main(String[] args) {
        
        // Set up our empty list of creatures.
        List<Creature> creatures = new ArrayList<Creature>();

        // Declare basic variables to prevent random undefined errors.
        boolean continuePrompt = true;
        randomGenerator = new Random();
        String userinput = "";
        String commands =
                "list: List all the Creatures in the Database.\n" + 
                "create/add: Add a creature to the list.\n" + 
                "random/populate: Adds a random set of creatures to the list.\n" + 
                "quit/exit: Exit the program.\n" + 
                "edit/customize: Change a creature's details.\n" + 
                "info/details: Show more information about a creature.\n" +
                "help/?: Shows this help menu.\n"
                ;
        
        // Now we start the interactive mode.
        System.out.println();
        while (continuePrompt == true) {
            // Until they tell us to quit or exit, we'll keep asking.
            System.out.print("What would you like to do? : ");
            userinput = scan.next().toLowerCase();
            switch (userinput) {
                case "list": // Let's print out all of the creatures we have in the database.
                    System.out.println();
                    System.out.println("--- All Creatures in Database: ---");
                    for (int i=0; i<creatures.size(); i++) {
                        System.out.println("Creature " + i + ": " + creatures.get(i));
                    }
                    System.out.println("--- No more creatures to show. ---\n");
                break;
                case "create":
                case "add":
                    // TODO
                    System.out.print("\nError: Not implemented yet.");
                break;
                case "random": // Add Random entries to populate the list of creatures.
                case "populate":
                    System.out.print("How many random entries? : ");
                    int num = scan.nextInt();
                    List<Creature> creatures2 = creatures;
                    makeEntries(creatures2, num);
                    while (hasDuplicate(creatures2)) {
                        creatures2 = creatures;
                        makeEntries(creatures2, num);
                    }
                    creatures = creatures2;
                    creatures2 = null;
                break;
                case "quit": // They've had enough, let's stop asking them for input.
                case "exit":
                    continuePrompt = false;
                break;
                case "edit": // Give them a chance to edit a creature.
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
                case "info": // What more do they want to know?
                case "details":
                    System.out.print("Which creature do you want to see details on? : ");
                    int index = scan.nextInt();
                    System.out.print("Creature Details:");
                    creatures.get(index).printAllInfo();
                break;
                case "help":
                case "?":
                    System.out.println("\n" + commands);
                break;
                default: // We don't know how to interpret what they typed.
                    System.out.println("\nThat wasn't an option, or was it?");
                break;
            } // End Switch Case selector
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
                                                                   "solan", //5
                                                                   "porten",
                                                                   "yurnam",
                                                                   "iman",
                                                                   "takmin",
                                                                   "weikem", //10
                                                                   "kadmein",
                                                                   "heinrich",
                                                                   "semtu",
                                                                   "iambu",
                                                                   "reahn", //15
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
                                                                   "numen", //5
                                                                   "kopenshmurf",
                                                                   "kenlung",
                                                                   "qeirl",
                                                                   "aural",
                                                                   "gentoo" //10
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
 // Returns a user-selected Motive Type.
    private static String selectMotive() {
        String choice = "";
        System.out.println("\n" +
                "Please Select a Motive (Movement type): \n" +
                "1: pendens: Floating. \n" +
                "2: repens: Crawls or walks on the surface. \n" +
                "3: perfodiens: Burrows, digs underground. \n" +
                "4: sedens: Does not move, like plants. \n"
                );
        choice = scan.next();
        switch (choice) {
            case "1":
                return "pedens";
            case "2":
                return "repens";
            case "3":
                return "perfodiens";
            case "4":
                return "sedens";
            default:
                System.out.println("That was not an option! Try again! Use the corresponding number!");
                return selectMotive();
        }
    } // End selectMotive()
    
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
    
    // Returns a user-selected Ingestion Type.
    private static String selectIngest() {
        String choice = "";
        System.out.println("\n" +
                "Please Select an Ingestion: \n" +
                "1: perficiendo: Processing, like plants, trees, or herbivores. \n" +
                "2: vaporem: Consumes gaseous substances, such as the \"floating whales\" \n" +
                "3: carnem: Carnivorous, eats other creatures. \n"
                );
        try {
            choice = scan.next();
        } catch (Exception e) {
            System.err.println("\n\tInvalid input. \n");
        }
        switch (choice) {
            case "1":
                return "perficiendo";
            case "2":
                return "vaporem";
            case "3":
                return "carnem";
            default:
                System.out.println("That was not an option! Try again!");
                return selectIngest();
        }
    } // End selectIngest()
    
    // Adds random creatures to the creature list.
    private static void makeEntries(List<Creature> list,int number) {
        for (int i=0; i<number; i++) {
            list.add(new Creature(getRandomMotive(), getRandomIngest(), getRandomGenus(), getRandomSpecies()));
        }
    }
    
    // Code to check if an ArrayList/List has duplicates.
    public static <T> boolean hasDuplicate(Iterable<T> all) {
        Set<T> set = new HashSet<T>();
        // Set#add returns false if the set does not change, which
        // indicates that a duplicate element has been added.
        for (T each: all) if (!set.add(each)) return true;
        return false;
    }
    
}
