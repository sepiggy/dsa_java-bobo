import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] alphabetCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> wordCodeSet = new TreeSet<>();

        for (String word : words) {
            StringBuilder wordCode = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                wordCode.append(alphabetCode[ch - 'a']);
            }
            wordCodeSet.add(wordCode.toString());
        }

        return wordCodeSet.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println((new Solution()).uniqueMorseRepresentations(words));
    }
}