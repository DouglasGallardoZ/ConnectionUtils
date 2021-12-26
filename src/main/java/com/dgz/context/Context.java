package com.dgz.context;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class Context {
    private static final Logger LOGGER = Logger.getLogger(Context.class);
    private static Connection con;
    private int status;
    private int rowCount;
    private Resulsets resulset;
    private static PreparedStatement preparedStmt;
    private static Statement statement;


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
    public int exec(String sentenceSql) throws SQLException {
        status = 0;
        try {
            preparedStmt = con.prepareStatement(sentenceSql);
            preparedStmt.execute();
            preparedStmt.close();
            LOGGER.info("Sentencia ejecutada correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
            status = 1;
        }finally {
            preparedStmt.close();
            con.close();
        }
        return status;
    }

    public int exec(String sentenceSql , Object... var) throws SQLException {
        status = 0;
        int i =0;

        try {
            preparedStmt = con.prepareStatement(sentenceSql);
            for (Object var2 : var){
                i++;
                preparedStmt.setString(i, var2.toString());
            }
            preparedStmt.execute();
            LOGGER.info("Sentencia ejecutada correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
            status = 1;
        }finally {
            preparedStmt.close();
            con.close();

        }

        return status;
    }


    public int resulSet(String query) throws SQLException {
        status = 0;
       // int i = 0;
        ArrayList<String> listRow;
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery (query);

            resulset.setMetaData(rs.getMetaData());

            while (rs.next()){
                //i = 0;
                listRow = new ArrayList<>();
                try{
                    for (int i = 0; i < rs.getMetaData().getColumnCount(); i++){
                        listRow.add(rs.getString(i+1));
                    }

                    /*while (true){
                        i++;
                        listRow.add(rs.getString(i));
                    }*/
                } catch (SQLException e){
                    e.printStackTrace();
                    LOGGER.info("Carga de data exitosa");
                }

                resulset.getData().getRow().add(listRow);
                rowCount++;

            }

        } catch (SQLException e) {
            e.printStackTrace();
            status = 1;
        }
        finally {
            statement.close();
            con.close();

        }
        return status;
    }


    public int resulSet(String query, Object... var) throws SQLException {
        status = 0;
        int i = 0;
        int j = 0;
        ArrayList<String> listRow;
        try {
            preparedStmt = con.prepareStatement(query);
            for (Object var2 : var){
                j++;
                preparedStmt.setString(j, var2.toString());
            }
            ResultSet rs = preparedStmt.executeQuery();

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
                    e.printStackTrace();
                    LOGGER.info("Carga de data exitosa");
                }

                resulset.getData().getRow().add(listRow);
                rowCount++;

            }
        } catch (SQLException e) {
            e.printStackTrace();
            status = 1;
        }
        finally {
          preparedStmt.close();
          con.close();

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
