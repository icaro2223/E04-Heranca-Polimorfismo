import java.util.*;
public class Conta {

    private int NumConta; // Número da conta
    private Cliente DonoConta; // Objeto Cliente que é o dono da conta
    private double SaldoConta; // Saldo da conta
    private double LimiteConta; // Limite da conta
    private Operacao[] operacao;
    private operacaoDeposito[] operacoes;
    private operacaoSaque[] Operacoes;
    private int proximaOperacao;
    private static int totalContas = 0;


    // Construtor padrão da classe Conta
    public Conta(int numero, Cliente dono, double saldo, double limite) {
        this.NumConta = numero; // Inicializa o número da conta com -1
        this.DonoConta = dono; // Instanciando um novo objeto Cliente
        this.SaldoConta = saldo; // Inicializa o saldo como 0
        this.LimiteConta = limite; // Inicializa o limite como 0
        this.operacao = new Operacao[1000];
        this.operacoes = new operacaoDeposito[1000];
        this.Operacoes = new operacaoSaque[1000];
        this.proximaOperacao = 0;
        Conta.totalContas++;
    }

    Scanner entrada = new Scanner(System.in);
    public void AdicionaOperacao(char tipo, double valor) {

        // Encontrar a primeira posição vazia no array
        int indiceVazio = 0;
        while (indiceVazio < operacoes.length && operacoes[indiceVazio] != null) {
            indiceVazio++;
        }
        // Adicionar uma nova operação na primeira posição vazia encontrada
        if (indiceVazio < operacoes.length) {
            operacao[indiceVazio] = new Operacao(tipo, valor);
        } else {
            System.out.println("Não há espaço suficiente para adicionar mais operações.");
        }
    }

    // Método para realizar um depósito
    public void deposito(double valor) {
        this.SaldoConta = this.SaldoConta + valor; // Adiciona o valor ao saldo
        AdicionaOperacao('d', valor);
    }


    // Método para realizar um saque
    public boolean saque(double valor) {
        if (valor <= this.SaldoConta) { // Verifica se há saldo suficiente para o saque
            this.SaldoConta = this.SaldoConta - valor;
            AdicionaOperacao('s', valor);// Subtrai o valor do saldo
            return true; // Retorna verdadeiro indicando que o saque foi realizado com sucesso
        } else {
            return false; // Retorna falso indicando que o saque não foi possível
        }
    }


    // Método para transferir um valor para outra conta
    public boolean transferir(Conta contaDestino, double valor) {
        boolean retirar = this.saque(valor); // Tenta realizar o saque na conta de origem
        if (retirar && this != contaDestino) { // Se o saque foi realizado com sucesso
            contaDestino.deposito(valor); // Deposita o valor na conta de destino
            return true; // Retorna verdadeiro indicando que a transferência foi realizada com sucesso
        } else {
            return false; // Retorna falso indicando que a transferência não foi possível
        }
    }

    // Método para imprimir os detalhes de uma conta

    public void imprimir() {
        System.out.println("======= Extrato Conta " + this.NumConta + " ======");

            System.out.println("Numero da conta: " + NumConta + " Dono da conta: " + DonoConta.Nome + " Saldo: " + SaldoConta + " Limite: " + LimiteConta);

        System.out.println("====================");
    }

    public int getNumConta() {
        return this.NumConta;
    }

    public Cliente getDonoConta() {
        return this.DonoConta;
    }

    public double getSaldoConta() {
        return this.SaldoConta;
    }

    public double getLimiteConta() {
        return this.LimiteConta;
    }

    public static int getTotalContas() {
        return Conta.totalContas;
    }
    public void setdonoConta(Cliente dono){
        this.DonoConta = dono;
    }
    public void setNumero(int numero) {
        this.NumConta = numero;
    }

    public void setDono(Cliente dono) {
        this.DonoConta = dono;
    }
    public void setSaldo(double saldo) {
        this.SaldoConta= saldo;
    }

    public void setLimite(double limite) {
        if (limite < 0)
            limite = 0;

        this.LimiteConta = limite;
    }

}
