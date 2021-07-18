public class Editora {
    String Nome;
    TermoDeReponsabilidade termos;

    public Editora(String nome, TermoDeReponsabilidade termos) {
        Nome = nome;
        this.termos = termos;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public TermoDeReponsabilidade getTermos() {
        return termos;
    }

    public void setTermos(TermoDeReponsabilidade termos) {
        this.termos = termos;
    }
}
