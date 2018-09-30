import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) {
        ArrayList<String> allCombos = new ArrayList<String>();
        new Permutation().permutate("","aws",allCombos);
        System.out.println(allCombos);
    }

    public void permutate(String anchor, String combo, ArrayList<String> combos) {
      ArrayList<String> splitString = new ArrayList<String>(Arrays.asList(combo.split("")));  
      if(combo.length() == 0) {
            combos.add(anchor);
        } else {
            for(int i = 0; i < splitString.size(); i++) {
                System.out.println("Anchor: "+anchor+" Split: "+splitString.get(i)+" splice"+splice(splitString, i)+" Combos: "+combo.length());
                permutate(join(anchor,splitString.get(i)),splice(splitString, i), combos);
            }
        }
    }

    public String splice(ArrayList<String> s, int i){
        s.remove(i);
        String join = String.join("",s);
        return join;
    }

    public String join(String a, String b){
        String c = a+b;
        return c;
    }
}