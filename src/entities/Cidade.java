package entities;

public class Cidade {
    private Integer idCidade;
    private Estado estado_idEstado;
    private String nome;

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public Estado getEstado_idEstado() {
        return estado_idEstado;
    }

    public void setEstado_idEstado(Estado estado_idEstado) {
        this.estado_idEstado = estado_idEstado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
