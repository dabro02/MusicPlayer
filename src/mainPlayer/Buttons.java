package mainPlayer;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Daniel on 18.03.2017.
 */
public class Buttons {

    int x,y,w,h;
    BufferedImage Icon;
    boolean pointed = false;

    public Buttons(int x, int y, int w, int h, BufferedImage Icon)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.Icon = Icon;
    }

    void renderButtons(Graphics2D g){
        /*g.setColor(Color.WHITE);
        g.fillRect(x,y,w,h);*/
        g.setColor(Color.BLACK);
        g.drawRect(x-1,y-1,w+2,h+2);
        g.drawImage(Icon , x, y,null);
        if (pointed){
            /*g.setColor(new Color(0.9f,0.9f,0.9f));
            g.fillRect(x,y,w,h);*/
            g.setColor(Color.BLACK);
            g.drawRect(x-1,y-1,w+2,h+2);
            g.drawRect(x-2,y-2,w+4,h+4);
            g.drawRect(x-3,y-3,w+6,h+6);
            g.drawImage(Icon , x,y,null);
            //System.out.println("ja");
        }

    }

    public boolean buttonPointed(int mouseX, int mouseY){
        if(mouseX >= x+10 && mouseX <= x+10+w && mouseY >= y+30 && mouseY <= y+30+h) {
            pointed = true;
            return pointed;
        }
        else{
        pointed = false;}
        return pointed;
    }

    public void koordsUpdate(int x,int y, int w, int h)
    {
        this.x = x;
        this.y = y;
        this.w= w;
        this.h = h;
    }
}
