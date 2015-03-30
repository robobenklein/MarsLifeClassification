package classification;

public class Ingesting extends Motive {
    
    public String ingestion;
    
    public Ingesting(String motive, String ingestion) {
        // TODO Auto-generated constructor stub
        super(motive);
        
        this.ingestion = ingestion;
    }
    
    public String toString() {
        return("" + ingestion);
    }
    
}
