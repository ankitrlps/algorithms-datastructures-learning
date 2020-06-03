package learning.javaconcepts;

import java.util.BitSet;

public class BitAndByte {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet(8);
        bitSet.set(0);
        for (int i = 0; i < bitSet.size(); i++){
            System.out.print(bitSet.get(i) ? 1 : 0);
        }
    }
}
