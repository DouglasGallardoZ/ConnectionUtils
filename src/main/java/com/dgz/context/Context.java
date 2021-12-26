package com.dgz.context;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Context {
    private static final Logger LOGGER = Logger.getLogger(Context.class);
    private Connection con;
    private int status;
    private int rowCount;
    private Resulsets resulset;
    private PreparedStatement preparedStmt;
    private Statement statement;


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

    public int exec(String sentenceSql , Object... variable) throws SQLException {
        status = 0;
        int i =0;

        try {
            preparedStmt = con.prepareStatement(sentenceSql);
            for (Object var2 : variable){
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
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery (query);

            executeResulset(rs);
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


    public int resulSet(String query, Object... varviable) throws SQLException {
        status = 0;
        int j = 0;

        try {
            preparedStmt = con.prepareStatement(query);
            for (Object var2 : varviable){
                j++;
                preparedStmt.setString(j, var2.toString());
            }
            ResultSet rs = preparedStmt.executeQuery();

            executeResulset(rs);

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

    private void executeResulset(ResultSet rs) throws SQLException {
        List<String >listRow = new ArrayList<>();
        resulset.setMetaData(rs.getMetaData());

        while (rs.next()){
            listRow = new ArrayList<>();
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++){
                listRow.add(rs.getString(i+1));
            }
            resulset.getData().getRow().add(listRow);
            rowCount++;
        }
        LOGGER.info("Carga de data exitosa");

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
