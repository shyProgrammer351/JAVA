import java.util.*;
import java.io.*;

public class FileCopyMain 
{
	// 프로그램시작 
	public static void main( String[] args ) 
{	
		try
		{
			BufferedReader inFile = new BufferedReader( new FileReader( new File( "C:\\Users\\user\\Downloads\\원본.txt" ) ) ); 	
			BufferedWriter outFile = new BufferedWriter( new FileWriter( new File( "C:\\Users\\user\\Downloads\\복사본.txt" ) ) ); 	
			// 원본 파일 끝까지 한 줄씩 읽기 
			for( String line = ""; ( line = inFile.readLine() ) != null; ) 
			{
				// 복사본 파일에 한 줄씩 쓰기 
				outFile.write( line + "\n" ); 		
			}

			// 버퍼에 남아있는 데이터를 파일에 강제 출력  			
			outFile.flush();						

			// 파일 닫기 
			inFile.close();							
			outFile.close();						
		}
		catch ( IOException e ) 					
		{
			System.out.println( "[오류] 파일을 열 수 없습니다!" );
			e.printStackTrace();
		}

		// 프로그램 종료 
		return;
	}
}

