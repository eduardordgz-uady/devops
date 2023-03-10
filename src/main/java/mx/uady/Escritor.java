package mx.uady;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Escritor {

    private static final Logger logger = LogManager.getLogger(Escritor.class);

    private File file;
    private OutputStream os;
    private OutputStreamWriter writer;

    public Escritor() {
    }

    public Escritor(String filename) {
        logger.info("Nombre del archivo: {}", filename);
        this.file = new File(filename);

        try {
            this.os = new FileOutputStream(this.file);
        } catch (FileNotFoundException e) {
            logger.error("No se pudo crear el archivo");
            throw new RuntimeException();
        }

        this.writer = new OutputStreamWriter(this.os);
    }

    public void escribir(List<String> palabras) throws FileNotFoundException {

        logger.debug("Iniciando escribir() Argumentos: {}", palabras);

        palabras.stream().forEach(p -> {

            try {

                logger.debug("Escribiendo en archivo: {}", p);

                writer.append(p);
                writer.append(System.lineSeparator());
                writer.flush();
                
            } catch (IOException e) {
                logger.error("No se pudo escribir en el archivo. {}", e);
            }

        });

        try {
            logger.debug("Cerrando archivo");
            writer.close();
        } catch (IOException e) {
            logger.error("No se pudo escribir en el archivo. {}", e);
        }

    }

    public File getFile() {
        return this.file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public OutputStream getOs() {
        return this.os;
    }

    public void setOs(OutputStream os) {
        this.os = os;
    }

    public OutputStreamWriter getWriter() {
        return this.writer;
    }

    public void setWriter(OutputStreamWriter writer) {
        this.writer = writer;
    }

    public Escritor file(File file) {
        this.file = file;
        return this;
    }

    public Escritor os(OutputStream os) {
        this.os = os;
        return this;
    }

    public Escritor writer(OutputStreamWriter writer) {
        this.writer = writer;
        return this;
    }


    
}