package mainPlayer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Daniel on 14.03.2017.
 */
public class MainFrame extends JPanel{
    MainMusicPlayer game;
    BufferedImage hintergrundbild1;
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

        Hintergrundbild.getHintergrund();
    }


    boolean hintergrundbild1printen = true;
    @Override
    protected void paintComponent(Graphics g2){
        Graphics2D g = (Graphics2D) g2;
        if(hintergrundbild1printen) {
            try {
                hintergrundbild1 = ImageIO.read(new File("src/mainPlayer/Pictures/Hintergrund.png"));
                hintergrundbild1printen = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(hintergrundbild1, 0, 0, null);
        }
        g.drawRect(0,0,750,200);
    }



    public void updateMainFrame() {
        while(true){
            repaint();
        }
    }
}
