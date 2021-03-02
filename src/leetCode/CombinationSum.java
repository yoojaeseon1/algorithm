package leetCode;

import java.util.*;

/**
 *
 * 헷갈렸던 부분
 * - 순열 / 조합 코드 헷갈림 : 조합으로 짜야 되는데 순열 코드로 작성했다.
 *
 * 해결 방법
 * - 조합은 한 번 검토(선택할지 말지)했던 element는 다시 검토하지 않는다.
 * - 순열은 반복문을 처음부터 돌면서 다시 검토할 수 있다.
 *
 */

public class CombinationSum {

    public static void main(String[] args) {

        CombinationSum combinationSum = new CombinationSum();

//        int[] candidates = {10,1,2,7,6,1,5};

//        int target = 8;

        int[] candidates = {2,5,2,1,2};

        int target = 5;

        List<List<Integer>> lists = combinationSum.combinationSum2(candidates, target);

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        Map<Integer, String> map = new TreeMap<>();

    }

    private Set<String> combiSet;

    public CombinationSum() {
        combiSet = new HashSet<>();
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        findElementsSumTarget(candidates, new int[candidates.length], 0, 0, target, 0);

        List<List<Integer>> combiList = new ArrayList<>();

        for (String s : combiSet) {
            List<Integer> combination = new ArrayList<>();
            StringBuilder number = new StringBuilder();
            for(int si = 0; si < s.length(); si++) {
                char currentChar = s.charAt(si);
                if(currentChar == ','){
                    combination.add(Integer.parseInt(number.toString()));
                    number.setLength(0);
                } else {
                    number.append(currentChar);
                }
            }
            combination.add(Integer.parseInt(number.toString()));
            combiList.add(combination);
        }

        Collections.sort(combiList, new Comparator<List<Integer>>(){

            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {

                if(o1.size() != o2.size())
                    return Integer.compare(o2.size(), o1.size());
                else {
                    for(int oi = 0; oi < o1.size(); oi++) {
                        int elementO1 = o1.get(oi);
                        int elementO2 = o2.get(oi);
                        if(elementO1 != elementO2)
                            return Integer.compare(elementO1, elementO2);
                    }
                }

                return 0;
            }
        });


        return combiList;
    }

    public void findElementsSumTarget(int[] candidates, int[] selectedIndices, int selectedIndex,  int targetIndex, int target,
                                      int sumElement) {

        if(sumElement == target) {
            int[] nums = new int[selectedIndex];
            for(int selectedI = 0; selectedI < selectedIndex; selectedI++) {
                nums[selectedI] = candidates[selectedIndices[selectedI]];
            }

            Arrays.sort(nums);

            StringBuilder numsToStr = new StringBuilder();

            for(int numsI = 0; numsI < nums.length - 1; numsI++) {
                numsToStr.append(nums[numsI] +",");
            }

            numsToStr.append(nums[nums.length-1]);

            combiSet.add(numsToStr.toString());

            return;

        } else if(sumElement > target || targetIndex == candidates.length)
            return;

        selectedIndices[selectedIndex] = targetIndex;

        findElementsSumTarget(candidates, selectedIndices, selectedIndex+1, targetIndex+1, target, sumElement+candidates[targetIndex]);

        findElementsSumTarget(candidates, selectedIndices, selectedIndex, targetIndex+1, target, sumElement);


    }
}
