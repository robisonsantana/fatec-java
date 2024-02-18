import java.util.*;
import java.io.*;
import javax.swing.*;
public class MetodosEleição 
{
    public Eleitor[] FCadastrarEleitor(Eleitor[] eleitor) throws IOException
    {
        Random generator = new Random();
        int i;
        String fileName = "CadastroEleitor1.txt";
        String FileName = "CadastroEleitor2.txt";
        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));
        BufferedWriter record = new BufferedWriter(new FileWriter(FileName));
        
        for(i = 0; i < 10; i++)
        {
            eleitor[i] = new Eleitor();
        }
        
        for(i = 0; i < 5; i++)
        {
            eleitor[i].NumeroEleitor = i;
            gravar.write(Integer.toString(eleitor[i].NumeroEleitor));
            gravar.newLine();
            
            eleitor[i].NomeEleitor = JOptionPane.showInputDialog("Digite o nome do eleitor:");
            gravar.write(eleitor[i].NomeEleitor);
            gravar.newLine();
            
            while(eleitor[i].Seção != 1 && eleitor[i].Seção != 3 && eleitor[i].Seção != 4)
            {
                eleitor[i].Seção = generator.nextInt(5);
            }
            gravar.write(Integer.toString(eleitor[i].Seção));
            gravar.newLine();
        }
        
        for(i = 5; i < 10; i++)
        {
            eleitor[i].NumeroEleitor = i;
            record.write(Integer.toString(eleitor[i].NumeroEleitor));
            record.newLine();
            
            eleitor[i].NomeEleitor = JOptionPane.showInputDialog("Digite o nome do eleitor:");
            record.write(eleitor[i].NomeEleitor);
            record.newLine();
            
            while(eleitor[i].Seção != 5 && eleitor[i].Seção != 9 && eleitor[i].Seção != 10)
            {
                eleitor[i].Seção = generator.nextInt(11);
            }
            record.write(Integer.toString(eleitor[i].Seção));
            record.newLine();
        }
        System.out.println("CADASTRO DO ELEITOR FEITO COM SUCESSO!");
        gravar.close();
        record.close();
        return eleitor;
    }
    public Eleição[] FCadastrarEleição1(Eleição[] eleição, Eleitor[] eleitor) throws IOException
    {
        Random generator = new Random();
        int i;
        String fileName = "ArquivoEleição1.txt";
        String FileName = "CadastroEleitor1.txt";
        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));
        BufferedReader ler = new BufferedReader(new FileReader(FileName));
        
        for(i = 0; i < 5; i++)
        {
            eleitor[i] = new Eleitor();
        }
        
        for(i = 0; i < 5; i++)
        {
            eleitor[i].NumeroEleitor = Integer.parseInt(ler.readLine());
            eleitor[i].NomeEleitor = ler.readLine();
            eleitor[i].Seção = Integer.parseInt(ler.readLine());
        }
        
        for(i = 0; i < 5; i++)
        {
            eleição[i] = new Eleição();
        }
        
        for(i = 0; i < 5; i ++)
        {
            eleição[i].Seção = eleitor[i].Seção;
            gravar.write(Integer.toString(eleição[i].Seção));
            gravar.newLine();
            
            eleição[i].CodCandidato = generator.nextInt(4) + 1;
            gravar.write(Integer.toString(eleição[i].CodCandidato));
            gravar.newLine();
            
            eleição[i].NumEleitor = eleitor[i].NumeroEleitor;
            gravar.write(Integer.toString(eleição[i].NumEleitor));
            gravar.newLine();
        }
        System.out.println("VOTACAO 1 APURADA COM SUCESSO!");
        gravar.close();
        return eleição;
    }
    public Eleição[] FCadastrarEleição2(Eleição[] eleição, Eleitor[] eleitor) throws IOException
    {
        Random generator = new Random();
        int i;
        String fileName = "ArquivoEleição2.txt";
        String FileName = "CadastroEleitor2.txt";
        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));
        BufferedReader ler = new BufferedReader(new FileReader(FileName));
        
        for(i = 0; i < 5; i++)
        {
            eleitor[i] = new Eleitor();
        }
        
        for(i = 0; i < 5; i++)
        {
            eleitor[i].NumeroEleitor = Integer.parseInt(ler.readLine());
            eleitor[i].NomeEleitor = ler.readLine();
            eleitor[i].Seção = Integer.parseInt(ler.readLine());
        }
        
        for(i = 0; i < 5; i++)
        {
            eleição[i] = new Eleição();
        }
        
        for(i = 0; i < 5; i ++)
        {
            if(eleição[i].Seção != 1 && eleição[i].Seção != 3 && eleição[i].Seção != 4)
            {
                eleição[i].Seção = eleitor[i].Seção;
                gravar.write(Integer.toString(eleição[i].Seção));
                gravar.newLine();

                eleição[i].CodCandidato = generator.nextInt(4) + 1;
                gravar.write(Integer.toString(eleição[i].CodCandidato));
                gravar.newLine();

                eleição[i].NumEleitor = eleitor[i].NumeroEleitor;
                gravar.write(Integer.toString(eleição[i].NumEleitor));
                gravar.newLine();
            }
        }
        System.out.println("VOTACAO 2 APURADA COM SUCESSO!");
        gravar.close();
        return eleição;
    }
    public Eleição[] FApuração(Eleição[] eleição, Eleição[] apuração) throws IOException
    {
        int i;
        String FileName = "ArquivoEleição1.txt";
        String fileName = "ArquivoEleição2.txt";
        String Filename = "Apuração.txt";
        BufferedReader ler = new BufferedReader(new FileReader(FileName));
        BufferedReader read = new BufferedReader(new FileReader(fileName));
        BufferedWriter gravar = new BufferedWriter(new FileWriter(Filename));
        
        for(i = 0; i < 10; i++)
        {
            eleição[i] = new Eleição();
        }
        for(i = 0; i < 10; i++)
        {
            apuração[i] = new Eleição();
        }
        
        for(i = 0; i < 5; i++)
        {
            eleição[i].Seção = Integer.parseInt(ler.readLine());
            eleição[i].CodCandidato = Integer.parseInt(ler.readLine());
            eleição[i].NumEleitor = Integer.parseInt(ler.readLine());
        }
        for(i = 0; i < 5; i++)
        {
            apuração[i].Seção = eleição[i].Seção;
            apuração[i].CodCandidato = eleição[i].CodCandidato;
            apuração[i].NumEleitor = eleição[i].NumEleitor;
        }
        
        for(i = 0; i < 5; i++)
        {
            eleição[i].Seção = Integer.parseInt(read.readLine());
            eleição[i].CodCandidato = Integer.parseInt(read.readLine());
            eleição[i].NumEleitor = Integer.parseInt(read.readLine());
        }
        for(i = 0; i < 5; i++)
        {
            apuração[i + 5].Seção = eleição[i].Seção;
            apuração[i + 5].CodCandidato = eleição[i].CodCandidato;
            apuração[i + 5].NumEleitor = eleição[i].NumEleitor;
        }
        
        for(i = 0; i < 10; i++)
        {
            gravar.write(Integer.toString(apuração[i].Seção));
            gravar.newLine();
            gravar.write(Integer.toString(apuração[i].CodCandidato));
            gravar.newLine();
            gravar.write(Integer.toString(apuração[i].NumEleitor));
            gravar.newLine();
        }
        System.out.println("APURACAO FEITA COM SUCESSO!");
        gravar.close();
        return apuração;
    }
    public void PVencedor(Eleição[] apuração) throws IOException
    {
        int i;
        String FileName = "Apuração.txt";
        BufferedReader ler = new BufferedReader(new FileReader(FileName));
        
        for(i = 0; i < 10; i++)
        {
            apuração[i] = new Eleição();
        }
        for(i = 0; i < 10; i++)
        {
            apuração[i].Seção = Integer.parseInt(ler.readLine());
            apuração[i].CodCandidato = Integer.parseInt(ler.readLine());
            apuração[i].NumEleitor = Integer.parseInt(ler.readLine());
        }
        int jose = 0, maria = 0;
        for(i = 0; i < 10; i++)
        {
            if(apuração[i].CodCandidato == 1)
            {
                jose = jose + 1;
            }
            else if(apuração[i].CodCandidato == 2)
            {
                maria = maria + 1;
            }
        }
        if(jose > maria)
        {
            System.out.println("JOSE FOI O VENCEDOR COM " + jose + " VOTO(S).");
        }
        else if(jose < maria)
        {
            System.out.println("MARIA FOI A VENCEDORA COM " + maria + " VOTO(S).");
        }
        else
        {
            System.out.println("EMPATE.");
        }
    }
    public void PSegundoColocado(Eleição[] apuração) throws IOException
    {
        int i;
        String FileName = "Apuração.txt";
        BufferedReader ler = new BufferedReader(new FileReader(FileName));
        
        for(i = 0; i < 10; i++)
        {
            apuração[i] = new Eleição();
        }
        for(i = 0; i < 10; i++)
        {
            apuração[i].Seção = Integer.parseInt(ler.readLine());
            apuração[i].CodCandidato = Integer.parseInt(ler.readLine());
            apuração[i].NumEleitor = Integer.parseInt(ler.readLine());
        }
        int jose = 0, maria = 0;
        for(i = 0; i < 10; i++)
        {
            if(apuração[i].CodCandidato == 1)
            {
                jose = jose + 1;
            }
            else if(apuração[i].CodCandidato == 2)
            {
                maria = maria + 1;
            }
        }
        if(jose < maria)
        {
            System.out.println("JOSE FOI O SEGUNDO COLOCADO COM " + jose + " VOTO(S).");
        }
        else if(jose > maria)
        {
            System.out.println("MARIA FOI A SEGUNDA COLOCADA COM " + maria + " VOTO(S).");
        }
        else
        {
            System.out.println("EMPATE.");
        }
        ler.close();
    }
    public void PVotosBrancos(Eleição[] apuração) throws IOException
    {
        int i;
        String FileName = "Apuração.txt";
        BufferedReader ler = new BufferedReader(new FileReader(FileName));
        
        for(i = 0; i < 10; i++)
        {
            apuração[i] = new Eleição();
        }
        for(i = 0; i < 10; i++)
        {
            apuração[i].Seção = Integer.parseInt(ler.readLine());
            apuração[i].CodCandidato = Integer.parseInt(ler.readLine());
            apuração[i].NumEleitor = Integer.parseInt(ler.readLine());
        }
        
        int brancos = 0;
        for(i = 0; i < 10; i++)
        {
            if(apuração[i].CodCandidato == 3)
            {
                brancos = brancos + 1;
            }
        }
        System.out.println("A QUANTIDADE DE VOTOS BRANCOS FOI DE " + brancos + " VOTO(S).");
        ler.close();
    }
    public void PVotosNulos(Eleição[] apuração) throws IOException
    {
        int i;
        String FileName = "Apuração.txt";
        BufferedReader ler = new BufferedReader(new FileReader(FileName));
        
        for(i = 0; i < 10; i++)
        {
            apuração[i] = new Eleição();
        }
        for(i = 0; i < 10; i++)
        {
            apuração[i].Seção = Integer.parseInt(ler.readLine());
            apuração[i].CodCandidato = Integer.parseInt(ler.readLine());
            apuração[i].NumEleitor = Integer.parseInt(ler.readLine());
        }
        
        int nulos = 0;
        for(i = 0; i < 10; i++)
        {
            if(apuração[i].CodCandidato == 4)
            {
                nulos = nulos + 1;
            }
        }
        System.out.println("A QUANTIDADE DE VOTOS NULOS FOI DE " + nulos + " VOTO(S).");
        ler.close();
    }
    public void PMostrarEleitores(Eleitor[] eleitor, Eleitor[] todos) throws IOException
    {
        int i;
        String FileName = "CadastroEleitor1.txt";
        String fileName = "CadastroEleitor2.txt";
        String filename = "CadastroEleitor.txt";
        BufferedReader ler = new BufferedReader(new FileReader(FileName));
        BufferedReader read = new BufferedReader(new FileReader(fileName));
        BufferedWriter gravar = new BufferedWriter(new FileWriter(filename));
        
        for(i = 0; i < 10; i++)
        {
            eleitor[i] = new Eleitor();
        }
        for(i = 0; i < 10; i++)
        {
            todos[i] = new Eleitor();
        }
        for(i = 0; i < 5; i++)
        {
            eleitor[i].NumeroEleitor = Integer.parseInt(ler.readLine());
            eleitor[i].NomeEleitor = ler.readLine();
            eleitor[i].Seção = Integer.parseInt(ler.readLine());
        }
        for(i = 0; i < 5; i++)
        {
            todos[i].NumeroEleitor = eleitor[i].NumeroEleitor;
            todos[i].NomeEleitor = eleitor[i].NomeEleitor;
            todos[i].Seção = eleitor[i].Seção;
        }
        for(i = 0; i < 5; i++)
        {
            eleitor[i].NumeroEleitor = Integer.parseInt(read.readLine());
            eleitor[i].NomeEleitor = read.readLine();
            eleitor[i].Seção = Integer.parseInt(read.readLine());
        }
        for(i = 0; i < 5; i++)
        {
            todos[i + 5].NumeroEleitor = eleitor[i].NumeroEleitor;
            todos[i + 5].NomeEleitor = eleitor[i].NomeEleitor;
            todos[i + 5].Seção = eleitor[i].Seção;
        }
        int x, aux;
        String auxS;
        for(i = 0; i < 10; i++)
        {
            for(x = i + 1; x < 10; x++)
            {
                if(todos[i].Seção > todos[x].Seção)
                {
                    aux = todos[i].Seção;
                    todos[i].Seção = todos[x].Seção;
                    todos[x].Seção = aux;
                    
                    auxS = todos[i].NomeEleitor;
                    todos[i].NomeEleitor = todos[x].NomeEleitor;
                    todos[x].NomeEleitor = auxS;
                    
                    aux = todos[i].NumeroEleitor;
                    todos[i].NumeroEleitor = todos[x].NumeroEleitor;
                    todos[x].NumeroEleitor = aux;
                }
            }
        }
        for(i = 0; i < 10; i++)
        {
            gravar.write(Integer.toString(todos[i].NumeroEleitor));
            gravar.newLine();
            gravar.write(todos[i].NomeEleitor);
            gravar.newLine();
            gravar.write(Integer.toString(todos[i].Seção));
            gravar.newLine();
        }
        System.out.println("\nELEITORES CADASTRADOS:");
        for(i = 0; i < 10; i++)
        {
            System.out.println("SECAO " + todos[i].Seção + ": " + todos[i].NomeEleitor + "(NUMERO " + todos[i].NumeroEleitor + ")");
        }
        gravar.close();
        ler.close();
        read.close();
    }
    public void PMostrarApuração(Eleição[] apuração) throws IOException
    {
        int i;
        String FileName = "Apuração.txt";
        BufferedReader ler = new BufferedReader(new FileReader(FileName));
        
        for(i = 0; i < 10; i++)
        {
            apuração[i] = new Eleição();
        }
        for(i = 0; i < 10; i++)
        {
            apuração[i].Seção = Integer.parseInt(ler.readLine());
            apuração[i].CodCandidato = Integer.parseInt(ler.readLine());
            apuração[i].NumEleitor = Integer.parseInt(ler.readLine());
        }
        
        int x, aux;
        for(i = 0; i < 9; i++)
        {
            for(x = i + 1; x < 10; x++)
            {
                if(apuração[i].Seção > apuração[x].Seção)
                {
                    aux = apuração[i].Seção;
                    apuração[i].Seção = apuração[x].Seção;
                    apuração[x].Seção = aux;
                    
                    aux = apuração[i].CodCandidato;
                    apuração[i].CodCandidato = apuração[x].CodCandidato;
                    apuração[x].CodCandidato = aux;
                    
                    aux = apuração[i].NumEleitor;
                    apuração[i].NumEleitor = apuração[x].NumEleitor;
                    apuração[x].NumEleitor = aux;
                }
            }
        }
        System.out.println("\nAPURACAO DOS VOTOS:");
        for(i = 0; i < 10; i++)
        {
            System.out.println("SECAO " + apuração[i].Seção + ": CANDIDATO DE NUMERO " + apuração[i].CodCandidato + " GANHOU 1 VOTO DO ELEITOR NUMERO " + apuração[i].NumEleitor + ".");
        }
        ler.close();
    }
}