package com.dgz;

import com.dgz.context.Context;
import com.dgz.util.ConnectionUtils;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection con = ConnectionUtils.getConnection();
        Context context = new Context(con);
        //String query = "insert into cliente (cedula, nombre, apellido, fecha_nac, sexo) values(?, ?, ?, ?, ?)";
        String query = "truncate table prueba.cliente";

        context.exec(query);









    }
}
