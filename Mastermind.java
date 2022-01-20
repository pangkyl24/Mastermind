import java.util.ArrayList;

public class Mastermind{
	
	private ArrayList<ArrayList<String>> board = new ArrayList<ArrayList<String>>();
	private ArrayList<String> code = new ArrayList<String>();
	
	public void setCode(){
		int rand;
		for(int i = 0; i < 5; i++){		
				rand = (int)(Math.random()*7);
				if(rand==0){
					code.add("R");
				}		
				else if(rand==1){
					code.add("Y");
				}
				else if(rand==2){
					code.add("O");
				}
				else if(rand==3){
					code.add("G");
				}
				else if(rand==4){
					code.add("B");
				}
				else if(rand==5){
					code.add("P");
				}
				else{
					code.add("W");
				}		
		}
	}
	public void printCode(){
		System.out.println(code);
	}
	public void printBoard(){
		for(int i = 0; i < board.size(); i++){
			for(int j = 0; j < board.get(i).size(); j++){
				System.out.print(board.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}	
	
	public void scoreRecent(){ //WIP
		int redPins = 0;
		int whitePins = 0;
		
		for(int i = 0; i < 5; i++){
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
		for(int i = 0; i < 5; i++){
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
		for(int i = 0; i < 5; i++){
			if(code.get(i).equals("R")){
				whitePins++;
				rC--;
			}
			else if(code.get(i).equals("Y")){
				whitePins++;
				yC--;
			}
			else if(code.get(i).equals("O")){
				whitePins++;
				oC--;
			}
			else if(code.get(i).equals("G")){
				whitePins++;
				gC--;
			}
			else if(code.get(i).equals("B")){
				whitePins++;
				bC--;
			}
			else if(code.get(i).equals("P")){
				whitePins++;
				pC--;
			}
			else if(code.get(i).equals("W")){
				whitePins++;
				wC--;
			}
		}
		whitePins-=redPins;
		
		board.get(board.size()-1).add("{---- ");
		for(int i = 0; i < 5; i++){
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
	
	public void addGuess(String inp1, String inp2, String inp3, String inp4, String inp5){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(inp1);
		temp.add(inp2);
		temp.add(inp3);
		temp.add(inp4);
		temp.add(inp5);
		board.add(temp);
	}
	
}

