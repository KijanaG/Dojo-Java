import java.util.HashMap;
import java.util.Set;
public class HashMatique {
    public static void main(String[] args) {
        HashMap <String, String> tracklist = new HashMap<String, String>();
        tracklist.put("Poison","I pick my poison and it's you! Nothing can kill me like you do.");
        tracklist.put("Post Up", "I took yo bitch that's right. Money keep comin' that's right. Only Raloh Lauren that's right.");
        tracklist.put("California", "Stay gettin' that work in California. Never seen a better view than out in Malibu.");
        tracklist.put("Lover", "Hey Lover, do you still believe in love I wonder? Oh when the stars come falling down for you.");
        String title = tracklist.get("California");
        System.out.println(title);
        Set<String> keys = tracklist.keySet();
        for(String key : keys){
            System.out.println(key +" : "+tracklist.get(key));
        }
    }
}