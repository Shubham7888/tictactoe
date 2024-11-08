package com.example.tictactoe.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.example.tictactoe.entity.Board;
import com.example.tictactoe.entity.Player;

public class Start {
    
    public char[][] board=new char[3][3];
   public boolean gameover;
   public Queue<Player>players;

   public void printBoard() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            System.out.print(board[i][j] + " ");  // Print each cell with a space
        }
        System.out.println();  // Newline after each row
    }
}

   public Start(){
    //System.out.println("Hi");
    this.gameover=false;
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            board[i][j]='-';
        }
      }

      printBoard();
      
   }

   ///////////// Inilizing players ////
   
   public void setPlayers(List<Player>players){
     this.players=new LinkedList<Player>();

     for(Player player:players){
        this.players.add(player);
     }
   }

   public boolean validmove(int i,int j){
     
    if(i<0 || i>=3 || j<0 || j>=3 || board[i][j]!='-'){
        return false;
    } 

    return true;
   }

     public void makemove(int i,int j,Player player){
        char piece=player.getPiece();
        board[i][j]=piece;
        printBoard();
     }

     public boolean checkwin(){
       
         for(int i=0;i<3;i++){
            boolean flag=true;
            char piece=board[i][0];
            for(int j=1;j<3;j++){
                if(board[i][j]=='-'){
                    flag=false;
                }
               else if(board[i][j]!=piece){
                 flag=false;
               }
            }
            if(flag)
            return true;
        }

        for(int i=0;i<3;i++){
            boolean flag=true;
            char piece=board[0][i];
            for(int j=1;j<3;j++){
                if(board[j][i]=='-'){
                    flag=false;
                }
               else if(board[j][i]!=piece){
                 flag=false;
               }
            }
            if(flag)
            return true;
        }
        
        if(board[0][0]!='-' && board[0][0]==board[1][1] && board[0][0]==board[2][2])
        return true;

        if(board[0][2]!='-' && board[0][2]==board[1][1] && board[1][1]==board[2][0])
        return true;
      
        return false;
     }


    public  void startGame(int i,int j){
         boolean valid=validmove(i-1,j-1);
         if(!valid){
            System.out.println("Invalid Move");
            return;
         }
         
         Player player= players.peek();
         makemove(i-1,j-1,player);
         if(checkwin()){
            System.out.println(player.getName()+" won the game");
            gameover=true;
            return;
         }

         players.remove();
         players.add(player);
         
    }
}
