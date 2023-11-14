package threeCupGame;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import network.Network;

/**
 * 구슬찾기 프로그램의 네트워크 담당 클래스
 * @author So Young Park
 * @version 0.8
 * @see     net.Network()
 */	
public class ThreeCupGameNetwork extends ThreeCupGamePanel implements Runnable
{	
	/** 
	 * 네트워크
	 */	
	private Network network;
	/** 
	 * 구슬찾기 참여자 아이디
	 */	
	private String  id;
	/** 
	 * 구슬찾기 메시지 헤더
	 */	
	private final String headerMessage = "[TCGN] ";
	/** 
	 * 네트워크 연결 해제 메시지
	 */	
	private final String disconnectMessage = " -1";
	
	/**
	 * 구슬찾기 프로그램의 네트워크 초기화
	 */
	public ThreeCupGameNetwork() 
	{
		super();
		id = "[" + JOptionPane.showInputDialog( this, "아이디를 입력해주세요.", "아이디" ) + "]";
		super.label.setText( id +"님, 상대편이 준비중입니다 기다려주세요" );					
		super.disableSelection();
		network = new Network();
	}
	
	/**
	 * 구슬찾기 프로그램의 네트워크 초기화
	 * @param serverIP 서버 IP 주소
	 */
	public ThreeCupGameNetwork( String serverIP )
	{
		this();
		connectAsClient( serverIP );
	}

	/**
	 * 구슬찾기 프로그램의 네트워크 클라이언트 연결 초기화  
	 * @param serverIP 서버 IP 주소
	 */
	public void connectAsClient( String serverIP )
	{
		network.connectAsClient( serverIP, this );
		network.write( headerMessage + id + " " + getRandomCup() );
	}
	
	/**
	 * 구슬찾기 프로그램의 네트워크 서버 연결 초기화 
	 */
	public void connectAsServer()
	{
		network.connectAsServer( this );
	}

	/**
	 * 컵 번호 선택시 구슬찾기 게임 업데이트 
	 * @param event 구슬찾기 선택 결과 
	 */
	@Override
	public void actionPerformed( ActionEvent event )
	{
		// 컵 번호 입력값 확인 
		player = selectCup( event );
		// 컵 번호 입력값을 바탕으로 구슬찾기 게임 결과 업데이트 
		showGameResult( super.player, super.ball );
		label.setText( id +"님, 상대편이 준비중입니다 기다려주세요" );
		disableSelection();
		network.write( headerMessage + id + " " + super.player );
	}

	/**
	 * 컵 번호 도착시 구슬찾기 게임 업데이트 
	 */
	@Override
	public void run() 
	{		
		// 상대편이 네트워크로 보낸 컵 번호 읽기 
		for ( String message = null; ( message = network.read() ) != null; )
		{
			// 구슬찾기 프로그램의 메시지가 아니면 무시 
			if ( !message.contains( headerMessage ) )
				continue;
			// 상대편이 네트워크 종료했으면 안내  
			else if ( message.contains( disconnectMessage ) )
			{
				label.setText( "상대편이 종료하였습니다" );
				disableSelection();
				network.write( headerMessage + id + disconnectMessage );
			}
			else
			{
				// 해당 번호의 컵에 구슬 숨기고 구슬찾기 게임 준비  
				String[] tmp = message.substring( headerMessage.length() ).split( "] " );
				String counterpartID = tmp[0].trim() + "]";
				ball = Integer.parseInt( tmp[1].trim() );
				enableSelection();
				label.setText( id + "님, " + counterpartID + "님이 구슬을 숨긴 컵을 선택하세요" );
			} 
		}
	}
	
	/**
	 * 구슬찾기 프로그램의 네트워크 연결 해제 
	 */
	public void close()  
   	{
		// 상대편에게 네트워크로 프로그램 종료 알림 
		network.write( headerMessage + id + disconnectMessage );
		// 네트워크 연결 해제 	
		network.disconnect();
	}
}

