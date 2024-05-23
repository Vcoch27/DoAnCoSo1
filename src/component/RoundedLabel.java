package component;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JLabel;

public class RoundedLabel extends JLabel {

    public RoundedLabel() {

        setOpaque(false); // Đặt thành false để cho phép vẽ nền tùy chỉnh
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Vẽ hình tròn
        int width = getWidth();
        int height = getHeight();
        g.fillOval(0, 0, width, height);
        
        // Vẽ văn bản trong hình tròn
        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        int diameter = Math.max(size.width, size.height);
        return new Dimension(diameter, diameter);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        int diameter = Math.max(width, height);
        super.setBounds(x, y, diameter, diameter);
    }
}
