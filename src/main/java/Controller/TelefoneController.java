package Controller;

import Model.Motorista;
import Model.Telefone;
import Model.Telefone;
import Model.Telefone;
import Model.dao.MotoristaDao;
import Model.dao.TelefoneDao;
import Model.dao.TelefoneDao;
import Model.dao.TelefoneDao;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class TelefoneController {


    private ArrayList<Telefone> telefones = new ArrayList<Telefone>();
    private static AtomicInteger id_generator = new AtomicInteger(0);
    private Telefone telefone;
    private TelefoneDao telefoneDao;

    public Telefone preencher() {

        telefone = new Telefone();
        Scanner leia = new Scanner(System.in);

        telefone.setId(id_generator.getAndIncrement());

        System.out.println("Informe o Código de Área: ");
        telefone.setCodigoArea(leia.next());

        System.out.println("Informe o DDD: ");
        telefone.setDDD(leia.next());

        System.out.println("Informe o Número do Telefone: ");
        telefone.setNumero(leia.next());

        telefones.add(telefone);
        
        return telefone;


//    }
//
//    public Telefone listarTelefones(long id) {
//        for (Telefone telefone : telefones) {
//            if (telefone.getId() == id) {
//                return telefone;
//            }
//        }
//        return null;
//    }
//
//    public void editarTelefones(long id) {
//        int log = 0;
//        for (Telefone telefone : telefones) {
//            if (telefone.getId() == id) {
//                Telefone telefoneNovo = new Telefone();
//
//                Scanner leia = new Scanner(System.in);
//
//                System.out.println("Informe o código de área: ");
//                telefoneNovo.setCodigoArea(leia.next());
//
//                System.out.println("Informe o DDD: ");
//                telefoneNovo.setDDD(leia.next());
//
//                System.out.println("Informe o número do telefone: ");
//                telefoneNovo.setNumero(leia.next());
//
//                telefoneNovo.setId(id);
//            }
//
//            telefones.set(log, telefone);
//
//        }
//        log++;
//    }
//
//
//
//    public void deletarTelefones(long id){
//        int log = 0;
//        for(Telefone telefone : telefones) {
//            if(telefone.getId() == id) {
//                telefones.remove(log);
//                break;
//            }
//            log++;
//        }
    }
    public ArrayList<Telefone> listarTelefonesDosClientes() {
        telefoneDao = new TelefoneDao();
        ArrayList<Telefone> telefones = telefoneDao.listarTelefonesDosClientes();
        return telefones;
    }
    public ArrayList<Telefone> listarTelefonesDosMotoristas() {
        telefoneDao = new TelefoneDao();
        ArrayList<Telefone> telefones = telefoneDao.listarTelefonesDosMotoristas();
        return telefones;
    }
    public void printarTelefones (Telefone telefone) {
        System.out.println();
        System.out.println("O Código de Area é:" + telefone.getCodigoArea());
        System.out.println("O DDD do Telefone é:" + telefone.getDDD());
        System.out.println("O Numero do Telefone é:" + telefone.getNumero());
        System.out.println();
    }

    public boolean salvarTelefoneDoCliente() {
        telefoneDao = new TelefoneDao();
        Telefone telefone = preencher();
        boolean isSalvo = telefoneDao.salvarTelefoneDosClientes(telefone);
        return isSalvo;
    }
    public boolean salvarTelefoneDoMotorista() {
        telefoneDao = new TelefoneDao();
        Telefone telefone = preencher();
        boolean isSalvo = telefoneDao.salvarTelefoneDoMotorista(telefone);
        return isSalvo;
    }

    public boolean editarTelefoneDoCliente() {
        telefoneDao = new TelefoneDao();
        int id = digitarId();
        Telefone telefone = preencher();
        telefone.setId(id);
        boolean isSalvo = telefoneDao.editarTelefoneDosClientes(telefone);
        return isSalvo;
    }
    public boolean editarTelefoneDoMotorista() {
        telefoneDao = new TelefoneDao();
        int id = digitarId();
        Telefone telefone = preencher();
        telefone.setId(id);
        boolean isSalvo = telefoneDao.editarTelefoneDoMotorista(telefone);
        return isSalvo;
    }

    public boolean deletarTelefoneDoCliente() {
        telefoneDao = new TelefoneDao();
        int id = digitarId();
        boolean isSalvo = telefoneDao.deletarTelefoneDoCliente(id);
        return isSalvo;
    }
    public boolean deletarTelefoneDoMotorista() {
        telefoneDao = new TelefoneDao();
        int id = digitarId();
        boolean isSalvo = telefoneDao.deletarTelefoneDoMotorista(id);
        return isSalvo;
    }

    public void printAll(ArrayList<Telefone> telefones) {
        for (Telefone telefone : telefones) {
            printarTelefones(telefone);
        }
    }
    public int digitarId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Qual o ID do Telefone que deseja modificar? ");
        int id = input.nextInt();
        return id;
    }
}
