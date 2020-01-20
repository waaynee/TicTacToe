import java.util.HashMap;

class Board {

    HashMap<Integer,PieceType> pieces = new HashMap<Integer,PieceType>();

    Board() {
        for(int i = 0; i < Main.FIELDS; i++) {
            pieces.put(i, PieceType.None);
        }
    }

    void print() {
        System.out.println("-------------");
        for(int i = 0; i < Main.FIELDS; i += 3) {
            System.out.println("| " + 
            		getTypeString(pieces.get(i)) + " | " + 
            		getTypeString(pieces.get(i+1)) + " | " + 
            		getTypeString(pieces.get(i+2)) + " |");
            System.out.println("-------------");
        }
    }
    
    void place(PieceType type, int position) {
    	pieces.replace(position, type);
    }

    String getTypeString(PieceType type) {
        return (type == PieceType.X) ? "X" : (type == PieceType.O) ? "O" : " ";
    }
}
