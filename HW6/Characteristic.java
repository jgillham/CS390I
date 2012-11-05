/**
* A decision-influencing characteristic.
* 
* @author Josh Gillham
* @version 10-29-12
*/
public class Characteristic {
    /** Holds the default rank. */
    public static final int DEFAULT_RANK = 1;
    /** Holds the rank. */
    private int rank = DEFAULT_RANK;
    /** Holds the name. */
    private String name;
    
    /**
    * Constructor that sets the name and default rank.
    * 
    * Post Conditions:
    * -this.name is set to theName.
    * 
    * @param theName the name of this characteristic
    */
    public Characteristic(String theName) {
        this.name = theName;
    }
    
    /**
     * Sets the new ranking.
     * 
     * @param newRank is the new rank.
     */
    public void setRank(int newRank) {
        this.rank = newRank;
    }
    
    /**
     * Accesses the name.
     * 
     * @return the name.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Accesses the rank.
     * 
     * @return the rank.
     */
    public int getRank() {
        return this.rank;
    }
}
