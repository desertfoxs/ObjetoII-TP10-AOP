package ejercicio1.aop;

public class Dirigente {

    private String nombre;

    public Dirigente(String nombre) {
        this.nombre = nombre;
    }

    public void insultarA(Arbitro unArbitro, String insulto) {
        //Ingresa a campo de juego y luego:
        unArbitro.escuchar(insulto);
    }
}
