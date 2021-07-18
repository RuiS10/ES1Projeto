import java.io.IOException;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException {
        Repositorio r = new Repositorio();
        Utilizador u = new Utilizador("manuel","Viseu","Manuel@gmail.com","Abcd1234");
        r.adicionaUtilizador(u);
        Utilizador u2 = r.ListaUtilizadores.get(0);
        System.out.println("entrega validada"+u2.getEstado());

        TermoDeReponsabilidade t = new TermoDeReponsabilidade("brrrrrrrrrr");
        Editora e = new Editora("brrr",t);
        Livro l = new Livro("omg",e);
        r.AssinarTermos(l);
    }
}
