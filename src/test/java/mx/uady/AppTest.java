package mx.uady;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.FileNotFoundException;

import org.mockito.Mockito;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {

    public AppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

/*     public void testExample() {
        assertTrue(true);
    } */

    public void test_deberiaEjecutarEscribir() throws FileNotFoundException {

        Escritor escritor = mock(Escritor.class);

        doNothing().when(escritor).escribir(Mockito.anyList());

        String[] args = {"hola", "como", "estas"};
        App.setEscritor(escritor);

        App.main(args);

        verify(escritor, times(1)).escribir(Mockito.anyList());

    }
    
}
