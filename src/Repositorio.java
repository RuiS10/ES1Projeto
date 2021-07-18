
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Repositorio {
    ArrayList<Ebook> ListaEbook = new ArrayList();
    ArrayList<Editora> ListEditora= new ArrayList();
    ArrayList<Servidor> ListaServidor = new ArrayList();
    ArrayList<TermoDeReponsabilidade> ListaTermoDeReponsabilidade = new ArrayList();
    ArrayList<Utilizador> ListaUtilizadores = new ArrayList();
    ArrayList<Livro> ListaLivro = new ArrayList();
    ArrayList<EmprestimoEbook> ListaEmprestimoEbook = new ArrayList();
    ArrayList<Emprestimo> ListaEmprestimo = new ArrayList();
     ArrayList<Coima> ListaCoima = new ArrayList<>();
     ArrayList<Copia> ListaCopia = new ArrayList<>();
     ArrayList<Devolucao> ListaDevolucao = new ArrayList<>();
     ArrayList<Encomenda> ListaEncomenda = new ArrayList<>();
     ArrayList<EntradaNovoLivro> ListaEntradaNovoLivro= new ArrayList<>();
     ArrayList<Notificacao> ListaNotificacao = new ArrayList<>();
     ArrayList<PropostaAquisicao> ListaPropostaAquisicao = new ArrayList<>();
     ArrayList<Requisicao> ListaRequisicao = new ArrayList<>();
     ArrayList<RequisicaoCompra> ListaRequisicaoCompra = new ArrayList<>();
     ArrayList<RequisicaoCompraCopia> ListaRequisicaoCompraCopia= new ArrayList<>();
     ArrayList<RequisicaoCompraLivro> ListaRequisicaoCompraLivro = new ArrayList<>();
     ArrayList<TipoUtilizador> ListaTipoUtilizador = new ArrayList<>();


    public Repositorio() {
    }




    public void adicionaCoima(Coima coima) {
        this.ListaCoima.add(coima);
    }

    public void adicionaCopia(Copia copia) {
        this.ListaCopia.add(copia);
    }

    public void adicionaDevolucao(Devolucao devolucao) {
        this.ListaDevolucao.add(devolucao);
    }

    public void adicionaEditora(Editora editora) {this.ListEditora.add(editora);}

    public void adicionaEmprestimo(Emprestimo emprestimo) {
        this.ListaEmprestimo.add(emprestimo);
    }

    public void adicionaEncomenda(Encomenda encomenda) {
        this.ListaEncomenda.add(encomenda);
    }

    public void adicionaEntradaNovoLivro(EntradaNovoLivro entradanovolivro) {
        this.ListaEntradaNovoLivro.add(entradanovolivro);
    }

    public void adicionaLivro(Livro livro) {
        this.ListaLivro.add(livro);
    }

    public void adicionaNotificacao(Notificacao notificacao) {
        this.ListaNotificacao.add(notificacao);
    }

    public void adicionaPropostaRequisicao(PropostaAquisicao proposta) {
        this.ListaPropostaAquisicao.add(proposta);
    }

    public void adicionaRequisicao(Requisicao requisicao) {
        this.ListaRequisicao.add(requisicao);
    }

    public void adicionaRequisicaoCompra(RequisicaoCompra requisicaocompra) {
        this.ListaRequisicaoCompra.add(requisicaocompra);
    }

    public void adicionaRequisicaoCompraCopia(RequisicaoCompraCopia requisicaocompraCopia) {
        this.ListaRequisicaoCompraCopia.add(requisicaocompraCopia);
    }

    public void adicionaRequisicaoCompraLivro(RequisicaoCompraLivro requisicaocompraLivro) {
        this.ListaRequisicaoCompraLivro.add(requisicaocompraLivro);
    }

    public void adicionaTipoUtilizador(TipoUtilizador tipo) {
        this.ListaTipoUtilizador.add(tipo);
    }

    public void adicionaUtilizador(Utilizador utilizador) {
        this.ListaUtilizadores.add(utilizador);
    }

    public void adicionaEbook(Ebook ebook) {
        this.ListaEbook.add(ebook);
    }

    public void adicionaEmprestimoEbook(EmprestimoEbook emprestimoEbook) {
        this.ListaEmprestimoEbook.add(emprestimoEbook);
    }

    public void adicionaServidor(Servidor servidor) {
        this.ListaServidor.add(servidor);
    }

    public void adicionaTermoResponsabilidade(TermoDeReponsabilidade termoResponsabilidade) {
        this.ListaTermoDeReponsabilidade.add(termoResponsabilidade);
    }

    public Emprestimo devolveEmprestimoDaRequisicao(Requisicao r) {
        Emprestimo emprestimo;
        Iterator<Emprestimo> var2 = this.ListaEmprestimo.iterator();
        do {
            if (!var2.hasNext())
                return null;
            emprestimo = var2.next();
        } while (!emprestimo.getRequisicao().equals(r));
        return emprestimo;
    }

    public boolean Verificarconta(Utilizador utilizador){
        String estado= utilizador.getEstado();
        return estado.equals("Ativo");
    }

    public  int Verificardata(EmprestimoEbook emprestimo){
        LocalDate datafim = emprestimo.getDatafim();
        LocalDate datanow = LocalDate.now();
        int result = datafim.compareTo(datanow);
        if (result > 0){
            return 1;
        }
        return 0;
    }

    public void ProlongarEmprestimo(EmprestimoEbook emprestimo){
        if (Verificarconta(emprestimo.getUtilizador())) {
            if (Verificardata(emprestimo) == 1) {
                if (emprestimo.getNumeroDeProlongamentos() < 3) {
                    emprestimo.setDatafim(emprestimo.getDatafim().plusDays(emprestimo.getEbook().getNumerodediasdoemprestimo())); //add days
                    emprestimo.setNumeroDeProlongamentos(emprestimo.getNumeroDeProlongamentos() + 1);
                    System.out.println("emprestimo prolongado");

                }
                System.out.println("numero de prolongamentos excedidos");
            }
            System.out.println("Emprestimo fora de prazo");
        }
        System.out.println("Conta cancelada");
    }

    public  String requestVisualizarEbook( WebAppInterface wa, EmprestimoEbook emprestimo) throws Exception {
        if(emprestimo.getUtilizador().getEstado().equals("Cancelado"))
        {

        if (Verificardata(emprestimo) == 1) {

            wa.downloadEbook(EscolherServidor( emprestimo.getUtilizador().getLocalizacao(),emprestimo),emprestimo.getEbook());
        }
            System.out.println("Emprestimo fora de prazo");
        }
        System.out.println("Conta cancelada");
        return null;

    }

    public void DownloadLivro(WebAppInterface wa,EmprestimoEbook emprestimo) throws Exception {
        wa.downloadEbook(EscolherServidor( emprestimo.getUtilizador().getLocalizacao(),emprestimo),emprestimo.getEbook());

        emprestimo.getUtilizador().setEstado("Conta Cancelada");

    }

    public Ebook DevolverEbook (Livro livro)
    {
        int i;
        Ebook e;
        for(i=0;i<ListaEbook.size();i++){
            e=ListaEbook.get(i);
            if (livro.equals(e.getLivro()) ) {
                return e;
            }

        }
        return null;
    }


    public boolean PedirEmprestimo(Livro livro, Utilizador utilizador) throws IOException {
        if (Verificarconta(utilizador)) {

            TermoDeReponsabilidade termos = AssinarTermos(livro);
            if(termos!=null) {
                Ebook book = DevolverEbook(livro);
                EmprestimoEbook emprestimo = new EmprestimoEbook(LocalDate.now() , book, utilizador, Boolean.TRUE, termos);
                ListaEmprestimoEbook.add(emprestimo);
                return true;
            }
            System.out.println("Asinatura invalida");
        }
        else
            System.out.println("Conta cancelada");
        return false;
    }

    public  Servidor EscolherServidor( int localizacao, EmprestimoEbook emprestimo) throws Exception {

        // Check if servidor contains ebook
        int i;
        ArrayList<Servidor> replicas = new ArrayList<>();
        for(i=0;i<ListaServidor.size();i++) {
            Servidor servidor = ListaServidor.get(i);
            if (servidor.getEbooks().contains(emprestimo.getEbook()))
                replicas.add(servidor);
        }
        return getClosestServer(replicas, localizacao);
    }



    public TermoDeReponsabilidade AssinarTermos(Livro livro) throws IOException {
        Editora editora = livro.getEditora();
        TermoDeReponsabilidade termos = editora.getTermos();
        System.out.println("Aceita os termos de responsabilidade?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String resp = br.readLine();
        if (resp.equals("Sim")) {

            return termos;
        }
        return null;
    }

    public static Servidor getClosestServer(ArrayList<Servidor> replicas, int localizacaoUser) throws Exception {

        if(replicas.isEmpty())
            throw new Exception("Sem servidores");

        int distancia = Math.abs(replicas.get(0).getLocalizacao() - localizacaoUser);
        int indx = 0;

        for (int i = 1; i < replicas.size(); i++) {
            int idistancia = Math.abs(replicas.get(i).getLocalizacao() - localizacaoUser);
            if (idistancia < distancia) {
                distancia = idistancia;
                indx = i;
            }
        }

        return replicas.get(indx);
    }



}
