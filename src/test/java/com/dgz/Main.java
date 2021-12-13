package com.dgz;

import com.dgz.common.DataType;
import com.dgz.common.Variable;
import com.dgz.context.Context;
import com.dgz.util.ConnectionUtils;
import org.apache.log4j.PropertyConfigurator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
      //  Connection con = ConnectionUtils.getConnection();
        //Context context = new Context(con);
        //String query = "insert into cliente (cedula, nombre, apellido, fecha_nac, sexo) values('0927587007', 'Douglas', 'Gallardo', '2000-07-11', 'H')";
        //String query = "select * from prueba.cliente";

        //context.exec(query);
        //context.resulSet(query);


      //  Variable var = new Variable("@i_cedula", DataType.STRING, 0927587006);

        String dateTime = "2021-03-25 00:00:00";
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = null;
        try {
            date = dateParser.parse(dateTime);
            System.out.println(date);}
        catch (ParseException e){

        }

    }
}
