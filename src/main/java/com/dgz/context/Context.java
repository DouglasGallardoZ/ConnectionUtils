package com.dgz.context;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Context {
    private static Connection con;
    private static int status;

    public Context(Connection con){
        this.con = con;
    }

    /**
     * Metodo que permite ejecutar sentencias sql para insert,
     * update y delete
     * @param sentenceSql
     * @return
     */
    public static int exec(String sentenceSql){
        status = 0;
        try {
            PreparedStatement preparedStmt = con.prepareStatement(sentenceSql);
            preparedStmt.execute();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            status = 1;
        }
        return status;
    }


}
