package leetCode.implement;

public class Q9 {

    public static void main(String[] args) {

        int x = -101;

        System.out.println(isPalindrome(x));

    }


    public static boolean isPalindrome(int x) {

        String xToString = Integer.toString(x);

        return x >= 0 && xToString.equals(new StringBuilder(xToString).reverse().toString());


    }
}
