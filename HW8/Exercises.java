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
     */
    public static Integer sum(final List<Integer> values) {
        throw new UnsupportedOperationException();
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
     */
    public static Integer product(final List<Integer> values) {
        throw new UnsupportedOperationException();
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
     */
    public static Integer strCount(final String toExamine,
            final String sub) {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }
}
