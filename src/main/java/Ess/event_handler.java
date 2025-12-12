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
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                panel.player1.next_direction = "up";
                break;
            case KeyEvent.VK_DOWN:
                panel.player1.next_direction = "down";
                break;
            case KeyEvent.VK_LEFT:
                panel.player1.next_direction = "left";
                break;
            case KeyEvent.VK_RIGHT:
                panel.player1.next_direction = "right";
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                panel.player1.next_direction = "up";
                break;
            case KeyEvent.VK_DOWN:
                panel.player1.next_direction = "down";
                break;
            case KeyEvent.VK_LEFT:
                panel.player1.next_direction = "left";
                break;
            case KeyEvent.VK_RIGHT:
                panel.player1.next_direction = "right";
                break;
        }
    }


}
