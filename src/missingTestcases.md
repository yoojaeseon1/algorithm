### 보통 제한 사항 잘 읽고, 예제 모두 손으로 써가면서 돌려보면 해결된다.


#### 문자열 압축

1.숫자+문자에서 숫자가 두자리 이상인 조건 안넣어서

-> 해결 : 숫자가 두자리 이상인 경우에는 그에 맞게 답의 길이가 늘어나도록 수정

---

#### 자물쇠와 열쇠

1. 구현 방식이 문제 있었다. -> 해결 : 해설보고 다시 구현

2. 제한 사항 중 M <=N 인데 M==N 인 경우만 생각했었다.

-> 해결 : M < N인 경우도 포함해 구현

3. rotete90Degree 메소드에서 source(key) 배열의 길이가 홀수 일 경우 rotated 배열 중심 좌표는 초기화 되지 않았다.

-> 해결 : source의 길이가 홀수 일 경우 rotated의 중심좌표 = source의 중심좌표


---

#### 디스크 컨트롤러(DiskController)

		while (!jobsQueue.isEmpty()) { // loop 1

			while (!jobsQueue.isEmpty()) { // loop 2
				int[] currentJob = jobsQueue.poll();
				startTime = endTime;
				endTime = startTime + currentJob[1];
				computedTime += endTime - currentJob[0];
				while (jobsI < jobs.length && jobs[jobsI][0] > startTime
						&& jobs[jobsI][0] <= endTime) {
					jobsQueue.add(jobs[jobsI++]);
				}
			}

			if (jobsI < jobs.length) { // condition 1
				startTime = jobs[jobsI][0];
				endTime = jobs[jobsI][0];
			}

			while (jobsI < jobs.length && jobs[jobsI][0] == startTime) { // loop 3
				jobsQueue.add(jobs[jobsI++]);
			}
		}


- loop 3에서 jobs배열의 끝까지 추가가 되어 큐가 비어있지 않음에도 불구하고 loop 1의 조건이 jobsI < jobs.length였을 때

루프 안으로 들어가지 않아서 오류가 발생했다.


- 중간에 실행시간이 비었다가 다시 시작하는 경우 loop2에서의 startTime은 이전 작업의 endTime으로 바뀌기 때문에

startTime의 수정이 필요했다.

- 중간에 실행시간이 비었다가 다시 시작하는 경우 startTime은 비었다가 다시 시작하는 그 작업의 요청시간으로 하면 되기 때문에  
condition 1의 if문에 endTime에 대한 초기화를 추가해줬다.

##### 근본적인 문제

- 제한 사항(실행중인 작업이 없을 경우 요청시간이 가장 빠른 것부터 실행한다.)을 꼼꼼히 읽어서 예외 케이스가 없는지 확인하자.

---

#### 라면 공장(RemenFactoryFail)

Fail code에서

        for(int datesI = 0; datesI < dates.length; datesI = supplyIndex+1) { // problem 1
            
            int supplyAmount = -1;
        
            while(true) {
                if(datesI < dates.length && dates[datesI] <= today+stock) {
                    if(supplyAmount < dates[datesI] + supplies[datesI])
                        supplyAmount = supplies[datesI];
                        supplyIndex = datesI; // problem 2
                        
                } else
                    break;
                datesI++;
            }
            
            today += stock;
            stock = supplyAmount;
            numSupplyment++;
            
            if(today+stock >= k)
                return numSupplyment;
        }
		return supplyIndex;

- problem 1

	datesI = supplyIndex+1;

밑의 while문에서 공급받을 수 있는 범위를 정하고 그 안에서 최선의 선택인 한 날짜에만 공급을 받았다.

그리고 그 범위 다음 인덱스부터 공급받을 날을 선택했는데

그 이후의 인덱스에서 여러 번 공급받아야 할 수도 있다.

이전의 인덱스에서 차선이 되는 공급도 같이 받았을 경우 최소한의 공급횟수를 만들 수도 있기 때문에

실패한 코드다.

- problem 2

이 부분에서 최선의 선택인 인덱스를 초기화한다.

##### 근본적인 문제 

예외 케이스를 생각하는 능력 부족

---

#### 벽부수고 이동하기(백준 2206)

BFS를 통한 탐색문제

경로별로 부수는 벽이 다를 수 있는데 하나의 2차원배열(field)로 경로계산을 다 하니까 정확한 계산이 되지 않았다.

- 해결책

field배열은 건드리지말고 움직이는 경로별로 인스턴스(Coordinate)를 만들어 이동하는 거리를 계산하고 먼저 도착하는 인스턴스의

거리를 최단경로로 잡았다.


##### 근본적인 문제

예외 케이스를 생각하는 능력 부족

---


#### 캐시(kakao2018Blind)

- LRU 캐시 알고리즘 문제


		public int solution(int cacheSize, String[] cities) {
     
      		if(cacheSize == 0) 
          		return 5*cities.length;
      
      		int answer = 0;
      		List<String> LRUList = new ArrayList<>();
      
      		for(int citiesI = 0; citiesI < cities.length; citiesI++) {
          		String cityToLowerCase = cities[citiesI].toLowerCase();
          		int indexOfElement = LRUList.indexOf(cityToLowerCase);
          
         		 if(indexOfElement >= 0) {
              		LRUList.remove(indexOfElement);
              		LRUList.add(cityToLowerCase);
              		answer++;
          		} else {
              		if(LRUList.size() < cacheSize)
                  	LRUList.add(cityToLowerCase);
              		else {
                  		LRUList.remove(0);
                  		LRUList.add(cityToLowerCase);
              			}
              		answer += 5; 
          		}
      		}
			return answer;
		}

cash hit : 메모리에 이미 들어있는 데이터를 갱신하는 경우(메모리에 올라오는 속도가 빠르다.)

cash miss : 메모리에 없는 데이터를 추가하는 경우(메모리에 올라오는 속도가 hit에 비해 느리다.)


cashSize가 0인 경우는 메모리에 들어오지 않기 때문에 항상 cache miss가 발생한다.

그러므로 맨 위 처럼 5*cashSize로 처리해서 끝내면 되는 문제였다.

입력형식(제한사항)에서 caseSize의 범위를 민감하게 봐야했다.

##### 근본적인 문제

제한사항(입력형식 등)을 민감하게 확인하는 습관 부족(예외 케이스를 생각 하는 능력과 직관된다.)

---