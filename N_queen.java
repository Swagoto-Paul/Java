//package Programs.Practise;

import java.util.Scanner;

public class N_queen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of rows: ");
        int n = sc.nextInt();
        boolean [][] board = new boolean[n][n];
        System.out.println("NO OF WAYS TO PLACE QUEEN: "+queen(board,0));
        sc.close();
    }

    static int queen(boolean[][] board,int row) {
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if(isSafe(board,row,col)){
                board[row][col] = true;
                count+=queen(board,row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i <row; i++) {
            if(board[i][col]){
                return false;
            }
        }

        int maxleft=Math.min(row,col);
        for (int i=1;i<=maxleft;i++) {
            if(board[row-i][col-i]){
                return false;
            }
        }


        int maxright=Math.min(row,board.length-col-1);
        for (int i=1;i<=maxright;i++) {
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean ele : row) {
                if (ele) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
