class Tictactoe {

    /*  Represents if player may place a piece
        - true (Player 1)
        - false (Player 2 / AI)
    */
    private static boolean playerOneTurn = true;

    private static boolean isGameFinished = false;
    private static int placedPieces = 0;

    public static void main(String[] args) {
        Board board = new Board();
        
        /*while(!isGameFinished) {
            Winner winner = null;
            if(placedPieces == 9) finishGame(winner);
        }*/
    }

    public static void takeOneTurn() {
        nextPlayer();
    }

    private static void nextPlayer() {
        if(playerOneTurn) playerOneTurn = false;
        else playerOneTurn = true;
    }

    private static void finishGame(Winner winner) {
        isGameFinished = true;
        switch(winner) {
            case One:
                System.out.println("Player 1 won!");
                break;
            case Two:
                System.out.println("Player 2 won!");
                break;
            default:
                System.out.println("Tie!");
                break;
        }
    }
}