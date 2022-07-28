package com.trybe.acc.java.sistemadevotacao;

/**
 * Classe PessoaEleitora.
 */
public class PessoaEleitora extends Pessoa {
  private String cpf;

  public PessoaEleitora(String nome, String cpf) {
    super(nome);
    this.setCpf(cpf);
  }

  public String getCpf() {
    return cpf;

  }

  public void setCpf(String cpf) {
    this.cpf = cpf;

  }


}
