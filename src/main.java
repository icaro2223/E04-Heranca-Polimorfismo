import java.util.*;
public class main {
    public static void main(String[] args) {


        // Criando instâncias das contas
        Scanner entrada = new Scanner(System.in);


        Conta conta1 = new Conta(1,null, 10000, 20000);
        Conta conta2 = new Conta(2, null, 5000, 10000);


        // Criando instâncias dos clientes e associando às contas
        Cliente cliente1 = new Cliente();
        cliente1.Nome = "Icaro";
        conta1.setdonoConta(cliente1);


        Cliente cliente2 = new Cliente();
        cliente2.Nome = "Maria";
        conta2.setdonoConta(cliente2);

        // Imprimindo saldo e dono da conta de Icaro
        System.out.println(conta1.getSaldoConta());
        System.out.println(conta1.getDonoConta());



        System.out.println();


        // Definindo os detalhes das contas
        conta1.setNumero(15);
        conta1.setdonoConta(cliente1);
        conta1.setSaldo(20000);
        conta1.setLimite(25000.0);


        conta2.setNumero(25);
        conta2.setdonoConta(cliente2);
        conta2.getSaldoConta();



        conta2.setLimiteConta(45000.0);


        if(conta1.setNumConta() == conta2.setNumConta()){
            System.out.println("Sao iguais!");


        }else{
            System.out.println("Sao diferentes!");
        }


        // Imprimindo detalhes das contas
        System.out.println("Dono da conta 1: " + conta1.getDonoConta());
        System.out.println("Dono da conta 2: " + conta2.getDonoConta());


        System.out.println("Saldo icaro: " + conta1.getSaldoConta());
        System.out.println("Saldo Maria: " + conta1.getSaldoConta());


        System.out.println();


        // Realizando operações na conta de Icaro
        conta1.deposito(700.0);
        System.out.println("Novo saldo: " + conta1.getSaldoConta());


        boolean saqueRealizado = conta1.saque(800);


        if(saqueRealizado){
            System.out.println("Saque realizado com sucesso!");
            System.out.printf("Sacando %d reais...\n", 800);
            System.out.println("novo Saldo: " + conta1.getSaldoConta());
        }else{
            System.out.println("Nao foi possivel fazer o saque!");
        }


        System.out.println();


        // Transferindo valor da conta de Icaro para a conta de Maria
        conta1.transferir(conta1, 3100);
        System.out.println("Saldo de conta 1: " + conta1.getSaldoConta());
        System.out.println("Novo saldo de conta 2: " + conta2.getSaldoConta());


        // Imprimindo detalhes da conta 1
        conta1.imprimir(conta1);


        conta1.deposito(1780.0);
        conta1.deposito(600.0);
        conta1.saque(400.0);
        conta1.saque(1780.0);
        conta1.deposito(150.0);

        System.out.println("Qual conta? I = icaro || M = Maria");
        char letra = entrada.next().charAt(0);

        if(letra == 'I'){
            System.out.println("Imprimindo extrato da conta de Icaro:");
            conta1.ImprimirExtrato(conta1.operacoes);
        }if(letra == 'M'){
            System.out.println("Imprimindo extrato da conta de Maria:");
            conta1.ImprimirExtrato(conta1.operacoes);
        }

    }
}
