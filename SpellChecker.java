package task_6;
import java.util.*;
public class SpellChecker {
	 private Set<String> lexicon;

	    public SpellChecker(Set<String> lexicon) {
	        this.lexicon = lexicon;
	    }

	    public List<String> check(String word) {
	        List<String> candidates = new ArrayList<>();
	        if (lexicon.contains(word)) {
	            candidates.add(word);
	            return candidates;
	        }

	        // Check for swapping adjacent characters
	        for (int i = 0; i < word.length() - 1; i++) {
	            char[] chars = word.toCharArray();
	            char temp = chars[i];
	            chars[i] = chars[i+1];
	            chars[i+1] = temp;
	            String swapped = new String(chars);
	            if (lexicon.contains(swapped)) {
	                candidates.add(swapped);
	            }
	        }

	        // Check for inserting a single character
	        for (int i = 0; i <= word.length(); i++) {
	            for (char c = 'a'; c <= 'z'; c++) {
	                String inserted = word.substring(0, i) + c + word.substring(i);
	                if (lexicon.contains(inserted)) {
	                    candidates.add(inserted);
	                }
	            }
	        }

	        // Check for deleting a single character
	        for (int i = 0; i < word.length(); i++) {
	            String deleted = word.substring(0, i) + word.substring(i+1);
	            if (lexicon.contains(deleted)) {
	                candidates.add(deleted);
	            }
	        }

	        // Check for replacing a single character
	        for (int i = 0; i < word.length(); i++) {
	            for (char c = 'a'; c <= 'z'; c++) {
	                String replaced = word.substring(0, i) + c + word.substring(i+1);
	                if (lexicon.contains(replaced)) {
	                    candidates.add(replaced);
	                }
	            }
	        }

	        // Consider phonetic substitutions as well

	        return candidates;
	    }

	    public static void main(String[] args) {
	        // Example usage
	        Set<String> lexicon = new HashSet<>(Arrays.asList("apple", "banana", "orange", "pear"));
	        SpellChecker spellChecker = new SpellChecker(lexicon);
	        String input = "banaa";
	        List<String> candidates = spellChecker.check(input);
	        if (candidates.isEmpty()) {
	            System.out.println(input + " is not a valid word");
	        } else {
	            System.out.println(input + " might be a misspelling of:");
	            for (String candidate : candidates) {
	                System.out.println(candidate);
	            }
	        }
	    }
	}

