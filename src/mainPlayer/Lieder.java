package mainPlayer;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.FileInputStream;
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
    boolean play = false;

    Lieder()
    {
        new Thread(new Runnable (){
            @Override public void run() {
                stopLieder2();
            }
        }).start();
        new Thread(new Runnable (){
            @Override public void run() {
                playLieder();
            }
        }).start();
    }
    public  void liederImportieren(){
        try {
            lied = new FileInputStream("src/mainPlayer/Liedertest/Alan Walker - Alone.mp3");
            playMP3 = new AdvancedPlayer(this.lied);
        }
        catch(Exception e) {}
    }


    public void playLieder() {
        while (true)
        {
            liederImportieren();
            if (!game.playOrPause)
            {
                try {
                    playMP3.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void stopLieder2() {
        while(true)
        {
            liederImportieren();
           if (game.playOrPause) {
               try {
                   playMP3.stop();
               }
               catch(Exception e)
               {

               }
            }
        }
    }

}
