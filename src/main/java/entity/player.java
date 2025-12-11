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
        temp_coordinates = new Coordinates[3];

        coordinates_player = new Coordinates[3];
        coordinates_player[0] =new Coordinates();
        player_rec = new Rectangle[3];

    }

    @Override
    public void update(){
//        if(i==11  && temp_X!=0 && temp_Y!=0){
//            i=1;
//        }if(i==12  && temp_X==0 && temp_Y==0){
//            i=0;
//        }
//        temp_X = coordinates_player[0].x;
//        temp_Y = coordinates_player[0].y;
//        //
//        if( (coordinates_player[0].x<Panel.screenWidth - (Panel.screenWidth/Panel.tile_size) ) && (coordinates_player[0].y<Panel.screenWidth - (Panel.screenWidth/Panel.tile_size) ) ){
//            coordinates_player[0].x = ( i * Panel.tile_size ) ;
//            coordinates_player[0].y = 0 ;
//        }else if( (coordinates_player[0].x>=Panel.screenWidth - (Panel.screenWidth/Panel.tile_size)) && (coordinates_player[0].y<Panel.screenWidth - (Panel.screenWidth/Panel.tile_size) ) ){
//            coordinates_player[0].x = Panel.screenWidth - (Panel.screenWidth/Panel.tile_size) ;
//            coordinates_player[0].y = ( i * Panel.tile_size ) ;
//        }else if( (coordinates_player[0].y>=Panel.screenWidth - (Panel.screenWidth/Panel.tile_size) ) && (coordinates_player[0].x>=Panel.screenWidth - (Panel.screenWidth/Panel.tile_size) ) ){
//            coordinates_player[0].x = Panel.screenWidth - ( i * Panel.tile_size ) ;
//            coordinates_player[0].y = Panel.screenWidth - (Panel.screenWidth/Panel.tile_size) ;
//        }else{
//            coordinates_player[0].x = 0 ;
//            coordinates_player[0].y = Panel.screenWidth - ( i * Panel.tile_size )  ;
//        }
//        ++i;
//        for(int j=1 ; j <3 ; j++){
//            if( j==1 ){
//                coordinates_player[i].x = temp_X ;
//                coordinates_player[i].y = temp_Y ;
//            }
//            coordinates_player[i] =
//        }

        if(direction.equalsIgnoreCase("up")){
            coordinates_player[0].y -= Panel.tile_size ;
        }else if(direction.equalsIgnoreCase("down")){
            coordinates_player[0].y += Panel.tile_size ;
        }else if(direction.equalsIgnoreCase("left")){
            coordinates_player[0].x -= Panel.tile_size ;
        }else if(direction.equalsIgnoreCase("right")){
            coordinates_player[0].x += Panel.tile_size ;
            direction.equalsIgnoreCase("left here ");
        }
    }

    @Override
    public void draw(Graphics2D g2d){
        g2d.fillRect(0 * Panel.tile_size ,5 * Panel.tile_size, Panel.tile_size ,  Panel.tile_size);

    }


}
