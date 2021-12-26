package com.dgz;

import com.dgz.context.Context;
import com.dgz.util.ConnectionUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con = ConnectionUtils.getConnection();
        Context context = new Context(con);
        //String query = "insert into cliente (cedula, nombre, apellido, fecha_nac, sexo) values(?, ?, ?, ?, ?)";
        //String query = "truncate table prueba.cliente";
      /*  String query = "insert into cliente (cedula, nombre, apellido, fecha_nac, sexo) values('0927587006', 'Douglas'," +
                " 'Gallardo', '2000-07-11', 'H')";
        */

       String query = "select * from cliente";

       context.resulSet(query);

        System.out.println(1);









    }
}
