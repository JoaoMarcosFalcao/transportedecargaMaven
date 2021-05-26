import Controller.*;
import Model.Cliente;
import Model.Veiculo;
import Model.dao.ClienteDao;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Principal {

    ClienteDao clienteDao;


    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

            ClienteController clienteController = new ClienteController();
            CargaNegocioController cargaNegocioController = new CargaNegocioController();
            EnderecoController enderecoController = new EnderecoController();
            MotoristaController motoristaController = new MotoristaController();
            RotaNegocioController rotaNegocioController = new RotaNegocioController();
            TelefoneController telefoneController = new TelefoneController();
            VeiculoController veiculoController = new VeiculoController();
            ViagemController viagemController = new ViagemController();


            int pararPrograma;
            Boolean rodarPrograma = true;

            while (rodarPrograma) {


                System.out.println("Escolha uma categoria:" +
                        "\n 1 para Telefone" +
                        "\n 2 para Endereço" +
                        "\n 3 para Cliente" +
                        "\n 4 para Motorista" +
                        "\n 5 para Carga" +
                        "\n 6 para Rota" +
                        "\n 7 para Veiculo" +
                        "\n 8 para Viagem");
                int escolha = leia.nextInt();

                if (escolha == 5) {
                    //Código da Carga
                    System.out.println("Escolha uma das Opcões:" +
                            "\n 1 para Cadastrar a Carga" +
                            "\n 2 para Editar a Carga" +
                            "\n 3 para Listar as Cargas" +
                            "\n 4 para Deletar a Carga");

                    int cdCarga = leia.nextInt();
                    if (cdCarga == 1) {
                        cargaNegocioController.salvarCarga();
                    } else if (cdCarga == 2) {
                        int cg;
                        System.out.println("Informe o ID da Carga que deseja editar:");
                        cg = leia.nextInt();
                        cargaNegocioController.editarCargas();
                    } else if (cdCarga == 3) {
                        int cg;
                        System.out.println("Informe o ID da Carga que deseja listar:");
                        cg = leia.nextInt();
                        cargaNegocioController.printAll(cargaNegocioController.listarCargas());
                    } else if (cdCarga == 4) {
                        int cg;
                        System.out.println("Informe o ID da Carga que deseja deletar:");
                        cg = leia.nextInt();
                        cargaNegocioController.deletarCarga();
                    }

                } else if (escolha == 3) {
                    //Código do Cliente
                    System.out.println("Escolha uma das Opcões:" +
                            "\n 1 para Cadastrar o Cliente:" +
                            "\n 2 para Editar o Cliente:" +
                            "\n 3 para Listar os Clientes:" +
                            "\n 4 para Deletar o Cliente:");
                    int cdCliente = leia.nextInt();
                    if (cdCliente == 1) {
                        clienteController.salvarCliente();
                    } else if (cdCliente == 2) {
                        int cl;
                        System.out.println("Informe o ID do Cliente que2 deseja editar:");
                        cl = leia.nextInt();
                        clienteController.editarClientes();
                    } else if (cdCliente == 3) {
                        int cl;
                        System.out.println("Informe o ID do Cliente que deseja listar:");
                        cl = leia.nextInt();
                        clienteController.printAll(clienteController.listarClientes());
                    } else if (cdCliente == 4) {
                        int cl;
                        System.out.println("Informe o ID do Cliente que deseja deletar:");
                        cl = leia.nextInt();
                        clienteController.deletarCliente();
                    }
                } else if (escolha == 4) {
                    //Código do Motorista
                    System.out.println("Escolha uma das Opcões:" +
                            "\n 1 para Cadastrar o Motorista:" +
                            "\n 2 para Editar o Motorista:" +
                            "\n 3 para Listar os Motoristas:" +
                            "\n 4 para Deletar o Motorista:");
                    int cdMotorista = leia.nextInt();
                    if (cdMotorista == 1) {
                        motoristaController.salvarMotorista();
                    } else if (cdMotorista == 2) {
                        int mt;
                        System.out.println("Informe o ID do Motorista que deseja editar:");
                        mt = leia.nextInt();
                        motoristaController.editarMotoristas();
                    } else if (cdMotorista == 3) {
                        int mt;
                        System.out.println("Informe o ID do Motorista que deseja listar:");
                        mt = leia.nextInt();
                        motoristaController.printAll(motoristaController.listarMotoristas());
                    } else if (cdMotorista == 4) {
                        int mt;
                        System.out.println("Informe o ID do Motorista que deseja deletar:");
                        mt = leia.nextInt();
                        motoristaController.deletarMotorista();
                    }
                } else if (escolha == 2) {
                    //Código do Endereço
                    System.out.println("Escolha uma das Opcões:" +
                            "\n 1 para Cadastrar o Endereço do Cliente:" +
                            "\n 2 para Editar o Endereço do Cliente:" +
                            "\n 3 para Listar os Endereços do Cliente:" +
                            "\n 4 para Deletar o Endereço do Cliente:" +
                            "\n 5 para Cadastrar o Endereço do Motorista:" +
                            "\n 6 para Editar o Endereço do Motorista:" +
                            "\n 7 para Listar os Endereços do Motorista:" +
                            "\n 8 para Deletar o Endereço do Motorista:");
                    int cdEndereco = leia.nextInt();
                    if (cdEndereco == 1) {
                        enderecoController.preencher();
                    } else if (cdEndereco == 2) {
                        int ed;
                        System.out.println("Informe o ID do Endereço do Cliente que deseja editar:");
                        ed = leia.nextInt();
                        enderecoController.editarEnderecoDoCliente();
                    } else if (cdEndereco == 3) {
                        int ed;
                        System.out.println("Informe o ID do Endereço do Cliente que deseja listar:");
                        ed = leia.nextInt();
                        enderecoController.printAll(enderecoController.listarEnderecosDosClientes());
                   } else if (cdEndereco == 4) {
                        int ed;
                        System.out.println("Informe o ID do Endereço do Cliente que deseja deletar:");
                        ed = leia.nextInt();
                        enderecoController.deletarEnderecoDoCliente();

                    } else if (cdEndereco == 5) {
                            enderecoController.salvarEnderecoDoMotorista();
                    } else if (cdEndereco == 6) {
                            int ed;
                            System.out.println("Informe o ID do Endereço do Motorista que deseja editar:");
                            ed = leia.nextInt();
                            enderecoController.editarEnderecoDoMotorista();
                        } else if (cdEndereco == 7) {
                            int ed;
                            System.out.println("Informe o ID do Endereço do Motorista que deseja listar:");
                            ed = leia.nextInt();
                            enderecoController.printAll(enderecoController.listarEnderecosDosMotoristas());
                        } else if (cdEndereco == 8) {
                            int ed;
                            System.out.println("Informe o ID do Endereço do Motorista que deseja deletar:");
                            ed = leia.nextInt();
                            enderecoController.deletarEnderecoDoCliente();
                    }
                } else if (escolha == 1) {
                    //Código do Telefone
                    System.out.println("Escolha uma das Opcões:" +
                            "\n 1 para Cadastrar o Telefone do Cliente:" +
                            "\n 2 para Editar o Telefone do Cliente:" +
                            "\n 3 para Listar os Telefones dos Clientes:" +
                            "\n 4 para Deletar o Telefone do Cliente:" +
                            "\n 5 para Cadastrar o Telefone do Motorista:" +
                            "\n 6 para Editar o Telefone do Motorista:" +
                            "\n 7 para Listar o5s Telefones dos Motorista:" +
                            "\n 8 para Deletar o Telefone do Motorista:");
                    int cdTelefone = leia.nextInt();
                    if (cdTelefone == 1) {
                        telefoneController.salvarTelefoneDoCliente();
                    } else if (cdTelefone == 2) {
                        int tf;
                        System.out.println("Informe o ID do Telefone do Cliente que deseja editar:");
                        tf = leia.nextInt();
                        telefoneController.editarTelefoneDoCliente();
                    } else if (cdTelefone == 3) {
                        int tf;
                        System.out.println("Informe o ID do Telefone do Cliente que deseja listar:");
                        tf = leia.nextInt();
                        telefoneController.printAll(telefoneController.listarTelefonesDosClientes());
                    } else if (cdTelefone == 4) {
                        int tf;
                        System.out.println("Informe o ID do Telefone do Cliente que deseja deletar:");
                        tf = leia.nextInt();
                        telefoneController.deletarTelefoneDoCliente();

                    }else if (cdTelefone == 5) {
                            telefoneController.salvarTelefoneDoMotorista();

                    } else if (cdTelefone == 6) {
                        int tf;
                        System.out.println("Informe o ID do Telefone do Motorista que deseja editar:");
                        tf = leia.nextInt();
                        telefoneController.editarTelefoneDoMotorista();
                    } else if (cdTelefone == 7) {
                        int tf;
                        System.out.println("Informe o ID do Telefone do Motorista que deseja listar:");
                        tf = leia.nextInt();
                        telefoneController.printAll(telefoneController.listarTelefonesDosMotoristas());
                    } else if (cdTelefone == 8) {
                        int tf;
                        System.out.println("Informe o ID do Telefone do Motorista que deseja deletar:");
                        tf = leia.nextInt();
                        telefoneController.deletarTelefoneDoMotorista();
                    }

                } else if (escolha == 6) {
                    //Código do Rota
                    System.out.println("Escolha uma das Opcões:" +
                            "\n 1 para Cadastrar uma Rota:" +
                            "\n 2 para Editar a Rota:" +
                            "\n 3 para Listar as Rotas:" +
                            "\n 4 para Deletar a Rota:");
                    int cdRota = leia.nextInt();
                    if (cdRota == 1) {
                        rotaNegocioController.salvarRota();
                    } else if (cdRota == 2) {
                        int rt;
                        System.out.println("Informe o ID da Rota que deseja editar:");
                        rt = leia.nextInt();
                        rotaNegocioController.editarRotas();
                    } else if (cdRota == 3) {
                        int rt;
                        System.out.println("Informe o ID da Rota que deseja listar:");
                        rt = leia.nextInt();
                        rotaNegocioController.printAll(rotaNegocioController.listarRotas());
                    } else if (cdRota == 4) {
                        int rt;
                        System.out.println("Informe o ID da Rota que deseja deletar:");
                        rt = leia.nextInt();
                        rotaNegocioController.deletarRota();
                    }
                } else if (escolha == 7) {
                    //Código do Veiculo
                    System.out.println("Escolha uma das Opcões:" +
                            "\n 1 para Cadastrar o Veiculo:" +
                            "\n 2 para Editar o Veiculo:" +
                            "\n 3 para Listar os Veiculos:" +
                            "\n 4 para Deletar o Veiculo:");
                    int cdVeiculo = leia.nextInt();
                    if (cdVeiculo == 1) {
                        veiculoController.salvarVeiculo();
                    } else if (cdVeiculo == 2) {
                        int vc;
                        System.out.println("Informe o ID do Veiculo que deseja editar:");
                        vc = leia.nextInt();
                        veiculoController.editarVeiculos();
                    } else if (cdVeiculo == 3) {
                        int vc;
                        System.out.println("Informe o ID do Veiculo que deseja listar:");
                        vc = leia.nextInt();
                        veiculoController.printAll(veiculoController.listarVeiculos());
                    } else if (cdVeiculo == 4) {
                        int vc;
                        System.out.println("Informe o ID do Veiculo que deseja deletar:");
                        vc = leia.nextInt();
                        veiculoController.deletarVeiculo();
                    }
                } else if (escolha == 8) {
                    //Código do Viagem
                    System.out.println("Escolha uma das Opcões:" +
                            "\n 1 para Cadastrar a Viagem:" +
                            "\n 2 para Editar a Viagem:" +
                            "\n 3 para Listar as Viagens:" +
                            "\n 4 para Deletar a VIagem:" +
                            "\n 5 para Calcular Frete da Viagem");
                    int cdViagem = leia.nextInt();
                    if (cdViagem == 1) {
                        viagemController.salvarViagem();
                    } else if (cdViagem == 2) {
                        int vj;
                        System.out.println("Informe o ID da Viagem que deseja editar:");
                        vj = leia.nextInt();
                        viagemController.editarViagems();
                    } else if (cdViagem == 3) {
                        int vj;
                        System.out.println("Informe o ID da Viagem que deseja listar:");
                        vj = leia.nextInt();
                        viagemController.printAll(viagemController.listarViagems());
                    } else if (cdViagem == 4) {
                        int vj;
                        System.out.println("Informe o ID da Viagem que deseja deletar:");
                        vj = leia.nextInt();
                        viagemController.deletarViagem();
                    } else if (cdViagem == 5) {
                        System.out.println("Informe o ID da Carga:");
                        int idCarga = leia.nextInt();
                        System.out.println("Informe o ID da Rota:");
                        int idRota = leia.nextInt();
                        System.out.println("Informe o ID da Veiculo:");
                        int idVeiculo = leia.nextInt();
                        System.out.println("Informe o ID da Viagem:");
                        int idViagem = leia.nextInt();

                       // viagemController.calcularFretePeso(viagemController.listarViagems(), cargaNegocioController.listarCargas(), rotaNegocioController.listarRotas(), veiculoController.listarVeiculos(idVeiculo));

                    }
                    System.out.println("Deseja encerrar o Sistema? 1-Sim, 2-Nao");
                    pararPrograma = leia.nextInt();

                    if (pararPrograma == 1) {
                        System.out.println("Encerrando o Sistema!");
                        rodarPrograma = false;
                    }

                }
            }

        }
    }

