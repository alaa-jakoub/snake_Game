package Ess;

import entity.food;
import entity.player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    public int gameStatus ;
    protected final int loading = 0 ;
    public final int win = 1 ;
    public final int playing = 2 ;
    public final int lose = 3 ;
    //loop
    public Thread thread;
    private long currentTime;
    private int FPS=120;
    private double drawInterval =Math.pow(10, 9)/FPS,move_interval=0.1899999,move_timer,delta,delta_time;
    private long lastTime,timer ;
    private int drawCount;
    private int gameState;
    public int fpsCount;
    //
    int sprite_image_counter =0 ;
    int you_lose_counter = 0;
    int color_sprite_counter=0;
    int images_sprite_i =0;
    boolean reverse = false;
    public boolean losed =false,change_layout=false;
    public String fofo_script="<html> Hi ,Im Fajer<br>I hope you like Alaa's Game<br>What are you Waiting for <br>start the Game.....</html>";
    public String Lose_script ="";
    public char[] fofo_script_chars,lose_script_chars;
    int script_index=0;
    String script="";
    //
    //ui
    user_interface ui ;
    public int colorB , colorR ,colorG;
    //player
    public player player1 ;
    //food eentity
    food food ;
    //orginizationTool
    public static orginizationTool orginizationTool = new orginizationTool();

    //constructor
    public Panel () {
        ui = new user_interface(this);
        player1 = new player(this);
        food = new food(this);
        setPreferredSize(new Dimension(screenWidth,screenHeight));
        setBackground(Color.BLACK);
        super.setDoubleBuffered(true);
        setFocusable(true);
        addKeyListener(eventHandler);
        setLayout(null);
        thread =new Thread(this);
        fofo_script_chars=fofo_script.toCharArray();
//        lose_script_chars=Lose_script.toCharArray();
        gameStatus=loading;
    }


    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2d= (Graphics2D) g;


//        for (int i=0 ; i<=screenHeight ; i+=32){
//            g2d.drawLine(0,i,screenWidth,i);
//
//        }
//        for(int j=0 ; j<=screenWidth ; j+=32){
//            g2d.drawLine(j,0,j,screenHeight);
//        }
        g2d.setColor(Color.WHITE);
        player1.draw(g2d);
        food.draw(g2d);

    }

    public void update(){
        switch (gameStatus) {
            case playing :{

                food.update();
                break;
            }
            case loading :{

                if(color_sprite_counter > 50){
                    ui.start_up_button.setForeground(new Color(colorR,colorG,colorB));
                    colorB = food.random.nextInt(100,255);
                    colorR = food.random.nextInt(50,255);
                    colorG = food.random.nextInt(30,255);
                    color_sprite_counter =0;
                }
                color_sprite_counter ++;
                if (sprite_image_counter >5){


                    if(images_sprite_i <= 0){
                        reverse = false;
                        images_sprite_i = 0;
                    }
                    if(images_sprite_i >= ui.sprites){
                        reverse = true ;
                        images_sprite_i = ui.sprites-1;

                    }
                    if(!ui.fofo_onscreen){
                        ui.mousa_label[0].setIcon(ui.icon[images_sprite_i]);
                        ui.mousa_label[1].setIcon(ui.icon[images_sprite_i]);
                        ui.mousa_label[2].setIcon(ui.icon[images_sprite_i]);
                        ui.mousa_label[3].setIcon(ui.icon[images_sprite_i]);
                    }else{
                        ui.fofo_label.setIcon(ui.icon[images_sprite_i]);

                        if(script_index>6){
                            ui.textLabel.setText(script);
                        }
                        if(script_index<fofo_script.length()){
                            script+=fofo_script_chars[script_index];
                            script_index++;
                        }

                    }
                    if(reverse){
                        --images_sprite_i;
                    }else {
                        ++images_sprite_i;
                    }
                    sprite_image_counter =0;
                }
                sprite_image_counter++;
                break;
            }
            case lose:{

                if(losed){
                    ui.try_Again_frame.setVisible(true);
                    Main.frame.setVisible(false);

                    Lose_script="<html> YOU LOSE <br> Score : "+(player.player_squares-1)+"<br></html>";
                    lose_script_chars= Lose_script.toCharArray();
                    ui.try_again_text_label.setFont(ui.textLabel.getFont().deriveFont(30f));
                    ui.try_again_text_label.setBounds((screenWidth-(tile_size*5))/2,0,tile_size*6,tile_size*8);
                    ui.try_again_text_label.setText("");


                    ui.try_again_button.setText("TRY AGAIN");
                    ui.try_again_button.setBounds((screenWidth-(tile_size*8))/2,(screenHeight-(tile_size*4))/2,tile_size*8,tile_size*4);



                    script="";
                    script_index=0;
                    losed =false;
                }
                if(you_lose_counter>10){
                    if(script_index>5){
                        ui.try_again_text_label.setText(script);
                    }

                    if (script_index < Lose_script.length()) {
                        script += lose_script_chars[script_index];
                        script_index++;
                    }
                    you_lose_counter=0;
                }
                you_lose_counter++;

                break;
            }
            case win:{

                if(losed){
                    ui.try_Again_frame.setVisible(true);
                    Main.frame.setVisible(false);

                    Lose_script="<html> YOU WIN <br>Max Score : "+(player.player_squares-1)+"<br></html>";
                    lose_script_chars= Lose_script.toCharArray();
                    ui.try_again_text_label.setFont(ui.textLabel.getFont().deriveFont(30f));
                    ui.try_again_text_label.setBounds((screenWidth-(tile_size*5))/2,0,tile_size*6,tile_size*7);
                    ui.try_again_text_label.setText("");


                    ui.try_again_button.setText("PLAY AGAIN");
                    ui.try_again_button.setBounds((screenWidth-(tile_size*8))/2,(screenHeight-(tile_size*4))/2,tile_size*8,tile_size*4);



                    script="";
                    script_index=0;
                    losed =false;
                }
                if(you_lose_counter>10){
                    if(script_index>5){
                        ui.try_again_text_label.setText(script);
                    }

                    if (script_index < Lose_script.length()) {
                        script += lose_script_chars[script_index];
                        script_index++;
                    }
                    you_lose_counter=0;
                }
                you_lose_counter++;

                break;
            }
            default:{
                break;
            }
        }
    }
    public void resetGame(){


        ui.try_again_button.setVisible(false);
        ui.start_up_button.setVisible(false);
        ui.start_up_button.setFocusable(false);
        ui.fofo_label.setVisible(false);
        ui.try_again_button.setVisible(true);

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
            if(delta_time>=move_interval && gameStatus == playing){
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
