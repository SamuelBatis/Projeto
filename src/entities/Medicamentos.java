package entities;

public class Medicamentos {
    private Integer medicamentosId;
    private String nome;
    private String marca;

    public Integer getMedicamentosId() {
        return medicamentosId;
    }

    public void setMedicamentosId(Integer medicamentosId) {
        this.medicamentosId = medicamentosId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
