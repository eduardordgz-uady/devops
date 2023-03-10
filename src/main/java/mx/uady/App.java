package mx.uady;

import java.io.FileNotFoundException;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    static Escritor escritor = new Escritor("palabras.txt");

    public static void main(String[] args) throws FileNotFoundException {

        logger.info("Iniciando sistema");

        for (int i = 0; i < args.length; i++) {
            logger.debug("Argumento[{}]: {}", i, args[i]);
        }

        if (args.length < 1) {
            logger.warn("Se llamo al sistema sin parametros");
            System.out.println("Sin parametros");
            return;
        }

        escribir(args);
    }

    public static void escribir(String[] args) throws FileNotFoundException {
        escritor.escribir(Arrays.asList(args));
    }

    public static void setEscritor(Escritor escritor) {
        App.escritor = escritor;
    }

}
