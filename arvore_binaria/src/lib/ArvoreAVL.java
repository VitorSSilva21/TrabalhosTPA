package lib;

import java.util.Comparator;
import src.lib.ArvoreBinaria;

public class ArvoreAVL <T> extends ArvoreBinaria<T>{

    public ArvoreAVL(Comparator<T> comparator) {
        super(comparator);
    }

    /**
     *
     * @param No raiz da subarvore com elemento do tipo T armazenado.
     * @return No<T> com a rotação feita no trecho da árvore concluída
     */
    private No<T> rotacaoEsquerda(No<T> raiz){
        No<T> rotacionado = raiz.getFilhoDireita();
        raiz.setFilhoDireita(rotacionado.getFilhoEsquerda());
        rotacionado.setFilhoEsquerda(raiz);

        return rotacionado;
    }
    
    //Implementar métodos para efetuar o balanceamento e sobrescrever método de adicionar elemento...

}
