import Controller.*;
import Model.Veiculo;

import java.util.Scanner;


public class Principal {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        CargaNegocioController cargaNegocioController = new CargaNegocioController();
        ClienteController clienteController = new ClienteController();
        EnderecoController enderecoController = new EnderecoController();
        MotoristaController motoristaController = new MotoristaController();
        RotaNegocioController rotaNegocioController = new RotaNegocioController();
        TelefoneController telefoneController = new TelefoneController();
        VeiculoController veiculoController = new VeiculoController();
        ViagemNegocioController viagemNegocioController = new ViagemNegocioController();
        ViagemController viagemController = new ViagemController();

        int pararPrograma;
        Boolean rodarPrograma = true;

        while (rodarPrograma) {

            clienteController.cadastrarCliente();

            motoristaController.cadastrarMotorista();

            enderecoController.cadastrarEndereco();

            telefoneController.cadastrarTelefone();

            veiculoController.cadastrarVeiculo();

            rotaNegocioController.definirRotas();

            cargaNegocioController.cadastrarCarga();

            viagemController.cadastrarViagem(cargaNegocioController.getCarga(0), rotaNegocioController.getRotas(0), veiculoController.getVeiculo(0));

            System.out.println("Escolha a categoria:" +
                    "\n 1 para Carga" +
                    "\n 2 para Cliente" +
                    "\n 3 para Motorista" +
                    "\n 4 para Endereço" +
                    "\n 5 para Telefone" +
                    "\n 6 para Rota" +
                    "\n 7 para Veiculo" +
                    "\n 8 - Viagem");
            int escolha = leia.nextInt();

            if (escolha == 1) {
                //Código da Carga
                System.out.println("Escolha: 1 para Cadastrar // 2 para Editar // 3 para Procurar e 4 para Deletar");
                int cdCarga = leia.nextInt();
                if (cdCarga == 1) {
                    cargaNegocioController.cadastrarCarga();
                } else if (cdCarga == 2) {
                    int cg;
                    System.out.println("Informe o ID que deseja editar");
                    cg = leia.nextInt();
                    cargaNegocioController.editarCarga(cg);
                } else if (cdCarga == 3) {
                    int cg;
                    System.out.println("Informe o ID que deseja procurar");
                    cg = leia.nextInt();
                    cargaNegocioController.listarCarga(cg);
                } else if (cdCarga == 4) {
                    int cg;
                    System.out.println("Informe o ID que deseja deletar");
                    cg = leia.nextInt();
                    cargaNegocioController.deletarCarga(cg);
                }

            } else if (escolha == 2) {
                //Código do Cliente
                System.out.println("Escolha: 1 para Cadastrar // 2 para Editar // 3 para Procurar e 4 para Deletar");
                int cdCliente = leia.nextInt();
                if (cdCliente == 1) {
                    clienteController.cadastrarCliente();
                } else if (cdCliente == 2) {
                    int cl;
                    System.out.println("Informe o ID que deseja editar");
                    cl = leia.nextInt();
                    cargaNegocioController.editarCarga(cl);
                } else if (cdCliente == 3) {
                    int cl;
                    System.out.println("Informe o ID que deseja procurar");
                    cl = leia.nextInt();
                    cargaNegocioController.listarCarga(cl);
                } else if (cdCliente == 4) {
                    int cl;
                    System.out.println("Informe o ID que deseja deletar");
                    cl = leia.nextInt();
                    cargaNegocioController.deletarCarga(cl);
                }
            } else if (escolha == 3) {
                //Código do Motorista
                System.out.println("Escolha: 1 para Cadastrar // 2 para Editar // 3 para Procurar e 4 para Deletar");
                int cdMotorista = leia.nextInt();
                if (cdMotorista == 1) {
                    motoristaController.cadastrarMotorista();
                } else if (cdMotorista == 2) {
                    int mt;
                    System.out.println("Informe o ID que deseja editar");
                    mt = leia.nextInt();
                    motoristaController.editarMotorista(mt);
                } else if (cdMotorista == 3) {
                    int mt;
                    System.out.println("Informe o ID que deseja procurar");
                    mt = leia.nextInt();
                    motoristaController.listarMotorista(mt);
                } else if (cdMotorista == 4) {
                    int mt;
                    System.out.println("Informe o ID que deseja deletar");
                    mt = leia.nextInt();
                    motoristaController.deletarMotorista(mt);
                }
            } else if (escolha == 4) {
                //Código do Endereço
                System.out.println("Escolha: 1 para Cadastrar // 2 para Editar // 3 para Procurar e 4 para Deletar");
                int cdEndereco = leia.nextInt();
                if (cdEndereco == 1) {
                    enderecoController.cadastrarEndereco();
                } else if (cdEndereco == 2) {
                    int ed;
                    System.out.println("Informe o ID que deseja editar");
                    ed = leia.nextInt();
                    enderecoController.editarEndereco(ed);
                } else if (cdEndereco == 3) {
                    int ed;
                    System.out.println("Informe o ID que deseja procurar");
                    ed = leia.nextInt();
                    enderecoController.listarEndereco(ed);
                } else if (cdEndereco == 4) {
                    int ed;
                    System.out.println("Informe o ID que deseja deletar");
                    ed = leia.nextInt();
                    enderecoController.deletarEndereco(ed);
                }
            } else if (escolha == 5) {
                //Código do Telefone
                System.out.println("Escolha: 1 para Cadastrar // 2 para Editar // 3 para Procurar e 4 para Deletar");
                int cdTelefone = leia.nextInt();
                if (cdTelefone == 1) {
                    telefoneController.cadastrarTelefone();
                } else if (cdTelefone == 2) {
                    int tf;
                    System.out.println("Informe o ID que deseja editar");
                    tf = leia.nextInt();
                    telefoneController.editarTelefones(tf);
                } else if (cdTelefone == 3) {
                    int tf;
                    System.out.println("Informe o ID que deseja procurar");
                    tf = leia.nextInt();
                    telefoneController.listarTelefones(tf);
                } else if (cdTelefone == 4) {
                    int tf;
                    System.out.println("Informe o ID que deseja deletar");
                    tf = leia.nextInt();
                    telefoneController.deletarTelefones(tf);
                }

            } else if (escolha == 6) {
                    //Código do Rota
                    System.out.println("Escolha: 1 para Cadastrar // 2 para Editar // 3 para Procurar e 4 para Deletar");
                    int cdRota = leia.nextInt();
                    if (cdRota == 1) {
                       rotaNegocioController.definirRotas();
                    } else if (cdRota == 2) {
                        int rt;
                        System.out.println("Informe o ID que deseja editar");
                        rt = leia.nextInt();
                        rotaNegocioController.editarRotas(rt);
                    } else if (cdRota == 3) {
                        int rt;
                        System.out.println("Informe o ID que deseja procurar");
                        rt = leia.nextInt();
                        rotaNegocioController.listarRotas(rt);
                    } else if (cdRota == 4) {
                        int rt;
                        System.out.println("Informe o ID que deseja deletar");
                        rt = leia.nextInt();
                        rotaNegocioController.deletarRota(rt);
                    }
            } else if (escolha == 7) {
                //Código do Veiculo
                System.out.println("Escolha: 1 para Cadastrar // 2 para Editar // 3 para Procurar e 4 para Deletar");
                int cdVeiculo = leia.nextInt();
                if (cdVeiculo == 1) {
                    veiculoController.cadastrarVeiculo();
                } else if (cdVeiculo == 2) {
                    int vc;
                    System.out.println("Informe o ID que deseja editar");
                    vc = leia.nextInt();
                    veiculoController.editarVeiculo(vc);
                } else if (cdVeiculo == 3) {
                    int vc;
                    System.out.println("Informe o ID que deseja procurar");
                    vc = leia.nextInt();
                   veiculoController.listarVeiculos(vc);
                } else if (cdVeiculo == 4) {
                    int vc;
                    System.out.println("Informe o ID que deseja deletar");
                    vc = leia.nextInt();
                    veiculoController.deletarVeiculos(vc);
                }
            } else if (escolha == 8) {
                //Código do Viagem
                System.out.println("Escolha: 1 para Cadastrar // 2 para Editar // 3 para Procurar e 4 para Deletar");
                int cdViagem = leia.nextInt();
                if (cdViagem == 1) {
                    viagemController.cadastrarViagem(cargaNegocioController.getCarga(0), rotaNegocioController.getRotas(0), veiculoController.getVeiculo(0));
                } else if (cdViagem == 2) {
                    int vj;
                    System.out.println("Informe o ID que deseja editar");
                    vj = leia.nextInt();
                    viagemController.editarViagem(vj, cargaNegocioController.getCarga(0), rotaNegocioController.getRotas(0), veiculoController.getVeiculo(0));
                } else if (cdViagem == 3) {
                    int vj;
                    System.out.println("Informe o ID que deseja procurar");
                    vj = leia.nextInt();
                    veiculoController.listarVeiculos(vj);
                } else if (cdViagem == 4) {
                    int vj;
                    System.out.println("Informe o ID que deseja deletar");
                    vj = leia.nextInt();
                    veiculoController.deletarVeiculos(vj);

                }
                System.out.println("Deseja parar o programa? 1-Sim, 2-Nao");
                pararPrograma = leia.nextInt();

                if (pararPrograma == 1) {
                    rodarPrograma = false;
                }

            }
        }
    }
}
