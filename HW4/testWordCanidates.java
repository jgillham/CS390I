

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
            assertEquals( sizes[j], subList.size() );
        }
    }
    @Test
    public void testsubDivide() {
        int[] resultingSizes={ 1, 1, 1 };
        List< String > wordList= new LinkedList< String >();
        wordList.add( "cant" );
        wordList.add( "went" );
        wordList.add( "capa" );
        WordCanidates instance= new WordCanidates( wordList );
        java.util.Map< String, List< String > > mappedLists= instance.subDivide( 'a' );
        List< String > subList;
        java.util.Collection< List< String > > subLists= mappedLists.values();
        assertEquals( 3, mappedLists.values().size() );
        utilTestSizes( resultingSizes, subLists );
    }
    @Test
    public void testsubDivide2() {
        int[] resultingSizes={ 2, 1 };
        List< String > wordList= new LinkedList< String >();
        wordList.add( "casa" );
        wordList.add( "went" );
        wordList.add( "capa" );
        WordCanidates instance= new WordCanidates( wordList );
        java.util.Map< String, List< String > > mappedLists= instance.subDivide( 'a' );
        List< String > subList;
        java.util.Collection< List< String > > subLists= mappedLists.values();
        utilTestSizes( resultingSizes, subLists );
    }
}
