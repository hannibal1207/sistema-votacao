package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/**
 * Classe GerenciamentoVoto.
 */
public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos = 0;

  private static int existeNumeroPessoaCandidata(ArrayList<PessoaCandidata> pessoas, int numero) {
    for (int i = 0; i < pessoas.size(); i++) {
      if (pessoas.get(i).getNumero() == numero) {
        return i;
      }
    }
    return -1;
  }

  private static int existeCpfComputado(ArrayList<String> pessoas, String cpf) {
    for (int i = 0; i < pessoas.size(); i++) {
      if (pessoas.get(i).equals(cpf)) {
        return i;
      }
    }
    return -1;
  }

  // http://www.softblue.com.br/blog/java-strings-nao-use-operador-de-igualdade/
  private boolean existeCpfPessoaEleitora(ArrayList<PessoaEleitora> pessoas, String cpf) {
    for (int i = 0; i < pessoas.size(); i++) {
      if (pessoas.get(i).getCpf().equals(cpf)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Método para cadastrar pessoa candidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    if (existeNumeroPessoaCandidata(pessoasCandidatas, numero) != -1) {
      System.out.println("utilizado");
    } else {
      pessoasCandidatas.add(new PessoaCandidata(nome, numero));
    }
  }

  /**
   * Método para cadastrar pessoa candidata.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    if (existeCpfPessoaEleitora(pessoasEleitoras, cpf) == true) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      pessoasEleitoras.add(new PessoaEleitora(nome, cpf));
    }
  }

  /**
   * Método para votar em uma pessoa candidata.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (existeCpfComputado(cpfComputado, cpfPessoaEleitora) != -1) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      int candidato = existeNumeroPessoaCandidata(pessoasCandidatas, numeroPessoaCandidata);
      pessoasCandidatas.get(candidato).receberVoto();
      cpfComputado.add(cpfPessoaEleitora);
      this.totalVotos += 1;
    }
  }

  /**
   * Método para mostrar o resultado da eleição.
   */
  public void mostrarResultado() {
    if (this.totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    }
    for (int i = 0; i < this.pessoasCandidatas.size(); i++) {
      System.out.println("Nome: " + this.pessoasCandidatas.get(i).getNome() + " - "
          + this.pessoasCandidatas.get(i).getVotos() + " votos ( " + calcularPorcentagemVotos(i)
          + "% )");
    }
    System.out.println("Total de votos: " + this.totalVotos);
  }

  private float calcularPorcentagemVotos(int indice) {
    float porcetagemVotos = pessoasCandidatas.get(indice).getVotos() * 100f / this.totalVotos;
    return Math.round(porcetagemVotos);
  }
}
