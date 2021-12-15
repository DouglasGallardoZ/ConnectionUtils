package com.dgz.context;

import com.dgz.common.Variable;
import com.dgz.util.ConnectionUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Context {
    private static final Logger LOGGER = Logger.getLogger(Context.class);
    private static Connection con;
    private int status;
    private int rowCount;
    private Resulsets resulset;


    public Context(Connection con){
        BasicConfigurator.configure();
        resulset = new Resulsets();
        this.con = con;
    }

    /**
     * Metodo que permite ejecutar sentencias sql para insert,
     * update y delete
     * @param sentenceSql
     * @return
     */
    public int exec(String sentenceSql){
        status = 0;
        try {
            PreparedStatement preparedStmt = con.prepareStatement(sentenceSql);
            preparedStmt.execute();
            con.close();
            LOGGER.info("Sentencia ejecutada correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
            status = 1;
        }
        return status;
    }

    public int exec(String sentenceSql , Object... var){
        status = 0;
        int i =0;

        try {
            PreparedStatement preparedStmt = con.prepareStatement(sentenceSql);
            for (Object var2 : var){
                i++;
                preparedStmt.setString(i, var2.toString());
            }
            preparedStmt.execute();
            con.close();
            LOGGER.info("Sentencia ejecutada correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
            status = 1;
        }
        return status;
    }


    public int resulSet(String query){
        status = 0;
        int i = 0;
        ArrayList<String> listRow;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery (query);

            resulset.setMetaData(rs.getMetaData());

            while (rs.next()){
                i = 0;
                listRow = new ArrayList<>();
                try{
                    while (true){
                        i++;
                        listRow.add(rs.getString(i));
                    }
                } catch (SQLException e){
                    LOGGER.info("Carga de data exitosa");
                }

                resulset.getData().getRow().add(listRow);
                rowCount++;

            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            status = 1;
        }
        return status;
    }


    public int resulSet(String query, Object... var){
        status = 0;
        int i = 0;
        int j = 0;
        ArrayList<String> listRow;
        try {
            PreparedStatement s = con.prepareStatement(query);
            for (Object var2 : var){
                j++;
                s.setString(j, var2.toString());
            }
            ResultSet rs = s.executeQuery();

            resulset.setMetaData(rs.getMetaData());

            while (rs.next()){
                i = 0;
                listRow = new ArrayList<>();
                try{
                    while (true){
                        i++;
                        listRow.add(rs.getString(i));
                    }
                } catch (SQLException e){
                    LOGGER.info("Carga de data exitosa");
                }

                resulset.getData().getRow().add(listRow);
                rowCount++;

            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            status = 1;
        }
        return status;
    }




    /**
     * Retorna la cantidad de registros que devuelve una consulta
     * @return
     */
    public int getRowCount(){
        return this.rowCount;
    }

    public Resulsets getResulset() {
        return resulset;
    }
}
