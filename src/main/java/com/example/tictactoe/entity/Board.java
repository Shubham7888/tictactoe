package com.example.tictactoe.entity;

public class Board {
    public int size;
    
    char[][] board;

    public Board(int size){
      this.size=size;
      board=new char[size][size];

      for(int i=0;i<size;i++){
        for(int j=0;j<size;j++){
            board[i][j]='-';
        }
      }
      System.out.println(board);
    }




    
}
