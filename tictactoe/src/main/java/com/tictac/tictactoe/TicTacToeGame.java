package com.tictac.tictactoe;

import ch.qos.logback.core.joran.sanity.Pair;
import com.tictac.tictactoe.Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    Deque<Player> players;
    Board gameBoard;

    public void initializeGame(){

        // let's just create 2 players...
        players = new LinkedList<>();

        // 1st player
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player1", crossPiece);

        // 2nd player
        PlayingPieceO noughtsPiece = new PlayingPieceO();
        Player player2 = new Player("Player2", noughtsPiece);

        players.add(player1);
        players.add(player2);

        // Initialize the Board...
        gameBoard = new Board(3);

    }

    // start the game now...
    public String startGame(){
        boolean noWinner = true;
        while (noWinner){

            // here take the player out whose turn is there and also put that player back inside the queue again..
            Player playerTurn = players.removeFirst();

            // get the empty space from the board...
            gameBoard.printBoard();

            List<Pair<Integer, Integer>> freeSpaces = gameBoard.getEmptyCell();
            if(freeSpaces.isEmpty()){
                noWinner = false;
                continue;
            }

            // read the user input...
            System.out.println("Player:" + playerTurn.name + "Enter row, column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            // place the piece on the board...
            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow, inputColumn, playerTurn.playingPiece);
            if(!pieceAddedSuccessfully){
                // player can not add the piece into the cell, player has to choose another cell..
                System.out.println("Incorrect Position chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.playingPiece.pieceType);
            if(winner){
                return playerTurn.name;
            }
        }
        return "tie";
    }

    public boolean isThereWinner(int row, int col, PieceType pieceType){

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDoagonalMatch = true;

        // check in for the rows...
        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType){
                rowMatch = false;
            }
        }

        // check in for the column...
        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.board[i][col] == null || gameBoard.board[i][col].pieceType != pieceType){
                columnMatch = false;
            }
        }

        // need to check for the diagonal...
        for(int i = 0; i < gameBoard.size; i++){
            for(int j = 0; j < gameBoard.size; j++){
                if(gameBoard.board[i][j]==null || gameBoard.board[i][j].pieceType != pieceType){
                    diagonalMatch = false;
                }
            }
        }

        // need to check for the anti-diagonal...
        for(int i = 0; i < gameBoard.size; i++){
            for(int j = gameBoard.size-1; j < gameBoard.size; j--){
                if(gameBoard.board[i][j]==null || gameBoard.board[i][j].pieceType != pieceType){
                    antiDoagonalMatch = false;
                }
            }
        }
        return rowMatch || columnMatch || diagonalMatch || antiDoagonalMatch;
    }
}
