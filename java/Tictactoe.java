import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Tictactoe {

	/*
	 * Represents if player may place a piece - true (Player 1) - false (Player 2 /
	 * AI)
	 */
	private static boolean playerTurn = true;

	private static boolean isGameFinished = false;
	private static int placedPieces = 0;

	//	0 = nothing; 1 = player; 2 = computer
	private static int[] boardSet = new int[9];
	private static Board board;
	private static Player player;
	private static Piece playerPiece = new Piece('X');
	private static Piece computerPiece = new Piece('O');

	public static void main(String[] args) {
		board = new Board();
		player = new Player();

		while (!isGameFinished) {
			GameState winner = null;
			if(playerTurn) playerTurn();
			else computerTurn();
			if (placedPieces == 9)
				finishGame(winner);
			//takeOneTurn();
		}
	}

	public static void takeOneTurn() {
		nextPlayer();
		placedPieces++;
		GameState state = getStateFromString(board.checkForWinner());
		if (state.ordinal() < 3)
			finishGame(state);
	}

	private static void nextPlayer() {
		if (playerTurn)
			playerTurn = false;
		else
			playerTurn = true;
	}

	private static void playerTurn() {
		clearSysout();
		board.boardDisplay();
		System.out.println("(Fields are numbered 1-9 (left to right, top to down))");
		System.out.print("Enter a number to place a piece (1-9): ");
		int position = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = "0";
		try {
			input = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		position = Integer.parseInt(input);
		board.placePiece(position, "Player", playerPiece);
		boardSet[position-1] = 1;
	}
	
	private static void computerTurn() {
		clearSysout();
		char[][] boardBackup = board.getBoard();
		int position = 0;
		
		position = computerTurnHelper(0);
		
		if(position == 0) board.setBoard(boardBackup);
		else System.out.println("TODO: PLACE RANDOM");
		board.boardDisplay();
		board.placePiece(position, "Cpu", playerPiece);
	}
	private static int computerTurnHelper(int position) {
		if(getStateFromString(board.checkForWinner()) == GameState.ComputerWon) return position;
		else {
			for(int i = 0; i < boardSet.length; i++) {
				if(boardSet[i] == 0) {
					board.placePiece(i, "Cpu", computerPiece);
					return computerTurnHelper(i);
					
				}
				board.placePiece(i, "", new Piece(' '));
			}
			return 0;
		}
		
	}
	
	private static void clearSysout() {
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
	
	
	private static void finishGame(GameState winner) {
		isGameFinished = true;
		switch (winner) {
		case PlayerWon:
			System.out.println("Congratulations you have won!");
			break;
		case ComputerWon:
			System.out.println("You lose, the Computer has bested you!");
			break;
		default:
			System.out.println("The match has ended as a draw.");
			break;
		}
	}

	private static GameState getStateFromString(String str) {
		switch (str) {
		case "Congratulations you have won!":
			return GameState.PlayerWon;
		case "You lose, the Computer has bested you!":
			return GameState.ComputerWon;
		case "The match has ended as a draw.":
			return GameState.Tie;
		case "":
			return GameState.Running;
		default:
			return GameState.NotStarted;
		}
	}
}
