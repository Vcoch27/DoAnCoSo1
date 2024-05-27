package GUI.ForHomePage;

import javax.swing.JPanel;
import Client.MainClient.MainClient;
import GUI.ForLogin.FrameLogin;
import component.ButtonGradient;
import java.awt.Font;
import java.awt.Color;
import java.io.IOException;

public class PaneLogIn_Out extends JPanel  {
	public FrameLogin fl;
	public ButtonGradient btnStart;
	/**
	 * Create the panel.
	 */
	public PaneLogIn_Out(MainClient client)  throws IOException {
		
		fl =new FrameLogin(client);
		
		setBackground(new Color(100, 149, 237));
		setBounds(0, 0, 239, 65);
		setLayout(null);
		btnStart = new ButtonGradient();
		btnStart.setFont(new Font("Monospaced", Font.ITALIC, 14));
		btnStart.setText("\u0110\u0103ng k\u00FD / \u0110\u0103ng Nh\u1EADp");
		btnStart.setBounds(10, 11, 219, 43);
		add(btnStart);

	}
}
