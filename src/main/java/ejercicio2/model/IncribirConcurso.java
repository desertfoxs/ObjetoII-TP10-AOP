package ejercicio2.model;

import java.io.IOException;
import java.util.List;

public class IncribirConcurso {

    private Registrar registrador;

    public IncribirConcurso(Registrar registrador) {
        this.registrador = registrador;
    }


 //espectear este metodo
    @Marca
    public List<String> todosLosConcursos() throws IOException {
        // carga del archivo de texto concursos.txt los concursos
        return registrador.leerNombreConcursos();
    }


//espectear este metodo
    @Marca
    public void saveInscription(String apellido, String nombre, String DNI, String telefono, String email, int idConcurso) throws RuntimeException, IOException {
            // Guarda en inscriptos.txt los datos de la persona y el concurso elegido
            Persona persona = new Persona(apellido, nombre, DNI, telefono, email, idConcurso);
            registrador.registrarPersona(persona);
    }



}
