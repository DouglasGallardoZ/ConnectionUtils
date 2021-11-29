package com.dgz.util;

import com.dgz.context.Context;
import org.apache.log4j.PropertyConfigurator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection con = ConnectionUtils.getConnection();
        Context context = new Context(con);
        String query = "TRUNCATE TABLE cliente";
        context.exec(query);

    }
}
