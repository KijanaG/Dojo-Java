import java.util.ArrayList;
import java.util.Arrays;
public class BasicJava {
    public static void main(String[] args) {
        new BasicJava().print1To255();
        new BasicJava().iterate();
        int[] maxArray = {13,-3,-34,1,4};
        new BasicJava().findMax(maxArray); 
        new BasicJava().getAverage(maxArray); 
        new BasicJava().oddNumbers(); 
        new BasicJava().greaterThanY(maxArray, 12); 
        new BasicJava().eliminateNegatives(maxArray);
        int[] newArray = {43,7,-14,8,18};
        new BasicJava().squareValues(newArray);
        new BasicJava().maxMinAvg(newArray);
        ArrayList<Integer> dynArray = new ArrayList<Integer>();
        dynArray.add(3);
        dynArray.add(5);
        dynArray.add(4);
        dynArray.add(9);
        new BasicJava().shiftArray(dynArray);
    }
    public void print1To255(){
        int sum = 0;
        for(int i = 1; i<256;i+=2){
            sum += i;
            System.out.println("New number: "+i+" Sum: "+sum);
        }
    }
    public void iterate(){
        int[] thisArray = {1,3,5,7,9,13};
        for(int i : thisArray){
            System.out.println(i);
        }
    }
    public void findMax(int[] array){
        int max = array[0];
        for(int i : array){
            if(i>max){
                max = i;
            }
        }
        System.out.println(max);
    }
    public void getAverage(int[] array){
        int sum = 0;
        int count = 0;
        for(int i : array){
            count++;
            sum+= i;
            System.out.println(i);
        }
        float average = (float) sum/count;
        System.out.println(average);
    }
    public void oddNumbers(){
        ArrayList<Integer> oddArray = new ArrayList<Integer>();
        for(int i=1;i<256;i+=2){
            oddArray.add(i);
        }
        System.out.println(oddArray);
    }
    public void greaterThanY(int[] array, int value){
        int count = 0;
        for(int i : array){
            if(i > value){
                count++;
            }
        }
        System.out.println("Values greater than "+value+": "+count);
    }
    public void squareValues(int[] array){
        for(int i=0;i<array.length;i++){
            array[i] = array[i] * array[i];
        }
        System.out.println(Arrays.toString(array));
    }
    public void eliminateNegatives(int[] array){
        for(int i=0;i<array.length;i++){
            if(array[i]<0){
                array[i]=0;
            }
        }
        System.out.println(Arrays.toString(array));  
    }
    public void maxMinAvg(int[] array){
        int max = array[0];
        int min = array[0];
        int sum = array[0];
        int count = 0;
        for(int i=1;i<array.length;i++){
            if(array[i]>max){
                max = array[i];
            } else if(array[i]<min){
                min = array[i];
            }
            sum+=array[i];
            count++;
        }
        double average = (double) sum/count;
        System.out.println("Min: "+min+" Max: "+max+" Average: "+average);
    }
    public void shiftArray(ArrayList<Integer> array){
        array.remove(0);
        array.add(0);
        System.out.println(array);
    }
}