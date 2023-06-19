package cafeteira.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    protected String nome, sobrenome, telefone;

    //- cria a tabela cliente_venda
    @OneToMany(cascade = CascadeType.ALL)   //OBS: Talvez tenha que ser tipo List<Venda> --- 
    private List<Venda> venda;

    public Pessoa(String nome, String sobrenome, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }

    public Pessoa(){}

    public Pessoa(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    //-- Getters and Setters de Venda | @OneToMany ---------
    public List<Venda> getVenda() {
        return venda;
    }
    public void setVenda(List<Venda> venda) {
        this.venda = venda;
    }
    //---------------------------------------

    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", telefone=" + telefone + "]";
    }

  
}
