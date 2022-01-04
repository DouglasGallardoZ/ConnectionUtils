package com.dgz.context;

import com.dgz.common.Data;
import org.apache.log4j.Logger;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Resulsets {
    private static final Logger LOGGER = Logger.getLogger(Resulsets.class);
    private List<String> metaData;
    private Data data;

    public Resulsets(){
        data = new Data();
        metaData = new ArrayList<>();
    }
    public List<String> getMetaData() {
        return metaData;
    }
    public Data getData() {
        return data;
    }



    public void setMetaData(ResultSetMetaData meta) {
        try {
            int i = 0;
            while(i<meta.getColumnCount()){
                i++;
                metaData.add(meta.getColumnName(i));
            }

        } catch (SQLException e){
            LOGGER.info("Carga de metadata exitosa");
        }
    }

}
