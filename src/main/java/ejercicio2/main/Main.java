package ejercicio2.main;
import ejercicio2.UI.RadioCompetition;
import ejercicio2.dataBase.GrabarLeerBD;
import ejercicio2.dataBase.GrabarYLeerTXT;
import ejercicio2.model.IncribirConcurso;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) { launchApplication();}

    private static void launchApplication() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {

                    GrabarYLeerTXT grabarYLeerTXT = new GrabarYLeerTXT("C:/Users/desertfoxs/Desktop/txt tp4 ejercicio 3/");
                    var BD = new GrabarLeerBD();
                    IncribirConcurso incribirConcurso = new IncribirConcurso(BD);
                    RadioCompetition radioCompetition = new RadioCompetition(incribirConcurso);

                } catch (Exception e) {
                    // log exception...
                    System.out.println(e);
                }
            }
        });
    }
}

