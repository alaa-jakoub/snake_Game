package Ess;

public class Coordinates {
    public int x , y;
    public Coordinates () {
        y=x=-Panel.tile_size;
    }
    public void set_coordinates(int x , int y){
        this.x=x;
        this.y=y;
    }

}
