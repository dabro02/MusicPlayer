package mainPlayer;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
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
    Player playMP3;
    public  void liederImportieren(){
        try {
            lied = new FileInputStream("src/mainPlayer/Liedertest/Alan Walker - Alone.mp3");
        }
        catch(Exception e)
        {        }
    }
    public void liederAbspielen( boolean playOrPause)
    {
            try {
                liederImportieren();
                playMP3 = new Player(this.lied);
                playMP3.play();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }
        }

    public void updateLieder() {
        while (true)
        {
            if(!game.playOrPause)
            game.lieder.liederAbspielen(game.playOrPause);
            else{
                System.out.println("wird nicht abgespielt");
            }
        }
    }

}
