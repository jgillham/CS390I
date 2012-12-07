import java.util.List;
/**
 * This class provides a namespace for exercise problems.
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
     * @throws NullPointerException when values is null.
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
     * @throws NullPointerException when values is null.
     */
    public static Integer product(final List<Integer> values) {
        switch ( values.size() ) {
            case 0:
                throw new IllegalArgumentException(
                    "Taking the sum of an empty list is undefined."
                );
                // Only used when the call passes a list of one.
            case 1:
                return values.get( 0 );
                // Base case of two products.
            case 2:
                return values.get( 0 ) * values.get( 1 );
                // All other cases.
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
            // Handle bad arguments.
        if ( toExamine == null || sub == null )
            throw new NullPointerException( "Parameters cannot be null." );
        if ( toExamine.length() == 0 || sub.length() == 0 )
            throw new IllegalArgumentException( 
                "Parameters cannot be empty strings."
            );
            // The base case. Impossible to find the sub string.
        if ( toExamine.length() < sub.length() )
            return 0;
            // Check from the beginning.
        boolean found = toExamine.startsWith( sub );
        int counter = found ? 1 : 0;
            // Recursive call for the next part of the string.
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
     *  sum to the given target value OR false if it is not or the list
     *  is empty.
     * 
     * @throws NullPointerException if numbers is null.
     */
    public static boolean groupExists(final List<Integer> numbers,
            final int target) {
        if ( numbers == null )
            throw new NullPointerException();
            // Start checking for combinations.
        if ( combinationExists( numbers, 0, target, 0, true ) ||
                combinationExists( numbers, 0, target, 0, false ) ) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Move through ever combination from the index in numbers. First,
     *  compare the base to the target for a match. If there is a match,
     *  signal success and return. Second, if not a match and we are "on",
     *  add our number to the base. Third, call ourselves for the next
     *  index and the newbase both for on and off selections. Finally,
     *  every combination of numbers in the list is checked. This
     *  algorithm borrows from addition.
     * 
     * @param numbers the list of numbers.
     * @param base the starting number.
     * @param index the starting index.
     * @param on includes the number corresponding to the index.
     */
    public static boolean combinationExists( 
            final List<Integer> numbers, Integer base, 
            Integer target, int index, boolean on ) {
            // Check for a match.
        if ( base.equals( target ) ) {
            return true;
        }
            // Don't pass the end of the list.
        if ( index >= numbers.size() ) {
            return false;
        }
            // Add the selected number.
        Integer newBase = new Integer( base );
        if ( on ) {
            newBase += numbers.get( index );
        }
            // If we have passed the target then look no further.
        if ( newBase > target )
            return false;
            // Check each sub combination.
        if ( combinationExists( numbers, newBase, target, index + 1, true ) ||
                combinationExists( numbers, newBase, target, index + 1, false ) ) {
            return true;
        } else {
            return false;
        }
    }
}
