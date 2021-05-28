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
                        cargaNegocioController.editarCargas();
                    } else if (cdCarga == 3) {
                        cargaNegocioController.printAll(cargaNegocioController.listarCargas());
                    } else if (cdCarga == 4) {
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
                        clienteController.editarClientes();
                    } else if (cdCliente == 3) {
                        clienteController.printAll(clienteController.listarClientes());
                    } else if (cdCliente == 4) {
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
                        motoristaController.editarMotoristas();
                    } else if (cdMotorista == 3) {
                        motoristaController.printAll(motoristaController.listarMotoristas());
                    } else if (cdMotorista == 4) {
                        motoristaController.deletarMotorista();
                    }
                } else if (escolha == 2) {

                    //Código do Endereço

                    System.out.println("Escolha uma das Opcões:" +
                            "\n 1 para Cadastrar o Endereço do Cliente:" +
                            "\n 2 para Editar o Endereço do Cliente:" +
                            "\n 3 para Listar os Endereços do Cliente:" +
                            "\n 4 para Deletar o Endereço do Cliente:" +
                            "\n" +
                            "\n 5 para Cadastrar o Endereço do Motorista:" +
                            "\n 6 para Editar o Endereço do Motorista:" +
                            "\n 7 para Listar os Endereços do Motorista:" +
                            "\n 8 para Deletar o Endereço do Motorista:");

                    //Endereço do Cliente

                    int cdEndereco = leia.nextInt();
                    if (cdEndereco == 1) {
                        enderecoController.salvarEnderecoDoCliente();
                    } else if (cdEndereco == 2) {
                        enderecoController.editarEnderecoDoCliente();
                    } else if (cdEndereco == 3) {
                        enderecoController.printAll(enderecoController.listarEnderecosDosClientes());
                   } else if (cdEndereco == 4) {
                        enderecoController.deletarEnderecoDoCliente();

                    //Endereço do Motorista

                    } else if (cdEndereco == 5) {
                            enderecoController.salvarEnderecoDoMotorista();
                    } else if (cdEndereco == 6) {
                            enderecoController.editarEnderecoDoMotorista();
                        } else if (cdEndereco == 7) {
                            enderecoController.printAll(enderecoController.listarEnderecosDosMotoristas());
                        } else if (cdEndereco == 8) {
                            enderecoController.deletarEnderecoDoMotorista();
                    }
                } else if (escolha == 1) {

                    //Código do Telefone

                    System.out.println("Escolha uma das Opcões:" +
                            "\n 1 para Cadastrar o Telefone do Cliente:" +
                            "\n 2 para Editar o Telefone do Cliente:" +
                            "\n 3 para Listar os Telefones dos Clientes:" +
                            "\n 4 para Deletar o Telefone do Cliente:" +
                            "\n" +
                            "\n 5 para Cadastrar o Telefone do Motorista:" +
                            "\n 6 para Editar o Telefone do Motorista:" +
                            "\n 7 para Listar o5s Telefones dos Motorista:" +
                            "\n 8 para Deletar o Telefone do Motorista:");

                    //Telefone do Cliente

                    int cdTelefone = leia.nextInt();
                    if (cdTelefone == 1) {
                        telefoneController.salvarTelefoneDoCliente();
                    } else if (cdTelefone == 2) {
                        telefoneController.editarTelefoneDoCliente();
                    } else if (cdTelefone == 3) {
                        telefoneController.printAll(telefoneController.listarTelefonesDosClientes());
                    } else if (cdTelefone == 4) {
                        telefoneController.deletarTelefoneDoCliente();

                    //Telefone do Motorista

                    }else if (cdTelefone == 5) {
                        telefoneController.salvarTelefoneDoMotorista();
                    } else if (cdTelefone == 6) {
                        telefoneController.editarTelefoneDoMotorista();
                    } else if (cdTelefone == 7) {
                        telefoneController.printAll(telefoneController.listarTelefonesDosMotoristas());
                    } else if (cdTelefone == 8) {
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
                        rotaNegocioController.editarRotas();
                    } else if (cdRota == 3) {
                        rotaNegocioController.printAll(rotaNegocioController.listarRotas());
                    } else if (cdRota == 4) {
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
                        veiculoController.editarVeiculos();
                    } else if (cdVeiculo == 3) {
                        veiculoController.printAll(veiculoController.listarVeiculos());
                    } else if (cdVeiculo == 4) {
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
                        viagemController.editarViagems();
                    } else if (cdViagem == 3) {
                        viagemController.printAll(viagemController.listarViagems());
                    } else if (cdViagem == 4) {
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

                       viagemController.calcularFretePeso(viagemController.procurarPorId(idViagem), cargaNegocioController.procurarPorId(idCarga),rotaNegocioController.procurarPorId(idRota), veiculoController.procurarPorId(idVeiculo));

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

