package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe de Principal.
 */
public class Principal {
  /** funçao principal. */
  public static void main(String[] args) {
    System.out.println("----------- Bem-vindo ao Sistema de Votação -----------");
    Scanner scan = new Scanner(System.in);
    short opcao;
    String nome;
    int numero;
    String cpf;
    GerenciamentoVotacao gv1 = new GerenciamentoVotacao();

    do {
      System.out.println("Cadastrar pessoa candidata?\n" + "1 - Sim\n" + "2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      opcao = scan.nextShort();
      if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa candidata: ");
        nome = scan.next();
        System.out.println("Entre com o número da pessoa candidata: ");
        numero = scan.nextInt();
        gv1.cadastrarPessoaCandidata(nome, numero);
      }
    } while (opcao != 2);
    System.out.println("----------- Cadastre as pessoas eleitoras -----------");
    do {
      System.out.println("Cadastrar pessoa eleitora?\n" + "1 - Sim\n" + "2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      opcao = scan.nextShort();
      if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa eleitora: ");
        nome = scan.next();
        System.out.println("Entre com o cpf da pessoa eleitora: ");
        cpf = scan.next();
        gv1.cadastrarPessoaEleitora(nome, cpf);
      }
    } while (opcao != 2);

    System.out.println("----------- Votação iniciada! -----------");
    do {
      System.out.println("Entre com o número correspondente à opção desejada:\n" + "1 - Votar\n"
          + "2 - Resultado Parcial\n" + "3 - Finalizar Votação");
      System.out.println("Entre com o número correspondente à opção desejada: ");
      opcao = scan.nextShort();
      if (opcao == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora: ");
        cpf = scan.next();
        System.out.println("Entre com o número da pessoa candidata: ");
        numero = scan.nextInt();
        gv1.votar(cpf, numero);
      }
      if (opcao == 2) {
        gv1.mostrarResultado();
      }
    } while (opcao != 3);

    gv1.mostrarResultado();
    scan.close();
  }
}
