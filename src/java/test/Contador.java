package test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author salva
 */
public class Contador {

    public String getJugada_cliente() {
        return jugada_cliente;
    }

    public void setJugada_cliente(String jugada_cliente) {
        this.jugada_cliente = jugada_cliente;
    }

    public String getJugada_servidor() {
        return jugada_servidor;
    }

    public void setJugada_servidor(String jugada_servidor) {
        this.jugada_servidor = jugada_servidor;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public int getJugadas_ganadas_cliente() {
        return jugadas_ganadas_cliente;
    }

    public void setJugadas_ganadas_cliente(int jugadas_ganadas_cliente) {
        this.jugadas_ganadas_cliente = jugadas_ganadas_cliente;
    }

    public int getJugadas_ganadas_servidor() {
        return jugadas_ganadas_servidor;
    }

    public void setJugadas_ganadas_servidor(int jugadas_ganadas_servidor) {
        this.jugadas_ganadas_servidor = jugadas_ganadas_servidor;
    }

    public int getEmpatadas() {
        return empatadas;
    }

    public void setEmpatadas(int empatadas) {
        this.empatadas = empatadas;
    }

    public int getCliente_ganadas() {
        return cliente_ganadas;
    }

    public void setCliente_ganadas(int cliente_ganadas) {
        this.cliente_ganadas = cliente_ganadas;
    }

    public int getServidor_ganadas() {
        return servidor_ganadas;
    }

    public void setServidor_ganadas(int servidor_ganadas) {
        this.servidor_ganadas = servidor_ganadas;
    }
    String jugada_cliente = " ";
    String jugada_servidor = " ";
    String ganador = " ";
    int jugadas_ganadas_cliente = 0;
    int jugadas_ganadas_servidor = 0;
    int empatadas = 0;
    int cliente_ganadas = 0;
    int servidor_ganadas = 0;    

    public int getWin_server() {
        return win_server;
    }

    public void setWin_server(int win_server) {
        this.win_server = win_server;
    }

    public int getWin_client() {
        return win_client;
    }

    public void setWin_client(int win_client) {
        this.win_client = win_client;
    }
    int win_server = 0;
    int win_client = 0;

    public int getWin_empate() {
        return win_empate;
    }

    public void setWin_empate(int win_empate) {
        this.win_empate = win_empate;
    }
    int win_empate = 0;
    
    
}
