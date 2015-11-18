import java.util.Scanner;
import java.io.*;
public class UserInterface{
	private int currentPage;
	private User loggedin;
	private ShoppingCart usercart;
	//^ the page number (P1..P10)
	public int getCurrentPage(int toPage){
		if(toPage == 1){
			Scanner input = new Scanner(System.in);
			int choice = 0;
			while(choice != 1 && choice != 2){
				choice = 0;
				System.out.println("1.Sign in");
				System.out.println("2.Sign up");
				try{
				choice = Integer.parseInt(input.next());
				}
				catch(NumberFormatException e){
					System.out.println("Invalid Input");
				}
			}
			if(choice == 1){
				System.out.println("Please enter your username");
				String name = input.next();
				try{
				BufferedReader names = new BufferedReader(new InputStreamReader(new FileInputStream("Users.txt")));
				String check = null;
				check = names.readLine();
				System.out.println(check);
				boolean next = true;
				while(next == true){
				if(name.equals(check)){
					names.close();
					loggedin = new User(name);
					usercart = new ShoppingCart(name);
					return(3);
					}
				else if(check == null){
					next = false;
					names.close();
					return(4);
				}
				check = (names.readLine());
				}
				}
				catch(FileNotFoundException e){
					System.out.println("Users.txt file not found");
				}
				catch(IOException e){
					
				}
			}
			else if(choice == 2){
				return(2);
			}
		}
		else if (toPage == 2){
			Scanner input = new Scanner(System.in);
			System.out.println("Please Choose your username");
			String name = input.next();
			try{
			BufferedReader names = new BufferedReader(new InputStreamReader(new FileInputStream("Users.txt")));
			String check = null;
			check = names.readLine();
			boolean next = true;
			while(next == true){
			if(name.equals(check)){
				names.close();
				System.out.println("Username already in use. Returning to Sign in/Sign Up selection Page");
				}
			else if(check == null){
				next = false;
				names.close();
				BufferedWriter writer = new BufferedWriter(new FileWriter("Users.txt",true));
				writer.newLine();
				writer.append(name);
				writer.close();
			}
			check = (names.readLine());
			}
			return(1);
			}
			catch(FileNotFoundException e){
				System.out.println("Users.txt file not found");
			}
			catch(IOException e){
				
			}
		}
		else if(toPage == 3){//getting an error here
			System.out.println("Welcome " + loggedin.getUsername());
			return(5);
		}
		else if(toPage == 4){
			System.out.println("Access Denied");
			return(1);
		}
		else if(toPage == 5){
			Scanner input = new Scanner(System.in);
			System.out.println("Main Menu");
			int choice = 0;
			while(choice != 1 && choice != 2 && choice != 3){
				choice = 0;
				System.out.println("1.Browse Store By Category");
				System.out.println("2.View Cart");
				System.out.println("3.Return to Sign In");
				try{
					choice = Integer.parseInt(input.next());
				}
				catch(NumberFormatException e){
					System.out.println("Invalid Input");
				}
			}
			input.close();
			if(choice == 1){
				return(6);
			}
			else if(choice == 2){
				return(7);
			}
			else if(choice == 3){
				return(1);
			}
		}
		else if(toPage == 6){
			Scanner input = new Scanner(System.in);
			int choice = 0;
			while(choice != -1 && choice != 1 && choice != 2){
				System.out.println("1.Readables");
				System.out.println("2.Audio");
				System.out.println("Please enter your selection or enter -1 to return to the last menu");
				try{
					choice = Integer.parseInt(input.next());
				}
				catch(NumberFormatException e){
					System.out.println("Invalid Input");
				}
			}
			input.close();
			if(choice == 1){
				return(8);
			}
			else if(choice == 2){
				return(9);
			}
			else if(choice == -1){
				return(5);
			}
		}
		else if(toPage == 7){
			System.out.println("Shopping Cart");
		}
		else if(toPage == 8){
			System.out.println("Readable Materials");
			System.out.println("S.No  Name of the Book  Author  Price($)  Quantity in Store  Type");
			//
		}
		else if(toPage == 9){
			System.out.println("Audio Materials");
			System.out.println("S.No  Name           Artist  Price($)  Quantity in Store  Type");
			//
		}
		else if(toPage == 10){
			System.out.println("Checkout");
		}
		return 0;
	}
	public int changeCurrentPage(int selection){
		this.currentPage = selection;
		return currentPage;
	}

}
