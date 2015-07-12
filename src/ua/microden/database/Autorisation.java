package ua.microden.database;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Autorisation extends JFrame{
    static JButton singIn;
    static JLabel l1;
    static JLabel l2;
    static JTextField loginInt;
    static JPasswordField passInt;
    static DBWorker worker;
    static Frame frame;

    public Autorisation(String s){
        super(s);
        setLayout(new FlowLayout());
        singIn = new JButton("Sing In");
        l1 = new JLabel("Login:");
        l2 = new JLabel("Pass: ");
        loginInt = new JTextField(10);
        passInt = new JPasswordField(10);
        l1.setForeground(Color.ORANGE);
        l2.setForeground(Color.ORANGE);
        add(l1);
        add(loginInt);
        add(l2);
        add(passInt);
        add(singIn);
        singIn.addActionListener(e -> {
            try{
                Frame.login = loginInt.getText();
                Frame.pass = new String(passInt.getPassword());
                if(control()){
                    frame = new Frame("Вы ввошли как: " + Frame.login);
                    passInt.setText(null);
                    setVisible(false);
                    frame.getContentPane().setBackground(Color.GRAY);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    frame.setVisible(true);
                }
            }catch (Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ошибка соединения с Базой Данных");
            }
        });
    }

    public boolean control() throws SQLException {
        String selectDataSQL = "SELECT * FROM users WHERE username='" + Frame.login + "' AND password='" + Frame.pass + "'";
        System.out.println(selectDataSQL);
        worker = new DBWorker();
        DBWorker.loadStat(selectDataSQL);
        return Frame.online;
    }
}
