package com.dgz.common;

import java.sql.Timestamp;

public class Variable<T>{

    private String value;
    private Object valueAsObject;
    private DataType type;
    private String name;

    public Variable(String name, DataType type){
        this.name = name;
        this.type = type;
    }

    public Variable(String name, DataType type, Object value){
        this.name = name;
        this.type = type;
        this.valueAsObject = convertToCorrectType(value);
        this.value = value.toString();
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value.toString();
    }

    public int getIntValue(){
        return Integer.parseInt(this.value.toString());
    }

    public Timestamp getDateValue(){
        return convertToDate(this.value.toString());
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
                    return this.convertToInteger(value);
                case DOUBLE:
                    return Double.parseDouble(value.toString());
                case DATETIME:
                    return this.convertToDate(value.toString());
            }
        }
        return null;
    }

    private Timestamp convertToDate(String dateTime) {
        return Timestamp.valueOf(dateTime);
    }

    private Integer convertToInteger(Object value){
        if(value instanceof Integer){
            return (Integer)value;
        } else if(value instanceof Number){
            return ((Number)value).intValue();
        } else if(value instanceof String){
            try{
                double auxValue = Double.parseDouble((String)value);
                return (int)auxValue;
            } catch (NumberFormatException e){
                System.out.println("Value: "+value.toString()+" no puede ser convertido en Integer");
                throw new NumberFormatException();
            }
        } else {
            System.out.println("Value: "+value.toString()+" no puede ser convertido en Integer");
            throw new RuntimeException();

        }

    }



}
