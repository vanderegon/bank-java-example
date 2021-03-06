import java.util.LinkedHashMap;
import java.util.Scanner;

public class MenuCliente {

    private LinkedHashMap<String, Contas> listaClientes;
    private Scanner scanner;
    private Utils utils;

    public MenuCliente(LinkedHashMap<String, Contas> listaClientes, Scanner scanner, Utils utils){
        this.listaClientes = listaClientes;
        this.scanner = scanner;
        this.utils = utils;
    }

    public void Menu(){

        while (true){
            System.out.println("\n Escolha uma das opções abaixo: ");

            System.out.println(" 1 - Listar clientes do banco");
            System.out.println(" 2 - Acessar dados do cliente");
            System.out.println(" 3 - Voltar ao menu principal");

            int opcao = scanner.nextInt();

            if(opcao == 3){
                break;
            }

            if(opcao == 1){
                utils.imprimirListaClientes(listaClientes);
            }

            if(opcao == 2){
                DadosCliente();
            }
        }
    }

    private void DadosCliente(){
        int tentativas = 1;

        while (true){
            System.out.println("\n Digite nome do cliente");

            String nomeCliente = scanner.next();
            var cliente = listaClientes.get(nomeCliente);

            if(cliente == null){
                System.out.println(nomeCliente + " não encontrado");
                tentativas++;
            }

            if(tentativas > 3){
                System.out.println("\n Voce retornará ao menu anterior");
                break;
            }

            if(cliente != null){
                var voltaMenu = Contas(cliente);

                if(voltaMenu){
                    break;
                }
            }
        }
    }

    private boolean Contas(Contas cliente){

        boolean voltaMenu = false;

        while (true){
            System.out.println("\n Escolha uma das opções abaixo: ");

            System.out.println(" 1 - Resumo contas");
            System.out.println(" 2 - Movimentações");
            System.out.println(" 3 - Voltar ao menu anterior");

            int opcao = scanner.nextInt();

            if(opcao == 3){
                voltaMenu = true;
                break;
            }

            if(opcao == 1){
                utils.imprimirDadosContasPorCliente(cliente);
            }

            if(opcao == 2){
                utils.Movimentacoes(cliente);
            }
        }

        return voltaMenu;
    }

}
