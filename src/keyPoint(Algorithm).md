#### 문제 풀 때

1. 문제 설명을 집중해서 읽고 이해한 다음 예제의 입력 값, 출력 값을 확인해서 설명을 정확히 이해했는지 확인하자

2. 작성한 알고리즘에 문제가 있을 경우 예시 입력 값을 직접 손으로 계산해보자



---

#### BFS / DFS

- 탐색 할 때는 enqueue/push 된 노드만 체크하면 된다.
: enqueue/push = 방문예정이기 때문에 visited의 의미도 가지고 있는 것이므로
한번 enqueue/push 된 노드를 다시 enqueue/push 하지 않으면 된다.(visited 따로 체크 불필요)

						for (int di = 0; di < dx.length; di++) {
							if (currentX + dx[di] >= 0 && currentX + dx[di] < n && currentY + dy[di] >= 0
									&& currentY + dy[di] < n) {
								if (field[currentY + dy[di]][currentX + dx[di]]
										&& !isEnqueued[currentY + dy[di]][currentX + dx[di]]) {
									int[] enqueuedPosition = new int[2];
									enqueuedPosition[0] = currentX + dx[di];
									enqueuedPosition[1] = currentY + dy[di];
									searchingQueue.add(enqueuedPosition);
									isEnqueued[currentY + dy[di]][currentX + dx[di]] = true;
								}
							}
						}

---

##### DFS(재귀)

	재귀로 DFS를 짤 때
	
	같은 메소드에서 재귀가 여러번 실행 될 때는 visited의 조건을 같게 해줘야 하기 때문에
	
	visited(push 체크)를 체크해준후 메소드를 실행하고 다름 루프가 돌기 전에 원래(방문하지 않은)상태로 초기화 해줘야 한다.
	
			for(int wi = 0; wi < visitSequence.length; wi++) {
			if(checkEqualWord(source, words[wi]) && visitSequence[wi] == 0) {
			
				visitSequence[wi] = visitCount + 1; // visited 푸시한 것으로 체크
				dfs(words[wi], visitSequence, visitCount+1);
				visitSequence[wi] = 0; // 다음 루프로 넘어가기 전에 푸시하지 않은 것으로 원상복귀
			}
		}

---

##### BFS/DFS 영역 구하는 문제

0 : enqueue/push 되지 않고 방문하지 않은 영역

1 : enqueue/push 했지만 방문하진 않은 영역

2 : 방문 한 영역 

field의 값을 위와 같이 초기화 하고

dequeue(queue.poll())/pop 할 때 : 2로 초기화(방문)와 방문한 영역의 count

주위 영역을 enqueue(add(e) or offer(e))/push 할 때 : 1로 초기화

0,1,2로 구분을 해줘야 나중에 문제가 발생했을 때 디버깅하기 편하다.
		
		
##### visited 배열을 deepCopy할 필요가 없는 이유

어차피 depth로 자식 노드가 없을 때까지 탐색하기 때문에 위의 코드에서처럼 visited를 0(false)으로 다시 초기화 해주면 해당 노드를 방문하지 않은 것으로 하고 

다른 노드로의 재귀를 이어갈 수 있기 때문에 deepcopy로 필요없는 연산을 할 필요가 없다.



BFS를 비재귀로 위와 같은 방식으로 한다면 deepcopy가 필요하긴 하지만 그렇게 탐색을 해야할 문제가 있을지 의문이다.(아무리 생각해도 없다.)

#### Backtraking

핵심 : 탐색하지 않는 조건을 만들어서 탐색 횟수를 줄이는 것

조건에 맞는 깊이로 탐색을 진행한다 > 마지막 레벨까지 탐색 > 탐색한 값 출력 > 끝

백트래킹은 DFS를 사용 했을 때 해당 노드의 단말노드까지 들어갔다가 새로운 형제의 노드로 돌아와서 탐색하는 과정이다.

DFS가 아니어도 구현 가능하지만 DFS에서 Stack을 사용하는 논리와 가장 유사하다.

비 재귀로 구현할 경우 백트래킹 되는 지점에서 DFS되었던 모든 노드에 대한
방문기록 삭제

	visited[y][x] = false;

를 해야한다.

재귀로 구현할 경우 재귀로 실행되는 메소드 아래에 해당 노드의 방문을 삭제하는 코드를 작성하면 백트래킹 되면서 순서대로 방문취소가 된다.

			if(x+dx[i] >= 0 && x+dx[i] < c && y+dy[i] >= 0 && y+dy[i] < r) {
				if(!visited[board[y+dy[i]][x+dx[i]] - 'A']) {
					visited[board[y+dy[i]][x+dx[i]] - 'A'] = true;
					dfs(x+dx[i],y+dy[i], count+1,visited);
					visited[board[y+dy[i]][x+dx[i]] - 'A'] = false; // 백트래킹 되면서 실행되었던 노드가 실행순서 반대로 방문취소된다.
				}
			}
			
static 변수 중에서 자주 초기화되는 변수를 함수의 인자로 넣어야 할지 그냥 static으로 써야 할지 고민해보자
(static 변수는 자주 초기화되지 않는 경우에 쓰는 것이 좋다.(method영역에 올라가서 시스템이 종료 될 때 까지 지워지지 않으니까)) 

---

#### 그리디 알고리즘(greedy algorithm)

현재 상황에서 할 수 있는 최선의 선택을 하는 것(전체적으로 봤을 때 최적의 결과 값이 나오지 않을 수도 있다.)

ex) 회의실 배정 문제 : 현재 상황에서 가장 빨리 배정할 수 있는 회의를 배정한다.

		int earlist = 0; // 현재 가장 빨리 배정 가능한 시간
		int selected = 0;
		for(int i = 0; i < schedule.length; i++) { // schedule 배열은 오름차순정렬(1순위 : 종료시간, 2순위 : 시작시간)
			startTime = schedule[i][0];
			endTime = schedule[i][1];
			if(earlist <= startTime) {
				earlist = endTime;
				selected++;
			}
		}
		
---

#### DP

- 이전단계(바로전이 아닐 수도 있다.)까지 계산된 결과를 바탕으로 현재의 계산을 한다.

- 이 전의 결과가 하나만 있을 수도 있고 경우의 수에 따라 여러가지의 결과 값이 나올 수도 있다.


##### 배열을 사용하는 경우(memoization)

###### 1차원 배열

- 이 경우는 이전 index(직전 index가 아닐 수도 있다.)를 활용해서 풀면 된다.

- 이 전 까지 값 중 최대/최소 값과 현재 값을 이용해 문제를 푸는 경우(간단한 문제에서 많이 나온다.)

      int[] maxSales = new int[v.length];
      
      int maxSale = 0;
      for(int vI = 0; vI < maxSales.length; vI++) {
    	  maxSale = Math.max(maxSale, v[vI]);
    	  maxSales[vI] = maxSale;
      }
      
      int maxProfit = -999999999;
      for(int vI = 1; vI < v.length; vI++) {
    	maxProfit = Math.max(maxProfit, maxSales[vI-1] - v[vI]);  
      }
      
      return maxProfit;


###### 2차원 배열

	dp[di][dj] // 0~di 까지 범위를 사용해 dj값을 만드는 경우의 수  

ex) change(거스름돈) 문제에서

	dp[2][5] // money의 0~2까지 인덱스에 들어있는 값을 사용해서 5를 만들 수 있는 경우의 수

---

#### sorting


---

##### Arrays.sort() 메소드보다 QuickSort를 구현해서 정렬하는 것이 더 빠르다.

ex) K번째 수 문제

---

#### Floyd WarShall

그래프에서 모든 꼭지점 사이의 최단 경로를 찾는 알고리즘

초기화 하는 배열에는 startStop과 endStop사이의 경로가 없을 경우(값이 0일 경우)에 경로 값으로 나올 수 있는 최대 값을 넣어준다.(최소 비용을 구하기 때문에)

그리고 출력할 때는 최대 비용이면 0으로 출력하도록 조건을 넣어 출력한다.

		for (int throughStop = 1; throughStop < feesOfRoute.length; throughStop++) {

			for (int startStop = 1; startStop < feesOfRoute.length; startStop++) {

				for (int endStop = 1; endStop < feesOfRoute[startStop].length; endStop++) {
					if (startStop != endStop)
						feesOfRoute[startStop][endStop] = Math.min(feesOfRoute[startStop][endStop],
								feesOfRoute[startStop][throughStop] + feesOfRoute[throughStop][endStop]);
				}
			}
		}
		
ex) 1->4 사이의 최단 경로
	
	feesOfRoute[startStop][throughStop] + feesOfRoute[throughStop][endStop]


startStop -> throughStop -> endStop의 경로에서 최단 경로(최소 비용)을 찾는 것이다.

startStop -> throughStop은 각각 startStop-> endStop(throughStop)

	feesOfRoute[startStop][throughStop] + feesOfRoute[throughStop][endStop]

throughStop -> endStop은 각각 startStop(throughStop) -> endStop

	feesOfRoute[startStop][throughStop] + feesOfRoute[throughStop][endStop]

 으로 루프 내에서 최단 경로가 구해진 값을 더하기 때문에 두 값
 
	feesOfRoute[startStop][throughStop] + feesOfRoute[throughStop][endStop] 
 
 만 더해주면 된다.
 
#### combination

	doCombination(int[] source, int n, int r, int[] selectedIndice, int selectedIndex);
	
source : 원소를 선택할 배열

n : source 배열의 크기(전체 원소의 개수)

r : 선택할 원소의 개수(r <= n)

selectedIndice : 선택된 source의 index 들어갈 배열

seletedIndex : selectedIndice의 index, source에서 원소가 선택될 때마다 selectedIndex에 초기화 되고 1씩 증가 시켜준다.
			   (선택되지 않으면 source의 다음 인덱스(target)를 선택하므로 값을 증가시키지 않는다.)

 
#### 최대공약수 / 최소공배수
 
3개 이상의 수의 최대공약수 / 최소공배수는

두 수의 최대공약수 / 최소공배수를 구한 값과 나머지 값의 최대공약수 / 최소공배수를 구하면 된다.
 
 