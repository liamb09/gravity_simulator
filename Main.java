// From tutorial at https://www.youtube.com/watch?v=zCiMlbu1-aQ

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int width = 1000;
        int height = 1000;
        JFrame frame = new JFrame("Gravity Demo");
        DrawingCanvas dc = new DrawingCanvas(width, height);
//        JButton b = new JButton("increment");
//        b.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (e.getSource() == b) {
//                    frame.repaint();
//                }
//            }
//        });
//        frame.add(b, BorderLayout.SOUTH);
        frame.setSize(width, height);
        frame.add(dc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while (true) {
            frame.setVisible(true);
            frame.repaint();
            TimeUnit.MILLISECONDS.sleep(1);
        }
    }
}