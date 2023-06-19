package cafeteira.model;

public enum Cafe {
    ESPRESSO("Espresso", 10.00f, 20),
    CAPPUCCINO("Cappuccino", 15.00f, 30),
    MACCHIATO("Macchiato", 17.50f, 20),
    MOCHA("Mocha", 15.50f, 30);

    private String nome;
    private float preco;
    private int quantidade;

    private Cafe(String nome, float preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
