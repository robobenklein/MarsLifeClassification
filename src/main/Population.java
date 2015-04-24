package main;

import classification.Creature;
//import main.Main;

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
     *              average positive reproduction rate (1.22)
     *              species is fairly new to the environment, or environment has recently changed for their benefit (2)
     *      ex. y = ln( -0.51x + 30 ) * 0.37 for something like cheetas that will soon go extinct
     *              not reproducing fast enough: -0.51 (severely unable to reproduce fast enough)
     *              been alive previously for a long time: 30
     * 
     * Variables that need to be set per creature:
     *      - Years in existence
     *      - Reproduction rate
     *          - influenced by predators / food supply
     *          - other creatures should be able to alter this value based on their own performance
     *      - Optimal population exponent
     *          - the population exponent for which the population is at it's peak and perfect size
     * 
     * Then population per square km can be calculated from x=0, which is current time.
     * Then multiply by number of square km on Mars
     * 
     */
    
    // This should not be called.
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.err.println("main.Population.main(String[] args) should not be called!");
    }
    
    // Return the population exponent at specified time for creature.
    public static double getPopulationAtTime(Creature creature, double years) {
        double population = Math.log(Double.parseDouble(creature.getInfo("reprate")) * years + Double.parseDouble(creature.getInfo("years"))) * Double.parseDouble(creature.getInfo("populationexp"));
        return(population);
    }
    
    // Get the population per square mile.
    public static double getPopulationPerSqKm(Creature creature, double km) {
        double popnow = getPopulationAtTime(creature, 0);
        return popnow * 5 * km;
    }
    
    // Get the population per square mile at some point in the future.
    public static double getPopulationPerSqKm(Creature creature, double km, double years) {
        double popnow = getPopulationAtTime(creature, years);
        return popnow * 5 * km;
    }
    
}
