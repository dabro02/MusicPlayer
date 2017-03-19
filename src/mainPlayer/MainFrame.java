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
    BufferedImage hintergrundbild1,play;
    Buttons playButton;

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

        try{
            play = ImageIO.read(new File("src/mainPlayer/Pictures/play.png"));
        }
        catch(Exception e){}

        playButton = new Buttons(game.actualwidth/4-25,game.actualheight/12-25,50,50, play);
        Hintergrundbild.getHintergrund(game);
    }


    @Override
    protected void paintComponent(Graphics g2){
        Graphics2D g = (Graphics2D) g2;
        super.paintComponent(g);
            try {
                hintergrundbild1 = ImageIO.read(new File("src/mainPlayer/Pictures/Hintergrund.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(hintergrundbild1, 0,0 , null);
        playButton.renderButtons(g);
        playButton.koordsUpdate(game.actualwidth/4-25,game.actualheight/12-25,50,50);
        g.drawRect(0,0,game.actualwidth/2,game.actualheight/6);
    }



    public void updateMainFrame() {
        while(true){
            int y = 0;
            int x = 0;
            try {
                y = game.frame.getMousePosition().y;
                x = game.frame.getMousePosition().x;
            }
            catch(Exception e){}
            playButton.buttonPointed(x,y);
            game.actualwidth = game.frame.getWidth();
            game.actualheight = game.frame.getHeight();
            game.actualX = game.frame.getX();
            game.actualY = game.frame.getY();
            if(game.actualheight< 400)
            {
                game.actualheight = 400;
                game.frame.setBounds(game.actualX,game.actualY,game.actualwidth,game.actualheight);
            }
            else if (game.actualwidth < 600){
                game.actualwidth = 600;
                game.frame.setBounds(game.actualX,game.actualY,game.actualwidth,game.actualheight);
            }
            else if(game.actualheight> 768)
            {
                game.actualheight = 768;
                game.frame.setBounds(game.actualX,game.actualY,game.actualwidth,game.actualheight);
            }
            else if (game.actualwidth > 1366){
                game.actualwidth = 1366;
                game.frame.setBounds(game.actualX,game.actualY,game.actualwidth,game.actualheight);
            }


            repaint();
        }
    }
}
