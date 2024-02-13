import java.util.Random;

public class Recherche_dicho {

    private int [] board;

    public Recherche_dicho(int [] board){
        this.board = board;
    }

    public int[] sort_board(int [] board) {
        boolean swapped;
        do {
            swapped = false;
            for(int i = 0; i < board.length - 1; i++){
                if(board[i] > board[i + 1]){
                    int temp = board[i];
                    board[i] = board[i + 1];
                    board[i + 1] = temp;
                    swapped = true;
                }
            }
        }while(swapped);
        return board;
    }


    public int search(int element, int [] board, int start, int end) {
        if(end < start) {
            return -1;
        }
        else
        {
            int average = (end + start) / 2;
            if(board[average] == element) {
                return average;
            }
            else if(board[average] < element) {
                return search(element, board, average + 1, end);
            }
            else if(board[average] > element) {
                return search(element, board, start, average - 1);
            }
            else{
                return -1;
            }
        }
    }

    public static void main (String [] args)
    {
        int board[] = new int [100];
        Random rdm = new Random();
        for(int i = 0; i < 100; i++){
            board[i] = rdm.nextInt(100);
            System.out.print(board[i] + " ");
        }
        System.out.print("\n");
        Recherche_dicho r = new Recherche_dicho(board);
        board = r.sort_board(board);
        for(int element : board){
            System.out.print(element + " ");
        }
        System.out.print("\n");
        int result = r.search(32, board, 0, board.length - 1);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }

}
