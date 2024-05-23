package GUI.ElementPublic;

import java.awt.Component;
import java.awt.Dimension;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;

import Model.ElementDanhPhapHoaHoc;

import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;

public class PanelHienThiListDanhPhap extends JPanel {

	/**
	 * Create the panel.
	 * 
	 * @throws LineUnavailableException
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 * @throws MalformedURLException
	 */
	public PanelHienThiListDanhPhap(ArrayList<ElementDanhPhapHoaHoc> list)
			throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		setBounds(10, 287, 670, 300);
		setLayout(null);

		JScrollPane scrollPaneList = new JScrollPane();
		scrollPaneList.setBounds(0, 0, 670, 300);
		add(scrollPaneList);

		JPanel areaList = new JPanel();
		BoxLayout boxLayout = new BoxLayout(areaList, BoxLayout.Y_AXIS);
		areaList.setLayout(boxLayout);
		scrollPaneList.setViewportView(areaList);
		int size = list.size();
		for (int i = 0; i < size; i++) {
			ElementDanhPhap elementDP = new ElementDanhPhap(list.get(i));
			list.get(i).toString();
			areaList.add(elementDP);

			Component rigidArea = Box.createRigidArea(new Dimension(0, 10));
			areaList.add(rigidArea);
			if (i == size - 1) {
				if (size <= 4) {
					System.out.println("done");
//				if(i<3) {
					Component rigidAreass = Box.createRigidArea(new Dimension(0, 200));
					areaList.add(rigidAreass);
				}
			}
		}
	}

}
