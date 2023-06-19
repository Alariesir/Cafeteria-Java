package cafeteira.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import cafeteira.model.Cliente;

public abstract class ClienteDao {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
    private static EntityManager em = emf.createEntityManager();

    public static void salvar(Cliente cliente) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    public static List<Cliente> listar() throws Exception {
        try {
            em.getTransaction().begin();
            Query sql = em.createQuery("SELECT c FROM Cliente c");
            List<Cliente> lista = sql.getResultList();
            em.getTransaction().commit();
            
            return lista;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    public static Cliente buscarCliente(int id) {
        try {
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, id);
            em.getTransaction().commit();

            return cliente;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        }
    }

    public static void alterarCliente(Cliente cliente) {
        try {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public static void excluirCliente(Cliente cliente) {
        try {
            em.getTransaction().begin();
            cliente = em.merge(cliente);
            em.remove(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
}
