import javax.swing.*;
import java.util.*;
public class MainClassEstatísticas 
{
    public static void main (String args[])
    {
        //Instância da classe abstrata com 10 registros tipo vetor:
        Estatística[] estatística = new Estatística[10];
        
        int x;
        //Execução do método construtor:
        for(x = 0; x < 10; x++)
        {
            estatística[x] = new Estatística();
        }
        int opc = 0;
        while(opc != 9)
        {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Menu Prncipal \n\n 1 - Cadastro Estatística \n 2 - Consulta por quantidade de acidentes \n 3 - Consulta por estatísticas de acidentes \n 4 - Acidentes acima da média das 10 cidades \n 9 - Finalizar"));
            switch(opc)
            {
                case 1: estatística = FCadastra(estatística); //Chamada função
                break;
                
                case 2: PConsultaQnt(estatística); //Chamada procedimento
                break;
                
                case 3: PConsultaEst(estatística); //Chamada procedimento
                break;
                
                case 4: Acima(estatística); //Chamada procedimento
                break;
                
                case 9: JOptionPane.showMessageDialog(null,"Programa finalizado");
                break;
                
                default: JOptionPane.showMessageDialog(null,"Opção Inválida");
            }
        }
    }
    //Função recebendo registro "aluno" e retornando tipo "Estatística[]":
    static Estatística[] FCadastra(Estatística[] estatística)
    {
        Random gerador = new Random();
        int x;
        for(x = 0; x < 10; x++)
        {
            estatística[x].CodigoCidade = gerador.nextInt(10000);
            estatística[x].NomeCidade = JOptionPane.showInputDialog("Digite o nome da cidade:");
            estatística[x].QtdAcidentes = gerador.nextInt(1000);
        }
        return estatística;
    }
    //Procedimento para mostrar quantidade de acidentes > 100 e < 500:
    static void PConsultaQnt(Estatística[] estatística)
    {
        int x;
        System.out.println("As cidades com o numero de acidentes entre 100 e 500 sao:");
        for (x = 0; x < 10; x++)
        {
            if(estatística[x].QtdAcidentes > 100 && estatística[x].QtdAcidentes < 500)
            {
                System.out.println(estatística[x].NomeCidade + "(" + estatística[x].CodigoCidade + ") = " + estatística[x].QtdAcidentes + " acidentes");
            }
        }
    }
    //Procedimento para mostrar o maior e o menor indice de acidendes:
    static void PConsultaEst(Estatística[] estatística)
    {
        int x, maior = 0, menor = 0, y = 0, indiceMA = 0, indiceME = 0;
        for(x = 0; x < 10; x++)
        {
            if(y == 0)
            {
                menor = estatística[x].QtdAcidentes;
                indiceME = x;
                y = 1;
            }
            else if(estatística[x].QtdAcidentes < menor)
            {
                menor = estatística[x].QtdAcidentes;
                indiceME = x;
            }
            else if(estatística[x].QtdAcidentes > maior)
            {
                maior = estatística[x].QtdAcidentes;
                indiceMA = x;
            }
        }
        System.out.println("\n" + estatística[indiceMA].NomeCidade + "(" + estatística[indiceMA].CodigoCidade + ") e a cidade com o maior indice de acidentes (" + maior + " acidentes)\n" + estatística[indiceME].NomeCidade + "(" + estatística[indiceME].CodigoCidade + ") e a cidade com o menor indice de acidentes (" + menor + " acidentes)\n");
    }
    //Procedimento para as cidades com quantidade de acidentes acima da média:
    static void Acima(Estatística[] estatística)
    {
        int x, media = 0;
        for(x = 0; x < 10; x++)
        {
            media = media + estatística[x].QtdAcidentes;
        }
        media = media / 10;
        System.out.println("As cidades com a taxa de acidentes acima da media(" + media + ") sao:");
        for(x = 0; x < 10; x++)
        {
            if(estatística[x].QtdAcidentes > media)
            {
                System.out.println(estatística[x].NomeCidade + "(" + estatística[x].CodigoCidade + ") = " + estatística[x].QtdAcidentes + " acidentes");
            }
        }
    }
}
