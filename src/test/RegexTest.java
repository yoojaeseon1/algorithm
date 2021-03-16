package test;

import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {

        String str = "1+2+55-3***1";

        String[] splited = str.split("[\\+\\*\\-]{1}");

        for (String s : splited) {
            System.out.println("s = " + s);
        }

    }
}
