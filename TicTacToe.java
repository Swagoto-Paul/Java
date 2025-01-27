//package Programs.Practise;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String [] args) {
        Scanner obj = new Scanner(System.in);
        char[][] board = new char[3][3];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = ' ';
            }
        }
        char ply = 'X';
        boolean over = false;

        while (!over) {
            display(board);
            System.out.println("PLAYER " + ply + " TURN");
            System.out.print("ROW: ");
            int row = obj.nextInt();
            System.out.print("COLUMNS: ");
            int col = obj.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = ply;
                over = won(board, ply);
                if (over) {
                    display(board);
                    System.out.println("PLAYER " + ply + " HAS WON");
                } else
                    ply = (ply == 'X') ? 'O' : 'X';
            } else {
                System.out.println("INVALID MOVE TRY AGAIN !!!");
            }
        }
    }

    static boolean won(char[][] board,char ply){
        for(int r=0;r<board.length;r++){
            if(board[r][0]==ply && board[r][1]==ply && board[r][2]==ply)
                return true;
        }

        for(int c=0;c<board[0].length;c++){
            if(board[0][c]==ply && board[1][c]==ply && board[2][c]==ply)
                return true;
        }

        if(board[0][0]==ply && board[1][1]==ply && board[2][2]==ply)
            return true;

        if(board[0][2]==ply && board[1][1]==ply && board[2][0]==ply)
            return true;

        return false;
    }

    static void display(char[][] board){
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[r].length;c++) {
                if (c + 1 == board.length)
                    System.out.print(board[r][c]);
                else
                    System.out.print(board[r][c] + " | ");
            }
            System.out.println();
        }
    }
}
