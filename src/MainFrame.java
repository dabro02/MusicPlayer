import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Daniel on 14.03.2017.
 */
public class MainFrame extends JPanel{
    MainMusicPlayer game;
    MainFrame(MainMusicPlayer game)
    {
        this.game =game;




        game.frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }



    @Override
    protected void paintComponent(Graphics g2){
        Graphics2D g = (Graphics2D) g2;
        g.drawRect(0,0,750,200);
    }



    public void updateMainFrame() {
        while(true){
            repaint();
        }
    }
}
