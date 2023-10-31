package remoteControl;
import java.awt.*;
import javax.swing.*;

/**
 * 리모컨으로 제어하는 TV 클래스
 * @author So Young Park
 * @version 0.8
 */
public class TVPanel extends JPanel implements RemoteControl 
{
	/** 
	 * TV 전원 
	 */	
	private boolean power;
	/** 
	 * 채널 번호 
	 */	
	private int channel;

	/** 
	 * 채널별 이미지 모음 : EBS, SBS, KBS, MBC
	 */	
	private ImageIcon[] imgChannel;
	/** 
	 * 채널 선택 결과를 이미지로 표현  
	 */	
	private JLabel lblChannel;
	/** 
	 * 음량
	 */	
	private int volume;
	/** 
	 * 음량별 이미지 모음 : 음량0, 음량1, 음량2, 음량3
	 */	
	private ImageIcon[] imgVolume;		
	/** 
	 * 음량 선택 결과를 이미지로 표현  
	 */	
	private JLabel lblVolume;
	
	/**
	 * TV 화면 초기화 
	 */
	public TVPanel() 
	{
		// 채널 이미지 준비 
		final String imgPath = "./Common/remoteControl/image/";
		final String[] channelFile = { "EBS.gif", "SBS.gif", "KBS.gif", "MBC.gif", "blank.gif" };	
		imgChannel = new ImageIcon[channelFile.length];
		for ( int i = 0; i < channelFile.length; i++ )
		{
			imgChannel[i] = new ImageIcon( new ImageIcon( imgPath + channelFile[i] ).getImage().getScaledInstance( 250, 120, Image.SCALE_SMOOTH ) );
		}
		
		// 음량 이미지 준비 
		final String[] volumeFile = { "volume0.gif", "volume1.gif", "volume2.gif", "volume3.gif" };	
		imgVolume = new ImageIcon[volumeFile.length];
		for ( int i = 0; i < volumeFile.length; i++ )
		{
			imgVolume[i] = new ImageIcon( new ImageIcon( imgPath + volumeFile[i] ).getImage().getScaledInstance( 80, 120, Image.SCALE_SMOOTH ) );
		}
		// 준비한 이미지를 바탕으로 채널 및 음량 초기화			
		power = OFF;
		channel = imgChannel.length - 1;
		volume = 0;			
		lblChannel = new JLabel( imgChannel[channel] );
		lblVolume =  new JLabel( imgVolume[volume] );
		add( lblChannel );
		add( lblVolume );
	}
	
	/**
	 * TV 리모컨에서 전원 버튼을 누르면 전원 상태 변경 
	 */
	public String clickPower()
	{
		if( power == OFF )
		{
			power = ON;
			channel = 0;
			volume = 1;
			lblChannel.setIcon( imgChannel[channel] );
			lblVolume.setIcon( imgVolume[volume] );
			return "전원을 켭니다";
		}
		else 
		{
			power = OFF;
			channel = imgChannel.length - 1;
			volume = 0;
			lblChannel.setIcon( imgChannel[channel] );
			lblVolume.setIcon( imgVolume[volume] );
			return "전원을 끕니다";
		}
	}
	
	/**
	 * TV 리모컨에서 상(△) 버튼을 누르면 채널 번호 증가 
	 */
	public String clickUp()
	{
		if( power == ON )
		{
			channel = ( channel + 1 ) % ( imgChannel.length - 1 );
			lblChannel.setIcon( imgChannel[channel] );
		}
		
		return "현재 채널은 " + ( channel ) + "번입니다";
	}
	
	/**
	 * TV 리모컨에서 하(▽) 버튼을 누르면 채널 번호 감소 
	 */
	public String clickDown()
	{
		if( power == ON )
		{
			channel = ( channel + ( imgChannel.length - 2 ) ) % ( imgChannel.length - 1 );
			lblChannel.setIcon( imgChannel[channel] );
		}
		
		return "현재 채널은 " + ( channel ) + "번입니다";
	}
	
	/**
	 * TV 리모컨에서 좌(◁) 버튼을 누르면 음량 감소 
	 */
	public String clickLeft()
	{
		if( power == ON )
		{
			volume = ( volume + ( imgVolume.length - 1 ) ) % imgVolume.length;
			lblVolume.setIcon( imgVolume[volume] );
		}
		
		return "현재 음량은 " + ( volume ) + "입니다";
	}
	
	/**
	 * TV 리모컨에서 우(▷) 버튼을 누르면 음량 증가 
	 */
	public String clickRight()
	{
		if( power == ON )
		{
			volume = ( volume + 1 ) % imgVolume.length;
			lblVolume.setIcon( imgVolume[volume] );
		}
		
		return "현재 음량은 " + ( volume ) + "입니다";
	}
}

