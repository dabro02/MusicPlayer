import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel on 14.03.2017.
 */
public class MainFrame extends JPanel{
    MainMusicPlayer game;
    MainFrame(MainMusicPlayer game)
    {
        this.game =game;

    }

    @Override
    protected void paintComponent(Graphics g2){
        Graphics2D g = (Graphics2D) g2;
    }

    public void updateMainFrame() {
        while(true){

        }
    }
}
