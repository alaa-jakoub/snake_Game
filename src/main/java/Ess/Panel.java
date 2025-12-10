package Ess;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable{
    //1024 x 1280
    protected final int tile_size = 32 ;
    protected final int scale_ratio = 4 ;
    protected final int tile = tile_size * scale_ratio ;
    protected final int screen_col = 10 ;
    protected final int screen_row = 6 ;
    protected final int screenWidth = screen_col * tile ;
    protected final int screenHeight = screen_row * tile ;
    protected event_handler eventHandler= new event_handler(this);
    protected int gameStatus ;
    protected final int loading = 0 ;
    protected final int pause = 1 ;
    protected final int playing = 2 ;
    public Thread thread =new Thread(this);
    //constructor
    public Panel () {
        setPreferredSize(new Dimension(screenWidth,screenHeight));
        setBackground(Color.BLACK);
        super.setDoubleBuffered(true);
        setFocusable(true);
        addKeyListener(eventHandler);
        setLayout(null);
        gameStatus=loading;

    }


    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2d= (Graphics2D) g;


    }

    @Override
    public void run() {

    }
}
