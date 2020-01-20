import java.io.IOException;

public class Main {
	
    final static int FIELDS = 9;
    
    static Board board;
    static Player player1;
    static Player player2;
    
    private static int turn = 0;
    
	public static void main(String[] args) throws IOException {
        board = new Board();
        player1 = new Player(PieceType.X);
        player2 = new AI(PieceType.O);
        board.print();
        
        while(true) {
            if(turn % 2 == 0) player1.takeTurn();
            else player2.takeTurn();
            turn++;
            board.print();
        }
	}

}
