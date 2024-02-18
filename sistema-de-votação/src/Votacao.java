public class Votacao 
{
    int NumeroSecao;
    int NumeroCandidato;
    
    Votacao()
    {
        this(0, 0);
    }
    
    Votacao(int numero, int candidato)
    {
        NumeroSecao = numero;
        NumeroCandidato = candidato;
    }
}
