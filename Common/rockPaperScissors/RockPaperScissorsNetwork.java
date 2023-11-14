package rockPaperScissors;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import network.Network;

/**
 * 가위바위보 프로그램의 네트워크 담당 클래스
 * @author So Young Park
 * @version 0.8
 * @see     net.Network()
 */	
public class RockPaperScissorsNetwork extends RockPaperScissorsPanel implements Runnable
{	
	/** 
	 * 네트워크
	 */	
	private Network network;
	/** 
	 * 가위바위보 참여자 아이디
	 */	
	private String id;
	/** 
	 * 상대편 가위바위보 선택 결과 
	 */	
	private int counterpart;
	/** 
	 * 가위바위보 메시지 헤더 
	 */	
	private final String headerMessage = "[RPSN] ";
	/** 
	 * 네트워크 연결 해제 메시지
	 */	
	private final String disconnectMessage = " -1";

	/**
	 * 가위바위보 프로그램의 네트워크 초기화
	 */
	public RockPaperScissorsNetwork() 
	{
		super();
		id = "[" + JOptionPane.showInputDialog( this, "아이디를 입력해주세요.", "아이디" ) + "]";
		super.strPlayers.setText( "<html><body style='text-align:center;'>상대편이 준비중입니다 기다려주세요<br>"+ id +"</body></html>" );			
		super.disableSelection();
		network = new Network();
	}
	
	/**
	 * 가위바위보 프로그램의 네트워크 초기화
	 * @param serverIP 서버 IP 주소
	 */
	public RockPaperScissorsNetwork( String serverIP )
	{
		this();
		connectAsClient( serverIP );
	}

	/**
	 * 가위바위보 프로그램의 네트워크 클라이언트 연결 초기화  
	 * @param serverIP 서버 IP 주소
	 */
	public void connectAsClient( String serverIP )
	{
		network.connectAsClient( serverIP, this );
		network.write( headerMessage + id + " " + game.selectRockPaperScissors() );
	}
	
	/**
	 * 가위바위보 프로그램의 네트워크 서버 연결 초기화 
	 */
	public void connectAsServer()
	{
		network.connectAsServer( this );
	}

	/**
	 * 가위바위보 입력시 게임 업데이트 
	 * @param event 가위바위보 선택 결과 
	 */
	@Override
	public void actionPerformed( ActionEvent event )
	{
		// 먼저 가위바위보 값을 확인 후 게임 업데이트 
		int player = super.selectRockPaperScissors( event );
		super.showGameResult( player, counterpart );
		super.disableSelection();
		network.write( headerMessage + id + " " + player );
	}

	/**
	 * 가위바위보 도착시 게임 업데이트 
	 */
	@Override
	public void run()  
	{		
		// 상대편이 네트워크로 보낸 가위바위보 값을 읽기 
		for ( String message = null; ( message = network.read() ) != null; )
		{	
			// 가위바위보 프로그램의 메시지가 아니면 무시 
			if ( !message.contains( headerMessage ) )
				continue;
			// 상대편이 네트워크 종료했으면 안내  
			else if ( message.contains( disconnectMessage ) )
			{
				super.strPlayers.setText( "<html><body style='text-align:center;'>상대편이 종료하였습니다<br>"+ id +"</body></html>" );
				super.imgPlayerB.setIcon( image[QUESTIONMARK][BASE] );
				super.disableSelection();
				network.write( headerMessage + id + disconnectMessage );
			}					
			else
			{
				// 가위바위보 값을 바탕으로 게임 업데이트 
				String[] tmp = message.substring(7).split( "] " );
				String counterpartID = tmp[0].trim() + "]";
				counterpart = Integer.parseInt( tmp[1].trim() );
				super.strPlayers.setText( "<html><body style='text-align:center;'>"+ counterpartID + "<br>"+ id +"</body></html>" );
				super.enableSelection();
			}
		} 
	}
	
	/**
	 * 가위바위보 프로그램의 네트워크 연결 해제 
	 */
	public void close()  
   	{
		// 상대편에게 네트워크로 프로그램 종료 알림 
		network.write( headerMessage + id + disconnectMessage );
		// 네트워크 연결 해제 	
		network.disconnect();
	}
}

