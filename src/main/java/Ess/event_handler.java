package Ess;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class event_handler implements KeyListener {
    public Panel panel;
    public boolean pressed;
    //constructor
    public event_handler (Panel panel) {
        this.panel = panel ;
        pressed =false ;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(!pressed) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (panel.player1.direction.equalsIgnoreCase("down")) {
                    panel.player1.direction = "down";
                } else {
                    panel.player1.direction = "up";
                }
                pressed = !pressed;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (panel.player1.direction.equalsIgnoreCase("up")) {
                    panel.player1.direction = "up";
                } else {
                    panel.player1.direction = "down";
                }
                pressed = !pressed;
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (panel.player1.direction.equalsIgnoreCase("right")) {
                    panel.player1.direction = "right";
                } else {
                    panel.player1.direction = "left";
                }
                pressed = !pressed;
            } else {
                if (panel.player1.direction.equalsIgnoreCase("left")) {
                    panel.player1.direction = "left";
                } else {
                    panel.player1.direction = "right";
                }
                pressed = !pressed;
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (panel.player1.direction.equalsIgnoreCase("down")) {
                panel.player1.direction = "down";
            } else {
                panel.player1.direction = "up";
            }
            if (pressed)
                pressed =! pressed;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (panel.player1.direction.equalsIgnoreCase("up")) {
                panel.player1.direction = "up";
            } else {
                panel.player1.direction = "down";
            }
            if (pressed)
                pressed =! pressed;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (panel.player1.direction.equalsIgnoreCase("right")) {
                panel.player1.direction = "right";
            } else {
                panel.player1.direction = "left";
            }
            if (pressed)
                pressed =! pressed;
        } else {
            if (panel.player1.direction.equalsIgnoreCase("left")) {
                panel.player1.direction = "left";
            } else {
                panel.player1.direction = "right";
            }
            if (pressed)
                pressed =! pressed;
        }

    }
}
