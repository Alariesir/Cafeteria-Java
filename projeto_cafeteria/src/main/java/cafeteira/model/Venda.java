package cafeteira.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Venda implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private Cliente cliente;
    private int quantidade;

    @Enumerated(EnumType.STRING)
    private Cafe cafe;

    //TODO: implementar um @OneToMany ou dependendo @OneToOne 
    @ManyToOne(cascade = CascadeType.ALL)   //OBS: Talvez tenha que ser tipo List<Venda> --- 
    private Cliente clientes;
    //

    public Venda(Cliente cliente, Cafe cafe, int quantidade) {
        this.cliente = cliente;
        this.cafe = cafe;
        this.quantidade = quantidade;
    }

    public Venda(int quantidade, Cafe cafe) {
        this.quantidade = quantidade;
        this.cafe = cafe;
    }

    public Venda() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    //-- Getters and Setters de Venda | @OneToMany ---------
    public Cliente getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }


    @Override
    public String toString() {
        return "Venda [cliente=" + cliente + ", cafe=" + cafe.getNome() + " preco="+ cafe.getPreco() +" quantidade="+ quantidade +"]";
    }

    
    

    
}
