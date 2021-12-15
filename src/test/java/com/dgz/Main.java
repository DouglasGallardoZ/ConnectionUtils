package com.dgz;

import com.dgz.common.DataType;
import com.dgz.common.Variable;
import com.dgz.context.Context;
import com.dgz.util.ConnectionUtils;
import org.apache.log4j.PropertyConfigurator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Connection con = ConnectionUtils.getConnection();
        Context context = new Context(con);
        //String query = "insert into cliente (cedula, nombre, apellido, fecha_nac, sexo) values(?, ?, ?, ?, ?)";
        String query = "truncate table prueba.cliente";

        context.exec(query);









    }
}
