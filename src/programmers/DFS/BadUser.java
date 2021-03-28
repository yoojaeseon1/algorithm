package programmers.DFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    헷갈렸던 부분
    - 조합이 아닌 순열로 풀어야 됐다.
        - user_id의 순서에 따라서도 경우에수가 생기므로
 */

public class BadUser {

    public static void main(String[] args) {

        BadUser test = new BadUser();


//        System.out.println(test.isMatchedPattern("abc1**", "frodoc"));

        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        System.out.println(test.solution(user_id, banned_id));

        test.bannedIdSet.clear();

        user_id = new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"};
        banned_id = new String[]{"*rodo", "*rodo", "******"};

        System.out.println(test.solution(user_id, banned_id));

        test.bannedIdSet.clear();
        user_id = new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"};
        banned_id = new String[]{"fr*d*", "*rodo", "******", "******"};
        System.out.println(test.solution(user_id, banned_id));


    }

    Set<String> bannedIdSet;

    public BadUser() {
        bannedIdSet = new HashSet<>();
    }

    public int solution(String[] user_id, String[] banned_id) {


        selectUserId(user_id, new String[banned_id.length], new boolean[user_id.length], 0, banned_id);


        return bannedIdSet.size();
    }

    public void selectUserId(String[] userId, String[] selectedId, boolean[] isSelected, int numSelected, String[] bannedId) {

        if(numSelected == selectedId.length){

            for(int banI = 0; banI < bannedId.length; banI++) {

                if(!isMatchedPattern(bannedId[banI], selectedId[banI])) {
                    return;
                }
            }


            String[] copiedSelectedId = new String[selectedId.length];

            System.arraycopy(selectedId, 0, copiedSelectedId, 0, selectedId.length);

            Arrays.sort(copiedSelectedId);

            StringBuilder bannedIds = new StringBuilder();

            for (String s : copiedSelectedId) {
                bannedIds.append(s);
            }

            bannedIdSet.add(bannedIds.toString());

            return;

        } else {



            for(int userI = 0; userI < userId.length; userI++) {

                if(!isSelected[userI]) {
                    selectedId[numSelected] = userId[userI];
                    isSelected[userI] = true;
                    selectUserId(userId, selectedId, isSelected, numSelected+1, bannedId);
                    isSelected[userI] = false;
                }
            }

        }

    }

    public boolean isMatchedPattern(String pattern, String id) {

        if(pattern.length() != id.length())
            return false;


        for(int patternI = 0; patternI < pattern.length(); patternI++) {

            char currentPattern = pattern.charAt(patternI);

            if(currentPattern == '*')
                continue;

            if(currentPattern != id.charAt(patternI))
                return false;

        }

        return true;

    }


}
