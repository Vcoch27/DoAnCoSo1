package GUI.ForNotePage.KhungNotePage;

import javax.swing.JPanel;

import GUI.ElementPublic.PanelHienThiListDanhPhap;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.undo.UndoManager;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class PaneContentList extends JPanel {
	public JLabel idList;

	private UndoManager undoManager;

	/**
	 * Create the panel.
	 * 
	 * @throws LineUnavailableException
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 * @throws MalformedURLException
	 */
	public PaneContentList()
			throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBounds(0, 0, 770, 596);
		setLayout(null);

		PanelHienThiListDanhPhap panelListDP = new PanelHienThiListDanhPhap(null);
		panelListDP.setBounds(50, 296, 670, 300);
		add(panelListDP);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 750, 263);
		add(scrollPane);

		JTextPane textPane = new JTextPane();
		undoManager = new UndoManager();
		textPane.getDocument().addUndoableEditListener(undoManager);
		scrollPane.setViewportView(textPane);
		textPane.setText("Brom là 1 chất rất là Brom \nHeli hít rất phê \nNatri KHÔNG THÍCH NƯỚC");
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 19));
	}
	public void undo() {
		 if (undoManager.canUndo()) {
             undoManager.undo(); 
         }
	}
	public void endo() {
		if (undoManager.canRedo()) {
            undoManager.redo(); 
        }
	}
}
