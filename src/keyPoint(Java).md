#### 백준에서 문제 풀 때

백준에서 입력 여러개 받을 때는 한줄 입력받을 때마다 처리하지말고(초기화는 하고 연산을 나중에 하자는 의미)

배열로 다 받은다음 처리하자(초기화만)

출력 값이 변수의 자료형 범위를 벗어나는지 확인하자

---

#### switch문

      switch(currentChar) {
          case 'S':
              currentPoint = Integer.parseInt(dartResult.substring(pointStartIndex, dartResultI));
              break;
          case 'D':
              currentPoint = (int)Math.pow(Integer.parseInt(dartResult.substring(pointStartIndex, dartResultI)),2);
              break;
          case 'T':
              currentPoint = (int)Math.pow(Integer.parseInt(dartResult.substring(pointStartIndex, dartResultI)),3);
              break;
		 default : 
			  System.out.println("execute default");
      }

각 case마다 break를 해주지 않으면 다음 case로 넘어가서 확인한다.

Java 7버전 전에는 switch의 인자로 int 타입 변수만 올 수 있었지만 7버전 부터는 char / String 타입도 올 수 있다.

#### for문 초기화 변수 여러개 사용하기

	for (int line = si, ci = 0; line < source.length - si; line++, ci++) {
				copied[ci] = source[si][line];
			}

예시처럼 ,로 구분해 여러개의 초기화 변수를 사용하고 증감시킬 수 있다.

---

#### 탐색문제

전체적으로 탐색해야 하는 문제(ex) list.contains() 메서드 사용해야 하는 문제 )는  list 대신 map을 사용하면 시간초과가 발생하지 않을 수 있다.

알파벳 하나를 포함하는지 탐색해야 하는 경우

	boolean[] alphabet = new boolean[26];
	alphabet[alpha-'A'] = true;
	if(alphabet[alpha-'A']) {
		executing statement
	}

위와 같이 배열의 인덱스를 아스키코드 값으로 접근하자.

- 아스키코드

알파벳 대문자(A~Z) : 65 ~ 90
알파벳 소문자(a~z) : 97 ~ 122

---



##### Queue 선언/메소드

	Queue<Integer> queue = new LinkedList<>();

	queue.add() // enqueue(include exception)

	queue.offer() // enqueue(exclude exception)

	queue.poll() // dequeue

	queue.peek() // check recent added element

---

#### 배열과 list중에서 배열을 사용해도 무관하다면 배열을 사용하는것이 수행시간이 적게 나온다.(정렬 할 때, 거의 1/3 수준)

크기가 정해져 있다면 배열을 사용하는 습관을 들이자.(list가 편하긴 하지만 수행시간에서 조금 차이가 있다.)

배열의 인덱스 변수를 하나 따로 만들어서 초기화 할 때마다 증가시키는 것으로 list와 동일하게 사용이 가능하다.

배열 : Arrays.sort(array);

list : Collections.sort(list);

---
#### 아스키코드 자주 쓰는 것들

숫자(0~9) : 48~57

알파벳대문자(A~Z) : 65~90

알파벳 소문자(a~z) : 97~122

A~B(B>A) 범위 안의 개수 : 둘다 포함하면 (B-A)+1, 하나만 포함하면 B-A, 둘다 포함 안하면 (B-A)-1

한글 :44032 ~ 55203

한글 자음(ㄱ~ㅎ) : 12593 ~ 12622

한글 모음(ㅏ~ㅣ) : 12623 ~ 12643

---

StringBuffer : multi-thread에서 사용(jdk 1.5부터) (동기화 지원)

StringBuilder : single-thread에서 사용(동기화 지원X, 싱글스레드에서는 성능이 더 좋다.)

String대신 StringBuilder 사용

Scanner(System.in) : single-thread에서 사용(동기화 지원X, 싱글스레드에서는 성능이 더 좋다.)

BufferedReader(new InputStreamReader()) : multi-thread에서 사용(jdk 1.5부터) (동기화 지원)

---

StringTokenizer st = new StringTokenizer(String, delim);

delim을 기준으로 split한다.(delimeter : 구분기호)

st.nextToken() : 처음설정한 delim을 기준으로 나눠진 String을 return

st.nextToken(delim)을 통해 delim을 바꾸면 split의 기준이 다시 바뀐다.

StringTokenizer 객체에는 nextToken()했을때의 delim기준으로 나눠진 첫번째 String을 제외한 전체 String이 저장되어있다.

ex) 

	String temp =  "this$1is$1string";

StringTokenizer st = new StringTokenizer(temp, delim); >> delim의 default 값 : " "

delim을 설정한 이후 재 설정 하지 않으면 계속 그 delim으로 적용돼 token이 생성된다.
(인스턴스 생성할 때, st.nextToken(String delim)할 때 모두 마찬가지)

nextToken(delim)실행 시 남아있는 문자열의 시작에는 해당 delim이 맨 앞에 포함되어있다.

	String temp = "$1is$1string$1shaha";
		
		StringTokenizer st = new StringTokenizer(temp, "$");
		
		System.out.println(st.nextToken());  // 반환값 :"1is", 남아있는 문자열 : "$1string$1shaha"
		System.out.println(st.nextToken("s")); // 반환값 : "$1", 남아있는 문자열 : "string$1shaha"
		System.out.println(st.nextToken()); // 반환값 : tring$1, 남아있는 문자열 : "shaha"
		System.out.println(st.nextToken()); // delim이 "s"로 적용되서 haha를 출력한다.
		
하나의 delim으로 계속 nextToken을 반환 시킬 때는 크게 신경 쓸 필요없이 해당 delim으로 문자열이 나워져 token이 된다고 생각하자.

---

기본형변수(int, float, double, char, boolean...)에 대한 래퍼클래스(Integer, Float, Double, Character, Boolean...) 가 존재한다.

기본형의 경우 따로 초기화를 하지 않아도 0 또는 ''또는 "" 또는 false 의 값이 초기화 되어있다.

Integer wrapper = new Integer(10);  -> Integer wrapper = 10; //오토박싱(autoboxing)

int primitive = wrapper.intValue();  -> int primitive = wrapper;        //언박싱(unboxing)

객체와 변수를 따로 변환하지 않고 쉽게 초기화 할 수 있도록 돕는다.

---

try문에서 선언, 초기화된 클래스, 변수는 밖에서 사용할 수 없다(try문의 로컬클래스/변수)

밖에서 선언된 전역변수를 가져와서 쓸 수 있다.


---

String.replace()는 인스턴스의 값을 바꾸지 않고 대체된 String을 반환하므로

str = str.replace("a", "b");

와 같은 방식으로 써야된다.

replace랑 replaceAll 둘다 해당하는 문자열을 모두 대체시킨다.

replaceFirst, replaceLast는 하나만

---

#### 배열의 범위

	int[][] tree = new int[2][nodeinfo.length];
	// = {{nodeinfo.length},{nodeinfo.length}}; // nodeinfo.length만큼의 1차원 배열을 2개 만든다.
	
	int[][] tree = new int[nodeinfo.length][2];
	// = {{2},{2},{2},...,{2}}  // length가 2인 1차원 배열을 nodeinfo.length개 만큼 만든다.



#### 배열을 ArrayList로

	String[] city = {"서울","부산","대구","광주"};
	List<String> list = new ArrayList<String>();
	Collections.addAll(list, city);

배열이 래퍼클래스의 배열일 경우만 사용 가능하다.

---

#### ArrayList를 배열로

	List<String> list = new ArrayList<String>();

	list.add("abc");
	list.add("def");

	String[] array = list.toArray(new String[list.size()]);

	// 배열이 래퍼클래스의 배열일 경우만 사용가능하다.

---

배열과 list중에서 배열을 사용해도 무관하다면 배열을 사용하는것이 수행시간이 적게 나온다.(정렬 할 때, 거의 1/3 수준)


#### 2차원 배열의 정렬

##### 배열

ex) 첫 번째 인덱스 오름차순 -> 같으면 두 번째 인덱스 오름차순 


		Arrays.sort(coordiArr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[0] > o2[0]) return 1;
				else if(o1[0] == o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				} else
					return -1;
			}
		});

Integer.compare(o1,o2); // 오름차순(가장 작은 것이 1등)
Integer.compare(o2,o1); // 내림차순(가장 큰 것이 1등)

##### 내부 배열의 인덱스가 길 경우 정렬 방법

		Collections.sort(routes, new Comparator<List<String>>(){

			@Override
			public int compare(List<String> o1, List<String> o2) {
				
				for(int oi = 0; oi < o1.size(); oi++) {
					
					int compareResult = o1.get(oi).compareTo(o2.get(oi));
					
					if(compareResult > 0) return 1;
					else if(compareResult < 0) return -1;
				
				}
				
				return 0;
			}

		});

##### list

위와 같이 래퍼 클래스의 배열로 받거나 List<List<String>>을 Collections.sort해주면 동일하게 정렬된다.

#### Comparable 인터페이스

- Collections.sort() 메소드에서 인자를 List하나만 넣었을 경우에 적용되는 정렬방식
- List에 들어가는 타입의 클래스에서 인터페이스를 구현해야한다.

		class Alphabet implements Comparable<Alphabet>{
			
			private char alphabet;
			private int count;
			
			public Alphabet() {
				// TODO Auto-generated constructor stub
			}
			
			public Alphabet(char alphabet, int count) {
				this.alphabet = alphabet;
				this.count = count;
			}
			
			
			
			@Override
			public int compareTo(Alphabet o) {
				
				return Integer.compare(o.getCount(), this.count);
			}
	
			// getter, setter..
		
		}


compareTo 인자가 하나라서 Comparator의 compare랑 헷갈릴 수 있지만

	compare(Alphabet o1, Alphabet o2) {...}

라면

	compareTo(Alphabet o) {...}

compareTo 에서는 o2에 해당하는 인자만 받고 o1은 해당 클래스의 필드 값이 된다.

#### Comparator 인터페이스

Comparator 인터페이스의 compare(Object o1, Object o2){} 를 구현하여 사용한다.

배열과 list의 정렬에서 모두 사용할 수 있다.

단순히 오름차순, 내림차순이 아니라 정렬하는 기준이 정해져 있을 경우 사용하면 된다.

1회성으로 사용할 경우에는 익명 클래스로 바로 인자에 넣어서 사용하면 된다.

compare(Object o1, Object o2)에서의 리턴 값

	// 오름차순

	if(o1 > o2) return 1 ;
	else if(o1 == o2) return 0;
	else return -1;
	
	// 내림차순

	if(o1 > o2) return -1;
	else if(o1 == o2) return 0;
	else return -1;
	
String의 경우 사전순, 문자열의 길이, 문자이지만 숫자의 크기로 정렬하는 것처럼 다양하게 구현할 수 있다.

- list의 내림차순 정렬 참고(Collections.sort 대신 Arrays.sort를 사용한다.)

단순히 사전순으로 비교할 때는 

	String a = "haha";
	String b = "hoho";

	// 리턴 값으로
	
	o1.compareTo(o1); 오름차순
	
o1-o2의 값을 리턴한다.
	
	o2.compareTo(o2); 내림차순
	
o2-o1의 값을 리턴한다.
	

	

##### 오름차순

기본적으로 모든 메소드의 default가 오름차순이다. 내림차순일 경우에만 신경 써주면 된다.

##### 내림차순

Comparator 인터페이스를 구현 할 경우에는 기본형이 아닌 래퍼클래스의 배열을 사용해야 한다.(한 번만 사용할 경우 익명클래스로 바로 Arrays.sort함수에 인자로 넣으면 된다.)

	class Descending implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			
			if(o1 > o2) {
				return -1;
			} else if(o1 == o2) {
				return 0;
			} else {
				return 1;
			}
		}
	}

메인 메소드	
	
	Integer arr = {1,3,6,4,3,2}; // Comparator 인터페이스에서 기본형 타입으로는 정렬이 안되므로 래퍼클래스의 인스턴스를 생성해야한다.

	Arrays.sort(arr, new Descending());
	
	// 또는
	
	Arrays.sort(arr, new Comparator<Integer>(){
		
		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1>o2)return -1;
			else if (o1==o2) return 0;
			else return 1;
	});

	// 또는

	Arrays.sort(arr, Collections.reverseOrder()); 
	// 속도 차이는 거의 없으니 이거 쓰는게 훨씬 간편하다.(기본 자료형 배열도 가능, Comparator인터페이스를 구현한 것이 아니니까)
	
	// 또는
	
		Arrays.sort(arr, new Comparator<Integer>(){
		
		@Override
		public int compare(Integer o1, Integer o2) {
			
			return Integer.compare(o2,o1); // 인자에 int형으로 들어가도 알아서 오토박싱해준다.(메소드의 인자는 원래 int형이다.)
	});
	

#### List의  정렬(람다식 사용)

##### 오름차순

모든 메서드의 default가 오름차순이므로 내림차순일 경우만 신경쓰면 된다.

##### 내림차순

	List<Integer> list = new ArrayList<Integer>();

	Collections.sort(list, (o1, o2)->o2-o1); // 첫 번째 인자만 넣으면 오름차순 정렬

	
	// 문자열 정렬

	Collections.sort(nList, (o1,o2)->Integer.parseInt(o1)-Integer.parseInt(o2)); // 문자열을 숫자 순서대로  오름차순 정렬
	
	Collections.sort(nList, (o1,o2)->Integer.parseInt(o2)-Integer.parseInt(o1)); // 문자열을 숫자 순서대로  내림차순 정렬
	
	Collections.sort(nList, (o1,o2)->o1.compareTo(o2)); // 사전 순서대로 오름차순 정렬 (ex)123 > 1000 : 문자 순서대로면 두번 째 인덱스에 오는 수가 123이 더 크니까)
	
	Collections.sort(nList, (o1,o2)->o2.compareTo(o1)); // 사전 순서대로 내림차순 정렬 (ex)123 > 1000 : 문자 순서대로면 두번 째 인덱스에 오는 수가 123이 더 크니까)
	
Collections.reverse(list)는 정렬이 아니라 인덱스를 반대로 재 배열 해준다.

---

#### String 배열을 정렬하는 것과

int 배열을 정렬하는 것은 결과가 다르다.

11 103 132 19 102

숫자 :  [11, 19, 102, 103, 132]

문자 :  ["102", "103", "11", "132", "19"]

---

#### 인스턴스와 배열의 copy

##### 인스턴스의 copy

###### shallow copy

인스턴스를 copy 할 경우 shallow copy가 되어 복사의 대상이 된 인스턴스의 필드 값이 바뀌면 복사한 인스턴스의 필드 값도 바뀐다.

ex)

	Test a = new Test();
	a.setName("yoo");
	Test b = new Test();
	b = a;
	
	System.out.println(b.name); // output : yoo
	a.setName("changed name");
	System.out.println(b.name); // output : changed name
	
###### deep copy

하지만 String을 포함한 래퍼클래스의 인스턴스와 기본형 변수는 deep copy가 된다.

ex)

	String a = "name";
	String b = a;
	
	System.out.println(b); // output : name
	a = "changed name";
	System.out.println(b); // output : name


###### List의 deepCopy

- addAll메소드를 사용하면 된다.

ex)

	List<String> source = new ArrayList<>();
	source.add("abc");
	source.add("def");

	List<String> destination = new ArrayList<>();

	destination.addAll(source);
	
###### set의 deepCopy

	Set<Integer> source = new HashSet<>();
	source.add(1);
	source.add(2);
	source.add(3);
	
	Set<Integer> destination = new Hashset<>(source); // deepcopy가 된다.
 
###### List의 deep copy

	List<Integer> source = new ArrayList<>();
		
		source.add(1);
		source.add(2);
		source.add(3);
		source.add(4);
		source.add(5);
		
	List<Integer> copied = new ArrayList<>(source);
	
- List를 생성할 때 생성자의 파라미터로 copy할 source List를 넣어주면 된다.

- 주의사항

		List<Integer> copied = source.subList(0, source.size());
		
subList는 view를 리턴하기 때문에 같은 객체를 참조하므로 shallow copy가 된다.

---

##### 배열의 copy

shallow copy (System.arraycopy()로 인한 부하를 줄이는 것이 좋으므로 )
- source와 destination이 참조하는 주소값이 같다.
- 입력받은 배열을 수정할 일이 없을 경우 
- source array를 copy 이후에 사용하지 않을 때

deep copy
- source와 destination이 독립
- source array를 copy 이후에 수정할 일이 있을 경우(destination array도 같이 수정되는 것을 방지하기 위해)

###### shallow copy

	int[] original = {1,2,3,4,5};
	int[] coiped = original // shallow copy가 되어 original의 값이 수정되면 같은 인덱스의 copied의 값도 바뀐다.
								 // copied의 값이 수정되어도 original의 값이 바뀐다.(같은 주소값을 사용하기 때문에)
								 
	Stack<int[]> testStack = new Stack<>();
		
	int[] test = new int[2];
		
	test[0] = 1;
	test[1] = 2;
		
	int[] test2 = test;
		
	testStack.push(test);
		
	test2[0] = 5;
		
	System.out.println(testStack.pop()[0]); // push될 때 shallow copy되서 들어가기 때문에 push된 배열도 영향을 받는다.
	
인자로 들어가는 모든 경우에  shallow copy된다.

		boolean[] source = new boolean[26];
		
		DeepCopy test = new DeepCopy(1, source);
		
		System.out.println(test.getVisited()[5]);
		
		source[5] = true;
		
		System.out.println(test.getVisited()[5]); // output : 5
		
복사해서 사용하려면 필드를 사용한 생성자에서 System.arrayCopy()메소드를 사용해야 한다.
	
###### deep copy

	int[] original = {1,2,3,4,5};
	int[] copied = new int[original.length];
	
	System.arraycopy(original,0,copied,0,original.length); 
	
	// deep copy가 되어 original의 값이 수정되어도 copied의 값에는 아무런 영향이 없다.
	
###### 2차원 배열 deep copy

여러번 쓸거면 이렇게 만들어서 쓰고 아니면 main문에 똑같이 작성하자

	static int[][] copyArray(int[][] original) {

		int[][] copied = new int[original.length][original[0].length];

		for (int i = 0; i < original.length; i++) {
			System.arraycopy(original[i], 0, copied[i], 0, original[i].length);
		}

		return copied;

	}
---

#### 배열의 초기화

	int[] source = {1,2,3,4};

의 의미는

	int[] source = new int[4];

	source[0] = 1;
	source[1] = 2;
	source[2] = 3;
	source[3] = 4;

와 같다.

	int[] sameElements = {1,2,3,4};
	
를 만들어도 두 배열은 아예 다른 주소값을 가지므로 deep copy한 것과 같은 형태가 된다.

그래도 원소의 개수가 많거나 초기화하는 값이 복잡하면 인덱스 별로 초기화 해주는 것이 가독성이 더 높은 것 같다.


#### 무한한 숫자를 표현할 때는 

BingInteger, BigDecimal 을 사용하자

	BigInteger a = new BigInteger(String);

	BigInteger b = new BigInteger(String);

	a = a.add(b); // a 와 b를 더한다.


---


input.readLine할때 입력값의 끝은

length == 0 으로 조건을 하면 된다.

StringBuilder.append(String a) // a를 리턴한다.


---

#### 가변 크기 2차원배열 생성하는 법


	int[][] array5 = new int[3][];

	array5[0] = new int[1];
	array5[1] = new int[2];
	array5[2] = new int[3]; 



---

#### 메타문자(+,-,*,/ 등등 정규표현식에 사용되는 문자)를 string으로 인식하게 하려면 앞에 \\\를 추가해줘야 한다)

ex) 

	String[] a = b.split("\\*");
	
그냥 "+"만 인자로 넣으면 PatternSyntaxException을 반환한다.

---


	Map<Character, Integer> charMap = new HashMap<>();
	ValueComparator vc = new ValueComparator(charMap);
	Map<Character, Integer> sortedMap = new TreeMap<>(vc);
	sortedMap.putAll(charMap);


	class ValueComparator implements Comparator<Character> {

		Map<Character, Integer> map;

		public ValueComparator(Map<Character, Integer> map) {

			this.map = map;

		}

		@Override
		public int compare(Character o1, Character o2) {

			if (map.get(o1) >= map.get(o2)) {  // map.get(o1) <= map.get(o2) 일 경우 오름차순정렬
				return -1;
			} else {
				return 1;
			}
		}

	}

---

#### StringBuilder/StringBuffer에서 substring을 뽑아 새로운 StringBuilder/StringBuffer에 옮길 때는

CharSequence을 반환하는 subSequence(int startIndex, int lastIndex) 메소드를 사용해서 append하자
(substring을 쓰면 힙영역에 스트링이 계속 올라가니까 메모리 관리에 안좋다.)

StringBuilder.append에 char형 변수를 인자로 넣을 수 있다.(안되는 줄 알았는데..)

---

#### StringBuilder/StringBuffer가 같은지 비교할 때는 인스턴스.equals(인스턴스) 하면 안되고

인스턴스1.toString().equals(인스턴스2.toString()); 을 해야한다.

인스턴스1.equals(인스턴스2); 로는 StringBuilder/StringBuffer 에 들어있는 값이 같은지 확인 할 수 없다.

ex)

	StringBuilder str1 = new StrigBuilder("haha");
	StringBuilder str2 = new StrigBuilder("haha");

	// 같은지 확인할 때

	if(str1.toString().equals(str2.toString())) {
		System.out.println("equals");
	}

---
#### StringBuilder/StringBuffer에는 있고 String에는 없는 메소드

.reverse(); : 해당 문자열의 인덱스를 거꾸로 한 문자열로 만든다.


#### String에는 있고  StringBuilder/StringBuffer에는 없는 메소드

.split() : 인자로 입력한 정규표현식에 따라 문자열을 분리해서 String[]로 반환한다.

---

#### StringBuilder/StringBuffer.insert(index)

해당 index에 추가하고 그 뒤로 오는 문자열을 한칸씩 밀어준다.(해당 인덱스에 대체 해주는 것이 아니다.)

해당 index에 대체하고 싶으면 StirngBuilder/StringBuffer.serCharAt(index) 를 사용하면 된다.

String은 insert의 기능을 하는 메소드가 없다.(문자/문자열로 접근해서 대체 해주는 replace메소드가 있다.(replace는 StringBuilder/StringBuffer도 있다.))

---

#### String과 Char의 빈 문자열/문자의 초기화

String은 빈 문자열을 초기화 할 수 있지만

Char는 빈 문자를 초기화 할 수 없다.

빈 문자를 사용해야 할 때는 String을 사용하는 것이 편리하다.

ex)

	String initString = ""; // 가능
	
	Char initChar = '' // 에러 발생


---

#### list의 중복된 원소 제거

	List<String> wordsList = new ArrayList<>();
	
	Set<String> wordsSet = new Hashset<>(strList); // 인자로 배열을 Arrays.asList(배열)로 입력해도 된다.
	
	wordsList = new ArrayList<>(wordsSet);
	
---

#### main문 안에서의 초기화

- 기본형 변수의 배열은 자동으로 초기화가 된다.(0,false 등)

- 기본형 변수는 초기화를 해줘야 된다.

---

#### map에서 key뽑아 반복문 돌리는 방법

		Set<Character> keySet = nameMap.keySet();

		Iterator keyIter = keySet.iterator();
		
		while (keyIter.hasNext()) {
			// key의 자료형 또는 클래스로 casting해주면 된다.(next() 메소드는 Object 객체를 반환한다.)
			char key = (char) keyIter.next();  
			
			if (nameMap.get(key) >= 5) {
				entryList.add(key);
			}
		}

key를 뽑아 iterator 반복문에서 get(key)로 value값을 검색할 생각이면 애초에 entry로 뽑는 것이 효율적이다.
		
#### map에서 key와 value를 동시에 뽑아 반복문 돌리는 방법

- Map.Entry로 캐스팅 하는 것이 핵심!!(Iterator 인스턴스 생성할 때, 인스턴스에서 값을 확인할 때)

- Map.Entry<T>를 모두 꼭 써줘야 programmers에서 오류없이 체점된다.

import java.util.Map;
import java.util.Map.Entry;

를 해주면 Map.Entry를 Entry만 써줘도 된다.

(import java.util.*; 를 하면 Map.Entry를 다 써줘야 된다.)

        Iterator<Entry<String, List<int[]>>> entryIter = genreToPlay.entrySet().iterator();
        List<Genre> sumPlaysOfGenre = new ArrayList<>();

        while(entryIter.hasNext()) {
            
            Entry<String, List<int[]>> genreAndPlay = entryIter.next();
            
            String genre = genreAndPlay.getKey();
            List<int[]> songs = genreAndPlay.getValue();
            
            if(songs.size() > 1) albumLength += 2;
            else albumLength += 1;
            
            int sumPlay = 0;
            
            for(int songsI = 0; songsI < songs.size(); songsI++) {
                
                sumPlay += songs.get(songsI)[1];

            }
            sumPlaysOfGenre.add(new Genre(genre, sumPlay));
        }

---

#### map을 key와 value로 구분해서 ArrayList에 넣는 방법

		ArrayList<Character> keys = new ArrayList<>(sortedMap.keySet());
		ArrayList<Integer> values = new ArrayList<>(sortedMap.values());

map의 key 또는 value로 정렬한 후에 위와 같이 하면 정렬한 순서대로 ArrayList에 추가된다.

---

#### TreeMap / TreeSet

추가되는 element(Map은 key)가 오름차순으로 정렬된다.(Hash는 순서 없음)

정렬기준을  바꾸는 방법 : 생성자의 인자로 Comparator 인터페이스를 구현하면 된다.

ex)

	Set<Integer> testSet = new TreeSet<>((o1,o2)-> o2.compare(o1));
	
	Map<String, Integer> testSet = new TreeMap<>((o1,o2)-> o2.compareTo(o1));

String은 문자열 크기 순, Integer는 숫자 크기 순으로 정렬된다.(숫자와 숫자로 된 문자열은 정렬 기준이 다르다.)

---
	
#### LinkedHashMap / LinkedHashSet

HashMap과 HashSet은 순서가 없지만 

LinkedHashMap과 LinkedHashSet은 입력된 순서를 보장한다.(Map은 key값의 순서)

사용법은 기존의 Map, Set과 동일

---
	
#### Object 타입 배열의 활용 방법 

Object배열보다는 해당 자료형,인스턴스를 필드로 가지는 클래스를 만들어 그 인스턴스를 넣어주는 것이 더 편리하다.(꺼낼 때 캐스팅 할 필요X)

사용법

여러 타입의 자료형, 인스턴스를 한번에 push, enqueue(add, offer <-> poll) 할 때 사용할 수 있다.

    Stack<Object[]> boardStack = new Stack<>();

	Object[] curPosition = new Object[3];
	StringBuilder movedRoute = new StringBuilder();
	movedRoute.append(board[0][0]);
	curPosition[0] = 0;
	curPosition[1] = 0;
	curPosition[2] = movedRoute;
	boardStack.push(curPosition);
	
	// 각각 다운캐스팅 해야 해당 인스턴스의 메소드를 사용할 수 있다.(안하면 overriding되지 않은 Ojbect 타입의  메소드만 사용가능)
	
	curPosition = boardStack.pop();
	curX = (int) curPosition[0];
	curY = (int) curPosition[1];
	movedRoute = (StringBuilder) curPosition[2];

---

#### method signature

메서드 명과 파라미터의 순서, 타입, 개수를 의미한다.(리턴 타입과 exceptions는 메서드 시그니처가 아니다.)

오버로딩 시 시그니처를 구별해 다른 메소드라는 것을 인식한다.

ex)

	public void funcA(int x, int y){
		...
	}
	
	public void funcA(double x, int y, int z) {
		...
	}
	

메소드명은 같지만 인자 리스트의 구성이 다르기 때문에  오버로딩이 되는 것이다.

---

#### PriorityQueue(우선순위 큐)


		PriorityQueue<Integer> scovilles = new PriorityQueue<>(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o2.compareTo(o1);
			}
			
		});

		scovilles.add(2);
		scovilles.add(3);
		scovilles.add(4);
		scovilles.add(1);

		System.out.println(scovilles.poll()); // output : 4

와 같은 방식으로 Comparator 인터페이스를 구현해 사용 할 수 있다.

어떤 순서대로 enqueue를 했더라도 내림차순 우선순위에 따라 가장 큰 수 인 4가 dequeue되었다.

다른 클래스를 타입 파라미터로 넣어도 Comparator 인터페이스를 구현해 원하는 우선순위에 따라 enqueue하는 큐를 만들 수 있다.

---

#### Set의 elements를 List에 바로 넣기

	Set<Integer> testSet = new HashSet<>();

	List<Integer> testList = new ArrayList<>(testSet);

또는
	
	Map<Integer, List<int[]>> levelToX = new HashMap<>();

	List<Integer> levels = new ArrayList<>(levelToX.keySet());

또는 (List인스턴스 생성이후)
	
	levels.addAll(levelToX.keySet());

와 같은 방식으로 List 인스턴스를 생성할 때 생성자의 인자로 넣어줘야 한다.

List인스턴스를 선언만 하고

	levels.addAll(levelToX.keySet())

과 같이 사용하면 NullPointException이 발생한다.
	

---

#### 정규표현식(Regular Expression)

- String.split(String regex)의 인자로 정규표현식을 넣어 간단하게 배열로 자를 수 있다.

- 정규표현식은 []안에 작성해야한다.

- 그냥 문자 하나로 split할 때는

	String.split(" ")

와 같이 []로 감싸지 않고 문자 하나만 써주면 된다.

- 사용된 정규표현식이 제외되는 것이다.(정규표현식을 기준으로 split이 되는 것이기 때문에)

- 구분자가 String의 맨앞 또는 맨뒤에 있으면 split되는 배열의 해당 위치에 공백인 index가 생긴다.

- ^가 not으로 쓰이는 경우, [], {}를 제외하고는 split에서 사용할 일은 없다.(Pattern.matchs()에서 사용된다.)

^ : 문자열의 시작(집합([]) 안에서는 not의 의미)

$ : 문자열의 종료

. : 임의의 한 문자 (문자의 종류 가리지 않음) 단, \ 는 넣을 수 없음

\* : 앞 문자가 없을 수도 무한정 많을 수도 있음

\+ : 앞 문자가 하나 이상

? : 앞 문자가 없거나 하나있음
 
[] : 문자의 집합이나 범위를 나타내며 두 문자 사이는 - 기호로 범위를 나타낸다. []내에서 ^가 선행하여 존재하면 not 을 나타낸다.

{} : 횟수 또는 범위를 나타낸다.

() : 소괄호 안의 문자를 하나의 문자로 인식 

| : 패턴 안에서 or 연산을 수행할 때 사용


\s : 공백 문자(" ")

\S : 공백 문자가 아닌 나머지 문자([^' '])

\w : 알파벳이나 숫자([0-9A-Za-z])

\W : 알파벳이나 숫자를 제외한 문자([^0-9A-Za-z])

\d : 숫자([0-9]와 동일)

\D : 숫자를 제외한 모든 문자([^0-9])

\ : 정규표현식 역슬래시(\)는 확장 문자. 역슬래시 다음에 일반 문자가 오면 특수문자로 취급하고 역슬래시 다음에 특수문자가 오면 그 문자 자체를 의미

(?i) : 앞 부분에 (?i) 라는 옵션을 넣어주면 대소문자를 구분하지 않음


자주쓰이는 match 패턴

이메일 : "[0-9A-Za-z]{1,15}@[a-z]{1,10}.[a-z]{1,5}"

주민등록번호 : "\\d{6}-[1-4]\\d{6}"

		String pattern = "[0-9A-Za-z]{1,15}@[a-z]{1,10}.[a-z]{1,5}";
		
		String input = "you8054@nate.com";
		boolean validationofInput = Pattern.matches(pattern, input);
		System.out.println(validationofInput);
		
		input = "you8054@nate.com.com";
		validationofInput = Pattern.matches(pattern, input);
		System.out.println(validationofInput);
		
		pattern = "\\d{6}-[1-4]\\d{6}";
		input = "930114-1216014";
		validationofInput = Pattern.matches(pattern, input);
		
		System.out.println(validationofInput);
		
		input = "930114-5216014";
		validationofInput = Pattern.matches(pattern, input);
		
		System.out.println(validationofInput);

출력

	true
	false
	true
	false

##### 주의사항

###### 메타문자를 사용할 때

- 메타문자는 \를 앞에 써줘야 문자로 인식된다.

- [] 안에서 \를 사용할 때는 한 번 더 입력해야 된다.

- {시작,끝} : 정규표현식에 맞는 문자가 시작 이상 끝 이하인 길이 일 경우에만 적용(+를 사용할 경우 길이 1 이상)

ex)

	String expression = "100-200*300-500+20";

	String[] symbols = expression.split("[^\\+\\-\\*]{1,3}"); // 길이 1이상 3이하

	System.out.println(Arrays.toString(symbols));

	symbols = expression.split("[^\\+\\-\\*]+"); // 길이 1이상	

	System.out.println(Arrays.toString(symbols));

	symbols = expression.split("[0-9]+"); // 길이 1이상

	System.out.println(Arrays.toString(symbols));

	symbols = expression.split("\\d+"); // 길이 1이상

	System.out.println(Arrays.toString(symbols));

출력

	[, -, *, -, +]

---

	String[] numbers = expression.split("\\D");
	String[] numbers = expression.split("[^0-9]");

두 배열의 값은

	[100,200,300,500,20]

으로 같다.

	

###### ^를 사용할 때
	
	String[] numbers = expression.split("[^0-9]");
	String[] numbers = expression.split("^[0-9]");
	
출력

	[100, 200, 300, 500, 20]
	[, 00-200*300-500+20]

	- [^0-9] : 숫자를 제외한 문자([]안의 ^는 제외의 의미)
	- ^[0-9] : 숫자로 시작하는 문자열([] 밖에서의 ^는 시작의 의미)

###### \를 사용할 때



ex)

	String test = "a12b34c56d";

	String[] splitedTest = test.split("[0-9]{2,4}");

	for(int splitedI = 0; splitedI < splitedTest.length; splitedI++) {
		System.out.print(splitedTest[splitedI] + " ");	// 출력 : a b c d 
	}

	// 구분되는 문자를 길이 2~4인 숫자로 한다. {}안에 숫자 하나만 쓸 경우 딱 그 길이의 숫자인 경우만 구분자로 사용한다.

자주 쓰는 정규 표현식(여러개를 붙여서 쓸 수도 있다.)

[0-9] : 숫자

[a-z] : 알파벳 소문자

[A-Z] : 알파벳 대문자

[a-zA-Z] : 알파벳 전부

^를 써주면 not의 의미가 된다.

[^0-9] : 숫자가 아닌 것

[^a-z] : 알파벳 소문자가 아닌 것 

[^A-Z] : 알파벳 대문자가 아닌 것

[^a-zA-Z] : 알파벳이 아닌 것

[^abc] : a, b, c를 제외한 다른 글자

[x?]: x가 없거나 한 번 나옴

[x*] : x가 없거나 한 번 이상 나옴

[x+] : x가 한 번 이상 나옴 

[a-z&&[^bc]] : b와 c를 제외한 a 부터 z까지 중의 하나와 일치하는 것

[]안에 특정 문자만 넣어서 할 수도 있다.(메타문자일 경우 문자 앞에 \\추가)

ex)

	String dartResult = "1S2D*3T";

	String[] splitedDart = dartResult.split("[SDT#*]{1,2}"); 

	// 알파벳 'S', 'D', 'T'와 '#', '*'가 포함된 1~2길이의 문자


SDT가 순서대로 나오지 않아도 된다. DS같은 문자가 나와도 구분자로 사용된다.
	 

ex)

	String dartResult = "1S2D*3T";

	String[] splitedDart = dartResult.split("[A-Z#*]{1,2}"); // 알파벳 대문자와 '#', '*'가 포함된 1~2길이의 문자


##### split은 성능이 안좋으므로 substring을 사용하는 것이 더 좋다.

---

#### Math class

- Math.pow(double a, double b) : a의 b제곱을 구해준다.(return 타입이 double이므로 정수로 사용하려면 캐스팅해야한다.)

인자로 정수를 넣어줘도 알아서 실수형으로 캐스팅된다. 

ex)
	System.out.println(Math.pow(5, 2)); // output : 25.0

- Math.sqrt(double num) : 제곱근을 구해준다.(return 타입이 double이므로 정수로 사용하려면 캐스팅해야한다.)

인자로 정수를 넣어줘도 알아서 실수형으로 캐스팅된다. 

ex)
	System.out.println(Math.sqrt(16.0)); // output : 4.0

---

#### Integer class

- Integer.toBinaryString(int num)

인자로 들어가는 num을 2진수로 변환한 문자열을 리턴한다.

ex)

	System.out.println(Integer.toBinaryString(30)); // output : 11110

이외에도 toOctalString(8진수), toHexString(16진수)가 있다.




---


#### 비트연산자

두 정수를 이진수로 바꿔 AND, OR, XOR 연산을 간편하게 할 수 있다.

비트연산을 쓸 수 있는 문제는 쓰는게 더 코드도 간결해지고 약간은 빨라진다.

- 사용법

AND : 둘다 1일 경우만 1

OR : 둘 중 하나 이상 1이면 1

XOR : 두개의 숫자가 다르면 1

		System.out.println(Integer.toBinaryString(42));  // 2진수 : 101010
		System.out.println(Integer.toBinaryString(27));  // 2진수 : 11011

		// 계산할 때 27의 자리수가 부족한 만큼 앞을 0으로 채우고 계산한다.

		// 101010
		// 011011

		System.out.println(Integer.toBinaryString(27|42)); // 111011
		System.out.println(Integer.toBinaryString(27&42)); // 1010(001010이지만 앞에 있는 0은 생략된다.)
		System.out.println(Integer.toBinaryString(27^42)); // 110001
		
		
		System.out.println(Integer.toBinaryString(42)); // 2진수 : 101010
		System.out.println(Integer.toBinaryString(7));  // 2진수 : 111

		// 101010
		// 000111

		System.out.println(Integer.toBinaryString(42|7)); // 101111
		System.out.println(Integer.toBinaryString(42&7)); // 10
		System.out.println(Integer.toBinaryString(42^7)); // 101101

---

#### 쉬프트 연산자

##### 좌측 쉬프트 연산

- n << i = n*2^i

i가 1씩 증가할 때마다 값이 두배씩 커진다. 

ex)

		System.out.println(2<<4); // 32
		System.out.println(2<<2); // 8
		System.out.println(3<<2); // 12

##### 우측 쉬프트 연산

- n >> i = n / 2^i

i가 1씩 증가할 때마다 값이 절반으로 나눠진다.

		System.out.println(20>>3); // 2(몫만 계산된다.)
		System.out.println(20>>2); // 5
		System.out.println(20>>1); // 10

---

#### String

##### replace vs replaceAll

	

	String test = "12341";

	test = test.replace("1", "a");

	System.out.println(test) // a234a


	String testAll = "12341";

	testAll = test.replaceAll("1", "a");

	System.out.println(testAll) // a234a


하지만 replaceAll는 첫번째 인자로 정규표현식을 받을 수 있다.(다양한 범위의 내용을 replace할 수 있다.)

##### toLowerCase / toUpperCase


String type의 변수를 모두 소문자 / 대문자로 변환시킨 String을 반환한다.

숫자/특수문자/공백 등이 포함되어 있어도 알파벳만 변환시켜준다.

ex)

	String str1 = "AA1+aa2";

	str1.toLowerCase();  // 이렇게 한다고 해도 str1이 변환되는 것이 아니다. 다른 String 변수에 초기화 해야한다.

	str2 = str1.toLowerCase();

	System.out.println(str2) // aa1+aa2

	

---