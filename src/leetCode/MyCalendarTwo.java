package leetCode;

import java.util.Map;
import java.util.TreeMap;


/**
 * 헷갈렸던 부분
 * - 제한 사항을 볼 때 boolean 배열로 전부 체크하면서 하는 것은 아니라는 것 확인
 * - 배열을 쓰지 않고 어떻게 접근해야 할지 감이 안왔다.
 * 
 * 해결 방법
 * - map을 사용해서 startTime : +1, endTime : -1
 * - TreeMap은 key(time) 순으로 정렬되어 있으므로 더해진 값이 3이상이면 3개가 겹친 것으로 파악하는 것
 *
 */

public class MyCalendarTwo {

    private Map<Integer, Integer> scheduleToCount;

    public MyCalendarTwo() {
        scheduleToCount = new TreeMap<>();
    }



    public static void main(String[] args) {

        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();

        System.out.println(myCalendarTwo.book(10,20));
        System.out.println("===========");
        System.out.println(myCalendarTwo.book(50,60));
        System.out.println("===========");
        System.out.println(myCalendarTwo.book(10,40));
        System.out.println("===========");
        System.out.println(myCalendarTwo.book(5,15));
        System.out.println("===========");
        System.out.println(myCalendarTwo.book(5,10));
        System.out.println("===========");
        System.out.println(myCalendarTwo.book(25,55));




    }

    public boolean book(int start, int end) {

        int startCount = scheduleToCount.getOrDefault(start, 0);
        int endCount = scheduleToCount.getOrDefault(end, 0);

        scheduleToCount.put(start, startCount + 1);
        scheduleToCount.put(end, endCount - 1);

        int numActiveBooking = 0;

        for(int time : scheduleToCount.values()) {
            numActiveBooking += time;

            if(numActiveBooking >= 3) {

                if(startCount == 0)
                    scheduleToCount.remove(start);
                else
                    scheduleToCount.put(start, startCount);

                if(endCount == 0)
                    scheduleToCount.remove(end);
                else
                    scheduleToCount.put(end, endCount);

                return false;
            }
        }
        return true;
    }

}
