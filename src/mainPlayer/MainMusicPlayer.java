package mainPlayer;

import javax.swing.*;

/**
 * Created by Daniel on 14.03.2017.
 */
public class MainMusicPlayer {
    MainFrame frame1;
    JFrame frame;
    static boolean playOrPause = true;
    static Lieder lieder;
    int actualwidth = 1366;
    int actualheight = 768;
    int actualX = 277;
    int actualY = 156;

    public static void main(String[] args)
    {

        new MainMusicPlayer().start();
        new Thread(new Runnable (){
            @Override public void run() {
                lieder = new Lieder();
                //Kostruktor erstellen etc.
                lieder.updateLieder();
                }
        }).start();
    }
        public void start()
        {

            frame = new JFrame("dabromusic");
            frame1 = new MainFrame(this);
            frame.add(frame1);
            frame.setBounds(actualX,actualY,actualwidth,actualheight);

            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.updateMainFrame();
        }
}
