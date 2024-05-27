package GUI.ForTraCuuDanhPhap.MucDanhPhapHienThi;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import Controller.ControlDanhPhap.ControllerMucDanhPhap;
import GUI.ElementPublic.PanelHienThiListDanhPhap;
import Model.ElementDanhPhapHoaHoc;
import Model.ElementMucDanhPhap;
import component.ButtonGradient;
import component.ImageAvatar;
import component.Notifications;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class PanelChiTietMucDanhPhap extends JPanel {
	public ButtonGradient btnStart;
	private JLabel ia;
    /**
     * Create the panel.
     * @throws LineUnavailableException 
     * @throws IOException 
     * @throws UnsupportedAudioFileException 
     * @throws MalformedURLException 
     */
    public PanelChiTietMucDanhPhap(ElementMucDanhPhap eMDP, ArrayList<ElementDanhPhapHoaHoc> list) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
//    	ElementMucDanhPhap eMDP = ControllerMucDanhPhap.getMucDanhPhap(id);
//    	eDM = eMDP;
    	
    	setBounds(0, 0, 1285, 588);
        setLayout(null);

        // Hình minh họa
//        ImageIcon scalesIMGMucDP = new ImageIcon("asset/img/ion2.jpg");
//        Image imgIMGMucDP = scalesIMGMucDP.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
//        scalesIMGMucDP = new ImageIcon(imgIMGMucDP);
//        JLabel imgMinhHoa = new JLabel(scalesIMGMucDP);
//        imgMinhHoa.setBounds(22, 40, 228, 224);
//        add(imgMinhHoa);

        // Panel chứa JEditorPane
        JPanel panel = new JPanel();
        panel.setBounds(274, 0, 1001, 272);
        add(panel);
        panel.setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane, BorderLayout.CENTER);

        JEditorPane editorPane = new JEditorPane();
        editorPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
        scrollPane.setViewportView(editorPane);
        editorPane.setContentType("text/html");
        editorPane.setText(eMDP.getMota());
        editorPane.setEditable(false);

        // Button để mở trình duyệt với đường dẫn được chỉ định
        
        btnStart = new ButtonGradient();
        btnStart.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnStart.setText("Luyện tập bằng flashcard");
        btnStart.setBounds(10, 278, 252, 46);
        add(btnStart);
        
        JLabel lblNewLabel = new JLabel(eMDP.getIdMucDanhPhap().toUpperCase());
        lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        lblNewLabel.setBounds(22, 11, 228, 26);
        add(lblNewLabel);

        JPanel panel_1 = new JPanel();
		panel_1.setBounds(300, 277, 673, 300);
		panel_1.setLayout(null);
		PanelHienThiListDanhPhap listdp = new PanelHienThiListDanhPhap(list);
		listdp.setBounds(0, 0, 670, 300);
		panel_1.add(listdp);
		add(panel_1);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(eMDP.getImg());

		try {
			BufferedImage bufferedImage = ImageIO.read(bais);
			Image imgMinhHoa = bufferedImage.getScaledInstance(228, 224, Image.SCALE_SMOOTH); 
			ImageIcon icon = new ImageIcon(imgMinhHoa);
			ia = new JLabel(icon);
			ia.setBounds(22, 40, 228, 224);
			add(ia);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    openURL(eMDP.getLink());
                } catch (URISyntaxException | IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    // Phương thức để mở URL trong trình duyệt mặc định
    private void openURL(String url) throws IOException, URISyntaxException {
        Desktop.getDesktop().browse(new URI(url));
    }

    // Phương thức main để chạy thử
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("Test PanelChiTietMucDanhPhap");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setSize(1285, 788);
//
//            PanelChiTietMucDanhPhap panel;
//			try {
//				panel = new PanelChiTietMucDanhPhap(""); frame.getContentPane().add(panel);
//
//            frame.setVisible(true);
//			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//           
//        });
//    }
}
