
import Controller.TelefoneController;
import Model.Telefone;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TelefoneTeste {
    TelefoneController telefoneController = new TelefoneController();
    ArrayList<Telefone> telefoneTeste = telefoneController.listarTelefonesDosClientes();
    @Test
    public void listarTelefoneDosClientes () {
        ArrayList<Telefone> telefones = telefoneController.listarTelefonesDosClientes();
        assertFalse(telefones.isEmpty());
        assertEquals(telefones.size(), telefoneTeste.size());
        assertEquals(telefoneTeste.get(0).getNumero(), telefoneTeste.get(0).getNumero());

        Telefone telefone = new Telefone();
        telefone.setNumero("32323232");
        assertEquals(telefone.getNumero(), telefoneController.listarTelefonesDosClientes().get(0).getNumero());
    }
}

