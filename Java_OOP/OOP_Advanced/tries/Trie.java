package oop.advanced.tries;
import java.util.Set;
import java.util.ArrayList;
public class Trie {
    public Node root;
    
    public Trie() {
        this.root = new Node();
    }
    
    public void insertWord(String word) {
        // gets the root node;
        Node currentNode = this.root;
        
        // iterates over every character in the word
        for(int i = 0; i < word.length(); i++) {
            // currentLetter is just the character / letter at the iteration
            Character currentLetter = word.charAt(i);
            // ask if the current letter is in the map of the current node
            Node child = currentNode.children.get(currentLetter);
            if(child == null) {
                child = new Node();
                currentNode.children.put(currentLetter, child); 
            } 
            
            currentNode = child;
        }
        currentNode.isCompleteWord = true;
    }
    public boolean isPrefixValid(String prefix) {
    	Node currentNode = this.root;
    	boolean found = false;
    	for(int i = 0; i<prefix.length();i++) {
        	found = false;
        	Character currentLetter = prefix.charAt(i);
    		Set<Character> keys = currentNode.children.keySet();
    		for(Character key : keys) {
//    			System.out.println(key);
    			if(currentLetter == key) {
    				found = true;
    			}
    		}
    		if(found == false) {
    			return false;
    		}
    		Node child = currentNode.children.get(currentLetter);
    		currentNode = child;
    	}
    	return found;
    }
    public boolean isWordValid(String word) {
    	Node currentNode = this.root;
    	boolean found = false;
    	for(int i = 0; i<word.length();i++) {
        	found = false;
        	Character currentLetter = word.charAt(i);
    		Set<Character> keys = currentNode.children.keySet();
			System.out.println("GUUYY"+keys.size());
    		for(Character key : keys) {
    			if(currentLetter == key) {
    				found = true;
    			}
    		}
    		if(found == false) {
    			return false;
    		}
    		Node child = currentNode.children.get(currentLetter);
    		currentNode = child;
    	}
    	return currentNode.isCompleteWord;
    }
    void printAllKeys() {
    	ArrayList<Character> characterList = new ArrayList<Character>();
    	if(this.root != null) {
    		Node currentNode = this.root;
    		characterList.addAll(keyCall(currentNode));
    		System.out.println(characterList);
    	} else {
    		System.out.println("Cannot find");
    	}
    }
    private ArrayList<Character> keyCall(Node current) {
    	ArrayList<Character> characterList = new ArrayList<Character>();
    	Set<Character> keys = current.children.keySet();
    	for(Character key : keys) {
    		System.out.println(current.children);
        	characterList.add(key);
        	Node child = current.children.get(key);
        	if(child != null) {
        		characterList.addAll(keyCall(child));
        	}
    	}
    	return characterList;
    }
}
