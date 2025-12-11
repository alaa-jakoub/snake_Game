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


        coordinates_player = new Coordinates[10];
        for(int i=0 ;i<10;i++){
            coordinates_player[i]=new Coordinates();
        }
        player_rec = new Rectangle[3];

    }

    @Override
    public void update(){
        for(int i=9 ;i>0;i--){
            coordinates_player[i].x=coordinates_player[i-1].x;
            coordinates_player[i].y=coordinates_player[i-1].y;
        }

        if(direction.equalsIgnoreCase("up")){
            coordinates_player[0].y -= Panel.tile_size ;
        }else if(direction.equalsIgnoreCase("down")){
            coordinates_player[0].y += Panel.tile_size ;
        }else if(direction.equalsIgnoreCase("left")){
            coordinates_player[0].x -= Panel.tile_size ;
        }else if(direction.equalsIgnoreCase("right")){
            coordinates_player[0].x += Panel.tile_size ;

        }


    }

    @Override
    public void draw(Graphics2D g2d){
//        g2d.fillRect(coordinates_player[0].x ,coordinates_player[0].y , Panel.tile_size ,  Panel.tile_size);
//        g2d.fillRect(coordinates_player[1].x ,coordinates_player[1].y , Panel.tile_size ,  Panel.tile_size);
//        g2d.setColor(Color.BLUE);
//        g2d.fillRect(coordinates_player[2].x ,coordinates_player[2].y , Panel.tile_size ,  Panel.tile_size);
        for(int i=0;i<10;i++){
            g2d.fillRect(coordinates_player[i].x ,coordinates_player[i].y , Panel.tile_size ,  Panel.tile_size);
        }
    }


}
