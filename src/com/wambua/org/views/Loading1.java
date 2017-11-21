package com.wambua.org.views;

import java.sql.Connection;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

class Loading1 extends JPanel {

    private JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 50);
    private JLabel label = new JLabel("", JLabel.CENTER);
    private Timer timer = new Timer(1, new ActionListener() {
        private int counter = 1;

        @Override
        public void actionPerformed(ActionEvent ae) {
            label.setText(String.valueOf(counter));

            if (counter <= 1) {
                bar.setValue(++counter);
            } else {
                setVisible(false);
                ClientHome ob = new ClientHome();
                ob.setLocation(null);
                ob.setVisible(true);
                JOptionPane.showMessageDialog(null, "Welcome our estemeed Customer");
                timer.stop();
            }
        }
    });

    public Loading1() {
        super.setLayout(new GridLayout(0, 1));
        bar.setValue(0);
        timer.start();
        this.add(bar);
        this.add(label);
        //JOptionPane.showMessageDialog(null,true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Loading ob = new Loading();

            }
        });
    }
}
