/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package app;

import lib.ArvoreBinaria;
import app.ComparadorAlunoPorMatricula;
import app.Aluno;

/**
 *
 * @author lorhan.souza
 */
public class ProgArvore_Binaria {

    public static void main(String[] args) {
    	GeradorDeArvores gerador = new GeradorDeArvores();
    	ComparadorAlunoPorMatricula comp = new ComparadorAlunoPorMatricula();
        ArvoreBinaria<Aluno> arvore = new ArvoreBinaria<Aluno>(comp);
        gerador.geraArvorePerfeitamenteBalanceada(1, 5, arvore);
        System.out.println(arvore.quantidadeNos());
        System.out.println(arvore.altura());
    }
}
