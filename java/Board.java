import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Board {
    private char[][] board = {  {' ', '|', ' ', '|', ' '},
                                {'-', '+', '-', '+', '-'},
                                {' ', '|', ' ', '|', ' '},
                                {'-', '+', '-', '+', '-'},
                                {' ', '|', ' ', '|', ' '},
                            };

    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();

    public Board() {
        boardDisplay();
    }


    // Displays the board
    public void boardDisplay() {
        for(char[] row : board) {
            for(char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    // Logic for placing pieces
    public void placePiece(int position, String player) {
        char gamePiece;

        if(!player.equalsIgnoreCase("Cpu")) {
            gamePiece = 'X';
            playerPositions.add(position);
        } else {
            gamePiece = 'O';
            playerPositions.add(position);
        }

        switch(position) {
            case 1:
                board[0][0] = gamePiece;
                break;
            case 2:
                board[0][2] = gamePiece;
                break;
            case 3:
                board[0][4] = gamePiece;
                break;
            case 4:
                board[2][0] = gamePiece;
                break;
            case 5:
                board[2][2] = gamePiece;
                break;
            case 6:
                board[2][4] = gamePiece;
                break;
            case 7:
                board[4][0] = gamePiece;
                break;
            case 8:
                board[4][2] = gamePiece;
                break;
            case 9:
                board[4][4] = gamePiece;
                break;

            default:
                break;
        }


    }

    public String checkForWinner() {
        // All possible win scenarios
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> middleRow = Arrays.asList(4, 5, 6);
        List<Integer> bottomRow = Arrays.asList(7, 8, 9);
        List<Integer> topCol = Arrays.asList(1, 4, 7);
        List<Integer> middleCol = Arrays.asList(2, 5, 8);
        List<Integer>bottomCol = Arrays.asList(3, 6, 9);
        // Diagonal from top left to bottom right
        List<Integer> diagTLBR = Arrays.asList(1, 5, 9);
        // Diagonal from bottom left to top right
        List<Integer> diagBLTR = Arrays.asList(7, 5, 3);


        List<List> winConditions = new ArrayList<List>();
        winConditions.add(topRow);
        winConditions.add(middleRow);
        winConditions.add(bottomRow);
        winConditions.add(topCol);
        winConditions.add(middleCol);
        winConditions.add(bottomCol);
        winConditions.add(diagBLTR);
        winConditions.add(diagTLBR);

        for(List list : winConditions) {
            if(playerPositions.containsAll(list)) {
                return "Congratulations you have won!";
            } else if (cpuPositions.containsAll(list)) {
                return "You lose, the Computer has bested you!";
            } else {
                gameIsDraw();
            }
        }

        return "";
    }

    public String gameIsDraw() {
        if(playerPositions.size() + cpuPositions.size() == 9 ) {
            return "The match has ended as a draw.";
        }
        return "";
    }

}
