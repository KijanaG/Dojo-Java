public class StringManipulatorTest {
    public static void main(String[] args) {
        //Task 1
        StringManipulator manipulator = new StringManipulator();
        String str = manipulator.trimAndConcat("    Hello     ","     World    ");
        System.out.println(str); // HelloWorld
        //Task 2
        char letter = 'o';
        Integer a = manipulator.getIndexOrNull("Coding", letter);
        Integer b = manipulator.getIndexOrNull("Hello World", letter);
        Integer c = manipulator.getIndexOrNull("Hi", letter);
        System.out.println(a); // 1
        System.out.println(b); // 4
        System.out.println(c); // null
        //Task 3
        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer d = manipulator.getIndexorNullStr(word, subString);
        Integer e = manipulator.getIndexorNullStr(word, notSubString);
        System.out.println(d); // 2
        System.out.println(e); // null
        //Task 4
        String thisWord = manipulator.concatSubstring("Hello", 1, 2, "world");
        System.out.println(thisWord); // eworld
    }
}