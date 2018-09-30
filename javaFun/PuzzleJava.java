
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Arrays;
public class PuzzleJava {
    public static void main(String[] args) {
        // int[] testArray = {3,5,1,2,7,9,8,13,25,32};
        // System.out.println(new PuzzleJava().arrayFun(testArray));
        //  ArrayList<String> names = new ArrayList<String>();
        //  names.add("Nancy");
        //  names.add("Jinichi");
        //  names.add("Fujibayashi");
        //  names.add("Momochi");
        //  names.add("Ishikawa");
        // System.out.println(new PuzzleJava().shuffleArray(names));
        // new PuzzleJava().alphabet();
        // new PuzzleJava().randomGenerator();
        // new PuzzleJava().randomDynGenerator();
        // new PuzzleJava().randomChar();
        new PuzzleJava().randString();
    }
    public ArrayList<Integer> arrayFun(int[] array) {
        int sum = 0;
        ArrayList<Integer> newArray = new ArrayList<Integer>(); 
        for(int i = 0;i<array.length;i++){
            sum+= array[i];
            if(array[i] > 10){
                newArray.add(array[i]);
            }
        }
        System.out.println("Sum is "+sum);
        return newArray;
    }
    public ArrayList<String> shuffleArray(ArrayList<String> array) {
        System.out.println(array);
        Collections.shuffle(array);
        System.out.println(array);
        ArrayList<String> larger = new ArrayList<String>();
        for(String name : array){
            // System.out.println(name.length());
            if(name.length() > 5){
                larger.add(name);
            }
        }
        return larger;
    }
    public void alphabet(){
        char[] alpha = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(char letter : alpha){
            alphabet.add(letter);
        }
        System.out.println(alphabet);
        Collections.shuffle(alphabet);
        System.out.println(alphabet);
        System.out.println(alphabet.get(alphabet.size()-1));
        System.out.println(alphabet.get(0));
        if(alphabet.get(0) == 'A' || alphabet.get(0) == 'E' || alphabet.get(0) == 'I' || alphabet.get(0) == 'O' || alphabet.get(0) == 'U'){
            System.out.println("It was a vowel!");
        }
    }
    public int[] randomGenerator(){
        int[] thisArray = new int[10];
        for(int i=0;i<10;i++){
            int r = (int) Math.floor(Math.random()*101);
            while(r < 55){
                r = (int) Math.floor(Math.random()*101);
            }
            System.out.println(r);
            thisArray[i] = r;
        }
        System.out.println(Arrays.toString(thisArray));
        return thisArray;
    }
    public ArrayList<Integer> randomDynGenerator(){
        ArrayList<Integer> thisArray = new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            int r = (int) Math.floor(Math.random()*101);
            while(r<55){
                r = (int) Math.floor(Math.random()*101);
            }
            thisArray.add(r);
        }
        Collections.sort(thisArray);
        System.out.println(thisArray);
        return thisArray;
    }
    public void randomChar(){
        char[] randomCharsArray = new char[5];
        // ArrayList<Character> randomCharsArray = new ArrayList<Character>();
        for(int i=0;i<5;i++){
            Random r = new Random();
            char randomChar = (char) (40 + r.nextInt(50));
            randomCharsArray[i] = randomChar;
            // System.out.println("Random "+r.toString());
            // System.out.println(randomChar);
        }
        // String.join("",string);
        String thisString = (String) Arrays.toString(randomCharsArray); // "[+, J, F, -, Q]"


        System.out.println(randomCharsArray.getClass().getSimpleName());
        System.out.println(randomCharsArray);
        System.out.println(thisString.getClass().getSimpleName());
        System.out.println(thisString);
    }
    public void randString(){
        String[] randomStringsArray = new String[10];
        for(int i=0;i<10;i++){
            char[] randomCharsArray = new char[5];
            for(int j=0;j<5;j++){
                Random r = new Random();
                char randomChar = (char) (40 + r.nextInt(50));
                randomCharsArray[j] = randomChar;
            }
            String indexString = (String) Arrays.toString(randomCharsArray);
            randomStringsArray[i] = indexString;
        }
        System.out.println(Arrays.toString(randomStringsArray));
    }
}