import java.util.Scanner;

public class ClapperProject {

	public static void main(String[] args) {
		int exp = 4;
		int clappers;
		int claps;
		boolean vlaueClappers = false;
		String ON ="ON";
		String OFF ="OFF";
		boolean bulb = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter no of clappers");
		clappers= scanner.nextInt();
		System.out.println("Enter no . of claps");
		claps = scanner.nextInt();
		if(claps== 0){
		System.out.println("Bulb is OFF");
		}else{
			
			for(int i=0 ; i<clappers;i++){
				if(claps%2==0){
					
					System.out.println("Bulb is OFF");
				}
				else{
					System.out.println("Bulb is ON");
				}
			}
		}
	}

}
