package GUI.ForCommunity.KhungHienThiCommunity;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
 
public class FrameAddPost extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea content;
    private PaneSlideShow slideshow;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	PaneSlideShow slideshow = new PaneSlideShow(); // Táº¡o má»™t Ä‘á»‘i tÆ°á»£ng SlidesShow
                    FrameAddPost frame = new FrameAddPost(slideshow); // GÃ¡n SlidesShow cho AddPost
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Constructor vá»›i tham sá»‘ kiá»ƒu SlidesShow
    public FrameAddPost(PaneSlideShow slideshow) {
        // Thiáº¿t láº­p Ä‘á»‘i tÆ°á»£ng SlidesShow cho AddPost
        this.slideshow = slideshow;

        // CÃ¡c pháº§n cÃ²n láº¡i cá»§a constructor
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 407);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel avatar = new JLabel("");
        avatar.setIcon(new ImageIcon("C:\\Java\\DACS-1\\user.png"));
        avatar.setBounds(10, 10, 32, 35);
        contentPane.add(avatar);

        JLabel myName = new JLabel("HAHA");
        myName.setForeground(new Color(102, 102, 102));
        myName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        myName.setBounds(52, 22, 105, 23);
        contentPane.add(myName);

        content = new JTextArea();
        content.setBounds(10, 65, 726, 243);
        contentPane.add(content);

        JLabel addPost = new JLabel("");
        addPost.setIcon(new ImageIcon("C:\\Java\\DACS-1\\add (1).png"));
        addPost.setBounds(688, 318, 38, 39);
        contentPane.add(addPost);

        // Gáº¯n sá»± kiá»‡n cho addPost label
        addPost.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addNewEventToSlideshow();
            }
        });
    }

    // PhÆ°Æ¡ng thá»©c Ä‘á»ƒ thÃªm sá»± kiá»‡n má»›i vÃ o SlidesShow
    private void addNewEventToSlideshow() {
        String newTitle = "Sá»° KIá»†N " + (slideshow.getInsets().bottom + 1); // Táº¡o tiÃªu Ä‘á»� má»›i
        String newContent = content.getText(); // Láº¥y ná»™i dung tá»« JTextArea
        slideshow.addNewEvent(newTitle, newContent); // Gá»�i phÆ°Æ¡ng thá»©c addNewEvent cá»§a SlidesShow
        content.setText(""); // XÃ³a ná»™i dung trong JTextArea sau khi thÃªm

        // Cáº­p nháº­t láº¡i giao diá»‡n ngÆ°á»�i dÃ¹ng
        slideshow.showTextAtIndex(slideshow.getInsets().bottom - 3); // Hiá»ƒn thá»‹ sá»± kiá»‡n má»›i thÃªm vÃ o
    }
}
