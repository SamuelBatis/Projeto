package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Funcionario {
  private Integer idFuncionario;
  private String nomeCompleto;

  private String idade;

  public String getIdade() {
    return idade;
  }

  public void setIdade(String idade) {
    this.idade = idade;
  }

  private String endereco;

  private String cpf;
  private String Rg;
  private String telefones;
  private String email;

  private String userPassword;
  private String especilidade;
  private String registroTecnico;
  private String carteiraDeTrabalho;

  private String funcao;

  private Posto posto;

  private Cidade cidade;

  private Estado Estado;

  private Profissao profissao;


  private String adm;

  public String getAdm() {
    return adm;
  }

  public void setAdm(String adm) {
    this.adm = adm;
  }

  public Cidade getCidade() {
    return cidade;
  }

  public void setCidade(Cidade cidade) {
    this.cidade = cidade;
  }

  public entities.Estado getEstado() {
    return Estado;
  }

  public void setEstado(entities.Estado estado) {
    Estado = estado;
  }

  public Profissao getProfissao() {
    return profissao;
  }

  public void setProfissao(Profissao profissao) {
    this.profissao = profissao;
  }

  public Posto getPosto() {
    return posto;
  }

  public void setPosto(Posto posto) {
    this.posto = posto;
  }

  public String getFuncao() {
    return funcao;
  }

  public void setFuncao(String funcao) {
    this.funcao = funcao;
  }


  public  Funcionario() {}

  public Funcionario(String nomeCompleto, String cpf, String rg, String telefones, String email, String especilidade, String conselhoDeClasse, String carteiraDeTrabalho) {
    this.nomeCompleto = nomeCompleto;
    this.cpf = cpf;
    Rg = rg;
    this.telefones = telefones;
    this.email = email;
    this.especilidade = especilidade;
    this.registroTecnico = conselhoDeClasse;
    this.carteiraDeTrabalho = carteiraDeTrabalho;
  }


  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public Integer getIdFuncionario() {
    return idFuncionario;
  }

  public void setIdFuncionario(Integer idFuncionario) {
    this.idFuncionario = idFuncionario;
  }

  public String getNomeCompleto() {
    return nomeCompleto;
  }

  public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getRg() {
    return Rg;
  }

  public void setRg(String rg) {
    Rg = rg;
  }

  public String getTelefones() {
    return telefones;
  }

  public void setTelefones(String telefones) {
    this.telefones = telefones;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEspecilidade() {
    return especilidade;
  }

  public void setEspecilidade(String especilidade) {
    this.especilidade = especilidade;
  }

  public String getRegistroTecnico() {
    return registroTecnico;
  }

  public void setRegistroTecnico(String registroTecnico) {
    this.registroTecnico = registroTecnico;
  }

  public String getCarteiraDeTrabalho() {
    return carteiraDeTrabalho;
  }

  public void setCarteiraDeTrabalho(String carteiraDeTrabalho) {
    this.carteiraDeTrabalho = carteiraDeTrabalho;
  }
}
