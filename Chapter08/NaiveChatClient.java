import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**************
 * 채팅 프로그램의 네트워크 클라이언트 초기 버전
 * @author So Young Park
 * @version 0.8
 */	
public class NaiveChatClient
{
	public static void main(String[] args) 
	{
		try 
		{
			System.out.println( "[Server]와 함께 얘기 해요 바로 시작해 주세요 bye를 입력하면 종료됩니다" );

			// 네트워크 클라이언트 연결 초기화 
			// 클라이언트에서 서버로 연결 요청 
			Socket socket = new Socket( "localhost", 7700 );

			// 네트워크 입출력 연결 초기화  
			BufferedReader networkIn = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
			PrintWriter networkOut = new PrintWriter( socket.getOutputStream(), true );
			Scanner scan = new Scanner( System.in ); 
			
			// 클라이언트에서 클라이언트-서버 순서대로 대화 반복 
			while( true )
			{
				// 클라이언트의 입력 데이터를 네트워크로 전송  
				System.out.print( "[Client] " );
				String clientMessage = scan.nextLine(); 
				networkOut.println( clientMessage );

				// 클라이언트가 대화 종료 
				if( clientMessage.equals( "bye" ) )
				{
					System.out.println( "[Client]가 대화를 종료하였습니다" );
					break;					
				}

				// 서버가 네트워크로 보낸 데이터 읽어서 출력 
				String serverMessage = networkIn.readLine();
				System.out.println( "[Server] " + serverMessage );
			}

			// 네트워크 연결 해제   
			networkIn.close();
			networkOut.close();
			socket.close();
			scan.close();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
}

