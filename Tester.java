public class Tester{
	
	public static void main(String[] args){
		
		Mastermind test = new Mastermind();
		test.setCode();
		test.printCode();
		
		System.out.println();
		test.addGuess("R", "Y", "G", "B", "W");
		test.addGuess("W", "G", "O", "Y", "Y");
		test.printBoard();
		
	}

}
