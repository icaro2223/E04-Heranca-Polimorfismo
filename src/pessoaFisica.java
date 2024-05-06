public class pessoaFisica extends Cliente{

    String cpf;
    int idade;
    char sexo;

    public void imprimir(){
        System.out.println("Cpf: " + cpf + " idade: " + idade + " sexo: " + sexo);
    }
}
