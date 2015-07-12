package ua.microden.database;

import java.sql.*;

public class DBWorker {

    public static Connection connection;
    public static Statement statement;
    public static ResultSet rs;
    public static int i;
    public DBWorker(){
        try {
            String HOST = "jdbc:mysql://85.10.205.173:3306/user123456";
            String USERNAME = "java123456";
            String PASSWORD = "123456";
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        }catch (SQLException e){
            System.out.println("Не удалось установить соединение с БД");
        }
    }

    public static void loadStat(String sqlQuery) throws SQLException {
        statement = connection.createStatement();
        rs = statement.executeQuery(sqlQuery);
        Frame.online = rs.next();
        Frame.lvl = rs.getInt("lvl");
        Frame.money = rs.getInt("money");
        Frame.house = rs.getInt("house");
        if(Frame.house!=255) {
            rs = statement.executeQuery("SELECT * FROM housestats WHERE id=" + Frame.house);
            rs.next();
            Frame.uhclass = rs.getInt("class");
        }
    }

    public static void loadBiz(String sqlQuery) throws SQLException {
        statement = connection.createStatement();
        rs = statement.executeQuery(sqlQuery);
        int i = 0;
        while(rs.next()){
            Frame.bname[i] = rs.getString("name");
            Frame.bprice[i] = rs.getInt("price");
            Frame.bmats[i] = rs.getInt("mats");
            Frame.bfree[i] = rs.getBoolean("free");
            i++;
        }
    }

    public static void loadHouse(String sqlQuery) throws SQLException {
        statement = connection.createStatement();
        rs = statement.executeQuery(sqlQuery);
        i = 0;
        rs.next();
        while(rs.getBoolean("free")){
            Frame.hnum[i] = rs.getInt("id");
            Frame.hclass[i] = rs.getInt("class");
            Frame.hprice[i] = rs.getInt("price");
            i++;
            rs.next();
        }
    }

}
