package ua.microden.database;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        Autorisation autoFrame = new Autorisation("Вход");
        autoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        autoFrame.setLayout(new FlowLayout());
        autoFrame.setSize(200, 120);
        autoFrame.getContentPane().setBackground(Color.GRAY);
        autoFrame.setLocationRelativeTo(null);
        autoFrame.setResizable(false);
        autoFrame.setVisible(true);
    }

}
