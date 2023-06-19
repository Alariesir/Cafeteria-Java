package cafeteira.controller;

import cafeteira.dal.VendaDao;
import cafeteira.model.Cafe;
import cafeteira.model.Venda;

public abstract class VendaController {
    
    public static void venderCafe(Venda venda) throws Exception {
        try {
            if(venda.getQuantidade() < Cafe.ESPRESSO.getQuantidade()) {
                if(venda.getQuantidade() > 0) {
                    if(venda.getCafe().getNome().equals("Espresso")){
                        Cafe.ESPRESSO.setQuantidade(Cafe.ESPRESSO.getQuantidade() - venda.getQuantidade());
                        VendaDao.salvarVenda(venda);
                    }
                }
            }
            if(venda.getQuantidade() < Cafe.CAPPUCCINO.getQuantidade()) {
                if(venda.getQuantidade() > 0) {
                    if(venda.getCafe().getNome().equals("Cappuccino")){
                        Cafe.CAPPUCCINO.setQuantidade(Cafe.CAPPUCCINO.getQuantidade() - venda.getQuantidade());
                        VendaDao.salvarVenda(venda);
                    }
                }
            }
            if(venda.getQuantidade() < Cafe.MACCHIATO.getQuantidade()) {
                if(venda.getQuantidade() > 0) {
                    if(venda.getCafe().getNome().equals("Macchiato")){
                        Cafe.MACCHIATO.setQuantidade(Cafe.MACCHIATO.getQuantidade() - venda.getQuantidade());
                        VendaDao.salvarVenda(venda);
                    }
                }
            }
            if(venda.getQuantidade() < Cafe.MOCHA.getQuantidade()) {
                if(venda.getQuantidade() > 0) {
                    if(venda.getCafe().getNome().equals("Mocha")){
                        Cafe.MOCHA.setQuantidade(Cafe.MOCHA.getQuantidade() - venda.getQuantidade());
                        VendaDao.salvarVenda(venda);
                    }
                }
            }
            } catch (Exception e) {
            System.out.println("Erro: "+ e);
        } 
    }

}

