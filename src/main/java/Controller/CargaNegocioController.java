package Controller;

import Model.Carga;
import Model.Carga;
import Model.Rota;
import Model.dao.CargaDao;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static Model.TipoCarga.fragil;
import static Model.TipoCarga.naoFragil;

public class CargaNegocioController {

    private static AtomicInteger id_generator = new AtomicInteger(0);
    private ArrayList<Carga> cargas = new ArrayList<Carga>();
    private Carga carga;
    private CargaDao cargaDao;


    public Carga preencher() {
        Scanner leia = new Scanner(System.in);

        carga = new Carga();

        carga.setId(id_generator.getAndIncrement());

        System.out.println("Informe o peso da carga:");
        carga.setPeso(leia.nextDouble());

        System.out.println("Informe o altura da carga:");
        carga.setAltura(leia.nextDouble());

        System.out.println("Informe o comprimento da carga:");
        carga.setComprimento(leia.nextDouble());

        System.out.println("Informe o largura da carga:");
        carga.setLargura(leia.nextDouble());

        carga.setPesoOcupada(carga.getAltura() * carga.getComprimento() * carga.getLargura() * 300);

        System.out.println("A carga é frágil, digite 1 para Sim e 2 para não:");
        int tipoCarga = leia.nextInt();
        if (tipoCarga == 1) {
            carga.setTipoCarga(fragil);

        } else if (tipoCarga == 2) {
            carga.setTipoCarga(naoFragil);
        }
        cargas.add(carga);

        return carga;
    }
//
//    public void editarCarga(long id) {
//        int log = 0;
//        for (Carga carga : cargas) {
//            if (carga.getId() == id) {
//
//            }
//            Carga cargaNova = new Carga();
//            Scanner leia = new Scanner(System.in);
//
//
//            System.out.println("Informe o novo peso da carga");
//            cargaNova.setPeso(leia.nextDouble());
//
//            System.out.println("Informe a nova altura da carga:");
//            cargaNova.setAltura(leia.nextDouble());
//
//            System.out.println("Informe o novo comprimento da carga:");
//            cargaNova.setComprimento(leia.nextDouble());
//
//            System.out.println("Informe a nova largura da carga:");
//            cargaNova.setLargura(leia.nextDouble());
//
//            cargaNova.setPesoOcupada(cargaNova.getAltura() * cargaNova.getComprimento() * cargaNova.getLargura() * 300);
//
//            System.out.println("A carga é frágil, digite 1 para Sim e 2 para não:");
//            int tipoCarga = leia.nextInt();
//            if (tipoCarga == 1) {
//                carga.setTipoCarga(fragil);
//
//            } else if (tipoCarga == 2) {
//                carga.setTipoCarga(naoFragil);
//            }
//            cargas.set(log, cargaNova);
//        }
//        log++;
//    }
//
//    public Carga listarCarga(long id) {
//
//        for (Carga carga : cargas) {
//            if (carga.getId() == id) {
//                return carga;
//            }
//        }
//        return null;
//    }
//
//
//
//    public void deletarCarga(long id) {
//        int log = 0;
//        for (Carga carga : cargas) {
//            if (carga.getId() == id) {
//                cargas.remove(log);
//            }
//            log++;
//        }

        public void printarCarga(Carga carga) {
            System.out.println();
            System.out.println("O Peso da Carga é:" + carga.getPeso());
            System.out.println("A Altura da Carga é:" + carga.getAltura());
            System.out.println("O Comprimento da Carga é:" + carga.getComprimento());
            System.out.println("A Largura da Carga é:" + carga.getLargura());
            System.out.println("O Peso Ocupado no Veiculo é:" + carga.getPesoOcupada());
            System.out.println("O Tipo de Carga é:" + carga.getTipoCarga());
            System.out.println();
        }

public ArrayList<Carga> listarCargas() {
        cargaDao = new CargaDao();
        ArrayList<Carga> cargas = cargaDao.listarCargas();
        return cargas;
        }

public boolean salvarCarga() {
        Carga carga = preencher();
        cargaDao = new CargaDao();
        boolean isSalvo = cargaDao.salvarCarga(carga);
        return isSalvo;
        }

public boolean editarCargas() {
        cargaDao = new CargaDao();
        int id = digitarId();
        Carga carga = preencher();
        carga.setId(id);
        boolean isSalvo = cargaDao.editarCarga(carga);
        return isSalvo;
        }

public boolean deletarCarga() {
        cargaDao = new CargaDao();
        int id = digitarId();
        boolean isSalvo = cargaDao.deletarCarga(id);
        return isSalvo;
        }

public void printAll(ArrayList<Carga> cargas) {
        for (Carga carga : cargas) {
        printarCarga(carga);
        }
        }
public Carga procurarPorId(int id) {
        cargaDao = new CargaDao();
        Carga carga = cargaDao.buscarCargaPorId(id);
        return carga;
        }
public int digitarId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Qual o ID da Carga que deseja modifcar?: ");
        int id = input.nextInt();
        return id;
        }

    public boolean editarCargas(Carga carga) {
        cargaDao = new CargaDao();
        boolean isSalvo = false;
        return isSalvo;
    }
}



