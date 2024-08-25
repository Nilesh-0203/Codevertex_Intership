package atm;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class BankAccount {
	
	String name;
	String userName;
	String password;
	String accountNo;
	int CardType;;
	
	float balance = 100000f;
	int transactions = 0;
	String transactionHistory = "";
	
	// BankAccount(String name, String userName, String password, String accountNo) {
	// this.name = name;
	// this.userName = userName;
	// this.password = password;
	// this.accountNo = accountNo;
	// }
	 LocalDateTime currentDateTime = LocalDateTime.now();
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
     String formattedDateTime = currentDateTime.format(formatter);
	
	public void register() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nEnter Your Name : ");
		this.name = sc.nextLine();
		while(name.isEmpty()) {
   		  System.out.print("\nName Should not be empty ! ");
   		  System.out.print("\nEnter Your Name : ");
		  this.name = sc.nextLine();
   	    }
		
		System.out.print("\nEnter Your Username : ");
		this.userName = sc.nextLine();
		while(userName.isEmpty() || userName.equalsIgnoreCase(name)) {
   		  System.out.print("\nEnter Your Username and username not similar to name : ");
   		  System.out.print("\nEnter Your Username : ");
		  this.userName = sc.nextLine();
	     }
		
		System.out.print("\nEnter Your Password : ");
		this.password = sc.nextLine();
		while(password.isEmpty()) {
   		 System.out.print("\nPassword Should not be empty ! ");
   		 System.out.print("\nEnter Your Password : ");
		 this.password = sc.nextLine();
    	}
		
		System.out.print("\nEnter Your Account Number : ");
		this.accountNo = sc.nextLine();
		while(accountNo.isEmpty() || !(accountNo.length()==8) ) {
   		 System.out.print("\nAccount No. shoud be 8 digit ");
   		 System.out.print("\nEnter Your Account Number : ");
		 this.accountNo = sc.nextLine();
   	 }
		
		System.out.print("\nEnter CardType\n"
				+ "(1.Global International debit card\n "
				+ "2.Platinum International debit card) : ");
		CardType = sc.nextInt();
		while(CardType!=1 && CardType!=2) {
   		 System.out.print("\nCard Type Should be 1 or 2 ");
   		System.out.print("\nEnter CardType\n"
				+ "(1.Global International debit card\n "
				+ "2.Platinum International debit card) : ");
		CardType = sc.nextInt();
   	 }

		System.out.println("\nRegistration completed..kindly login");
	}
	public boolean login() {
		boolean isLogin = false;
		Scanner sc = new Scanner(System.in);
		while ( !isLogin ) {
			System.out.print("\nEnter Your Username : ");
			String Username = sc.nextLine();
			if ( Username.equals(userName) ) {
				while ( !isLogin ) {
					System.out.print("\nEnter Your Password : ");
					String Password = sc.nextLine();
					if ( Password.equals(password) ) {
						System.out.print("\nLogin successful!!");
						isLogin = true;
					}
					else {
						System.out.println("\nIncorrect Password");
					}
				}
			}
			else {
				System.out.println("\nUsername not found");
			}
		}
		return isLogin;
	}
	
	public void withdraw() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Your Password : ");
		String Password = sc.nextLine();
		if ( Password.equals(password) ) {
		
		System.out.print("\nEnter amount to withdraw :  ");
		float amount = sc.nextFloat();
		
		try {
			
			if ( balance >= amount && CardType==1 && amount<=50000 ) {
				transactions++;
				balance -= amount;
				System.out.println("\nWithdraw Successfully");
				String str = amount + " Rs Withdrawed ";
				transactionHistory = transactionHistory.concat(str+formattedDateTime+"\n");
			}
			else if ( balance >= amount && CardType==2 && amount<=100000 ) {
				transactions++;
				balance -= amount;
				System.out.println("\nWithdraw Successfully");
				String str = amount + " Rs Withdrawed ";
				transactionHistory = transactionHistory.concat(str+formattedDateTime+"\n");
			}
			else {
				System.out.println("\nInsufficient Balance or your card daily limit excced ");
			}
			
		}
		catch ( Exception e) {
		}
	}
		else {
			System.out.println("\nIncorrect Password");
		}
	}
	
	public void deposit() {
		
		System.out.print("\nEnter amount to deposit :  ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		
		try {
			if ( amount <= 100000f ) {
				transactions++;
				balance += amount;
				System.out.println("\nSuccessfully Deposited");
				String str = amount + " Rs deposited ";
				transactionHistory = transactionHistory.concat(str+formattedDateTime+"\n");
			}
			else {
				System.out.println("\nSorry...Limit is 100000.00");
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	public void transfer() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Receipent's Name : ");
		String receipent = sc.nextLine();
		System.out.print("\nEnter amount to transfer : ");
		float amount = sc.nextFloat();
		
		try {
			if ( balance >= amount ) {
				if ( amount <= 50000f ) {
					transactions++;
					balance -= amount;
					System.out.println("\nSuccessfully Transfered to " + receipent);
					String str = amount + " Rs transfered to " + receipent + " ";
					transactionHistory = transactionHistory.concat(str+formattedDateTime+"\n");
				}
				else {
					System.out.println("\nSorry...Limit is 50000.00");
				}
			}
			else {
				System.out.println("\nInsufficient Balance");
			}
		}
		catch ( Exception e) {
		}
	}
	
	public void checkBalance() {
		System.out.println("\n" + balance + " Rs");
	}
	
	public void transHistory() {
		System.out.println("\nTransaction History ");
		if ( transactions == 0 ) {
			System.out.println("\nEmpty");
		}
		else {
			System.out.println("\n" + transactionHistory);
		}
	}
}


public class AtmInterface {
	
	
	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) {
					System.out.println("Choose the number between 1 to " + limit+ " : ");
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("Enter only integer value");
				flag = false;
			}
		};
		return input;
	}
	
	
	public static void main(String[] args) {	
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Current Date and Time: " + formattedDateTime);
		
		System.out.println("\n**********WELCOME TO SBI ATM SYSTEM**********\n");
		System.out.println("1.Register \n2.Exit");
		System.out.print("Enter Your Choice : ");
		int choice = takeIntegerInput(2);
		
		if ( choice == 1 ) {
			BankAccount b = new BankAccount();
			b.register();
			while(true) {
				System.out.println("\n1.Login \n2.Exit");
				System.out.print("Enter Your Choice : ");
				int ch = takeIntegerInput(2);
				if ( ch == 1 ) {
					if (b.login()) {
						System.out.println("\n\n**********WELCOME BACK " + b.name + " **********\n");
						boolean isFinished = false;
						while (!isFinished) {
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.print("\nEnter Your Choice : ");
							int c = takeIntegerInput(6);
							switch(c) {
								case 1:
								b.withdraw();
								break;
								case 2:
								b.deposit();
								break;
								case 3:
								b.transfer();
								break;
								case 4:
								b.checkBalance();
								break;
								case 5:
								b.transHistory();
								break;
								case 6:
								isFinished = true;
								break;
							}
						}
					}
				}
				else {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
	}
}	