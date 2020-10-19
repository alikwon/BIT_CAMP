package studygroup;

import java.util.ArrayList;

public class EnumEx {

   // 기존에 상수를 정의하는 방법
   public static final String MALE = "MALE";
   public static final String FEMALE = "FEMALE";

   public static void main(String[] args) {
//    String gender1;
//      
//     gender1 = EnumExample.MALE;
//     gender1 = EnumExample.FEMALE;
//
//     //MALE, FEMALE이 아닌 상수 값이 할당 될 때 
//     //컴파일시 에러가 나지 않음. -> 문제점 발생.
//     gender1 = "boy";
      Gender1 gender1 = Gender1.MALE;
      Gender2 gender2 = Gender2.MALE;
      ArrayList <Object> a = new ArrayList<Object>();
      a.add(gender1);
      a.add(gender2);
      System.out.println(0);
      gender1 = Gender1.MALE;
      gender1.setColor("brown");
      System.out.println(gender1.color);
      System.out.println(1);
      // gender2 = Gender.FEMALE;
      System.out.println(2);
      // System.out.println(gen1der2);
      System.out.println(a.get(0) instanceof Gender1);
      System.out.println(a.get(1) instanceof Gender1);
      System.out.println(gender1.color);
      System.out.println(gender1.a);
      // 컴파일 시 의도하지 않는 상수 값을 체크할 수 있음.
      // Enum으로 정의한 상수값만 할당 받을 수 있음.
      // gender2 = "boy";
   }

   enum Gender1 {
      MALE("red", 3), FEMALE("blue", 4);

      public String color;
      int a;

      Gender1(String color, int a) {
         System.out.println("Call Constructor " + this);
         this.a = a;
         this.color = color;
      }

      public String getColor() {
         return color;
      }

      public void setColor(String color) {
         this.color = color;
      }

   }

   enum Gender2 {
      MALE("purple", 3), FEMALE("black", 4);

      
      public String color;
      int a;

      Gender2(String color, int a) {
         System.out.println("Call Constructor " + this);
         this.a = a;
         this.color = color;
      }
      
      public String getColor() {
         return color;
      }

      public void setColor(String color) {
         this.color = color;
      }
      
   }
}
//enum class를 이용해 Gender라는 새로운 상수들의 타입을 정의한다.