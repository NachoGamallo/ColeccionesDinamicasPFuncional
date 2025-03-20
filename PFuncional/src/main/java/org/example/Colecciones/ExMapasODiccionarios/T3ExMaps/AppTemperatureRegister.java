package org.example.Colecciones.ExMapasODiccionarios.T3ExMaps;

public class AppTemperatureRegister {

    public static void main(String[] args) {

        TemperatureRegister register = new TemperatureRegister();
        register.insertTemperature("Alicante",32);
        register.insertTemperature("Albacete",42);
        register.insertTemperature("Barcelona",22);
        register.insertTemperature("Acoruña",12);
        register.updateTemperature("Alicante");
        register.getTemperature();
        register.getTemperature();
        register.getAllTemperatures();
    }


}
