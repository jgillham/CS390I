import java.util.List;
/**
 * 
 * @author Josh Gillham
 * @version 11-28-12
 */
public class Exercises {
    /**
     * (a) Compute the sum of a List of Integer values. Must
     *  use function application and recursion only. Must not 
     *  use mutation. Must not use any form of the for or while 
     *  loop constructs. Must not use any form of the add, addAll, 
     *  clear, remove, removeAll, retainAll, or set methods. 
     *  Must not have side effects, including changing the 
     *  structure of an object pointed to by a parameter. Use tail 
     *  recursion if possible.
     * 
     * @param values the list of integers to be added.
     * 
     * @return the sum of the integers.
     * 
     * @throws IllegalArgumentException when values is empty.
     */
    public static Integer sum(final List<Integer> values) {
        switch ( values.size() ) {
            case 0:
                throw new IllegalArgumentException( 
                    "Taking the sum of an empty list is undefined."
                );
            case 1:
                return values.get( 0 );
            case 2:
                return values.get( 0 ) + values.get( 1 );
            default:
                return values.get( 0 ) + 
                    sum( values.subList( 1, values.size() ) );
        }
    }
    
    /**
     * (b) Compute the product of a List of Integer values. 
     *  Must use function application and recursion only. Must 
     *  not use mutation. Must not use any form of the for or 
     *  while loop constructs. Must not use any form of the add, 
     *  addAll, clear, remove, removeAll, retainAll, or set methods. 
     *  Must not have side effects, including changing the structure 
     *  of an object pointed to by a parameter. Use tail recursion 
     *  if possible.
     * 
     * @param values the list of integers to be multiplied.
     * 
     * @return the product of the integers.
     * 
     * @throws IllegalArgumentException when values is empty.
     */
    public static Integer product(final List<Integer> values) {
        switch ( values.size() ) {
            case 0:
                throw new IllegalArgumentException(
                    "Taking the sum of an empty list is undefined."
                );
            case 1:
                return values.get( 0 );
            case 2:
                return values.get( 0 ) * values.get( 1 );
            default:
                return values.get( 0 ) *
                    product( values.subList( 1, values.size() ) );
        }
    }
    
    /**
     * Given a non-null string and a non-empty substring, recursively 
     *  compute the number of times that the substring appears in the 
     *  string, without the substrings overlapping. For example, 
     *  strCount("catcowcat", "cat") returns 2. Must use function 
     *  application and recursion only. Must not use mutation. Must not 
     *  use any form of the for or while loop constructs. Must not have 
     *  side effects. Use tail recursion if possible.
     * 
     * @param toExamine the string to be searched.
     * @param sub the string be searched for.
     * 
     * @return the number of non-overlapping occurences of the substring
     *  in the string.
     * 
     * @throws NullPointerException when toExamine or sub is null.
     * @throws IllegalArgumentException when toExamine or sub is empty.
     */
    public static Integer strCount(final String toExamine,
            final String sub) {
        if ( toExamine == null || sub == null )
            throw new NullPointerException( "Parameters cannot be null." );
        if ( toExamine.length() == 0 || sub.length() == 0 )
            throw new IllegalArgumentException( 
                "Parameters cannot be empty strings."
            );
        if ( toExamine.length() < sub.length() )
            return 0;
        boolean found = toExamine.startsWith( sub );
        int counter = found ? 1 : 0;
        if ( toExamine.length() > sub.length() )
            counter += strCount( 
                toExamine.substring( ( found ? sub.length() : 1 ) ), sub
            );
        return counter;
    }
    
    /**
     * (d) Given a List of Integers, determine if it is possible to 
     *  choose a group of some of the values such that the group sums 
     *  to a given target value. Examples:
     *  
     * groupExists({2, 4, 9}, 11) → true
     * groupExists({2, 4, 9}, 15) → true
     * groupExists({2, 4, 9}, 8) → false
     * groupExists({2, 4, 9, 2}, 8) → true
     *  
     * Must use function application and recursion only. Must not use 
     *  mutation. Must not use any form of the for or while loop constructs. 
     *  Must not use any form of the add, addAll, clear, remove, removeAll, 
     *  retainAll, or set methods. Must not have side effects, including 
     *  changing the structure of an object pointed to by a parameter. Use 
     *  tail recursion if possible.
     * 
     * @param numbers the list of integers.
     * @param target the integer to find.
     * 
     * @return true if there exists a group of integers in the list that 
     *  sum to the given target value.
     */
    public static boolean groupExists(final List<Integer> numbers,
            final int target) {
        if ( numbers.isEmpty() )
            return false;
        else {
            if ( numbers.get( 0 ).intValue() == target )
                return true;
            else
                return groupExists( 
                    numbers.subList( 1, numbers.size() ), target
                );
        }
    }
}
