import java.lang.Character;
import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.Map;

/**
 * Driver to create Huffman codes and encoded strings. 
 * 
 * @author  Josh Gillham
 * @version 12-3-12
 */
public class HuffmanCode {

    /**
     * Establish the codeTree using the PriorityQueue provided. 
     * 
     * @param hh the priority queue with data for the Huffman Code.
     * 
     * @return the root of the tree.
     */
    static public HNode buildTree(PriorityQueue<HNode> hh) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Create a map of character -> frequency based on a string. 
     * 
     * @param source the string of characters.
     * 
     * @return the frequency map.
     */
    static public Map<Character, Integer> analyse(String source) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Create a Priority Queue using data from a frequency map.
     * 
     * @param fm frequency map.
     * 
     * @return a priority queue with values from the frequency map.
     */
    static public PriorityQueue<HNode> convert(Map<Character, Integer> fm) {
        throw new UnsupportedOperationException();
    }
    
    /** The Huffman code map created from the seed. */
    private Map<Character, String> codeMap;
    /** Root of the Huffman code tree created from the seed. */
    private HNode codeTree;
    /** The seed string used to create the Huffman code. */
    private String seed;
    
    /**
     * Establish this Huffman code based on an initial string.
     * 
     * @param initialString the initial string used to create the code
     */
    HuffmanCode( String initialString ) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Establish the codeTree using the PriorityQueue provided. 
     * 
     * @param hh the priority queue with data for the Huffman Code.
     */
    private void createCodeTree(PriorityQueue<HNode> hh) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Create a map of character -> frequency based on a string. 
     * 
     * @param source the string of characters.
     */
    private Map<Character, Integer> createFrequencyMap(String source) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Create a Priority Queue using data from a frequency map.
     * 
     * @param fm frequency map.
     * 
     * @return a priority queue with values from the frequency map.
     */
    private PriorityQueue<HNode> createPriorityQueue(
            Map<Character, Integer> fm) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Decode a string using this Huffman code.
     * 
     * @param encoded the string to decode.
     * 
     * @return the decoded string.
     */
    public String decode(String encoded) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Encode a string using this Huffman code.
     * 
     * @param cleartext the string to encode.
     * 
     * @return the encoded string.
     */
    public String encode(String cleartext) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Retrieve the internal Huffman Code Map.
     * 
     * @return the code map for this Huffman Code.
     */
    public Map<Character, String> getCodeMap() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Retrieve the internal Huffman Code Tree.
     * 
     * @return the root of the code tree for this Huffman Code.
     */
    public HNode getCodeTree() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Create codeMap from a code tree.
     * 
     * @param root the root of a Huffman Code subtree.
     */
    private void growCodeMap(HNode root) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Fill in the Huffman Codes in a tree.
     * 
     * @param root the root of the Huffman Code subtree.
     * @param code the code to set at the root.
     */
    private void setCodes(HNode root, String code) {
        throw new UnsupportedOperationException();
    }

}
