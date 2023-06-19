package cafeteira.model;

import javax.persistence.*;

@Entity
public class Cliente extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome, sobrenome, telefone;

    public Cliente(String nome, String sobrenome, String telefone) {
        super(nome, sobrenome, telefone);
   
    }
    public int getId() {
        return id;
    }
   
    public void setId(int id) {
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

    @Override
    public String toString() {
        return "\nCliente [nome=" + nome + ", sobrenome=" + sobrenome + ", telefone=" + telefone + "]";
    }


}