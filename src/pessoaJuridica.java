public class pessoaJuridica extends Cliente{

    String cnpj;
    int numFuncionarios;
    String setor;

    public void imprimir(){
        System.out.println("CNPJ: " + cnpj + " Numero de funcionarios: " + numFuncionarios + " Setor: " + setor);
    }
}
