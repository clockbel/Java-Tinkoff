package edu.hw1;

public class Task5 {
    public static boolean isPalindromeDescendant(int number) {
        String numStr = String.valueOf(number);
        boolean flag = false;
        if (checkPolindrom(numStr)) {
            flag = true;
        } else {
            String descendant = getDescendant(numStr);
            while (descendant != null && !flag) {
                if (checkPolindrom(descendant)) {
                    flag = true;
                } else {
                    descendant = getDescendant(descendant);
                }
            }
        }
        return flag;
    }

    private static boolean checkPolindrom(String str) {
        boolean ans = false;
        if (str.length() != 1) {
            ans = str.equals(new StringBuilder(str).reverse().toString());
        }
        return ans;
    }

    private static String getDescendant(String numStr) {
        boolean flag = true;
        StringBuilder descendant = new StringBuilder();
        if (numStr.length() == 1) {
            flag = false;
        } else {
            for (int i = 0; i < numStr.length() - 1; i += 2) {
                int digit1 = Character.getNumericValue(numStr.charAt(i));
                int digit2 = Character.getNumericValue(numStr.charAt(i + 1));
                descendant.append(digit1 + digit2);
            }
        }
        return flag ? descendant.toString() : null;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeDescendant(11));
    }
}
