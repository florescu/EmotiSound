import java.awt.AWTException;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class MusicGUI extends JFrame{
	
	private JCheckBox bgMusicToggle;
	
	public void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("MindMusic");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane and add swing components to it
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout(5,5));

        bgMusicToggle = new JCheckBox("Bg Music");
        bgMusicToggle.setSelected(false);
        contentPane.add(bgMusicToggle, BorderLayout.LINE_START);
        
        JCheckBox.addActionListener(bgMusicToggle);
        
        frame.pack();
        frame.setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		Object source = e.getItemSelectable();
		if (source == bgMusicToggle)
			if (e.getStateChange() == ItemEvent.SELECTED)
				bgMusicToggle.setSelected(false);
			else if (e.getStateChange() == ItemEvent.DESELECTED)
				bgMusicToggle.setSelected(true);		
	}
	
	
}
