import javax.swing.*;
import java.io.IOException;
public class MainClassVotacao 
{
    public static void main(String args[]) throws IOException
    {
        Votacao[] votacao = new Votacao[200];
        MetodosVotacao metodos = new MetodosVotacao();
    
        int opc = 0;
        while(opc != 9)
        {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Sistema de Votação \n\n 1 - Carregar Seção/Número Eleitor \n 2 - Classificar por Seção \n 3 - Gravar Registros \n 4 - Mostrar Indicadores \n 9 - Finalizar"));
            switch(opc)
            {
                case(1): metodos.FCadastrarVotacao(votacao);
                break;
                
                case(2): metodos.FClassificarSecao(votacao);
                break;
                
                case(3): metodos.FGravarVotacao(votacao);
                break;
                
                case(4):
                    int opc2 = 0;
                    while(opc2 != 9)
                    {
                        opc2 = Integer.parseInt(JOptionPane.showInputDialog("Mostrar Indicadores \nEstatísticas de Votação \n\n 1 - Quantidade Eleitores por Seção \n 2 - Seção com Maior e Menor número de Eleitores \n 3 - Quantidade de votos por candidato \n 4 - 10 primeiros colocadas (nro cand. e qtd votos) \n 9 - Finalizar consulta"));
                        switch(opc2)
                        {
                            case(1): metodos.PQntdEleitores(votacao);
                            break;
                            
                            case(2): metodos.PMaiorMenor(votacao);
                            break;
                            
                            case(3): metodos.PQntdVotos(votacao);
                            break;
                            
                            case(4): metodos.PMaisVotados(votacao);
                            break;
                            
                            case(9): JOptionPane.showMessageDialog(null, "Consulta Finalizada!");
                            break;
                            
                            default: JOptionPane.showMessageDialog(null, "Opção Inválida!");
                        }
                    }
                break;
                
                case(9): JOptionPane.showMessageDialog(null, "Programa Finalizado!");
                break;
                
                default: JOptionPane.showMessageDialog(null, "Opção Inválida!");
            }
        }
    }
}