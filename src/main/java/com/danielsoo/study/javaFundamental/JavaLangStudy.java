package com.danielsoo.study.javaFundamental;
import static java.lang.Math.*;
import static java.lang.System.*;

public class JavaLangStudy {
    public static void main(String ... args){
        System.out.println("hi");
        floor(20.5);
    }
}

/**
 1.4 Math Class
 1) private 생성자로 다른 클래스에서 인스턴스를 생성할 수 없다.
 2) 모든 메서드는 static으로 인스턴스변수가 하나도 없다.
 3) 2개의 상수만 정희해놨다.
 - public static final double E = 2.718....; - 자연로그의 밑
 - public static final double PI = 3.141592...;  - 원주율
 */
class MathStudy{
    public static void main(String ... args){
        simpleCal();
    }
    /**
     소수첫째자리에서
     1) 올림 .ceil(double a)
     2) 버림 .floor(double a)
     3) 반올림  .round(double a) -> long 반환
               .rint(double a) -> double 반환, 정가운데에 있는 경우 가까운 짝수 정수를 반환.
     */
    private static void simpleCal(){
        out.println(floor(1.6)); // 1.0
        out.println(ceil(1.6525*1000)/1000.0); // 1.653
        out.println(ceil(1.6525*1000)/1000); // 1.653
        out.println(round(2.6255*1000)/1000.0); // 2.626
        out.println(round(2.6255*1000)/1000); // 2
        out.println(round(-1.5)); // -1
        out.println(rint(2.6)); // 3.0
        out.println(rint(-1.5)); // -2.0
    }
    /**
     예외를 발생시키는 메서드 ~Exact
     정수형 간의 연산에서 발생하는 오버플로우를 감지해, 발생하면 ArithmeticException발생시킴
     */
}
