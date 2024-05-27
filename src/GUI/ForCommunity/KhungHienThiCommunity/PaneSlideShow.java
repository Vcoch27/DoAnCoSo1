package GUI.ForCommunity.KhungHienThiCommunity;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Client.MainClient.MainClient;
import GUI.ForCommunity.ElementForCommunity.ElementForPost.*;


public class PaneSlideShow extends JPanel {

	private JPanel panelPost1;
	private JPanel panePost2;
	private JPanel panelPost3;
	private PaneElementMiniPost[] miniPost1;
	private PaneElementMiniPost[] miniPost2;
	private PaneElementMiniPost[] miniPost3;
	private int currentIndex = 0;
	private String[] texts = { "Top 1", "Top 2", "Top 3", "Top 4", "Top 5" };
	private String[] contents = {
			"    HoÃ  tan hoÃ n toÃ n hh X gá»“m Fe vÃ  Mg báº±ng má»™t lÆ°á»£ng vá»«a \r\n  Ä‘á»§ dd HCl 20 % thu Ä‘Æ°á»£c dd Y. Ná»“ng Ä‘á»™ FeCl2 trong dd Y lÃ  \r\n  15.76%. Ná»“ng Ä‘á»™ % MgCl2 trong dd Y lÃ :\r\n  A.24.24%\r\n  B.11.79%\r\n  C.28.21%\r\n  D.15.76%",
			"    Ä�á»‘t chÃ¡y hoÃ n toÃ n 0,33 mol há»—n há»£p X gá»“m metyl propionat,\r\n  metyl axetat vÃ  2 hidocacbon máº¡ch há»Ÿ cáº§n vá»«a Ä‘á»§ 1,27 mol \r\n  O2 táº¡o ra 14,4 gam H2O. Náº¿u cho 0,33 mol X vÃ o dung dá»‹ch \r\n  Br2 dÆ° thÃ¬ sá»‘ mol Br2 pháº£n á»©ng tá»‘i Ä‘a lÃ :\r\n  A. 0,26\r\n  B. 0,30\r\n  C. 0,33\r\n  D. 0,40",
			"    Ä�á»‘t chÃ¡y hoÃ n toÃ n 0,75 mol há»—n há»£p X gá»“m etyl axetat,\r\n  metyl propionat, metyl axetat, axit  axetic vÃ  2 hidrocacbon \r\n  máº¡ch há»Ÿ vá»«a Ä‘á»§ 2,9 mol O2 táº¡o ra 2,22 mol H2O. náº¿u cho \r\n  0,75 mol X   vÃ o dung dá»‹ch Br2 dÆ° thÃ¬ sá»‘ mol Br2 pháº£n á»©ng lÃ ?\r\n  A. 0,36\r\n  B. 0,32\r\n  C. 0,30\r\n  D. 0,40",
			"    XÃ  phÃ²ng hoÃ¡ háº¿t 0.1 mol este Z Ä‘Æ¡n chá»©c báº±ng 80ml dd  \r\n  11.2 % cá»§a má»™t hidroxit kl kiá»�m ( d=1.25g/ml). ChÆ°ng cáº¥t thu \r\n  Ä‘Æ°á»£c 94.6g cháº¥t lá»�ng vÃ  cÃ²n láº¡i 15.4g cháº¥t ráº¯n khan . Z lÃ :\r\n  A.C5H9COOC3H5\r\n  B.C2H5COOC3H5\r\n  C.C3H5COOCH3\r\n  D.CH3COOC3H5",
			"    Há»—n há»£p X gá»“m Mg vÃ  Fe3O4 (oxi chiáº¿m 25% khá»‘i lÆ°á»£ng). \r\n  Cho m gam X vÃ o dung dá»‹ch gá»“m H2SO4 2M vÃ  KNO3 1M,\r\n  thu Ä‘Æ°á»£c dung dá»‹ch Y chá»©a 35,74 gam chá»‰ chá»©a muá»‘i trung \r\n  hÃ²a vÃ  0,02 mol NO (Ä‘ktc, sáº£n pháº©m khá»­ duy nháº¥t). Cho \r\n  Ba(OH)2 dÆ° vÃ o Y tháº¥y xuáº¥t hiá»‡n a gam káº¿t tá»§a. Biáº¿t cÃ¡c pháº£n \r\n  á»©ng xáº£y ra hoÃ n toÃ n. GiÃ¡ trá»‹ cá»§a a gáº§n nháº¥t vá»›i:\r\n  A. 55       B. 60       C. 65       D. 70" };

	private JLabel titleForPost1;
	private JLabel titleForPost2;
	private JLabel titleForPost3;
	private JPanel panel;
	private MainClient client;

	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 */
	public PaneSlideShow(MainClient client) throws IOException {
		this.client = client;
		setBackground(new Color(0, 128, 192));

		setLayout(null);
		setBounds(0, 0, 1269, 220);
		panelPost1 = new JPanel();
		panelPost1.setLayout(null);
		panelPost1.setBounds(66, 0, 330, 220);
		add(panelPost1);

		panePost2 = new JPanel();
		panePost2.setLayout(null);
		panePost2.setBounds(469, 0, 330, 220);
		add(panePost2);

		panelPost3 = new JPanel();
		panelPost3.setLayout(null);
		panelPost3.setBounds(888, 0, 330, 220);
		add(panelPost3);

		miniPost1 = new PaneElementMiniPost[1];
		miniPost2 = new PaneElementMiniPost[1];
		miniPost3 =new PaneElementMiniPost[1];

		miniPost1[0] = new PaneElementMiniPost("a");
		miniPost1[0].setBounds(0, 0, 330, 199);
		panelPost1.add(miniPost1[0]);

		titleForPost1 = new JLabel("New label");
		titleForPost1.setHorizontalAlignment(SwingConstants.CENTER);
		titleForPost1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titleForPost1.setBounds(0, 0, 71, 19);
		panelPost1.add(titleForPost1);

		panel = new JPanel();
		panel.setBounds(0, 21, 330, 199);
		panelPost1.add(panel);

//		JPanel panel = new JPanel();
//		panel.setBounds(0, 30, 330, 150);
//		panelPost1.add(panel);

		miniPost2[0] = new PaneElementMiniPost("a");
		miniPost2[0].setBounds(0, 40, 330, 140);
		panePost2.add(miniPost2[0]);

		titleForPost2 = new JLabel("New label");
		titleForPost2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titleForPost2.setHorizontalAlignment(SwingConstants.CENTER);
		titleForPost2.setBounds(0, 0, 69, 19);
		panePost2.add(titleForPost2);

		miniPost3[0] = new PaneElementMiniPost("a");
		miniPost3[0].setBounds(0, 40, 330, 140);
		panelPost3.add(miniPost3[0]);

		titleForPost3 = new JLabel("New label");
		titleForPost3.setHorizontalAlignment(SwingConstants.CENTER);
		titleForPost3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titleForPost3.setBounds(0, 0, 70, 19);
		panelPost3.add(titleForPost3);

		BufferedImage myIconPre = ImageIO.read(new File("asset//img//pre.png"));
		Image imgIconPre = myIconPre.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon scalesPre = new ImageIcon(imgIconPre);
		JLabel lblPrevious = new JLabel(scalesPre);
		lblPrevious.setBackground(new Color(0, 128, 192));
		lblPrevious.setBounds(10, 95, 40, 40);
		add(lblPrevious);

		BufferedImage myIconNext = ImageIO.read(new File("asset//img//next.png"));
		Image imgIconNext = myIconNext.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon scalesNext = new ImageIcon(imgIconNext);
		JLabel lblNext = new JLabel(scalesNext);
		lblNext.setBounds(1221, 95, 40, 40);
		add(lblNext);

		lblPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showPreviousText();
			}
		});

		lblNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showNextText();
			}
		});

		showTextAtIndex(currentIndex);

	}

	void showTextAtIndex(int index) {
		titleForPost1.setText(texts[index % texts.length]);
		titleForPost2.setText(texts[(index + 1) % texts.length]);
		titleForPost3.setText(texts[(index + 2) % texts.length]);

		miniPost1[0].setContentForMini(contents[index % contents.length]);
		miniPost2[0].setContentForMini(contents[(index + 1) % contents.length]);
		miniPost3[0].setContentForMini(contents[(index + 2) % contents.length]);

		miniPost1[0].setBounds(1, 22, 330, 199);
		miniPost2[0].setBounds(1, 22, 330, 199);
		miniPost3[0].setBounds(1, 22, 330, 199);

		panelPost1.revalidate();
		panelPost1.repaint();
		panePost2.revalidate();
		panePost2.repaint();
		panelPost3.revalidate();
		panelPost3.repaint();
	}

	private void showPreviousText() {
		currentIndex--;
		if (currentIndex < 0) {
			currentIndex = texts.length - 1;
		}
		showTextAtIndex(currentIndex);
	}

	private void showNextText() {
		currentIndex++;
		if (currentIndex >= texts.length) {
			currentIndex = 0;
		}
		showTextAtIndex(currentIndex);
	}

	public void addNewEvent(String title, String content) {
		String[] newTexts = new String[texts.length + 1];
		String[] newContents = new String[contents.length + 1];

		System.arraycopy(texts, 0, newTexts, 0, texts.length);
		System.arraycopy(contents, 0, newContents, 0, contents.length);

		newTexts[texts.length] = title; // GÃ¡n tiÃªu Ä‘á»� má»›i cho sá»± kiá»‡n Ä‘Æ°á»£c thÃªm vÃ o
		newContents[contents.length] = content;

		texts = newTexts;
		contents = newContents;
		// Cáº­p nháº­t currentIndex Ä‘á»ƒ hiá»ƒn thá»‹ sá»± kiá»‡n má»›i
		currentIndex = texts.length - 3; // Hiá»ƒn thá»‹ sá»± kiá»‡n má»›i thÃªm vÃ o
		showTextAtIndex(currentIndex); // Hiá»ƒn thá»‹ sá»± kiá»‡n má»›i
	}
	private void getTopPost() throws IOException {
		client.dataOutput.writeUTF("POST");
		client.dataOutput.writeUTF("GETTOP");
		
	}
}
