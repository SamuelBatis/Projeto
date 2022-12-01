package entities;

public class Paciente {
    private String nomeCompleto;

    private Integer id;
    private String sexo;
    private String endereco;
    private Efermidade efermidade;
    private String entrada;
    private String medico;
    private Integer Posto;
    private Telefone telefone;
    private String idade;
    private Cidade cidade;

    private Estado estado;

    private String email;

    private String rg;

    private String registroTecnico;

    private Integer profissao;

    private Medicamentos medicamentos;

    private String adm;

    private String cpf;



    public Medicamentos getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Medicamentos medicamentos) {
        this.medicamentos = medicamentos;
    }


    public Integer getPosto() {
        return Posto;
    }

    public void setPosto(Integer posto) {
        Posto = posto;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getProfissao() {
        return profissao;
    }

    public void setProfissao(Integer profissao) {
        this.profissao = profissao;
    }

    public String getAdm() {
        return adm;
    }

    public void setAdm(String adm) {
        this.adm = adm;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    public String getRegistroTecnico() {
        return registroTecnico;
    }
    public void setRegistroTecnico(String registroTecnico) {
        this.registroTecnico = registroTecnico;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Efermidade getEfermidade() {
        return efermidade;
    }

    public void setEfermidade(Efermidade efermidade) {
        this.efermidade = efermidade;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }
}
