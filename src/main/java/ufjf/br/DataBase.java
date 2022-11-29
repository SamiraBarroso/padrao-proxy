package ufjf.br;
import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private static Map<Integer, Sapatilha> sapatilhas = new HashMap<>();

    public static Sapatilha getSapatilha(Integer codigo) {
        return sapatilhas.get(codigo);
    }

    public static void addSapatilha(Sapatilha sapatilha) {
        sapatilhas.put(sapatilha.getCodigo(), sapatilha);
    }
}
