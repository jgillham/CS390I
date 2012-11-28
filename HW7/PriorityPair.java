
/**
 * Encapsulates a pair of data and provides implementation for the priority
 *  queue to sort through.
 * 
 * @param <T> is the data type for the second element.
 * 
 * @author Josh Gillham 
 * @version 11-18-12
 */
public class PriorityPair< T > implements Comparable {
    /** Holds the priority. */
    private int priority;
    /** Holds the data value. */
    private T value;
    
    /**
     * Initializes the object.
     * 
     * @param priority is the pair priority.
     * @param value is the new data.
     */
    public PriorityPair(int priority, T value) {
        this.priority = priority;
        this.value = value;
    }
    
    /**
     * Accesses the priority.
     * 
     * @return the priority.
     */
    public int getPriority() {
        return this.priority;
    }
    
    /**
     * Accesses the data.
     * 
     * @return the data.
     */
    public T getValue() {
        return this.value;
    }
    
    /**
     * Sets a new value.
     * 
     * @param value the new value.
     */
    public void setPriority( int priority ) {
        this.priority = priority;
    }
    
    /**
     * Tests if all the data in this pair matches another pair.
     * 
     * @param o is the other object to compare to.
     * 
     * @return true if the other object is a PriorityPair and the data matches
     *  OR false otherwise.
     */
    @Override
    public boolean equals( Object o ) {
        if ( o instanceof PriorityPair ) {
            PriorityPair a2 = (PriorityPair)o;
            return this.priority == a2.priority && this.priority == a2.priority;
        }
        return false;
    }
    
    /**
     * Compares the priority of PriorityPairs.
     * 
     * @param o is the other object to compare to.
     * 
     * @throws IllegalArgumentException if o is not a priority pair.
     * 
     * @return 1 if this object has a higher priority 
     *  OR -1 if the this object has a lower priority 
     *  OR 0 otherwise.
     */
    public int compareTo( Object o ) {
        if ( o instanceof PriorityPair == false )
            throw new IllegalArgumentException();
        PriorityPair a2 = (PriorityPair)o;
        if ( this.priority > a2.priority ) {
            return 1;
        }
        else if ( this.priority < a2.priority ) {
            return -1;
        }
        return 0;
    
    }
} 
