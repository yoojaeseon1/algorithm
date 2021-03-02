package leetCode;

import java.util.regex.Pattern;

/**
 * 
 * 헷갈렸던 부분
 * - 정규표현식 패턴에 메타문자 사용시 \\ 추가해야 되는 것
 * 
 */

public class ValidateIpAddress {

    public static void main(String[] args) {

        ValidateIpAddress validateIpAddress = new ValidateIpAddress();

        String IP = "172.16.254.1";
//        String IP = "2001:0db8:85a3:0:0:8A2E:0370:7334";
//        String IP = "256.256.256.256";
//        String IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:";


        String[] split = IP.split(":");

        for (String s : split) {
            System.out.println("s = " + s);
        }


        System.out.println(validateIpAddress.validIPAddress(IP));

//        System.out.println(validateIpAddress.validateIPv4(IP));
//        System.out.println(validateIpAddress.validateIPv6(IP));

    }

    public String validIPAddress(String IP) {

        if(validateIPv4(IP))
            return "IPv4";

        if(validateIPv6(IP))
            return "IPv6";

        return "Neither";
    }

    public boolean validateIPv4(String IP) {

        if(IP.length() == 0 || IP.charAt(IP.length()-1) == '.')
            return false;


        String[] IPSplited = IP.split("\\.");

        String pattern = "[0-9]{1,3}";

        if(IPSplited.length == 4) {

            for(int ipI = 0; ipI < IPSplited.length; ipI++) {
                String oneOfSplited = IPSplited[ipI];


                if(!Pattern.matches(pattern, oneOfSplited)) {
                    return false;
                }

                if(oneOfSplited.length() >= 2 && oneOfSplited.charAt(0) == '0')
                    return false;

                int splitedToNum = Integer.parseInt(oneOfSplited);

                if(splitedToNum < 0 || splitedToNum > 255)
                    return false;

            }

        } else
            return false;

        return true;
    }

    public boolean validateIPv6(String IP) {
        String[] IPSplited = IP.split(":");
        String pattern = "[a-fA-F0-9]{1,4}";

        if(IP.length() == 0 || IP.charAt(IP.length()-1) == ':')
            return false;

        if(IPSplited.length == 8) {

            for(int ipI = 0; ipI < IPSplited.length; ipI++) {
                String oneOfSplited = IPSplited[ipI];

                if(!Pattern.matches(pattern, oneOfSplited))
                    return false;

            }

        } else
            return false;

        return true;

    }



}
