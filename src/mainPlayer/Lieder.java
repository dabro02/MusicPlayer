package mainPlayer;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import static mainPlayer.ButtonPictures.game;

/**
 * Created by Daniel on 18.03.2017.
 */

public class Lieder {
    /*Liederklasse
    hieraus können die Lieder geladen werden
    eventuelle methode .getLieder , die dann die audio dateien ausließt und abspielen kann
     */
    FileInputStream lied;
    AdvancedPlayer playMP3;
    Thread thread2;

    boolean running = true;

    Lieder()
    {
        liederImportieren();
        thread2 = new Thread(new Runnable (){
            @Override public void run() {
                while(true) {
                    try {
                        thread2.sleep(0,1);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (!game.playOrPause) {
                            try {
                                playMP3.play();
                            } catch (JavaLayerException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        });
        thread2.start();
    }

    public  void liederImportieren(){
        try {
            lied = new FileInputStream("src/mainPlayer/Liedertest/Alan Walker - Alone.mp3");
            playMP3 = new AdvancedPlayer(this.lied);
        }
        catch(Exception e) {}
    }

    public void liederAnzeigen(Graphics2D g)
    {
        g.setColor(new Color(0.5f,0.5f,0.5f,0.5f));
        g.fillRect(game.actualwidth/2, 0,game.actualwidth,game.actualheight/20);
        g.drawString(lied.toString(), game.actualheight/2, 0);
    }

}
