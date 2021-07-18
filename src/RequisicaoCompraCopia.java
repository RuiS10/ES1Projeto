import java.time.LocalDate;

public class RequisicaoCompraCopia extends RequisicaoCompra {
    public RequisicaoCompraCopia(String estado, LocalDate data, String oficio) {
        super(estado, data, oficio);
    }
}
