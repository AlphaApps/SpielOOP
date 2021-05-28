public class Score {
    
    String Spielername;
    int sekunden;
    
    Score (String spielername, int sekunden)
    {
        this.Spielername = spielername;
        this.sekunden = sekunden;
    }

    public String getSpielername() {
        return Spielername;
    }

    public int getSekunden() {
        return sekunden;
    }

}
