package Ess;

import entity.food;
import entity.player;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable{
    //1024 x 1280
    public static final int tile_size = 32 ;
    protected static final int scale_ratio = 2 ;
    protected static final int tile = tile_size * scale_ratio ;
    protected static final int screen_col = 6 ;
    protected static final int screen_row = 6 ;
    public static final int screenWidth = screen_col * tile ;
    public static final int screenHeight = screen_row * tile ;
    protected event_handler eventHandler= new event_handler(this);
    protected int gameStatus ;
    protected final int loading = 0 ;
    protected final int pause = 1 ;
    protected final int playing = 2 ;
    //loop
    public Thread thread;
    private long currentTime;
    private int FPS=120;
    private double drawInterval =Math.pow(10, 9)/FPS,move_interval=0.25,move_timer,delta,delta_time;
    private long lastTime,timer ;
    private int drawCount;
    private int gameState;
    public int fpsCount;
    //
    //player
    public player player1 ;
    //food eentity
    food food ;
    //orginizationTool
    public static orginizationTool orginizationTool = new orginizationTool();

    //constructor
    public Panel () {
        player1 = new player(this);
        food = new food(this);
        setPreferredSize(new Dimension(screenWidth,screenHeight));
        setBackground(Color.BLACK);
        super.setDoubleBuffered(true);
        setFocusable(true);
        addKeyListener(eventHandler);
        setLayout(null);
        thread =new Thread(this);
        gameStatus=loading;
    }


    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2d= (Graphics2D) g;


        for (int i=0 ; i<=screenHeight ; i+=32){
            g2d.drawLine(0,i,screenWidth,i);

        }
        for(int j=0 ; j<=screenWidth ; j+=32){
            g2d.drawLine(j,0,j,screenHeight);
        }
        g2d.setColor(Color.WHITE);
        player1.draw(g2d);
        food.draw(g2d);

    }

    public void update(){
        food.update();
    }


    @Override
    public void run() {
        drawInterval =Math.pow(10, 9)/FPS;
        delta=0;
        delta_time=0;
        lastTime=System.nanoTime();
        timer=0;
        drawCount=0;

        while(thread !=null) {
            currentTime = System.nanoTime();
            delta+=(currentTime - lastTime)/drawInterval;
            delta_time+=(currentTime - lastTime)/Math.pow(10,9);
            timer+=(currentTime  - lastTime);
            lastTime =currentTime;
            if(delta_time>=move_interval){
                player1.update();
                delta_time=0;
            }
            if(delta>=1) {
                update();
                repaint();
                delta=0;
                drawCount++;
            }
            if(timer>=1000000000) {
                fpsCount=drawCount;
                drawCount=0;
                timer=0;
            }

        }
    }
}
