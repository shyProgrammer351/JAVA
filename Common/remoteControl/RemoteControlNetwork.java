package remoteControl;
import java.awt.event.ActionEvent;
import network.Network;

/**
 * 리모컨 프로그램의 네트워크 담당 클래스
 * @author So Young Park
 * @version 0.8
 * @see     net.Network()
 */	
public class RemoteControlNetwork extends RemoteControllerPanel implements Runnable
{	
	/** 
	 * 네트워크
	 */	
	private Network network;
	/** 
	 * 리모컨이나 가전제품 아이디
	 */	
	private String  id;
	/** 
	 * 리모컨 프로그램의 메시지 헤더 
	 */	
	private final String header = "[RMTC] ";

	/**
	 * 리모컨 프로그램의 네트워크 연결 초기화 
	 * @param serverIP 서버 IP 주소
	 */
	public RemoteControlNetwork( String serverIP )
	{
		super();
		connectAsClient( serverIP, this.getClass().getSimpleName() );
	}

	/**
	 * 가전제품을 제어하는 리모컨 프로그램의 네트워크 연결 초기화 
	 * @param appliance 가전제품 : TV, 에어콘, 로봇청소기 
	 * @param serverIP 서버 IP 주소
	 */
	public RemoteControlNetwork( RemoteControl appliance, String serverIP )
	{
		super( appliance );
		connectAsClient( serverIP, appliance.getClass().getSimpleName() );
	}


	/**
	 * 리모컨 프로그램의 네트워크 클라이언트 연결 초기화 
	 * @param serverIP 서버 IP 주소
	 * @param applianceName 가전제품의 클래스 이름 : TV, 에어콘, 로봇청소기, 리모컨 클라이언트
	 */
	public void connectAsClient( String serverIP, String applianceName )
	{
		id = "[" + applianceName +"]";
		network = new Network();
		network.connectAsClient( serverIP, this );
	}

	/**
	 * 리모컨 버튼을 클릭시 가전제품에게 그 결과를 전송 
	 * @param event 대화 입력 결과 
	 */
	@Override
	public void actionPerformed( ActionEvent event )
	{
		String message = "";			                 
		// 리모컨 버튼 클릭 결과 확인 
		if ( event.getSource() == button[POWER] )  
			message = header + "POWER";
		else if ( event.getSource() == button[UP] ) 
			message = header + "UP";
		else if ( event.getSource() == button[DOWN] ) 
			message = header + "DOWN";
		else if ( event.getSource() == button[LEFT] ) 
			message = header + "LEFT";
		else if ( event.getSource() == button[RIGHT] ) 
			message = header + "RIGHT";

		// 상대편에게 네트워크로 리모컨 버튼 클릭 결과 전송
		network.write( message );
	}

	/**
	 * 리모컨 버튼 클릭 결과 도착시 가전제품 상태 업데이트 
	 */
	@Override
	public void run()  
	{	
		// 상대편이 네트워크로 보낸 리모컨 버튼 클릭 결과 읽기 
		for ( String message = null; ( message = network.read()
		                                                             ) != null; ) 
		{
			// 리모컨 프로그램 메시지가 아니면 무시
			if ( !message.contains( header ) )
				continue;
			// 리모컨 버튼 클릭 결과를 바탕으로 가전제품 상태 업데이트 
			else if ( message.contains( "POWER" ) && ( appliance != null ) )
				appliance.clickPower();
			else if ( message.contains( "UP" ) && ( appliance != null ) )		
				appliance.clickUp();
			else if ( message.contains( "DOWN" ) && ( appliance != null ) )
				appliance.clickDown();
			else if ( message.contains( "LEFT" ) && ( appliance != null ) )
				appliance.clickLeft();
			else if ( message.contains( "RIGHT" ) && ( appliance != null ) )
				appliance.clickRight();
		}  
	}
	
	/**
	 * 리모컨 프로그램의 네트워크 연결 해제 
	 */
	public void close()  
   	{
		// 상대편에게 네트워크로 프로그램 종료 알림 
		network.write( header + id + " 네트워크 연결 종료" );
		// 네트워크 연결 해제 	
		network.disconnect();
	}
}

