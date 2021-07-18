public class WebAppDriver implements WebAppInterface {

    private static WebAppDriver instance = null;

    // Singleton
    private WebAppDriver() {}

    public static WebAppDriver instance() {
        if(instance == null)
            instance = new WebAppDriver();

        return instance;
    }

    @Override
    public String getViewer(Servidor servidor, Ebook ebook) {
        return "https://" + servidor.getLocalizacao() + "/" + ebook.getLivro().getTitulo() + "." + ebook.getFormato();
    }

    @Override
    public String downloadEbook(Servidor servidor, Ebook ebook) {
        return "https://" + servidor.getLocalizacao() + "/" + ebook.getLivro().getTitulo() + "." + ebook.getFormato();
    }
}