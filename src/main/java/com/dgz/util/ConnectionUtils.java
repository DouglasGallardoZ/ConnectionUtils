package com.dgz.util;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    private static final Logger LOGGER = Logger.getLogger(ConnectionUtils.class);
    private static final String USER = "root";
    private static final String PASSWORD = "rootpw";
    private static final String PORT = "3306";

    private static String jurl = "jdbc:mysql://localhost:"+PORT+"/prueba";

    private ConnectionUtils(){}

    public static Connection getConnection(){
        BasicConfigurator.configure();
        LOGGER.info("Iniciando conexion a Base de Datos");
        Connection con = null;

        try {
            con = DriverManager.getConnection(jurl, USER, PASSWORD);
            LOGGER.info("Conexion exitosa");
        } catch (SQLException e) {
            LOGGER.info("Error en conexion");
            e.printStackTrace();
        }

        return con;
    }

}
