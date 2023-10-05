package app;

import lib.ArvoreBinaria;
import app.ComparadorAlunoPorMatricula;
import app.Aluno;

public class ProgArvore_Binaria {

    public static void main(String[] args) {
    	GeradorDeArvores gerador = new GeradorDeArvores();
    	ComparadorAlunoPorMatricula comp = new ComparadorAlunoPorMatricula();
        ArvoreBinaria<Aluno> arvore = new ArvoreBinaria<Aluno>(comp);
        gerador.geraArvoreDegenerada(100, arvore);
        System.out.println(arvore.quantidadeNos());
        System.out.println(arvore.altura());
        System.out.println(arvore.caminharEmOrdem());
    }
}
