import java.util.Scanner;

public class Main{
	
	public boolean testInputValidity(String input){
		String charAtI;
		for(int i = 0; i < input.length(); i++){
			charAtI = input.substring(i, i+1);
			if(charAtI != "R" && charAtI != "Y" && charAtI != "O" && charAtI != "G" && charAtI != "B" && charAtI != "P" && charAtI != "W"){
				return false;
			}
		}
		return true;
		
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		int temp = 0;
		String input = "";
		
		System.out.println();
		System.out.println("~~______________________~~");
		System.out.println("~~Welcome to Mastermind!~~");
		System.out.println("~~______________________~~");
		System.out.println();
	
		while (temp > 7 || temp < 4){
			System.out.println("How Big a Code Do you Want to Crack? (Input a Number Between 4-7)");
			temp = Integer.parseInt(scan.nextLine());
		}
		
		
		Mastermind game = new Mastermind(temp);
		
		System.out.println();
		System.out.println();
		System.out.println("Would you like to play this game with or without repeats? (Type 1 for Repeats: Type 2 for no repeats)");
		temp = Integer.parseInt(scan.nextLine());
		while(temp != 1 && temp != 2){
			System.out.println("Would you like to play this game with or without repeats? (Type 1 for Repeats: Type 2 for no repeats)");
			temp = Integer.parseInt(scan.nextLine());
		}
		
		if (temp == 1){
			game.setCode(true);
		}
		else{
			game.setCode();
		}
		
		System.out.println();
		System.out.println("~~___________________~~");
		System.out.println("~~Game Will Now Begin~~");
		System.out.println("~~___________________~~");
		System.out.println();
		
		int tryNum = 1;
		boolean gameWon = false;
		
		while(gameWon == false){
			System.out.println();
			System.out.println("Guess #" + tryNum);
			System.out.println("Input Your Guess! Any Guess with Characters other than R, Y, O, G, B, P, W will be Bounced");
			input = scan.nextLine();
			while(!testInputValidity(input) || input.length() < game.getSize()){
				//WIP
			}
			
		}
		
		
		
	}

}