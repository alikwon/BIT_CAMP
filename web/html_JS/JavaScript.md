# 자바 스크립트

## 1. 자바스크립트의 활용

- 인터넷 연결 없이 웹 브라우저에서 실행가능한 웹어플리케이션
  - computer 브라우저(chrome)에서 실행됨



## 2. 자바스크립트 기본 문법

- 식별자 생성 규칙 : camel case방식을 주로 사용 
  - 소문자 시작, 여러 단어로 이루어지면 각단어 첫글자는 대문자
- 데이터의 출력
  - alert() 함수 : 문자열, 숫자, 함수, 객체, 배열(객체)
  - console.log() : 문자열, 숫자, 함수, 객체, 배열(객체)
- 데이터 : 문자
  - 문자 표현 ==> ' ' 또는 " "
- 데이터 : 숫자
  - 정수와 실수를 구분하지 않음
- 연산자 : 산술연산자 → + - * / %
  - 우선순위는 () 가 최우선 , 기본순서와 동일
- 데이터 : bool true / false
- 비교연산자 : 결과는 true / false
- 변수 : var 변수이름;







## 5.  자바스크립트 함수

- 함수 : 코드의 집합 ( ex : alert(), prompt() )

  - 익명 함수 : 형태는 함수지만 이름이 없음 ,**변수에 대입해서 쓸 때 사용 ( 변수 이름이 함수이름이 됨 )**

  - 선언적 함수 : 이름이 있는 함수

  - **변수처럼 재정의 가능하다.**

    ```javascript
    // 익명함수 : var 변수이름 = function(){}; 
    var addNum = function(x,y){
                	return x+y;
            	};
    
    // 선언적 함수 : function 함수이름(매개변수){ 코드 내용; };
    function addNum2(x,y) { 
    	return x+y;
    };
    
    //함수 호출
    var sum = addNum(10,20));
    var sum = addNum2(30,40));
    ```

    ※ window객체 →  최상위 객체

    

  - 매개변수와 리턴값

    - 매개변수 : 함수호출시 괄호 안에 적는 것, 대입할 때 타입정해짐 → 문법적 문제는 없으나 생각해야할 부분

    - <u>**선택적**</u> 매개변수와 리턴값 사용 

    - Array() 함수의 형태

      | 함수 형태             | 설명                                     |
      | --------------------- | ---------------------------------------- |
      | Array()               | 빈 배열 만들기                           |
      | Array(number)         | 매개변수만큼의 크기를 가지는 배열을 만듦 |
      | Array(any, ... , any) | 매개변수를 배열로 만듦 (가변 매개변수)   |

    - 가변 인자 함수 

      - 매개변수가 변할수 있는 함수

      - 리턴 키워드 : 함수 실행중 함수를 호출한 곳으로 돌아가라는 의미

      - samAll() 함수

        - **arguments : 매개변수의 배열 , 자바스크립트 내부에서 기본으로 제공**

          ```javascript
          function sumAll(){
          	var output = 0;
              //arguments는 가변 매개변수에 전달되는 값들을 배열로 저장해놓음
          	for(var i =0; i<arguments.length; i++){
          		output += arguments[i];
                   console.log('output +'+arguments[i]+'=> '+output); //디버깅
          	}
          	return output;
          }
          
          //함수 호출
          alert(sumAll(1,2,3,4,5,6,7,8,9))
          
          ```

          

    - 콜백 함수★★★

      - 매개변수로 전달하는 함수 (함수가 매개변수 )
      - callTenTimes() 함수 : 함수를 매개변수로 받아 해당함수를 10번 호출

      ```javascript
      //콜백함수 : 매개변수로 전달된 함수
      //	정의하는 함수 내부에서 실행할 목적으로 구성한다.
      function callTenTimes(callback){
          if(typeof(callback)=='function'){
              for(var i =0; i<10; i++){
                  callback();
              }
          }
      }
      var cnt = 0;
      var handler = function(){
          console.log('handler function'+cnt++);
      };
      
      callTenTimes(handler);
      ```

      

    - 내장 함수 : 기본적으로 내장된 함수 , ex) alert(), prompt()

      - 타이머 함수 : 특정시간에 특정한 함수 실행 가능하게 한다.

        | 메서드                            | 설명                                        |
        | --------------------------------- | ------------------------------------------- |
        | setTimeout(function, milisecond)  | 일정시간 후 함수를 한 번 실행               |
        | setInterval(function, milisecond) | 일정시간마다 함수를 반복실행                |
        | clearTimeout(id)                  | 일정시간 후 함수를 한 번 실행하는 것을 중지 |
        | clearInterval(id)                 | 일정시간 마다 함수를 반복하는 것을 중단     |

        - setInterval() : 지속적인 매모리 소비 → 타이머를 멈춤으로 해결

        ```javascript
        //내장 함수 : alert(), prompt(), confirm()
        // setTimeout(callback, ms) → ms 이후에 callback() 한번 실행
        // setInterval(callback, ms) → ms 마다 callback() 실행 반복
        var intervalId = setInterval(function(){
            document.body.innerHTML='<h1>'+new Date+'</h1>'
        },1000);
        
        setTimeout(function(){
            clearInterval(intervalId);
        }, 10*1000);
        ```

      - 코드 실행 함수 : 문자열을 코드로 실행할 수 잇는 특별한 함수 제공

        - eval() : 문자열을 자바스크립트 코드로 실행하는 함수

          ```javascript
          var jsCode ='';
          jsCode +='var number=100;';
          jsCode += 'alert(number)';
          
          eval(jsCode);
          ```

      - 숫자 변환 함수 : Number(), parseInt(), parseFloat() 

        - Number()는 숫자로 못바꾸면 NaN
        - parseInt(), parseFloat()  는 변환할 수 있는 부분까지 모두 숫자로 변환



## 6. 자바스크립트 객체

- 자바스크립트에서는 숫자, 문자열, 불리언, undefined 타입을 제외한 모든 것이 객체

- But 숫자, 문자열, 불리언과 같은 원시 타입은 **값이 정해진 객체**로 취급되어, 객체로서의 특징도 함께 가지게 된다

- 속성과 메서드
  - 속성 : 객체 내부에 있는 값  (※ 요소 : 배열 내부에 잇는 값)
  
  - 메서드 :  객체 속성중 function 자료형인 속성
  
  -  동적으로 속성추가 or 삭제
  
    ```javascript
    //속성 부여
    var person={
        name:'손흥민',
        age:27,
        hello:function(){
            alert('안녕하세요. 저는'+this.name+'입니다');
            alert('나이는 '+this.age+'살 이에요.');
            this.bye(); //객체 내부 메서드 호출
        },
        bye : function(){
            alert('ㅃㅃ~!!');
        }
    };
    console.log(person); //객체 내부 속성을 전부 출력
    
    person.hello(); // 객체내부 hello 메서드 실행
    
    // job 속성 바로 추가하기 가능 
    //(변수 뿐 아니라 메서드 추가도 가능)
    person.job='player';
    alert(person.job);
    ```
  
    
  
- 객체와 배열을 사용한 데이터 관리

  - 학생의 성적 총점과 평균을 계산하는 예제

    ```javascript
    //빈 배열선언
    var students = [];
    
    //데이터 추가
    students.push({name :'A1',kor:90,math:40,eng:100});
    students.push({name :'A2',kor:100,math:50,eng:20});
    students.push({name :'A3',kor:70,math:10,eng:40});
    students.push({name :'A4',kor:80,math:70,eng:30});
    students.push({name :'A5',kor:60,math:80,eng:80});
    students.push({name :'A6',kor:50,math:90,eng:50});
    students.push({name :'A7',kor:30,math:100,eng:60});
    students.push({name :'A8',kor:20,math:30,eng:70});
    students.push({name :'A9',kor:10,math:60,eng:60});
    students.push({name :'A10',kor:60,math:20,eng:100});
    
    //각각 배열의 요소인 객체에 과목점수 총합을 구하는 메서드를 추가해주기
    for(var i in students){
        students[i].getSum = function(){
            return this.eng + this.kor + this.math;
        };
    }
    
    // 평균 구하는 메서드 추가
    for(var i in students){
        students[i].getAvg = function(){
            return this.getSum()/3;
        };
    }
    console.log(students); // 추가 됐는지 확인
    var list ='';
    for(var i in students){
        list += '<h4> 이름 : '+ students[i].name;
        list += '총점 : '+ students[i].getSum();
        list += '평균 : '+ students[i].getAvg();
        list += '</h4>';
    }
    document.write(list);
    ```

    

## 7. 생성자 함수

- 생성자 함수 : new 키워드를 사용해서 객체를 생성할 수 있는 함수

- this 키워드 : 생성자 함수로 생성될 객체의 속성(변수 , 메서드) 지정

- 프로토 타입 : 동일한 함수 생성에 따른 비효율적인 메모리 이용을 해결하는 방안

  ​					==> 공통함수를 정의 ( 한개의 메서드로 모든 객체가 사용 )

- ***(사진 넣으세요)***

  ```javascript
  //	 new 키워드를 이용해서 객체 생성
  //	 생성자 함수의 이름은 대문자 시작
  function Student(name, kor_sc, math_sc, eng_sc){
      this.name = name;
      this.kor = kor_sc;
      this.math = math_sc;
      this.eng = eng_sc;
      //메서드 생성
      this.getSum = function(){
       	return this.kor+this.eng+this.math;
       };
      this.getAvg = function(){
       	return this.getSum()/3;
       };
  }
  
  /*
  // 프로토 타입
  // 생성자 함수로 생성된 객체가 동일한 함수 생성함에 따른 비효율적 메모리 이용을 해결 
  // ==> 공통함수 정의
  Student.prototype.getSum = function(){
      return this.eng+this.kor+this.math;
  };
  Student.prototype.getAvg = function(){
      return this.getSum()/3;
  };
  */
  //생성자 함수를 이용해서 객체 배열 생성
  var students =[];
  students.push(new Student('A1',90,100,20));
  students.push(new Student('A1',80,50,30));
  students.push(new Student('A1',60,70,40));
  students.push(new Student('A1',10,100,50));
  students.push(new Student('A1',90,10,20));
  ```

  

- 캡슐화

- **<u>좀더 공부해야할거같음 </u>**





## 8.기본 내장 객체

- JSON

