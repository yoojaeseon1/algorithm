package programmers.implementation;

public class findKim {

    public String solution(String[] seoul) {

        for(int seoulI = 0; seoulI < seoul.length;seoulI++) {
            if(seoul[seoulI].equals("Kim"))
                return "김서방은 " + seoulI + "에 있다";

        }

        return "fail";
    }
}
