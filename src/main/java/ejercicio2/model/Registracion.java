package ejercicio2.model;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import ejercicio2.dataBase.GrabarYLeerTXT;

@Aspect
public class Registracion {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    GrabarYLeerTXT percistencia = new GrabarYLeerTXT("C:/Users/desertfoxs/Desktop/txt tp4 ejercicio 3/");

    //@Before("execution(* ejercicio2.model.IncribirConcurso.todosLosConcursos())") llama a un metodo
    @Before("execution(@Marca * *(..))")
    public void registrarAntes(JoinPoint joinPoint) {
        String parametros = "";
        String nombreMetodo = joinPoint.getSignature().getName();
        Object[] parametro =  joinPoint.getArgs();

        if(parametro.length > 0 ){
            //parametros = (String) joinPoint.getArgs()[0];
            for(int i = 0; i < parametro.length; i++){
                parametros += (String) joinPoint.getArgs()[i].toString() + "|";
            }
        }
        else{
            parametros = "no tiene parametros";
        }

        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDateTime = dateTime.format(formatter);

        String mensaje = nombreMetodo + ", " + parametros + ", " + formattedDateTime;
        System.out.println(mensaje);
        percistencia.registrarEspecteada(mensaje);
    }
}