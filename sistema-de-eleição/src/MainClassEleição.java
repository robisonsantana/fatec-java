import javax.swing.JOptionPane;
import java.io.*;
public class MainClassEleição 
{
    public static void main(String args[]) throws IOException
    {
        Eleitor[] eleitor = new Eleitor[10];
        Eleitor[] todos = new Eleitor[10];
        Eleição[] eleição = new Eleição[10];
        Eleição[] apuração = new Eleição[10];
        MetodosEleição metodos = new MetodosEleição();
        
        int opc1 = 0;
        while(opc1 != 9)
        {
            opc1 = Integer.parseInt(JOptionPane.showInputDialog("MENU PRINCIPAL \n\n 1 - Cadastrar Eleitor \n 2 - Cadastrar Eleição 1 e 2 \n 3 - Agrupar Apuração \n 4 - Menu Estatística \n 9 - Finalizar")); 
            switch(opc1)
            {
                case(1): metodos.FCadastrarEleitor(eleitor);
                break;
                
                case(2):
                    int opc2 = 0;
                    while(opc2 != 9)
                    {
                        opc2 = Integer.parseInt(JOptionPane.showInputDialog("CADASTRO VOTAÇÃO 1 E 2 \n\n 1 - Cadastrar Votação 1 \n 2 - Cadastrar Votação 2 \n 9 - Finalizar"));
                        switch(opc2)
                        {
                            case(1): metodos.FCadastrarEleição1(eleição, eleitor);
                            break;
                            
                            case(2): metodos.FCadastrarEleição2(eleição, eleitor);
                            break;
                            
                            case(9): JOptionPane.showMessageDialog(null, "Cadastro Finalizado!");
                            break;
                            
                            default: JOptionPane.showMessageDialog(null, "Número Inválido!");
                        }
                    }
                break;
                
                case(3): metodos.FApuração(eleição, apuração);
                break;
                
                case(4):
                    int opc3 = 0;
                    while(opc3 != 9)
                    {
                        opc3 = Integer.parseInt(JOptionPane.showInputDialog("MENU ESTATÍSTICA \n\n 1 - Vencedor \n 2 - Segundo Colocado \n 3 - Quantidade de votos brancos \n 4 - Quantidade de votos nulos \n 5 - Mostrar Eleitores \n 6 - Mostrar Apuração \n 9 - Finalizar"));
                        switch(opc3)
                        {
                            case(1): metodos.PVencedor(apuração);
                            break;
                            
                            case(2): metodos.PSegundoColocado(apuração);
                            break;
                            
                            case(3): metodos.PVotosBrancos(apuração);
                            break;
                            
                            case(4): metodos.PVotosNulos(apuração);
                            break;
                            
                            case(5): metodos.PMostrarEleitores(eleitor, todos);
                            break;
                            
                            case(6): metodos.PMostrarApuração(apuração);
                            break;
                            
                            case(9): JOptionPane.showMessageDialog(null, "Consulta Finalizada!");
                            break;
                            
                            default: JOptionPane.showMessageDialog(null, "Número Inválido!");
                        }
                    }
                break;
                
                case(9): JOptionPane.showMessageDialog(null, "Programa Finalizado!");
                break;
                
                default: JOptionPane.showMessageDialog(null, "Número Inválido!");
            }
        }
    }
}