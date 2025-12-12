package entity;

import Ess.Coordinates;
import Ess.Panel;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.image.BufferedImage;

public class entity {
    Coordinates coordinates =new Coordinates();
    public String direction="",next_direction="";
    BufferedImage entityImage = null ;
    Panel panel ;

    public entity(Panel panel) {
        this.panel = panel;
    }

    public void update(){}
    public void draw(Graphics2D g2d){}


}
