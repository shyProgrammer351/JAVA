class Bankbook
{
	private String id;									
	private int money;									
	private static int totalMoney  = 0;	
	
	// 통장 초기화 
	public Bankbook( String id )
	{
		this.id = id;
		this.money = 0;
	}

	// 통장 입금
	public int deposit( int money )	 
	{
		this.money += money;
		this.totalMoney += money;
		return this.money;
	}

	// 통장 내역 문자열 변환
	public String toString()	
	{
		return this.id + " : " + this.money + "원\n총 예금액 : " + totalMoney + "원";
	}
	
	// 전체 통장의 총 예금액
	public static int getTotalMoney()	
	{
		return totalMoney;
	}
}

public class Bankbook_Main
{
	// 프로그램 시작 
	public static void main (String[] args)	
	{
		Bankbook bankbook;

		// 국민은행 통장 만들어 1000원 입금 후 출력 
		bankbook = new Bankbook ( "국민은행 통장" );
		bankbook.deposit( 1000 );
		System.out.println(
		                    bankbook ); 

		// 우리은행 통장 만들어 2000원 입금 후 출력 
		bankbook = new Bankbook ( "우리은행 통장" );
		bankbook.deposit( 2000 );
		System.out.println(
		                    bankbook );	 

		// 하나은행 통장 만들어 3000원 입금 후 출력 
		bankbook = new Bankbook ( "하나은행 통장" );
		bankbook.deposit( 3000 );
		System.out.println(
		                    bankbook ); 

		// 전체 전체 총 예금액 출력 
		System.out.println( "(전체 총 예금액) " 
					+ Bankbook.getTotalMoney() + "원" ); 
		
		// 프로그램 종료 
		return;
	}
}

