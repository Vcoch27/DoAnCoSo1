package GUI.ForHomePage;

import javax.swing.JPanel;

import GUI.ForLogin.FrameLogin;
import component.ButtonGradient;

import javax.swing.JFrame;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class PaneLogIn_Out extends JPanel  {
	public FrameLogin fl =new FrameLogin();
	
	/**
	 * Create the panel.
	 */
	public PaneLogIn_Out()  throws IOException {
		setBackground(new Color(100, 149, 237));
		setBounds(0, 0, 239, 65);
		setLayout(null);
		
		ButtonGradient btnNewButton = new ButtonGradient();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					fl.setVisible(true);
					fl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				
			}
		});
		btnNewButton.setFont(new Font("Monospaced", Font.ITALIC, 14));
		btnNewButton.setText("\u0110\u0103ng k\u00FD / \u0110\u0103ng Nh\u1EADp");
		btnNewButton.setBounds(10, 11, 219, 43);
		add(btnNewButton);
//		fl.pLogin.button.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				System.out.println("done");
//				
//				
//			}
//
//			
//		});
	}
}
