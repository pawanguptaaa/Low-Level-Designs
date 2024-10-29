package com.tictac.tictactoe.Model;


import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public int size;
    public PlayingPiece[][]board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    // get all free cell....
    public boolean addPiece(int row, int column, PlayingPiece playingPiece){

        if(board[row][column] != null){
            return false;

        }
        board[row][column]=playingPiece;
        return true;
    }

    public List<Pair<Integer, Integer>> getEmptyCell(){
        List<Pair<Integer,Integer>> freeCells = new ArrayList<>();

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j] ==null){
                    Pair<Integer, Integer> rc = new Pair<>(i,j);
                    freeCells.add(rc);

                }
            }
        }
        return freeCells;
    }

    //Print the board....
    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]!=null){
                    System.out.println(board[i][j].pieceType.name()+ "   ");
                }
                else{
                    System.out.println("   ");
                }
                System.out.println(" | ");
            }
            System.out.println();
        }
    }

}
