package Ess;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class event_handler implements KeyListener {
    public Panel panel;

    //constructor
    public event_handler (Panel panel) {
        this.panel = panel ;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            panel.player1.direction = "up" ;
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            panel.player1.direction = "down" ;
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            panel.player1.direction = "left" ;
        }else{
            panel.player1.direction = "right" ;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            panel.player1.direction = "up" ;

        }else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            panel.player1.direction = "down" ;

        }else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            panel.player1.direction = "left" ;

        }else{
            panel.player1.direction = "right" ;

        }
    }
}
