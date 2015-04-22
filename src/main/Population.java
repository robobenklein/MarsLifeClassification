/**
 * 
 */
package main;

/**
 * @author Ben Klein
 *
 */
public class Population {
    
    /**
     * population estimation function:
     * 
     * y = ln(Rx+Y)M
     * 
     * R = rate of population change
     *      0.4 for very slow to reproduce populations
     *      5.6+ for rapidly evolving populations
     * x = Time unit
     * Y = Years population has already had to reach optimum population
     * M = Exponential equivalent of maximum optimum population
     *      0.06 for very low population creatures
     *      1+ for populations insanely large (like ants)
     * 
     * returns y, the population index from 0 representing how close it is to optimal pop.
     *      ex. y = ln( 1.22x + 2 ) * 0.11 for something like whales
     *      attributes: low numerical population (0.11)
     *              average reproduction rate (1.22)
     *              species is fairly new to the environment, or environment has recently changed for their benefit (2)
     *      ex. y = ln( -0.51x + 30 ) * 0.37 for something like cheetas that will soon go extinct
     *              not reproducing fast enough: -0.51 (severely unable to reproduce fast enough)
     *              been alive previously for a long time: 30
     * 
     */
    public Population() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
