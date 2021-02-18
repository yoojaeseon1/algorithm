#### 조건문(if/else, 삼항 연산자)

##### 값이 더 유동적인 조건을 먼저 쓰자

- 영어의 어순으로 볼 때 읽기 편하다.
- 조건이 모두 유동적이라면 영어의 어순으로 자연스러운 것을 택하자.

ex)

	if(arr[i] > A && arr2[i] < A) System.out.println("correct!!");

##### if / else 블록의 순서

- 부정이 아닌 긍정을 다루자  
	- if(!debug)가 아닌 if(debug)
#
- 간단한 것을 먼저 처리하자(해보면서 생각해보자)
 
- 더 흥미롭고, 확실한 것을 먼저 다루자(해보면서 생각해보자)  

##### if- else if문 작성할 때 

if문 또는 상위의 else if문의 조건에서 걸러진 것을 참고해서 else if의 조건문을 작성하자


##### 조건문에서 인덱스를 결정하는 변수(i,j등)

인덱스 범위에 들어오는지 확인하는 조건을 먼저 작성하자

	while (j >= 0 && operator[j] == '<') // j의 범위를 먼저 확인하기 때문에 에러가 나지 않는다.
			j--;
			
	while (operator[j] == '<' && j >= 0)  // indexOutOfBound 에러가 날 수 있다.
			j--;

##### 삼항연산자는 매우 간단할 때만 사용하자

ex)

	timeStr += (hour >= 12) ? "pm" : "am";

---


#### 메소드

#### 메소드명

##### 리턴 타입 별 naming convention

###### boolean

- is*, has*, can*, should*

is*는 boolean 타입 필드의 setter로도 사용되지만

적절하게 네이밍 할 수 있으면 setter가 아닌 메소드에 사용해도 좋다.

###### int

- compute* : 계산할 때


##### 메소드명 키워드로 사용할 만한 것들

- convertTo~, changeTo~ : 변환


##### 자료구조 별 naming convention

###### List / array

- *s : 추가되는 변수명이 * 일 때

ex)

	List<String> names = new ArrayList<>();
	
	String[] names = new String[5];

- ListOf*s / arrayOf*s

ex)

	List<Name> listOfNames = new ArrayList<>();

	Name[] arrayOfNames = new Name[5];

namesList는 메소드 내에 namesSet과 같은 자료구조가 있어서 구분이 필요할 때 사용한다.

###### Map

keyToValue 또는 valueByKey 


---

#### map

##### map을 굳이 쓰지 않아도 되는 경우

- 알파벳(a-z, A-Z), 숫자(0-9) 등 아스키코드 값으로 인덱스에 접근 가능한 경우
	- 배열을 사용하자


---
#### 변수명

##### 적당한 변수의 길이

- 변수 이름의 길이가 평균적으로 10-16일 때 프로그램을 디버깅하기 위해서 들이는 노력을 최소화 할 수 있고 변수의 평균 길이가 8-20인 프로그램은 디버깅하기가 쉽다.

- 결론 : 길이가 8-20 이면 적절하다.(약간 길어보여도 의미가 명확하도록 이름 짓자)

##### 변수 naming convention

max, min : 경계를 포함하는 최대/최소값

first, last : 경계를 포함하는 범위

begin, end : 경계를 포함/배제하는 범위(begin이상 end미만 일 때)

num* : 개수를 나타낼 때(ex) numNodes : 노드의 개수)

sum* : 특정 값의 합을 나타낼 때(ex) sumSquares : 사각형들의 합)

is* / has* / can* / should* : boolean 타입 변수를 지을 때

base* : 기준이 되는 변수(높이, 길이 등)

*Count : 카운팅되는 변수

filled* : 채워진


##### 변수명 키워드로 사용할 만한 것들

- before / after

##### 너무 긴 이름

numberOfPeopleOnTheUsOlympicTeam

numberOfSeatsInTheStadium
 
maximunNumberOfPointsInMordernOlympics


##### 너무 짧은 이름 

n, np, ntm 
n, ns, nsisd 
m, mp, max, points

##### 적당한 이름 

numTeamMembers, teamMemberCount

numSeatsInStadium, seatCount

teamPointsMax, pointsRecord


---

##### num, size, input과 같은 변수명은 지양하자

num : 정수/실수의 자료형이라면 당연히 숫자(number)의 의미를 포함하므로 적어주지 않는게 좋다. 단, ~~의 개수의 의미를 가질 경우라면 괜찮다.

size : 무엇의 size인지 명확하게 써줘야 한다.

input : 표준 입력으로 받는 인스턴스라면 입력(input)의 의미를 이미 포함하므로 적어주지 않는게 좋다

XXXArray : 배열이라고 써주지 않아도 배열이라는 것을 알고 있다.

ex) fieldArray[](X) >>> field[](O)

---

	
#### 루프반복자(i, j, iter, it등) 더 명확하게 이름짓는 방법

반복자를 단순히 i,j,iter가 아니라 어떤 배열의 인덱스인지를 나타내는 것이 좋다.(ci,mi,ui)

	int[] club = new int[5];
	int[] member = new int[5];
	int[] user = new int[5];
	
club[ci], memeber[mi], user[ui] 또는 club[club_i], memeber[member_i], user[user_i] 

 처럼 반복자의 이름을 알아보기 쉽게 작성하자.

---
	
#### 메소드에서 변수(인스턴스)의 선언 위치

사용하는 스코프 바로 위에 선언&초기화 한다.(맨 위에 한꺼번에 선언하지 말고 필요할 때 선언!!)

변수를 해당 스코프(if,for,while)내에서만 쓰도록 제한한다.(메모리 관리 측면에서)

---

#### 상수는 대문자로

단어를 이을 경우 _로 연결한다.(카멜케이스X)

final 키워드를 추가한다.

ex) 

	final int N = 5; // 앞으로 수정할 일이 없을 경우
	
---

#### Iterator 

		Iterator keyIter = keySet.iterator();
		
		while (keyIter.hasNext()) {
			// key의 자료형 또는 클래스로 casting해주면 된다.(next() 메소드는 Object 객체를 반환한다.)
			char key = (char) keyIter.next();  
			
			if (nameMap.get(key) >= 5) {
				entryList.add(key);
			}
		}
		
map(key 또는 value), set 의 원소를 하나씩 확인할 수 있다.