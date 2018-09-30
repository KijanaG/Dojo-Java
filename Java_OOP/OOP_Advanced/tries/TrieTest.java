package oop.advanced.tries;
//import java.util.Set;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("car");
        trie.insertWord("card");
        trie.insertWord("chip");
        trie.insertWord("trie");
        trie.insertWord("try");
        trie.insertWord("carmichael");
        trie.insertWord("carnage");
        trie.insertWord("carpet");
        trie.insertWord("WordUp");
        
//        Set<Character> keys = trie.root.children.keySet();
//        for(Character key: keys) {
//        	System.out.println(key);
//        	System.out.println(trie.root.children.get(key));
//        }
//        System.out.println(trie.isPrefixValid("ca"));
//        System.out.println(trie.isWordValid("s"));
        trie.printAllKeys();
    }
}
