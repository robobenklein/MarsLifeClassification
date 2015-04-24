package classification;

import java.util.HashMap;
import java.util.Map;

import main.Population;

public class Creature extends Ingesting {
    
    String genus;
    String species;
    Map<String, String> information = new HashMap<String, String>();
    
    // Constructor without extra info
    public Creature(String motive, String ingestion, String genus, String species) {
        super(motive, ingestion);
        
        this.genus = genus;
        this.species = species;
    }
    // Constructor with optional extra info
    public Creature(String motive, String ingestion, String genus, String species, Map<String, String> information) {
        // TODO Auto-generated constructor stub
        super(motive, ingestion);
        
        this.genus = genus;
        this.species = species;
        this.information = information;
    }
    
    // Code to change Genus / Species / Ingestion / Motive
    public void setGenus(String genus) {
        this.genus = genus;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public void setIngest(String ingest) {
        this.ingestion = ingest;
    }
    public void setMotive(String motive) {
        this.motive = motive;
    }
    
    // Adds extra information to the Creature's information dict.
    public void addInfo(String key, String value) {
        information.put(key, value);
    }
    public void addInfo(String key, double d) {
        information.put(key, String.valueOf(d));
    }
    // Returns information from dict if key is present
    public String getInfo(String key) {
        try {
            return information.get(key);
        } catch (Exception e) {
            return "Error";
        }
    }
    
    // The proper name for this species.
    public String toString() {
        return super.toString() + " " + genus + " " + species;
    }
    
    // Print everything we have on the creature.
    public void printAllInfo() {
        System.out.println();
        System.out.println("Creature " + this);
        System.out.println("Custom information: " + information);
        System.out.println("Population from 0 to 1, extinct to Maximum Sustainable Population");
        System.out.println("Population now:   " + Population.getPopulationAtTime(this, 0));
        System.out.println("Population 5yrs:  " + Population.getPopulationAtTime(this, 5));
        System.out.println("Population 30yrs: " + Population.getPopulationAtTime(this, 30));
        System.out.println("Absolute Population per sqKm: " + Population.getPopulationPerSqKm(this, 1));
        System.out.println("Absolute Population per sqKm in 30yrs: " + Population.getPopulationPerSqKm(this, 1, 30));
    }
    
    // Compare the two based on what type of comparison they want.
    public int compareTo(Creature other, String comparetype) {
        if (comparetype.matches("first*|base")) {
            String compare1 = this.motive + this.ingestion;
            String compare2 = other.motive + other.ingestion;
            return compare1.compareTo(compare2);
        }
        else return this.toString().compareTo(other.toString());
    }
    
    // Compare the two when no type of comparison is specified.
    public int compareTo(Creature other) {
        return compareTo(other, "base");
    }
    
    // Using this for the List.conatins() method to work correctly.
    public boolean equals(Creature other) {
        if (compareTo(other) == 0) return true;
        else return false;
    }

}
