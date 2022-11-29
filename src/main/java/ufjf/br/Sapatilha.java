package ufjf.br;
import java.util.Arrays;
import java.util.List;

public class Sapatilha implements ISapatilha{

    private Integer codigo;
    private String modelo;
    private String marca;
    private Float valor;


    public Sapatilha(int codigo) {
        this.codigo = codigo;
        Sapatilha objeto = DataBase.getSapatilha(codigo);
        this.modelo = objeto.modelo;
        this.marca = objeto.marca;
        this.valor = objeto.valor;

    }

    public Sapatilha(Integer codigo, String modelo, String marca, Float valor ) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.marca = marca;
        this.valor = valor;

    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public List<String> receberDadosSapatilha() {
        return Arrays.asList(this.modelo, this.marca);
    }

    @Override
    public List<Float> receberValor(Vendedor vendedor) {
        return Arrays.asList(this.valor);
    }
}
