
public class Main {
    public static void main(String[] args) {
        GameFrame frame1 = GameFrame.getInstance("Tank War",800,600);
        frame1.Draw.start();
        frame1.EnemyBirth.start();
        frame1.EnemyMoves.start();
    }
}




