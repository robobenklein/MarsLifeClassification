package classification;

public class Motive extends Kingdom {
    
    public String motive;
    
    public Motive(String motive) {
        // TODO Auto-generated constructor stub
        super();
        
        this.motive = motive;
    }
    
    public String toString() {
        return(super.toString() + " " + motive);
    }
    
}
