
/**
 * 
 * @author Josh Gillham
 * @version 11-28-12
 */
public abstract class HNode extends BTNode< String > {
    private int frequency = 0;
    
    public HNode( String binaryCode, HNode left, HNode right ) {
        super( binaryCode, left, right );
        throw new UnsupportedOperationException();
    }
    
    public int getFrequency() {
        throw new UnsupportedOperationException();
    }
}
