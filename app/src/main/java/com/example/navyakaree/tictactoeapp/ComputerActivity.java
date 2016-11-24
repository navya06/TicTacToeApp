package com.example.navyakaree.tictactoeapp;

/**
 * Created by NavyaKaree on 11/23/16.
 */

import java.util.Scanner;


/** The game of Tic Tac Toe. */
public class ComputerActivity {

    /** For reading from the console. */
    public static final Scanner INPUT = new Scanner(System.in);
    public static char cha_inf;

    /** Squares on the board, each of which is '.', 'X', or 'O'. */
    private char[][] squares;

    /** The board is initially empty. */
    public ComputerActivity() {
        squares = new char[][] {{'.', '.', '.'},
                {'.', '.', '.'},
                {'.', '.', '.'}};
    }

    /** Return true if the game is over. */
    public boolean gameOver() {
        if (score() != 0) {
            return true;
        }
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (squares[row][column] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    /** Return the value of the current position if it is O's turn. */
    protected int minimaxForO() {
        int score = score();
        if (gameOver()) {
            return score;
        }
        int bestScore = 2;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (squares[row][column] == '.') {
                    squares[row][column] = 'O';
                    score = minimaxForX();
                    if (score < bestScore) {
                        bestScore = score;
                    }
                    squares[row][column] = '.';
                }
            }
        }
        return bestScore;
    }

    /** Return the value of the current position if it is X's turn. */
    protected int minimaxForX() {
        int score = score();
        if (gameOver()) {
            return score;
        }
        int bestScore = -2;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (squares[row][column] == '.') {
                    squares[row][column] = 'X';
                    score = minimaxForO();
                    if (score > bestScore) {
                        bestScore = score;
                    }
                    squares[row][column] = '.';
                }
            }
        }
        return bestScore;
    }

    /** Play one game. */
    public void play(int e_row,int e_column, char t) {
        char player = t;
        int no_of_times=2;
        if(player=='X')
            no_of_times=1;
        else
            no_of_times=2;


        for (int move = 0; move < no_of_times; move++) {
            if (gameOver()) {
                return;
            }
            if (player == 'X')
            {
                playBestMove();
                player = 'O';
                cha_inf=player;
            } else
            {
                squares[e_row][e_column] = 'O';
                player = 'X';
                cha_inf=player;
            }

        }
    }

    /** Find the best move for X and play it on the board. */
    protected void playBestMove() {
        int score;
        int bestScore = -2;
        int bestRow = -1;
        int bestColumn = -1;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (squares[row][column] == '.') {
                    squares[row][column] = 'X';
                    score = minimaxForO();
                    if (score > bestScore) {
                        bestScore = score;
                        bestRow = row;
                        bestColumn = column;
                    }
                    squares[row][column] = '.';
                }
            }
        }
        squares[bestRow][bestColumn] = 'X';
    }

    /** Return 1 if X has won, -1 if O has won, and 0 otherwise. */
    public int score() {
        int lineScore;
        for (int i = 0; i < 3; i++) {
            lineScore = scoreLine(squares[i][0],
                    squares[i][1],
                    squares[i][2]);
            if (lineScore != 0) {
                return lineScore;
            }
            lineScore = scoreLine(squares[0][i],
                    squares[1][i],
                    squares[2][i]);
            if (lineScore != 0) {
                return lineScore;
            }
        }
        lineScore = scoreLine(squares[0][0],
                squares[1][1],
                squares[2][2]);
        if (lineScore != 0) {
            return lineScore;
        }
        return scoreLine(squares[0][2], squares[1][1], squares[2][0]);
    }

    /**
     * Return 1 if all three characters are 'X', -1 if they are all 'O',
     * and 0 otherwise.
     */
    protected int scoreLine(char a, char b, char c) {
        if ((a == 'X') && (b == 'X') && (c == 'X')) { return 1; }
        if ((a == 'O') && (b == 'O') && (c == 'O')) { return -1; }
        return 0;
    }

    public String toString() {
        String result = "";
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                result += squares[row][column];
            }
            result += "\n";
        }
        return result;
    }


    public  char[][] Original()
    {
        return squares;
    }


}
