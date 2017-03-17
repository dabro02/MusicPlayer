package mainPlayer;

import javax.swing.*;

/**
 * Created by Daniel on 14.03.2017.
 */
public class MainMusicPlayer {
    MainFrame frame1;
    JFrame frame;

    public static void main(String[] args)
    {
        new MainMusicPlayer().start();
    }
        public void start()
        {
            frame = new JFrame("dabromusic");
            frame1 = new MainFrame(this);
            frame.add(frame1);
            frame.setBounds(277,156,1366,768);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.updateMainFrame();
        }
}
