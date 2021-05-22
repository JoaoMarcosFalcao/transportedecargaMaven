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
        Cliente cliente = new Cliente();
        cliente.setNome("João Marcos");
        cliente.setEmail("asifjaoijf@hotmail.com");
        cliente.setCpf("000.000.00082");


        Cliente clienteEdit = new Cliente();

            List<Cliente> clientes = clienteController.listarClientes();
            for (Iterator iterator = clientes.iterator(); iterator.hasNext(); ) {
                Cliente cliente1 = (Cliente) iterator.next();
                System.out.println("ID " + cliente1.getId());
                System.out.println("Nome " + cliente1.getNome());
                System.out.println("Email " + cliente1.getEmail());
                System.out.println("CPF " + cliente1.getCpf());
                if(cliente1.getId() == 1) {
                    clienteEdit = cliente1;
                }

            clienteEdit.setNome("João Edit");
            clienteEdit.setEmail("jaosdjad@hotmail.com");
            clienteEdit.setCpf("000.000.000-28");

            clienteController.editarCliente(clienteEdit);


        }
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
                        "\n 1 para Carga" +
                        "\n 2 para Cliente" +
                        "\n 3 para Motorista" +
                        "\n 4 para Endereço" +
                        "\n 5 para Telefone" +
                        "\n 6 para Rota" +
                        "\n 7 para Veiculo" +
                        "\n 8 para Viagem");
                int escolha = leia.nextInt();

                if (escolha == 1) {
                    //Código da Carga
                    System.out.println("Escolha uma das Opcões:" +
                            "\n 1 para Cadastrar a Carga" +
                            "\n 2 para Editar a Carga" +
                            "\n 3 para Listar as Cargas" +
                            "\n 4 para Deletar a Carga");

                    int cdCarga = leia.nextInt();
                    if (cdCarga == 1) {
                        cargaNegocioController.cadastrarCarga();
                    } else if (cdCarga == 2) {
                        int cg;
                        System.out.println("Informe o ID da Carga que deseja editar:");
                        cg = leia.nextInt();
                        cargaNegocioController.editarCarga(cg);
                    } else if (cdCarga == 3) {
                        int cg;
                        System.out.println("Informe o ID da Carga que deseja listar:");
                        cg = leia.nextInt();
                        cargaNegocioController.printarCarga(cargaNegocioController.listarCarga(cg));
                    } else if (cdCarga == 4) {
                        int cg;
                        System.out.println("Informe o ID da Carga que deseja deletar:");
                        cg = leia.nextInt();
                        cargaNegocioController.deletarCarga(cg);
                    }

                } else if (escolha == 2) {
                    //Código do Cliente
                    System.out.println("Escolha uma das Opcões:" +
                            "\n 1 para Cadastrar o Cliente:" +
                            "\n 2 para Editar o Cliente:" +
                            "\n 3 para Listar os Clientes:" +
                            "\n 4 para Deletar o Cliente:");
                    int cdCliente = leia.nextInt();
                    if (cdCliente == 1) {
                        clienteController.cadastrarCliente();
                    } else if (cdCliente == 2) {
                        int cl;
                        System.out.println("Informe o ID do Cliente que deseja editar:");
                        cl = leia.nextInt();
                        clienteController.editarClientes(cl);
                    } else if (cdCliente == 3) {
                        int cl;
                        System.out.println("Informe o ID do Cliente que deseja listar:");
                        cl = leia.nextInt();
                        clienteController.printarCliente(clienteController.listarClientes(cl));
                    } else if (cdCliente == 4) {
                        int cl;
                        System.out.println("Informe o ID do Cliente que deseja deletar:");
                        cl = leia.nextInt();
                        clienteController.deletarCliente(cl);
                    }
                } else if (escolha == 3) {
                    //Código do Motorista
                    System.out.println("Escolha uma das Opcões:" +
                            "\n 1 para Cadastrar o Motorista:" +
                            "\n 2 para Editar o Motorista:" +
                            "\n 3 para Listar os Motoristas:" +
                            "\n 4 para Deletar o Motorista:");
                    int cdMotorista = leia.nextInt();
                    if (cdMotorista == 1) {
                        motoristaController.cadastrarMotorista();
                    } else if (cdMotorista == 2) {
                        int mt;
                        System.out.println("Informe o ID do Motorista que deseja editar:");
                        mt = leia.nextInt();
                        motoristaController.editarMotorista(mt);
                    } else if (cdMotorista == 3) {
                        int mt;
                        System.out.println("Informe o ID do Motorista que deseja listar:");
                        mt = leia.nextInt();
                        motoristaController.printarMotorista(motoristaController.listarMotorista(mt));
                    } else if (cdMotorista == 4) {
                        int mt;
                        System.out.println("Informe o ID do Motorista que deseja deletar:");
                        mt = leia.nextInt();
                        motoristaController.deletarMotorista(mt);
                    }
                } else if (escolha == 4) {
                    //Código do Endereço
                    System.out.println("Escolha uma das Opcões:" +
                            "\n 1 para Cadastrar o Endereço:" +
                            "\n 2 para Editar o Endereço:" +
                            "\n 3 para Listar os Endereços:" +
                            "\n 4 para Deletar o Endereço:");
                    int cdEndereco = leia.nextInt();
                    if (cdEndereco == 1) {
                        enderecoController.cadastrarEndereco();
                    } else if (cdEndereco == 2) {
                        int ed;
                        System.out.println("Informe o ID do Endereço que deseja editar:");
                        ed = leia.nextInt();
                        enderecoController.editarEndereco(ed);
                    } else if (cdEndereco == 3) {
                        int ed;
                        System.out.println("Informe o ID do Endereço que deseja listar:");
                        ed = leia.nextInt();
                        enderecoController.printarEndereco(enderecoController.listarEndereco(ed));
                    } else if (cdEndereco == 4) {
                        int ed;
                        System.out.println("Informe o ID do Endereço que deseja deletar:");
                        ed = leia.nextInt();
                        enderecoController.deletarEndereco(ed);
                    }
                } else if (escolha == 5) {
                    //Código do Telefone
                    System.out.println("Escolha uma das Opcões:" +
                            "\n 1 para Cadastrar o Telefone:" +
                            "\n 2 para Editar o Telefone:" +
                            "\n 3 para Listar os Telefones:" +
                            "\n 4 para Deletar o Telefone:");
                    int cdTelefone = leia.nextInt();
                    if (cdTelefone == 1) {
                        telefoneController.cadastrarTelefone();
                    } else if (cdTelefone == 2) {
                        int tf;
                        System.out.println("Informe o ID do Endereço que deseja editar:");
                        tf = leia.nextInt();
                        telefoneController.editarTelefones(tf);
                    } else if (cdTelefone == 3) {
                        int tf;
                        System.out.println("Informe o ID do Endereço que deseja listar:");
                        tf = leia.nextInt();
                        telefoneController.printarTelefones(telefoneController.listarTelefones(tf));
                    } else if (cdTelefone == 4) {
                        int tf;
                        System.out.println("Informe o ID do Endereço que deseja deletar:");
                        tf = leia.nextInt();
                        telefoneController.deletarTelefones(tf);
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
                        rotaNegocioController.definirRotas();
                    } else if (cdRota == 2) {
                        int rt;
                        System.out.println("Informe o ID da Rota que deseja editar:");
                        rt = leia.nextInt();
                        rotaNegocioController.editarRotas(rt);
                    } else if (cdRota == 3) {
                        int rt;
                        System.out.println("Informe o ID da Rota que deseja listar:");
                        rt = leia.nextInt();
                        rotaNegocioController.printarRotas(rotaNegocioController.listarRotas(rt));
                    } else if (cdRota == 4) {
                        int rt;
                        System.out.println("Informe o ID da Rota que deseja deletar:");
                        rt = leia.nextInt();
                        rotaNegocioController.deletarRota(rt);
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
                        veiculoController.cadastrarVeiculo();
                    } else if (cdVeiculo == 2) {
                        int vc;
                        System.out.println("Informe o ID do Veiculo que deseja editar:");
                        vc = leia.nextInt();
                        veiculoController.editarVeiculo(vc);
                    } else if (cdVeiculo == 3) {
                        int vc;
                        System.out.println("Informe o ID do Veiculo que deseja listar:");
                        vc = leia.nextInt();
                        veiculoController.printarVeiculo(veiculoController.listarVeiculos(vc));
                    } else if (cdVeiculo == 4) {
                        int vc;
                        System.out.println("Informe o ID do Veiculo que deseja deletar:");
                        vc = leia.nextInt();
                        veiculoController.deletarVeiculos(vc);
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
                        viagemController.cadastrarViagem();
                    } else if (cdViagem == 2) {
                        int vj;
                        System.out.println("Informe o ID da Viagem que deseja editar:");
                        vj = leia.nextInt();
                        viagemController.editarViagem(vj);
                    } else if (cdViagem == 3) {
                        int vj;
                        System.out.println("Informe o ID da Viagem que deseja listar:");
                        vj = leia.nextInt();
                        viagemController.printarViagem(viagemController.listarViagens(vj));
                    } else if (cdViagem == 4) {
                        int vj;
                        System.out.println("Informe o ID que deseja deletar");
                        vj = leia.nextInt();
                        viagemController.deletarViagem(vj);
                    } else if (cdViagem == 5) {
                        System.out.println("Informe o ID da Carga:");
                        int idCarga = leia.nextInt();
                        System.out.println("Informe o ID da Rota:");
                        int idRota = leia.nextInt();
                        System.out.println("Informe o ID da Veiculo:");
                        int idVeiculo = leia.nextInt();
                        System.out.println("Informe o ID da Viagem:");
                        int idViagem = leia.nextInt();

                        viagemController.calcularFretePeso(viagemController.listarViagens(idViagem), cargaNegocioController.listarCarga(idCarga), rotaNegocioController.listarRotas(idRota), veiculoController.listarVeiculos(idVeiculo));

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

