package leetCode;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * 헷갈렸던 부분
 * - MyCalendarTwo를 먼저 풀고와서 이 것도 Map으로 처리
 * - 겹치는게 아예 있으면 안되는 것이기 때문에 list으로 전체를 탐색해서 하나라도 겹치면 안되는 것으로 풀어도 된다.
 * 
 * 해결 방법
 * - 기존 스케쥴을 list에 추가하고 새로 추가할 때마다 기존 스케쥴과 겹치는지 체크
 *
 */


public class MyCalendar {

    private List<int[]> schedules;

    public MyCalendar() {
        schedules = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        for(int[] schedule : schedules) {
            if(schedule[0] < end && schedule[1] > start)
                return false;

        }
        schedules.add(new int[]{start, end});
        return true;
    }

}
