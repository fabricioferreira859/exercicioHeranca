package heranca_2;

import entidades.Pessoa;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Heranca_2 {

   
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        List<Pessoa> pessoas = new ArrayList<>();
        
        System.out.print("Digite o número de pessoas: ");
        int num = sc.nextInt();
        
        for(int i = 1; i <= num; i++){
            System.out.println("\n--------- Pessoa "+i+" ---------");
            System.out.print("Pessoa física ou jurídica? f/j: ");
            char ch = sc.next().charAt(0);
            System.out.print("\nNome: ");
            String nome = sc.next();
            System.out.print("Renda anual: ");
            double renda = sc.nextDouble();
            
            if(ch == 'f'){
                System.out.print("Gastos com saúde: ");
                double gastos = sc.nextDouble();
                
                Pessoa p1 = new PessoaFisica(gastos, nome, renda);
                pessoas.add(p1);
            }
            else{
                System.out.print("Número funcionários: ");
                int numeroFuncionarios = sc.nextInt();
                
                Pessoa p2 = new PessoaJuridica(numeroFuncionarios, nome, renda);
                pessoas.add(p2);
            }
            
        }
        
        double total = 0;
        System.out.println("\n\n======================================================");
        System.out.println("                       Tabela\n");
        for(Pessoa pss: pessoas){
            System.out.println(pss.exibirResultados());
            total += pss.valorImposto();
        }
            
        System.out.println("======================================================");
        System.out.println("Total impostos: "+String.format("R$ %.2f", total));
        System.out.println("======================================================");
    }
    
}
