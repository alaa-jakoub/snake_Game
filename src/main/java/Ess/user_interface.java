package Ess;

import entity.player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class user_interface {
    Panel panel;
    public JFrame start_up_frame,try_Again_frame;
    public BufferedImage [] welcome_sprites ;
    public boolean started = false , fofo_onscreen =false;
    public Icon[] icon;
    public int sprites=0;
    JLabel [] mousa_label;
    JLabel fofo_label;
    public JLabel textLabel ,try_again_text_label;
    public JButton start_up_button = new JButton(),try_again_button=new JButton();
    public user_interface(Panel panel){
        this.panel=panel;
        initialize_start_up_frame();

    }
    public void initialize_start_up_frame (){
        start_up_frame = new JFrame();
        try_Again_frame = new JFrame();
        welcome_sprites = new BufferedImage [21];
        mousa_label = new JLabel[4];
        fofo_label=new JLabel();
        textLabel = new JLabel("");
        try_again_text_label=new JLabel("");
        textLabel.setFont(new Font("showcard gothic",Font.PLAIN,15));
        textLabel.setBackground(Color.WHITE);
        textLabel.setForeground(new Color(panel.colorR,panel.colorG,panel.colorB));
        try_again_text_label.setBackground(Color.WHITE);
        try_again_text_label.setForeground(Color.black);
        icon = new Icon[21];
        sprites=21;
        start_up_frame.setSize(Panel.screenWidth,Panel.screenHeight);
        start_up_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start_up_frame.setLocationRelativeTo(null);
        start_up_frame.setResizable(false);
        start_up_frame.setLayout(null);

        try_Again_frame.setSize(Panel.screenWidth,Panel.screenHeight);
        try_Again_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try_Again_frame.setLocationRelativeTo(null);
        try_Again_frame.setResizable(false);
        try_Again_frame.setLayout(null);


        start_up_button.setSize(Panel.tile_size*4 , Panel.tile_size*4);
        start_up_button.setFocusable(true);
        start_up_button.setBorder(null);
        start_up_button.setOpaque(false);
        start_up_button.setBackground(new Color(255,255,255));
        start_up_button.setFont(textLabel.getFont().deriveFont(30f));
        start_up_button.setText("Start");

        try_again_button.setBounds(-4654,-564,Panel.tile_size*4 , Panel.tile_size*4);
        try_again_button.setFocusable(true);
        try_again_button.setBorder(null);
        try_again_button.setOpaque(false);
        try_again_button.setBackground(new Color(255,255,255));
        try_again_button.setFont(textLabel.getFont().deriveFont(30f));

        try_again_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i <player.player_squares ; i++) {
                    panel.player1.coordinates_player[i].x=-100;
                    panel.player1.coordinates_player[i].y=-100;
                }
                player.player_squares =1;


                    panel.player1.coordinates_player[0].x = 0;
                    panel.player1.coordinates_player[0].y = 0;
                    panel.player1.direction="right";
                    panel.player1.next_direction = "right";


                panel.player1.red=0;
                panel.player1.green=0;
                panel.player1.blue=255;


                panel.food.x= panel.food.random.nextInt(0,11) * Panel.tile_size;
                panel.food.y= panel.food.random.nextInt(0,11) * panel.tile_size;

                panel.food.food_rec.setLocation(panel.food.x,panel.food.y);
                try_Again_frame.setVisible(false);
                Main.frame.setVisible(true);
                panel.gameStatus=panel.playing;


            }
        });

        start_up_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==start_up_button){
                    if(!started){
                        if(!fofo_onscreen){
                            sprites = 4;
                            for (int i = 0; i <sprites; i++) {
                                try {

                                    welcome_sprites[i] = ImageIO.read(getClass().getResourceAsStream("/fofo " + (i + 1) + ".png"));
                                    welcome_sprites[i] = Panel.orginizationTool.scaleImage(welcome_sprites[i], Panel.tile_size * 4, Panel.tile_size * 4);

                                    icon[i] = new ImageIcon(welcome_sprites[i]);
                                } catch (IOException es) {
                                    es.printStackTrace();
                                    throw new RuntimeException(es);
                                }
                            }
                            fofo_label.setBounds((Panel.screenWidth-(Panel.tile_size*4))/Panel.screenWidth, (Panel.screenHeight-(Panel.tile_size*12)), Panel.tile_size*4 ,Panel.tile_size*4);
                            start_up_button.setBounds(new Rectangle((Panel.screenWidth - start_up_button.getWidth())/2,(Panel.screenHeight-start_up_button.getHeight())/2,start_up_button.getWidth(),start_up_button.getHeight()));

                            textLabel.setBounds(( fofo_label.getWidth()),(Panel.screenHeight-Panel.tile_size*12),Panel.tile_size*12,Panel.tile_size*4);

                            for (int i=0;i< mousa_label.length;i++){
                                start_up_frame.remove(mousa_label[i]);

                            }
                            fofo_label.setIcon(icon[0]);
//                            mousa_label=null;
                            start_up_frame.add(fofo_label);
                            start_up_frame.add(textLabel);
                            start_up_frame.repaint();
                            start_up_frame.validate();

                            fofo_onscreen=true;
                        }else if(fofo_onscreen){

                            started=true;
                        }
                    }
                    if(started) {
                        panel.gameStatus=panel.playing;
                        start_up_button.setBounds(-465464654,-466656565,0,0);
                        fofo_label.setVisible(false);
                        start_up_button.setVisible(false);
                        fofo_label=null;
                        mousa_label=null;
                        start_up_button=null;

                        start_up_frame.validate();
                        start_up_frame.repaint();
                        start_up_frame.setVisible(false);
                        start_up_frame=null;
                        Main.frame.setVisible(true);

                    }
                }
            }
        });
        start_up_button.setBounds(new Rectangle((Panel.screenWidth - start_up_button.getWidth())/2,(Panel.screenHeight-start_up_button.getHeight())/2,start_up_button.getWidth(),start_up_button.getHeight()));
        for (int i=0 ; i< sprites ; i++){
            try{

                welcome_sprites[i] = ImageIO.read(getClass().getResourceAsStream("/mousa blue eye "+(i+1)+".png"));
                welcome_sprites[i]= Panel.orginizationTool.scaleImage(welcome_sprites[i],Panel.tile_size*4,Panel.tile_size*4);
                icon[i] =new ImageIcon(welcome_sprites[i]);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        for (int i=0 ; i< mousa_label.length ;i++){
            mousa_label[i]=new JLabel();
            mousa_label[i].setIcon(icon[0]);

            start_up_frame.add(mousa_label[i]);
        }
        mousa_label[0].setBounds((Panel.screenWidth-(Panel.tile_size*4))/Panel.screenWidth, (Panel.screenHeight-(Panel.tile_size*4))/Panel.screenHeight, Panel.tile_size*4 ,Panel.tile_size*4);
        mousa_label[1].setBounds((Panel.screenWidth-(Panel.tile_size*4)), (Panel.screenHeight-(Panel.tile_size*4))/Panel.screenHeight, Panel.tile_size*4 ,Panel.tile_size*4);
        mousa_label[2].setBounds((Panel.screenWidth-(Panel.tile_size*4))/Panel.screenWidth, (Panel.screenHeight-(Panel.tile_size*4)), Panel.tile_size*4 ,Panel.tile_size*4);
        mousa_label[3].setBounds((Panel.screenWidth-(Panel.tile_size*4)), (Panel.screenHeight-(Panel.tile_size*4)), Panel.tile_size*4 ,Panel.tile_size*4);
//        start_up_frame.add(textLabel);
        start_up_frame.add(start_up_button);
        try_Again_frame.add(try_again_button);
        try_Again_frame.add(try_again_text_label);
        start_up_frame.setVisible(true);
    }


}
