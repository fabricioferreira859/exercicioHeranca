package entidades;

public class PessoaJuridica extends Pessoa{

    private Integer numeroFuncionarios;
    
    public PessoaJuridica(){
        super();
    }

    public PessoaJuridica(Integer numeroFuncionarios, String nome, Double rendaAnual) {
        super(nome, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(Integer numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }
    
    @Override
    public double valorImposto() {
        double imp = 0;
        
        if(numeroFuncionarios <= 10){
            imp = (getRendaAnual() * 16)/100;
        }
        else{
            imp = (getRendaAnual() * 14)/100;
        }
        
        return imp;
    }
    
    @Override
    public  String exibirResultados(){
        return "Nome: "+getNome()
               +"\tValor imposto: R$ "+String.format("%.2f", valorImposto());
    }
    
}
