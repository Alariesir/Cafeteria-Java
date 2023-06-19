package view;

import java.util.Scanner;

public abstract class Menu {
    private static int opcao;
    private static Scanner entrada = new Scanner(System.in);

    public static int opcaoEscolhida() {
        try {
            
            System.out.println("Escolha uma das opções:\n"+
                            "1 - Cadastrar Cliente\n"+
                            "2 - Lista de Cliente\n"+
                            "3 - Alterar Clientes\n"+
                            "4 - Excluir Cliente\n"+
                            "5 - Comprar Café\n"+
                            "0 - Sair");
            opcao = entrada.nextInt();

            return opcao;
        } catch (Exception e) {
            System.out.println("Erro na opção escolhida.");
            return 0;
        }
    }

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }
}
