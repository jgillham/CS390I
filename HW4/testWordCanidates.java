

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Map;

/**
 * The test class testWordCanidates.
 *
 * @author  Josh Gillham
 * @version 10-10-12
 */
public class testWordCanidates {
    public void utilTestSizes( int[] sizes, java.util.Collection< List< String > > lists){
        assertEquals( sizes.length, lists.size() );
        int j=0;
        List< String > subList;
        for( Iterator< List< String > > i= lists.iterator(); i.hasNext(); ) {
            subList= i.next();
            System.out.println( "subList.size(): "+subList.size() );
            System.out.println( "subList: "+subList );
            assertEquals( sizes[j++], subList.size() );
        }
    }
    public void utilTestResults( java.util.Map< String, String[] > expectedResults, 
                                 java.util.Map< String, List< String > > actualResults ){
        assertEquals( expectedResults.size(), actualResults.size() );
        int j=0;
        List< String > subList;
        Iterator< String > k= expectedResults.keySet().iterator();
        while( k.hasNext() ){
            String key= k.next();
            String[] eArray= expectedResults.get( key );
            assertNotNull( eArray );
            List< String > aArray= actualResults.get( key );
            assertNotNull( aArray );
            assertEquals( eArray.length, aArray.size() );
            int e= 0;
            Iterator< String > a= aArray.iterator();
            while( a.hasNext() ){
                String expected= eArray[ e++ ];
                String actual= a.next();
                assertEquals( expected, actual );
            }
            
        }
    }
    @Test
    public void testsubDivide() {
        System.out.println( "testsubDivide" );
        List< String > wordList= new LinkedList< String >();
        wordList.add( "cant" );
        wordList.add( "went" );
        wordList.add( "capa" );
        java.util.Map< String, String[] > expectedResult= new java.util.TreeMap< String, String[] >();
        expectedResult.put( "----", new String[]{ "went" } );
        expectedResult.put( "-a--", new String[]{ "cant" } );
        expectedResult.put( "-a-a", new String[]{ "capa" } );
        WordCanidates instance= new WordCanidates( wordList );
        java.util.Map< String, List< String > > mappedLists= instance.subDivide( 'a' );
        
        utilTestResults( expectedResult, mappedLists );
    }
    @Test
    public void testsubDivide2() {
        System.out.println( "testsubDivide2" );
        int[] resultingSizes={ 2, 1 };
        List< String > wordList= new LinkedList< String >();
        wordList.add( "casa" );
        wordList.add( "went" );
        wordList.add( "capa" );
        java.util.Map< String, String[] > expectedResult= new java.util.TreeMap< String, String[] >();
        expectedResult.put( "----", new String[]{ "went" } );
        expectedResult.put( "-a-a", new String[]{ "casa", "capa" } );
        
        WordCanidates instance= new WordCanidates( wordList );
        java.util.Map< String, List< String > > mappedLists= instance.subDivide( 'a' );
        
        utilTestResults( expectedResult, mappedLists );
    }
}
