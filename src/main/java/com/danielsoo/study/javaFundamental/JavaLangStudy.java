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
        try {
            out.println("----simpleCal------");
            simpleCal();
            out.println("----exactCal------");
            exactCal();
            out.println("----trigonometricalFunction------");
            trigonometricalPractice();
        }catch (Exception e){
            e.printStackTrace();
        }
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
     1) x + y : int addExact(int x, int y)
     2) x - y : int subtractExact(int x, int y)
     3) x * y : int multiplyExact(int x, int y)
     4) a ++  : int incrementExact(int a)
     5) b --  : int decrementExact(int b)
     6) -a    : int negateExact(int,long a)
     7) (int)longValue : int toIntExact(long value)
     */
    private static void exactCal(){
        int i = Integer.MIN_VALUE;
        try{
            negateExact(i); //Exception Occurred
        }catch (ArithmeticException ae){
            out.printf("ArithmeticExceptionCaught: %d%n", negateExact((long)i));
        }
    }
    /**
     Trigonometrical Function
     - 1PI rad = 180 degree  , 1rad = 180/PI
     - sin(rad), cos(rad)
     - atan2(a, b) -> 직각삼각형의 두변의 길이를 알면, 끼인각을 라디안 단위로 구해준다.
                      도(degree)단위로 변환하려면 꼭 180/PI를 곱하자
     - log10(a)
     */
    private static void trigonometricalPractice(){
        int x1 = 1, y1 = 1;
        int x2 = 2, y2 = 2;
        double a = sqrt(pow(x1-x2, 2) + pow(y1-y2, 2));
        double b = a*cos(PI/4);
        double c = a*sin(PI/4);
        out.printf("a = %f, b = %f, c = %f%n", a, b, c);
        double radianAngle = atan2(3.0, 4.0);
        double degreeAngle = atan2(3.0, 4.0)*180/PI;
        out.printf("radianAngle = %f, degreeAngle = %f%n", radianAngle, degreeAngle);
        out.println("log10(50) = " + log10(50.0));
    }
    /**
     StrictMath Class
     : Math는 성능을 위해 OS메서드를 호출해서 사용하나 OS에 의존적인 계산으로 OS마다 값이 다를 수 있다.
       이를 대신해 성능을 포기하고 모두 같은 값이 나오도록 한 것이 StrictMath Class
     - 절댓값     : abs(a) -> 인수의 자료형과 결과의 자료형이 같음
     - 올림, 버림 : double ceil(double a), double floor(double b)
     - 반올림     : long round(double/float a), double rint(double a)
     - 최대, 최소 : max(a), min(a) -> 인수의 자료형과 결과의 자료형이 같음
     - 0.0<= 랜덤 <1.0 : double random()
     */
    private static void strictMathPractice(){
    }
    /**
     Wrapper Class
     : 8 primitive types 을 어쩔 수 없이 객체로 다뤄야할 때 사용한다.
     - 생성자는 각 자료형에 맞춰야 하거나, 문자열도 가능하다.

     */

}
