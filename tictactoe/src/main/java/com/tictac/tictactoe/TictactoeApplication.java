package com.tictac.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TictactoeApplication {

	public static void main(String[] args) {

		SpringApplication.run(TictactoeApplication.class, args);
		// System.out.println("Welcome to my new world!!");
		TicTacToeGame game = new TicTacToeGame();
		game.initializeGame();
		System.out.println("game winner is:" + game.startGame());

	}

}
