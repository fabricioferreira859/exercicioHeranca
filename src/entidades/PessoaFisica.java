package entidades;

public class PessoaFisica extends Pessoa{

    private Double gastosSaude;
    
    public PessoaFisica(){
        super();
    }

    public PessoaFisica(Double gastosSaude, String nome, Double rendaAnual) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    
    public Double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(Double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }
    
    
    @Override
    public double valorImposto() {
        double imp = 0;
        
        if(getRendaAnual() < 2000.0 && gastosSaude == 0){
            imp = (getRendaAnual() * 15)/100;
        }
        
        else if(getRendaAnual() < 2000.0 && gastosSaude > 0){
            imp = ((getRendaAnual() * 15)/100) - (gastosSaude * 0.5);
        }
        
        else if (getRendaAnual() >= 2000.0 && gastosSaude > 0){
            imp = ((getRendaAnual() * 25)/100) - (gastosSaude * 0.5);
        }
        
        else{
            imp = (getRendaAnual() * 25)/100;
        }
        
        return imp;
    }
    
    @Override
    public String exibirResultados(){
        return "Nome: "+getNome()
               +"\tValor imposto: R$ "+String.format("%.2f", valorImposto());      
    }
    
}
