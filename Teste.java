import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Teste.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Teste{
    @Test
    public void cenario1() {
        GrafoDeadlock gd = new GrafoDeadlock();
        gd.criarVertice("A")
        .criarVertice("B")
        .criarVertice("T")
        .criarVertice("S")
        .criarArestaEntre("T", "A")
        .criarArestaEntre("S", "B")
        .criarArestaEntre("B", "T");
        
        System.out.println(DeadlockUteis.verificaDeadLock(gd));
        assertEquals(false,DeadlockUteis.verificaDeadLock(gd));
    }    

    @Test
    public void cenario2() {
        GrafoDeadlock gd = new GrafoDeadlock();
        gd.criarVertice("A")
        .criarVertice("B")
        .criarVertice("C")
        .criarVertice("S")
        .criarVertice("R")
        .criarVertice("T")    
        .criarArestaEntre("R", "A")
        .criarArestaEntre("S", "B")
        .criarArestaEntre("T", "C")
        .criarArestaEntre("A", "S")
        .criarArestaEntre("B", "T")
        .criarArestaEntre("C", "R");
        
        System.out.println(DeadlockUteis.verificaDeadLock(gd));
        assertEquals(true,DeadlockUteis.verificaDeadLock(gd));
    }

    @Test
    public void cenario3() {
        GrafoDeadlock gd = new GrafoDeadlock();
        gd.criarVertice("A")
        .criarVertice("C")
        .criarVertice("R")
        .criarVertice("S")
        .criarVertice("T")
        .criarArestaEntre("T", "C")
        .criarArestaEntre("R", "C");   
        
        System.out.println(DeadlockUteis.verificaDeadLock(gd));
        assertEquals(false,DeadlockUteis.verificaDeadLock(gd));
    }    
    

    @Test
    public void cenario4() {
        GrafoDeadlock gd = new GrafoDeadlock();
        gd.criarVertice("A")
        .criarVertice("V")
        .criarVertice("U")
        .criarVertice("B")
        .criarVertice("C")
        .criarVertice("X")
        .criarVertice("D")
        .criarVertice("E")
        .criarVertice("Z")
        .criarArestaEntre("A", "U")
        .criarArestaEntre("V", "A")
        .criarArestaEntre("B", "V")
        .criarArestaEntre("B", "U")
        .criarArestaEntre("B", "Z")
        .criarArestaEntre("U", "C")
        .criarArestaEntre("X", "D")
        .criarArestaEntre("D", "Z")
        .criarArestaEntre("E", "X")
        .criarArestaEntre("Z", "E");
        
        System.out.println(DeadlockUteis.verificaDeadLock(gd));
        assertEquals(true,DeadlockUteis.verificaDeadLock(gd));
    }    
}
