package app;

import lib.ArvoreBinaria;
import app.ComparadorAlunoPorMatricula;
import app.Aluno;
import lib.ArvoreAVL;

public class ProgArvore_Binaria {

    public static void main(String[] args) {
    	GeradorDeArvores gerador = new GeradorDeArvores();
    	ComparadorAlunoPorMatricula comp = new ComparadorAlunoPorMatricula();
        ArvoreAVL<Aluno> arvore = new ArvoreAVL<Aluno>(comp);
        gerador.geraArvoreDegenerada(15, arvore);
        System.out.println(arvore.caminharEmNivel());
    }
}
