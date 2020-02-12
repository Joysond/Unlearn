import java.math.BigInteger;
import java.util.LinkedHashSet;
import java.util.Set;

public class TestClass {
    public static void main(String[] args) {
        /*System.out.println(new BigInteger("123456").toString());
        Character ch = new Character('c');
        if(ch.equals('c')) {
            System.out.println("its true");
        }*/
        lengthOfLongestSubstring("pwwkew");
    }

    public static int lengthOfLongestSubstring(String s) {
        int longestSubLength, subLength;
        longestSubLength = subLength = 0;
        Set<Character> tracker = new LinkedHashSet<>();
        for(int i=0;i<s.length();i++) {
            if(tracker.contains(s.charAt(i))) {
                tracker = getUpdatedTracker(tracker, s.charAt(i));
                tracker.add(s.charAt(i));
                subLength = tracker.size() > subLength ? tracker.size() : subLength;
                //subLength = tracker.size();
                if(subLength > longestSubLength) {
                    longestSubLength = subLength;
                }
                System.out.println(tracker.toString() + " >> " + subLength);
            } else {
                subLength++;
                tracker.add(s.charAt(i));
            }
        }
        return longestSubLength > subLength ? longestSubLength : subLength;
    }

    public static Set getUpdatedTracker(Set<Character> tracker, char charac) {
        Set<Character> updatedTracker = new LinkedHashSet<>();
        boolean addEnable = false;
        for(Character ch : tracker) {
            if(ch.equals(charac)) {
                addEnable = true;
                continue;
            }
            if(addEnable) {
                updatedTracker.add(ch);
            }
        }
        return updatedTracker;
    }
}
