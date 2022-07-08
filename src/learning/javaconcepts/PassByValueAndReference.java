package learning.javaconcepts;

public class PassByValueAndReference {

    private int byValue(int i) {
        i = (i + 2);
        System.out.println("by value: " + i);
        return i+3;
    }

    public static void main(String[] args) {
        PassByValueAndReference andReference = new PassByValueAndReference();
        System.out.println("result: " + andReference.byValue(-1));
    }
    
}
