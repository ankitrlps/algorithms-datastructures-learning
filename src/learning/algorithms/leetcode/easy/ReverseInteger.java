package learning.algorithms.leetcode.easy;

public class ReverseInteger {
    public static void main(String[] args) {
        int i = 15342369;
        StringBuilder res = new StringBuilder();
        int finalRes = 0;
        if(i < 0){
            i = i * -1;
            res.append("-");
        }
        while (i > 0){
            res.append(i % 10);
            i = i / 10;
        }
        try{
            finalRes = Integer.parseInt(res.toString());
        } catch (Exception e){
            finalRes = 0;
        }
        System.out.println(finalRes);
        System.out.println(reversInteger(15236469));
    }

    public static int reversInteger(int x){
        int res = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        while (x != 0){
            int remainder = x % 10;
            if(res > max/10 || (res == max/10 && remainder > 7)) return 0;
            if(res <= min/10 && remainder < -8) return 0;
            res = (res * 10) + remainder;

            x = x / 10;
        }
        System.out.println(res);
        return res;
    }
}
