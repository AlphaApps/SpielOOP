public class Score {
    
    String playername;
    int second;
    
    Score (String name, int second)
    {
        this.playername = name;
        this.second = second;
    }

    public String getPlayername() {
        return playername;
    }

    public int getSecond() {
        return second;
    }

    // public void setPlayername(String playername) {
    //     this.playername = playername;
    // }

    // public void setSecond(int second) {
    //     this.second = second;
    // }
}
