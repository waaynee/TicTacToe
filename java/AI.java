import java.util.HashMap;

class AI extends Player {
	
	public AI(PieceType type) {
		super(type);
	}
	
	@Override
	void takeTurn() {
		int pos = checkForWin(super.getType());
		int pos2 = checkForWin(Main.player1.getType());
		if(pos != -1) Main.board.place(super.getType(), pos);
		else if(pos2 != -1) Main.board.place(super.getType(), pos2);
		else {
			for(int i = 0; i < Main.FIELDS; i++) {
				if(Main.board.pieces.get(i) == PieceType.None) {
					Main.board.place(super.getType(), i);
					break;
				}
			}
		}
	}
	
	private int checkForWin(PieceType type) {
		HashMap<Integer,PieceType> h = Main.board.pieces;
		for(int i = 0; i < Main.FIELDS; i += 3) {
			int count = 0;
			if(h.get(i) == type) count++;
			if(h.get(i+1) == type) count++;
			if(h.get(i+2) == type) count++;
			if(count == 2) return (h.get(i) == PieceType.None) ? i : (h.get(i+1) == PieceType.None) ? i+1 : i+2;
		}
		for(int i = 0; i < 3; i++) {
			int count = 0;
			if(h.get(i) == type) count++;
			if(h.get(i+3) == type) count++;
			if(h.get(i+6) == type) count++;
			if(count == 2) return (h.get(i) == PieceType.None) ? i : (h.get(i+3) == PieceType.None) ? i+3 : i+6;
		}
		int count = 0;
		if(h.get(0) == type) count++;
		if(h.get(4) == type) count++;
		if(h.get(8) == type) count++;
		if(count == 2) return (h.get(0) == PieceType.None) ? 0 : (h.get(4) == PieceType.None) ? 4 : 8;
		
		count = 0;
		if(h.get(2) == type) count++;
		if(h.get(4) == type) count++;
		if(h.get(6) == type) count++;
		if(count == 2) return (h.get(2) == PieceType.None) ? 2 : (h.get(4) == PieceType.None) ? 4 : 6;
		return -1;
	}

}
