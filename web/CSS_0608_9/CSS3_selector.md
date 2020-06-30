# 	CSS3 선택자

## 1. 선택자 개요

- CSS3 선택자

  - 특정한 HTML 태그를 선택할 때 사용하는기능

  - 선택한 태그에 원하는 스타일 적용가능

    

  ```html
  // [css block]
  <style>
  	h1 { color: red; }
  </style>
  ```

  - h1 : 선택자
  - color : 스타일 속성
  - red : 스타일 값

- 스타일 시트 : style 태그 내부에 입력하는 코드

- 보통은 CSS 파일을 따로 빼서 불러오는 식으로 처리함

  

## 2. 기본선택자

|  선택자 종류  | 선택자 형태 | 설명                            |
| :-----------: | :---------: | ------------------------------- |
|  전체 선택자  |      *      | HTML문서 안의 모든 태그 선택    |
|  태그 선택자  |    태그     | HTML페이지 내부의 특정 태그     |
| 아이디 선택자 |     #id     | 특정 id 속성이 있는 태그를 선택 |
| 클래스 선택자 |   .클래스   | 특정 클래스가 있는 태그 선택    |

(**Tag 의 id 속성은 속성값을 중복해서 쓰지 않는다 →  자바스크립트에서 문제발생!!**)

- ###### 전체선택자

  ```html
  <style>
      * { color: red; }
  </style>
  ```
  
- ###### 태그 선택자

  ```html
  <style>
      /* p태그 */
      p {
          font-size: 20px;
          font-style: italic;
      }
  
      /* 여러 태그 */ 
      /* solid 한줄 외곽선 */
      /* margin, padding 간격 */
      h1,p {
          border: 5px solid blue;
          margin: 0;
          padding: 0;
      }
  </style>
  ```

  

- ###### 아이디 선택자

  ```html
  <style>
      #header {
          margin: 0 auto;
          width: 300px;
          background-color: skyblue;
      }
      #aside {
          margin: 20px auto;
          width: 200px;
          background-color: aquamarine;
      }
      #content {
          width: 500px;
          background-color: cadetblue;
      }
  </style>
  ```

  

- ###### 클래스 선택자

  ```html
  <style>
      .font_color {
          width: 200px;
          color: blanchedalmond;
          background-color: darkcyan
      }
      /* li 태그만 적용되게 해보기 */
      li.font_bold { font-weight: 900; }
  
      .font_size { font-size: 200%; }
   	/* div 태그만 적용되게 해보기 */
      div.font_bold { font-size: 150%; }
  </style>
  ```
  

## 

## 3. 속성 선택자 

| 선택자 형태             | 설명                                                     |
| ----------------------- | -------------------------------------------------------- |
| 선택자[속성이름]        | 특정 속성을 가지는 태그들을 선택 (ex) input[type])       |
| 선택자[속성이름=속성값] | 특정 속성을 가지며, 속성에 특성값을 가지는 태그들을 선택 |

```html
<style>
/* EX */
    /* 선택자[속성이름] */
    input[type] { height: 100px; }
    
    /* 선택자[속성이름=속성값] */
    input[type=text]{ background-color: aqua;}
    
    img[alt]{ width: 50%;}
    
    /* src속성값이 각각의 파일 형식일때 */
    img[src$=png]{ border: 3px solid red;}
    img[src$=jpg]{
        border: 3px solid blue;
        width: 40%;
    }
</style>
```

**※ width는 브라우저의 사이즈에 영향을 받는다.**



## 4. 후손 선택자와 자손 선택자

![후손 선택자와 자손선택자](https://github.com/alikwon/web/blob/master/CSS_0608_9/css_childselector.png?raw=true)

- ###### 후손 : 하나의 태그 아래의 모든 태그

  - 특정한 태그의 후손을 선택할때 사용

  - 선택자A 선택자B : 선택자 A의 후손인 선택자 B를 선택

  - 여러 개의 선택자를 함께 사용할 때 주의해야함

    ```html
    <style>
    /* EX */
        /* 후손선택자 */
        /* 선택자A 선택자B */
        div h1{ color: blue; }
        #nav h1{ color: red; }
        
        /* header 태그의 후손인 h1 태그를 선택하고 일반적인 h2 태그를 선택 */
        #header h1, h2 { color: red; }
        
        /* header 태그의 후손인 h1 태그와 header 태그의 후손인 h2 태그 선택 */
        #header h1, #header h2 { color: red; }
    </style>
    ```

- ###### 자손 : 하나의 태그 바로 밑의 태그

  - 특정한 태그의 자손을 선택할 때 사용

  - 선택자A > 선택자B : 선택자A의 자손인 선택자B 선택

  - **table 태그 적용시 웹 브라우저가 tbody 태그를 자동으로 추가하므로 스타일 속성이 적용되지 않음**

    ```html
    <style>
    /* EX */
        /* 자손선택자 */
        /* 선택자A > 선택자B */
        #header>h1{ background-color: black; }
        /* #header 밑의 모든 h1이 아니라 바로밑 자손만 영향을 받음 */
        
        table>tbody>tr>td{
        	/* 찾아들어가는 느낌 */  
        }
    </style>
    ```

- ###### 동위 선택자 :  동위 관계에서 뒤에 위치한 태그를 선택할때 사용

  |    선택자 형태     | 설명                                                         |
  | :----------------: | :----------------------------------------------------------- |
  | 선택자A + 선택자 B | 선택자A ***바로 뒤*** 위치하는 선택자B를 선택                |
  | 선택자A ~ 선택자 B | 선택자A 뒤에 위치하는 선택자B를 선택 **(같은 레벨의 형제 태그들)** |

  ```html
  <style>
  /* EX */
      /* h1 태그의 바로 뒤에 위치하는 h2 태그의 
      	color 속성에 red 키워드를 적용 */ 
      h1 + h2 { color: red; } 
      
      /* h1 태그의 뒤에 위치하는 h2 태그의 
      	background-color 속성에 orange 키워드를 적용 */ 
      h1 ~ h2 { background-color: orange; }
  </style>
  ```

  

## 5. 반응 선택자 : 

- 사용자의 반응으로 생성되는 특정한 상태를 선택할 때 사용

  | 선택자 형태   | 설명                                           |
  | ------------- | ---------------------------------------------- |
  | 선택자:active | 마우스로 클릭한 태그 선택 (클릭하고 있는 동안) |
  | 선택자:hover  | 마우스 커서를 올린 태그 선택                   |

```html
<style>
    /* EX */
    h3:active{
        color : cadetblue;
        font-style: italic;
    }

    h3:hover{
        color : red;
        font-size: 32px;
    }
</style>
```



## 6.  상태 선택자

- 입력양식의 상태를 선택할 때 사용

  | 선택자 형태 | 설명                       |
  | :---------: | -------------------------- |
  |  :checked   | 체크 상태의 input 태그     |
  |   :focus    | 초점이 맞추어진 input 태그 |
  |  :enabled   | 사용 가능한 input 태그     |
  |  :disabled  | 사용 불가능한 input 태그   |

  ```html
  <style> 
      /* input 태그가 사용 가능할 경우에 
      	background-color 속성에 white 키워드를 적용합니다. */ 
      input:enabled { background-color: white; } 
      
      /* input 태그가 사용 불가능할 경우에 
      	background-color 속성에 white 키워드를 적용합니다. */ 
      input:disabled { background-color: gray; } 
      
      /* input 태그에 초점이 맞추어진 경우에 
      	background-color 속성에 white 키워드를 적용합니다. */ 
      input:focus { background-color: orange; } 
      
      /* checkbox 타입에 체크가 된 경우에 
      	width 속성을 변경합니다. */
      input[type=checkbox]{ width = 30px; }
  </style>
  <body>
      <input type="text" disabled>
      <input type="checkbox" checked>
  </body>
  ```

  

## 7. 구조 선택자

- 특정한 위치에 있는 태그를 선택할 때 사용

  | 선택자 형태           | 설명                                                    |
  | --------------------- | ------------------------------------------------------- |
  | :first-child          | 형제 관계에서 **첫 번째로** 등장하는 태그 선택          |
  | :last-child           | 형제 관계에서 **마지막으로** 등장하는 태그 선택         |
  | :nth-child(수열)      | 형제 관계에서 **앞에서** 수열 번째로 등장하는 태그 선택 |
  | :nht-last-child(수열) | 형제 관계에서 **뒤에서** 수열 번째로 등장하는 태그 선택 |

  ```html
  <style>
      ul { overflow: hidden;}
  
      li {
          /*리스트 앞의 점*/
          list-style: none; 
          /*정렬방향*/
          float: left;
          /*간격*/
          padding: 15px;
      }
  
      /* 첫번째 태그*/
      li:first-child {
          /* 둥글게 */
          border-radius: 10px 0 0 10px;
      }
  
      /* 끝 태그*/
      li:last-child { border-radius: 0 10px 10px 0; }
  
      /* 수열 */
      li:nth-child(2n) { background-color: aquamarine; }
      li:nth-child(2n+1) { background-color: darkcyan; }
  </style>
  ```

  

## 8. 문자 선택자

- 태그 내부의 특정한 조건의 문자를 선택

- 시작 문자 선택자

  | 선택자 형태    | 설명                       |
  | -------------- | -------------------------- |
  | ::first-letter | 첫 번째 글자를 선택합니다. |
  | ::first-line   | 첫 번째 줄을 선택합니다.   |

- 반응 문자 선택자

  | 선택자 형태 | 설명                                     |
  | ----------- | ---------------------------------------- |
  | ::selection | 사용자가 **드래그한 글자**를 선택합니다. |

  ```html
  <style>
      /* 시작 문자 */
      p::first-letter { font-size: 3em; } 
      p::first-line { color: red; }
  
      /* 반응 문자 */
      p::selection { background: black; color: red; }
  </style>
  ```

  

## 9. 링크 선택자

- href 속성을 가지고 있는 a 태그와 한 번 이상 다녀온 링크를 선택할 수 있는 선택자이다.

  | 선택자 형태 | 설명                                             |
  | ----------- | ------------------------------------------------ |
  | :link       | href 속성을 가지고 있는 a 태그를 선택합니다.     |
  | :visited    | 방문했던 링크를 가지고 있는 a 태그를 선택합니다. |

  ```html
  <style>
      a { text-decoration: none; }
      a:visited { color: red; }
      /* href 속성을 가지고 있는 a 태그 뒤의 공간에 
      "- (href 속성)"을 추가합니다. */
      a:link::after { content: ' - ' attr(href); }
  </style>
  ```

  

## 10. 부정 선택자 

- 선택자를 모두 반대로 적용할 수 있게 만드는 선택자

  ```html
  <style>
      /* input 태그 중에서 type 속성값이 password가 아닌 태그의 
      	background 속성에 red 키워드를 적용합니다.*/
      input:not([type=password]) { background: red; }
  </style>
  ```