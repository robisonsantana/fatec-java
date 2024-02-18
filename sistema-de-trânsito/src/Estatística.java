//CLASSE ABSTRATA:
class Estatística
{
    int CodigoCidade, QtdAcidentes;
    String NomeCidade;
    
    //Método Construtor:
    Estatística()
    {
        this(0, 0, "");
    }
    
    //Método Procedimento:
    Estatística(int Codigo, int Acidentes, String Nome)
    {
        CodigoCidade = Codigo;
        QtdAcidentes = Acidentes;
        NomeCidade = Nome;
    }
}