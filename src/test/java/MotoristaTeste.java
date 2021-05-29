import Controller.MotoristaController;
import Model.Motorista;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MotoristaTeste {
    MotoristaController motoristaController = new MotoristaController();

    @Test
    public void salvarMotorista() {
        Motorista motorista = new Motorista();
        motorista.setNome("Pedro");
        motorista.setEmail("pedro@hotmail.com");
        motorista.setIdTelefone(1);
        motorista.setIdEndereco(1);
        motorista.setCNH("2146654");
        motorista.setValidadeCHN(2020, 2, 3);
        motorista.setId(1);

        assertTrue(!motoristaController.salvarMotorista(motorista));
 }
}
