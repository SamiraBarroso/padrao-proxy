package ufjf.br;

import java.util.List;

public class SapatilhaProxy implements ISapatilha{
    private Sapatilha sapatilha;

    private Integer codigo;

    public SapatilhaProxy(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public List<String> receberDadosSapatilha() {
        if (this.sapatilha == null) {
            this.sapatilha = new Sapatilha(this.codigo);
        }
        return this.sapatilha.receberDadosSapatilha();
    }

    @Override
    public List<Float> receberValor(Vendedor vendedor) {
        if (!vendedor.isAdministrador()) {
            throw new IllegalArgumentException("Vendedor não autorizado");
        }
        if (this.sapatilha == null) {
            this.sapatilha = new Sapatilha(this.codigo);
        }
        return this.sapatilha.receberValor(vendedor);
    }
}
