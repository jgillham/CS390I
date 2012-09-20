
/**
 * Write a description of class Manager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Manager implements ManagerInterface {
    public Manager( String name ){ throw new IllegalArgumentException(); }
    public int getScore(){ return 5; }
    public PlayerInterface addPlayer( String name ) { return null; }
    public boolean kickPlayer( PlayerInterface player ) { return false; }
    public PlayerInterface getPlayerUp() { return null; }
    public int getRosterSize() { return 0; }
    public void nextPlayer() {}
    public String getName() { return ""; }
    public void resignPlayer( Player player ) throws java.util.NoSuchElementException{ throw new java.util.NoSuchElementException(); }
}
