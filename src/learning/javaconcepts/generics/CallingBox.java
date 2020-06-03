package learning.javaconcepts.generics;

public class CallingBox{
    public static void main(String[] args) {
        BoxWithNoType boxWithNoType = new BoxWithNoType();
        /**
         * Throws a runtime exception due to not defining the type of Box class.
         * Variable "object" of class Box is set as Integer but casted as String.
         */
//        boxWithNoType.setObject(1);
//        String s = (String) boxWithNoType.getObject();
        BoxWithType<String> boxWithType = new BoxWithType<>();
        boxWithType.setObject("");
        String s = boxWithType.getObject();
        System.out.print(s);
    }
}
