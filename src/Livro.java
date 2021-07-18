public class Livro {
    String titulo;
    Editora editora;

    public Livro(String titulo, Editora editora) {
        this.titulo = titulo;
        this.editora = editora;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Editora getEditora() {
        return this.editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
}