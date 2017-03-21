package mainPlayer;

import javazoom.jl.decoder.JavaLayerException;
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
    Thread thread2;
    Thread thread3;

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


    public void liederSuchen() {
        thread3 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        thread3.start();
    }

}
