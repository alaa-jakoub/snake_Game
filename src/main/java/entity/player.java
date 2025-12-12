package entity;

import Ess.Coordinates;
import Ess.Panel;

import java.awt.*;

public class player extends entity{
    final int player_length = (Ess.Panel.screenWidth / Panel.tile_size)*(Panel.screenHeight / Panel.tile_size);
    Coordinates [] coordinates_player ;
    public Rectangle [] player_rec ;
    public static int player_squares =1;
    public player(Panel panel){
        super(panel);
        coordinates_player = new Coordinates[player_length];
        for(int i=0 ;i<player_length;i++){
            coordinates_player[i]=new Coordinates();
        }
        player_rec = new Rectangle[player_length];
        for(int i=0 ; i<player_length ;i++){
            player_rec[i] = new Rectangle();
            player_rec[i].setSize(Panel.tile_size , Panel.tile_size);
        }
        next_direction = "right";

    }

    @Override
    public void update(){
        if(!next_direction.equalsIgnoreCase(opposite_direction(direction))){
            direction=next_direction;
        }
        for(int i=player_squares -1  ;i>0;i--){
            coordinates_player[i].x=coordinates_player[i-1].x;
            coordinates_player[i].y=coordinates_player[i-1].y;
        }
        switch (direction) {
            case "up":    coordinates_player[0].y -= Panel.tile_size; break;
            case "down":  coordinates_player[0].y += Panel.tile_size; break;
            case "left":  coordinates_player[0].x -= Panel.tile_size; break;
            case "right": coordinates_player[0].x += Panel.tile_size; break;
        }

        if (coordinates_player[0].x < 0) coordinates_player[0].x = Panel.screenWidth - Panel.tile_size;
        if (coordinates_player[0].x >= Panel.screenWidth) coordinates_player[0].x = 0;

        if (coordinates_player[0].y < 0) coordinates_player[0].y = Panel.screenHeight - Panel.tile_size;
        if (coordinates_player[0].y >= Panel.screenHeight) coordinates_player[0].y = 0;
    }

    @Override
    public void draw(Graphics2D g2d){

        for(int i=0;i<player_squares;i++){
            if(i==0){
                g2d.setColor(Color.BLUE);
            }else {
                g2d.setColor(Color.WHITE);
            }
            player_rec[i].setLocation(coordinates_player[i].x,coordinates_player[i].y);
            g2d.fill(player_rec[i]);
        }
    }
    public String opposite_direction(String dire){
        return switch (dire) {
            case "up" -> "down";
            case "down" -> "up";
            case "right" -> "left";
            case "left" -> "right";
            default -> "";
        };
    }

}
