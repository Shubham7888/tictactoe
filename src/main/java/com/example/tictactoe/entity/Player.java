package com.example.tictactoe.entity;

public class Player {
    private char piece;
    private String name;
    private String id; 
   public static int count=1;
    public Player(char piece,String name){
        this.piece=piece;
        this.name=name;
        this.id="P"+count;
        count++;
    }

    public String getId(){
        return id;
    }

    public char getPiece(){
        return piece;
    }

    public String getName(){
        return name;
    }
}
