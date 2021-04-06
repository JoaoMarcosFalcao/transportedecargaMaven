import Controller.*;
import Model.Veiculo;

public class Principal {

    public static void main (String []args){

        CargaNegocioController cargaNegocioController = new CargaNegocioController();
        ClienteController clienteController = new ClienteController();
        EnderecoController enderecoController = new EnderecoController();
        MotoristaController motoristaController = new MotoristaController();
        RotaNegocioController rotaNegocioController = new RotaNegocioController();
        TelefoneController telefoneController = new TelefoneController();
        VeiculoController veiculoController = new VeiculoController();
        ViagemNegocioController viagemNegocioController = new ViagemNegocioController();


    }
}
