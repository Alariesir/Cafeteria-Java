package cafeteira.controller;

import java.util.List;

import cafeteira.dal.ClienteDao;
import cafeteira.model.Cliente;

public abstract class ClienteController {
    public static void salvar(Cliente cliente) {
        try {
            //ClienteDao é static
            ClienteDao.salvar(cliente);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<Cliente> listar() {
        try {
            return ClienteDao.listar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static void alterarCliente(Cliente cliente) {
        try {
            if(ClienteDao.buscarCliente(cliente.getId()) != null) {
                ClienteDao.alterarCliente(cliente);
            }
        } catch (Exception e) {
            System.out.println("Erro ao alterar cliente!");
        }
    }

    public static void excluirCliente(int id ) {
        try {
            if(ClienteDao.buscarCliente(id) != null) {
                ClienteDao.excluirCliente(ClienteDao.buscarCliente(id));
            }
        } catch (Exception e) {
            System.out.println("Erro ao excluir cliente!");
        }
    }
}
