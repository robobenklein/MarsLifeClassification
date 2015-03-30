package classification;

public class Creature extends Ingesting {
    
    String genus;
    String species;
    
    public Creature(String motive, String ingestion, String genus, String species) {
        // TODO Auto-generated constructor stub
        super(motive, ingestion);
        
        this.genus = genus;
        this.species = species;
    }
    
}
