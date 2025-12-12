package Ess;

import java.awt.*;
import java.awt.image.BufferedImage;

public class orginizationTool {
    private BufferedImage scaledImage;
    private Graphics2D g2d;

    public BufferedImage scaleImage(BufferedImage original,int width , int height){
        scaledImage=new BufferedImage(width,height,original.getType());
        g2d=scaledImage.createGraphics();
        g2d.drawImage(original,0,0,width,height,null);
        g2d.dispose();
        return scaledImage;
    }
}