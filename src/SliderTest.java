import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class SliderTest extends JFrame{
	
	
	JSlider slider;
	JTextArea textArea;
	int fontsize=25;
	
	public SliderTest(String s) {
		super(s);
		Container contentpanel=getContentPane();
		contentpanel.setLayout(new BorderLayout());
		
		slider=new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
		slider.setPaintTicks(true);
		
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(5);
		slider.setPaintLabels(true);
		
		SliderHandler handler=new SliderHandler();
		slider.addChangeListener(handler);
		contentpanel.add(slider, BorderLayout.NORTH);
		
		textArea=new JTextArea("hello\n你好",5,10);
		textArea.setFont(new Font("隶书", Font.PLAIN, fontsize));
		textArea.setForeground(Color.BLUE);
		contentpanel.add(textArea, BorderLayout.CENTER);
		
		setSize(400, 400);
		setVisible(true);
	}

	
	private class SliderHandler implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			fontsize=slider.getValue();
			textArea.setFont(new Font("隶书",Font.PLAIN,fontsize	));
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SliderTest("滑杆改变字体大小");
	}

}
