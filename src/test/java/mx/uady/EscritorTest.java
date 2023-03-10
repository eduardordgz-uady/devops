package mx.uady;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

import org.mockito.Mockito;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class EscritorTest extends TestCase {

    public EscritorTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(EscritorTest.class);
    }

    public void test_escribir() throws IOException {

        Escritor escritor = new Escritor();

        File file = mock(File.class);
        OutputStream os = mock(OutputStream.class);
        OutputStreamWriter writer = mock(OutputStreamWriter.class);

        escritor.setFile(file);
        escritor.setOs(os);
        escritor.setWriter(writer);

        List<String> palabras = new LinkedList<>();
        palabras.add("hola");
        palabras.add("alumnos");

        escritor.escribir(palabras);

        verify(writer, times(4)).append(Mockito.anyString());
        verify(writer, times(2)).flush();

        verify(writer, times(1)).close();

    }
    
}
