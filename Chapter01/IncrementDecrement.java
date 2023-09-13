import java.lang.System;
import java.util.Scanner;

public class IncrementDecrement 
{
	// 프로그램 시작 
	public static void main( String[] args ) 
	{
		// 변수 선언 및 초기화
		int a = 3, b = 3, c = 0, d = 0;

		// 증가연산자(++)의 전위연산자와 후위연산자 실습  
		c = ++a;
		d = b++;

		// 증가연산자의 실습결과 출력 
		System.out.println( "a = 3일 때 c = ++a 적용 후 결과 a = " + a + ", c = " + c );			
		System.out.println( "b = 3일 때 d = b++ 적용 후 결과 b = " + b + ", d = " + d );			

		// 감소연산자(--)의 전위연산자와 후위연산자 실습 
		c = --a;
		d = b--;

		// 감소연산자의 실습결과 출력 
		System.out.println( "a = 4일 때 c = --a 적용 후 결과 a = " + a + ", c = " + c );			
		System.out.println( "b = 4일 때 d = b-- 적용 후 결과 b = " + b + ", d = " + d );			

		// 프로그램 종료 
		return;
	} 
}

