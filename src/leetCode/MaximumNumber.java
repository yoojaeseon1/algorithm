package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 문제 번호 : 1297
 *
 * 헷갈렸던 부분
 * - 다 하고나면 코드가 그렇게 길지 않은데 시간이 오래걸린다. 인덱스 가지고 노는게 머리가 너무 아프다.
 *
 * 포인트
 * - minSize만 체크하면 된다.
 *      - minSize + 1 ~ maxSize의 substring은 minSize의 substring을 포함하고 있다.
 *      - 그렇기 때문에 minSize + 1 ~ maxSize의 count는 minSize 이하다.
 *
 */

public class MaximumNumber {

    public static void main(String[] args) {

        MaximumNumber maximumNumber = new MaximumNumber();

        String s = "aababcaab";
        int maxLetters = 2;
        int minSize = 3;
        int maxSize = 4;

//        String s = "aaaa";
//        int maxLetters = 1;
//        int minSize = 3;
//        int maxSize = 3;

//        String s = "aabcabcab";
//        int maxLetters = 2;
//        int minSize = 2;
//        int maxSize = 3;

//        String s = "abcde";
//        int maxLetters = 2;
//        int minSize = 3;
//        int maxSize = 3;

//        String s = "abcabababacabcabc";
//        int maxLetters = 3;
//        int minSize = 3;
//        int maxSize = 10;

        System.out.println(maximumNumber.maxFreq(s,maxLetters,minSize,maxSize));


    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int maxFrequency = 0;

        Map<String, Integer> substringToCount = new HashMap<>();

//        for(int si = 0; si <= s.length() - minSize; si++) {
//            putCorrectSubstring(s, si, maxLetters, minSize);
//        }

        StringBuilder substringBuilder = new StringBuilder(s.substring(0, minSize));
        String substring = substringBuilder.toString();
        if(isCorrectSubstring(substring, maxLetters)){
            int numSubstring = substringToCount.getOrDefault(substring, 0);

            if(numSubstring > 0)
                substringToCount.put(substring, numSubstring+1);
            else
                substringToCount.put(substring, 1);
        }

        for(int si = 1; si <= s.length() - minSize; si++) {

            substringBuilder.deleteCharAt(0);
            substringBuilder.append(s.charAt(si+minSize-1));

            substring = substringBuilder.toString();
            if(isCorrectSubstring(substring, maxLetters)) {

                int numSubstring = substringToCount.getOrDefault(substring, 0);

                if(numSubstring > 0)
                    substringToCount.put(substring, numSubstring+1);
                else
                    substringToCount.put(substring, 1);
            }
        }

        for (Integer count : substringToCount.values()) {
            maxFrequency = Math.max(maxFrequency, count);
        }

        return maxFrequency;
    }

//    public void putCorrectSubstring(String s, int startIndex, int maxLetters, int minSize) {
//        boolean[] isUsedAlphabets = new boolean[26];
//        int numLetters = 0;
//
//        for(int si = startIndex; si < startIndex + minSize; si++) {
//            int currentAlphabetAscii = s.charAt(si) - 'a';
//
//            if(!isUsedAlphabets[currentAlphabetAscii]) {
//                numLetters++;
//                isUsedAlphabets[currentAlphabetAscii] = true;
//            }
//
//            if(numLetters > maxLetters)
//                return;
//        }
//
//        String substring = s.substring(startIndex, startIndex + minSize);
//        int numSubstring = substringToCount.getOrDefault(substring, 0);
//
//        if(numSubstring > 0)
//            substringToCount.put(substring, numSubstring+1);
//        else
//            substringToCount.put(substring, 1);
//
//    }

    public boolean isCorrectSubstring(String s, int maxLetters) {
        boolean[] isUsedAlphabets = new boolean[26];
        int numLetters = 0;

        for(int si = 0; si < s.length(); si++) {
            int currentAlphabetAscii = s.charAt(si) - 'a';

            if(!isUsedAlphabets[currentAlphabetAscii]) {
                numLetters++;
                isUsedAlphabets[currentAlphabetAscii] = true;
            }

            if(numLetters > maxLetters)
                return false;
        }

        return true;

    }
}
