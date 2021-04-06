package programmers.implementation;

import java.util.*;

public class MenuRenewal {

    public static void main(String[] args) {

        MenuRenewal test = new MenuRenewal();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};

//        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        int[] course = {2,3,5};

//        String[] orders = {"XYZ", "XWY", "WXA"};
//        int[] course = {2,3,4};

        test.solution(orders, course);

    }

    private List<String> menuCandidates;

    public MenuRenewal() {
        menuCandidates = new ArrayList<>();
    }

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for(int ordersI = 0; ordersI < orders.length; ordersI++) {
            String order = orders[ordersI];
            for(int courseI = 0; courseI < course.length; courseI++) {
                int numMenu = course[courseI];
                selectMenu(order, order.length(), numMenu, new int[numMenu], 0,0);
            }
        }


        Map<String, Integer> menuToCount = new HashMap<>();

        for (String menu : menuCandidates) {
            int count = menuToCount.getOrDefault(menu, 0);

            menuToCount.put(menu, count+1);
        }

        List<MenuCandidate> menuCandidates = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : menuToCount.entrySet()) {

            String menu = entry.getKey();
            int count = entry.getValue();

            if(count > 1)
                menuCandidates.add( new MenuCandidate(menu, count));
        }

        Collections.sort(menuCandidates);

        int beforeLength = 0;
        int beforeCount = 0;

        if(menuCandidates.size() > 0) {
            beforeLength = menuCandidates.get(0).getName().length();
            beforeCount = menuCandidates.get(0).getCount();
            answer.add(menuCandidates.get(0).getName());
        }

        for(int menuI = 1; menuI < menuCandidates.size(); menuI++) {
            MenuCandidate menuCandidate = menuCandidates.get(menuI);

            if(menuCandidate.getName().length() == beforeLength
                    && menuCandidate.getCount() == beforeCount) {

                answer.add(menuCandidate.getName());

            } else if(menuCandidate.getName().length() != beforeLength) {

                beforeLength = menuCandidate.getName().length();
                beforeCount = menuCandidate.getCount();
                answer.add(menuCandidate.getName());
            }
        }

        Collections.sort(answer);

        return answer.toArray(new String[answer.size()]);
    }


    public void selectMenu(String order, int n, int r, int[] selectedIndices, int selectedIndex, int targetIndex) {

        if(r == 0) {
            char[] menus = new char[selectedIndex];
            for(int selectedI = 0; selectedI < selectedIndex; selectedI++) {
                menus[selectedI] = order.charAt(selectedIndices[selectedI]);
            }

            Arrays.sort(menus);

            menuCandidates.add(String.valueOf(menus));

        } else if(targetIndex == n) {
            return;
        } else {

            selectedIndices[selectedIndex] = targetIndex;

            selectMenu(order, n, r - 1, selectedIndices, selectedIndex + 1, targetIndex + 1);
            selectMenu(order, n, r, selectedIndices, selectedIndex, targetIndex + 1);
        }

    }


}

class MenuCandidate implements Comparable<MenuCandidate> {
    private String name;
    private int count;

    public MenuCandidate() {
    }

    public MenuCandidate(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(MenuCandidate o) {

        if(this.name.length() == o.name.length())
            return Integer.compare(o.count, this.count);

        return Integer.compare(o.name.length(), this.name.length());

    }
}
