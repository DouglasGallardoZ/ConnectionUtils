package com.dgz.util;

import org.apache.log4j.PropertyConfigurator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection con = ConnectionUtils.getConnection();
        String query = "insert into cliente values('DOUGLAS', 'GALLARDO', '2000-07-11 00:00:00', 'H')";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.execute();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
