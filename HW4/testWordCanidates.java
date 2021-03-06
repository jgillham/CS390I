

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * The test class testWordCanidates.
 *
 * @author  Josh Gillham
 * @version 10-17-12
 */
public class testWordCanidates {
    /**
     * Hides the complexity of the TreeMap ge
     */
    class SubDivideResult extends TreeMap< String, SortedSet< String > > {
        public SubDivideResult( ) { super( ); }
        public SubDivideResult( Map< String, SortedSet< String > > object ) { super( object ); }
    }
    
    SortedSet< String > testWordList;
    String[] words= { "stat", "land", "meet", "find" };
    
    @Before
    public void setup() {
        testWordList= new TreeSet< String >();
        for( String word: words ) {
            testWordList.add( word );
        }
    }
    
    @Test( expected= NullPointerException.class )
    public void testConstructor_nullWord() {
        new WordCanidates( null, testWordList );
    }

    @Test( expected= NullPointerException.class )
    public void testConstructor_nullList() {
        new WordCanidates( "adfs", null );
    }
    
    @Test( expected= IllegalArgumentException.class )
    public void testConstructor_emptyList() {
        new WordCanidates( "adfs", new TreeSet< String >() );
    }
    
    @Test( expected= IllegalArgumentException.class )
    public void testConstructor_badWordLength() {
        new WordCanidates( "adf", testWordList );
    }
    
    @Test( expected= IllegalArgumentException.class )
    public void testConstructor_emptyWord() {
        new WordCanidates( "", testWordList );
    }
    
    @Test
    public void testCount() {
        WordCanidates instance= new WordCanidates( "adfs", testWordList );
        assertEquals( testWordList.size(), instance.size() );
        
        testWordList.add( "test" );
        instance= new WordCanidates( "adfs", testWordList );
        assertEquals( testWordList.size(), instance.size() );
        
        testWordList.add( "conf" );
        instance= new WordCanidates( "adfs", testWordList );
        assertEquals( testWordList.size(), instance.size() );
    }
    
    @Test
    public void testGetRandomCanidate() {
        WordCanidates instance= new WordCanidates( "adfs", testWordList );
        assertTrue( testWordList.contains( instance.getRandomCanidate() ) );
    }
    
    @Test
    public void testsubDivide() {
        SortedSet< String > wordList= new TreeSet< String >();
        wordList.add( "cant" );
        wordList.add( "went" );
        wordList.add( "capa" );
        
        
        SubDivideResult expectedResult= new SubDivideResult();
        SortedSet< String > temp= new TreeSet< String >();
        temp.add( "went" );
        expectedResult.put( "----", temp );
        temp= new TreeSet< String >();
        temp.add( "cant" );
        expectedResult.put( "-a--", temp );
        temp= new TreeSet< String >();
        temp.add( "capa" );
        expectedResult.put( "-a-a", temp );
        WordCanidates instance= new WordCanidates( "----", wordList );
        SubDivideResult mappedLists= new SubDivideResult( instance.subDivide( 'a' ) );
        
        java.util.Set< String > keys= mappedLists.keySet();
        
        for( String key: keys ) {
            SortedSet< String > list= mappedLists.get( key );
            assertNotNull( list );
            assertTrue( list.size() > 0 );
        }
        
        assertEquals( expectedResult, mappedLists );
    }
    @Test
    public void testsubDivide2() {
        int[] resultingSizes={ 2, 1 };
        SortedSet< String > wordList= new TreeSet< String >();
        wordList.add( "casa" );
        wordList.add( "went" );
        wordList.add( "capa" );
        SubDivideResult expectedResult= new SubDivideResult();
        SortedSet< String > temp= new TreeSet< String >();
        temp.add( "went" );
        expectedResult.put( "----", temp );
        temp= new TreeSet< String >();
        temp.add( "casa" );
        temp.add( "capa" );
        expectedResult.put( "-a-a", temp );
        
        WordCanidates instance= new WordCanidates( "----", wordList );
        SubDivideResult mappedLists= new SubDivideResult( instance.subDivide( 'a' ) );
        assertEquals(expectedResult, mappedLists );
    }
    
    @Test
    public void testsubDivide_noDefault() {
        SortedSet< String > wordList= new TreeSet< String >();
        wordList.add( "cant" );
        wordList.add( "weat" );
        wordList.add( "capa" );
        
        
        SubDivideResult expectedResult= new SubDivideResult();
        SortedSet< String > temp= new TreeSet< String >();
        temp.add( "weat" );
        expectedResult.put( "--a-", temp );
        temp= new TreeSet< String >();
        temp.add( "cant" );
        expectedResult.put( "-a--", temp );
        temp= new TreeSet< String >();
        temp.add( "capa" );
        expectedResult.put( "-a-a", temp );
        WordCanidates instance= new WordCanidates( "----", wordList );
        SubDivideResult mappedLists= new SubDivideResult( instance.subDivide( 'a' ) );
        
        java.util.Set< String > keys= mappedLists.keySet();
        
        for( String key: keys ) {
            SortedSet< String > list= mappedLists.get( key );
            assertNotNull( list );
            assertTrue( list.size() > 0 );
        }
        
        assertEquals( expectedResult, mappedLists );
    }
    
    @Test
    public void testsubDivide_Twice() {
        SortedSet< String > wordList= new TreeSet< String >();
        wordList.add( "casa" );
        wordList.add( "went" );
        wordList.add( "capa" );
        wordList.add( "cata" );
        
        SubDivideResult expectedResult= new SubDivideResult();
        SortedSet< String > temp= new TreeSet< String >();
        temp.add( "went" );
        expectedResult.put( "----", temp );
        temp= new TreeSet< String >();
        temp.add( "casa" );
        temp.add( "capa" );
        temp.add( "cata" );
        expectedResult.put( "-a-a", temp );
        
        WordCanidates instance= new WordCanidates( "----", wordList );
        SubDivideResult mappedLists= new SubDivideResult( instance.subDivide( 'a' ) );
        
        assertEquals(expectedResult, mappedLists );
        SortedSet< String > subList;
        assertNotNull( (subList= mappedLists.get( "-a-a" ) ) );
        
        expectedResult= new SubDivideResult();
        temp= new TreeSet< String >();
        temp.add( "casa" );
        temp.add( "capa" );
        expectedResult.put( "-a-a", temp );
        temp= new TreeSet< String >();
        temp.add( "cata" );
        expectedResult.put( "-ata", temp );
        
        
        WordCanidates instance2= new WordCanidates( "-a-a", subList );
        mappedLists= new SubDivideResult( instance2.subDivide( 't' ) );
        
        assertEquals(expectedResult, mappedLists );
        
    }
    @Test
    public void testsubDivide_ThreeTimes() {
        SortedSet< String > wordList= new TreeSet< String >();
        wordList.add( "casa" );
        wordList.add( "went" );
        wordList.add( "capa" );
        wordList.add( "cata" );
        wordList.add( "pasa" );
        
        SubDivideResult expectedResult= new SubDivideResult();
        SortedSet< String > temp= new TreeSet< String >();
        temp.add( "casa" );
        temp.add( "capa" );
        temp.add( "cata" );
        temp.add( "pasa" );
        expectedResult.put( "-a-a", temp );
        temp= new TreeSet< String >();
        temp.add( "went" );
        expectedResult.put( "----", temp );
        
        WordCanidates instance= new WordCanidates( "----", wordList );
        SubDivideResult mappedLists= new SubDivideResult( instance.subDivide( 'a' ) );
        
        assertEquals(expectedResult, mappedLists );
        
        SortedSet< String > subList;
        assertNotNull( (subList= mappedLists.get( "-a-a" ) ) );
        
        expectedResult= new SubDivideResult();
        temp= new TreeSet< String >();
        temp.add( "casa" );
        temp.add( "capa" );
        temp.add( "pasa" );
        expectedResult.put( "-a-a", temp );
        temp= new TreeSet< String >();
        temp.add( "cata" );
        expectedResult.put( "-ata", temp );
        
        
        WordCanidates instance2= new WordCanidates( "-a-a", subList );
        mappedLists= new SubDivideResult( instance2.subDivide( 't' ) );
        
        assertEquals(expectedResult, mappedLists );
        
        assertNotNull( (subList= mappedLists.get( "-a-a" ) ) );
                
        expectedResult= new SubDivideResult();
        temp= new TreeSet< String >();
        temp.add( "capa" );
        temp.add( "casa" );
        expectedResult.put( "ca-a", temp );
        temp= new TreeSet< String >();
        temp.add( "pasa" );
        expectedResult.put( "-a-a", temp );
        
        
        WordCanidates instance3= new WordCanidates( "-a-a", subList );
        mappedLists= new SubDivideResult( instance3.subDivide( 'c' ) );
        
        assertEquals(expectedResult, mappedLists );
        
    }
}
