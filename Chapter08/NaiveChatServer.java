import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**************
 * 채팅 프로그램의 네트워크 서버 초기 버전
 * @author So Young Park
 * @version 0.8
 */	
public class NaiveChatServer
{
	public static void main(String[] args) 
	{
		try 
		{
			System.out.println( "[Client]가 대화를 시작할 때까지 잠시만 기다려 주세요" );

			// 네트워크 서버 연결 초기화 
			// 서버 소켓 연결 
			ServerSocket serverSocket = new ServerSocket( 7700 ); 
			// 클라이언트에서 서버로 연결 요청시 연결 활성화 
			Socket socket = serverSocket.accept();

			// 네트워크 입출력 연결 초기화 
			BufferedReader networkIn = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
			PrintWriter networkOut = new PrintWriter( socket.getOutputStream(), true );
			Scanner scan = new Scanner( System.in ); 

			// 서버에서 클라이언트-서버 순서대로 대화 반복  
			while( true )
			{
				// 클라이언트가 네트워크로 보낸 데이터 읽기  
				String clientMessage = networkIn.readLine();
				System.out.println( "[Client] " + clientMessage );

				// 클라이언트가 대화 종료 
				if( clientMessage.equals( "bye" ) )
				{
					System.out.println( "[Client]가 대화를 종료하였습니다" );
					break;					
				}
				
				// 서버의 입력 데이터를 네트워크로 전송  
				System.out.print( "[Server] " );
				String serverMessage = scan.nextLine(); 
				networkOut.println( serverMessage );
			}

			// 네트워크 연결 해제 
			networkIn.close();
			networkOut.close();
			socket.close();
			serverSocket.close();
			scan.close();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
}
	}


