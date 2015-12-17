import java.util.ArrayList;
import java.util.HashMap;

public class Cheater {
	private ArrayList<String> words;
	private HashMap<String, Integer> used;
	
	public Cheater(){
		this.words = new ArrayList<String>();
		this.used = new HashMap<String, Integer>();
	}
	
	/**
	 * 
	 * 
	 * @param nextWord
	 */
	public void add(String nextWord){
		this.words.add(nextWord);
	}
	
	public void add(String word, int likelihood){
		this.used.put(word, likelihood);
	}
	
	private int singleCompare(String word1, String word2){
		
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		
		if(word1.length() != word2.length()){
			return -1;
		}
		
		int returnCount = 0;
		for(int i = 0; i < word1.length(); i++){
			if(word1.charAt(i) == word2.charAt(i)){
				returnCount++;
			}
		}	
		return returnCount;
	}
	
	private boolean isPossible(String word){
		for(String s:used.keySet()){
			if(singleCompare(word, s) != used.get(s) || word.equals(s)){
				return false;
			}
			
		}
		return true;
	}
	
	public ArrayList<String> solution(){
		ArrayList<String> possibilities = new ArrayList<String>() ;
		
		for(String s:words){
			if(this.isPossible(s) == true){
				possibilities.add(s);
			}
		}
		return possibilities;
	}
	
}
