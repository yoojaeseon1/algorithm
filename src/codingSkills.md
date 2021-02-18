#### 알고리즘 문제 풀 때

##### 문제의 이해를 빨리 하고 나올 수 있는 예외를 확인하고 풀자

입력 값, 문제설명, 제한사항을 논리적으로 생각하자. 그냥 있는 그대로만 보지말고 어떻게 쓰일지를 생각하자

나올 수 있는 경우의 수, 예외를 다 확인해야 if문의 조건을 정확히 나눌 수 있다.

경우의 수, 예외를 모두 공책에 써서 확인하고 공책에 설계를 하자

ex) 3개,5개 채울 수 있는 상자의 개수를 최소로 짐을 채우는 문제(모바일리더 오프라인 3번문제)

##### 꼭 공책에 설계를 다 하고 타이핑을 시작하자

제발... 그래야 실수해서 돌아오거나 중간중간에 생각해서 낭비하는 시간을 줄일 수 있다.

##### index 가지고 조건을 만들어야 하는 문제

꼭 반드시 공책에 적어서 하나하나 인덱스를 표시해주고 인덱스 간의 관계를 살펴보자.

어렵다고 생각이 드는 문제는 인덱스 정리만 잘해도 보통 풀린다.

꼭 공책에 적어서!!!

안적고 생각으로만 해결하려다가 매번 망쳤다..제발

ex) 사다리게임(모바일리더 오프라인 1번문제)

##### 테스트케이스 예제는 손으로 직접 풀어보자

완전히 직접 풀어봐서 이해하고 설계를 시작하자

---

#### 문제를 풀기 시작할 때

메인 반복문에 들어가기 전에 초기화 해놓고 들어가는 변수에 민감해지자

      int pointStartIndex = 0;
      int totalPoint = 0;
      int beforePoint = 0;
      
      for(int dartResultI = 0; dartResultI < dartResult.length(); dartResultI++) {
			....
		}

beforePoint의 경우 맨 처음에 들어가면 이전 포인트가 없기 때문에 0으로 해놓으면 totalPoint에 더해줘도

영향이 없기 때문에 0으로 해놓고 index 0부터 반복문을 돌면 된다.


---

### 재귀를 사용하는 문제에서

재귀로 메소드를 계속 실행하다. 백트래킹하는 return문을 만드는 조건을 가장 신경쓰자.

---

#### String 가지고 노는 문제에서

구분의 기준이 되는 문자를 설정하자

다트게임문제에서

예제	 dartResult	answer	설명
1	 1S2D*3T	  37	11 * 2 + 22 * 2 + 33

dartResult로 주어지는 문자열을 쪼개서 답을 찾아야 하는데

보너스 점수가 되는 S,D,T를 기준으로 앞을 포인트, 뒤를 옵션으로 봐서 답을 찾을 수 있다.

기준이 되는 문자를 잡고 앞, 뒤로 연관된 문자를 찾자.




#### map

##### map을 굳이 쓰지 않아도 되는 경우

- 알파벳(a~z, A~Z), 숫자(0~9) 등 아스키코드 값으로 
- 에 접근 가능한 경우 배열을 사용하자
---

#### index 가지고 장난치기(the best 결과 값 제대로 안나오는 이유)

##### 배열

모듈러 연산자(%)
	
	int[] inputs = {1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,6,7,8,9,0};
	int[] patterns = {1,1,2,2,3,3,4,4,5,5};
	
와 같은 패턴일 때 input과 pattern이 같은 index에서 값이 같은지 확인하기 위해서는
	
	for(int inpustI = 0; inpustI < inpustI.length; inpustI++){
	
		if(inputs[inpustI] == patterns[inpustI%pattern.length]) answer++;
	}
	
과 같이 패턴의 길이로 모듈러 연산을 해주면 input의 해당 인덱스의 값과 일치하는지 확인할 수 있다.

	

##### 문자열

substring

기준 index를 가지고 원하는 문자열 뽑아내기

- 0부터 기준 index까지

	substring(0, index+1);
	
- 기준 index부터 끝까지

	substring(index);

- 뒤에서 부터 일정 길이(str.substring(str.length()-뒤에서 원하는 만큼 길이, str.length()))
	
	String test = "0123456";

	test.substring(test.length()-3, test.length()); // return "456";


#### 반복문을 돌면서 사용하고 있는 자료구조의 사이즈를 줄일 경우

- 반복문의 조건이 계속 줄어들어 원하지 않은 결과가 나온다.

		
		 
		 for (int removedI = 0; removedI < removedIndices.length()-1; removedI++)  {
		 
		
			 removedIndices.deleteCharAt(0);
			 System.out.println("removedI : " + removedI);
			 System.out.println("removedIndices : " + removedIndices);

			 for (int candidatesI = 0; candidatesI < candidates.size();candidatesI++) {

			 	if (candidates.get(candidatesI).contains(removedIndices.toString())){
			 		return;
				 }
		
			}
		}

removedIndicesLength를 처음에 따로 생성해두지 않으면 for문의 조건인 removedI < removedIndices.length()-1에서

removedIndices.length()가 deleteCharAt(0)이 되면서 1씩 줄어들기 때문에 for문의 조건도 1씩 줄어들어 결과적으론

remove증가 + removedIndices.length()감소로 인해 반복문이 절반만 돌게 된다.

	int removedIndicesLength = removedIndices.length();

을 생성하고 removedIndices.length()대신 넣어주면 조건이 변하지 않고 원하는 만큼 반복문을 돌 수 있다.


#### 조합할 수 있는 경우의 수는 combination 알고리즘으로 찾아야한다.

- 단순 반복문으로는 모든 조합을 찾을 수 없다.
	
	 System.out.println("to front");
	
	 int removedIndicesLength = removedIndices.length();

	 for (int removedI = 0; removedI < removedIndicesLength-1; removedI++)
	 {
	
		 removedIndices.deleteCharAt(0);
	 	System.out.println("removedI : " + removedI);
	 	System.out.println("removedIndices : " + removedIndices);
	 	for (int candidatesI = 0; candidatesI < candidates.size();candidatesI++) {
	
	 		if (candidates.get(candidatesI).contains(removedIndices.toString()))
	 		 return;
		}
	}


	System.out.println("to end");

	for(int removedI = removedIndices.length() - 1;removedI>=0;removedI--){

			removedIndices.deleteCharAt(removedI);
			removedIndices.deleteCharAt(removedI);
			System.out.println("removedIndices : " + removedIndices);
		for (int candidatesI = 0; candidatesI < candidates.size(); candidatesI++) {

		if (candidates.get(candidatesI).contains(removedIndices.toString())) {
				System.out.println("duplicated : ");
				return;
			}

		}
	}

위 두 반복문으로는 모든 조합을 찾을 수 없다.

deleteCharAt을 인덱스 순서대로 진행하기 때문에

(1,3) 또는 (2,5)와 같은 조합은 찾을 수 없다.

---

#### 배열의 초기화

	int[] test = {1,2,3,4}; // possible


	int[][] test2 = new int[2][];

	test2[0] = {1,2,3}; // impossioble

	test2[0] = new int[3];  // possible
	test2[0][0] = 1;
	test2[0][1] = 2;
	test2[0][2] = 3;


	test2[0] = test; // possible

	System.out.println(test[0][1]); // 2


- 2차원 배열은 impossible의 방식으로는 안되고 new 키워드로 배열 인스턴스를 생성한 이후에 하나씩 초기화

하던가

- 이전에 new 키워드로 생성된 배열을 초기화 시켜주거나 둘 중 하나를 해야 한다.


---

#### sort 메소드 사용할 때

		Arrays.sort(phoneNumbers, new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				
				if (o1.length() > o2.length())
					return 1;
				else if(o1.length() == o2.length())
					return 0;
				else
					return -1;
			}
		});

같은 경우를 따로 정렬할 필요가 없더라도

위와 같이 클 때, 같을 때, 작을 때를 다 구분해주자

나중에 인덱스로 접근해야 할 경우 IndexOutOfBoundException이 나올 수 있다.

		for (int phoneJ = phoneI + 1; phoneJ < phoneNumbers.length; phoneJ++) {
			if (currentPhoneNum.length() == phoneNumbers[phoneJ].length())
				continue;
			if (currentPhoneNum.equals(phoneNumbers[phoneJ].substring(0, currentPhoneNum.length()))) // IndexOutOfBoundException 발생가능
				return false;
		}


---