import javax.swing.*;
import java.awt.*;

public class JGradientButton extends JButton {
    public JGradientButton(String text){
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        final Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(new GradientPaint(
                new Point(0, 0),
                Color.WHITE,
                new Point(0, getHeight()),
                new Color(168,182,185)));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();

        super.paintComponent(g);
    }

    public static JGradientButton newInstance(String text) {
        return new JGradientButton(text);
    }

}
