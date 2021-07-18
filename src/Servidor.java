import java.util.ArrayList;

public class Servidor {

     String address;
     int localizacao;
     ArrayList<Ebook> ebooks;

    public Servidor(String address, int localizacao, ArrayList<Ebook> ebooks) {

        this.address = address;
        this.localizacao = localizacao;
        this.ebooks = ebooks;
    }

    public String getAddress() {
        return address;
    }

    public int getLocalizacao() {
        return localizacao;
    }

    public ArrayList<Ebook> getEbooks() {
        return ebooks;
    }
}
