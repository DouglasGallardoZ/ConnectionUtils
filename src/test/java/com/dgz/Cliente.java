package com.dgz;

import java.util.List;

public class Cliente {
    private String cedula;
    private String nombre;
    private String apellido;
    private String fecha_nac;
    private String sexo;

    public Cliente(String cedula, String nombre, String apellido, String fecha_nac, String sexo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nac = fecha_nac;
        this.sexo = sexo;
    }

    public Cliente(){

    }
    public Cliente(List<String> list){
        this.cedula = list.get(1);
        this.nombre = list.get(2);
        this.apellido = list.get(3);
        this.fecha_nac = list.get(4);
        this.sexo = list.get(5);

    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fecha_nac='" + fecha_nac + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
