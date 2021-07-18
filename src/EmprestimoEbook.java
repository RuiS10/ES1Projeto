
import java.time.LocalDate;

public class EmprestimoEbook {
    LocalDate datainicio;
    LocalDate datafim;
    Ebook ebook;
    Utilizador utilizador;
    Integer NumeroDeProlongamentos;
    Boolean Assinado;
    TermoDeReponsabilidade termos;

    public EmprestimoEbook(LocalDate datainicio, Ebook ebook, Utilizador utilizador, Boolean assinado, TermoDeReponsabilidade termos) {
        this.datainicio = datainicio;
        this.datafim = datainicio.plusDays(ebook.getNumerodediasdoemprestimo());
        this.ebook = ebook;
        this.utilizador = utilizador;
        NumeroDeProlongamentos = 0;
        Assinado = assinado;
        this.termos = termos;
    }

    public LocalDate getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(LocalDate datainicio) {
        this.datainicio = datainicio;
    }

    public LocalDate getDatafim() {
        return datafim;
    }

    public void setDatafim(LocalDate datafim) {
        this.datafim = datafim;
    }



    public Ebook getEbook() {
        return ebook;
    }

    public void setEbook(Ebook ebook) {
        this.ebook = ebook;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public Integer getNumeroDeProlongamentos() {
        return NumeroDeProlongamentos;
    }

    public void setNumeroDeProlongamentos(Integer numeroDeProlongamentos) {
        NumeroDeProlongamentos = numeroDeProlongamentos;
    }

    public Boolean getAssinado() {
        return Assinado;
    }

    public void setAssinado(Boolean assinado) {
        Assinado = assinado;
    }




    public TermoDeReponsabilidade getTermos() {
        return termos;
    }

    public void setTermos(TermoDeReponsabilidade termos) {
        this.termos = termos;
    }
}