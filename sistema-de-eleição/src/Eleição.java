public class Eleição 
{
    int Seção, CodCandidato, NumEleitor;
    
    Eleição()
    {
        this(0, 0, 0);
    }
    
    Eleição(int seção, int CodCand, int NumEleit)
    {
        Seção = seção;
        CodCandidato = CodCand;
        NumEleitor = NumEleit;
    }
}
