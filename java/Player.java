import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Player {

	private PieceType type;
	
	Player(PieceType type) {
		this.type = type;
	}
	
	void takeTurn() throws IOException {
		System.out.print("Enter a number to place your piece (1-9, top left to bottom right): ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int pos = in.read() - 49;
		if(pos < 0 || pos > 8) {
			takeTurn();
		}
		else {
			Main.board.place(type, pos);
		}
	}
	
	PieceType getType() {
		return type;
	}

}
