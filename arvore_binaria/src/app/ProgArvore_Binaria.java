package app;

import lib.ArvoreBinaria;
import app.ComparadorAlunoPorMatricula;
import app.Aluno;

public class ProgArvore_Binaria {

    public static void main(String[] args) {
    	GeradorDeArvores gerador = new GeradorDeArvores();
    	ComparadorAlunoPorMatricula comp = new ComparadorAlunoPorMatricula();
        ArvoreBinaria<Aluno> arvore = new ArvoreBinaria<Aluno>(comp);
        ArvoreBinaria<Aluno> arvore2 = new ArvoreBinaria<Aluno>(comp);
        gerador.geraArvoreDegenerada(100, arvore);
        gerador.geraArvorePerfeitamenteBalanceada(0, 100, arvore2);
        System.out.println(arvore.quantidadeNos()+"\n");
        System.out.println(arvore.altura()+"\n");
        System.out.println(arvore.caminharEmOrdem()+"\n");
        System.out.println(arvore.obterProximo()+"\n");
        System.out.println(arvore2.caminharEmNivel()+"\n");
        Aluno teste = new Aluno(2000000010,"joaozinho pereira");
        System.out.println(arvore2.pesquisar(teste)+"\n");
    }
}
