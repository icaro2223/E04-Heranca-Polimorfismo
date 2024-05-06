import java.util.Date;
public class Operacao{

    private Date data;
    private char tipo;
    private double valor;


    public Operacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        data = new Date();
    }
    public void imprimirExtrato() {
        System.out.println("Tipo: " + tipo + ", Valor: " + valor + ", Data: " + data);
    }
}
