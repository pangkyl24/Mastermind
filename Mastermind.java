import java.util.ArrayList;

public class Mastermind{
	
	private ArrayList<ArrayList<String>> board = new ArrayList<ArrayList<String>>();
	private ArrayList<String> code = new ArrayList<String>();
	private int SIZE;
	
	public Mastermind(int size){
		SIZE = size;
	}
	
	public void setCode(){ //Randomly Sets the Code - Repeats Allowed
		int rand;
		for(int i = 0; i < SIZE; i++){		
				rand = (int)(Math.random()*7);
				switch (rand){
					case 0: code.add("R");
					        break;
					case 1: code.add("Y");
					        break;
					case 2: code.add("O");
					        break;
					case 3: code.add("G");
					        break;
					case 4: code.add("B");
					        break;
					case 5: code.add("P");
					        break;
					case 6: code.add("W");
					        break;
				}		
		}
	}
	
	public void setCode(boolean noRepeats){ //Randomly Sets the Code - Repeats Not Allowed
		int[] randomList = new int[SIZE];
		for(int i = 0; i < SIZE; i++){
			randomList[i] = (int)(Math.random()*7);
			for(int k = 0; k < i; k++){
				if(randomList[k] == randomList[i]){
					i--;
					break;
				}
			}
		}
		for(int i = 0; i < SIZE; i++){
			switch (randomList[i]){
				case 0: code.add("R");
				        break;
				case 1: code.add("Y");
				        break;
				case 2: code.add("O");
				        break;
				case 3: code.add("G");
				        break;
				case 4: code.add("B");
				        break;
				case 5: code.add("P");
				        break;
				case 6: code.add("W");
				        break;
			}
		}
	}
	
	public void setCode(String input){ //Sets the Code - Manual Input
		for(int i = 0; i < SIZE; i++){
			code.add(input.substring(i, i+1));
		}	
	}
	
	public void printCode(){ //Prints the CODE
		System.out.println(code);
	}
	
	public void printBoard(){ //Prints the BOARD [Excluding the Code]
		for(int i = 0; i < board.size(); i++){
			for(int j = 0; j < board.get(i).size(); j++){
				System.out.print(board.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}	
	
	public void scoreRecent(){ //Scores the most Recent Guess
		int redPins = 0;
		int whitePins = 0;
		
		for(int i = 0; i < SIZE; i++){ //Counts Num of Red pins
			if(board.get(board.size()-1).get(i).equals(code.get(i))){
				redPins++;
			}
		}
		
		int rC = 0; 
		int yC = 0; 
		int oC = 0; 
		int gC = 0; 
		int bC = 0; 
		int pC = 0; 
		int wC = 0;
		for(int i = 0; i < SIZE; i++){ //Counts num of each color
			if(board.get(board.size()-1).get(i).equals("R")){
				rC++;
			}
			else if(board.get(board.size()-1).get(i).equals("Y")){
				yC++;
			}
			else if(board.get(board.size()-1).get(i).equals("O")){
				oC++;
			}
			else if(board.get(board.size()-1).get(i).equals("G")){
				gC++;
			}
			else if(board.get(board.size()-1).get(i).equals("B")){
				bC++;
			}
			else if(board.get(board.size()-1).get(i).equals("P")){
				pC++;
			}
			else if(board.get(board.size()-1).get(i).equals("W")){
				wC++;
			}
		}
		for(int i = 0; i < SIZE; i++){ //If the code has a color, and there is a color in guess: whitePins++
			if(code.get(i).equals("R") && rC>0 ){
				whitePins++;
				rC--;
			}
			else if(code.get(i).equals("Y") && yC>0){
				whitePins++;
				yC--;
			}
			else if(code.get(i).equals("O") && oC>0){
				whitePins++;
				oC--;
			}
			else if(code.get(i).equals("G") && gC>0){
				whitePins++;
				gC--;
			}
			else if(code.get(i).equals("B") && bC>0){
				whitePins++;
				bC--;
			}
			else if(code.get(i).equals("P") && pC>0){
				whitePins++;
				pC--;
			}
			else if(code.get(i).equals("W") && wC>0){
				whitePins++;
				wC--;
			}
		}
		whitePins-=redPins; //Removes excess Whitepins
		//System.out.println("Whitepins: " + whitePins);
		//System.out.println("Redpins: " + redPins);
		
		//Adding the Scoring to the Board
		board.get(board.size()-1).add("{---- ");
		for(int i = 0; i < SIZE; i++){
			if(redPins!=0){
				redPins--;
				board.get(board.size()-1).add("O");
			}
			else if(whitePins!=0){
				whitePins--;
				board.get(board.size()-1).add("X");
			}
			else{
				board.get(board.size()-1).add("-");
			}
		}
		board.get(board.size()-1).add(" ----}");
	}
	
	public void addGuess(String input, boolean score){ //Adds a guess to the board
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = 0; i < SIZE; i++){
			temp.add(input.substring(i, i+1));
		}
		board.add(temp);
		if(score){
			scoreRecent();
		}
	}
	
	
}

