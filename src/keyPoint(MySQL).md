##### 문제 풀 때

출력할 속성명, 조건, 정렬방식을 꼭 확인하고 쿼리문을 작성하자


##### 테이블명, 속성은 소문자, 나머지는 모두 대문자로 작성하자

	SELECT COUNT(animal_id) AS count FROM animal_ins;

##### 쿼리문 문법 순서

SELECT

FROM

WHERE

GROUP BY

HAVING

ORDER BY


##### UPDATE

UPDATE 테이블이름

SET 필드이름1=데이터값1, 필드이름2=데이터값2, ...

WHERE 필드이름=데이터값

ex)

	UPDATE branch_info SET acceptState=true;

WHERE 절을 작성하지 않으면 branch_info 테이블에 있는 모든 튜플의 acceptState가 true로 바뀐다.


##### safe mode 해제 방법

Edit -> Preferences -> SQLEditor -> 맨 밑 sate update 해제


##### ★★★★★ JOIN ★★★★★


JOIN 할 때는 외래키를 조건으로 해야 한다.

	SELECT * FROM a JOIN b ON a.기본키=b.외래키

JOIN을 해야하는 문제는 JOIN으로 만들어지는 테이블을 SELECT로 확인 해보고

쿼리에 살을 붙이는 방식으로 풀자

###### LEFT JOIN(LEFT가 기준)

a LEFT JOIN b ON 조건

조건에 맞는 a 와 b의 튜플을 합쳐 새로운 테이블을 만든다.

합쳐진 튜플 중 공통되지 않는 b의 속성은 NULL값이 된다.

	SELECT outs.animal_id, outs.name FROM animal_outs outs LEFT JOIN animal_ins ins ON outs.animal_id=ins.animal_id WHERE ins.animal_id IS NULL ORDER BY outs.animal_id;

즉, out.animal에는 있는 id지만 ins.animal에는 없는 id를 가지는 ins의 속성이 모두 NULL이 된다.

a는 그대로 나오고 b에서 a와 공통되지 않는 속성이 null로 반환된다.

NULL값이 나올 수 있는 테이블을 오른쪽에다 두고 작성하는 습관을 들이자. 


###### RIGHT JOIN

a RIGHT JOIN b ON 조건 = b LEFT JOIN a ON 조건

###### INNER JOIN

a INNER JOIN b ON 조건

INNER는 생략 가능하다.

a 와 b의 속성이 모두 일치하는 튜플만 반환한다.(NULL 값이 나올 수 있는 튜플은 반환하지 않는다.) 

	SELECT ins.animal_id, ins.name FROM animal_ins ins INNER JOIN animal_outs outs ON ins.animal_id = outs.animal_id WHERE ins.animal_id=outs.animal_id AND ins.datetime > outs.datetime ORDER BY ins.datetime;


###### 3개 이상의 테이블을 JOIN할 때

table1 JOIN table2 ON 조건 JOIN table3 ON 조건...

	SELECT places.id, places.name FROM places JOIN schedules ON places.id = schedules.place_id JOIN place_reviews reviews ON places.id=reviews.place_id WHERE DATE_FORMAT(schedules.scheduled_at, '%Y-%m-%d') = '2019-01-06' GROUP BY places.id ORDER BY places.id;

##### WHERE 조건

= : 같다.
!= : 다르다.
>,<,>=,<= : 초과, 미만, 이상, 이하

id = NULL / id != NULL  (X)

id IS NULL / id IS NOT NULL(O)

	SELECT animal_type, COUNT(animal_type) FROM animal_ins WHERE animal_type="CAT" OR animal_type="DOG" GROUP BY animal_type ORDER BY animal_type;

WHERE 절에서 사용하는 조건의 문자열은 대,소문자를 구분하지 않는다.("CAT" = "Cat", "DOG" = Dog)



###### 날짜(datetime) 검색

	select * from reviewboard where date(registeredDate) = "2020-04-02";

	select * from reviewboard where registeredDate >= "2020-04-02 00:00:00" and registeredDate <= "2020-04-02 23:59:59";
	
둘 다 같은 결과 값을 리턴한다.

하지만 밑에 쿼리문이 날짜를 파싱하는 단계가 없기 때문에 더 빠르다.

##### ORDER BY

ASC : 오름차순

DESC : 내림차순

차순을 명시하지 않으면 ASC가 Default으로 선택된다. 

	SELECT ins.animal_id, ins.name FROM animal_ins ins JOIN animal_outs outs ON ins.animal_id = outs.animal_id ORDER BY outs.datetime - ins.datetime DESC LIMIT 2;

조건을 단순히 칼럼명만 쓰는 것이 아니라 계산식을 쓸 수도 있다.

##### 정렬 조건 여러개 사용하기

	SELECT animal_id, name, datetime FROM animal_ins ORDER BY name, datetime DESC;

작성하는 순서가 정렬되는 우선순위다.

	ORDER BY outs.datetime - ins.datetime

기간을 계산해 정렬기준으로 삼을 수도 있다.

##### GROUP BY

특정 속성에 따른 그룹을 지어 출력한다

	SELECT animal_type, COUNT(animal_type) AS count FROM animal_ins WHERE animal_type='Cat' OR animal_type="Dog" GROUP BY animal_type ORDER BY animal_type;


animal_type이 같은 튜플들 끼리 그룹을 지어서 출력된다.

##### HAVING

GROUP BY groupName 의 조건을 추가해 원하는 튜플만 출력되도록 한다.

	SELECT name, COUNT(name) AS "COUNT" FROM animal_ins GROUP BY name HAVING COUNT(name) > 1 ORDER BY name;

출력되는 튜플 중 name의 count가 2이상인 튜플만 출력한다.

- 
- 
-  함수(COUNT, SUM, MAX)는 HAVING 절에서만 쓸 수 있다.(WHERE절에서는 불가능. WHERE 절에서 HOUR, MONTH 등의 함수는 사용 가능하다.)

##### DISTINCT

GROUP BY와 같은 논리로 작동한다(중복을 제거하는 것과 같은 것끼리 그룹화 하는 건 같은 원리니까)

중복되는 데이터를 제거한 결과를 출력한다.

	SELECT COUNT(DISTINCT name) AS count FROM animal_ins WHERE name IS NOT NULL;

	// 중복이 제거된 이름의 개수를 출력한다.

	SELECT DISTINCT name AS count FROM animal_ins WHERE name IS NOT NULL;

	// 중복이 제거된 이름을 전부 출력한다.

중복되는 name을 제외하고 카운트를 한다.

##### 출력되는 튜플의 개수 제한하기

	SELECT name FROM animal_ins ORDER BY datetime LIMIT 1;

"LIMIT 제한할 개수" 를 입력하면 된다.

---

인자가 두 개인 경우

LIMIT 시작 index, 개수 : 시작 index부터 개수만큼 뽑는다. (인덱스는 0부터 시작)  

	SELECT name FROM animal_ins ORDER BY datetime LIMIT 4, 10;

4(5번째 인덱스) 부터 10개가 출력된다.

#### 함수

##### 집계 함수

COUNT/SUM/AVG/MAX/MIN(속성명) : 개수, 합계, 평균, 최댓값, 최솟값

- 조건으로 사용할 때는 반드시 GROUP BY절의 HAVING절에서만 사용할 수 있다.(WHERE절에서 사용불가, 집계를 위해서는 그룹화가 필수니까)


###### COUNT(속성명)의 경우 

NULL값이면 COUNT하지 않는다.

##### 논리관련 함수

IF(논리식,참일 때 값,거짓일 때 값) : 논리식이 참이면 참일 때 값을 출력하고 논리식이 거짓이면 거짓일 때 출력한다.
	SELECT animal_id, name, IF(sex_upon_intake LIKE '%Intact%', 'X', 'O') AS '중성화' FROM animal_ins ORDER BY animal_id;

IFNULL(값1,값2) : 값1이 NULL 이면 값2로 대치하고 그렇지 않으면 값1을 출력

	SELECT animal_type, IFNULL(name, 'No name'), sex_upon_intake FROM animal_ins ORDER BY animal_id;

"No name"은 대소문자를 구별해서 출력해줘야 한다.

##### IN

WHERE id IN(레코드1, 레코드2,...,레코드N)

id가 해당 레코드 중에 일치하는 값이 있는 튜플만 반환한다.

WHERE id NOT IN(레코드1, 레코드2,...,레코드N)

id가 해당 레코드에 포함되지 않는 튜플만 반환한다.

IN / NOT IN 모두 레코드의 대소문자를 구별하지 않는다.

##### LIKE

yoo를 포함하는 id

	WHERE id LIKE '%yoo%'

yoo로 시작하는 id

	WHERE id LIKE 'yoo%'

yoo로 끝나는 id

	WHERE id LIKE '%yoo'

LIKE 오른쪽에 들어가는 조건은 대소문자를 구별하지 않는다.

##### BETWEEN

	SELECT HOUR(datetime), COUNT(datetime) FROM animal_outs WHERE HOUR(datetime) BETWEEN 9 AND 21 GROUP BY HOUR(datetime) ORDER BY HOUR(datetime);

BETWEEN a AND b 에서 a와 b를 모두 포함한다.


##### 문자관련 함수

- 시작위치는 1부터(index 아님)

LEFT('문자열',개수) : 문자열 중 왼쪽에서 개수만큼을 추출

RIGHT('문자열',개수) : 문자열 중 오른쪽에서 개수만큼을 추출

MID('문자열',시작위치,개수) : 문자열 중 시작위치부터 개수만큼 출력

SUBSTRING('문자열',시작위치,개수) : 문자열 중 시작위치부터 개수만큼 출력

SUBSTR('문자열',시작위치,개수) : 문자열 중 시작위치부터 개수만큼 출력

시작위치는 첫 자리가 1부터 시작하는 위치다.(0부터 시작하는 인덱스 아님)

MID, SUBSTRING, SUBSTR 모두 사용법, 결과값이 같다.

---


##### 날짜관련 함수

YEAR(날짜)  날짜의 연도 출력

MONTH(날짜)  날짜의 월 출력

---

##### 시간관련 함수

DATE_FORMAT

날짜를 원하는 형식으로 출력할 수 있다.

	select DATE_FORMAT('1997-10-04 22:23:00', '%H %k %I %r %T %S %w'); 

%M (달 이름), %W (요일 이름), %Y (YYYY 형식의 년도), %y (YY 형식의 년도)

, %a (요일 이름의 약자)

년 : %Y (YYYY 형식의 년도), %y (YY 형식의 년도)

월 : %m(MM 형식의 월, 0포함)) , %c (M 형식의 날짜, 0 제외)

일 : %d (DD 형식의 일(ex) 05)), %e (D 형식의 일 ex) 5 (0 제외))

시간:  %H (HH 형식의 시간, 24시간 형식, 0포함), %k (H 형식의 시간, 24시간 형식, 0 제외)

, %h (HH 형식의 시간, 12시간 형식, 0포함), %i (MM 형식의 분, 0포), %p (AM 또는 PM)


DAYOFWEEK(date) : 해당 날짜의 요일을 숫자로 반환한다. 일요일은 1, 토요일은 7 이다.

WEEKDAY(date) : 해당 날짜에 대한 요일을 반환한다. 월요일은 0, 일요일은 6 이다.

DAYOFYEAR(date) : 해당 날짜의 1월 1일부터의 날수를 반환한다. 결과값은 1에서 366 까지이다.

YEAR(date) : 해당 날짜의 년을 반환한다.

MONTH(date) : 해당 날짜의 월을 반환한다.

DAYOFMONTH(date) : 해당 날짜의 일을 반환한다. 결과값은 1 에서 31 까지이다.

HOUR(time) : 해당날짜의 시간을 반환한다. 결과값은 0 에서 23 이다.

MINUTE(time) : 해당날짜의 분을 반환한다. 결과값은 0 에서 59 이다.

SECOND(time) : 해당날짜의 초를 반환한다. 결과값은 0 에서 59 이다.

DAYNAME(date) : 해당 날짜의 요일 이름을 반환한다. 일요일은 'Sunday' 이다.

MONTHNAME(date) : 해당 날짜의 월 이름을 반환한다. 2월은 'February' 이다.



##### AS

출력되는 데이터의 속성명을 지정

	SELECT COUNT(*) AS count FROM animal_ins;

	SELECT COUNT(*) count FROM animal_ins;


AS를 생략해도 동일한 결과가 나온다. 별칭은 ""로 감싸도 무관하다.


