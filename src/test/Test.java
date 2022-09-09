package test;
import game.*;
import util.Piece;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.Scanner;
public class Test {

	public static void main(String[] args) {


		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to my Chess Game");
		System.out.println("Player 1 and Player 2, please enter your names");
		String name1 = input.next(); //reads the user input and stores in name1
		String name2 = input.next(); //reads the user input and stores in name2

		Game game = new Game(name1, name2); //Creates a new Game with the two names entered
		game.showBoard(System.out); //prints chess board

		while(true){
			System.out.println("Valid Commands: new game, move, capture, status, undo");

			Scanner scan = new Scanner(System.in);
			String commands = input.next();


			switch(commands){

		//New game - when the command "new game" is entered it creates a new game with the names stored in the variables name 1 and name 2 and shows a new board.

				case"new game":
					Game newGame= new Game(name1,name2);
					newGame.showBoard(System.out);
					break;
		//Move - when the command "move" is entered it passes the coordinates you've entered into the instance of the move class and updates the board to show the new position of the piece.
				case "move":
					System.out.println("Enter your move: ");
					String move = scan.next();
					if(game.move(new Move(move))){
						game.showBoard(System.out);
					}else {
						System.out.println("Incorrect command. Please re-enter one of the following commands: new game, move, capture, status, undo");
					}
					break;

		//Status - when the command "status" is entered it prints all the coordinates of the moves played for the duration of the game.

				case "status":
					if (commands.equals("status")) {
						game.showBoard(System.out);
						System.out.println("The moves played were as follows : "+ game);
					} else {
						System.out.println("Incorrect command. Please re-enter one of the following commands: new game, move, capture, status, undo");
					}
					break;
		//Undo- when the command "undo" is entered it creates a new game and shows the board with one less move
		// than the previous one game so it technically undos the last move.
				case "undo":
					Game back = new Game(game.getPlayer1(),game.getPlayer2());
					for(int x = 0; x < game.getMoves().size() - 1; x++){
						back.move(game.getMoves().get(x));
					}

					game = back;
					game.showBoard(System.out);

		//Capture - when the command "capture" is entered it allows the users to move into a block that was previously taken.

				case "capture":
					System.out.println("Enter the coordinates of your capture");
					String capture = scan.next();
					if(game.move(new Move(capture))){
						System.out.println("You captured the piece!");
						game.showBoard(System.out);
					}else {
						System.out.println("Incorrect command. Please re-enter one of the following commands: new game, move, capture, status, undo");
					}
					break;







			}


		}

		}//end main
	}//end Test Class












