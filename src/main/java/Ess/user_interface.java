package Ess;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class user_interface {
    Panel panel;
    public JFrame start_up_frame;
    public BufferedImage [] welcome_sprites ;
    public Icon[] icon;
    JLabel [] mousa_label;
    public JLabel textLabel ;
    public JButton start_up_button = new JButton();
    public user_interface(Panel panel){
        this.panel=panel;
        initialize_start_up_frame();

    }
    public void initialize_start_up_frame (){
        start_up_frame = new JFrame();
        welcome_sprites = new BufferedImage [5];
        mousa_label = new JLabel[4];
        textLabel = new JLabel("<html>I Wish You<br> Happy New Year.</html>");
        textLabel.setFont(new Font("showcard gothic",Font.PLAIN,30));
        textLabel.setBackground(Color.WHITE);
        textLabel.setForeground(new Color(panel.colorR,panel.colorG,panel.colorB));
        textLabel.setBounds((Panel.screenWidth - Panel.tile_size*6)/2,(Panel.screenHeight-Panel.tile_size*4)/2,Panel.tile_size*6,Panel.tile_size*4);
        icon = new Icon[5];
        start_up_frame.setSize(Panel.screenWidth,Panel.screenHeight);
        start_up_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start_up_frame.setLocationRelativeTo(null);
        start_up_frame.setResizable(false);
        start_up_frame.setLayout(null);
        start_up_button.setSize(Panel.tile_size*4 , Panel.tile_size*4);
        start_up_button.setFocusable(true);
        start_up_button.setBorder(null);
        start_up_button.setOpaque(false);
        start_up_button.setBackground(new Color(255,255,255));
        start_up_button.setFont(textLabel.getFont());
        start_up_button.setText("Start");
        start_up_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==start_up_button){
                    start_up_frame.setVisible(false);
                    Main.frame.setVisible(true);
                    panel.gameStatus=panel.playing;
                }
            }
        });
        start_up_button.setBounds(new Rectangle((Panel.screenWidth - start_up_button.getWidth())/2,(Panel.screenHeight-start_up_button.getHeight())/2,start_up_button.getWidth(),start_up_button.getHeight()));
        for (int i=0 ; i< welcome_sprites.length ; i++){
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
        start_up_frame.setVisible(true);
    }


}
