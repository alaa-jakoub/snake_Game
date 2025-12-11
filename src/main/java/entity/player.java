package entity;

import Ess.Coordinates;
import Ess.Panel;

import java.awt.*;

public class player extends entity{
    Coordinates [] coordinates_player ;
    Rectangle [] player_rec ;
    int i=0 , temp_X=0 ,temp_Y=0 ;
    Coordinates [] temp_coordinates ;
    public player(){


        coordinates_player = new Coordinates[144];
        for(int i=0 ;i<10;i++){
            coordinates_player[i]=new Coordinates();
        }
        player_rec = new Rectangle[144];
        for(int i=0 ; i<10 ;i++){
            player_rec[i] = new Rectangle();
            player_rec[i].setSize(Panel.tile_size , Panel.tile_size);
        }

    }

    @Override
    public void update(){
        for(int i=9 ;i>0;i--){
            coordinates_player[i].x=coordinates_player[i-1].x;
            coordinates_player[i].y=coordinates_player[i-1].y;
        }
        if(player_rec[0].intersects(Panel.borders[0])) {
            coordinates_player[0].y = Panel.screenHeight;
        }else   if(player_rec[0].intersects(Panel.borders[2])) {
            coordinates_player[0].y = 0;
        }else   if(player_rec[0].intersects(Panel.borders[3])) {
            coordinates_player[0].x = Panel.screenWidth;
        }else   if(player_rec[0].intersects(Panel.borders[1])) {
            coordinates_player[0].x = 0;
        }else {
            if (direction.equalsIgnoreCase("up")) {
                coordinates_player[0].y -= Panel.tile_size;
            } else if (direction.equalsIgnoreCase("down")) {
                coordinates_player[0].y += Panel.tile_size;
            } else if (direction.equalsIgnoreCase("left")) {
                coordinates_player[0].x -= Panel.tile_size;
            } else if (direction.equalsIgnoreCase("right")) {
                coordinates_player[0].x += Panel.tile_size;
            }
        }


    }

    @Override
    public void draw(Graphics2D g2d){

        for(int i=0;i<10;i++){
            if(i==0){
                g2d.setColor(Color.BLUE);
            }else {
                g2d.setColor(Color.WHITE);
            }
            player_rec[i].setLocation(coordinates_player[i].x,coordinates_player[i].y);
            g2d.fill(player_rec[i]);
//            g2d.fillRect(coordinates_player[i].x ,coordinates_player[i].y , Panel.tile_size ,  Panel.tile_size);
        }
    }


}
