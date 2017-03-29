package mainPlayer;

import java.awt.*;
import java.io.FileInputStream;

import static mainPlayer.ButtonPictures.game;

/**
 * Created by Daniel on 18.03.2017.
 */

public class Lieder {
    FileInputStream lied;
    boolean running = false;
    Thread thread2;
    Thread thread3;

    Lieder()
    {
        liederImportieren();

    }

    public  void liederImportieren(){
        try {
            lied = new FileInputStream("src/mainPlayer/Liedertest/Alan Walker - Alone.mp3");
        }
        catch(Exception e) {}
    }

    public void liederAnzeigen(Graphics2D g)
    {
        g.setColor(new Color(0.5f,0.5f,0.5f,0.5f));
        g.fillRect(game.actualwidth/2, 0,game.actualwidth,game.actualheight/20);
        g.drawString(lied.toString(), game.actualheight/2, 0);
    }

    public void liederStarten()
    {

        }

    public void liederStoppen()
    {

    }
}
