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

        randomGenerator = new Random();
        
        List<Creature> creatures = new ArrayList<Creature>();
        for (int i=0; i<20; i++) {
            getRandomMotive();
        }
        creatures.add(new Creature("repens", "perficiendo", "bardicus", "lichens"));
        
        System.out.println();
        
        Scanner scan = new Scanner(System.in);
        
        
        
        scan.close();
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
    private static String getRandomIngest() {
        List<String> choices = new ArrayList<String>(Arrays.asList(
                                                                   "vaporem", //Gaseous consumption
                                                                   "carnem", //Carnivore
                                                                   "perficiendo" //Processing
                                                                   ));
        int index = randomGenerator.nextInt(choices.size());
        return choices.get(index);
    }
    
}
