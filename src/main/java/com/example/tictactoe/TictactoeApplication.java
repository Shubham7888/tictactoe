package com.example.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import com.example.tictactoe.services.Start;

import com.example.tictactoe.entity.Player;

@SpringBootApplication
public class TictactoeApplication {

	public static void main(String[] args) {

		SpringApplication.run(TictactoeApplication.class, args);
		Start startinstance=new Start();
		Scanner scanner=new Scanner(System.in);

		List<Player>players=new ArrayList<>();
		players.add(new Player(scanner.next().charAt(0), scanner.next()));
		players.add(new Player(scanner.next().charAt(0), scanner.next()));

		startinstance.setPlayers(players);

		// for (int i = 0; i < 3; i++) {
		// 	for (int j = 0; j < 3; j++) {
		// 		System.out.print("-");  
		// 	}
		// 	System.out.println();  
		// }

		for(int i=0;i<9;i++){
			String a=scanner.next();
			if(a.equals("exit")){
				
				break;
			}
			int x=a.charAt(0)-'0';
			int y=scanner.nextInt();
           
			
			startinstance.startGame(x,y);
			
             if(startinstance.gameover==true){
				break;
			 }
		}

		if(startinstance.gameover==false){
			System.out.println("GameOver");
		}
	}

}
