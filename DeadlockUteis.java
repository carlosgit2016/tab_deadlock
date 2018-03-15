import java.util.*;
/**
 * Write a description of class DeadlockUteis here.
 *
 * @author José Lucas Panizio & Carlos Gabriel
 * @version 16/09/2017
 */
public class DeadlockUteis{   
    /**
     * Verifica duplicidade elementos na lista.
     * 
     * @param   LinkedList l   - lista de vertices a ser analisada.  
     * @param   String v       - vertice para comparacao. 
     * @return  boolean        - retorna true se existir duplicidade.
     */
    public static boolean estaDuplicado(LinkedList l,String v){
        int count = 0;
        for(int i = 0; i < l.size() ; i++){
            if(l.get(i).equals(v))count++;
        }
        return count >= 2;
    }

    /**
     * Seleciona o vertice que não esta contido na lista de arestas marcadas.
     * 
     * @param   GrafoDeadlock gd   -  representacao de grafo.
     * @param   LinkedList aM      -  lista de arestas marcadas.
     * @param   String v           -  vertice para comparacao.
     * @return  String             -  vertice não marcado.
     */
    public static String escolheVertice(GrafoDeadlock gd , LinkedList aM , String v){
        if(gd.listarDestinosDe(v).isEmpty()) return null;
        LinkedList<String> vertices = new LinkedList(gd.listarDestinosDe(v));

        for(int i = 0; i < vertices.size(); i ++){
            if(!aM.contains(vertices.get(i))) return vertices.get(i);
        }
        return null;
    }

    /**
     * Verifica se o vertice especificado é igual ao primeiro da lista analisada.
     * 
     * @param   LinkedList<String> l   -  lista de vertices.    
     * @param   String v               -  vertice a ser comparado.
     * @return  boolean                -  retorna true se o vertice for o 1º da lista.                                    
     */
    public static boolean igualInicial(LinkedList<String> l , String v){
        return l.getFirst() == v;
    }

    /**
     * Verifica se existe condição ciclica, ou seja, deadlock a partir de um dado vertice.
     * 
     * @param   LinkedList<String> l   -  lista de vertices.
     * @param   LinkedList<String> aM  -  lista de arestas marcadas.
     * @param   String v               -  vertice inicial.
     * @return  boolean                -  retorna true se existir condicao ciclica a partir do vertice especificado.
     */
    public static boolean verificaCiclica(GrafoDeadlock gd,LinkedList<String> l, LinkedList aM, String v){
        if(l.isEmpty() || v != l.getLast()) l.add(v);
        if(estaDuplicado(l,v))return true;
        else{            
            String vSaida = escolheVertice(gd,aM,v);
            if(vSaida != null){
                aM.add(vSaida);
                return verificaCiclica(gd,l,aM,vSaida);
            }else{
                if(igualInicial(l,v)) return false;
                else{
                    l.remove(v);
                    verificaCiclica(gd,l,aM,l.getLast());
                }
            }
        }

        return false;
    }

    /**
     * Analisa todos os vertices da lista, em busca de deadlock.
     * 
     * @param   GrafoDeadlock gd       -  representacao de grafo.     
     * @return  boolean                -  retorna true se existir deadlock no cenario.
     */
    public static boolean verificaDeadLock(GrafoDeadlock gd){
        LinkedList<String> allVertices = new LinkedList(gd.listarVertices());

        for(int i = 0; i < allVertices.size() ; i++){
            LinkedList<String> l = new LinkedList();
            LinkedList<String> aM = new LinkedList();

            if(verificaCiclica(gd,l,aM,allVertices.get(i))) return true;
        }

        return false;
    }

    /**
     * Essa classe apenas oferece métodos auxiliares, não deve nunca precisar
     * instanciar objetos.
     */
    private DeadlockUteis() {}
}
