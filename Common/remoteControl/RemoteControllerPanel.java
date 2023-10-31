package remoteControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * 리모컨 GUI 클래스
 * @author So Young Park
 * @version 0.8
 */

public class RemoteControllerPanel extends JPanel implements ActionListener 
{
	/**
	 * 가전제품 : TV, 에어콘, 로봇청소기 
	 */
	protected RemoteControl appliance;
	/**
	 * 리모컨 버튼 : 전원 및 상하좌우 버튼 
	 */
	protected JButton[] button;	
	/**
	 * 전원 버튼
	 */
	public final static int POWER = 0;
	/**
	 * 상(△) 버튼
	 */
	public final static int UP = 1;
	/**
	 * 하(▽) 버튼
	 */
	public final static int DOWN = 2;
	/**
	 * 좌(◁) 버튼
	 */
	public final static int LEFT = 3;
	/**
	 * 우(▷) 버튼
	 */
	public final static int RIGHT = 4;

	/**
	 * 가전제품을 제어하는 리모컨 GUI 초기화
	 * @param appliance 가전제품 : TV, 에어콘, 로봇청소기 
	 */
	public RemoteControllerPanel( RemoteControl appliance )
	{
		this();
		this.appliance = appliance;
	}

	/**
	 * 리모컨 GUI 초기화 
	 */
	public RemoteControllerPanel()					// [주요실행순서 제외]  
	{
		this.appliance = null;

		// 전원, 상, 하, 좌, 우 버튼의 이미지 및 리스너 초기화 
		final String imgPath = "./Common/remoteControl/image/";
		final String[] strButton = { "power", "up", "down", "left", "right" };
		button = new JButton[strButton.length];
		for ( int i = 0; i < strButton.length; i++ )
		{
			button[i] = new JButton( new ImageIcon( new ImageIcon( imgPath + strButton[i] + ".gif" ).getImage().getScaledInstance( 30, 30, Image.SCALE_SMOOTH ) ) );
			button[i].addActionListener( this ); 
		}

		this.setPreferredSize( new Dimension( 240, 120 ) );		
		this.setLayout( new BorderLayout() );
		this.add( button[POWER], BorderLayout.CENTER );
		this.add( button[UP   ], BorderLayout.NORTH );
		this.add( button[DOWN ], BorderLayout.SOUTH );
		this.add( button[LEFT ], BorderLayout.WEST );
		this.add( button[RIGHT], BorderLayout.EAST );   
	} 					// [주요실행순서 제외]

	/**
	 * 리모컨 버튼을 클릭시 가전제품 상태 업데이트	
	 * @param ActionEvent e : 이벤트
	 * @return 없음
	 */
	@Override
	public void actionPerformed( ActionEvent event )
	{
		if ( ( event.getSource() == button[POWER] ) && ( appliance != null ) )
			appliance.clickPower();
		else if ( ( event.getSource() == button[UP] ) && ( appliance != null ) )
			appliance.clickUp();
		else if ( ( event.getSource() == button[DOWN] ) && ( appliance != null ) )
			appliance.clickDown();
		else if ( ( event.getSource() == button[LEFT] ) && ( appliance != null ) )
			appliance.clickLeft();
		else if ( ( event.getSource() == button[RIGHT] ) && ( appliance != null ) )
			appliance.clickRight();
	}
}

