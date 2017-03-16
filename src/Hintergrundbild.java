import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Daniel on 16.03.2017.
 */
public class Hintergrundbild {
    Hintergrundbild(){
        int w = 1366;
        int h = 768;
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        for(float i = 0; i<w; i++) {
            for(float j = 0; j<h; j++) {
                g.setColor(new Color(0, 1f, 0.0f, ((i/w)*(j/h))));
                g.drawLine((int) i, (int)j, (int)i, (int)j);
            }
        }
    }
}
