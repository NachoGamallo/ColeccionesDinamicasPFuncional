package org.example.Colecciones.Iterator;

public class Casino {

    private String juego;
    private double apuestaMinima;

    public Casino (String juego , double apuestaMinima){

        this.juego = juego;
        this.apuestaMinima = apuestaMinima;

    }

    public String getJuego() {
        return juego;
    }

    public void setJuego(String juego) {
        this.juego = juego;
    }

    public double getApuestaMinima() {
        return apuestaMinima;
    }

    public void setApuestaMinima(double apuestaMinima) {
        this.apuestaMinima = apuestaMinima;
    }

    @Override
    public String toString() {
        return "Casino{" +
                "juego='" + juego + '\'' +
                ", apuestaMinima=" + apuestaMinima +
                '}';
    }
}
