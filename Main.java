import java.util.Scanner;

public class Main{
	
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
		
	}

}
