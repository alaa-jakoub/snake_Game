package entity;

import Ess.Panel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class food extends entity{
    public Rectangle food_rec ;
    int x=0, y=0;
    boolean onSnake = false;
    public Random random ;
    public food(Panel panel) {
        super(panel);
        food_rec = new Rectangle(Panel.tile_size , Panel.tile_size);
        x=y= 11 * Panel.tile_size;
        food_rec.setLocation(x,y);

        random = new Random();
        try {
            entityImage = ImageIO.read(getClass().getResourceAsStream("/mousa blue eye.png"));
            entityImage = Panel.orginizationTool.scaleImage(entityImage,Panel.tile_size,Panel.tile_size);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update () {
        if (panel.player1.player_rec[0].intersects(food_rec)) {

            do {
                onSnake=false;
                x = random.nextInt(0, 12) * Panel.tile_size;
                y = random.nextInt(0, 12) * Panel.tile_size;
                for (int i = 0; i < player.player_squares; i++) {
                    if (panel.player1.player_rec[i].x == x && panel.player1.player_rec[i].y == y) {
                        onSnake=true;
                        break;
                    }
                }



            } while (onSnake) ;
            food_rec.setLocation(x, y);
            player.player_squares++;
        }
    }
    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(entityImage, x, y, null);

    }
}
