import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
  public static void main(String[] args) {
    String[] words = {
      "vase", "bat", "gods", "latte",
      "name", "apres", "spit", "joke",
      "ham", "dog", "act", "tale",
      "parse", "pits", "asper", "tab",
      "table", "mane", "late", "god",
      "cat", "table", "save", "spare"
    };

    Map<String, List> wordAnagramPairs = getWordAnagramPairs(words);
    System.out.println(wordAnagramPairs.values());
  }

  /**
   * Time Complexity - O(N * K log K) where N is length of words & K is maximum length of string
   * Space Complexity - O(N * K) with HashMap
   * @param words - array of strings to check for anagrams
   * @return Map<String, List> of word pairs with sorted word as key & list of anagram words as values
   */
  private static Map<String, List> getWordAnagramPairs(String[] words) {
    Map<String, List> anagrams = new HashMap<String, List>();

    for (String word : words) {
      // get unique sorted for word in words
      char[] charArr = word.toCharArray();
      Arrays.sort(charArr);

      String sortedWord = String.valueOf(charArr);

      // new word anagrams
      if (!anagrams.containsKey(sortedWord))
        anagrams.put(sortedWord, new ArrayList<>());
      
      anagrams.get(sortedWord).add(word);
    }

    return anagrams;
  }

}