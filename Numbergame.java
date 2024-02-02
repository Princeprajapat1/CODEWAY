package NumberGame;

import java.util.Scanner;

public class Numbergame{

	public static void main(String args[]) {
		
		System.out.println("Welcome my friend welcome!");
		Game gm=new Game();
		gm.TakeUserinput();
		
		
	}
}
	
class Game{	
	int Score=100;
	double random2=Math.random();
	double d=random2*100;
	int random=(int)d;
	public void TakeUserinput() {
	if(Score==0) {
		System.out.println("your score is 0 Try again");
		Game k=new Game();
		k.TakeUserinput();
		return;
	}
System.out.println("Enter the no:");


Scanner sc= new Scanner(System.in);
int g=sc.nextInt();

if(g<random) {
	System.out.println("number is smaller");
Score=Score-10;
	TakeUserinput();
}if(g>random) {
	Score=Score-10;
	System.out.println("number is bigger");	
	TakeUserinput();
}
if(isCorrect(random,g)) {
	System.out.println("wohoo!,you guessed it");
	System.out.println("your score is "+Score);
	System.out.println("choose option:");
	System.out.println("1.Play again!");
	System.out.println("2.exit");
	int opt=sc.nextInt();
	if(opt==1) {
		Game k=new Game();
		k.TakeUserinput();
	}if(opt==2) {
		return;
	}else {
		System.out.println("Invalid choice");
	}
}
	
	}
	
public static boolean isCorrect(int random,int g) {
	if(random==g) {
		return true;
	}else {
		return false;
	}
}
}