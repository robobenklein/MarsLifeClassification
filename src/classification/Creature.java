package classification;

import java.util.HashMap;
import java.util.Map;

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
    // Returns information from dict if key is present
    public String getInfo(String key) {
        try {
            return information.get(key);
        } catch (Exception e) {
            return "Error getting information.";
        }
    }
    
    public String toString() {
        return super.toString() + " " + genus + " " + species;
    }
    
    public void printAllInfo() {
        System.out.println();
        System.out.println("Creature " + this);
        System.out.println("Custom information: " + information);
    }
}
