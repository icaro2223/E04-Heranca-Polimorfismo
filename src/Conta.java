import java.util.*;
public class Conta {

    private int NumConta; // Número da conta
    private Cliente DonoConta; // Objeto Cliente que é o dono da conta
    private double SaldoConta; // Saldo da conta
    private double LimiteConta; // Limite da conta
    private Operacao[] operacoes;
    private int proximaOperacao;
    private static int totalContas = 0;


    // Construtor padrão da classe Conta
    public Conta(int numero, Cliente dono, double saldo, double limite) {
        this.NumConta = numero; // Inicializa o número da conta com -1
        this.DonoConta = dono; // Instanciando um novo objeto Cliente
        this.SaldoConta = saldo; // Inicializa o saldo como 0
        this.LimiteConta = limite; // Inicializa o limite como 0
        this.operacoes = new Operacao[1000];
        this.proximaOperacao = 0;
        Conta.totalContas++;
    }

    // Classe interna Operacao
    public class Operacao {
        private Date data;
        private char tipo;
        private double valor;


        public Operacao(char tipo, double valor) {
            this.tipo = tipo;
            this.valor = valor;
            data = new Date();
        }
        public void imprimir() {
            System.out.println("Tipo: " + tipo + ", Valor: " + valor + ", Data: " + data);
        }
    }
    public void AdicionaOperacao(char tipo, double valor) {
        // Encontrar a primeira posição vazia no array
        int indiceVazio = 0;
        while (indiceVazio < operacoes.length && operacoes[indiceVazio] != null) {
            indiceVazio++;
        }


        // Adicionar uma nova operação na primeira posição vazia encontrada
        if (indiceVazio < operacoes.length) {
            operacoes[indiceVazio] = new Operacao(tipo, valor);
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
    public void imprimir(Conta contaQualquer) {
        System.out.println(contaQualquer.NumConta); // Imprime o número da conta
        System.out.println(contaQualquer.DonoConta.Nome); // Imprime o nome do dono da conta
        System.out.println(contaQualquer.SaldoConta); // Imprime o saldo da conta
        System.out.println(contaQualquer.LimiteConta); // Imprime o limite da conta
    }


    public void imprimirExtrato() {
        System.out.println("======= Extrato Conta " + this.NumConta + "======");
        for(int i = 0; i < proximaOperacao; i++) {
            operacoes[i].imprimir();
        }
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
