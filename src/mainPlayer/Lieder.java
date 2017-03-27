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
    FileInputStream lied;
    AdvancedPlayer playMP3;
    boolean running = false;
    int  pausedOnFrame=0;
    Thread thread2;
    Thread thread3;

    Lieder()
    {
        liederImportieren();

    }

    public  void liederImportieren(){
        try {
            lied = new FileInputStream("src/mainPlayer/Liedertest/Alan Walker - Alone.mp3");
            playMP3 = new AdvancedPlayer(this.lied);
            /*playMP3.setPlayBackListener(new PlaybackListener() {
                @Override
                public void playbackStarted(PlaybackEvent playbackEvent) {
                    super.playbackStarted(playbackEvent);
                    pausedOnFrame = playbackEvent.getFrame();
                    System.out.println(playbackEvent.getFrame());
                }
            });*/

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

        if(!running) {
            liederImportieren();
            if(pausedOnFrame == 0){
                /*playMP3.setPlayBackListener(new PlaybackListener() {
                    @Override
                    public void playbackStarted(PlaybackEvent playbackEvent) {
                        super.playbackStarted(playbackEvent);
                        pausedOnFrame = playbackEvent.getFrame();
                    }
                });*/
            }
            thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        running = true;
                            updatePlayBackListener();
                            playMP3.play(pausedOnFrame, Integer.MAX_VALUE);

                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }

                }
            });
            thread2.start();
        }
    }

    public void liederStoppen()
    {
        if(running) {
            /*playMP3.setPlayBackListener(new PlaybackListener() {
                @Override
                public void playbackFinished(PlaybackEvent playbackEvent) {
                    super.playbackFinished(playbackEvent);
                    pausedOnFrame = playbackEvent.getFrame();
                    System.out.println(playbackEvent.getFrame());
                }
            });*/
            playMP3.stop();
            running = false;
        }
    }

    public void updatePlayBackListener()
    {
                playMP3.setPlayBackListener(new PlaybackListener() {
                    @Override
                    public void playbackFinished(PlaybackEvent playbackEvent) {
                        super.playbackFinished(playbackEvent);

                        thread3 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                while(running){
                                pausedOnFrame = pausedOnFrame+1;
                                try {
                                    thread3.sleep(25);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println(pausedOnFrame);
                        }
                    }
                });
            }
        });
        thread3.start();
    }
}
