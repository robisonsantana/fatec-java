public class Eleitor 
{
    int NumeroEleitor;
    String NomeEleitor;
    int Seção;
    
    Eleitor()
    {
        this(0, "", 0);
    }
    
    Eleitor(int numero, String nome, int seção)
    {
        NumeroEleitor = numero;
        NomeEleitor = nome;
        Seção = seção;
    }
    
}
