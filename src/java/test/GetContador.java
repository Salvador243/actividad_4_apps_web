package test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author salva
 */
public class GetContador {
    public static int[] estadisticas(){
        int[] datos = {1,5};
        Contador contador = new Contador();
        datos[0] = (contador.getEmpatadas() + 1 );
        return datos;
    }
}
