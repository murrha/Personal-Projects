package emailapp;

import java.util.Scanner;

public class Email {

	//writing out properties of the email for each person
	//all private 
	private String firstName;
	private String lastName; 
	private String password; 
	private String department; 
	private int mailboxCapacity = 500;
	private int defaultLength = 8; 
	private String email; 
	private String alternateEmail; 
	private String companyAt = "centertainment.com"; 
	
	//constructor to receive first and last name 
	public Email(String firstName, String lastName) 
	{
		this.firstName = firstName; //pass through local variables
		this.lastName = lastName; 
		System.out.println("Email for: " + this.firstName + " " + this.lastName); // check
		
		//call method asking for department and return it 
		this.department = setDepartment(); 
		//System.out.println("Department: " + this.department); to check
		
		//call method to return random password 
		this.password = password(defaultLength);
		System.out.println("Your temporary password is: " + this.password); 
		
		//combine to create an email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department + "." + companyAt;
		//System.out.println("Your email is: " + email); to check 
	}
	
	
	//ask for department 
	private String setDepartment()
	{
		System.out.println("DEPARTMENT CODES: \n1) Development\n2) Accounting\n3) Human Resources\n4) Marketing\n5) Intern ");
		Scanner scan = new Scanner(System.in); 
		int input = 0; 
		//checks if the value is an integer or within range
		//prints a statement if invalid and prompts for another input
		do
		{
			System.out.print("Enter department code: ");
			while(!scan.hasNextInt())
			{
				System.out.println("Invalid input. Please try again.");
				System.out.print("Enter department code: ");
				scan.next(); 
			}
			
			input = scan.nextInt(); 
			if(input < 1 || input > 5)
				System.out.println("Invalid input. Please try again.");
			
		} while(input < 1 || input > 5); 
		
		if(input == 1) {return "dev";}
		else if(input == 2) {return "account";}
		else if(input == 3) {return "hr";}
		else if(input == 4) {return "market";}
		else {return "intern";}
	}
	
	//generate random password 
	private String password(int length)
	{
		//list of characters that can be used to generate a random person
		String passwordSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!#$%&<>*"; 
		
		//creating an array of characters
		char[] password = new char[length]; 
		for(int i = 0; i < length; i++)
		{
			int random = (int)(Math.random() * passwordSet.length()); //will generate random numbers from scope 
			password[i] = passwordSet.charAt(random); 
		}
		return new String(password); 
	}
	
	//set mailbox capacity
	public void setMailbox(int capacity)
	{
		this.mailboxCapacity = capacity; //encapsulation 
	}
	
	public int getMailbox()
	{
		return mailboxCapacity; 
	}
	
	//set alternate email
	public void setAltEmail(String altEmail)
	{
		this.alternateEmail = altEmail; 
	}
	
	public String getAltEmail()
	{
		return alternateEmail; 
	}
	
	//change password 
	public void changePassword(String password)
	{
		this.password = password; 
	}

	public String getPassword()
	{
		return password; 
	}
	
	public void showInfo()
	{
		System.out.println("Display name: " + firstName + " " + lastName + " \n" + "Company email: " + email + "\n" + "Mailbox capacity: " + mailboxCapacity + " mb"); 
	}
}
