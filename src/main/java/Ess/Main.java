package Ess;

import javax.swing.*;

public class Main {
    public static JFrame frame = new JFrame();
    public static void main (String args[]) {
        Panel panel = new Panel();

        frame.setTitle("Aj game");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        panel.thread.start();

    }

}