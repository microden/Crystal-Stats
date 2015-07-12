package ua.microden.database;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Frame extends JFrame{

    public static String login;
    public static String selectDataSQL;
    public static String pass;
    public static int lvl;
    public static int money;
    public static boolean online;
    public static int house;
    public static int admin;
    public static int uhclass;
    public static int[] hclass = new int[10];
    public static int[] hnum = new int[10];
    public static int[] hprice = new int[10];
    public static int[] bprice = new int[10];
    public static int[] bmats = new int[10];
    public static boolean[] bfree = new boolean[10];
    public static String[] bname = new String[10];
    static DBWorker worker;
    private ArrayList<JLabel> labels = new ArrayList<>();

    public Frame(String s) throws SQLException{
        super(s);
        menuCreate();
        stat();
    }

    public void addLabel(String text, int size){
        JLabel label = new JLabel(text);
        labels.add(label);
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        label.setForeground(Color.ORANGE);
        label.setFont(new Font("Dialog", Font.ITALIC, size));
        add(label);
        revalidate();
    }

    public void stat(){
        setSize(370, 270);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        addLabel("Игровой ник: " + login, 20);
        addLabel("Игровой уровень: " + lvl, 20);
        addLabel("Деньги в игре: " + money, 20);
        if(house!=255) {
            addLabel("Дом в игре: №" + house + " [" + uhclass + "]", 20);
        }else{
            addLabel("Дом в игре отсутствует", 20);
        }
        switch (admin){
            case 0: addLabel("Жалкий смертный", 20);
                    break;
            case 1:
            case 2:
                    addLabel("Статус: Практикант ["+admin+"]", 20);
                    break;
            case 3:
            case 4:
                    addLabel("Статус: Младший Модератор ["+admin+"]", 20);
                    break;
            case 5: addLabel("Статус: Модератор ["+admin+"]", 20);
                    break;
            case 6: addLabel("Статус: Старший Модератор ["+admin+"]", 20);
                    break;
            case 7: addLabel("Статус: Главный Модератор ["+admin+"]", 20);
                    break;
            case 8: addLabel("Статус: Младший Администратор ["+admin+"]", 20);
                    break;
            case 9: addLabel("Статус: Администратор ["+admin+"]", 20);
                    break;
            case 10: addLabel("Статус: Старший Администратор ["+admin+"]", 20);
                    break;
            case 11: addLabel("Статус: Специальный Администратор ["+admin+"]", 20);
                    break;
            case 12: addLabel("Статус: Главный Администратор ["+admin+"]", 20);
                    break;
            case 13: addLabel("Статус: Основатель ["+admin+"]", 20);
                    break;
        }
    }

    public void biz() throws SQLException {
        setSize(650, 270);
        setLocationRelativeTo(null);
        removeAll();
        String free;
        loadBiz();
        setLayout(new FlowLayout(FlowLayout.LEFT));

        if (bfree[0]){
            free = "Свободный";
        }else {
            free = "Занят";
        }
        addLabel("Название бизнеса: " + bname[0]
                + " | Цена бизнеса: " + bprice[0]
                + " | Материалы: " + bmats[0]
                + " | Статус: " + free, 12);

        if (bfree[1]){
            free = "Свободный";
        }else {
            free = "Занят";
        }
        addLabel("Название бизнеса: " + bname[1]
                + " | Цена бизнеса: " + bprice[1]
                + " | Материалы: " + bmats[1]
                + " | Статус: " + free, 12);

        if (bfree[2]){
            free = "Свободный";
        }else {
            free = "Занят";
        }
        addLabel("Название бизнеса: " + bname[2]
                + " | Цена бизнеса: " + bprice[2]
                + " | Материалы: " + bmats[2]
                + " | Статус: " + free, 12);

        if (bfree[3]){
            free = "Свободный";
        }else {
            free = "Занят";
        }
        addLabel("Название бизнеса: " + bname[3]
                + " | Цена бизнеса: " + bprice[3]
                + " | Материалы: " + bmats[3]
                + " | Статус: " + free, 12);

        if (bfree[4]){
            free = "Свободный";
        }else {
            free = "Занят";
        }
        addLabel("Название бизнеса: " + bname[4]
                + " | Цена бизнеса: " + bprice[4]
                + " | Материалы: " + bmats[4]
                + " | Статус: " + free, 12);

        if (bfree[5]){
            free = "Свободный";
        }else {
            free = "Занят";
        }
        addLabel("Название бизнеса: " + bname[5]
                + " | Цена бизнеса: " + bprice[5]
                + " | Материалы: " + bmats[5]
                + " | Статус: " + free, 12);

        if (bfree[6]){
            free = "Свободный";
        }else {
            free = "Занят";
        }
        addLabel("Название бизнеса: " + bname[6]
                + " | Цена бизнеса: " + bprice[6]
                + " | Материалы: " + bmats[6]
                + " | Статус: " + free, 12);
    }

    public void houses() throws SQLException {
        setSize(450, 270);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        removeAll();
        String free;
        loadHouse();
        free = "Свободный";
        for(int i=0;i<DBWorker.i;i++) {
            addLabel("Номер дома: " + hnum[i]
                    + " | Класс: " + hclass[i]
                    + " | Цена: " + hprice[i]
                    + " | Статус: " + free, 12);
        }
    }

    public void quit() throws SQLException{
        removeAll();
        login = null;
        pass = null;
        Autorisation autoFrame = new Autorisation("Вход");
        setVisible(false);
        autoFrame.setLayout(new FlowLayout());
        autoFrame.setSize(200, 120);
        autoFrame.getContentPane().setBackground(Color.GRAY);
        autoFrame.setLocationRelativeTo(null);
        autoFrame.setResizable(false);
        autoFrame.setVisible(true);
    }

    public void menuCreate() throws SQLException{
        Font font = new Font("Verdana", Font.PLAIN, 11);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Разделы");
        fileMenu.setFont(font);
        fileMenu.setForeground(Color.ORANGE);

        JMenuItem statsMenu = new JMenuItem("Статистика");
        statsMenu.setFont(font);
        statsMenu.setBackground(Color.ORANGE);
        fileMenu.add(statsMenu);
        statsMenu.addActionListener(e -> {
            removeAll();
            stat();
        });

        JMenuItem bizMenu = new JMenuItem("Бизнесы");
        bizMenu.setFont(font);
        bizMenu.setBackground(Color.ORANGE);
        fileMenu.add(bizMenu);
        bizMenu.addActionListener(e -> {
            removeAll();
            try {
                biz();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });

        JMenuItem houseMenu = new JMenuItem("Свободные дома");
        houseMenu.setFont(font);
        houseMenu.setBackground(Color.ORANGE);
        fileMenu.add(houseMenu);
        houseMenu.addActionListener(e -> {
            removeAll();
            try {
                houses();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });

        fileMenu.addSeparator();

        JMenuItem outMenu = new JMenuItem("Выйти");
        outMenu.setFont(font);
        outMenu.setBackground(Color.yellow);
        fileMenu.add(outMenu);
        outMenu.addActionListener(e -> {
            int reply = JOptionPane.showConfirmDialog(null, "Хотите выйти?", "Выход", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                removeAll();
                try {
                    quit();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JMenuItem exitMenu = new JMenuItem("Закрыть");
        exitMenu.setFont(font);
        exitMenu.setBackground(Color.RED);
        fileMenu.add(exitMenu);
        exitMenu.addActionListener(e -> {
            int reply = JOptionPane.showConfirmDialog(null, "Хотите закрыть?", "Закрытие", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        JMenu updateMenu = new JMenu("Обновить");
        updateMenu.setFont(font);
        updateMenu.setForeground(Color.ORANGE);

        JMenuItem houseItem = new JMenuItem("Дома");
        houseItem.setFont(font);
        updateMenu.add(houseItem);
        houseItem.addActionListener(e -> {
            removeAll();
            try {
                loadHouse();
                houses();
                repaint();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Не удалось обновить!");
            }
        });

        JMenuItem bizItem = new JMenuItem("Бизнесы");
        bizItem.setFont(font);
        updateMenu.add(bizItem);
        bizItem.addActionListener(e -> {
            removeAll();
            try {
                loadBiz();
                biz();
                repaint();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Не удалось обновить!");
            }
        });

        JMenu helpMenu = new JMenu("Помощь");
        helpMenu.setFont(font);
        helpMenu.setForeground(Color.ORANGE);

        JMenuItem infoMenu = new JMenuItem("О программе");
        infoMenu.setFont(font);
        helpMenu.add(infoMenu);
        infoMenu.addActionListener(e -> JOptionPane.showMessageDialog(null, "Создатели:\nDenis Popovich (Kenny_Wills)\nMax Leva (Maks_Leon)"));

        JMenu urlMenu = new JMenu("Ссылки");
        urlMenu.setFont(font);
        urlMenu.setForeground(Color.ORANGE);

        JMenuItem siteMenu = new JMenuItem("Сайт");
        siteMenu.setFont(font);
        urlMenu.add(siteMenu);
        siteMenu.addActionListener(e -> open("http:/crystal-rp.ru"));

        JMenuItem forumMenu = new JMenuItem("Форум");
        forumMenu.setFont(font);
        urlMenu.add(forumMenu);
        forumMenu.addActionListener(e -> open("http:/forum-crystal-rp.ru"));

        JMenuItem adminMenu = new JMenuItem("Список администрации");
        adminMenu.setFont(font);
        urlMenu.add(adminMenu);
        adminMenu.addActionListener(e -> open("http:/crystal-rp.ru/admins.php"));

        menuBar.add(fileMenu);
        menuBar.add(updateMenu);
        menuBar.add(urlMenu);
        menuBar.add(helpMenu);
        menuBar.setBackground(Color.DARK_GRAY);
        menuBar.setForeground(Color.ORANGE);
        setJMenuBar(menuBar);
    }

    public void loadBiz() throws SQLException{
        selectDataSQL = "SELECT * FROM bizstats";
        System.out.println(selectDataSQL);
        worker = new DBWorker();
        DBWorker.loadBiz(selectDataSQL);
    }

    public void loadHouse() throws SQLException {
        selectDataSQL = "SELECT * FROM housestats ORDER BY free DESC";
        System.out.println(selectDataSQL);
        worker = new DBWorker();
        DBWorker.loadHouse(selectDataSQL);
    }

    public void removeAll(){
        while (labels.size() > 0) {
            int index = labels.size() - 1;
            JLabel label = labels.remove(index);
            remove(label);
            repaint();
            revalidate();
        }
    }

    public void open(String url){
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Ссылка не работает");
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ссылка не работает");
        }
    }
}
