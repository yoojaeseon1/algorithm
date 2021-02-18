package leetCode;

public class ReverseInteger {

    public static void main(String[] args) {

//        long num = 5L;
//        int numToInt = (int)num;
//
//        System.out.println("numToInt = " + (num >= Integer.MIN_VALUE && num <= Integer.MAX_VALUE));

        System.out.println(reverse(0));

    }

    public static int reverse(int x) {

        StringBuilder reversedNum = new StringBuilder();

        String xToString = Integer.toString(x);

        for(int xi = xToString.length()-1; xi > 0; xi--) {
            reversedNum.append(xToString.charAt(xi));
        }

        if(x > 0)
            reversedNum.append(xToString.charAt(0));
        else
            reversedNum.insert(0, xToString.charAt(0));


        long reversedToLong = Long.parseLong(reversedNum.toString());

        if(reversedToLong >= Integer.MIN_VALUE && reversedToLong <= Integer.MAX_VALUE)
            return (int) reversedToLong;

        return 0;
    }
}
