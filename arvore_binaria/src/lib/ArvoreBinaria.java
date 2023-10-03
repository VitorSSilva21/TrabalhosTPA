/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lib;

import lib.IArvoreBinaria;
import java.util.ArrayList;
import java.util.Comparator;
import java.lang.Math;

/**
 *
 * @author lorhan.souza
 */

public class ArvoreBinaria<T> implements IArvoreBinaria<T>{
	
	protected Comparator<T> comparador; 
    protected No<T> raiz = null;
    protected No<T> atual = null;
    private ArrayList<No<T>> pilhaDeNavegacao = null;
    
    
    /**
     * Construtor que recebe o objeto para criterio de comparação e o armazena como o comparador (referencia)
     * @param comp - será utilizado para passar o criterio de comparação que será utilizado. Por exemplo: CPF, Nome, Matrícula, ID.
     */
    public ArvoreBinaria(Comparator<T> comp) {
        this.comparador = comp;
    }
    
//ADICIONAR
    private No<T> _adicionar(No<T> raiz, No<T> novo){
        if (raiz == null) {
            return novo;
        }
        else{
            if (comparador.compare(novo.getChave(), raiz.getChave()) < 0){
               raiz.setFilho_esquerda(_adicionar(raiz.getFilho_esquerda(),novo));
              
            } 
            else {
            	raiz.setFilho_direita(_adicionar(raiz.getFilho_direita(),novo));
            }
            return raiz;
        }
        
    }

    @Override
    public void adicionar(T novoValor) {
    	No<T> novo = new No<T>(novoValor);
    	this.raiz =  _adicionar(this.raiz, novo);
        return;
    }

//PESQUISAR
    private T _pesquisar(T valor){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public T pesquisar(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
//REMOVER
    private T _remover(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
    @Override
    public T remover(T valor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

//ALTURA    
    @Override
    public int altura() {
        return (int) Math.floor( (Math.log(this.quantidadeNos()) / Math.log(2)));
    }

//QUANTIDADE NOS
    private int _quantidadeNos(No<T> no){
        if(no == null){
            return 0;
        }
        else {
            return 1 + _quantidadeNos(no.getFilho_esquerda()) + _quantidadeNos(no.getFilho_direita());
        }
    }

    @Override
    public int quantidadeNos() {
        return _quantidadeNos(this.raiz);
    }

//CAMINHAR EM NIVEL
    @Override
    public String caminharEmNivel() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

//CAMINHAR EM ORDEM
    private String caminharEmOrdem(No<T> r, String resposta){
        if(r!=null){
            if(r.getFilho_esquerda() != null){
                resposta+=r.getFilho_esquerda().getChave().toString() + "/n";;
                caminharEmOrdem(r.getFilho_esquerda(), resposta);
            }
            resposta+=r.getChave() + "/n";

            resposta+=r.getFilho_direita().getChave().toString() + "/n";;
            caminharEmOrdem(r.getFilho_esquerda(), resposta);
        }
        return resposta;
    }
    
    @Override
    public String caminharEmOrdem() {
        String resposta = null;
        return caminharEmOrdem(this.raiz, resposta);
    }
    
//OBTER PROXIMO
    @Override
    public T obterProximo(){
        throw new UnsupportedOperationException("Not supported yet."); 
    }
//REINICAR NAVEGACAO
    @Override
    public void reiniciarNavegacao(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

//METODOS PARA A PILHA
    
//GETTERS E SETTERS
    public No<T> getRaiz(){
    	return this.raiz;
    }
}
