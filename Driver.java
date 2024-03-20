package SnackCorner;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

interface Login {
	void signup();

	void login();

}
interface mainMenu {
	void menu();
	void payement();
}

class Menu implements Login , mainMenu
{
	static LinkedList food = new LinkedList();
	private String name;
	private long contact = 9763341304l;
	private String email = "siddhantr66@gmail.com";
	private String address;
	private String password = "12345";
	static double totalBill;
	static int quantity;
	static char ch;
	String captcha = "";

	public String getName() {
		return name;
	}

	public void setName() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name:");
		name = sc.nextLine();
		if (name != null && name.length() >= 3 && name.length() <= 20) {
			if (!(name.contains("1")) && !(name.contains("2")) && !(name.contains("3")) && !(name.contains("4"))
					&& !(name.contains("5")) && !(name.contains("6")) && !(name.contains("7")) && !(name.contains("8"))
					&& !(name.contains("9")) && !(name.contains("0"))) {
				if (!(name.contains("!")) && !(name.contains("@")) && !(name.contains("#")) && !(name.contains("$"))
						&& !(name.contains("%")) && !(name.contains("^")) && !(name.contains("&"))
						&& !(name.contains("*")) && !(name.contains("(")) && !(name.contains(")"))) {
					System.out.println("The name is valid");
				} else {
					System.err.println("You are trying to enter special character..");
					setName();

				}
			} else {
				System.err.println("In name you can not pass Integer or special character.....");
				setName();
			}
		} else {
			System.err.println("Either You are entering null value or out of range or number");

			setName();

		}
	}

	public long getContact() {
		return contact;
	}

	public void setContact() {
   try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Mobile Number :");
		contact = sc.nextLong();
		if (contact > 999999999 && contact < 10000000000l) {
			System.out.println("Contact number is valid ");
		} else {
			System.err.println("Please enter 10 digit !! Try again ");
			setContact();
		}
   }
   catch(Exception e)
   {
	   System.err.println("Please enter integer ");
		setContact();
	   
   }

	}

	public String getEmail() {
		return email;
	}

	public void setEmail() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Email:");
		email = sc.nextLine();
		if (email != null && email.length() >= 3 && email.length() <= 30
				&& ((email.contains("@" + "gmail" + "." + "com")) || (email.contains("@" + "gmail" + "." + "com")
						|| email.contains("@" + "Gmail" + "." + "Com") || email.contains("@" + "GMAIL" + "." + "COM")
						|| email.contains("@" + "gMAIL" + "." + "cOM") || email.contains("@" + "GMAIL" + "." + "cOM")
						|| email.contains("@" + "gmail" + "." + "Com")
						|| email.contains("@" + "Gmail" + "." + "com")))) {
			if (!(email.contains("!")) && !(email.contains("#")) && !(email.contains("$")) && !(email.contains("%"))
					&& !(email.contains("^")) && !(email.contains("&")) && !(email.contains("*"))
					&& !(email.contains("(")) && !(email.contains(")"))) {
				System.out.println("The Email is valid");

			} else {
				System.err.println("In email you can not pass Speial Characters");
				setEmail();
			}

		} else {
			System.err.println("Either You are entering null value or not following email syntax");

			setEmail();

		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Address:");
		address = sc.nextLine();
		if (address != null && address.length() >= 3 && address.length() <= 50) {
			System.out.println("The Address is valid");
		} else {
			System.err.println("Either You are entering null value or out of range");

			setAddress();

		}
	}

	public void setPassword() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Strong Password:");
		password = sc.nextLine();
		if (password != null && password.length() == 8) {
			System.out.println("The Password is valid");
		} else {
			System.err.println("Either You are entering null value ");
			System.out.println("Password range must be 8 ");

			setPassword();

		}
	}

	public void signup() {
		Scanner sc = new Scanner(System.in);
		setName();
		setContact();
		verifyOTP();
		setEmail();
		setPassword();
		setAddress();

		System.out.println("Registration is Succesfull");
		System.out.println("");
		System.out.println("Proceed with Login..");
		System.out.println("");
		login();

	}

	int otp;

	public void generateOTP() {
		Random r = new Random();
		int generatedOTP = r.nextInt(10000);
		if (generatedOTP > 999) {
			otp = generatedOTP;
			System.out.println("Generated OTP: " + otp);
		} else {
			generateOTP();
		}
	}

	public void verifyOTP() {
		Scanner sc = new Scanner(System.in);
		generateOTP();

		System.out.println("Enter OTP as same as above:");
		int userOTP = sc.nextInt();

		if (userOTP == otp) {
			System.out.println("OTP Verified Successfully.....");
		} else {
			System.err.println("Incorrect OTP. Try Again....");
			verifyOTP();
		}
	}

	public void login() {
	try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 to use contact for login");
		System.out.println("");
		System.out.println("Press 2 to use email for login");

		int n = sc.nextInt();
		if (n == 1) {
			System.out.println("Enter The Contact Number");
			long contact = sc.nextLong();
			sc.nextLine();
			verify();
			System.out.println("Enter the Password");
			String pass = sc.nextLine();

			if (this.contact == contact && this.password.equals(pass)) {
				System.out.println("Login Successful......");
			} else {
				System.err.println("User Credentials Incorrext");
				login();

			}

		} else if (n == 2) {
			System.out.println("Enter The email");
			sc.nextLine();
			String email = sc.nextLine();
			verify();
			System.out.println("Enter the Password");
			String pass = sc.nextLine();

			if (this.email.equals(email) && this.password.equals(pass)) {
				System.out.println("Login Successful...");
			} else {
				System.err.println("User Credentials Incorrext");
				login();

			}

		}

		else {
			System.err.println("Wronng Choice!!! Please Try again");
			login();

		}
	}catch(Exception e)
	{
		System.err.println("Wronng Choice!!! Please Try again");
		login();
	}
		

	}


	public void generate() {
		Random r = new Random();

		while (captcha.length() < 5) {
			int i = r.nextInt(123);
			if ((i >= 65 && i <= 90) || (i >= 97 && i <= 122)) {
				char randomChar = (char) i;
				captcha = captcha + randomChar;

			}

		}
		System.out.println("Generated Captcha :" + captcha);

	}

	public void verify() {
		generate();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Captcha Same as above");
		String Captcha = sc.next();
		if (this.captcha.equals(Captcha)) {
			System.out.println("Captcha is Correct....");
		} else {
			System.err.println("Captcha is Incorrect......");
			captcha = "";
			verify();
		}
	}

	public void menu() {
		try {
		Scanner sc = new Scanner(System.in);

		System.out.println("Press 1 for  Starters");

		System.out.println("Press 2 for Main Course");

		System.out.println("Press 3 for Deserts");

		System.out.println("Press 4 for Drinks");
		
		System.out.println("Press 5 for Special-Thali");
		

		System.out.println("Press 6 for Exit");

		int x = sc.nextInt();
		switch (x) {

		case 1:
			Straters s = new Straters();
			s.startersMenu();

			break;

		case 2:
			Main_Course mc = new Main_Course();
			mc.Main_Courses_Menu();

			break;
		case 3:
			Desserts ds = new Desserts();
			ds.DessertsMenu();
			break;
		case 4:
			Drinks d = new Drinks();
			d.Drinks_Menu();
			break;
			
		case 5:
			SpecialThali st = new SpecialThali();
			st.specialThali_menu();
			
			break;
			
		case 6:
			System.out.println("Thank You For Visisting ....");

			System.exit(0);

		default:
			System.err.print("Please Try Again");
		}
		}
		catch(Exception e)
		{
			System.err.print("Please Try Again");
			menu();
			
		}

	}

	public void payement() {
		
		System.out.println("Name: " + name);
		System.out.println("Contact: " + contact);
		System.out.println("Email: " + email);

		for (Object obj : food) {

			System.err.println( obj);

		}

		System.out.println("Your Bill :" + totalBill);
		double gst = 0.18; // 18% GST
		System.out.println("Gst :" + gst);
		double totalBillWithGST = totalBill + (totalBill * gst);

		System.out.println("Total Bill With GST: " + totalBillWithGST);

		System.err.println("Maccha Your Order Has Been Placed ....");

		System.out.println("---- Thank You ----");
	}
}

class Straters extends Menu {
	public void startersMenu() {
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Veg Starters :");

		System.out.println("Press 2 for Non Veg Starters :");

		System.out.println("Press 3 to go Back");

		int x = sc.nextInt();
		switch (x) {
		case 1:
			Veg_Straters vs = new Veg_Straters();
			vs.vegStarters();
			break;
		case 2:
			Nonveg_Straters nv = new Nonveg_Straters();
			nv.Nonveg_Straters();
			break;
		case 3:
			menu();
		default:
			System.err.print("Please Try Again !!!......");

		}
	}
		catch(Exception e)
		{
			System.err.print("Please Try Again !!!......");
			startersMenu();
		}
	}
	

}

class Veg_Straters extends Straters {

	public void vegStarters() {
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Chinese Starters");

		System.out.println("Press 2 for South Indian Staters");

		System.out.println("Press 3 for North Indian Starters");

		System.out.println("Press 4 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			chineseStarters();

			break;
		case 2:
			southIndianStarters();
			break;
		case 3:
			northIndianStarters();
			break;
		case 4:
			startersMenu();
			break;
		default:
			System.err.println("Please choose correct option");
			vegStarters();
			break;
		}
		}
		catch(Exception e)
		{
			System.err.println("Please chose integer");
			vegStarters();
			
		}
	}

	public void chineseStarters() {
		try {

		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Soya Chilly");
		System.out.println("Press 2 for Manchurian");
		System.out.println("Press 3 for Paneer Crispy");
		System.out.println("Press 4 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:

			System.out.println("Price of Soya Chilly is Rs 120");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();

			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				chineseStarters();
			} else {

				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Soya Chilly && Price::120 ");
					totalBill = totalBill + (120 * quantity);
					food.add("Quantity :" + quantity);

					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						chineseStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					chineseStarters();
				} else {
					System.err.println("Please choose correct option");
					chineseStarters();
				}
			}
			break;
		case 2:
			System.out.println("Price of Manchurian is Rs 150");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				chineseStarters();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Manchurian && Price::150 ");
					food.add("Quantity :" + quantity);

					totalBill = totalBill + (150 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						chineseStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					chineseStarters();
				} else {
					System.err.println("Please choose correct option");
					chineseStarters();
				}
			}
			break;
		case 3:
			System.out.println("Price of Panner Crispy is Rs 200");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				chineseStarters();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Panner Crispy && Price::200 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (200 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						chineseStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					chineseStarters();
				} else {
					System.err.println("Please choose correct option");
					chineseStarters();
				}
			}
			break;
		case 4:
			vegStarters();
			break;
		default:
			System.err.println("Sahi sahi choose kar");
			chineseStarters();
		
		}
		}
		catch(Exception e)
		{
			System.err.println("Sahi sahi choose kar");
			chineseStarters();
			
		}

	}

	public void southIndianStarters() 
	{
		try 
		{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 For Dal Vada");
		System.out.println("Press 2 For Idly");
		System.out.println("Press 3 For Masala Vada");
		System.out.println("Press 4 To Go Back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("Price For Dal Vada Is Rs 200");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				southIndianStarters();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Dal Vada && Price::200 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (200 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						southIndianStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;

					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					southIndianStarters();
				} else {
					System.err.println("Please choose correct option");
					southIndianStarters();
				}
			}
			break;
		case 2:
			System.out.println("Price For Idly Is Rs 100");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				southIndianStarters();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Idly && Price::100 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (100 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						southIndianStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;

					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					southIndianStarters();
				} else {
					System.err.println("Please choose correct option");
					southIndianStarters();
				}
			}
			break;
		case 3:
			System.out.println("Price For  Masala Vada Is Rs 150");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				southIndianStarters();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item :Masala Vada && Price::150 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (150 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						southIndianStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;

					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					southIndianStarters();
				} else {
					System.err.println("Please choose correct option");
					southIndianStarters();
				}
			}
			break;

		case 4:
			vegStarters();

			break;
		default:
			System.err.println("Sahi sahi choose kar");
			chineseStarters();

		}
		}
		catch(Exception e)
		{
			System.err.println("Please chose integer");
			chineseStarters();
			
		}
		
	}

	public void northIndianStarters()
	{
		try 
		{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 For Paneer Tikka");
		System.out.println("Press 2 For Samosas");
		System.out.println("Press 3 For Aloo Chaat");
		System.out.println("Press 4 To Go Back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("Price For Paneer Tikka Is Rs 400");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				northIndianStarters();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item :Paneer Tikka && Price::400 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (400 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						northIndianStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;

					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					northIndianStarters();
				} else {
					System.err.println("Please choose correct option");
					northIndianStarters();
				}
			}
			break;
		case 2:
			System.out.println("Price For Samosas Is Rs 120");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				northIndianStarters();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item :Samosas && Price::120 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (120 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						northIndianStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;

					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					northIndianStarters();
				} else {
					System.err.println("Please choose correct option");
					northIndianStarters();
				}
			}
			break;

		case 3:
			System.out.println("Price For Aloo Chaat Is Rs 200");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				northIndianStarters();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item :Aloo Chaat && Price::200 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (200 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						northIndianStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;

					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					northIndianStarters();
				} else {
					System.err.println("Please choose correct option");
					northIndianStarters();
				}
			}
			break;
		default:
			System.err.println("Sahi sahi choose kar");
			chineseStarters();

		}
	}
	catch(Exception e)
		{
		System.err.println("Sahi sahi choose kar");
		chineseStarters();
		}
		
}

}

class Nonveg_Straters extends Straters {
	public void Nonveg_Straters() 
	{ try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Non-Veg Chinese Starters");

		System.out.println("Press 2 for Non-Veg South Indian Staters");

		System.out.println("Press 3 for Non-Veg North Indian Starters");

		System.out.println("Press 4 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			non_vegchineseStarters();
			break;
		case 2:
			non_vegSouthStarters();
			break;
		case 3:
			non_vegNorthStarters();
			break;
		case 4:
			startersMenu();
			// break;
		default:
			System.err.println("Please choose correct option");
			Nonveg_Straters();
			break;
		}
	}
	catch(Exception e)
	{
		System.err.println("Please choose correct option");
		Nonveg_Straters();
		
	}
	}

	public void non_vegchineseStarters() {
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Chicken Manchurian");
		System.out.println("Press 2 for Chilli Chicken");
		System.out.println("Press 3 for Szechuan Prawns");
		System.out.println("Press 4 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("Price For Chicken Manchurian Is Rs 400");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				non_vegchineseStarters();
			} else {
				System.out.println("Choose Y to order or N to go back");
				char ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item :Chicken Manchurian && Price::400 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (400 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						non_vegchineseStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;

					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					non_vegchineseStarters();
				} else {
					System.err.println("Please choose correct option");
					non_vegchineseStarters();
				}
			}
			break;
		case 2:
			System.out.println("Price For Chilli Chicken Is Rs 800");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				non_vegchineseStarters();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item : Chilli Chicken && Price::800 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (800 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						non_vegchineseStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;

					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					non_vegchineseStarters();
				} else {
					System.err.println("Please choose correct option");
					non_vegchineseStarters();
				}
			}
			break;
		case 3:
			System.out.println("Price For Szechuan Prawns Is Rs 1000");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				non_vegchineseStarters();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item : Szechuan Prawns && Price::1000 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (1000 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						non_vegchineseStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;

					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					non_vegchineseStarters();
				} else {
					System.err.println("Please choose correct option");
					non_vegchineseStarters();
				}
			}
			break;
		default:
			System.err.println("Sahi sahi choose kar");
			non_vegchineseStarters();
		}
		}
		catch(Exception e)
		{
			System.err.println("Sahi sahi choose kar");
			non_vegchineseStarters();
		}
	}

	public void non_vegSouthStarters() 
	{
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Chicken 65 ");
		System.out.println("Press 2 for Fish Fry");
		System.out.println("Press 3 for Kerala Chicken Roast");
		System.out.println("Press 4 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("Price For Chicken 65 Is Rs 499");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				non_vegSouthStarters();
			} else {
				System.out.println("Choose Y to order or N to go back");
				char ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item : Chicken 65 && Price::499 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (499 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						non_vegSouthStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;

					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					non_vegSouthStarters();
				} else {
					System.err.println("Please choose correct option");
					non_vegSouthStarters();
				}
			}
			break;
		case 2:
			System.out.println("Price For Fish Fry Is Rs 899");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				non_vegSouthStarters();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item : Fish Fry  && Price::899 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (899 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						non_vegSouthStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;

					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					non_vegSouthStarters();
				} else {
					System.err.println("Please choose correct option");
					non_vegSouthStarters();
				}
			}
			break;
		case 3:
			System.out.println("Price For  Kerala Chicken Roast Is Rs 1499");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				non_vegSouthStarters();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item : Kerala Chicken Roast  && Price::1499 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (1499 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						non_vegSouthStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;

					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					non_vegSouthStarters();
				} else {
					System.err.println("Please choose correct option");
					non_vegSouthStarters();
				}
			}
			break;
		default:
			System.err.println("Sahi sahi choose kar");
			non_vegSouthStarters();
		}
		}
		catch(Exception e)
		{
			System.err.println("Sahi sahi choose kar");
		    non_vegSouthStarters();
			
		}

	}

	public void non_vegNorthStarters() {
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Chicken Tikka ");
		System.out.println("Press 2 for Seekh Kebabs");
		System.out.println("Press 3 for Tandoori Chicken");
		System.out.println("Press 4 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("Price For Chicken Tikka Is Rs 599");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				non_vegNorthStarters();
			} else {
				System.out.println("Choose Y to order or N to go back");
				char ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item :  Chicken Tikka  && Price::599 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (599 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						non_vegNorthStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;

					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					non_vegNorthStarters();
				} else {
					System.err.println("Please choose correct option");
					non_vegNorthStarters();
				}
			}
			break;
		case 2:
			System.out.println("Price For Seekh Kebabs Is Rs 999");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				non_vegNorthStarters();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item :  Seekh Kebabs && Price::999 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (999 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						non_vegNorthStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;

					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					non_vegNorthStarters();
				} else {
					System.err.println("Please choose correct option");
					non_vegNorthStarters();
				}
			}
			break;
		case 3:
			System.out.println("Price For  Kerala Tandoori Chicken Is Rs 699");
			quantity = sc.nextInt();
			System.out.println("Enter the quantity:");
			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				non_vegNorthStarters();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item :  Tandoori Chicken && Price::699 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (699 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						non_vegNorthStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;

					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					non_vegNorthStarters();
				} else {
					System.err.println("Please choose correct option");
					non_vegNorthStarters();
				}
			}
			break;
		default:
			System.err.println("Sahi sahi choose kar");
			non_vegNorthStarters();
		}

	}
		catch(Exception e)
		{
			System.err.println("Sahi sahi choose kar");
			non_vegNorthStarters();
		}
	}
	
}

class Main_Course extends Menu {
	public void Main_Courses_Menu() {
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Veg Main_Courses :");

		System.out.println("Press 2 for Non Veg Main_Courses :");

		System.out.println("Press 3 to go Back");

		int x = sc.nextInt();
		switch (x) {
		case 1:
			Veg_Main_Courses vmc = new Veg_Main_Courses();
			vmc.vegMain_Courses();
			break;
		case 2:
			nonVeg_Main_Courses nvmc = new nonVeg_Main_Courses();
			nvmc.nonvegMain_Courses();

			break;
		case 3:
			menu();
		default:
			System.err.print("Please Try Again !!!......");

		}


		}
		catch(Exception e)
		{
			System.err.print("Please Try Again !!!......");
			Main_Courses_Menu();
		}
	}

}

class Veg_Main_Courses extends Main_Course {
	public void vegMain_Courses() 
	{
		try 
	{
		
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Chinese Main_Course");

		System.out.println("Press 2 for South Indian Main_Course");

		System.out.println("Press 3 for North Indian Main_Courses");

		System.out.println("Press 4 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			chineseMain_Course();

			break;
		case 2:
			southindianmain_course();
			break;
		case 3:
			northindianmain_course();
			break;
		case 4:
			Main_Courses_Menu();
			break;
		default:
			System.err.println("Please choose correct option");
			vegMain_Courses();
			break;
		}
	}
		catch(Exception e)
		{
			System.err.println("Please choose correct option");
			vegMain_Courses();
		}
	}

	public void chineseMain_Course()
	{
         try
         {
        	 
        
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Vegetable Fried Rice");
		System.out.println("Press 2 for Paneer Szechuan");
		System.out.println("Press 3 for Vegetable Hakka Noodles");
		System.out.println("Press 4 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:

			System.out.println("Price of Vegetable Fried Rice is Rs 350");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();

			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				chineseMain_Course();
			} else {

				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Vegetable Fried Rice && Price::350 ");
					totalBill = totalBill + (350 * quantity);
					food.add("Quantity :" + quantity);

					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						chineseMain_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					chineseMain_Course();
				} else {
					System.err.println("Please choose correct option");
					chineseMain_Course();
				}
			}
			break;
		case 2:
			System.out.println("Price of Paneer Szechuan is Rs 120");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.err.println("Quantity can not be Zero...");
				chineseMain_Course();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Pongal && Price::120 ");
					food.add("Quantity :" + quantity);

					totalBill = totalBill + (120 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						chineseMain_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					chineseMain_Course();
				} else {
					System.err.println("Please choose correct option");
					chineseMain_Course();
				}
			}
			break;
		case 3:
			System.out.println("Price of Vegetable Hakka Noodles is Rs 250");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.err.println("Quantity can not be Zero...");
				chineseMain_Course();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Vegetable Hakka Noodles && Price::250 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (250 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						chineseMain_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					chineseMain_Course();
				} else {
					System.err.println("Please choose correct option");
					chineseMain_Course();
				}
			}
			break;
		case 4:
			vegMain_Courses();
			break;
		default:
			System.err.println("Sahi sahi choose kar");
			chineseMain_Course();
		}
         }
         catch(Exception e)
         {
        	 System.err.println("Sahi sahi choose kar");
 			chineseMain_Course();
         }

	}

	public void southindianmain_course() 
	{
       try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Vegetable Biryani");
		System.out.println("Press 2 for Pongal");
		System.out.println("Press 3 for Vegetable Korma");
		System.out.println("Press 4 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:

			System.out.println("Price of Vegetable Biryani is Rs 150");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();

			if (quantity == 0) {
				System.err.println("Quantity can not be Zero...");
				southindianmain_course();
			} else {

				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Vegetable Biryani && Price::150 ");
					totalBill = totalBill + (150 * quantity);
					food.add("Quantity :" + quantity);

					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						southindianmain_course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					southindianmain_course();
				} else {
					System.err.println("Please choose correct option");
					southindianmain_course();
				}
			}
			break;
		case 2:
			System.out.println("Price of Pongal is Rs 120");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.err.println("Quantity can not be Zero...");
				southindianmain_course();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Pongal && Price::120 ");
					food.add("Quantity :" + quantity);

					totalBill = totalBill + (120 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						southindianmain_course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					southindianmain_course();
				} else {
					System.err.println("Please choose correct option");
					southindianmain_course();
				}
			}
			break;
		case 3:
			System.out.println("Price of Vegetable Hakka Noodles is Rs 250");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.err.println("Quantity can not be Zero...");
				southindianmain_course();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Vegetable Korma && Price::200 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (200 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						southindianmain_course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					southindianmain_course();
				} else {
					System.err.println("Please choose correct option");
					southindianmain_course();
				}
			}
			break;
		case 4:

			vegMain_Courses();
			break;

		default:
			System.err.println("Sahi sahi choose kar");
			southindianmain_course();
		}
       }
       catch(Exception e)
       {
    	   System.err.println("Sahi sahi choose kar");
			southindianmain_course();
       }

	}

	public void northindianmain_course() 
	{
        try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Paneer Butter Masala");
		System.out.println("Press 2 for Dal Makhani");
		System.out.println("Press 3 for Palak Paneer");
		System.out.println("Press 4 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:

			System.out.println("Price of Paneer Butter Masala is Rs 250");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();

			if (quantity == 0) {
				System.err.println("Quantity can not be Zero...");
				northindianmain_course();
			} else {

				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Paneer Butter Masala && Price::250 ");
					totalBill = totalBill + (250 * quantity);
					food.add("Quantity :" + quantity);

					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						northindianmain_course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					northindianmain_course();
				} else {
					System.err.println("Please choose correct option");
					northindianmain_course();
				}
			}
			break;
		case 2:
			System.out.println("Price of Dal Makhani is Rs 200");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.err.println("Quantity can not be Zero...");
				northindianmain_course();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Dal Makhani && Price::200 ");
					food.add("Quantity :" + quantity);

					totalBill = totalBill + (200 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						northindianmain_course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					northindianmain_course();
				} else {
					System.err.println("Please choose correct option");
					northindianmain_course();
				}
			}
			break;
		case 3:
			System.out.println("Price ofPalak Paneer is Rs 220");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.err.println("Quantity can not be Zero...");
				northindianmain_course();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Palak Paneer && Price::220 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (220 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						northindianmain_course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					northindianmain_course();
				} else {
					System.err.println("Please choose correct option");
					northindianmain_course();
				}
			}
			break;

		case 4:

			vegMain_Courses();
			break;

		default:
			System.err.println("Sahi sahi choose kar");
			northindianmain_course();
		}

	}
        catch(Exception e)
    	{
    		System.err.println("Sahi sahi choose kar");
    		northindianmain_course();
    		
    	}
	}
	

}

class nonVeg_Main_Courses extends Main_Course {
	public void nonvegMain_Courses() 
	{
		try
		{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Chinese NonVeg_Main_Course");

		System.out.println("Press 2 for South NonVeg_Indian Main_Course");

		System.out.println("Press 3 for North NonVeg_Indian Main_Courses");

		System.out.println("Press 4 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			nonvegchineseMain_Course();

			break;
		case 2:
			nonvegSouthMain_Course();
			break;
		case 3:
			nonvegNorthMain_Course();
			break;
		case 4:
			Main_Courses_Menu();
			break;
		default:
			System.err.println("Please choose correct option");
			nonvegMain_Courses();
			break;
		}
		}
		catch(Exception e)
		{
			System.err.println("Please choose correct option");
			nonvegMain_Courses();
		}
	}

	public void nonvegchineseMain_Course() 
	{

		try
		{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Chicken Curry");
		System.out.println("Press 2 for Chicken Tikka Masala");
		System.out.println("Press 3 for Rogan Josh");
		System.out.println("Press 4 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:

			System.out.println("Price of Chicken Curry is Rs 450");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();

			if (quantity == 0) {
				System.out.println("Quantity can not be Zero...");
				nonvegchineseMain_Course();
			} else {

				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Chicken Curry && Price::450 ");
					totalBill = totalBill + (450 * quantity);
					food.add("Quantity :" + quantity);

					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						nonvegchineseMain_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					nonvegchineseMain_Course();
				} else {
					System.err.println("Please choose correct option");
					nonvegchineseMain_Course();
				}
			}
			break;
		case 2:
			System.out.println("Price of Chicken Tikka Masala is Rs 799");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) {
				System.err.println("Quantity can not be Zero...");
				nonvegchineseMain_Course();
			} else {
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Chicken Tikka Masala && Price::799 ");
					food.add("Quantity :" + quantity);

					totalBill = totalBill + (799 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						nonvegchineseMain_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					nonvegchineseMain_Course();
				} else {
					System.err.println("Please choose correct option");
					nonvegchineseMain_Course();
				}
			}
			break;
		case 3:
			System.out.println("Price of Rogan Josh is Rs 450");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0) 
			{
				System.err.println("Quantity can not be Zero...");
				nonvegchineseMain_Course();
			} else
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') 
				{
					System.out.println("Order has been confirmed");
					food.add("Item ::Rogan Josh && Price::450 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (450 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n)
					{
					case 1:
						nonvegchineseMain_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N')
				{
					System.out.println("Choose another item");
					nonvegchineseMain_Course();
				} else 
				{
					System.err.println("Please choose correct option");
					nonvegchineseMain_Course();
				}
			}
			break;
		case 4:
			nonvegchineseMain_Course();
			break;
		default:
			System.err.println("Sahi sahi choose kar");
			nonvegchineseMain_Course();
		}
		}
		catch(Exception e)
		{
			System.err.println("Sahi sahi choose kar");
		nonvegchineseMain_Course();
			
		}

	}
	public void nonvegNorthMain_Course()
	{
try 
{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Butter Chicken (Murgh Makhani)");
		System.out.println("Press 2 for Chicken Tikka Masala");
		System.out.println("Press 3 for Fish Curry");
		System.out.println("Press 4 to go back");
		int n = sc.nextInt();
		switch (n) 
		{
		case 1:

			System.out.println("Price ofButter Chicken (Murgh Makhani) is Rs 950");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();

			if (quantity == 0)
			{
				System.out.println("Quantity can not be Zero...");
				nonvegNorthMain_Course();
			} 
			else 
			{

				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') 
				{
					System.out.println("Order has been confirmed");
					food.add("Item ::Butter Chicken (Murgh Makhani) && Price::950 ");
					totalBill = totalBill + (950 * quantity);
					food.add("Quantity :" + quantity);

					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						nonvegNorthMain_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') 
				{
					System.out.println("Choose another item");
					nonvegNorthMain_Course();
				} else 
				{
					System.err.println("Please choose correct option");
					nonvegNorthMain_Course();
				}
			}
			break;
		case 2:
			System.out.println("Price of Chicken Tikka Masalais Rs 599");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				nonvegNorthMain_Course();
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') 
				{
					System.out.println("Order has been confirmed");
					food.add("Item ::Chicken Tikka Masala && Price::599 ");
					food.add("Quantity :" + quantity);

					totalBill = totalBill + (599 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						nonvegNorthMain_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} 
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					nonvegNorthMain_Course();
				} else
				{
					System.err.println("Please choose correct option");
					nonvegNorthMain_Course();
				}
			}
			break;
		case 3:
			System.out.println("Price of Fish Curryis Rs 850");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				nonvegNorthMain_Course();
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Fish Curry  && Price::850 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (850 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						nonvegNorthMain_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				}
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					nonvegNorthMain_Course();
				} 
				else 
				{
					System.err.println("Please choose correct option");
					nonvegNorthMain_Course();
				}
			}
			break;
		case 4:
			nonvegNorthMain_Course();
			break;
		default:
			System.err.println("Sahi sahi choose kar");
			nonvegNorthMain_Course();
		}

	}
	
	catch(Exception e)
	{
		System.err.println("Sahi sahi choose kar");
		nonvegNorthMain_Course();
	}
	}
	
	public void nonvegSouthMain_Course()
	{
try 
{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Chettinad Chicken Curry");
		System.out.println("Press 2 for Andhra Chicken Curry");
		System.out.println("Press 3 for Mutton Curry");
		System.out.println("Press 4 to go back");
		int n = sc.nextInt();
		switch (n) 
		{
		case 1:

			System.out.println("Price of Chettinad Chicken Curry is Rs 950");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();

			if (quantity == 0)
			{
				System.out.println("Quantity can not be Zero...");
				nonvegSouthMain_Course();
			} 
			else 
			{

				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') 
				{
					System.out.println("Order has been confirmed");
					food.add("Item ::Chettinad Chicken Curry && Price::950 ");
					totalBill = totalBill + (950 * quantity);
					food.add("Quantity :" + quantity);

					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						nonvegSouthMain_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') 
				{
					System.out.println("Choose another item");
					nonvegSouthMain_Course();
				} else 
				{
					System.err.println("Please choose correct option");
					nonvegSouthMain_Course();
				}
			}
			break;
		case 2:
			System.out.println("Price of Andhra Chicken Curry is Rs 799");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				nonvegSouthMain_Course();
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') 
				{
					System.out.println("Order has been confirmed");
					food.add("Item ::Andhra Chicken Curry && Price::799 ");
					food.add("Quantity :" + quantity);

					totalBill = totalBill + (799 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						nonvegSouthMain_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} 
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					nonvegSouthMain_Course();
				} else
				{
					System.err.println("Please choose correct option");
					nonvegSouthMain_Course();
				}
			}
			break;
		case 3:
			System.out.println("Price of Mutton Curry is Rs 650");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				nonvegSouthMain_Course();
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Mutton Curry  && Price::650 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (650 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						nonvegSouthMain_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				}
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					nonvegSouthMain_Course();
				} 
				else 
				{
					System.err.println("Please choose correct option");
					nonvegSouthMain_Course();
				}
			}
			break;
		case 4:
			nonvegSouthMain_Course();
			break;
		default:
			System.err.println("Sahi sahi choose kar");
			nonvegSouthMain_Course();
		}

	}
	
	catch(Exception e)
	{
		System.err.println("Sahi sahi choose kar");
		nonvegSouthMain_Course();
	}
	}
	
	

}

class Drinks extends Menu {
	public void Drinks_Menu() {
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Soft Drinks :");

		System.out.println("Press 2 for Hard Drinks :");

		System.out.println("Press 3 to go Back");

		int x = sc.nextInt();
		switch (x) {
		case 1:
			soft_drinks sd = new soft_drinks();
			sd.soft_drinks_Course();
			
			break;
		case 2:
			hard_drinks hd = new hard_drinks();
			hd.HardDrinks_menu() ;
			

			break;
		case 3:
			menu();
		default:
			System.err.print("Please Try Again !!!......");
			Drinks_Menu();

		}


		}
		catch(Exception e)
		{
			System.err.print("Please Try Again !!!......");
			Drinks_Menu();
		}
	}
	

}
class soft_drinks extends Drinks{
	public void soft_drinks_Course()
	{
try 
{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Coco - Cola");
		System.out.println("Press 2 for Pepsi");
		System.out.println("Press 3 for Sprite");
		System.out.println("Press 4 for Mountain Dew");
		System.out.println("Press 5 for Lassi");
		System.out.println("Press 6 for Bisleri");
		System.out.println("Press 7 for Dr.peper");
		System.out.println("Press 8 for Massala Chai");
		System.out.println("Press 9 for Fanta");
		
		System.out.println("Press 10 to go back");
		int n = sc.nextInt();
		switch (n) 
		{
		case 1:

			System.out.println("Price of Coco - Cola is Rs 50");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();

			if (quantity == 0)
			{
				System.out.println("Quantity can not be Zero...");
				soft_drinks_Course();
			} 
			else 
			{

				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') 
				{
					System.out.println("Order has been confirmed");
					food.add("Item ::Coco - Cola && Price::50 ");
					totalBill = totalBill + (50 * quantity);
					food.add("Quantity :" + quantity);

					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						soft_drinks_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') 
				{
					System.out.println("Choose another item");
					soft_drinks_Course();
				} else 
				{
					System.err.println("Please choose correct option");
					soft_drinks_Course();
				}
			}
			break;
		case 2:
			System.out.println("Price of Pepsi is Rs  49");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				soft_drinks_Course();			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') 
				{
					System.out.println("Order has been confirmed");
					food.add("Item ::Pepsi && Price:: 49 ");
					food.add("Quantity :" + quantity);

					totalBill = totalBill + (49 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						soft_drinks_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} 
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					soft_drinks_Course();
				} else
				{
					System.err.println("Please choose correct option");
					soft_drinks_Course();
				}
			}
			break;
		case 3:
			System.out.println("Price of Sprite is Rs 40");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				soft_drinks_Course();
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Sprite && Price::40 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (40 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						soft_drinks_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				}
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					soft_drinks_Course();
				} 
				else 
				{
					System.err.println("Please choose correct option");
					soft_drinks_Course();
				}
			}
			break;
		case 4:
			System.out.println("Price of Mountain Dew is Rs 40");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				soft_drinks_Course();
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Mountain Dew && Price::40 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (40 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						soft_drinks_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				}
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					soft_drinks_Course();
				} 
				else 
				{
					System.err.println("Please choose correct option");
					soft_drinks_Course();
				}
			}
			break;
		case 5:
			System.out.println("Price of Lassi is Rs 65");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				soft_drinks_Course();
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Lasi && Price::40 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (65 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						soft_drinks_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				}
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					soft_drinks_Course();
				} 
				else 
				{
					System.err.println("Please choose correct option");
					soft_drinks_Course();
				}
			}
			break;
			
		case 6:
			System.out.println("Price of Bisleri is Rs 20");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				soft_drinks_Course();
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Bisleri && Price::20 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (20 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						soft_drinks_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				}
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					soft_drinks_Course();
				} 
				else 
				{
					System.err.println("Please choose correct option");
					soft_drinks_Course();
				}
			}
			break;
		
			
		case 7:
			System.out.println("Price of Dr.peper is Rs 20");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				soft_drinks_Course();
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Dr.peper && Price::20 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (20 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						soft_drinks_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				}
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					soft_drinks_Course();
				} 
				else 
				{
					System.err.println("Please choose correct option");
					soft_drinks_Course();
				}
			}
			break;
		case 8:
			System.out.println("Price of Massala Chai is Rs 35");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				soft_drinks_Course();
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Massala Chai && Price::35 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (35 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						soft_drinks_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				}
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					soft_drinks_Course();
				} 
				else 
				{
					System.err.println("Please choose correct option");
					soft_drinks_Course();
				}
			}
			break;
			
			
		case 9:
			System.out.println("Price of Fanta is Rs 39");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				soft_drinks_Course();
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Fanta && Price::39 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (39 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						soft_drinks_Course();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				}
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					soft_drinks_Course();
				} 
				else 
				{
					System.err.println("Please choose correct option");
					soft_drinks_Course();
				}
			}
			break;
			
		case 10:
			soft_drinks_Course();
			break;
		default:
			System.err.println("Sahi sahi choose kar");
			soft_drinks_Course();
		}

	}
	
	catch(Exception e)
	{
		System.err.println("Sahi sahi choose kar");
		soft_drinks_Course();
	}
	}
	
	
	
}
class hard_drinks extends Drinks{
	public void HardDrinks_menu() 
	{

		try
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your age: ");
			int age = sc.nextInt();
			if(age >=18)
			{
			System.out.println("Press 1 for Whiskey :");

			System.out.println("Press 2 for Rum :");
			
			System.out.println("Press 3 for Vodka: ");

			System.out.println("Press 4 to go Back");

			int x = sc.nextInt();
			switch (x) {
			case 1:
				whiskey();
				
				break;
			case 2:
				Rum();

				break;
            case 3:
            	vodka();

			   break;
				
			case 4:
				menu();
			default:
				System.err.print("Please Try Again !!!......");
				Drinks_Menu();

			}


			}
			else {
				System.out.println("You must drink Milk not an alcohol");
				menu();
				
			}
		}
			catch(Exception e)
			{
				System.err.print("Please Try Again !!!......");
				Drinks_Menu();
			}
		}
	public void whiskey()
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			
			
			System.out.println("Press 1 for McDowell's No. 1:");

			System.out.println("Press 2 for Royal Stag:");
			
			System.out.println("Press 3 for Old Monk: ");

			System.out.println("Press 4 to go Back");

			int n = sc.nextInt();
			switch (n) {
			case 1:

				System.out.println("Price of McDowell's No. 1 is Rs 950");
				System.out.println("Enter the quantity:");
				quantity = sc.nextInt();

				if (quantity == 0)
				{
					System.out.println("Quantity can not be Zero...");
					whiskey();
				} 
				else 
				{

					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') 
					{
						System.out.println("Order has been confirmed");
						food.add("Item ::McDowell's No. 1 && Price::950 ");
						totalBill = totalBill + (950 * quantity);
						food.add("Quantity :" + quantity);

						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							whiskey();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					} else if (ch == 'n' || ch == 'N') 
					{
						System.out.println("Choose another item");
						whiskey();
					} else 
					{
						System.err.println("Please choose correct option");
						whiskey();
					}
				}
				break;
			case 2:
				System.out.println("Price of Royal Stagis Rs  999");
				System.out.println("Enter the quantity:");
				quantity = sc.nextInt();
				if (quantity == 0)
				{
					System.err.println("Quantity can not be Zero...");
					whiskey();		
					
				} else 
				{
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') 
					{
						System.out.println("Order has been confirmed");
						food.add("Item ::Royal Stag&& Price:: 999 ");
						food.add("Quantity :" + quantity);

						totalBill = totalBill + (999 * quantity);
						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							whiskey();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					} 
					else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						whiskey();
					} else
					{
						System.err.println("Please choose correct option");
						whiskey();
					}
				}
				break;
			case 3:
				System.out.println("Price of Old Monk is Rs 1299");
				System.out.println("Enter the quantity:");
				quantity = sc.nextInt();
				if (quantity == 0)
				{
					System.err.println("Quantity can not be Zero...");
					whiskey();
				} else 
				{
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') {
						System.out.println("Order has been confirmed");
						food.add("Item ::Old Monk && Price::1299 ");
						food.add("Quantity :" + quantity);
						totalBill = totalBill + (1299 * quantity);
						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							whiskey();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					}
					else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						whiskey();
					} 
					else 
					{
						System.err.println("Please choose correct option");
						whiskey();
					}
				}
				break;
				
			case 4:
				menu();
			default:
				System.err.print("Please Try Again !!!......");
				Drinks_Menu();

			}


			
		
		}
			catch(Exception e)
			{
			System.err.print("Please Try Again !!!......");
				Drinks_Menu();
			}
		
	}
	public void Rum()
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			
			
			System.out.println("Press 1 for Jolly Roger Rum:");

			System.out.println("Press 2 for Captain Morgan:");
			
			System.out.println("Press 3 for Bacardi: ");

			System.out.println("Press 4 to go Back");

			int n = sc.nextInt();
			switch (n) {
			case 1:

				System.out.println("Price of Jolly Roger Rum is Rs 1250");
				System.out.println("Enter the quantity:");
				quantity = sc.nextInt();

				if (quantity == 0)
				{
					System.out.println("Quantity can not be Zero...");
					Rum();
				} 
				else 
				{

					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') 
					{
						System.out.println("Order has been confirmed");
						food.add("Item ::Jolly Roger Rum && Price::1250 ");
						totalBill = totalBill + (1250 * quantity);
						food.add("Quantity :" + quantity);

						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							Rum();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					} else if (ch == 'n' || ch == 'N') 
					{
						System.out.println("Choose another item");
						Rum();
					} else 
					{
						System.err.println("Please choose correct option");
						Rum();
					}
				}
				break;
			case 2:
				System.out.println("Price of Captain Morgan Rs  2499");
				System.out.println("Enter the quantity:");
				quantity = sc.nextInt();
				if (quantity == 0)
				{
					System.err.println("Quantity can not be Zero...");
					Rum();	
					
				} else 
				{
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') 
					{
						System.out.println("Order has been confirmed");
						food.add("Item ::Captain Morgan && Price:: 2499 ");
						food.add("Quantity :" + quantity);

						totalBill = totalBill + (2499 * quantity);
						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							Rum();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					} 
					else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						Rum();
					} else
					{
						System.err.println("Please choose correct option");
						Rum();
					}
				}
				break;
			case 3:
				System.out.println("Price of Bacardi is Rs 1199");
				System.out.println("Enter the quantity:");
				quantity = sc.nextInt();
				if (quantity == 0)
				{
					System.err.println("Quantity can not be Zero...");
					Rum();
				} else 
				{
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') {
						System.out.println("Order has been confirmed");
						food.add("Item ::Bacardi && Price::1199 ");
						food.add("Quantity :" + quantity);
						totalBill = totalBill + (1199 * quantity);
						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							Rum();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					}
					else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						Rum();
					} 
					else 
					{
						System.err.println("Please choose correct option");
						Rum();
					}
				}
				break;
				
			case 4:
				menu();
			default:
				System.err.print("Please Try Again !!!......");
				Drinks_Menu();

			}


			
		
		}
			catch(Exception e)
			{
			System.err.print("Please Try Again !!!......");
				Drinks_Menu();
			}
		
	}
	
	
	public void vodka()
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			
			
			System.out.println("Press 1 for Belvedere:");

			System.out.println("Press 2 for Finlandia:");
			
			System.out.println("Press 3 for Smirnoff:");

			System.out.println("Press 4 to go Back");

			int n = sc.nextInt();
			switch (n) {
			case 1:

				System.out.println("Price of Belvedere is Rs 2050");
				System.out.println("Enter the quantity:");
				quantity = sc.nextInt();

				if (quantity == 0)
				{
					System.out.println("Quantity can not be Zero...");
					vodka();
				} 
				else 
				{

					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') 
					{
						System.out.println("Order has been confirmed");
						food.add("Item ::Belvedere && Price::2050 ");
						totalBill = totalBill + (2050 * quantity);
						food.add("Quantity :" + quantity);

						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							vodka();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					} else if (ch == 'n' || ch == 'N') 
					{
						System.out.println("Choose another item");
						vodka();
					} else 
					{
						System.err.println("Please choose correct option");
						vodka();
					}
				}
				break;
			case 2:
				System.out.println("Price of Finlandia  is Rs  2499");
				System.out.println("Enter the quantity:");
				quantity = sc.nextInt();
				if (quantity == 0)
				{
					System.err.println("Quantity can not be Zero...");
					vodka();
					
				} else 
				{
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') 
					{
						System.out.println("Order has been confirmed");
						food.add("Item ::Finlandia && Price:: 2499 ");
						food.add("Quantity :" + quantity);

						totalBill = totalBill + (2499 * quantity);
						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							vodka();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					} 
					else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						vodka();
					} else
					{
						System.err.println("Please choose correct option");
						vodka();
					}
				}
				break;
			case 3:
				System.out.println("Price of Smirnoff is Rs 1199");
				System.out.println("Enter the quantity:");
				quantity = sc.nextInt();
				if (quantity == 0)
				{
					System.err.println("Quantity can not be Zero...");
					vodka();
				} else 
				{
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') {
						System.out.println("Order has been confirmed");
						food.add("Item ::Smirnoff && Price::1199 ");
						food.add("Quantity :" + quantity);
						totalBill = totalBill + (1299 * quantity);
						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							vodka();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					}
					else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						vodka();
					} 
					else 
					{
						System.err.println("Please choose correct option");
						vodka();
					}
				}
				break;
				
			case 4:
				menu();
			default:
				System.err.print("Please Try Again !!!......");
				Drinks_Menu();

			}


			
		
		}
			catch(Exception e)
			{
			System.err.print("Please Try Again !!!......");
				Drinks_Menu();
			}
		
	}
	

		

	
}


class Desserts extends Menu {
	public void DessertsMenu() {
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("press 1 for sweets");
		System.out.println("Press 2 for Ice Cream :");

		System.out.println("Press 3 to go Back");

		int x = sc.nextInt();
		switch (x) {
		case 1:
			sweets  s = new sweets ();
			s.sweets();
			
			break;
		case 2:
			icecream ic = new icecream();
			ic.icecream_menu();
			break;
		case 3:
			menu();
		default:
			System.err.print("Please Try Again !!!......");
			DessertsMenu();

		}


		}
		catch(Exception e)
		{
			System.err.print("Please Try Again !!!......");
			DessertsMenu();
		}
	}
	
	
}
class sweets extends Desserts{
	public void sweets() {
		try
		{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Rasgulla :");
		System.out.println("Press 2 for Jalebi :");
		System.out.println("Press 3 for Barfi :");
		System.out.println("Press 4 for Kheer :");
		System.out.println("Press 5 for Ladoo :");
		System.out.println("Press 6 for Halwa :");
		System.out.println("Press 7 to go Back");
		
		
		
		int n = sc.nextInt();
		switch (n) {
		case 1:

			System.out.println("Price of Rasgulla is Rs 250");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();

			if (quantity == 0)
			{
				System.out.println("Quantity can not be Zero...");
				sweets();
			} 
			else 
			{

				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') 
				{
					System.out.println("Order has been confirmed");
					food.add("Item ::Rasgulla  && Price::250 ");
					totalBill = totalBill + (250 * quantity);
					food.add("Quantity :" + quantity);

					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						sweets();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') 
				{
					System.out.println("Choose another item");
					sweets();
				} else 
				{
					System.err.println("Please choose correct option");
					sweets();
				}
			}
			break;
		case 2:
			System.out.println("Price of Jalebi is Rs  100");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				sweets();
				
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') 
				{
					System.out.println("Order has been confirmed");
					food.add("Item ::Jalebi && Price:: 100 ");
					food.add("Quantity :" + quantity);

					totalBill = totalBill + (100 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						sweets();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} 
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					sweets();
				} else
				{
					System.err.println("Please choose correct option");
					sweets();
				}
			}
			break;
		case 3:
			System.out.println("Price of Barfi  is Rs  300");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				sweets();
				
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') 
				{
					System.out.println("Order has been confirmed");
					food.add("Item :: Barfi && Price:: 300 ");
					food.add("Quantity :" + quantity);

					totalBill = totalBill + (300 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						sweets();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} 
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					sweets();
				} else
				{
					System.err.println("Please choose correct option");
					sweets();
				}
			}
			break;
		case 4:
			System.out.println("Price of Kheer is Rs 200");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				sweets();
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Kheer && Price::200 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (200 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						sweets();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				}
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					sweets();
				} 
				else 
				{
					System.err.println("Please choose correct option");
					sweets();
				}
			}
			break;
		case 5:
			System.out.println("Price of Ladoo is Rs 250");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				sweets();
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Ladoo && Price::250 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (250 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						sweets();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				}
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					sweets();
				} 
				else 
				{
					System.err.println("Please choose correct option");
					sweets();
				}
			}
			break;
		case 6:
			System.out.println("Price of Halwa is Rs 299");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				sweets();
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Halwa && Price::299 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (299 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						sweets();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				}
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					sweets();
				} 
				else 
				{
					System.err.println("Please choose correct option");
					sweets();
				}
			}
			break;
		
			
		case 7:
			menu();
		default:
			System.err.print("Please Try Again !!!......");
			DessertsMenu();

		}

		
		
		
	}
	catch(Exception e)
		{
			System.err.print("Please Try Again !!!......");
			sweets();
		}
	}
	
	
}
class icecream extends Desserts{
	public void icecream_menu()
	{
		try
		{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Vanilla - Ice Cream :");
		System.out.println("Press 2 for Chocolate - Ice Cream :");
		System.out.println("Press 3 for Mango- Ice Cream :");
		System.out.println("Press 4 for Butterscotch- Ice Cream :");
		System.out.println("Press 5 for Strawberry - Ice Cream :");
		System.out.println("Press 6 for Pista (Pistachio) - Ice Cream:");
		System.out.println("Press 7 to go Back");
		
		
		
		int n = sc.nextInt();
		switch (n) {
		case 1:

			System.out.println("Price of Vanilla - Ice Cream is Rs 250");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();

			if (quantity == 0)
			{
				System.out.println("Quantity can not be Zero...");
				icecream_menu();
			} 
			else 
			{

				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') 
				{
					System.out.println("Order has been confirmed");
					food.add("Item ::Rasgulla  && Price::250 ");
					totalBill = totalBill + (250 * quantity);
					food.add("Quantity :" + quantity);

					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						icecream_menu();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') 
				{
					System.out.println("Choose another item");
					icecream_menu();
				} else 
				{
					System.err.println("Please choose correct option");
					icecream_menu();
				}
			}
			break;
		case 2:
			System.out.println("Price of Chocolate - Ice Cream is Rs  100");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				icecream_menu();
				
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') 
				{
					System.out.println("Order has been confirmed");
					food.add("Item ::Jalebi && Price:: 100 ");
					food.add("Quantity :" + quantity);

					totalBill = totalBill + (100 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						icecream_menu();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} 
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					icecream_menu();
				} else
				{
					System.err.println("Please choose correct option");
					icecream_menu();
				}
			}
			break;
		case 3:
			System.out.println("Price of Mango- Ice Cream  is Rs  300");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				icecream_menu();
				
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') 
				{
					System.out.println("Order has been confirmed");
					food.add("Item :: Barfi && Price:: 300 ");
					food.add("Quantity :" + quantity);

					totalBill = totalBill + (300 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						icecream_menu();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} 
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					icecream_menu();
				} else
				{
					System.err.println("Please choose correct option");
					icecream_menu();
				}
			}
			break;
		case 4:
			System.out.println("Price of Butterscotch- Ice Cream is Rs 200");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				icecream_menu();
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Kheer && Price::200 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (200 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						icecream_menu();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				}
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					icecream_menu();
				} 
				else 
				{
					System.err.println("Please choose correct option");
					icecream_menu();
				}
			}
			break;
		case 5:
			System.out.println("Price of Strawberry - Ice Cream is Rs 250");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				icecream_menu();
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Ladoo && Price::250 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (250 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						icecream_menu();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				}
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					icecream_menu();
				} 
				else 
				{
					System.err.println("Please choose correct option");
					icecream_menu();
				}
			}
			break;
		case 6:
			System.out.println("Price of Pista (Pistachio) - Ice Cream is Rs 299");
			System.out.println("Enter the quantity:");
			quantity = sc.nextInt();
			if (quantity == 0)
			{
				System.err.println("Quantity can not be Zero...");
				icecream_menu();
			} else 
			{
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					food.add("Item ::Halwa && Price::299 ");
					food.add("Quantity :" + quantity);
					totalBill = totalBill + (299 * quantity);
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						icecream_menu();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				}
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					icecream_menu();
				} 
				else 
				{
					System.err.println("Please choose correct option");
					icecream_menu();
				}
			}
			break;
		
			
		case 7:
			menu();
		default:
			System.err.print("Please Try Again !!!......");
			DessertsMenu();

		}

		
		
		
	}
	catch(Exception e)
		{
			System.err.print("Please Try Again !!!......");
			icecream_menu();
		}
		
	}

	
}
class SpecialThali extends Menu{
	public void specialThali_menu()
	{
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Press 1 for Veg special Thali :");

			System.out.println("Press 2 for Non Veg special Thali :");

			System.out.println("Press 3 to go Back");

			int x = sc.nextInt();
			switch (x) {
			case 1:
				vegSpecialThali vst = new vegSpecialThali();
				vst.vegSpecialThali_men();
				
				break;
			case 2:
				nonvegSpecialThali nvst = new nonvegSpecialThali();
				nvst.nonvegSpecialThali_men();
				
				break;
			case 3:
				menu();
			default:
				System.err.print("Please Try Again !!!......");

			}
		}
			catch(Exception e)
			{
				System.err.print("Please Try Again !!!......");
				specialThali_menu();
			}
		}
	
}
class vegSpecialThali extends SpecialThali{
	public void vegSpecialThali_men()
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			
			
			System.out.println("Press 1 for Kathiawadi Thali:");

			System.out.println("Press 2 for Kerala Thali:");
			
			System.out.println("Press 3 for Rajasthani Thali: ");
			
			System.out.println("Press 4 for Maharashtrian Thali: ");
			
			System.out.println("Press 5 for Bengali Thali: ");
			
			System.out.println("Press 6 for Kashmiri Thali: ");
		

			System.out.println("Press 7 to go Back");

			int n = sc.nextInt();
			switch (n) {
			case 1:

				System.out.println("Price of Kathiawadi Thali is Rs 1500");
				System.out.println("About: Kathiawadi thali is a very delicious vegetarian platter that hails from Kathiawar which is a peninsula in Gujarat.");
				System.out.println("       Contrary to popular belief, this thali "); 
				System.out.println("       isn’t sweet, rather spicy along with a tinge of sweetness."); 
				
				System.out.println("Enter the quantity:");
				quantity = sc.nextInt();

				if (quantity == 0)
				{
					System.out.println("Quantity can not be Zero...");
					vegSpecialThali_men();
				} 
				else 
				{

					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') 
					{
						System.out.println("Order has been confirmed");
						food.add("Item ::Kathiawadi Thali && Price::1500 ");
						totalBill = totalBill + (1500 * quantity);
						food.add("Quantity :" + quantity);

						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							vegSpecialThali_men();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					} else if (ch == 'n' || ch == 'N') 
					{
						System.out.println("Choose another item");
						vegSpecialThali_men();
					} else 
					{
						System.err.println("Please choose correct option");
						vegSpecialThali_men();
					}
				}
				break;
			case 2:
				System.out.println("Price of Kerala Thali Rs  999");
				
				System.out.println("About:A Kerala Thali is served on a banana leaf. ");
				System.out.println("      The dishes are generously made with coconut oil, coconut milk, rice, and curry leaves. ");
			    System.out.println( "     sambar, thoran, pickle, pachadi, rasam, papadum, and olan.");
				
				
				System.out.println("Enter the quantity:");
				quantity = sc.nextInt();
				if (quantity == 0)
				{
					System.err.println("Quantity can not be Zero...");
					vegSpecialThali_men();		
					
				} else 
				{
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') 
					{
						System.out.println("Order has been confirmed");
						food.add("Item ::Kerala Thali && Price:: 999 ");
						food.add("Quantity :" + quantity);

						totalBill = totalBill + (999 * quantity);
						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							vegSpecialThali_men();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					} 
					else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						vegSpecialThali_men();
					} else
					{
						System.err.println("Please choose correct option");
						vegSpecialThali_men();
					}
				}
				break;
			case 3:
				System.out.println("Price of Rajasthani Thali is Rs 1299");
				
				System.out.println("About: Rajasthan is all about its spices, royalty, and culture. ");
				System.out.println("       These aspects are reflected in the Rajasthani Thali. ");
				System.out.println("       Made with lots of ghee, Rajasthani Thali includes dal baati churma, rotis of bajra, ");
				System.out.println("       makka, jowar, or missi roti, panchmela dal, ker sangria, boondi chaas, pulao, and papad. ");
				
				System.out.println("Enter the quantity:");
				quantity = sc.nextInt();
				if (quantity == 0)
				{
					System.err.println("Quantity can not be Zero...");
					vegSpecialThali_men();
				} else 
				{
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') {
						System.out.println("Order has been confirmed");
						food.add("Item ::Rajasthani Thali && Price::1299 ");
						food.add("Quantity :" + quantity);
						totalBill = totalBill + (1299 * quantity);
						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							vegSpecialThali_men();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					}
					else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						vegSpecialThali_men();
					} 
					else 
					{
						System.err.println("Please choose correct option");
						vegSpecialThali_men();
					}
				}
				break;
				
			case 4:
				System.out.println("Price of Maharashtrian Thali is Rs 1899");
				
				System.out.println("About: The thali is rich in spices and tastes extremely delicious.");
				System.out.println("       It consists of kothimbir vadi, bhakri roti, pitla, bhajis, like vangyache bharit, batatyachi bhaji, ");
				System.out.println("       or matkichi bhaji, amti, mutton kolhapuri, andhra rassa, and kosimbir.");
				
				System.out.println("Enter the quantity:");
				quantity = sc.nextInt();
				if (quantity == 0)
				{
					System.err.println("Quantity can not be Zero...");
					vegSpecialThali_men();
				} else 
				{
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') {
						System.out.println("Order has been confirmed");
						food.add("Item ::Maharashtrian Thali && Price::1899 ");
						food.add("Quantity :" + quantity);
						totalBill = totalBill + (1899 * quantity);
						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							vegSpecialThali_men();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					}
					else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						vegSpecialThali_men();
					} 
					else 
					{
						System.err.println("Please choose correct option");
						vegSpecialThali_men();
					}
				}
				break;
				
			case 5:
				System.out.println("Price of Bengali Thali  is Rs 999");
				
				System.out.println("About: As soon as you hear about Bengali Thali, you know there’s going to be fish and rice. ");
				System.out.println( "      Bengali thali has a combination of spicy and subtle dishes. It balances out all the flavors. ");
				
				System.out.println("Enter the quantity:");
				quantity = sc.nextInt();
				if (quantity == 0)
				{
					System.err.println("Quantity can not be Zero...");
					vegSpecialThali_men();
				} else 
				{
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') {
						System.out.println("Order has been confirmed");
						food.add("Item ::Bengali Thali && Price::999 ");
						food.add("Quantity :" + quantity);
						totalBill = totalBill + (999 * quantity);
						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							vegSpecialThali_men();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					}
					else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						vegSpecialThali_men();
					} 
					else 
					{
						System.err.println("Please choose correct option");
						vegSpecialThali_men();
					}
				}
				break;
				
			case 6:
				System.out.println("Price of Kashmiri Thali is Rs 1299");
				
				System.out.println("About: A Kashmiri thali includes Yakhni, Kashmiri dum aloo, kebabs, rogan josh, Kashmiri pulao, ");
				System.out.println("       and khatte baingan (saucy aubergine).");
				System.out.println("       The meal also has salad, yoghurt, and pickle to accompany the dishes.");
				
				System.out.println("Enter the quantity:");
				quantity = sc.nextInt();
				if (quantity == 0)
				{
					System.err.println("Quantity can not be Zero...");
					vegSpecialThali_men();
				} else 
				{
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') {
						System.out.println("Order has been confirmed");
						food.add("Item ::Kashmiri Thali && Price::1299 ");
						food.add("Quantity :" + quantity);
						totalBill = totalBill + (1299 * quantity);
						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							vegSpecialThali_men();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					}
					else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						vegSpecialThali_men();
					} 
					else 
					{
						System.err.println("Please choose correct option");
						vegSpecialThali_men();
					}
				}
				break;
				
				
			case 7:
				menu();
			default:
				System.err.print("Please Try Again !!!......");
				vegSpecialThali_men();

			}


			
		
		}
			catch(Exception e)
			{
			System.err.print("Please Try Again !!!......");
			vegSpecialThali_men();
			}
		
	}
	}




class nonvegSpecialThali extends SpecialThali{
	public void nonvegSpecialThali_men()
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			
			
			System.out.println("Press 1 for Mutton Thali:");

			System.out.println("Press 2 for Chicken Thali:");
			
			System.out.println("Press 3 for Chicken Chienese Thali: ");
			
			System.out.println("Press 4 for Mutton Briyani Thali: ");
			
			System.out.println("Press 5 to go Back");

			int n = sc.nextInt();
			switch (n) {
			case 1:

				System.out.println("Price of Mutton Thali is Rs 1700");
				
				System.out.println("Enter the quantity:");
				quantity = sc.nextInt();

				if (quantity == 0)
				{
					System.out.println("Quantity can not be Zero...");
					nonvegSpecialThali_men();
				} 
				else 
				{

					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') 
					{
						System.out.println("Order has been confirmed");
						food.add("Item ::Mutton Thali && Price::1700 ");
						totalBill = totalBill + (1700 * quantity);
						food.add("Quantity :" + quantity);

						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							nonvegSpecialThali_men();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					} else if (ch == 'n' || ch == 'N') 
					{
						System.out.println("Choose another item");
						nonvegSpecialThali_men();
					} else 
					{
						System.err.println("Please choose correct option");
						nonvegSpecialThali_men();
					}
				}
				break;
			case 2:
				System.out.println("Price of Chicken Thali Rs  999");
	
				
				System.out.println("Enter the quantity:");
				quantity = sc.nextInt();
				if (quantity == 0)
				{
					System.err.println("Quantity can not be Zero...");
					nonvegSpecialThali_men();
					
				} else 
				{
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') 
					{
						System.out.println("Order has been confirmed");
						food.add("Item ::Chicken Thali && Price:: 999 ");
						food.add("Quantity :" + quantity);

						totalBill = totalBill + (999 * quantity);
						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							nonvegSpecialThali_men();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					} 
					else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						nonvegSpecialThali_men();
					} else
					{
						System.err.println("Please choose correct option");
						nonvegSpecialThali_men();
					}
				}
				break;
			case 3:
				System.out.println("Price of Chicken Chienese Thali is Rs 1599");
				
				
				
				System.out.println("Enter the quantity:");
				quantity = sc.nextInt();
				if (quantity == 0)
				{
					System.err.println("Quantity can not be Zero...");
					nonvegSpecialThali_men();
				} else 
				{
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') {
						System.out.println("Order has been confirmed");
						food.add("Item ::Chicken Chienese Thali  && Price::1599 ");
						food.add("Quantity :" + quantity);
						totalBill = totalBill + (1599 * quantity);
						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							nonvegSpecialThali_men();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					}
					else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						nonvegSpecialThali_men();
					} 
					else 
					{
						System.err.println("Please choose correct option");
						nonvegSpecialThali_men();
					}
				}
				break;
				
			case 4:
				System.out.println("Price of Mutton Briyani Thali is Rs 1899");
				
				
				System.out.println("Enter the quantity:");
				quantity = sc.nextInt();
				if (quantity == 0)
				{
					System.err.println("Quantity can not be Zero...");
					nonvegSpecialThali_men();
				} else 
				{
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') {
						System.out.println("Order has been confirmed");
						food.add("Item ::Mutton Briyani Thali && Price::1899 ");
						food.add("Quantity :" + quantity);
						totalBill = totalBill + (1899 * quantity);
						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							nonvegSpecialThali_men();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					}
					else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						nonvegSpecialThali_men();
					} 
					else 
					{
						System.err.println("Please choose correct option");
						nonvegSpecialThali_men();
					}
				}
				break;
				
			
				
				
			case 5:
				menu();
			default:
				System.err.print("Please Try Again !!!......");
				nonvegSpecialThali_men();

			}


			
		
		}
			catch(Exception e)
			{
			System.err.print("Please Try Again !!!......");
			nonvegSpecialThali_men();
			}
		
	}
	}




		
	

public class Driver {

	static {

		System.out.println(" ----------------------------");
		System.out.println("|       * Fodd  Corner *     |");
		System.out.println("|    Eat                     |");
		System.out.println("|         THink              |");
		System.out.println("|                 Grow       |");
		System.out.println(" ----------------------------");

	}

	public static void main(String[] args)
	{
		try
		{

			Scanner sc = new Scanner(System.in);
			System.out.println(" ----------------------------");
			System.out.println("| Press Enter 1 for Signup   |");
			System.out.println("| Press Enter 2 for Login    |");
			System.out.println("| Press 3 For exit           |");
			System.out.println("");
			System.out.println("Enter Your Input: ");
			int x = sc.nextInt();
			Menu m = new Menu();
			switch (x) 
			{
			case 1:
				m.signup();
				break;
			case 2:
				System.err.println("Machha First Register....");
				m.signup();
				break;
			case 3:
				System.err.println("Thank You For Visiting ..");
				System.exit(0);
			default:
				System.err.println("Invalid Input!! Please Try Again");
				main(null);

			}
			m.menu();
			m.payement();

		} 
		catch (Exception e)
		{
			System.err.println("Invalid Input!! Please Try Again");
			main(null);

		}

	}

}
