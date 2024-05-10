package GUI.ElementPublic;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

public class ElementOPhanTu extends JPanel {

	/**
	 * Create the panel.
	 */
	public ElementOPhanTu() {
		setBackground(new Color(0, 255, 0));
		setBounds(0, 0,121, 70);
	
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00D4 danh ph\u00E1p");
		lblNewLabel.setBounds(27, 30, 68, 34);
		add(lblNewLabel);
	}
}
