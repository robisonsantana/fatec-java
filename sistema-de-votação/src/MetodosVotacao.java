import java.io.*;
import java.util.*;
public class MetodosVotacao 
{
    int posicao[] = new int[11];
    int candidato[] = new int[300];
    public Votacao[] FCadastrarVotacao(Votacao[] votacao) throws IOException
    {
        Random generator = new Random();
        int i;
        for(i = 0; i < 200; i++)
        {
            votacao[i] = new Votacao();
        }
        
        for(i = 0; i < 200; i++)
        {
            votacao[i].NumeroSecao = generator.nextInt(10) + 1;
            votacao[i].NumeroCandidato = generator.nextInt(300);
        }
        System.out.println("VOTACAO CADASTRADA!");
        return votacao;
    }
    public Votacao[] FClassificarSecao(Votacao[] votacao) throws IOException
    {
        int i, x, aux;
        for(i = 0; i < 199; i++)
        {
            for(x = i + 1; x < 200; x++)
            {
                if(votacao[i].NumeroSecao > votacao[x].NumeroSecao)
                {
                    aux = votacao[i].NumeroSecao;
                    votacao[i].NumeroSecao = votacao[x].NumeroSecao;
                    votacao[x].NumeroSecao = aux;
                    
                    aux = votacao[i].NumeroCandidato;
                    votacao[i].NumeroCandidato = votacao[x].NumeroCandidato;
                    votacao[x].NumeroCandidato = aux;
                }
            }
        }
        System.out.println("VOTACAO CLASSIFICADA!");
        return votacao;
    }
    public Votacao[] FGravarVotacao(Votacao[] votacao) throws IOException
    {
        int i;
        String fileName = "ArquivoVotacao.txt";
        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));
        
        for(i = 0; i < 200; i++)
        {
            gravar.write(Integer.toString(votacao[i].NumeroSecao));
            gravar.newLine();
            
            gravar.write(Integer.toString(votacao[i].NumeroCandidato));
            gravar.newLine();
        }
        System.out.println("GRACACAO FEITA COM SUCESSO!");
        gravar.close();
        return votacao;
    }
    public void PQntdEleitores(Votacao[] votacao) throws IOException
    {
        int i;
        String fileName = "ArquivoVotacao.txt";
        BufferedReader ler = new BufferedReader(new FileReader(fileName));
        String FileName = "ArquivoVotacaoSecoes.txt";
        BufferedWriter gravar = new BufferedWriter(new FileWriter(FileName));
        
        for(i = 0; i < 200; i++)
        {
            votacao[i] = new Votacao();
        }
        
        for(i = 0; i < 200; i++)
        {
            votacao[i].NumeroSecao = Integer.parseInt(ler.readLine());
            votacao[i].NumeroCandidato = Integer.parseInt(ler.readLine());
        }
        
        for(i = 0; i < 200; i++)
        {
            posicao[votacao[i].NumeroSecao - 1]++;
        }
        System.out.println("\nA quantidade de votos em cada secao foi:");
        for(i = 0; i < 10; i++)
        {
            gravar.write(Integer.toString(posicao[i]));
            gravar.newLine();
            System.out.println("Secao(" + (i + 1) + ") = " + posicao[i]);
        }
        gravar.close();
        ler.close();
    }
    public void PMaiorMenor(Votacao[] votacao) throws IOException
    {
        int i;
        String fileName = "ArquivoVotacaoSecoes.txt";
        BufferedReader ler = new BufferedReader(new FileReader(fileName));
        
        for(i = 0; i < 10; i++)
        {
            posicao[i] = Integer.parseInt(ler.readLine());
        }
        
        int maior = 0, menor, x = 0, y = 0;
        menor = posicao[0];
        for(i = 0; i < 10; i++)
        {
            if(menor > posicao[i])
            {
                menor = posicao[i];
                x = i;
            }
            else if(maior < posicao[i])
            {
                maior = posicao[i];
                y = i;
            }
        }
        System.out.println("\nA secao com menor numero de eleitores foi a " + (x + 1) + " com " + menor + " eleitores. \nA secao com maior numero de eleitores foi a " + (y + 1) + " com " + maior + " eleitores.");
        ler.close();
    }
    public void PQntdVotos(Votacao[] votacao) throws IOException
    {
        int i;
        String FileName = "ArquivoVotacaoCand.txt";
        BufferedWriter gravar = new BufferedWriter(new FileWriter(FileName));
        String fileName = "ArquivoVotacao.txt";
        BufferedReader ler = new BufferedReader(new FileReader(fileName));
        
        for(i = 0; i < 200; i++)
        {
            votacao[i] = new Votacao();
        }
        for(i = 0; i < 200; i++)
        {
            votacao[i].NumeroSecao = Integer.parseInt(ler.readLine());
            votacao[i].NumeroCandidato = Integer.parseInt(ler.readLine());
        }
        
        for(i = 0; i < 200; i++)
        {
            candidato[votacao[i].NumeroCandidato]++;
        }
        
        System.out.println("\nNumero de votos por candidato:");
        for(i = 0; i < 300; i++)
        {
            gravar.write(Integer.toString(candidato[i]));
            gravar.newLine();
            if(candidato[i] != 0)
            {
                System.out.println("Candidato numero " + i + " = " + candidato[i] + " votos.");
            }
        }
        ler.close();
        gravar.close();
    }
    public void PMaisVotados(Votacao[] votacao) throws IOException
    {
        int i;
        String fileName = "ArquivoVotacaoCand.txt";
        BufferedReader ler = new BufferedReader(new FileReader(fileName));
        
        for(i = 0; i < 300; i++)
        {
            candidato[i] = Integer.parseInt(ler.readLine());
        }
        
        int position[] = new int[300];
        for(i = 0; i < 300; i++)
        {
            position[i] = i;
        }
        
        int x, aux;
        for(i = 0; i < 299; i++)
        {
            for(x = i + 1; x < 300; x++)
            {
                if(candidato[i] < candidato[x])
                {
                    aux = candidato[i];
                    candidato[i] = candidato[x];
                    candidato[x] = aux;
                    
                    aux = position[i];
                    position[i] = position[x];
                    position[x] = aux;
                }
            }
        }
        
        System.out.println("\nOs 10 candidatos mais votados foram:");
        for(i = 0; i < 10; i++)
        {
            System.out.println("Candidato numero " + position[i] + " com " + candidato[i] + " votos.");
        }
    }
}