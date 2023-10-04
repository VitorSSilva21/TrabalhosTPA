/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arvore_binaria.lib;

import com.mycompany.arvore_binaria.app.Aluno;
import java.util.ArrayList;
import java.util.Comparator;


/**
 *
 * @author lorhan.souza
 */

public class ArvoreBinaria<T> implements IArvoreBinaria<T> {
    protected No<T> raiz = null;
    protected Comparator<T> comparador; 

    protected No<T> atual = null;
    private ArrayList<No<T>> pilhaDeNavegacao = null;
    
    /**
     * Construtor que recebe o objeto para criterio de comparação e o armazena como o comparador (referencia)
     * @param comp - será utilizado para passar o criterio de comparação que será utilizado. Por exemplo: CPF, Nome, Matrícula, ID.
     */
    public ArvoreBinaria(Comparator<T> comp) {
        comparador = comp;
    }

    private void adicionar(T novoValor){
        if (this.atual == null){
            this.atual = new No<>(novoValor);
        }
        else {
            if (comparador.compare(novoValor, this.atual.getChave()) < 0) {
                this.atual.getFilho_esquerda();
                adicionar(novoValor);
            } else if (comparador.compare(novoValor, this.atual.getChave()) > 0) {
                this.atual.getFilho_direita();
                adicionar(novoValor);
            }
        }
    }
    @Override
    public void adicionar(T novoValor) {
        this.atual = this.raiz;
        adicionar(novoValor);
    }

    private T pesquisar(T valor){
        this.atual = this.raiz;

        if(comparador.compare(valor, this.atual.getChave()) < 0){
            this.atual.getFilho_esquerda();
            pesquisar(valor);
        }
        else{
            this.atual.getFilho_direita();
            pesquisar(valor);
        }

        return this.atual.getChave();
    }
    @Override
    public T pesquisar(T valor) {
        if(this.raiz != null){
            adicionar(valor);
        }

        return pesquisar(valor);
    }

    @Override
    public T remover(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int altura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int quantidadeNos() {
        this.atual = this.raiz;
        return quantidadeNos(this.atual);
    }

    private int quantidadeNos(No<T> no) {
        if (no == null) {
            return 0;
        } else {
            int esquerda = quantidadeNos(no.getFilho_esquerda());
            int direita = quantidadeNos(no.getFilho_direita());
            return 1 + esquerda + direita;
        }
    }

    @Override
    public String caminharEmNivel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }


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
    

    @Override
    public T obterProximo(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reiniciarNavegacao(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
