class TowerOfHanoi
{
	// 원판 이동 함수 시작 
	public void moveTower( int numDisks, int start, int temp, int end ) 
	{
		if (numDisks == 1)
			moveOneDisk (start, end);	
		else
		{
	  		// N-1개 원판을 출발기둥에서 임시기둥으로 모두 이동 
			moveTower( numDisks-1, start, end, temp );	
	  		// 가장 큰 원판을 출발기둥에서 도착기둥으로 이동 
			moveOneDisk (start, end);	
	  		// N-1개 원판을 임시기둥에서 도착기둥으로 모두 이동 
			moveTower( numDisks-1, temp, start, end );	
		}
	// 원판 이동 함수 종료 
	}
   private void moveOneDisk (int start, int end ) 
   {
      System.out.println ("Move one disk from " + start + " to " + end);
   }
}

public class TowerOfHanoi_Main
{
	//프로그램시작 
   public static void main (String[] args)
   {
	  //하노이 타워 생성 
      TowerOfHanoi towers = new TowerOfHanoi();
	  // 3개의 원판을 1(출발), 2(임시), 3(도착) 기둥을 이용해 이동 
      towers.moveTower( 3, 1, 2, 3 ); 
	  //프로그램종료 
	  return;
   }
}

