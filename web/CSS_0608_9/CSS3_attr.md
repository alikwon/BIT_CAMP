# CSS3 속성

## 1. CSS3 단위

- 키워드 단위

  - 키워드를 스타일 값으로 입력
    → 키워드에 해당하는 스타일이 자동으로 적용
  - 통합 개발 환경에서는 입력한 속성에 속한 키워드를 자동으로 알려줌

- 크기 단위

  - CSS3에서 가장 많이 사용하는 단위

  - **16px = 1em = 100%**

    | 단위 | 설명                           |
    | :--: | ------------------------------ |
    |  %   | 백분율 단위 (em보다 많이 사용) |
    |  em  | 배수 단위 (1em = 100%)         |
    |  px  | 픽셀                           |

- 색상 단위

  - 색상에 해당하는 영단어 입력

    | 단위형태                      | 설명                           |
    | ----------------------------- | ------------------------------ |
    | rgb(red, green, blue)         | RGB 색상 단위 ( 각각 0 ~ 255 ) |
    | rgba(red, green, blue, alpha) | RGBA 색상 단위                 |
    | #000000                       | HEX 코드 단위                  |

- URL단위

  - 이미지나 글꼴 파일을 불러올 때 사용
  - background-image 속성 사용

## 2. 박스 속성

![](https://github.com/alikwon/web/blob/master/CSS_0608_9/css_boxproperty.png?raw=true)

- width와 height 속성 : 글자를 감싸는 영역의 크기를 지정
- boder 속성 : 테두리의 두께를 지정
- margin 속성 : 테두리와 다른 태그와의 간격을 지정
- padding 속성 : 테두리와 글자 사이의 간격을 지정
- border-width 속성 : 테두리의 두께 지정
- border-style 속성 : 테두리의 형태 지정
- border-radius 속성 : 테두리가 둥근 사각형 또는 원 생성 가능

## 3. Display 속성

| 키워드 이름  | 설명                                    |
| ------------ | --------------------------------------- |
| none         | 태그를 화면에서 보이지 않게 만듭니다.   |
| block        | 태그를 블록 형식으로 지정합니다.        |
| inline       | 태그를 인라인 형식으로 지정합니다.      |
| inline-block | 태그를 인라인-블록 형식으로 지정합니다. |

- 인라인 형식과 인라인-블록 형식의 차이
  - inline 키워드를 적용한 코드
    - width와 height 속성이 지정되지 않음
    - margin 속성이 div 태그의 좌우로만 적용
  - inline-block 키워드를 적용한 코드 (이미지를 블록으로 ...)
    - width와 height 속성이 적용
    - margin 속성도 상하좌우로 적용

## 4. 배경 속성

| 속성 이름             | 설명                         |
| --------------------- | ---------------------------- |
| background-image      | 배경 이미지 지정             |
| background-size       | 배경 이미지의 크기 지정      |
| background-repeat     | 배경 이미지의 반복 형태 지정 |
| background-attachment | 배경 이미지의 부착 형태 지정 |
| background-position   | 배경 이미지의 위치 지정      |
| background            | 한 번에 모든 배경 속성 지정  |

- 