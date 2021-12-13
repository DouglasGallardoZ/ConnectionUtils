package com.dgz.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Variable<T>{

    private String value;
    private DataType type;
    private String id;

    public Variable(String id, DataType type){
        this.id = id;
        this.type = type;
    }

    public Variable(String id, DataType type, Object value){
        this.id = id;
        this.type = type;
        this.value = value.toString();
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getIntValue(){
        return Integer.parseInt(this.value);
    }



    //Metodos que convierten correctamente el tipo de dato

    private Object convertToCorrectType(Object value){

        if(value.equals(null)){
            return null;
        } else if (this.type != null){
            switch (this.type){
                case STRING:
                    return value.toString();
                case INTEGER:
                    return Integer.parseInt(value.toString());
                case DOUBLE:
                    return Double.parseDouble(value.toString());
                case DATETIME:


            }
        }
        return null;
    }

    private Date convertToDate(String dateTime) {

        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = null;
        try {
            date = dateParser.parse(dateTime);
            System.out.println(date);

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(dateFormatter.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }




}
