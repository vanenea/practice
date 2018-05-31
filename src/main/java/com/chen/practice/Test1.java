package com.chen.practice;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Test1 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
            String sql = "select now() from dual";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet set = preparedStatement.executeQuery();
            while(set.next()){
                Date date = set.getDate(1);
                System.out.println("date:"+date);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static Collection add(String[] strings) {
        List<String> list = new ArrayList<>();
        for(String s:strings){
            list.add(s);
        }
        return list;
    }
}
