package task1;

import java.util.*;
public class Number_Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random=new Random();
		System.out.println("*******************************************");
		System.out.println("*     WelCome To Number Guessing game     *");
		System.out.println("*******************************************");
		
		System.out.println("Enter the number of Rounds you want : ");
		int NoOfRounds=sc.nextInt();
		int score=0;
		System.out.println("Enter your Name : ");
		String Name=sc.next();
		int cnt=1;
		while(cnt<=NoOfRounds) {
			System.out.println("Round "+cnt+" Start ");
			int target=random.nextInt(100)+1;
			int attempts=0;
			int maxAttempts=7;
			boolean flag=false;
			while(attempts<maxAttempts) {
				System.out.println("Enter the Your Guess : ");
				int Guess=sc.nextInt();
				attempts++;
				
				if(Guess==target) {
					score+=1;
					flag=true;
					System.out.println("Congratulations!! "+Name+" You guess it in "+attempts+" attempts");
					break;
				}
				else if(Guess>target) {
					System.out.println("Guess the smaller number");
				}
				else {
					System.out.println("Guess the Larger number");
				}
			}
			if(attempts>=maxAttempts && !flag) {
				System.out.println("Sorry, you've run out of attempts. The correct number is "+target+".");
			}
			System.out.println("**************************************************************");
			cnt++;
		}
		System.out.println("*******************************************");
		double winRate=(score*100)/NoOfRounds;
		System.out.println("Congrasulations "+Name);
		System.out.println("Your Score is "+score+" out of "+NoOfRounds);
		System.out.println("Win Percentage is "+winRate);
		System.out.println("*******************************************");
		sc.close();
	}
}
