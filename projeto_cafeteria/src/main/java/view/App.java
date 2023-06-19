package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cafeteira.controller.ClienteController;
import cafeteira.controller.VendaController;
import cafeteira.model.Cafe;
import cafeteira.model.Cliente;
import cafeteira.model.Venda;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Cafeteria!" );
        
        Scanner entrada = new Scanner(System.in);
        List<Cliente> verificarNome = new ArrayList<Cliente>();
        int idCliente = 0;
        
        boolean cont = true;

        while(cont){
            switch(Menu.opcaoEscolhida()) {
                case 1:
                    System.out.println("--- Cadastro de Cliente! ---");
                    System.out.println("Informe o Nome:");
                    String nome = entrada.nextLine();
                    System.out.println("Informe o Sobrenome:");
                    String sobrenome = entrada.nextLine();
                    System.out.println("Informe o Telefone:");
                    String telefone = entrada.nextLine();
                    System.out.println("Cadastro feito e salvo!");

                    ClienteController.salvar(new Cliente(nome, sobrenome, telefone));
                break;
                case 2:
                    System.out.println("Listando e Cadastrando ao Banco de Dados!");
                    System.out.println(ClienteController.listar());
                break;
                case 3:
                    System.out.println("--- Alterar Cliente ---");
                    System.out.println("Informe o Nome:");
                    nome = entrada.nextLine();
                    System.out.println("Informe o Sobrenome:");
                    sobrenome = entrada.nextLine();
                    System.out.println("Informe o Telefone:");
                    telefone = entrada.nextLine();
                    System.out.println("Alteração feita e salva!");

                    ClienteController.alterarCliente(new Cliente(nome, sobrenome, telefone));
                break;
                case 4:
                    System.out.println("--- Excluir Cliente ---");
                    System.out.println("Informe o ID do Cliente;");
                    idCliente = entrada.nextInt();
                    entrada.nextLine();

                    ClienteController.excluirCliente(idCliente);
                break;
                case 5:
                    int opcaoCafe = 0;
                    System.out.println("\n---- Menu de Opções ----");
                    System.out.println("1. Espresso.......R$10,00");
                    System.out.println("2. Cappuccino.....R$15,00");
                    System.out.println("3. Macchiato......R$17,50");
                    System.out.println("4. Mocha..........R$15,50\n");
                    System.out.println("Qual sua escolha?");
                    opcaoCafe = entrada.nextInt();
                    System.out.println("Quantos cafés?");
                    int quantidade = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Seu nome:");
                    String nomeDigitado = entrada.nextLine();

                    try {
                        
                        verificarNome = ClienteController.listar();
                        
                        for (Cliente cliente : verificarNome) {
                            if(cliente.getNome().equals(nomeDigitado)) {
                                if(opcaoCafe == 1){
                                    VendaController.venderCafe(new Venda(cliente, Cafe.ESPRESSO, quantidade)); //TODO: pensar em como passar o cliente
                                }
                            }
                            if(cliente.getNome().equals(nomeDigitado)) {
                                if(opcaoCafe == 1){
                                    VendaController.venderCafe(new Venda(cliente, Cafe.CAPPUCCINO, quantidade)); //TODO: pensar em como passar o cliente
                                }
                            }
                            if(cliente.getNome().equals(nomeDigitado)) {
                                if(opcaoCafe == 1){
                                    VendaController.venderCafe(new Venda(cliente, Cafe.MACCHIATO, quantidade)); //TODO: pensar em como passar o cliente
                                }
                            }
                            if(cliente.getNome().equals(nomeDigitado)) {
                                if(opcaoCafe == 1){
                                    VendaController.venderCafe(new Venda(cliente, Cafe.MOCHA, quantidade)); //TODO: pensar em como passar o cliente
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Não foi possivel fazer a compra."+ e);
                    }
                break;
                case 0:
                    cont = false;
                break;
            }
        }
        entrada.close();
    }
}
