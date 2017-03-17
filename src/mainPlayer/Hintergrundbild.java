package mainPlayer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Daniel on 16.03.2017.
 */
public class Hintergrundbild {


    public static void getHintergrund(){
        int w = 1366;
        int h = 768;

        File imgtest = new File("src/mainPlayer/Pictures/Hintergrund.png");
        if(!imgtest.exists())
        {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));

        for(float i = 0; i<w; i++) {
            for(float j = 0; j<h; j++) {
                g.setColor(new Color(0, 1f, 0.0f, ((i/w)*(j/h))));
                g.drawLine((int) i, (int)j, (int)i, (int)j);
            }
        }
        try {
            ImageIO.write(img, "png", new File("src/mainPlayer/Pictures/Hintergrund.png"));
        } catch (IOException k) {
            k.printStackTrace();
        }
        }
    }
}
