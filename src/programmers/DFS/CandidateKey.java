package programmers.DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

    헷갈렸던 부분
    - DFS식 조합(1개 뽑는 경우의 수 전부 ~ n개 뽑는 경우의 수 전부)을 했어야 했다.(최소성의 원칙)
    - 복합키를 만들 때, 해당 조합의 부분 복합키들이 정답에 있는지 확인해야 했다.(최소성의 원칙)

    포인트
    - 유일성 체크
        - 조합으로 선택한 column의 값들을 하나로 합쳐서 String을 만들고 set에 넣어 튜플 개수만큼 넣었을 때 실제 튜플의 개수(relation.length)와 같은지 확인
    - 희소성의 원칙에 필요한 조건 추가
        - 헷갈렸던 부분에 있는 내용

 */

public class CandidateKey {

    public static void main(String[] args) {

        CandidateKey test = new CandidateKey();

        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

        System.out.println(test.solution(relation));


    }

    private List<Integer> columns;
    private Set<Integer> columnSet;
    private List<String> candidateKeys;

    public CandidateKey() {

        columns = new ArrayList<>();
        columnSet = new HashSet<>();
        candidateKeys = new ArrayList<>();
    }

    public int solution(String[][] relation) {


        for(int column = 0; column < relation[0].length; column++) {
            columns.add(column);
        }

        for(int r = 1; r <= relation[0].length; r++) {

            if(columns.size() < r)
                break;

            selectRow(relation, r, 0, new int[r], 0);

            columns.clear();
            columns.addAll(columnSet);
            columnSet.clear();

        }



        return candidateKeys.size();

    }

    public void selectRow(String[][] relation, int r, int selectedIndex, int[] selectedIndices, int targetIndex) {

        if(r == 0) {

            List<String> candidates = new ArrayList<>();

            selectIndices(selectedIndices, 0, new StringBuilder(), candidates);

            for (String candidate : candidates) {
                if(candidateKeys.contains(candidate))
                    return;
            }

            Set<String> tupleSet = new HashSet<>();

            for(int row = 0; row < relation.length; row++) {

                StringBuilder content = new StringBuilder();

                for(int selectedI = 0; selectedI < selectedIndex; selectedI++) {
                    int column = columns.get(selectedIndices[selectedI]);

                    content.append(relation[row][column]);

                }


                tupleSet.add(content.toString());

            }

            if(tupleSet.size() == relation.length) {


                StringBuilder candidateKey = new StringBuilder();
                for(int selectedI = 0; selectedI < selectedIndex; selectedI++) {

                    int column = columns.get(selectedIndices[selectedI]);

                    candidateKey.append(column);
                }


                candidateKeys.add(candidateKey.toString());

            } else {
                for(int selectedI = 0; selectedI < selectedIndex; selectedI++) {
                    columnSet.add(columns.get(selectedIndices[selectedI]));
                }
            }
            return;


        } else if(targetIndex == columns.size())
            return;
        else {

            selectedIndices[selectedIndex] = targetIndex;

            selectRow(relation, r-1, selectedIndex+1, selectedIndices, targetIndex+1);

            selectRow(relation,  r, selectedIndex, selectedIndices, targetIndex+1);


        }

    }

    public void selectIndices(int[] columns, int nextSelctedI, StringBuilder selectedColumns, List<String> candidates) {

        if(nextSelctedI > 0) {

            candidates.add(selectedColumns.toString());

        }

        for(int selectedI = nextSelctedI; selectedI < columns.length; selectedI++) {

            selectedColumns.append(this.columns.get(columns[selectedI]));
            selectIndices(columns, selectedI+1, selectedColumns, candidates);
            selectedColumns.deleteCharAt(selectedColumns.length()-1);

        }
    }
}
