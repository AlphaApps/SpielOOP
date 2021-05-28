public class Test {
 
    public static void main(String[] args) {
        
        Highscore obj = Highscore.getInstance();
        obj.add(new Score("Alex", 45));
        obj.add(new Score("Micheal", 49));
        obj.add(new Score("Sharon", 55));
        
        
    }
}
