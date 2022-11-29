package ufjf.br;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class SapatilhaProxyTest {

    @BeforeEach
    void setUp() {
        DataBase.addSapatilha(new Sapatilha(001, "Toshie", "So Danca", 300.0f));
        DataBase.addSapatilha(new Sapatilha(002, "Elegance", "Bloch", 690.0f));
    }

    @Test
    void retornaDadosSapatilha() {
        SapatilhaProxy sapatilha = new SapatilhaProxy(001);

        assertEquals(Arrays.asList("Toshie", "So Danca"), sapatilha.receberDadosSapatilha());
    }

    @Test
    void retornaValorSapatilha() {
        Vendedor vendedor = new Vendedor("Miranda", true);
        SapatilhaProxy sapatilha = new SapatilhaProxy(002);

        assertEquals(Arrays.asList(690.0f), sapatilha.receberValor(vendedor));
    }

    @Test
    void retornaUserNaoAutorizado() {
        try {
            Vendedor vendedor  = new Vendedor("Luna", false);
            SapatilhaProxy sapatilha = new SapatilhaProxy(002);

            sapatilha.receberValor(vendedor);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Vendedor não autorizado", e.getMessage());
        }
    }

}