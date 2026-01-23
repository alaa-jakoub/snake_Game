package entity;

import Ess.Coordinates;
import Ess.Panel;

import java.awt.*;

public class player extends entity{
    final int player_length = (Ess.Panel.screenWidth / Panel.tile_size)*(Panel.screenHeight / Panel.tile_size);
    public Coordinates [] coordinates_player ;
    public Rectangle [] player_rec ;
    public static int player_squares =1;
    float t;
    public int red;
    public int blue;
    public int green ;
    public player(Panel panel){
        super(panel);
        coordinates_player = new Coordinates[player_length];
        for(int i=0 ;i<player_length;i++){
            coordinates_player[i]=new Coordinates();
        }
        coordinates_player[0].x=0;
        coordinates_player[0].y=0;

        red=0;
        green=0;
        blue=255;

        player_rec = new Rectangle[player_length];
        for(int i=0 ; i<player_length ;i++){
            player_rec[i] = new Rectangle();
            player_rec[i].setSize(Panel.tile_size , Panel.tile_size);
        }
        next_direction = "right";

    }

    @Override
    public void update(){
        if(player_squares==player_length){
            panel.losed=true;
            panel.gameStatus=panel.win;
        }
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

//        if (coordinates_player[0].x < 0) coordinates_player[0].x = Panel.screenWidth - Panel.tile_size;
//        if (coordinates_player[0].x >= Panel.screenWidth) coordinates_player[0].x = 0;
//
//        if (coordinates_player[0].y < 0) coordinates_player[0].y = Panel.screenHeight - Panel.tile_size;
//        if (coordinates_player[0].y >= Panel.screenHeight) coordinates_player[0].y = 0;

        if (coordinates_player[0].x < 0){
            panel.losed=true;
            panel.gameStatus=panel.lose;
        }
        if (coordinates_player[0].x >= Panel.screenWidth) {
            panel.losed=true;
            panel.gameStatus = panel.lose;
        }

        if (coordinates_player[0].y < 0) {
            panel.losed=true;
            panel.gameStatus = panel.lose;
        }
        if (coordinates_player[0].y >= Panel.screenHeight) {
            panel.losed=true;
            panel.gameStatus = panel.lose;
        }

        for (int i = 1; i < player_squares ; i++) {
            if(player_rec[0].intersects(player_rec[i])){
                panel.losed=true;
                panel.gameStatus=panel.lose;
            }
        }
    }

    @Override
    public void draw(Graphics2D g2d){

        for(int i=0;i<player_squares;i++){
            try {
                t = (float) i / Math.max(1, player_squares - 1);

                red = (int) (125 * t);
                green = (int) (150 * (1 - t));
                blue = 255;

                g2d.setColor(new Color(red, green, blue));
            }catch(IllegalArgumentException e){
                e.printStackTrace();
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
