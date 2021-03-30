package programmers.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*

    헷갈렸던 부분
    - ctrl+커서 로 이동할 때 메소드로 만들어야 했다.
    - while문을 벗어날 조건이 2개(범위 밖, 카드만나기)이기 때문에 나와서도 뭐 때문에 while문을 나온건지 또 확인해야 했다.

    해결 방법
    - ctrl+커서 이동 부분을 메소드로 만들어 해당 조건인 부분에서 바로 return해버린다.

    포인트
    - open해야할 카드의 순서를 permutation으로 경우의 수를 전부 정리할 수 있다.(카드의 종류가 6가지이므로 시간초과나지 않는다.)
    - 종류별로 2장씩 있으므로 2장의 순서를 뒤집어서 생기는 순서도 따로 만들어야 한다.
    - ctrl+커서 이동 부분을 메소드로 만들어 while문 밖에서 while을 나온 조건을 다시 확인하지 않도록 한다.
    - open한 카드는 0으로 초기화해서 ctrl+커서 이동할 때 통과할 수 있도록 한다.
        - 경우의 수마다 복사된 board를 사용해서 open한 카드를 0으로 초기화한다.

 */

public class MatchingCardPair {

    public static void main(String[] args) {

        MatchingCardPair test = new MatchingCardPair();

        int[][] board = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
        int r = 1;
        int c = 0;

        System.out.println(test.solution(board, r, c));

        board = new int[][]{{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}};
        r = 0;
        c = 1;

        System.out.println(test.solution(board, r, c));
    }


    private List<PositionCardPair[]> searchSequences;
    private int[] dr = {-1,0,1,0};
    private int[] dc = {0,1,0,-1};

    public MatchingCardPair() {
        searchSequences = new ArrayList<>();
        dr = new int[]{-1,0,1,0};
        dc = new int[]{0,1,0,-1};
    }

    public int solution(int[][] board, int r, int c) {

        PositionCardPair[][] cardTypePosition = new PositionCardPair[7][2];
        int numCardType = 0;

        for(int boardI = 0; boardI < board.length; boardI++) {
            for(int boardJ = 0; boardJ < board[boardI].length; boardJ++) {
                int cardNumber = board[boardI][boardJ];
                if(cardNumber> 0) {

                    if(cardTypePosition[cardNumber][0] == null) {
                        numCardType++;
                        cardTypePosition[cardNumber][0] = new PositionCardPair(boardI,boardJ);
                    } else {
                        cardTypePosition[cardNumber][1] = new PositionCardPair(boardI, boardJ);
                    }

                }
            }
        }


        selectCardType(cardTypePosition, new int[numCardType], new boolean[7], 0, numCardType);


        Queue<PositionCardPair> boardQueue = new LinkedList<>();
        boolean[][] isVisited = new boolean[4][4];
        int minNumMoved = Integer.MAX_VALUE;


        for(int searchI = 0; searchI < searchSequences.size(); searchI++) {

            PositionCardPair[] route = searchSequences.get(searchI);


            int startR = r;
            int startC = c;
            int[][] copiedBoard = new int[4][4];

            for(int boardI = 0; boardI < board.length; boardI++) {
                for(int boardJ = 0; boardJ < board[boardI].length; boardJ++) {
                    copiedBoard[boardI][boardJ] = board[boardI][boardJ];
                }
            }



            int currentNumMoved = 0;
            for(int routeI = 0; routeI < route.length; routeI++) {
                int endR = route[routeI].getR();
                int endC = route[routeI].getC();

                isVisited = new boolean[4][4];

                boardQueue.add(new PositionCardPair(startR, startC, 0));
                isVisited[startR][startC] = true;

                while(!boardQueue.isEmpty()) {

                    PositionCardPair position = boardQueue.poll();
                    int currentR = position.getR();
                    int currentC = position.getC();
                    int numMoved = position.getNumMoved();

                    if(currentR == endR && currentC == endC) {
                        boardQueue.clear();
                        currentNumMoved += numMoved+1;
                        copiedBoard[currentR][currentC] = 0;

                        break;
                    }

                    for(int di = 0; di < dr.length; di++) {

                        int movedR = currentR + dr[di];
                        int movedC = currentC + dc[di];

                        if(movedR >= 0 && movedR < board.length && movedC >= 0 && movedC < board[0].length && !isVisited[movedR][movedC]) {

                            isVisited[movedR][movedC] = true;

                            boardQueue.add(new PositionCardPair(movedR, movedC, numMoved+1));

                        }

                        int[] addCtrl = findCard(copiedBoard, currentR, currentC, di);

                        if(addCtrl[0] != currentR || addCtrl[1] != currentC) {

                            boardQueue.add(new PositionCardPair(addCtrl[0], addCtrl[1], numMoved+1));
                            isVisited[addCtrl[0]][addCtrl[1]] = true;
                        }

                    }

                }

                startR = endR;
                startC = endC;


            }

            minNumMoved = Math.min(minNumMoved, currentNumMoved);

        }
        return minNumMoved;
    }

    public int[] findCard(int[][] board, int r, int c, int di) {

        r += dr[di];
        c += dc[di];

        while(r >= 0 && r < 4 && c >= 0 && c < 4) {
            if(board[r][c] != 0)
                return new int[]{r,c};
            r += dr[di];
            c += dc[di];
        }

        return new int[]{r - dr[di], c - dc[di]};

    }

    public void selectCardType(PositionCardPair[][] cardTypePosition, int[] selectedTypes, boolean[] isSelected, int numSelected, int maxNumSelected) {

        if(numSelected == maxNumSelected) {

            selectDetailCard(cardTypePosition, new PositionCardPair[maxNumSelected*2], 0, selectedTypes, 0);


            return;

        }

        for(int cardI = 1; cardI < cardTypePosition.length; cardI++) {

            if(cardTypePosition[cardI][0] != null && !isSelected[cardI]) {

                selectedTypes[numSelected] = cardI;
                isSelected[cardI] = true;
                selectCardType(cardTypePosition, selectedTypes, isSelected, numSelected+1, maxNumSelected);
                isSelected[cardI] = false;


            }
        }

    }

    public void selectDetailCard(PositionCardPair[][] cardTypePosition, PositionCardPair[] searchSequence, int sequenceI, int[] selectedTypes, int selectedIndex) {

        if(selectedIndex == selectedTypes.length) {

            PositionCardPair[] sequence = new PositionCardPair[searchSequence.length];

            System.arraycopy(searchSequence, 0, sequence, 0, searchSequence.length);

            searchSequences.add(sequence);

            return;

        }

        searchSequence[sequenceI] = cardTypePosition[selectedTypes[selectedIndex]][0];
        searchSequence[sequenceI+1] = cardTypePosition[selectedTypes[selectedIndex]][1];

        selectDetailCard(cardTypePosition, searchSequence, sequenceI+2, selectedTypes, selectedIndex+1);

        searchSequence[sequenceI] = cardTypePosition[selectedTypes[selectedIndex]][1];
        searchSequence[sequenceI+1] = cardTypePosition[selectedTypes[selectedIndex]][0];

        selectDetailCard(cardTypePosition, searchSequence, sequenceI+2, selectedTypes, selectedIndex+1);



    }
}

class PositionCardPair{

    private int r;
    private int c;
    private int numMoved;

    public PositionCardPair(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public PositionCardPair(int r, int c, int numMoved) {
        this.r = r;
        this.c = c;
        this.numMoved = numMoved;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public int getNumMoved() {
        return numMoved;
    }

}