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
		System.out.println(board);
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
