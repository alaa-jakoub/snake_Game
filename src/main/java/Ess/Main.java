package Ess;

import javax.swing.*;

public class Main {
    public static void main (String args[]) {
        Panel panel = new Panel();
        JFrame frame = new JFrame();
        frame.setTitle("Aj game");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        panel.thread.start();

    }

}