package com.dominik.gameofthrones.interfaces;

import com.dominik.gameofthrones.entities.Fraction;

public interface IFraction {
    
    /**
     * Fraction h1 attacks Fraction h2. A Fraction wins if either one has a bigger
     * army than the other. 
     * @param h1
     * @param h2
     * @return true if Fraction h1 wins, false otherwise
     */
    public boolean attack(Fraction h1, Fraction h2);

    /**
     * Fraction h1 joins Fraction h2. Then, Fraction h2 gains full army support
     * of Fraction h1. Fraction h1 may then be declared as a feudal lord of Fraction h2.
     * @param h1
     * @param h2
     * @return true if Fraction h2 is still alive, false otherwise
     */
    public boolean join(Fraction h1, Fraction h2);

    /**
     * A Fraction can recruit an army as long as the size of the army
     * is not 0. Otherwise, a Fraction will be flagged as eliminated.
     * 
     * @param Fraction
     * @return number of soldiers recruited
     */
    public int recruitArmy(Fraction Fraction);
}
