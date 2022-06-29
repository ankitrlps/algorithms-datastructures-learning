package learning.algorithms;

public class NumberToWords {

    private String ones(int num) {
        switch (num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }

    private static String teens(int num) {
        switch (num) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        return "";
    }

    public String tens(int num) {
        switch(num) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }

    private String two(int num) {
        if (num < 10) {
            return ones(num);
        } else if (num < 20) {
            return teens(num);
        }

        int tenss = num/10;
        int oness = num - tenss * 10;

        if (tenss != 0 && oness != 0) {
            return tens(tenss) + " " + ones(oness);
        }
        if (tenss != 0 && oness == 0) {
            return tens(tenss);
        }
        return "";
    }

    private String threes(int num) {
        String result = "";
        int hundred = num / 100;
        int rest = num - hundred * 100;
        if (hundred != 0 && rest == 0) {
            result += ones(hundred) + " Hundred";
        } else if (hundred == 0 && rest != 0) {
            result += two(rest);
        } else {
            result += ones(hundred) + " Hundred " + two(rest);
        }
        return result;
    }


    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        String result = "";
        int billion = num / 1000000000;
        int million = (num - billion * 1000000000) / 1000000;
        int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
        int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

        if (billion != 0) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += threes(billion) + " Billion";
        }
        if (million != 0) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += threes(million) + " Million";
        }
        if (thousand != 0) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += threes(thousand) + " Thousand";
        }
        if (rest != 0) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += threes(rest);
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
